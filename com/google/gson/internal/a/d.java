package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
/* loaded from: classes2.dex */
public final class d implements o {
    private final com.google.gson.internal.b kmt;

    public d(com.google.gson.internal.b bVar) {
        this.kmt = bVar;
    }

    @Override // com.google.gson.o
    public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.cMy().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (n<T>) a(this.kmt, dVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n<?> a(com.google.gson.internal.b bVar, com.google.gson.d dVar, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        n<?> kVar;
        Object cMf = bVar.b(com.google.gson.b.a.E(bVar2.value())).cMf();
        if (cMf instanceof n) {
            kVar = (n) cMf;
        } else if (cMf instanceof o) {
            kVar = ((o) cMf).a(dVar, aVar);
        } else if ((cMf instanceof com.google.gson.m) || (cMf instanceof com.google.gson.g)) {
            kVar = new k<>(cMf instanceof com.google.gson.m ? (com.google.gson.m) cMf : null, cMf instanceof com.google.gson.g ? (com.google.gson.g) cMf : null, dVar, aVar, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (kVar != null && bVar2.cMc()) {
            return kVar.cLZ();
        }
        return kVar;
    }
}
