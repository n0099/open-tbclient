package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class b<Data> implements n<byte[], Data> {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0430b<Data> f35673a;

    /* loaded from: classes6.dex */
    public static class a implements o<byte[], ByteBuffer> {
        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<byte[], ByteBuffer> a(@NonNull r rVar) {
            return new b(new InterfaceC0430b<ByteBuffer>() { // from class: com.kwad.sdk.glide.load.b.b.a.1
                @Override // com.kwad.sdk.glide.load.b.b.InterfaceC0430b
                public Class<ByteBuffer> a() {
                    return ByteBuffer.class;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.glide.load.b.b.InterfaceC0430b
                /* renamed from: a */
                public ByteBuffer b(byte[] bArr) {
                    return ByteBuffer.wrap(bArr);
                }
            });
        }
    }

    /* renamed from: com.kwad.sdk.glide.load.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0430b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    /* loaded from: classes6.dex */
    public static class c<Data> implements com.kwad.sdk.glide.load.a.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f35675a;

        /* renamed from: b  reason: collision with root package name */
        public final InterfaceC0430b<Data> f35676b;

        public c(byte[] bArr, InterfaceC0430b<Data> interfaceC0430b) {
            this.f35675a = bArr;
            this.f35676b = interfaceC0430b;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public Class<Data> a() {
            return this.f35676b.a();
        }

        /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: Data, ? super Data */
        @Override // com.kwad.sdk.glide.load.a.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            aVar.a((d.a<? super Data>) ((Data) this.f35676b.b(this.f35675a)));
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

    /* loaded from: classes6.dex */
    public static class d implements o<byte[], InputStream> {
        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<byte[], InputStream> a(@NonNull r rVar) {
            return new b(new InterfaceC0430b<InputStream>() { // from class: com.kwad.sdk.glide.load.b.b.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.glide.load.b.b.InterfaceC0430b
                /* renamed from: a */
                public InputStream b(byte[] bArr) {
                    return new ByteArrayInputStream(bArr);
                }

                @Override // com.kwad.sdk.glide.load.b.b.InterfaceC0430b
                public Class<InputStream> a() {
                    return InputStream.class;
                }
            });
        }
    }

    public b(InterfaceC0430b<Data> interfaceC0430b) {
        this.f35673a = interfaceC0430b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull byte[] bArr, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return new n.a<>(new com.kwad.sdk.glide.f.b(bArr), new c(bArr, this.f35673a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull byte[] bArr) {
        return true;
    }
}
