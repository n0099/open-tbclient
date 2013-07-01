package com.google.gson.internal.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
/* loaded from: classes.dex */
final class ac extends com.google.gson.aa {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public Character b(com.google.gson.stream.a aVar) {
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            return null;
        }
        String h = aVar.h();
        if (h.length() != 1) {
            throw new JsonSyntaxException("Expecting character, got: " + h);
        }
        return Character.valueOf(h.charAt(0));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Character ch) {
        dVar.b(ch == null ? null : String.valueOf(ch));
    }
}
