using MediatR;
using System;
using System.Collections.Generic;
using System.Text;

namespace Nursery.Application.Animal
{
	public class AnimalCommand : IRequest<AnimalViewModel>
	{
		public string Name { get; set; }

		public string Age { get; set; }

        public string Image { get; set; }
    }
}
