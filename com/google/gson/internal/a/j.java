package com.google.gson.internal.a;

import com.google.gson.internal.a.g;
import com.google.gson.m;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j<T> extends m<T> {
    private final m<T> hFo;
    private final com.google.gson.d hGM;
    private final Type hGN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(com.google.gson.d dVar, m<T> mVar, Type type) {
        this.hGM = dVar;
        this.hFo = mVar;
        this.hGN = type;
    }

    @Override // com.google.gson.m
    public void a(com.google.gson.stream.a aVar, T t) throws IOException {
        m<T> mVar = this.hFo;
        Type a = a(this.hGN, t);
        if (a != this.hGN) {
            mVar = this.hGM.a(com.google.gson.b.a.l(a));
            if ((mVar instanceof g.a) && !(this.hFo instanceof g.a)) {
                mVar = this.hFo;
            }
        }
        mVar.a(aVar, t);
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
