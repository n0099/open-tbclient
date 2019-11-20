package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
/* loaded from: classes2.dex */
public final class d implements o {
    private final com.google.gson.internal.b knr;

    public d(com.google.gson.internal.b bVar) {
        this.knr = bVar;
    }

    @Override // com.google.gson.o
    public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.cKC().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (n<T>) a(this.knr, dVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n<?> a(com.google.gson.internal.b bVar, com.google.gson.d dVar, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        n<?> kVar;
        Object cKj = bVar.b(com.google.gson.b.a.C(bVar2.value())).cKj();
        if (cKj instanceof n) {
            kVar = (n) cKj;
        } else if (cKj instanceof o) {
            kVar = ((o) cKj).a(dVar, aVar);
        } else if ((cKj instanceof com.google.gson.m) || (cKj instanceof com.google.gson.g)) {
            kVar = new k<>(cKj instanceof com.google.gson.m ? (com.google.gson.m) cKj : null, cKj instanceof com.google.gson.g ? (com.google.gson.g) cKj : null, dVar, aVar, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (kVar != null && bVar2.cKg()) {
            return kVar.cKd();
        }
        return kVar;
    }
}
