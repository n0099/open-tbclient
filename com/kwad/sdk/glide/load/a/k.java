package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.a.e;
import com.kwad.sdk.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;
/* loaded from: classes7.dex */
public final class k implements e<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclableBufferedInputStream f36049a;

    /* loaded from: classes7.dex */
    public static final class a implements e.a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f36050a;

        public a(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
            this.f36050a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.a.e.a
        @NonNull
        public e<InputStream> a(InputStream inputStream) {
            return new k(inputStream, this.f36050a);
        }

        @Override // com.kwad.sdk.glide.load.a.e.a
        @NonNull
        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    public k(InputStream inputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        this.f36049a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(5242880);
    }

    @Override // com.kwad.sdk.glide.load.a.e
    public void b() {
        this.f36049a.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.a.e
    @NonNull
    /* renamed from: c */
    public InputStream a() {
        this.f36049a.reset();
        return this.f36049a;
    }
}
