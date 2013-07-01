package com.google.gson.internal.a;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class m extends com.google.gson.aa {

    /* renamed from: a  reason: collision with root package name */
    public static final com.google.gson.ab f1634a = new n();
    private final com.google.gson.e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(com.google.gson.e eVar, n nVar) {
        this(eVar);
    }

    private m(com.google.gson.e eVar) {
        this.b = eVar;
    }

    @Override // com.google.gson.aa
    public Object b(com.google.gson.stream.a aVar) {
        switch (o.f1635a[aVar.f().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(b(aVar));
                }
                aVar.b();
                return arrayList;
            case 2:
                com.google.gson.internal.q qVar = new com.google.gson.internal.q();
                aVar.c();
                while (aVar.e()) {
                    qVar.put(aVar.g(), b(aVar));
                }
                aVar.d();
                return qVar;
            case 3:
                return aVar.h();
            case 4:
                return Double.valueOf(aVar.k());
            case 5:
                return Boolean.valueOf(aVar.i());
            case 6:
                aVar.j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Object obj) {
        if (obj == null) {
            dVar.f();
            return;
        }
        com.google.gson.aa a2 = this.b.a(obj.getClass());
        if (a2 instanceof m) {
            dVar.d();
            dVar.e();
            return;
        }
        a2.a(dVar, obj);
    }
}
