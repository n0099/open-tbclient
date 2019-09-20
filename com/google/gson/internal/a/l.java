package com.google.gson.internal.a;

import com.google.gson.internal.a.h;
import com.google.gson.n;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l<T> extends n<T> {
    private final n<T> kqh;
    private final com.google.gson.d krU;
    private final Type krV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(com.google.gson.d dVar, n<T> nVar, Type type) {
        this.krU = dVar;
        this.kqh = nVar;
        this.krV = type;
    }

    @Override // com.google.gson.n
    public void a(com.google.gson.stream.a aVar, T t) throws IOException {
        n<T> nVar = this.kqh;
        Type a = a(this.krV, t);
        if (a != this.krV) {
            nVar = this.krU.a(com.google.gson.b.a.l(a));
            if ((nVar instanceof h.a) && !(this.kqh instanceof h.a)) {
                nVar = this.kqh;
            }
        }
        nVar.a(aVar, t);
    }

    private Type a(Type type, Object obj) {
        if (obj != null) {
            if (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) {
                return obj.getClass();
            }
            return type;
        }
        return type;
    }
}
