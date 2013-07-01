package com.google.gson.internal.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.math.BigDecimal;
/* loaded from: classes.dex */
final class ae extends com.google.gson.aa {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public BigDecimal b(com.google.gson.stream.a aVar) {
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            return null;
        }
        try {
            return new BigDecimal(aVar.h());
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, BigDecimal bigDecimal) {
        dVar.a(bigDecimal);
    }
}
