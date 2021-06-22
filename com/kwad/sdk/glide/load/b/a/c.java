package com.kwad.sdk.glide.load.b.a;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.b.o;
import com.kwad.sdk.glide.load.b.r;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class c implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f36064a;

    /* loaded from: classes7.dex */
    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f36066a;

        public a(Context context) {
            this.f36066a = context;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new c(this.f36066a);
        }
    }

    public c(Context context) {
        this.f36064a = context.getApplicationContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<InputStream> a(@NonNull Uri uri, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        if (com.kwad.sdk.glide.load.a.a.b.a(i2, i3)) {
            return new n.a<>(new com.kwad.sdk.glide.f.b(uri), com.kwad.sdk.glide.load.a.a.c.a(this.f36064a, uri));
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Uri uri) {
        return com.kwad.sdk.glide.load.a.a.b.c(uri);
    }
}
