package com.google.gson.internal.a;

import com.google.gson.internal.LazilyParsedNumber;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
final class ar extends com.google.gson.aa {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public com.google.gson.r b(com.google.gson.stream.a aVar) {
        switch (aVar.f()) {
            case NUMBER:
                return new com.google.gson.u(new LazilyParsedNumber(aVar.h()));
            case BOOLEAN:
                return new com.google.gson.u(Boolean.valueOf(aVar.i()));
            case STRING:
                return new com.google.gson.u(aVar.h());
            case NULL:
                aVar.j();
                return com.google.gson.s.f1672a;
            case BEGIN_ARRAY:
                com.google.gson.o oVar = new com.google.gson.o();
                aVar.a();
                while (aVar.e()) {
                    oVar.a(b(aVar));
                }
                aVar.b();
                return oVar;
            case BEGIN_OBJECT:
                com.google.gson.t tVar = new com.google.gson.t();
                aVar.c();
                while (aVar.e()) {
                    tVar.a(aVar.g(), b(aVar));
                }
                aVar.d();
                return tVar;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, com.google.gson.r rVar) {
        if (rVar == null || rVar.j()) {
            dVar.f();
        } else if (rVar.i()) {
            com.google.gson.u m = rVar.m();
            if (m.p()) {
                dVar.a(m.a());
            } else if (m.o()) {
                dVar.a(m.f());
            } else {
                dVar.b(m.b());
            }
        } else if (rVar.g()) {
            dVar.b();
            Iterator it = rVar.l().iterator();
            while (it.hasNext()) {
                a(dVar, (com.google.gson.r) it.next());
            }
            dVar.c();
        } else if (rVar.h()) {
            dVar.d();
            for (Map.Entry entry : rVar.k().o()) {
                dVar.a((String) entry.getKey());
                a(dVar, (com.google.gson.r) entry.getValue());
            }
            dVar.e();
        } else {
            throw new IllegalArgumentException("Couldn't write " + rVar.getClass());
        }
    }
}
