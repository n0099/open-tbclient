package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import com.baidubce.services.bos.BosClientConfiguration;
import com.kwad.sdk.glide.load.a.e;
import com.kwad.sdk.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;
/* loaded from: classes5.dex */
public final class k implements e<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclableBufferedInputStream f10352a;

    /* loaded from: classes5.dex */
    public static final class a implements e.a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f10353a;

        public a(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
            this.f10353a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.a.e.a
        @NonNull
        public e<InputStream> a(InputStream inputStream) {
            return new k(inputStream, this.f10353a);
        }

        @Override // com.kwad.sdk.glide.load.a.e.a
        @NonNull
        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    k(InputStream inputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f10352a = new RecyclableBufferedInputStream(inputStream, bVar);
        this.f10352a.mark(BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE);
    }

    @Override // com.kwad.sdk.glide.load.a.e
    public void b() {
        this.f10352a.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.a.e
    @NonNull
    /* renamed from: c */
    public InputStream a() {
        this.f10352a.reset();
        return this.f10352a;
    }
}
