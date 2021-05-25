package com.bytedance.sdk.openadsdk.preload.b;
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public Class<? extends d> f29940a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.b.b.a f29941b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f29942c;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Class<? extends d> f29943a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.b.b.a f29944b;

        /* renamed from: c  reason: collision with root package name */
        public Object[] f29945c;

        public static a a() {
            return new a();
        }

        public h b() {
            return new h(this);
        }

        public a a(Class<? extends d> cls) {
            if (cls != null) {
                this.f29943a = cls;
                return this;
            }
            throw new IllegalArgumentException("interceptor class == null");
        }

        public a a(com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
            this.f29944b = aVar;
            return this;
        }

        public a a(Object... objArr) {
            if (objArr != null) {
                this.f29945c = objArr;
                return this;
            }
            throw new IllegalArgumentException("args == null");
        }
    }

    public Class<? extends d> a() {
        return this.f29940a;
    }

    public com.bytedance.sdk.openadsdk.preload.b.b.a b() {
        return this.f29941b;
    }

    public Object[] c() {
        return this.f29942c;
    }

    public h(a aVar) {
        this.f29940a = aVar.f29943a;
        this.f29941b = aVar.f29944b;
        this.f29942c = aVar.f29945c;
        if (this.f29940a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }
}
