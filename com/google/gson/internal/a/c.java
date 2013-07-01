package com.google.gson.internal.a;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes.dex */
public final class c implements com.google.gson.ab {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.gson.internal.b f1627a;

    public c(com.google.gson.internal.b bVar) {
        this.f1627a = bVar;
    }

    @Override // com.google.gson.ab
    public com.google.gson.aa a(com.google.gson.e eVar, com.google.gson.b.a aVar) {
        Type b = aVar.b();
        Class a2 = aVar.a();
        if (!Collection.class.isAssignableFrom(a2)) {
            return null;
        }
        Type a3 = C$Gson$Types.a(b, a2);
        return new d(this, eVar, a3, eVar.a(com.google.gson.b.a.a(a3)), this.f1627a.a(aVar));
    }
}
