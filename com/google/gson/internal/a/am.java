package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
import java.util.UUID;
/* loaded from: classes.dex */
final class am extends com.google.gson.aa {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public UUID b(com.google.gson.stream.a aVar) {
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            return null;
        }
        return UUID.fromString(aVar.h());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, UUID uuid) {
        dVar.b(uuid == null ? null : uuid.toString());
    }
}
