package uk.co.keithsjohnson.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.co.keithsjohnson.entity.Build;
import uk.co.keithsjohnson.entity.Build2;

@Controller
public class BuildController {

	@RequestMapping("/build")
	public @ResponseBody
	Build build(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		return new Build(name);
	}

	@RequestMapping("/build2")
	public @ResponseBody
	Collection<Build2> build2(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		Collection<Build2> collection = new ArrayList<Build2>(2);
		collection.add(new Build2(name + 1));
		collection.add(new Build2(name + 2));
		return collection;
	}
}