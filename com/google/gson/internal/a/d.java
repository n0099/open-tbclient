package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
/* loaded from: classes2.dex */
public final class d implements p {
    private final com.google.gson.internal.b ixh;

    public d(com.google.gson.internal.b bVar) {
        this.ixh = bVar;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.ccr().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (o<T>) a(this.ixh, dVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o<?> a(com.google.gson.internal.b bVar, com.google.gson.d dVar, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        o<?> lVar;
        Object cbT = bVar.b(com.google.gson.b.a.C(bVar2.value())).cbT();
        if (cbT instanceof o) {
            lVar = (o) cbT;
        } else if (cbT instanceof p) {
            lVar = ((p) cbT).a(dVar, aVar);
        } else if ((cbT instanceof com.google.gson.n) || (cbT instanceof com.google.gson.h)) {
            lVar = new l<>(cbT instanceof com.google.gson.n ? (com.google.gson.n) cbT : null, cbT instanceof com.google.gson.h ? (com.google.gson.h) cbT : null, dVar, aVar, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (lVar != null && bVar2.cbQ()) {
            return lVar.cbN();
        }
        return lVar;
    }
}
