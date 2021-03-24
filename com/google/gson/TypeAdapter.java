package com.google.gson;

import com.google.gson.stream.JsonToken;
import d.g.c.d.a;
import d.g.c.d.b;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
/* loaded from: classes6.dex */
public abstract class TypeAdapter<T> {
    public final T fromJson(Reader reader) throws IOException {
        return read(new a(reader));
    }

    public final T fromJsonTree(JsonElement jsonElement) {
        try {
            return read(new d.g.c.b.j.a(jsonElement));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public final TypeAdapter<T> nullSafe() {
        return new TypeAdapter<T>() { // from class: com.google.gson.TypeAdapter.1
            @Override // com.google.gson.TypeAdapter
            public T read(a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                return (T) TypeAdapter.this.read(aVar);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(b bVar, T t) throws IOException {
                if (t == null) {
                    bVar.B();
                } else {
                    TypeAdapter.this.write(bVar, t);
                }
            }
        };
    }

    public abstract T read(a aVar) throws IOException;

    public final void toJson(Writer writer, T t) throws IOException {
        write(new b(writer), t);
    }

    public final JsonElement toJsonTree(T t) {
        try {
            d.g.c.b.j.b bVar = new d.g.c.b.j.b();
            write(bVar, t);
            return bVar.R();
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public abstract void write(b bVar, T t) throws IOException;

    public final T fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
