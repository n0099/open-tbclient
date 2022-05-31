package com.google.gson;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes4.dex */
public final class JsonStreamParser implements Iterator<JsonElement> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object lock;
    public final JsonReader parser;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JsonStreamParser(String str) {
        this(new StringReader(str));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Reader) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this.lock) {
                try {
                    try {
                        z = this.parser.peek() != JsonToken.END_DOCUMENT;
                    } catch (MalformedJsonException e) {
                        throw new JsonSyntaxException(e);
                    } catch (IOException e2) {
                        throw new JsonIOException(e2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.Iterator
    public void remove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            throw new UnsupportedOperationException();
        }
    }

    public JsonStreamParser(Reader reader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {reader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        JsonReader jsonReader = new JsonReader(reader);
        this.parser = jsonReader;
        jsonReader.setLenient(true);
        this.lock = new Object();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public JsonElement next() throws JsonParseException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (hasNext()) {
                try {
                    return Streams.parse(this.parser);
                } catch (JsonParseException e) {
                    if (e.getCause() instanceof EOFException) {
                        throw new NoSuchElementException();
                    }
                    throw e;
                } catch (OutOfMemoryError e2) {
                    throw new JsonParseException("Failed parsing JSON source to Json", e2);
                } catch (StackOverflowError e3) {
                    throw new JsonParseException("Failed parsing JSON source to Json", e3);
                }
            }
            throw new NoSuchElementException();
        }
        return (JsonElement) invokeV.objValue;
    }
}
