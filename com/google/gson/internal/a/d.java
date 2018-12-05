package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
/* loaded from: classes2.dex */
public final class d implements p {
    private final com.google.gson.internal.b isQ;

    public d(com.google.gson.internal.b bVar) {
        this.isQ = bVar;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.caT().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (o<T>) a(this.isQ, dVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o<?> a(com.google.gson.internal.b bVar, com.google.gson.d dVar, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        o<?> lVar;
        Object cav = bVar.b(com.google.gson.b.a.C(bVar2.value())).cav();
        if (cav instanceof o) {
            lVar = (o) cav;
        } else if (cav instanceof p) {
            lVar = ((p) cav).a(dVar, aVar);
        } else if ((cav instanceof com.google.gson.n) || (cav instanceof com.google.gson.h)) {
            lVar = new l<>(cav instanceof com.google.gson.n ? (com.google.gson.n) cav : null, cav instanceof com.google.gson.h ? (com.google.gson.h) cav : null, dVar, aVar, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (lVar != null && bVar2.cas()) {
            return lVar.cap();
        }
        return lVar;
    }
}
