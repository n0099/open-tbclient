package com.google.gson;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public final class JsonArray extends JsonElement implements Iterable<JsonElement> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<JsonElement> elements;

    public JsonArray() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.elements = new ArrayList();
    }

    public void add(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
            this.elements.add(bool == null ? JsonNull.INSTANCE : new JsonPrimitive(bool));
        }
    }

    public void addAll(JsonArray jsonArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jsonArray) == null) {
            this.elements.addAll(jsonArray.elements);
        }
    }

    public boolean contains(JsonElement jsonElement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jsonElement)) == null) ? this.elements.contains(jsonElement) : invokeL.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) ? obj == this || ((obj instanceof JsonArray) && ((JsonArray) obj).elements.equals(this.elements)) : invokeL.booleanValue;
    }

    public JsonElement get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? this.elements.get(i2) : (JsonElement) invokeI.objValue;
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.elements.size() == 1) {
                return this.elements.get(0).getAsBigDecimal();
            }
            throw new IllegalStateException();
        }
        return (BigDecimal) invokeV.objValue;
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.elements.size() == 1) {
                return this.elements.get(0).getAsBigInteger();
            }
            throw new IllegalStateException();
        }
        return (BigInteger) invokeV.objValue;
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.elements.size() == 1) {
                return this.elements.get(0).getAsBoolean();
            }
            throw new IllegalStateException();
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.elements.size() == 1) {
                return this.elements.get(0).getAsByte();
            }
            throw new IllegalStateException();
        }
        return invokeV.byteValue;
    }

    @Override // com.google.gson.JsonElement
    public char getAsCharacter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.elements.size() == 1) {
                return this.elements.get(0).getAsCharacter();
            }
            throw new IllegalStateException();
        }
        return invokeV.charValue;
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.elements.size() == 1) {
                return this.elements.get(0).getAsDouble();
            }
            throw new IllegalStateException();
        }
        return invokeV.doubleValue;
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.elements.size() == 1) {
                return this.elements.get(0).getAsFloat();
            }
            throw new IllegalStateException();
        }
        return invokeV.floatValue;
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.elements.size() == 1) {
                return this.elements.get(0).getAsInt();
            }
            throw new IllegalStateException();
        }
        return invokeV.intValue;
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.elements.size() == 1) {
                return this.elements.get(0).getAsLong();
            }
            throw new IllegalStateException();
        }
        return invokeV.longValue;
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.elements.size() == 1) {
                return this.elements.get(0).getAsNumber();
            }
            throw new IllegalStateException();
        }
        return (Number) invokeV.objValue;
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.elements.size() == 1) {
                return this.elements.get(0).getAsShort();
            }
            throw new IllegalStateException();
        }
        return invokeV.shortValue;
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.elements.size() == 1) {
                return this.elements.get(0).getAsString();
            }
            throw new IllegalStateException();
        }
        return (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.elements.hashCode() : invokeV.intValue;
    }

    @Override // java.lang.Iterable
    public Iterator<JsonElement> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.elements.iterator() : (Iterator) invokeV.objValue;
    }

    public boolean remove(JsonElement jsonElement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, jsonElement)) == null) ? this.elements.remove(jsonElement) : invokeL.booleanValue;
    }

    public JsonElement set(int i2, JsonElement jsonElement) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048603, this, i2, jsonElement)) == null) ? this.elements.set(i2, jsonElement) : (JsonElement) invokeIL.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.elements.size() : invokeV.intValue;
    }

    public void add(Character ch) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ch) == null) {
            this.elements.add(ch == null ? JsonNull.INSTANCE : new JsonPrimitive(ch));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.JsonElement
    public JsonArray deepCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!this.elements.isEmpty()) {
                JsonArray jsonArray = new JsonArray(this.elements.size());
                for (JsonElement jsonElement : this.elements) {
                    jsonArray.add(jsonElement.deepCopy());
                }
                return jsonArray;
            }
            return new JsonArray();
        }
        return (JsonArray) invokeV.objValue;
    }

    public JsonElement remove(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) ? this.elements.remove(i2) : (JsonElement) invokeI.objValue;
    }

    public JsonArray(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.elements = new ArrayList(i2);
    }

    public void add(Number number) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, number) == null) {
            this.elements.add(number == null ? JsonNull.INSTANCE : new JsonPrimitive(number));
        }
    }

    public void add(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.elements.add(str == null ? JsonNull.INSTANCE : new JsonPrimitive(str));
        }
    }

    public void add(JsonElement jsonElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jsonElement) == null) {
            if (jsonElement == null) {
                jsonElement = JsonNull.INSTANCE;
            }
            this.elements.add(jsonElement);
        }
    }
}
