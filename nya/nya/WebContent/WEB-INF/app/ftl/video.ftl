<#import "spring.ftl" as s/>
<html>
<head>
<title>test</title>
<!-- 1. skin -->
<link rel="stylesheet" href="<@s.url'/plugins/index/skin/minimalist.css'/>">
<link rel="stylesheet" href="<@s.url'/plugins/index/skin/functional.css'/>">
<link rel="stylesheet" href="<@s.url'/plugins/index/skin/playful.css'/>">
 
<!-- 2. jquery library -->
<script src="<@s.url'/plugins/index/js/jquery.js'/>"></script>
 
<!-- 3. flowplayer -->
<script src="<@s.url'/plugins/index/js/flowplayer.min.js'/>"></script>
<script>
flowplayer.conf = {
   ratio: 9/16,
   splash: true,
};
</script>
</head>
<body>
<div class="flowplayer minimalist" style="background-color:#777; background-image:url(<@s.url'/plugins/index/${video.img}'/>);">
<!--<div class="flowplayer functional">  -->
   <video>
     <source type="video/mp4"  src="<@s.url'/plugins/index/video/${video.videoname}.mp4'/>">
   </video>
</div>
</body>
</html>