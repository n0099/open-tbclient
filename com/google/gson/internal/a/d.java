package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
/* loaded from: classes2.dex */
public final class d implements o {
    private final com.google.gson.internal.b koi;

    public d(com.google.gson.internal.b bVar) {
        this.koi = bVar;
    }

    @Override // com.google.gson.o
    public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.cKE().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (n<T>) a(this.koi, dVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n<?> a(com.google.gson.internal.b bVar, com.google.gson.d dVar, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        n<?> kVar;
        Object cKl = bVar.b(com.google.gson.b.a.C(bVar2.value())).cKl();
        if (cKl instanceof n) {
            kVar = (n) cKl;
        } else if (cKl instanceof o) {
            kVar = ((o) cKl).a(dVar, aVar);
        } else if ((cKl instanceof com.google.gson.m) || (cKl instanceof com.google.gson.g)) {
            kVar = new k<>(cKl instanceof com.google.gson.m ? (com.google.gson.m) cKl : null, cKl instanceof com.google.gson.g ? (com.google.gson.g) cKl : null, dVar, aVar, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (kVar != null && bVar2.cKi()) {
            return kVar.cKf();
        }
        return kVar;
    }
}
