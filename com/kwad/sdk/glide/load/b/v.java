package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
/* loaded from: classes3.dex */
public class v<Model> implements n<Model, Model> {

    /* renamed from: a  reason: collision with root package name */
    private static final v<?> f6701a = new v<>();

    /* loaded from: classes3.dex */
    public static class a<Model> implements o<Model, Model> {

        /* renamed from: a  reason: collision with root package name */
        private static final a<?> f6702a = new a<>();

        public static <T> a<T> a() {
            return (a<T>) f6702a;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Model, Model> a(r rVar) {
            return v.a();
        }
    }

    /* loaded from: classes3.dex */
    private static class b<Model> implements com.kwad.sdk.glide.load.a.d<Model> {

        /* renamed from: a  reason: collision with root package name */
        private final Model f6703a;

        b(Model model) {
            this.f6703a = model;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public Class<Model> a() {
            return (Class<Model>) this.f6703a.getClass();
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: Model, ? super Model */
        @Override // com.kwad.sdk.glide.load.a.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super Model> aVar) {
            aVar.a((d.a<? super Model>) ((Model) this.f6703a));
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

    public static <T> v<T> a() {
        return (v<T>) f6701a;
    }

    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Model> a(@NonNull Model model, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return new n.a<>(new com.kwad.sdk.glide.f.b(model), new b(model));
    }

    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Model model) {
        return true;
    }
}
