package com.google.gson;

import java.io.IOException;
/* loaded from: classes.dex */
public abstract class aa {
    public abstract void a(com.google.gson.stream.d dVar, Object obj);

    public abstract Object b(com.google.gson.stream.a aVar);

    public final r a(Object obj) {
        try {
            com.google.gson.internal.a.i iVar = new com.google.gson.internal.a.i();
            a(iVar, obj);
            return iVar.a();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }
}
