package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.resource.bitmap.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class s implements com.kwad.sdk.glide.load.f<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final k f10594a;

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f10595b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements k.a {

        /* renamed from: a  reason: collision with root package name */
        private final RecyclableBufferedInputStream f10596a;

        /* renamed from: b  reason: collision with root package name */
        private final com.kwad.sdk.glide.g.d f10597b;

        a(RecyclableBufferedInputStream recyclableBufferedInputStream, com.kwad.sdk.glide.g.d dVar) {
            this.f10596a = recyclableBufferedInputStream;
            this.f10597b = dVar;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
        public void a() {
            this.f10596a.a();
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
        public void a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) {
            IOException a2 = this.f10597b.a();
            if (a2 != null) {
                if (bitmap != null) {
                    eVar.a(bitmap);
                }
                throw a2;
            }
        }
    }

    public s(k kVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f10594a = kVar;
        this.f10595b = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(@NonNull InputStream inputStream, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        boolean z;
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            z = true;
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f10595b);
        }
        com.kwad.sdk.glide.g.d a2 = com.kwad.sdk.glide.g.d.a(recyclableBufferedInputStream);
        try {
            return this.f10594a.a(new com.kwad.sdk.glide.g.h(a2), i, i2, eVar, new a(recyclableBufferedInputStream, a2));
        } finally {
            a2.b();
            if (z) {
                recyclableBufferedInputStream.b();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f10594a.a(inputStream);
    }
}
