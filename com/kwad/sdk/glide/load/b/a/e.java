package com.kwad.sdk.glide.load.b.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.b.g;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.b.o;
import com.kwad.sdk.glide.load.b.r;
import java.io.InputStream;
import java.net.URL;
/* loaded from: classes7.dex */
public class e implements n<URL, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final n<g, InputStream> f35971a;

    /* loaded from: classes7.dex */
    public static class a implements o<URL, InputStream> {
        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<URL, InputStream> a(r rVar) {
            return new e(rVar.a(g.class, InputStream.class));
        }
    }

    public e(n<g, InputStream> nVar) {
        this.f35971a = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<InputStream> a(@NonNull URL url, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f35971a.a(new g(url), i2, i3, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull URL url) {
        return true;
    }
}
