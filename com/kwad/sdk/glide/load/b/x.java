package com.kwad.sdk.glide.load.b;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.b.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class x<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f36156a = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: b  reason: collision with root package name */
    public final n<g, Data> f36157b;

    /* loaded from: classes7.dex */
    public static class a implements o<Uri, InputStream> {
        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new x(rVar.a(g.class, InputStream.class));
        }
    }

    public x(n<g, Data> nVar) {
        this.f36157b = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull Uri uri, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f36157b.a(new g(uri.toString()), i2, i3, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Uri uri) {
        return f36156a.contains(uri.getScheme());
    }
}
