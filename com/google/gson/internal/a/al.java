package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
import java.net.InetAddress;
/* loaded from: classes.dex */
final class al extends com.google.gson.aa {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public InetAddress b(com.google.gson.stream.a aVar) {
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            return null;
        }
        return InetAddress.getByName(aVar.h());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, InetAddress inetAddress) {
        dVar.b(inetAddress == null ? null : inetAddress.getHostAddress());
    }
}
