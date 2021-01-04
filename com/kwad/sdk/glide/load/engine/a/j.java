package com.kwad.sdk.glide.load.engine.a;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.kwad.sdk.glide.g.a.a;
import com.kwad.sdk.glide.g.k;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.glide.g.g<com.kwad.sdk.glide.load.c, String> f10471a = new com.kwad.sdk.glide.g.g<>(1000);

    /* renamed from: b  reason: collision with root package name */
    private final Pools.Pool<a> f10472b = com.kwad.sdk.glide.g.a.a.a(10, new a.InterfaceC1095a<a>() { // from class: com.kwad.sdk.glide.load.engine.a.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.g.a.a.InterfaceC1095a
        /* renamed from: a */
        public a b() {
            try {
                return new a(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final MessageDigest f10474a;

        /* renamed from: b  reason: collision with root package name */
        private final com.kwad.sdk.glide.g.a.c f10475b = com.kwad.sdk.glide.g.a.c.a();

        a(MessageDigest messageDigest) {
            this.f10474a = messageDigest;
        }

        @Override // com.kwad.sdk.glide.g.a.a.c
        @NonNull
        public com.kwad.sdk.glide.g.a.c d() {
            return this.f10475b;
        }
    }

    private String b(com.kwad.sdk.glide.load.c cVar) {
        a aVar = (a) com.kwad.sdk.glide.g.j.a(this.f10472b.acquire());
        try {
            cVar.a(aVar.f10474a);
            return k.a(aVar.f10474a.digest());
        } finally {
            this.f10472b.release(aVar);
        }
    }

    public String a(com.kwad.sdk.glide.load.c cVar) {
        String b2;
        synchronized (this.f10471a) {
            b2 = this.f10471a.b(cVar);
        }
        if (b2 == null) {
            b2 = b(cVar);
        }
        synchronized (this.f10471a) {
            this.f10471a.b(cVar, b2);
        }
        return b2;
    }
}
