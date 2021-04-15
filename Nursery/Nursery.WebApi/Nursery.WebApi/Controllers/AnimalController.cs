using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Nursery.Application.Animal;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Nursery.WebApi.Controllers
{
    public class AnimalController : BaseController
    {
        private readonly IConfiguration _configuration;

        public AnimalController(IConfiguration configuration)
        {
            _configuration = configuration;
        }

        [HttpGet]
        [Route("animals")]
        public async Task<ActionResult<List<AnimalViewModel>>> getAnimals()
        {
            List<AnimalCommand> animals = new List<AnimalCommand>();
            List<AnimalViewModel> animals1 = new List<AnimalViewModel>();
            animals.Add(new AnimalCommand { Name = "Барсік", Age = "2", Image = "dog.jpg" });
            animals.Add(new AnimalCommand { Name = "Мурзік", Age = "1", Image = "cat.jpeg" });
            foreach (var item in animals)
            {
                animals1.Add(await Mediator.Send(item));
            }
            return new ActionResult<List<AnimalViewModel>>(animals1);
        }
    }
}
