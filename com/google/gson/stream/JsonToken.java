package com.google.gson.stream;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class JsonToken {
    public static final /* synthetic */ JsonToken[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final JsonToken BEGIN_ARRAY;
    public static final JsonToken BEGIN_OBJECT;
    public static final JsonToken BOOLEAN;
    public static final JsonToken END_ARRAY;
    public static final JsonToken END_DOCUMENT;
    public static final JsonToken END_OBJECT;
    public static final JsonToken NAME;
    public static final JsonToken NULL;
    public static final JsonToken NUMBER;
    public static final JsonToken STRING;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(634310385, "Lcom/google/gson/stream/JsonToken;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(634310385, "Lcom/google/gson/stream/JsonToken;");
                return;
            }
        }
        BEGIN_ARRAY = new JsonToken("BEGIN_ARRAY", 0);
        END_ARRAY = new JsonToken("END_ARRAY", 1);
        BEGIN_OBJECT = new JsonToken("BEGIN_OBJECT", 2);
        END_OBJECT = new JsonToken("END_OBJECT", 3);
        NAME = new JsonToken("NAME", 4);
        STRING = new JsonToken("STRING", 5);
        NUMBER = new JsonToken("NUMBER", 6);
        BOOLEAN = new JsonToken("BOOLEAN", 7);
        NULL = new JsonToken("NULL", 8);
        JsonToken jsonToken = new JsonToken("END_DOCUMENT", 9);
        END_DOCUMENT = jsonToken;
        $VALUES = new JsonToken[]{BEGIN_ARRAY, END_ARRAY, BEGIN_OBJECT, END_OBJECT, NAME, STRING, NUMBER, BOOLEAN, NULL, jsonToken};
    }

    public JsonToken(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static JsonToken valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (JsonToken) Enum.valueOf(JsonToken.class, str) : (JsonToken) invokeL.objValue;
    }

    public static JsonToken[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (JsonToken[]) $VALUES.clone() : (JsonToken[]) invokeV.objValue;
    }
}
