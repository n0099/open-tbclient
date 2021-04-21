package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.a.e;
import com.kwad.sdk.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;
/* loaded from: classes6.dex */
public final class k implements e<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclableBufferedInputStream f35652a;

    /* loaded from: classes6.dex */
    public static final class a implements e.a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f35653a;

        public a(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
            this.f35653a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.a.e.a
        @NonNull
        public e<InputStream> a(InputStream inputStream) {
            return new k(inputStream, this.f35653a);
        }

        @Override // com.kwad.sdk.glide.load.a.e.a
        @NonNull
        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    public k(InputStream inputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        this.f35652a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(5242880);
    }

    @Override // com.kwad.sdk.glide.load.a.e
    public void b() {
        this.f35652a.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.a.e
    @NonNull
    /* renamed from: c */
    public InputStream a() {
        this.f35652a.reset();
        return this.f35652a;
    }
}
