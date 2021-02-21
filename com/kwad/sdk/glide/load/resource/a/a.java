package com.kwad.sdk.glide.load.resource.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.a.e;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class a implements e<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f10258a;

    /* renamed from: com.kwad.sdk.glide.load.resource.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1134a implements e.a<ByteBuffer> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.a.e.a
        @NonNull
        public e<ByteBuffer> a(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        @Override // com.kwad.sdk.glide.load.a.e.a
        @NonNull
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f10258a = byteBuffer;
    }

    @Override // com.kwad.sdk.glide.load.a.e
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.a.e
    @NonNull
    /* renamed from: c */
    public ByteBuffer a() {
        this.f10258a.position(0);
        return this.f10258a;
    }
}
