package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import com.baidubce.services.bos.BosClientConfiguration;
import com.kwad.sdk.glide.load.a.e;
import com.kwad.sdk.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;
/* loaded from: classes3.dex */
public final class k implements e<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclableBufferedInputStream f6650a;

    /* loaded from: classes3.dex */
    public static final class a implements e.a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f6651a;

        public a(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
            this.f6651a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.a.e.a
        @NonNull
        public e<InputStream> a(InputStream inputStream) {
            return new k(inputStream, this.f6651a);
        }

        @Override // com.kwad.sdk.glide.load.a.e.a
        @NonNull
        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    k(InputStream inputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f6650a = new RecyclableBufferedInputStream(inputStream, bVar);
        this.f6650a.mark(BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE);
    }

    @Override // com.kwad.sdk.glide.load.a.e
    public void b() {
        this.f6650a.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.a.e
    @NonNull
    /* renamed from: c */
    public InputStream a() {
        this.f6650a.reset();
        return this.f6650a;
    }
}
