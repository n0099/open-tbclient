package com.google.gson;

import com.google.gson.stream.JsonToken;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1617a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.f1617a = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public Double b(com.google.gson.stream.a aVar) {
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            return null;
        }
        return Double.valueOf(aVar.k());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Number number) {
        if (number == null) {
            dVar.f();
            return;
        }
        this.f1617a.a(number.doubleValue());
        dVar.a(number);
    }
}
