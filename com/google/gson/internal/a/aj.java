package com.google.gson.internal.a;

import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonToken;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes.dex */
final class aj extends com.google.gson.aa {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public URI b(com.google.gson.stream.a aVar) {
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            return null;
        }
        try {
            String h = aVar.h();
            if ("null".equals(h)) {
                return null;
            }
            return new URI(h);
        } catch (URISyntaxException e) {
            throw new JsonIOException(e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, URI uri) {
        dVar.b(uri == null ? null : uri.toASCIIString());
    }
}
