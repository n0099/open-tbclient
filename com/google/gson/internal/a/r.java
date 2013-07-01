package com.google.gson.internal.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.util.Map;
/* loaded from: classes.dex */
public final class r extends com.google.gson.aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f1638a;
    private final com.google.gson.internal.n b;
    private final Map c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(p pVar, com.google.gson.internal.n nVar, Map map, q qVar) {
        this(pVar, nVar, map);
    }

    private r(p pVar, com.google.gson.internal.n nVar, Map map) {
        this.f1638a = pVar;
        this.b = nVar;
        this.c = map;
    }

    @Override // com.google.gson.aa
    public Object b(com.google.gson.stream.a aVar) {
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            return null;
        }
        Object a2 = this.b.a();
        try {
            aVar.c();
            while (aVar.e()) {
                s sVar = (s) this.c.get(aVar.g());
                if (sVar == null || !sVar.i) {
                    aVar.n();
                } else {
                    sVar.a(aVar, a2);
                }
            }
            aVar.d();
            return a2;
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (IllegalStateException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Object obj) {
        if (obj == null) {
            dVar.f();
            return;
        }
        dVar.d();
        try {
            for (s sVar : this.c.values()) {
                if (sVar.h) {
                    dVar.a(sVar.g);
                    sVar.a(dVar, obj);
                }
            }
            dVar.e();
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        }
    }
}
