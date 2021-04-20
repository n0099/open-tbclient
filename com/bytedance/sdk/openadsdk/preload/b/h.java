package com.bytedance.sdk.openadsdk.preload.b;
/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public Class<? extends d> f29845a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.b.b.a f29846b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f29847c;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Class<? extends d> f29848a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.b.b.a f29849b;

        /* renamed from: c  reason: collision with root package name */
        public Object[] f29850c;

        public static a a() {
            return new a();
        }

        public h b() {
            return new h(this);
        }

        public a a(Class<? extends d> cls) {
            if (cls != null) {
                this.f29848a = cls;
                return this;
            }
            throw new IllegalArgumentException("interceptor class == null");
        }

        public a a(com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
            this.f29849b = aVar;
            return this;
        }

        public a a(Object... objArr) {
            if (objArr != null) {
                this.f29850c = objArr;
                return this;
            }
            throw new IllegalArgumentException("args == null");
        }
    }

    public Class<? extends d> a() {
        return this.f29845a;
    }

    public com.bytedance.sdk.openadsdk.preload.b.b.a b() {
        return this.f29846b;
    }

    public Object[] c() {
        return this.f29847c;
    }

    public h(a aVar) {
        this.f29845a = aVar.f29848a;
        this.f29846b = aVar.f29849b;
        this.f29847c = aVar.f29850c;
        if (this.f29845a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }
}
