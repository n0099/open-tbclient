package com.kwad.sdk.glide.load.engine.a;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.kwad.sdk.glide.g.a.a;
import com.kwad.sdk.glide.g.k;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.glide.g.g<com.kwad.sdk.glide.load.c, String> f6731a = new com.kwad.sdk.glide.g.g<>(1000);
    private final Pools.Pool<a> b = com.kwad.sdk.glide.g.a.a.a(10, new a.InterfaceC1142a<a>() { // from class: com.kwad.sdk.glide.load.engine.a.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.g.a.a.InterfaceC1142a
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
    /* loaded from: classes3.dex */
    public static final class a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final MessageDigest f6733a;
        private final com.kwad.sdk.glide.g.a.c b = com.kwad.sdk.glide.g.a.c.a();

        a(MessageDigest messageDigest) {
            this.f6733a = messageDigest;
        }

        @Override // com.kwad.sdk.glide.g.a.a.c
        @NonNull
        public com.kwad.sdk.glide.g.a.c d() {
            return this.b;
        }
    }

    private String b(com.kwad.sdk.glide.load.c cVar) {
        a aVar = (a) com.kwad.sdk.glide.g.j.a(this.b.acquire());
        try {
            cVar.a(aVar.f6733a);
            return k.a(aVar.f6733a.digest());
        } finally {
            this.b.release(aVar);
        }
    }

    public String a(com.kwad.sdk.glide.load.c cVar) {
        String b;
        synchronized (this.f6731a) {
            b = this.f6731a.b(cVar);
        }
        if (b == null) {
            b = b(cVar);
        }
        synchronized (this.f6731a) {
            this.f6731a.b(cVar, b);
        }
        return b;
    }
}
