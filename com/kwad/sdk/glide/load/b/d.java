package com.kwad.sdk.glide.load.b;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class d implements n<File, ByteBuffer> {

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.glide.load.a.d<ByteBuffer> {

        /* renamed from: a  reason: collision with root package name */
        public final File f35678a;

        public a(File file) {
            this.f35678a = file;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super ByteBuffer> aVar) {
            try {
                aVar.a((d.a<? super ByteBuffer>) com.kwad.sdk.glide.g.a.a(this.f35678a));
            } catch (IOException e2) {
                if (Log.isLoggable(ByteBufferFileLoader.TAG, 3)) {
                    Log.d(ByteBufferFileLoader.TAG, "Failed to obtain ByteBuffer for file", e2);
                }
                aVar.a((Exception) e2);
            }
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
    public static class b implements o<File, ByteBuffer> {
        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<File, ByteBuffer> a(@NonNull r rVar) {
            return new d();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<ByteBuffer> a(@NonNull File file, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return new n.a<>(new com.kwad.sdk.glide.f.b(file), new a(file));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull File file) {
        return true;
    }
}
