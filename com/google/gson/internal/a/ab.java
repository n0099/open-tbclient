package com.google.gson.internal.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonToken;
/* loaded from: classes.dex */
final class ab extends com.google.gson.aa {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public Number b(com.google.gson.stream.a aVar) {
        JsonToken f = aVar.f();
        switch (f) {
            case NUMBER:
                return new LazilyParsedNumber(aVar.h());
            case BOOLEAN:
            case STRING:
            default:
                throw new JsonSyntaxException("Expecting number, got: " + f);
            case NULL:
                aVar.j();
                return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Number number) {
        dVar.a(number);
    }
}
