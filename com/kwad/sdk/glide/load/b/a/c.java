package com.kwad.sdk.glide.load.b.a;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.b.o;
import com.kwad.sdk.glide.load.b.r;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class c implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f10364a;

    /* loaded from: classes5.dex */
    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f10366a;

        public a(Context context) {
            this.f10366a = context;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new c(this.f10366a);
        }
    }

    public c(Context context) {
        this.f10364a = context.getApplicationContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<InputStream> a(@NonNull Uri uri, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        if (com.kwad.sdk.glide.load.a.a.b.a(i, i2)) {
            return new n.a<>(new com.kwad.sdk.glide.f.b(uri), com.kwad.sdk.glide.load.a.a.c.a(this.f10364a, uri));
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Uri uri) {
        return com.kwad.sdk.glide.load.a.a.b.c(uri);
    }
}
