package com.google.gson.internal.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
final class l extends com.google.gson.aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f1633a;
    private final com.google.gson.aa b;
    private final com.google.gson.aa c;
    private final com.google.gson.internal.n d;

    public l(k kVar, com.google.gson.e eVar, Type type, com.google.gson.aa aaVar, Type type2, com.google.gson.aa aaVar2, com.google.gson.internal.n nVar) {
        this.f1633a = kVar;
        this.b = new x(eVar, aaVar, type);
        this.c = new x(eVar, aaVar2, type2);
        this.d = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public Map b(com.google.gson.stream.a aVar) {
        JsonToken f = aVar.f();
        if (f == JsonToken.NULL) {
            aVar.j();
            return null;
        }
        Map map = (Map) this.d.a();
        if (f == JsonToken.BEGIN_ARRAY) {
            aVar.a();
            while (aVar.e()) {
                aVar.a();
                Object b = this.b.b(aVar);
                if (map.put(b, this.c.b(aVar)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + b);
                }
                aVar.b();
            }
            aVar.b();
            return map;
        }
        aVar.c();
        while (aVar.e()) {
            com.google.gson.internal.m.f1657a.a(aVar);
            Object b2 = this.b.b(aVar);
            if (map.put(b2, this.c.b(aVar)) != null) {
                throw new JsonSyntaxException("duplicate key: " + b2);
            }
        }
        aVar.d();
        return map;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Map map) {
        boolean z;
        int i = 0;
        if (map != null) {
            z = this.f1633a.b;
            if (!z) {
                dVar.d();
                for (Map.Entry entry : map.entrySet()) {
                    dVar.a(String.valueOf(entry.getKey()));
                    this.c.a(dVar, entry.getValue());
                }
                dVar.e();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            boolean z2 = false;
            for (Map.Entry entry2 : map.entrySet()) {
                com.google.gson.r a2 = this.b.a(entry2.getKey());
                arrayList.add(a2);
                arrayList2.add(entry2.getValue());
                z2 = (a2.g() || a2.h()) | z2;
            }
            if (z2) {
                dVar.b();
                while (i < arrayList.size()) {
                    dVar.b();
                    com.google.gson.internal.p.a((com.google.gson.r) arrayList.get(i), dVar);
                    this.c.a(dVar, arrayList2.get(i));
                    dVar.c();
                    i++;
                }
                dVar.c();
                return;
            }
            dVar.d();
            while (i < arrayList.size()) {
                dVar.a(a((com.google.gson.r) arrayList.get(i)));
                this.c.a(dVar, arrayList2.get(i));
                i++;
            }
            dVar.e();
            return;
        }
        dVar.f();
    }

    private String a(com.google.gson.r rVar) {
        if (rVar.i()) {
            com.google.gson.u m = rVar.m();
            if (m.p()) {
                return String.valueOf(m.a());
            }
            if (m.o()) {
                return Boolean.toString(m.f());
            }
            if (m.q()) {
                return m.b();
            }
            throw new AssertionError();
        } else if (rVar.j()) {
            return "null";
        } else {
            throw new AssertionError();
        }
    }
}
