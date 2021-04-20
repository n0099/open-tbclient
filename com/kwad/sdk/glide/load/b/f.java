package com.kwad.sdk.glide.load.b;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.asm.Label;
import com.bumptech.glide.load.model.FileLoader;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class f<Data> implements n<File, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final d<Data> f35590a;

    /* loaded from: classes6.dex */
    public static class a<Data> implements o<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        public final d<Data> f35591a;

        public a(d<Data> dVar) {
            this.f35591a = dVar;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public final n<File, Data> a(@NonNull r rVar) {
            return new f(this.f35591a);
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new d<ParcelFileDescriptor>() { // from class: com.kwad.sdk.glide.load.b.f.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.glide.load.b.f.d
                /* renamed from: a */
                public ParcelFileDescriptor b(File file) {
                    return ParcelFileDescriptor.open(file, Label.FORWARD_REFERENCE_TYPE_SHORT);
                }

                @Override // com.kwad.sdk.glide.load.b.f.d
                public Class<ParcelFileDescriptor> a() {
                    return ParcelFileDescriptor.class;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.glide.load.b.f.d
                public void a(ParcelFileDescriptor parcelFileDescriptor) {
                    parcelFileDescriptor.close();
                }
            });
        }
    }

    /* loaded from: classes6.dex */
    public static final class c<Data> implements com.kwad.sdk.glide.load.a.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final File f35592a;

        /* renamed from: b  reason: collision with root package name */
        public final d<Data> f35593b;

        /* renamed from: c  reason: collision with root package name */
        public Data f35594c;

        public c(File file, d<Data> dVar) {
            this.f35592a = file;
            this.f35593b = dVar;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public Class<Data> a() {
            return this.f35593b.a();
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, Data] */
        @Override // com.kwad.sdk.glide.load.a.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                Data b2 = this.f35593b.b(this.f35592a);
                this.f35594c = b2;
                aVar.a((d.a<? super Data>) b2);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable(FileLoader.TAG, 3)) {
                    Log.d(FileLoader.TAG, "Failed to open file", e2);
                }
                aVar.a((Exception) e2);
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void b() {
            Data data = this.f35594c;
            if (data != null) {
                try {
                    this.f35593b.a(data);
                } catch (IOException unused) {
                }
            }
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
    public interface d<Data> {
        Class<Data> a();

        void a(Data data);

        Data b(File file);
    }

    /* loaded from: classes6.dex */
    public static class e extends a<InputStream> {
        public e() {
            super(new d<InputStream>() { // from class: com.kwad.sdk.glide.load.b.f.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.glide.load.b.f.d
                /* renamed from: a */
                public InputStream b(File file) {
                    return new FileInputStream(file);
                }

                @Override // com.kwad.sdk.glide.load.b.f.d
                public Class<InputStream> a() {
                    return InputStream.class;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.glide.load.b.f.d
                public void a(InputStream inputStream) {
                    inputStream.close();
                }
            });
        }
    }

    public f(d<Data> dVar) {
        this.f35590a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull File file, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return new n.a<>(new com.kwad.sdk.glide.f.b(file), new c(file, this.f35590a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull File file) {
        return true;
    }
}
