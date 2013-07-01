package com.google.gson.internal.a;

import java.lang.reflect.Field;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends s {

    /* renamed from: a  reason: collision with root package name */
    final com.google.gson.aa f1637a;
    final /* synthetic */ com.google.gson.e b;
    final /* synthetic */ com.google.gson.b.a c;
    final /* synthetic */ Field d;
    final /* synthetic */ boolean e;
    final /* synthetic */ p f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, String str, boolean z, boolean z2, com.google.gson.e eVar, com.google.gson.b.a aVar, Field field, boolean z3) {
        super(str, z, z2);
        this.f = pVar;
        this.b = eVar;
        this.c = aVar;
        this.d = field;
        this.e = z3;
        this.f1637a = this.b.a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.gson.internal.a.s
    public void a(com.google.gson.stream.d dVar, Object obj) {
        new x(this.b, this.f1637a, this.c.b()).a(dVar, this.d.get(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.gson.internal.a.s
    public void a(com.google.gson.stream.a aVar, Object obj) {
        Object b = this.f1637a.b(aVar);
        if (b != null || !this.e) {
            this.d.set(obj, b);
        }
    }
}
