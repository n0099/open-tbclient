package com.google.gson;

import com.google.gson.stream.JsonToken;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1668a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.f1668a = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public Number b(com.google.gson.stream.a aVar) {
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            return null;
        }
        return Long.valueOf(aVar.l());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Number number) {
        if (number == null) {
            dVar.f();
        } else {
            dVar.b(number.toString());
        }
    }
}
