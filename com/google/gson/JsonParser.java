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
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
/* loaded from: classes4.dex */
public final class JsonParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public JsonParser() {
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

    public JsonElement parse(String str) throws JsonSyntaxException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? parse(new StringReader(str)) : (JsonElement) invokeL.objValue;
    }

    public JsonElement parse(Reader reader) throws JsonIOException, JsonSyntaxException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reader)) == null) {
            try {
                JsonReader jsonReader = new JsonReader(reader);
                JsonElement parse = parse(jsonReader);
                if (!parse.isJsonNull() && jsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonSyntaxException("Did not consume the entire document.");
                }
                return parse;
            } catch (MalformedJsonException e) {
                throw new JsonSyntaxException(e);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (NumberFormatException e3) {
                throw new JsonSyntaxException(e3);
            }
        }
        return (JsonElement) invokeL.objValue;
    }

    public JsonElement parse(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jsonReader)) == null) {
            boolean isLenient = jsonReader.isLenient();
            jsonReader.setLenient(true);
            try {
                try {
                    return Streams.parse(jsonReader);
                } catch (OutOfMemoryError e) {
                    throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e);
                } catch (StackOverflowError e2) {
                    throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e2);
                }
            } finally {
                jsonReader.setLenient(isLenient);
            }
        }
        return (JsonElement) invokeL.objValue;
    }
}
