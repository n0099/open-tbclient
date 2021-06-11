package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
/* loaded from: classes7.dex */
public class v<Model> implements n<Model, Model> {

    /* renamed from: a  reason: collision with root package name */
    public static final v<?> f36050a = new v<>();

    /* loaded from: classes7.dex */
    public static class a<Model> implements o<Model, Model> {

        /* renamed from: a  reason: collision with root package name */
        public static final a<?> f36051a = new a<>();

        public static <T> a<T> a() {
            return (a<T>) f36051a;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Model, Model> a(r rVar) {
            return v.a();
        }
    }

    /* loaded from: classes7.dex */
    public static class b<Model> implements com.kwad.sdk.glide.load.a.d<Model> {

        /* renamed from: a  reason: collision with root package name */
        public final Model f36052a;

        public b(Model model) {
            this.f36052a = model;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public Class<Model> a() {
            return (Class<Model>) this.f36052a.getClass();
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: Model, ? super Model */
        @Override // com.kwad.sdk.glide.load.a.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super Model> aVar) {
            aVar.a((d.a<? super Model>) ((Model) this.f36052a));
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
        return (v<T>) f36050a;
    }

    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Model> a(@NonNull Model model, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return new n.a<>(new com.kwad.sdk.glide.f.b(model), new b(model));
    }

    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Model model) {
        return true;
    }
}
