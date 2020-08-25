package com.google.gson;

import com.google.gson.internal.i;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import com.google.gson.stream.a;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
/* loaded from: classes3.dex */
public final class JsonParser {
    public JsonElement parse(String str) throws JsonSyntaxException {
        return parse(new StringReader(str));
    }

    public JsonElement parse(Reader reader) throws JsonIOException, JsonSyntaxException {
        try {
            a aVar = new a(reader);
            JsonElement parse = parse(aVar);
            if (!parse.isJsonNull() && aVar.dXp() != JsonToken.END_DOCUMENT) {
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

    public JsonElement parse(a aVar) throws JsonIOException, JsonSyntaxException {
        boolean dXJ = aVar.dXJ();
        aVar.yo(true);
        try {
            try {
                return i.parse(aVar);
            } catch (OutOfMemoryError e) {
                throw new JsonParseException("Failed parsing JSON source: " + aVar + " to Json", e);
            } catch (StackOverflowError e2) {
                throw new JsonParseException("Failed parsing JSON source: " + aVar + " to Json", e2);
            }
        } finally {
            aVar.yo(dXJ);
        }
    }
}
