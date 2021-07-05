package com.google.gson.internal.bind;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes7.dex */
public final class JsonTreeReader extends JsonReader {
    public static /* synthetic */ Interceptable $ic;
    public static final Object SENTINEL_CLOSED;
    public static final Reader UNREADABLE_READER;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] pathIndices;
    public String[] pathNames;
    public Object[] stack;
    public int stackSize;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(472366826, "Lcom/google/gson/internal/bind/JsonTreeReader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(472366826, "Lcom/google/gson/internal/bind/JsonTreeReader;");
                return;
            }
        }
        UNREADABLE_READER = new Reader() { // from class: com.google.gson.internal.bind.JsonTreeReader.1
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

            @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // java.io.Reader
            public int read(char[] cArr, int i2, int i3) throws IOException {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cArr, i2, i3)) == null) {
                    throw new AssertionError();
                }
                return invokeLII.intValue;
            }
        };
        SENTINEL_CLOSED = new Object();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeReader(JsonElement jsonElement) {
        super(UNREADABLE_READER);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsonElement};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Reader) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.stack = new Object[32];
        this.stackSize = 0;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        push(jsonElement);
    }

    private void expect(JsonToken jsonToken) throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, jsonToken) == null) || peek() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek() + locationString());
    }

    private String locationString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return " at path " + getPath();
        }
        return (String) invokeV.objValue;
    }

    private Object peekStack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) ? this.stack[this.stackSize - 1] : invokeV.objValue;
    }

    private Object popStack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            Object[] objArr = this.stack;
            int i2 = this.stackSize - 1;
            this.stackSize = i2;
            Object obj = objArr[i2];
            objArr[i2] = null;
            return obj;
        }
        return invokeV.objValue;
    }

    private void push(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, obj) == null) {
            int i2 = this.stackSize;
            Object[] objArr = this.stack;
            if (i2 == objArr.length) {
                Object[] objArr2 = new Object[i2 * 2];
                int[] iArr = new int[i2 * 2];
                String[] strArr = new String[i2 * 2];
                System.arraycopy(objArr, 0, objArr2, 0, i2);
                System.arraycopy(this.pathIndices, 0, iArr, 0, this.stackSize);
                System.arraycopy(this.pathNames, 0, strArr, 0, this.stackSize);
                this.stack = objArr2;
                this.pathIndices = iArr;
                this.pathNames = strArr;
            }
            Object[] objArr3 = this.stack;
            int i3 = this.stackSize;
            this.stackSize = i3 + 1;
            objArr3[i3] = obj;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            expect(JsonToken.BEGIN_ARRAY);
            push(((JsonArray) peekStack()).iterator());
            this.pathIndices[this.stackSize - 1] = 0;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            expect(JsonToken.BEGIN_OBJECT);
            push(((JsonObject) peekStack()).entrySet().iterator());
        }
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.stack = new Object[]{SENTINEL_CLOSED};
            this.stackSize = 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            expect(JsonToken.END_ARRAY);
            popStack();
            popStack();
            int i2 = this.stackSize;
            if (i2 > 0) {
                int[] iArr = this.pathIndices;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            expect(JsonToken.END_OBJECT);
            popStack();
            popStack();
            int i2 = this.stackSize;
            if (i2 > 0) {
                int[] iArr = this.pathIndices;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append('$');
            int i2 = 0;
            while (i2 < this.stackSize) {
                Object[] objArr = this.stack;
                if (objArr[i2] instanceof JsonArray) {
                    i2++;
                    if (objArr[i2] instanceof Iterator) {
                        sb.append('[');
                        sb.append(this.pathIndices[i2]);
                        sb.append(']');
                    }
                } else if (objArr[i2] instanceof JsonObject) {
                    i2++;
                    if (objArr[i2] instanceof Iterator) {
                        sb.append(IStringUtil.EXTENSION_SEPARATOR);
                        String[] strArr = this.pathNames;
                        if (strArr[i2] != null) {
                            sb.append(strArr[i2]);
                        }
                    }
                }
                i2++;
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JsonToken peek = peek();
            return (peek == JsonToken.END_OBJECT || peek == JsonToken.END_ARRAY) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            expect(JsonToken.BOOLEAN);
            boolean asBoolean = ((JsonPrimitive) popStack()).getAsBoolean();
            int i2 = this.stackSize;
            if (i2 > 0) {
                int[] iArr = this.pathIndices;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return asBoolean;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            JsonToken peek = peek();
            if (peek != JsonToken.NUMBER && peek != JsonToken.STRING) {
                throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + peek + locationString());
            }
            double asDouble = ((JsonPrimitive) peekStack()).getAsDouble();
            if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
                throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
            }
            popStack();
            int i2 = this.stackSize;
            if (i2 > 0) {
                int[] iArr = this.pathIndices;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return asDouble;
        }
        return invokeV.doubleValue;
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            JsonToken peek = peek();
            if (peek != JsonToken.NUMBER && peek != JsonToken.STRING) {
                throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + peek + locationString());
            }
            int asInt = ((JsonPrimitive) peekStack()).getAsInt();
            popStack();
            int i2 = this.stackSize;
            if (i2 > 0) {
                int[] iArr = this.pathIndices;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return asInt;
        }
        return invokeV.intValue;
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            JsonToken peek = peek();
            if (peek != JsonToken.NUMBER && peek != JsonToken.STRING) {
                throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + peek + locationString());
            }
            long asLong = ((JsonPrimitive) peekStack()).getAsLong();
            popStack();
            int i2 = this.stackSize;
            if (i2 > 0) {
                int[] iArr = this.pathIndices;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return asLong;
        }
        return invokeV.longValue;
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextName() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            expect(JsonToken.NAME);
            Map.Entry entry = (Map.Entry) ((Iterator) peekStack()).next();
            String str = (String) entry.getKey();
            this.pathNames[this.stackSize - 1] = str;
            push(entry.getValue());
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            expect(JsonToken.NULL);
            popStack();
            int i2 = this.stackSize;
            if (i2 > 0) {
                int[] iArr = this.pathIndices;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextString() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            JsonToken peek = peek();
            if (peek != JsonToken.STRING && peek != JsonToken.NUMBER) {
                throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + peek + locationString());
            }
            String asString = ((JsonPrimitive) popStack()).getAsString();
            int i2 = this.stackSize;
            if (i2 > 0) {
                int[] iArr = this.pathIndices;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return asString;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken peek() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.stackSize == 0) {
                return JsonToken.END_DOCUMENT;
            }
            Object peekStack = peekStack();
            if (peekStack instanceof Iterator) {
                boolean z = this.stack[this.stackSize - 2] instanceof JsonObject;
                Iterator it = (Iterator) peekStack;
                if (!it.hasNext()) {
                    return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
                } else if (z) {
                    return JsonToken.NAME;
                } else {
                    push(it.next());
                    return peek();
                }
            } else if (peekStack instanceof JsonObject) {
                return JsonToken.BEGIN_OBJECT;
            } else {
                if (peekStack instanceof JsonArray) {
                    return JsonToken.BEGIN_ARRAY;
                }
                if (peekStack instanceof JsonPrimitive) {
                    JsonPrimitive jsonPrimitive = (JsonPrimitive) peekStack;
                    if (jsonPrimitive.isString()) {
                        return JsonToken.STRING;
                    }
                    if (jsonPrimitive.isBoolean()) {
                        return JsonToken.BOOLEAN;
                    }
                    if (jsonPrimitive.isNumber()) {
                        return JsonToken.NUMBER;
                    }
                    throw new AssertionError();
                } else if (peekStack instanceof JsonNull) {
                    return JsonToken.NULL;
                } else {
                    if (peekStack == SENTINEL_CLOSED) {
                        throw new IllegalStateException("JsonReader is closed");
                    }
                    throw new AssertionError();
                }
            }
        }
        return (JsonToken) invokeV.objValue;
    }

    public void promoteNameToValue() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            expect(JsonToken.NAME);
            Map.Entry entry = (Map.Entry) ((Iterator) peekStack()).next();
            push(entry.getValue());
            push(new JsonPrimitive((String) entry.getKey()));
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (peek() == JsonToken.NAME) {
                nextName();
                this.pathNames[this.stackSize - 2] = StringUtil.NULL_STRING;
            } else {
                popStack();
                int i2 = this.stackSize;
                if (i2 > 0) {
                    this.pathNames[i2 - 1] = StringUtil.NULL_STRING;
                }
            }
            int i3 = this.stackSize;
            if (i3 > 0) {
                int[] iArr = this.pathIndices;
                int i4 = i3 - 1;
                iArr[i4] = iArr[i4] + 1;
            }
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? JsonTreeReader.class.getSimpleName() : (String) invokeV.objValue;
    }
}
