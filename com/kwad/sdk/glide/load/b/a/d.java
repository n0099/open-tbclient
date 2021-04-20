package com.kwad.sdk.glide.load.b.a;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.b.o;
import com.kwad.sdk.glide.load.b.r;
import com.kwad.sdk.glide.load.resource.bitmap.v;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class d implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f35575a;

    /* loaded from: classes6.dex */
    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f35576a;

        public a(Context context) {
            this.f35576a = context;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new d(this.f35576a);
        }
    }

    public d(Context context) {
        this.f35575a = context.getApplicationContext();
    }

    private boolean a(com.kwad.sdk.glide.load.e eVar) {
        Long l = (Long) eVar.a(v.f35987a);
        return l != null && l.longValue() == -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    @Nullable
    public n.a<InputStream> a(@NonNull Uri uri, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        if (com.kwad.sdk.glide.load.a.a.b.a(i, i2) && a(eVar)) {
            return new n.a<>(new com.kwad.sdk.glide.f.b(uri), com.kwad.sdk.glide.load.a.a.c.b(this.f35575a, uri));
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Uri uri) {
        return com.kwad.sdk.glide.load.a.a.b.b(uri);
    }
}
