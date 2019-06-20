package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
/* loaded from: classes2.dex */
public final class d implements o {
    private final com.google.gson.internal.b kfn;

    public d(com.google.gson.internal.b bVar) {
        this.kfn = bVar;
    }

    @Override // com.google.gson.o
    public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.cJs().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (n<T>) a(this.kfn, dVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n<?> a(com.google.gson.internal.b bVar, com.google.gson.d dVar, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        n<?> kVar;
        Object cIZ = bVar.b(com.google.gson.b.a.C(bVar2.value())).cIZ();
        if (cIZ instanceof n) {
            kVar = (n) cIZ;
        } else if (cIZ instanceof o) {
            kVar = ((o) cIZ).a(dVar, aVar);
        } else if ((cIZ instanceof com.google.gson.m) || (cIZ instanceof com.google.gson.g)) {
            kVar = new k<>(cIZ instanceof com.google.gson.m ? (com.google.gson.m) cIZ : null, cIZ instanceof com.google.gson.g ? (com.google.gson.g) cIZ : null, dVar, aVar, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (kVar != null && bVar2.cIW()) {
            return kVar.cIT();
        }
        return kVar;
    }
}
