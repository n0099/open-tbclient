package com.google.gson;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;
/* loaded from: classes6.dex */
public final class JsonPrimitive extends JsonElement {
    public static /* synthetic */ Interceptable $ic;
    public static final Class<?>[] PRIMITIVE_TYPES;
    public transient /* synthetic */ FieldHolder $fh;
    public Object value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1215079908, "Lcom/google/gson/JsonPrimitive;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1215079908, "Lcom/google/gson/JsonPrimitive;");
                return;
            }
        }
        PRIMITIVE_TYPES = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    }

    public JsonPrimitive(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bool};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setValue(bool);
    }

    public static boolean isIntegral(JsonPrimitive jsonPrimitive) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, jsonPrimitive)) == null) {
            Object obj = jsonPrimitive.value;
            if (obj instanceof Number) {
                Number number = (Number) obj;
                return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isPrimitiveOrString(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) {
            if (obj instanceof String) {
                return true;
            }
            Class<?> cls = obj.getClass();
            for (Class<?> cls2 : PRIMITIVE_TYPES) {
                if (cls2.isAssignableFrom(cls)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.JsonElement
    public JsonPrimitive deepCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (JsonPrimitive) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || JsonPrimitive.class != obj.getClass()) {
                return false;
            }
            JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
            if (this.value == null) {
                return jsonPrimitive.value == null;
            } else if (isIntegral(this) && isIntegral(jsonPrimitive)) {
                return getAsNumber().longValue() == jsonPrimitive.getAsNumber().longValue();
            } else if ((this.value instanceof Number) && (jsonPrimitive.value instanceof Number)) {
                double doubleValue = getAsNumber().doubleValue();
                double doubleValue2 = jsonPrimitive.getAsNumber().doubleValue();
                if (doubleValue != doubleValue2) {
                    return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
                }
                return true;
            } else {
                return this.value.equals(jsonPrimitive.value);
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object obj = this.value;
            return obj instanceof BigDecimal ? (BigDecimal) obj : new BigDecimal(this.value.toString());
        }
        return (BigDecimal) invokeV.objValue;
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Object obj = this.value;
            return obj instanceof BigInteger ? (BigInteger) obj : new BigInteger(this.value.toString());
        }
        return (BigInteger) invokeV.objValue;
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (isBoolean()) {
                return getAsBooleanWrapper().booleanValue();
            }
            return Boolean.parseBoolean(getAsString());
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.gson.JsonElement
    public Boolean getAsBooleanWrapper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (Boolean) this.value : (Boolean) invokeV.objValue;
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? isNumber() ? getAsNumber().byteValue() : Byte.parseByte(getAsString()) : invokeV.byteValue;
    }

    @Override // com.google.gson.JsonElement
    public char getAsCharacter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getAsString().charAt(0) : invokeV.charValue;
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? isNumber() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString()) : invokeV.doubleValue;
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? isNumber() ? getAsNumber().floatValue() : Float.parseFloat(getAsString()) : invokeV.floatValue;
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? isNumber() ? getAsNumber().intValue() : Integer.parseInt(getAsString()) : invokeV.intValue;
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? isNumber() ? getAsNumber().longValue() : Long.parseLong(getAsString()) : invokeV.longValue;
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Object obj = this.value;
            return obj instanceof String ? new LazilyParsedNumber((String) this.value) : (Number) obj;
        }
        return (Number) invokeV.objValue;
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? isNumber() ? getAsNumber().shortValue() : Short.parseShort(getAsString()) : invokeV.shortValue;
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (isNumber()) {
                return getAsNumber().toString();
            }
            if (isBoolean()) {
                return getAsBooleanWrapper().toString();
            }
            return (String) this.value;
        }
        return (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        long doubleToLongBits;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.value == null) {
                return 31;
            }
            if (isIntegral(this)) {
                doubleToLongBits = getAsNumber().longValue();
            } else {
                Object obj = this.value;
                if (obj instanceof Number) {
                    doubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
                } else {
                    return obj.hashCode();
                }
            }
            return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
        }
        return invokeV.intValue;
    }

    public boolean isBoolean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.value instanceof Boolean : invokeV.booleanValue;
    }

    public boolean isNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.value instanceof Number : invokeV.booleanValue;
    }

    public boolean isString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.value instanceof String : invokeV.booleanValue;
    }

    public void setValue(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, obj) == null) {
            if (obj instanceof Character) {
                this.value = String.valueOf(((Character) obj).charValue());
                return;
            }
            C$Gson$Preconditions.checkArgument((obj instanceof Number) || isPrimitiveOrString(obj));
            this.value = obj;
        }
    }

    public JsonPrimitive(Number number) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {number};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        setValue(number);
    }

    public JsonPrimitive(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65541, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        setValue(str);
    }

    public JsonPrimitive(Character ch) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ch};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        setValue(ch);
    }

    public JsonPrimitive(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        setValue(obj);
    }
}
