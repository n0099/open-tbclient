package com.google.gson.internal.a;

import com.google.gson.internal.a.i;
import com.google.gson.o;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m<T> extends o<T> {
    private final o<T> itb;
    private final com.google.gson.d iuY;
    private final Type iuZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(com.google.gson.d dVar, o<T> oVar, Type type) {
        this.iuY = dVar;
        this.itb = oVar;
        this.iuZ = type;
    }

    @Override // com.google.gson.o
    public T b(com.google.gson.stream.a aVar) throws IOException {
        return this.itb.b(aVar);
    }

    @Override // com.google.gson.o
    public void a(com.google.gson.stream.b bVar, T t) throws IOException {
        o<T> oVar = this.itb;
        Type a = a(this.iuZ, t);
        if (a != this.iuZ) {
            oVar = this.iuY.a(com.google.gson.b.a.l(a));
            if ((oVar instanceof i.a) && !(this.itb instanceof i.a)) {
                oVar = this.itb;
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
