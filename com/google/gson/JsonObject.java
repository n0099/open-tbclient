package com.google.gson;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public final class JsonObject extends JsonElement {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedTreeMap<String, JsonElement> members;

    public JsonObject() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.members = new LinkedTreeMap<>();
    }

    public Set<Map.Entry<String, JsonElement>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.members.entrySet();
        }
        return (Set) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.members.hashCode();
        }
        return invokeV.intValue;
    }

    public Set<String> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.members.keySet();
        }
        return (Set) invokeV.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.members.size();
        }
        return invokeV.intValue;
    }

    private JsonElement createJsonElement(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, obj)) == null) {
            if (obj == null) {
                return JsonNull.INSTANCE;
            }
            return new JsonPrimitive(obj);
        }
        return (JsonElement) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj != this && (!(obj instanceof JsonObject) || !((JsonObject) obj).members.equals(this.members))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public JsonElement get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return this.members.get(str);
        }
        return (JsonElement) invokeL.objValue;
    }

    public JsonArray getAsJsonArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            return (JsonArray) this.members.get(str);
        }
        return (JsonArray) invokeL.objValue;
    }

    public JsonObject getAsJsonObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            return (JsonObject) this.members.get(str);
        }
        return (JsonObject) invokeL.objValue;
    }

    public JsonPrimitive getAsJsonPrimitive(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            return (JsonPrimitive) this.members.get(str);
        }
        return (JsonPrimitive) invokeL.objValue;
    }

    public boolean has(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            return this.members.containsKey(str);
        }
        return invokeL.booleanValue;
    }

    public JsonElement remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            return this.members.remove(str);
        }
        return (JsonElement) invokeL.objValue;
    }

    public void add(String str, JsonElement jsonElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jsonElement) == null) {
            if (jsonElement == null) {
                jsonElement = JsonNull.INSTANCE;
            }
            this.members.put(str, jsonElement);
        }
    }

    public void addProperty(String str, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bool) == null) {
            add(str, createJsonElement(bool));
        }
    }

    public void addProperty(String str, Character ch) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ch) == null) {
            add(str, createJsonElement(ch));
        }
    }

    public void addProperty(String str, Number number) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, number) == null) {
            add(str, createJsonElement(number));
        }
    }

    public void addProperty(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            add(str, createJsonElement(str2));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.JsonElement
    public JsonObject deepCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JsonObject jsonObject = new JsonObject();
            for (Map.Entry<String, JsonElement> entry : this.members.entrySet()) {
                jsonObject.add(entry.getKey(), entry.getValue().deepCopy());
            }
            return jsonObject;
        }
        return (JsonObject) invokeV.objValue;
    }
}
