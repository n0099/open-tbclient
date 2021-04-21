package com.kwad.sdk.glide.load.engine.a;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.kwad.sdk.glide.g.a.a;
import com.kwad.sdk.glide.g.k;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.g.g<com.kwad.sdk.glide.load.c, String> f35830a = new com.kwad.sdk.glide.g.g<>(1000);

    /* renamed from: b  reason: collision with root package name */
    public final Pools.Pool<a> f35831b = com.kwad.sdk.glide.g.a.a.a(10, new a.InterfaceC0427a<a>() { // from class: com.kwad.sdk.glide.load.engine.a.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.g.a.a.InterfaceC0427a
        /* renamed from: a */
        public a b() {
            try {
                return new a(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    });

    /* loaded from: classes6.dex */
    public static final class a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        public final MessageDigest f35833a;

        /* renamed from: b  reason: collision with root package name */
        public final com.kwad.sdk.glide.g.a.c f35834b = com.kwad.sdk.glide.g.a.c.a();

        public a(MessageDigest messageDigest) {
            this.f35833a = messageDigest;
        }

        @Override // com.kwad.sdk.glide.g.a.a.c
        @NonNull
        public com.kwad.sdk.glide.g.a.c d() {
            return this.f35834b;
        }
    }

    private String b(com.kwad.sdk.glide.load.c cVar) {
        a aVar = (a) com.kwad.sdk.glide.g.j.a(this.f35831b.acquire());
        try {
            cVar.a(aVar.f35833a);
            return k.a(aVar.f35833a.digest());
        } finally {
            this.f35831b.release(aVar);
        }
    }

    public String a(com.kwad.sdk.glide.load.c cVar) {
        String b2;
        synchronized (this.f35830a) {
            b2 = this.f35830a.b(cVar);
        }
        if (b2 == null) {
            b2 = b(cVar);
        }
        synchronized (this.f35830a) {
            this.f35830a.b(cVar, b2);
        }
        return b2;
    }
}
