package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
/* loaded from: classes.dex */
final class ah extends com.google.gson.aa {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public StringBuffer b(com.google.gson.stream.a aVar) {
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            return null;
        }
        return new StringBuffer(aVar.h());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, StringBuffer stringBuffer) {
        dVar.b(stringBuffer == null ? null : stringBuffer.toString());
    }
}
