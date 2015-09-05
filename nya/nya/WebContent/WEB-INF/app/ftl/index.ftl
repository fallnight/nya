<#import "spring.ftl" as s/>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
		<!-- BASICS -->
        <meta charset="GBK">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Amoeba free one page responsive bootstrap site template</title>
        <meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="<@s.url'/plugins/index/css/isotope.css'/>" media="screen" />	
		<link rel="stylesheet" href="<@s.url'/plugins/index/js/fancybox/jquery.fancybox.css'/>" type="text/css" media="screen" />
		<link rel="stylesheet" href="<@s.url'/plugins/index/css/bootstrap.css'/>">
		<link rel="stylesheet" href="<@s.url'/plugins/index/css/bootstrap-theme.css'/>">
        <link rel="stylesheet" href="<@s.url'/plugins/index/css/style.css'/>">
		<!-- skin -->
		<link rel="stylesheet" href="<@s.url'/plugins/index/skin/default.css'/>">
    </head>
	 
    <body>
		<section id="header" class="appear"></section>
		<div class="navbar navbar-fixed-top" role="navigation" data-0="line-height:100px; height:100px; background-color:rgba(0,0,0,0.3);" data-300="line-height:60px; height:60px; background-color:rgba(0,0,0,1);">
			 <div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="fa fa-bars color-white"></span>
					</button>
					<h1><a class="navbar-brand" href="#" data-0="line-height:90px;" data-300="line-height:50px;">			Amoeba
					</a></h1>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav" data-0="margin-top:20px;" data-300="margin-top:5px;">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#section-about">About</a></li>
						<li><a href="#section-works">Portfolio</a></li>
						<li><a href="#section-contact">Contact</a></li>
					</ul>
				</div><!--/.navbar-collapse -->
			</div>
		</div>

		
			
		
			
		
		
		<!-- spacer section:stats -->
		<section id="parallax1" class="section pad-top40 pad-bot40" data-stellar-background-ratio="0.5">
				
		</section>
		
		<!-- section works -->
		<section id="section-works" class="section appear clearfix">
			<div class="container">
				
				
					
                        <div class="row">
                          <nav id="filter" class="col-md-12 text-center">
                            <ul>
                              <li><a href="#" class="current btn-theme btn-small" data-filter="*">All</a></li>
                              <li><a href="#"  class="btn-theme btn-small" data-filter=".webdesign" >Web Design</a></li>
                              <li><a href="#"  class="btn-theme btn-small" data-filter=".photography">Photography</a></li>
                              <li ><a href="#" class="btn-theme btn-small" data-filter=".print">Print</a></li>
                            </ul>
                          </nav>
                          <div class="col-md-12">
                            <div class="row">
                              <div class="portfolio-items isotopeWrapper clearfix" id="3">
							  
							  
							  <#list videos as v>
							  <article class="col-md-4 isotopeItem webdesign">
									<div class="portfolio-item">
										<a href="<@s.url'/video/poi${v.id}'/>" target="_blank">
											<img src="<@s.url'/plugins/index/${v.img}'/>"  alt="" />
										</a>
									</div>
									<h6 class="titlepod">${v.videoname}<h6>
                               </article>
							   </#list>
							               
                                </div>                                       
							</div>                                    
							</div>
                        </div>
				
			</div>
		</section>
		

		
		
	<section id="footer" class="section footer">
		<div class="container">
			<div class="row animated opacity mar-bot20" data-andown="fadeIn" data-animation="animation">
				<div class="col-sm-12 align-center">
                    <ul class="social-network social-circle">
                        <li><a href="#" class="icoRss" title="Rss"><i class="fa fa-rss"></i></a></li>
                        <li><a href="#" class="icoFacebook" title="Facebook"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#" class="icoTwitter" title="Twitter"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#" class="icoGoogle" title="Google +"><i class="fa fa-google-plus"></i></a></li>
                        <li><a href="#" class="icoLinkedin" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
                    </ul>				
				</div>
			</div>

			<div class="row align-center copyright">
					<div class="col-sm-12"><p>Copyright &copy; 2014 Amoeba - by <a href="http://bootstraptaste.com">Bootstraptaste</a></p></div>
			</div>
		</div>

	</section>
	<a href="#header" class="scrollup"><i class="fa fa-chevron-up"></i></a>	

	<script src="<@s.url'/plugins/index/js/modernizr-2.6.2-respond-1.1.0.min.js'/>"></script>
	<script src="<@s.url'/plugins/index/js/jquery.js'/>"></script>
	<script src="<@s.url'/plugins/index/js/jquery.easing.1.3.js'/>"></script>
    <script src="<@s.url'/plugins/index/js/bootstrap.min.js'/>"></script>
	<script src="<@s.url'/plugins/index/js/jquery.isotope.min.js'/>"></script>
	<script src="<@s.url'/plugins/index/js/jquery.nicescroll.min.js'/>"></script>
	<script src="<@s.url'/plugins/index/js/fancybox/jquery.fancybox.pack.js'/>"></script>
	<script src="<@s.url'/plugins/index/js/skrollr.min.js'/>"></script>		
	<script src="<@s.url'/plugins/index/js/jquery.scrollTo-1.4.3.1-min.js'/>"></script>
	<script src="<@s.url'/plugins/index/js/jquery.localscroll-1.2.7-min.js'/>"></script>
	<script src="<@s.url'/plugins/index/js/stellar.js'/>"></script>
	<script src="<@s.url'/plugins/index/js/jquery.appear.js'/>"></script>
	<script src="<@s.url'/plugins/index/js/validate.js'/>"></script>
    <script src="<@s.url'/plugins/index/js/main.js'/>"></script>
	</body>
</html>