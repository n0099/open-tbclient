package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes.dex */
final class d extends com.google.gson.aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1628a;
    private final com.google.gson.aa b;
    private final com.google.gson.internal.n c;

    public d(c cVar, com.google.gson.e eVar, Type type, com.google.gson.aa aaVar, com.google.gson.internal.n nVar) {
        this.f1628a = cVar;
        this.b = new x(eVar, aaVar, type);
        this.c = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public Collection b(com.google.gson.stream.a aVar) {
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            return null;
        }
        Collection collection = (Collection) this.c.a();
        aVar.a();
        while (aVar.e()) {
            collection.add(this.b.b(aVar));
        }
        aVar.b();
        return collection;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Collection collection) {
        if (collection == null) {
            dVar.f();
            return;
        }
        dVar.b();
        for (Object obj : collection) {
            this.b.a(dVar, obj);
        }
        dVar.c();
    }
}
