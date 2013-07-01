package com.google.gson.internal;

import java.lang.reflect.Type;
/* loaded from: classes.dex */
class j implements n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Class f1654a;
    final /* synthetic */ Type b;
    final /* synthetic */ b c;
    private final aa d = aa.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar, Class cls, Type type) {
        this.c = bVar;
        this.f1654a = cls;
        this.b = type;
    }

    @Override // com.google.gson.internal.n
    public Object a() {
        try {
            return this.d.a(this.f1654a);
        } catch (Exception e) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + this.b + ". Register an InstanceCreator with Gson for this type may fix this problem.", e);
        }
    }
}
