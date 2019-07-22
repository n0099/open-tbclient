package com.google.gson.internal.a;

import com.google.gson.internal.a.h;
import com.google.gson.n;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l<T> extends n<T> {
    private final n<T> kmE;
    private final com.google.gson.d kor;
    private final Type kos;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(com.google.gson.d dVar, n<T> nVar, Type type) {
        this.kor = dVar;
        this.kmE = nVar;
        this.kos = type;
    }

    @Override // com.google.gson.n
    public void a(com.google.gson.stream.a aVar, T t) throws IOException {
        n<T> nVar = this.kmE;
        Type a = a(this.kos, t);
        if (a != this.kos) {
            nVar = this.kor.a(com.google.gson.b.a.l(a));
            if ((nVar instanceof h.a) && !(this.kmE instanceof h.a)) {
                nVar = this.kmE;
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
