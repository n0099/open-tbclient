package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
/* loaded from: classes2.dex */
public final class d implements p {
    private final com.google.gson.internal.b ijU;

    public d(com.google.gson.internal.b bVar) {
        this.ijU = bVar;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.bZq().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (o<T>) a(this.ijU, dVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o<?> a(com.google.gson.internal.b bVar, com.google.gson.d dVar, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        o<?> lVar;
        Object bYS = bVar.b(com.google.gson.b.a.B(bVar2.value())).bYS();
        if (bYS instanceof o) {
            lVar = (o) bYS;
        } else if (bYS instanceof p) {
            lVar = ((p) bYS).a(dVar, aVar);
        } else if ((bYS instanceof com.google.gson.n) || (bYS instanceof com.google.gson.h)) {
            lVar = new l<>(bYS instanceof com.google.gson.n ? (com.google.gson.n) bYS : null, bYS instanceof com.google.gson.h ? (com.google.gson.h) bYS : null, dVar, aVar, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (lVar != null && bVar2.bYP()) {
            return lVar.bYM();
        }
        return lVar;
    }
}
