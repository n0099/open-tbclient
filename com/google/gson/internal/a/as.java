package com.google.gson.internal.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class as implements com.google.gson.ab {
    @Override // com.google.gson.ab
    public com.google.gson.aa a(com.google.gson.e eVar, com.google.gson.b.a aVar) {
        Class a2 = aVar.a();
        if (!Enum.class.isAssignableFrom(a2) || a2 == Enum.class) {
            return null;
        }
        if (!a2.isEnum()) {
            a2 = a2.getSuperclass();
        }
        return new bf(a2);
    }
}
