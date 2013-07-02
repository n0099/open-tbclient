package com.google.gson;

import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
/* loaded from: classes.dex */
public abstract class TypeAdapter {
    public abstract Object read(JsonReader jsonReader);

    public abstract void write(JsonWriter jsonWriter, Object obj);

    public final void toJson(Writer writer, Object obj) {
        write(new JsonWriter(writer), obj);
    }

    public final TypeAdapter nullSafe() {
        return new TypeAdapter() { // from class: com.google.gson.TypeAdapter.1
            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Object obj) {
                if (obj == null) {
                    jsonWriter.nullValue();
                } else {
                    TypeAdapter.this.write(jsonWriter, obj);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public Object read(JsonReader jsonReader) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return TypeAdapter.this.read(jsonReader);
            }
        };
    }

    public final String toJson(Object obj) {
        StringWriter stringWriter = new StringWriter();
        toJson(stringWriter, obj);
        return stringWriter.toString();
    }

    public final JsonElement toJsonTree(Object obj) {
        try {
            JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
            write(jsonTreeWriter, obj);
            return jsonTreeWriter.get();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public final Object fromJson(Reader reader) {
        return read(new JsonReader(reader));
    }

    public final Object fromJson(String str) {
        return fromJson(new StringReader(str));
    }

    public final Object fromJsonTree(JsonElement jsonElement) {
        try {
            return read(new JsonTreeReader(jsonElement));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }
}
