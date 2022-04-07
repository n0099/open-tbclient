package com.google.gson;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
/* loaded from: classes5.dex */
public abstract class JsonElement {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public JsonElement() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract JsonElement deepCopy();

    public BigDecimal getAsBigDecimal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            throw new UnsupportedOperationException(getClass().getSimpleName());
        }
        return (BigDecimal) invokeV.objValue;
    }

    public BigInteger getAsBigInteger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            throw new UnsupportedOperationException(getClass().getSimpleName());
        }
        return (BigInteger) invokeV.objValue;
    }

    public boolean getAsBoolean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            throw new UnsupportedOperationException(getClass().getSimpleName());
        }
        return invokeV.booleanValue;
    }

    public Boolean getAsBooleanWrapper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            throw new UnsupportedOperationException(getClass().getSimpleName());
        }
        return (Boolean) invokeV.objValue;
    }

    public byte getAsByte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            throw new UnsupportedOperationException(getClass().getSimpleName());
        }
        return invokeV.byteValue;
    }

    public char getAsCharacter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            throw new UnsupportedOperationException(getClass().getSimpleName());
        }
        return invokeV.charValue;
    }

    public double getAsDouble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            throw new UnsupportedOperationException(getClass().getSimpleName());
        }
        return invokeV.doubleValue;
    }

    public float getAsFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            throw new UnsupportedOperationException(getClass().getSimpleName());
        }
        return invokeV.floatValue;
    }

    public int getAsInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            throw new UnsupportedOperationException(getClass().getSimpleName());
        }
        return invokeV.intValue;
    }

    public JsonArray getAsJsonArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (isJsonArray()) {
                return (JsonArray) this;
            }
            throw new IllegalStateException("Not a JSON Array: " + this);
        }
        return (JsonArray) invokeV.objValue;
    }

    public JsonNull getAsJsonNull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (isJsonNull()) {
                return (JsonNull) this;
            }
            throw new IllegalStateException("Not a JSON Null: " + this);
        }
        return (JsonNull) invokeV.objValue;
    }

    public JsonObject getAsJsonObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (isJsonObject()) {
                return (JsonObject) this;
            }
            throw new IllegalStateException("Not a JSON Object: " + this);
        }
        return (JsonObject) invokeV.objValue;
    }

    public JsonPrimitive getAsJsonPrimitive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (isJsonPrimitive()) {
                return (JsonPrimitive) this;
            }
            throw new IllegalStateException("Not a JSON Primitive: " + this);
        }
        return (JsonPrimitive) invokeV.objValue;
    }

    public long getAsLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            throw new UnsupportedOperationException(getClass().getSimpleName());
        }
        return invokeV.longValue;
    }

    public Number getAsNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            throw new UnsupportedOperationException(getClass().getSimpleName());
        }
        return (Number) invokeV.objValue;
    }

    public short getAsShort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            throw new UnsupportedOperationException(getClass().getSimpleName());
        }
        return invokeV.shortValue;
    }

    public String getAsString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            throw new UnsupportedOperationException(getClass().getSimpleName());
        }
        return (String) invokeV.objValue;
    }

    public boolean isJsonArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this instanceof JsonArray : invokeV.booleanValue;
    }

    public boolean isJsonNull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this instanceof JsonNull : invokeV.booleanValue;
    }

    public boolean isJsonObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this instanceof JsonObject : invokeV.booleanValue;
    }

    public boolean isJsonPrimitive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this instanceof JsonPrimitive : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            try {
                StringWriter stringWriter = new StringWriter();
                JsonWriter jsonWriter = new JsonWriter(stringWriter);
                jsonWriter.setLenient(true);
                Streams.write(this, jsonWriter);
                return stringWriter.toString();
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
        return (String) invokeV.objValue;
    }
}
