package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
/* loaded from: classes2.dex */
public final class d implements p {
    private final com.google.gson.internal.b jMz;

    public d(com.google.gson.internal.b bVar) {
        this.jMz = bVar;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.cBC().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (o<T>) a(this.jMz, dVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o<?> a(com.google.gson.internal.b bVar, com.google.gson.d dVar, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        o<?> lVar;
        Object cBe = bVar.b(com.google.gson.b.a.E(bVar2.value())).cBe();
        if (cBe instanceof o) {
            lVar = (o) cBe;
        } else if (cBe instanceof p) {
            lVar = ((p) cBe).a(dVar, aVar);
        } else if ((cBe instanceof com.google.gson.n) || (cBe instanceof com.google.gson.h)) {
            lVar = new l<>(cBe instanceof com.google.gson.n ? (com.google.gson.n) cBe : null, cBe instanceof com.google.gson.h ? (com.google.gson.h) cBe : null, dVar, aVar, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (lVar != null && bVar2.cBb()) {
            return lVar.cAY();
        }
        return lVar;
    }
}
