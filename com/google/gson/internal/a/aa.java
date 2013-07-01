package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
/* loaded from: classes.dex */
final class aa extends com.google.gson.aa {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public Number b(com.google.gson.stream.a aVar) {
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            return null;
        }
        return Double.valueOf(aVar.k());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Number number) {
        dVar.a(number);
    }
}
