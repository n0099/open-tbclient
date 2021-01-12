package com.google.gson;

import com.google.gson.stream.JsonToken;
import com.google.gson.stream.a;
import com.google.gson.stream.b;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
/* loaded from: classes4.dex */
public abstract class TypeAdapter<T> {
    public abstract T read(a aVar) throws IOException;

    public abstract void write(b bVar, T t) throws IOException;

    public final void toJson(Writer writer, T t) throws IOException {
        write(new b(writer), t);
    }

    public final TypeAdapter<T> nullSafe() {
        return new TypeAdapter<T>() { // from class: com.google.gson.TypeAdapter.1
            @Override // com.google.gson.TypeAdapter
            public void write(b bVar, T t) throws IOException {
                if (t == null) {
                    bVar.ezq();
                } else {
                    TypeAdapter.this.write(bVar, t);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public T read(a aVar) throws IOException {
                if (aVar.eyX() == JsonToken.NULL) {
                    aVar.ezd();
                    return null;
                }
                return (T) TypeAdapter.this.read(aVar);
            }
        };
    }

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final JsonElement toJsonTree(T t) {
        try {
            com.google.gson.internal.bind.b bVar = new com.google.gson.internal.bind.b();
            write(bVar, t);
            return bVar.ezk();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public final T fromJson(Reader reader) throws IOException {
        return read(new a(reader));
    }

    public final T fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final T fromJsonTree(JsonElement jsonElement) {
        try {
            return read(new com.google.gson.internal.bind.a(jsonElement));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }
}
