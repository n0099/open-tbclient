package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
/* loaded from: classes2.dex */
public final class d implements p {
    private final com.google.gson.internal.b jMT;

    public d(com.google.gson.internal.b bVar) {
        this.jMT = bVar;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.cBw().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (o<T>) a(this.jMT, dVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o<?> a(com.google.gson.internal.b bVar, com.google.gson.d dVar, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        o<?> lVar;
        Object cAY = bVar.b(com.google.gson.b.a.F(bVar2.value())).cAY();
        if (cAY instanceof o) {
            lVar = (o) cAY;
        } else if (cAY instanceof p) {
            lVar = ((p) cAY).a(dVar, aVar);
        } else if ((cAY instanceof com.google.gson.n) || (cAY instanceof com.google.gson.h)) {
            lVar = new l<>(cAY instanceof com.google.gson.n ? (com.google.gson.n) cAY : null, cAY instanceof com.google.gson.h ? (com.google.gson.h) cAY : null, dVar, aVar, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (lVar != null && bVar2.cAV()) {
            return lVar.cAS();
        }
        return lVar;
    }
}
