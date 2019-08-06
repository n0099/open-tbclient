package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
/* loaded from: classes2.dex */
public final class d implements o {
    private final com.google.gson.internal.b knz;

    public d(com.google.gson.internal.b bVar) {
        this.knz = bVar;
    }

    @Override // com.google.gson.o
    public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.cMT().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (n<T>) a(this.knz, dVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n<?> a(com.google.gson.internal.b bVar, com.google.gson.d dVar, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        n<?> kVar;
        Object cMA = bVar.b(com.google.gson.b.a.E(bVar2.value())).cMA();
        if (cMA instanceof n) {
            kVar = (n) cMA;
        } else if (cMA instanceof o) {
            kVar = ((o) cMA).a(dVar, aVar);
        } else if ((cMA instanceof com.google.gson.m) || (cMA instanceof com.google.gson.g)) {
            kVar = new k<>(cMA instanceof com.google.gson.m ? (com.google.gson.m) cMA : null, cMA instanceof com.google.gson.g ? (com.google.gson.g) cMA : null, dVar, aVar, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (kVar != null && bVar2.cMx()) {
            return kVar.cMu();
        }
        return kVar;
    }
}
