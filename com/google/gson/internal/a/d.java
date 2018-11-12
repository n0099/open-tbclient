package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
/* loaded from: classes2.dex */
public final class d implements p {
    private final com.google.gson.internal.b ilE;

    public d(com.google.gson.internal.b bVar) {
        this.ilE = bVar;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.bYN().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (o<T>) a(this.ilE, dVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o<?> a(com.google.gson.internal.b bVar, com.google.gson.d dVar, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        o<?> lVar;
        Object bYp = bVar.b(com.google.gson.b.a.B(bVar2.value())).bYp();
        if (bYp instanceof o) {
            lVar = (o) bYp;
        } else if (bYp instanceof p) {
            lVar = ((p) bYp).a(dVar, aVar);
        } else if ((bYp instanceof com.google.gson.n) || (bYp instanceof com.google.gson.h)) {
            lVar = new l<>(bYp instanceof com.google.gson.n ? (com.google.gson.n) bYp : null, bYp instanceof com.google.gson.h ? (com.google.gson.h) bYp : null, dVar, aVar, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (lVar != null && bVar2.bYm()) {
            return lVar.bYj();
        }
        return lVar;
    }
}
