1、登录功能是否一定要启用Cookie？
   主要京东大量静态网页，url重写工作量太大，性能比较低，所以要求客户端必须启用Cookie
2、浏览器没有禁用Cookie，为什么服务端每次都返回新的Cookie？
3、Cookie是由谁放入到response里的？
   Cookie通过在客户端记录信息确定用户身份，Session通过在服务器端记录信息确定用户身份。
   tomcat的context.xml可以禁止Cookie,服务器不会自动维护名为JSESSIONID的Cookie了，但是程序中仍然可以读写其他的Cookie。
4、Cookie的加密、解密？
5、response.encodeURL("return.jsp");
   tomcat判断客户端浏览器是否支持Cookie的依据是请求中是否含有Cookie。
   会自动判断客户端是否支持Cookie。如果客户端支持Cookie，会将URL原封不动地输出来。
   如果客户端不支持Cookie，则会将用户Session的id重写到URL中
6、response里的编码是对http响应的编码，jsp页面的编码是告诉浏览器按照该编码方式解析，所以二者需要保持一致！
7、request如何获取ServletConfig？
   ServletConfig config = this.getServletConfig();  //拿到init方法中的ServletConfig对象
8、web.xml中配置项的加载顺序是context-param=>listener=>filter=>servlet,
   配置项的顺序并不会改变加载顺序，但是同类型的配置项会应该加载顺序，servlet中也可以通过load-on-startup来指定加载顺序