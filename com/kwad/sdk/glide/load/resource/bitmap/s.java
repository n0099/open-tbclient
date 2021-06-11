package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.resource.bitmap.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class s implements com.kwad.sdk.glide.load.f<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final k f36382a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f36383b;

    /* loaded from: classes7.dex */
    public static class a implements k.a {

        /* renamed from: a  reason: collision with root package name */
        public final RecyclableBufferedInputStream f36384a;

        /* renamed from: b  reason: collision with root package name */
        public final com.kwad.sdk.glide.g.d f36385b;

        public a(RecyclableBufferedInputStream recyclableBufferedInputStream, com.kwad.sdk.glide.g.d dVar) {
            this.f36384a = recyclableBufferedInputStream;
            this.f36385b = dVar;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
        public void a() {
            this.f36384a.a();
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
        public void a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) {
            IOException a2 = this.f36385b.a();
            if (a2 != null) {
                if (bitmap != null) {
                    eVar.a(bitmap);
                }
                throw a2;
            }
        }
    }

    public s(k kVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f36382a = kVar;
        this.f36383b = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(@NonNull InputStream inputStream, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f36383b);
            z = true;
        }
        com.kwad.sdk.glide.g.d a2 = com.kwad.sdk.glide.g.d.a(recyclableBufferedInputStream);
        try {
            return this.f36382a.a(new com.kwad.sdk.glide.g.h(a2), i2, i3, eVar, new a(recyclableBufferedInputStream, a2));
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
        return this.f36382a.a(inputStream);
    }
}
