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
    private final com.kwad.sdk.glide.g.g<com.kwad.sdk.glide.load.c, String> f10472a = new com.kwad.sdk.glide.g.g<>(1000);

    /* renamed from: b  reason: collision with root package name */
    private final Pools.Pool<a> f10473b = com.kwad.sdk.glide.g.a.a.a(10, new a.InterfaceC1136a<a>() { // from class: com.kwad.sdk.glide.load.engine.a.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.g.a.a.InterfaceC1136a
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
        final MessageDigest f10475a;

        /* renamed from: b  reason: collision with root package name */
        private final com.kwad.sdk.glide.g.a.c f10476b = com.kwad.sdk.glide.g.a.c.a();

        a(MessageDigest messageDigest) {
            this.f10475a = messageDigest;
        }

        @Override // com.kwad.sdk.glide.g.a.a.c
        @NonNull
        public com.kwad.sdk.glide.g.a.c d() {
            return this.f10476b;
        }
    }

    private String b(com.kwad.sdk.glide.load.c cVar) {
        a aVar = (a) com.kwad.sdk.glide.g.j.a(this.f10473b.acquire());
        try {
            cVar.a(aVar.f10475a);
            return k.a(aVar.f10475a.digest());
        } finally {
            this.f10473b.release(aVar);
        }
    }

    public String a(com.kwad.sdk.glide.load.c cVar) {
        String b2;
        synchronized (this.f10472a) {
            b2 = this.f10472a.b(cVar);
        }
        if (b2 == null) {
            b2 = b(cVar);
        }
        synchronized (this.f10472a) {
            this.f10472a.b(cVar, b2);
        }
        return b2;
    }
}
