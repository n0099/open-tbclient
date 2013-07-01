package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
import java.lang.reflect.Array;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class a extends com.google.gson.aa {

    /* renamed from: a  reason: collision with root package name */
    public static final com.google.gson.ab f1619a = new b();
    private final Class b;
    private final com.google.gson.aa c;

    public a(com.google.gson.e eVar, com.google.gson.aa aaVar, Class cls) {
        this.c = new x(eVar, aaVar, cls);
        this.b = cls;
    }

    @Override // com.google.gson.aa
    public Object b(com.google.gson.stream.a aVar) {
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.e()) {
            arrayList.add(this.c.b(aVar));
        }
        aVar.b();
        Object newInstance = Array.newInstance(this.b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Object obj) {
        if (obj == null) {
            dVar.f();
            return;
        }
        dVar.b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.c.a(dVar, Array.get(obj, i));
        }
        dVar.c();
    }
}
