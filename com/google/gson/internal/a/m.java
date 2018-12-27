package com.google.gson.internal.a;

import com.google.gson.internal.a.i;
import com.google.gson.o;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m<T> extends o<T> {
    private final o<T> iwl;
    private final com.google.gson.d iyi;
    private final Type iyj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(com.google.gson.d dVar, o<T> oVar, Type type) {
        this.iyi = dVar;
        this.iwl = oVar;
        this.iyj = type;
    }

    @Override // com.google.gson.o
    public T b(com.google.gson.stream.a aVar) throws IOException {
        return this.iwl.b(aVar);
    }

    @Override // com.google.gson.o
    public void a(com.google.gson.stream.b bVar, T t) throws IOException {
        o<T> oVar = this.iwl;
        Type a = a(this.iyj, t);
        if (a != this.iyj) {
            oVar = this.iyi.a(com.google.gson.b.a.l(a));
            if ((oVar instanceof i.a) && !(this.iwl instanceof i.a)) {
                oVar = this.iwl;
            }
        }
        oVar.a(bVar, t);
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
