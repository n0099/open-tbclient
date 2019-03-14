package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
/* loaded from: classes2.dex */
public final class d implements p {
    private final com.google.gson.internal.b jNe;

    public d(com.google.gson.internal.b bVar) {
        this.jNe = bVar;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.cBJ().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (o<T>) a(this.jNe, dVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o<?> a(com.google.gson.internal.b bVar, com.google.gson.d dVar, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        o<?> lVar;
        Object cBl = bVar.b(com.google.gson.b.a.F(bVar2.value())).cBl();
        if (cBl instanceof o) {
            lVar = (o) cBl;
        } else if (cBl instanceof p) {
            lVar = ((p) cBl).a(dVar, aVar);
        } else if ((cBl instanceof com.google.gson.n) || (cBl instanceof com.google.gson.h)) {
            lVar = new l<>(cBl instanceof com.google.gson.n ? (com.google.gson.n) cBl : null, cBl instanceof com.google.gson.h ? (com.google.gson.h) cBl : null, dVar, aVar, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (lVar != null && bVar2.cBi()) {
            return lVar.cBf();
        }
        return lVar;
    }
}
