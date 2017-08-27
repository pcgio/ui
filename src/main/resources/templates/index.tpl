yieldUnescaped '<!DOCTYPE html>'
html {
  head {
    title(title)
    meta([
      name:'viewport',
      content:'width=device-width, initial-scale=1, user-scalable=0, maximum-scale=1, minimum-scale=1'
    ]){}
    link ([rel:'icon', type:'image/png', href:'/html/favicon.ico']){}
    link([href: '//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css', rel:'stylesheet']){}
    link([href: '//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap-theme.min.css', rel:'stylesheet']){}
  }
  body {
    div([
        'class': 'container'
    ]){
        div(['class': 'row']){
            div(["class":"text-center"]){
                h1 "Procedural Content Generation for Short Video"
            }
        }
        include template: 'genForm.tpl'
    }
    include unescaped: 'trackingCode.html'
  }
}
