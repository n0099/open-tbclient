package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
/* loaded from: classes2.dex */
public final class d implements o {
    private final com.google.gson.internal.b kpW;

    public d(com.google.gson.internal.b bVar) {
        this.kpW = bVar;
    }

    @Override // com.google.gson.o
    public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.cNH().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (n<T>) a(this.kpW, dVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n<?> a(com.google.gson.internal.b bVar, com.google.gson.d dVar, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        n<?> kVar;
        Object cNo = bVar.b(com.google.gson.b.a.E(bVar2.value())).cNo();
        if (cNo instanceof n) {
            kVar = (n) cNo;
        } else if (cNo instanceof o) {
            kVar = ((o) cNo).a(dVar, aVar);
        } else if ((cNo instanceof com.google.gson.m) || (cNo instanceof com.google.gson.g)) {
            kVar = new k<>(cNo instanceof com.google.gson.m ? (com.google.gson.m) cNo : null, cNo instanceof com.google.gson.g ? (com.google.gson.g) cNo : null, dVar, aVar, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (kVar != null && bVar2.cNl()) {
            return kVar.cNi();
        }
        return kVar;
    }
}
