package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
import java.net.URL;
/* loaded from: classes.dex */
final class ai extends com.google.gson.aa {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public URL b(com.google.gson.stream.a aVar) {
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            return null;
        }
        String h = aVar.h();
        if ("null".equals(h)) {
            return null;
        }
        return new URL(h);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, URL url) {
        dVar.b(url == null ? null : url.toExternalForm());
    }
}
