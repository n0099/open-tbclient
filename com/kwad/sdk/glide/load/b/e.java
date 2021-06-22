package com.kwad.sdk.glide.load.b;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public final class e<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final a<Data> f36076a;

    /* loaded from: classes7.dex */
    public interface a<Data> {
        Class<Data> a();

        Data a(String str);

        void a(Data data);
    }

    /* loaded from: classes7.dex */
    public static final class b<Data> implements com.kwad.sdk.glide.load.a.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final String f36077a;

        /* renamed from: b  reason: collision with root package name */
        public final a<Data> f36078b;

        /* renamed from: c  reason: collision with root package name */
        public Data f36079c;

        public b(String str, a<Data> aVar) {
            this.f36077a = str;
            this.f36078b = aVar;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public Class<Data> a() {
            return this.f36078b.a();
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, Data] */
        @Override // com.kwad.sdk.glide.load.a.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                Data a2 = this.f36078b.a(this.f36077a);
                this.f36079c = a2;
                aVar.a((d.a<? super Data>) a2);
            } catch (IllegalArgumentException e2) {
                aVar.a((Exception) e2);
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void b() {
            try {
                this.f36078b.a((a<Data>) this.f36079c);
            } catch (IOException unused) {
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

    /* loaded from: classes7.dex */
    public static final class c<Model> implements o<Model, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final a<InputStream> f36080a = new a<InputStream>() { // from class: com.kwad.sdk.glide.load.b.e.c.1
            @Override // com.kwad.sdk.glide.load.b.e.a
            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.glide.load.b.e.a
            public void a(InputStream inputStream) {
                inputStream.close();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.glide.load.b.e.a
            /* renamed from: b */
            public InputStream a(String str) {
                if (str.startsWith(DataUrlLoader.DATA_SCHEME_IMAGE)) {
                    int indexOf = str.indexOf(44);
                    if (indexOf != -1) {
                        if (str.substring(0, indexOf).endsWith(DataUrlLoader.BASE64_TAG)) {
                            return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                        }
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                throw new IllegalArgumentException("Not a valid image data URL.");
            }
        };

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Model, InputStream> a(@NonNull r rVar) {
            return new e(this.f36080a);
        }
    }

    public e(a<Data> aVar) {
        this.f36076a = aVar;
    }

    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull Model model, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return new n.a<>(new com.kwad.sdk.glide.f.b(model), new b(model.toString(), this.f36076a));
    }

    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Model model) {
        return model.toString().startsWith(DataUrlLoader.DATA_SCHEME_IMAGE);
    }
}
