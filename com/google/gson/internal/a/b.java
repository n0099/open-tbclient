package com.google.gson.internal.a;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
final class b implements com.google.gson.ab {
    @Override // com.google.gson.ab
    public com.google.gson.aa a(com.google.gson.e eVar, com.google.gson.b.a aVar) {
        Type b = aVar.b();
        if (!(b instanceof GenericArrayType) && (!(b instanceof Class) || !((Class) b).isArray())) {
            return null;
        }
        Type g = C$Gson$Types.g(b);
        return new a(eVar, eVar.a(com.google.gson.b.a.a(g)), C$Gson$Types.e(g));
    }
}
