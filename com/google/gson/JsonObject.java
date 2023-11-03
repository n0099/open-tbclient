package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public final class JsonObject extends JsonElement {
    public final LinkedTreeMap<String, JsonElement> members = new LinkedTreeMap<>();

    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.members.entrySet();
    }

    public int hashCode() {
        return this.members.hashCode();
    }

    public Set<String> keySet() {
        return this.members.keySet();
    }

    public int size() {
        return this.members.size();
    }

    public void add(String str, JsonElement jsonElement) {
        LinkedTreeMap<String, JsonElement> linkedTreeMap = this.members;
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        linkedTreeMap.put(str, jsonElement);
    }

    public void addProperty(String str, Boolean bool) {
        JsonElement jsonPrimitive;
        if (bool == null) {
            jsonPrimitive = JsonNull.INSTANCE;
        } else {
            jsonPrimitive = new JsonPrimitive(bool);
        }
        add(str, jsonPrimitive);
    }

    public void addProperty(String str, Character ch) {
        JsonElement jsonPrimitive;
        if (ch == null) {
            jsonPrimitive = JsonNull.INSTANCE;
        } else {
            jsonPrimitive = new JsonPrimitive(ch);
        }
        add(str, jsonPrimitive);
    }

    public void addProperty(String str, Number number) {
        JsonElement jsonPrimitive;
        if (number == null) {
            jsonPrimitive = JsonNull.INSTANCE;
        } else {
            jsonPrimitive = new JsonPrimitive(number);
        }
        add(str, jsonPrimitive);
    }

    public void addProperty(String str, String str2) {
        JsonElement jsonPrimitive;
        if (str2 == null) {
            jsonPrimitive = JsonNull.INSTANCE;
        } else {
            jsonPrimitive = new JsonPrimitive(str2);
        }
        add(str, jsonPrimitive);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.JsonElement
    public JsonObject deepCopy() {
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<String, JsonElement> entry : this.members.entrySet()) {
            jsonObject.add(entry.getKey(), entry.getValue().deepCopy());
        }
        return jsonObject;
    }

    public boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof JsonObject) || !((JsonObject) obj).members.equals(this.members))) {
            return false;
        }
        return true;
    }

    public JsonElement get(String str) {
        return this.members.get(str);
    }

    public JsonArray getAsJsonArray(String str) {
        return (JsonArray) this.members.get(str);
    }

    public JsonObject getAsJsonObject(String str) {
        return (JsonObject) this.members.get(str);
    }

    public JsonPrimitive getAsJsonPrimitive(String str) {
        return (JsonPrimitive) this.members.get(str);
    }

    public boolean has(String str) {
        return this.members.containsKey(str);
    }

    public JsonElement remove(String str) {
        return this.members.remove(str);
    }
}
