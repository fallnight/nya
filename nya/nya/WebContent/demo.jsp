<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>test</title>
	<!-- player skin -->
   <link rel="stylesheet" type="text/css" href="<%=basePath%>plugins/vedio/skin/minimalist.css">
 
   <!-- site specific styling -->
   <style type="text/css">
   .flowplayer { width: 100%; height:100%;}
   </style>
 
   <!-- flowplayer depends on jQuery 1.7.1+ (for now) -->
   <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
 
   <!-- include flowplayer -->
   <script type="text/javascript" src="<%=basePath%>plugins/vedio/flowplayer.min.js"></script>
</head>
<body>
<!-- the player -->
           <div class="functional main" data-ratio="0.4167" data-splash="true">
              <video>
                 <source type="video/mp4" src="<%=basePath%>plugins/vedio/aa.mp4"> 
                 <!--<source type="video/mp4" src="http://stream.flowplayer.org/functional.mp4">-->
                 <!--<source type="video/ogv" src="http://stream.flowplayer.org/bauhaus/624x260.ogv">-->
              </video>
			</div>
</body>
</html>