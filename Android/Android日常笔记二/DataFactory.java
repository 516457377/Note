package com.example.bean;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class DataFactory {
	/**
	 * @param clazz
	 *            传入bean类
	 * @param json
	 *            传入json
	 * */
	public static Object getInstanceByJson(Class<?> clazz, String json) {
		Object obj = null;
		Gson gson = new Gson();
		obj = gson.fromJson(json, clazz);
		return obj;
	}

	/**
	 * @author I321533
	 * @param json
	 * @param clazz 未知
	 * @return
	 */
	public static <T> List<T> jsonToList(String json, Class<T[]> clazz) {
		Gson gson = new Gson();
		T[] array = gson.fromJson(json, clazz);
		return Arrays.asList(array);
	}

	/**
	 * @param json 传入json
	 * @param clazz 传入bean类
	 * @return
	 */
	public static <T> ArrayList<T> jsonToArrayList(String json, Class<T> clazz) {
		Type type = new TypeToken<ArrayList<JsonObject>>() {
		}.getType();
		ArrayList<JsonObject> jsonObjects = new Gson().fromJson(json, type);

		ArrayList<T> arrayList = new ArrayList<>();
		for (JsonObject jsonObject : jsonObjects) {
			arrayList.add(new Gson().fromJson(jsonObject, clazz));
		}
		return arrayList;
	}
}