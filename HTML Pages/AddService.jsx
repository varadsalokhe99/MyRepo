

export default function addService(){


    return(

      
  <div>
    
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Add Services</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          
         
        </div>
      </div>
    </nav>
  
  

  <main class="flex-shrink-0">
    <div class="container">
      <h1 class="mt-5"></h1>
      <p class="lead"><code class="small"></code> <code class="small"></code></p>
      <p><a href="/docs/5.3/examples/sticky-footer/"></a> </p>
    </div>
  </main>
  
  <div class="col-md-7 col-lg-8">
        
        <form class="needs-validation" novalidate="">
          <div class="row g-3">
            <div class="col-sm-6">
              <label for="servicename" class="form-label">Service name</label>
              
              <input type="text" class="form-control" id="servicename" placeholder="Enter Service Name" value={user.sname.value}
               />
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
      </div>
      </div>
      </form>

      <form class="needs-validation" novalidate="">
          <div class="row g-3">
            <div class="col-sm-6">
              <label for="servicename" class="form-label">Service Description</label>
              
              <input type="text" class="form-control" id="servicename" placeholder="Enter Service Description" value={user.description.value}
                />
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
      </div>
      </div>
      </form>

      <form class="needs-validation" novalidate="">
          <div class="row g-3">
            <div class="col-sm-6">
              <label for="price" class="form-label">Add Price</label>
              
              <input type="text" class="form-control" id="price" placeholder="Enter price $" value={user.price.value}
               />
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
      </div>
      </div>
      </form>
  <script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</div>
  </div>
    )
}