package com.google.gson.internal.a;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x extends com.google.gson.aa {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.gson.e f1641a;
    private final com.google.gson.aa b;
    private final Type c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(com.google.gson.e eVar, com.google.gson.aa aaVar, Type type) {
        this.f1641a = eVar;
        this.b = aaVar;
        this.c = type;
    }

    @Override // com.google.gson.aa
    public Object b(com.google.gson.stream.a aVar) {
        return this.b.b(aVar);
    }

    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Object obj) {
        com.google.gson.aa aaVar = this.b;
        Type a2 = a(this.c, obj);
        if (a2 != this.c) {
            aaVar = this.f1641a.a(com.google.gson.b.a.a(a2));
            if ((aaVar instanceof r) && !(this.b instanceof r)) {
                aaVar = this.b;
            }
        }
        aaVar.a(dVar, obj);
    }

    private Type a(Type type, Object obj) {
        if (obj != null) {
            if (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) {
                return obj.getClass();
            }
            return type;
        }
        return type;
    }
}
