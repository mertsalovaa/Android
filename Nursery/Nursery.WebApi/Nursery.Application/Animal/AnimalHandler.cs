using MediatR;
using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Nursery.Application.Exceptions;
using Nursery.Application.Interfaces;
using Nursery.Domain;
using Nursery.EFData;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Nursery.Application.Animal
{
    public class AnimalHandler : IRequestHandler<AnimalCommand, AnimalViewModel>
    {
        //private readonly UserManager<AppUser> _userManager;
        //private readonly SignInManager<AppUser> _signInManager;
        //private readonly IJwtGenerator _jwtGenerator;
        private readonly IConfiguration _configuration;

        public AnimalHandler(IConfiguration configuration)
        {
            //_userManager = userManager;
            //_signInManager = signInManager;
            //_jwtGenerator = jwtGenerator;
            _configuration = configuration;
        }

        public async Task<AnimalViewModel> Handle(AnimalCommand request, CancellationToken cancellationToken)
        {
            //int count = 0;
            //string name = "Animal" + count++;
            string animalImage = request.Image ?? "no-image.png";
            string image = "/" + _configuration.GetValue<string>("Folders:URLImages") + "/" + animalImage;
            //if(user.Image)
            return new AnimalViewModel
            {
                Name = request.Name,
                Age = request.Age,
                Image = image
            };
        }
    }
}
//name.ToLower() + "@" + name.ToLower().TrimEnd(new char[] { (char)count }) + ".com",