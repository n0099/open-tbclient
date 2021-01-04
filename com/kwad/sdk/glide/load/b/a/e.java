package com.kwad.sdk.glide.load.b.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.b.g;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.b.o;
import com.kwad.sdk.glide.load.b.r;
import java.io.InputStream;
import java.net.URL;
/* loaded from: classes5.dex */
public class e implements n<URL, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final n<g, InputStream> f10369a;

    /* loaded from: classes5.dex */
    public static class a implements o<URL, InputStream> {
        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<URL, InputStream> a(r rVar) {
            return new e(rVar.a(g.class, InputStream.class));
        }
    }

    public e(n<g, InputStream> nVar) {
        this.f10369a = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<InputStream> a(@NonNull URL url, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f10369a.a(new g(url), i, i2, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull URL url) {
        return true;
    }
}
