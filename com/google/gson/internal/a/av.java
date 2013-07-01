package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
/* loaded from: classes.dex */
final class av extends com.google.gson.aa {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public Boolean b(com.google.gson.stream.a aVar) {
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            return null;
        } else if (aVar.f() == JsonToken.STRING) {
            return Boolean.valueOf(Boolean.parseBoolean(aVar.h()));
        } else {
            return Boolean.valueOf(aVar.i());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Boolean bool) {
        if (bool == null) {
            dVar.f();
        } else {
            dVar.a(bool.booleanValue());
        }
    }
}
