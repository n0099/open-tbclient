package com.google.gson.internal.a;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.Type;
import java.util.Map;
/* loaded from: classes.dex */
public final class k implements com.google.gson.ab {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.gson.internal.b f1632a;
    private final boolean b;

    public k(com.google.gson.internal.b bVar, boolean z) {
        this.f1632a = bVar;
        this.b = z;
    }

    @Override // com.google.gson.ab
    public com.google.gson.aa a(com.google.gson.e eVar, com.google.gson.b.a aVar) {
        Type b = aVar.b();
        if (!Map.class.isAssignableFrom(aVar.a())) {
            return null;
        }
        Type[] b2 = C$Gson$Types.b(b, C$Gson$Types.e(b));
        return new l(this, eVar, b2[0], a(eVar, b2[0]), b2[1], eVar.a(com.google.gson.b.a.a(b2[1])), this.f1632a.a(aVar));
    }

    private com.google.gson.aa a(com.google.gson.e eVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? y.f : eVar.a(com.google.gson.b.a.a(type));
    }
}
