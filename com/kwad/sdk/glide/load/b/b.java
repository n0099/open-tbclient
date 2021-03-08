package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class b<Data> implements n<byte[], Data> {

    /* renamed from: a  reason: collision with root package name */
    private final InterfaceC1145b<Data> f6665a;

    /* loaded from: classes3.dex */
    public static class a implements o<byte[], ByteBuffer> {
        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<byte[], ByteBuffer> a(@NonNull r rVar) {
            return new b(new InterfaceC1145b<ByteBuffer>() { // from class: com.kwad.sdk.glide.load.b.b.a.1
                @Override // com.kwad.sdk.glide.load.b.b.InterfaceC1145b
                public Class<ByteBuffer> a() {
                    return ByteBuffer.class;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.glide.load.b.b.InterfaceC1145b
                /* renamed from: a */
                public ByteBuffer b(byte[] bArr) {
                    return ByteBuffer.wrap(bArr);
                }
            });
        }
    }

    /* renamed from: com.kwad.sdk.glide.load.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1145b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c<Data> implements com.kwad.sdk.glide.load.a.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f6667a;
        private final InterfaceC1145b<Data> b;

        c(byte[] bArr, InterfaceC1145b<Data> interfaceC1145b) {
            this.f6667a = bArr;
            this.b = interfaceC1145b;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public Class<Data> a() {
            return this.b.a();
        }

        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: Data, ? super Data */
        @Override // com.kwad.sdk.glide.load.a.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            aVar.a((d.a<? super Data>) ((Data) this.b.b(this.f6667a)));
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void b() {
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void c() {
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public DataSource d() {
            return DataSource.LOCAL;
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements o<byte[], InputStream> {
        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<byte[], InputStream> a(@NonNull r rVar) {
            return new b(new InterfaceC1145b<InputStream>() { // from class: com.kwad.sdk.glide.load.b.b.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.glide.load.b.b.InterfaceC1145b
                /* renamed from: a */
                public InputStream b(byte[] bArr) {
                    return new ByteArrayInputStream(bArr);
                }

                @Override // com.kwad.sdk.glide.load.b.b.InterfaceC1145b
                public Class<InputStream> a() {
                    return InputStream.class;
                }
            });
        }
    }

    public b(InterfaceC1145b<Data> interfaceC1145b) {
        this.f6665a = interfaceC1145b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull byte[] bArr, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return new n.a<>(new com.kwad.sdk.glide.f.b(bArr), new c(bArr, this.f6665a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull byte[] bArr) {
        return true;
    }
}
