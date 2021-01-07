package com.kwad.sdk.glide.load.b;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public final class e<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Data> f10377a;

    /* loaded from: classes5.dex */
    public interface a<Data> {
        Class<Data> a();

        Data a(String str);

        void a(Data data);
    }

    /* loaded from: classes5.dex */
    private static final class b<Data> implements com.kwad.sdk.glide.load.a.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final String f10378a;

        /* renamed from: b  reason: collision with root package name */
        private final a<Data> f10379b;
        private Data c;

        b(String str, a<Data> aVar) {
            this.f10378a = str;
            this.f10379b = aVar;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public Class<Data> a() {
            return this.f10379b.a();
        }

        /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: Data, ? super Data */
        @Override // com.kwad.sdk.glide.load.a.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                this.c = this.f10379b.a(this.f10378a);
                aVar.a((d.a<? super Data>) ((Data) this.c));
            } catch (IllegalArgumentException e) {
                aVar.a((Exception) e);
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void b() {
            try {
                this.f10379b.a((a<Data>) this.c);
            } catch (IOException e) {
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

    /* loaded from: classes5.dex */
    public static final class c<Model> implements o<Model, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final a<InputStream> f10380a = new a<InputStream>() { // from class: com.kwad.sdk.glide.load.b.e.c.1
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
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    }
                    if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    }
                    throw new IllegalArgumentException("Not a base64 image data URL.");
                }
                throw new IllegalArgumentException("Not a valid image data URL.");
            }
        };

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Model, InputStream> a(@NonNull r rVar) {
            return new e(this.f10380a);
        }
    }

    public e(a<Data> aVar) {
        this.f10377a = aVar;
    }

    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull Model model, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return new n.a<>(new com.kwad.sdk.glide.f.b(model), new b(model.toString(), this.f10377a));
    }

    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Model model) {
        return model.toString().startsWith("data:image");
    }
}
