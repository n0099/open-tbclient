package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
/* loaded from: classes2.dex */
public final class d implements p {
    private final com.google.gson.internal.b iwa;

    public d(com.google.gson.internal.b bVar) {
        this.iwa = bVar;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.cbJ().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (o<T>) a(this.iwa, dVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o<?> a(com.google.gson.internal.b bVar, com.google.gson.d dVar, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        o<?> lVar;
        Object cbl = bVar.b(com.google.gson.b.a.C(bVar2.value())).cbl();
        if (cbl instanceof o) {
            lVar = (o) cbl;
        } else if (cbl instanceof p) {
            lVar = ((p) cbl).a(dVar, aVar);
        } else if ((cbl instanceof com.google.gson.n) || (cbl instanceof com.google.gson.h)) {
            lVar = new l<>(cbl instanceof com.google.gson.n ? (com.google.gson.n) cbl : null, cbl instanceof com.google.gson.h ? (com.google.gson.h) cbl : null, dVar, aVar, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (lVar != null && bVar2.cbi()) {
            return lVar.cbf();
        }
        return lVar;
    }
}
