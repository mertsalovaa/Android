using FluentValidation;
using Nursery.Application.Validators;
using System;
using System.Collections.Generic;
using System.Text;

namespace Nursery.Application.Animal
{
	public class AnimalValidation : AbstractValidator<AnimalCommand>
	{
		public AnimalValidation()
		{
			RuleFor(x => x.Name).NotEmpty()
				.WithMessage("Поле не можу бути пустим");
			RuleFor(x => x.Age).NotEmpty()
				.WithMessage("Поле не можу бути пустим");
		}
	}
}
