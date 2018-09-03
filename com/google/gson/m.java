package com.google.gson;

import java.io.IOException;
/* loaded from: classes2.dex */
public abstract class m<T> {
    public abstract void a(com.google.gson.stream.a aVar, T t) throws IOException;

    public final h ai(T t) {
        try {
            com.google.gson.internal.a.d dVar = new com.google.gson.internal.a.d();
            a(dVar, t);
            return dVar.bKj();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }
}
