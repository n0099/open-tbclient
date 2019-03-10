package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
/* loaded from: classes2.dex */
public final class d implements p {
    private final com.google.gson.internal.b jNm;

    public d(com.google.gson.internal.b bVar) {
        this.jNm = bVar;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.cBG().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (o<T>) a(this.jNm, dVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o<?> a(com.google.gson.internal.b bVar, com.google.gson.d dVar, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        o<?> lVar;
        Object cBi = bVar.b(com.google.gson.b.a.F(bVar2.value())).cBi();
        if (cBi instanceof o) {
            lVar = (o) cBi;
        } else if (cBi instanceof p) {
            lVar = ((p) cBi).a(dVar, aVar);
        } else if ((cBi instanceof com.google.gson.n) || (cBi instanceof com.google.gson.h)) {
            lVar = new l<>(cBi instanceof com.google.gson.n ? (com.google.gson.n) cBi : null, cBi instanceof com.google.gson.h ? (com.google.gson.h) cBi : null, dVar, aVar, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (lVar != null && bVar2.cBf()) {
            return lVar.cBc();
        }
        return lVar;
    }
}
