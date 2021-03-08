package com.kwad.sdk.glide.load.b;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class f<Data> implements n<File, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final d<Data> f6674a;

    /* loaded from: classes3.dex */
    public static class a<Data> implements o<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final d<Data> f6675a;

        public a(d<Data> dVar) {
            this.f6675a = dVar;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public final n<File, Data> a(@NonNull r rVar) {
            return new f(this.f6675a);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new d<ParcelFileDescriptor>() { // from class: com.kwad.sdk.glide.load.b.f.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.glide.load.b.f.d
                /* renamed from: a */
                public ParcelFileDescriptor b(File file) {
                    return ParcelFileDescriptor.open(file, 268435456);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class c<Data> implements com.kwad.sdk.glide.load.a.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final File f6676a;
        private final d<Data> b;
        private Data c;

        c(File file, d<Data> dVar) {
            this.f6676a = file;
            this.b = dVar;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public Class<Data> a() {
            return this.b.a();
        }

        /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: Data, ? super Data */
        @Override // com.kwad.sdk.glide.load.a.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                this.c = this.b.b(this.f6676a);
                aVar.a((d.a<? super Data>) ((Data) this.c));
            } catch (FileNotFoundException e) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e);
                }
                aVar.a((Exception) e);
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void b() {
            if (this.c != null) {
                try {
                    this.b.a(this.c);
                } catch (IOException e) {
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

    /* loaded from: classes3.dex */
    public interface d<Data> {
        Class<Data> a();

        void a(Data data);

        Data b(File file);
    }

    /* loaded from: classes3.dex */
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
        this.f6674a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull File file, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return new n.a<>(new com.kwad.sdk.glide.f.b(file), new c(file, this.f6674a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull File file) {
        return true;
    }
}
