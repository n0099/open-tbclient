package com.google.gson;

import com.google.gson.stream.JsonToken;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1667a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.f1667a = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public Float b(com.google.gson.stream.a aVar) {
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            return null;
        }
        return Float.valueOf((float) aVar.k());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Number number) {
        if (number == null) {
            dVar.f();
            return;
        }
        this.f1667a.a(number.floatValue());
        dVar.a(number);
    }
}
