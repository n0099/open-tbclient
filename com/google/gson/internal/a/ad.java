package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
/* loaded from: classes.dex */
final class ad extends com.google.gson.aa {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public String b(com.google.gson.stream.a aVar) {
        JsonToken f = aVar.f();
        if (f == JsonToken.NULL) {
            aVar.j();
            return null;
        } else if (f == JsonToken.BOOLEAN) {
            return Boolean.toString(aVar.i());
        } else {
            return aVar.h();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, String str) {
        dVar.b(str);
    }
}
