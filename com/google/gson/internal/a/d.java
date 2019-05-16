package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
/* loaded from: classes2.dex */
public final class d implements o {
    private final com.google.gson.internal.b kfj;

    public d(com.google.gson.internal.b bVar) {
        this.kfj = bVar;
    }

    @Override // com.google.gson.o
    public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.cJr().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (n<T>) a(this.kfj, dVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n<?> a(com.google.gson.internal.b bVar, com.google.gson.d dVar, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        n<?> kVar;
        Object cIY = bVar.b(com.google.gson.b.a.C(bVar2.value())).cIY();
        if (cIY instanceof n) {
            kVar = (n) cIY;
        } else if (cIY instanceof o) {
            kVar = ((o) cIY).a(dVar, aVar);
        } else if ((cIY instanceof com.google.gson.m) || (cIY instanceof com.google.gson.g)) {
            kVar = new k<>(cIY instanceof com.google.gson.m ? (com.google.gson.m) cIY : null, cIY instanceof com.google.gson.g ? (com.google.gson.g) cIY : null, dVar, aVar, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (kVar != null && bVar2.cIV()) {
            return kVar.cIS();
        }
        return kVar;
    }
}
