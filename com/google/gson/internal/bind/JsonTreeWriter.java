package com.google.gson.internal.bind;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class JsonTreeWriter extends JsonWriter {
    public static /* synthetic */ Interceptable $ic;
    public static final JsonPrimitive SENTINEL_CLOSED;
    public static final Writer UNWRITABLE_WRITER;
    public transient /* synthetic */ FieldHolder $fh;
    public String pendingName;
    public JsonElement product;
    public final List<JsonElement> stack;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(994961722, "Lcom/google/gson/internal/bind/JsonTreeWriter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(994961722, "Lcom/google/gson/internal/bind/JsonTreeWriter;");
                return;
            }
        }
        UNWRITABLE_WRITER = new Writer() { // from class: com.google.gson.internal.bind.JsonTreeWriter.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // java.io.Writer, java.io.Flushable
            public void flush() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // java.io.Writer
            public void write(char[] cArr, int i2, int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_SEND_USER_MSG, this, cArr, i2, i3) == null) {
                    throw new AssertionError();
                }
            }
        };
        SENTINEL_CLOSED = new JsonPrimitive("closed");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeWriter() {
        super(UNWRITABLE_WRITER);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Writer) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.stack = new ArrayList();
        this.product = JsonNull.INSTANCE;
    }

    private JsonElement peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            List<JsonElement> list = this.stack;
            return list.get(list.size() - 1);
        }
        return (JsonElement) invokeV.objValue;
    }

    private void put(JsonElement jsonElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, jsonElement) == null) {
            if (this.pendingName != null) {
                if (!jsonElement.isJsonNull() || getSerializeNulls()) {
                    ((JsonObject) peek()).add(this.pendingName, jsonElement);
                }
                this.pendingName = null;
            } else if (this.stack.isEmpty()) {
                this.product = jsonElement;
            } else {
                JsonElement peek = peek();
                if (peek instanceof JsonArray) {
                    ((JsonArray) peek).add(jsonElement);
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginArray() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JsonArray jsonArray = new JsonArray();
            put(jsonArray);
            this.stack.add(jsonArray);
            return this;
        }
        return (JsonWriter) invokeV.objValue;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginObject() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JsonObject jsonObject = new JsonObject();
            put(jsonObject);
            this.stack.add(jsonObject);
            return this;
        }
        return (JsonWriter) invokeV.objValue;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.stack.isEmpty()) {
                this.stack.add(SENTINEL_CLOSED);
                return;
            }
            throw new IOException("Incomplete document");
        }
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endArray() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.stack.isEmpty() && this.pendingName == null) {
                if (peek() instanceof JsonArray) {
                    List<JsonElement> list = this.stack;
                    list.remove(list.size() - 1);
                    return this;
                }
                throw new IllegalStateException();
            }
            throw new IllegalStateException();
        }
        return (JsonWriter) invokeV.objValue;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endObject() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.stack.isEmpty() && this.pendingName == null) {
                if (peek() instanceof JsonObject) {
                    List<JsonElement> list = this.stack;
                    list.remove(list.size() - 1);
                    return this;
                }
                throw new IllegalStateException();
            }
            throw new IllegalStateException();
        }
        return (JsonWriter) invokeV.objValue;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public JsonElement get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.stack.isEmpty()) {
                return this.product;
            }
            throw new IllegalStateException("Expected one JSON element but was " + this.stack);
        }
        return (JsonElement) invokeV.objValue;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter name(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!this.stack.isEmpty() && this.pendingName == null) {
                if (peek() instanceof JsonObject) {
                    this.pendingName = str;
                    return this;
                }
                throw new IllegalStateException();
            }
            throw new IllegalStateException();
        }
        return (JsonWriter) invokeL.objValue;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter nullValue() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            put(JsonNull.INSTANCE);
            return this;
        }
        return (JsonWriter) invokeV.objValue;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (str == null) {
                return nullValue();
            }
            put(new JsonPrimitive(str));
            return this;
        }
        return (JsonWriter) invokeL.objValue;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
            put(new JsonPrimitive(Boolean.valueOf(z)));
            return this;
        }
        return (JsonWriter) invokeZ.objValue;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Boolean bool) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bool)) == null) {
            if (bool == null) {
                return nullValue();
            }
            put(new JsonPrimitive(bool));
            return this;
        }
        return (JsonWriter) invokeL.objValue;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(double d2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Double.valueOf(d2)})) == null) {
            if (!isLenient() && (Double.isNaN(d2) || Double.isInfinite(d2))) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d2);
            }
            put(new JsonPrimitive((Number) Double.valueOf(d2)));
            return this;
        }
        return (JsonWriter) invokeCommon.objValue;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
            put(new JsonPrimitive((Number) Long.valueOf(j2)));
            return this;
        }
        return (JsonWriter) invokeJ.objValue;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Number number) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, number)) == null) {
            if (number == null) {
                return nullValue();
            }
            if (!isLenient()) {
                double doubleValue = number.doubleValue();
                if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                    throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
                }
            }
            put(new JsonPrimitive(number));
            return this;
        }
        return (JsonWriter) invokeL.objValue;
    }
}
