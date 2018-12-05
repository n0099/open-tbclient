package com.google.gson;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
/* loaded from: classes2.dex */
public abstract class o<T> {
    public abstract void a(com.google.gson.stream.b bVar, T t) throws IOException;

    public abstract T b(com.google.gson.stream.a aVar) throws IOException;

    public final o<T> cap() {
        return new o<T>() { // from class: com.google.gson.o.1
            @Override // com.google.gson.o
            public void a(com.google.gson.stream.b bVar, T t) throws IOException {
                if (t == null) {
                    bVar.caS();
                } else {
                    o.this.a(bVar, t);
                }
            }

            @Override // com.google.gson.o
            public T b(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.caH() == JsonToken.NULL) {
                    aVar.nextNull();
                    return null;
                }
                return (T) o.this.b(aVar);
            }
        };
    }

    public final i aQ(T t) {
        try {
            com.google.gson.internal.a.f fVar = new com.google.gson.internal.a.f();
            a(fVar, t);
            return fVar.caM();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }
}
