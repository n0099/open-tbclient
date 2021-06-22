package com.bytedance.sdk.openadsdk.preload.b;
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public Class<? extends d> f30125a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.b.b.a f30126b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f30127c;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Class<? extends d> f30128a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.b.b.a f30129b;

        /* renamed from: c  reason: collision with root package name */
        public Object[] f30130c;

        public static a a() {
            return new a();
        }

        public h b() {
            return new h(this);
        }

        public a a(Class<? extends d> cls) {
            if (cls != null) {
                this.f30128a = cls;
                return this;
            }
            throw new IllegalArgumentException("interceptor class == null");
        }

        public a a(com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
            this.f30129b = aVar;
            return this;
        }

        public a a(Object... objArr) {
            if (objArr != null) {
                this.f30130c = objArr;
                return this;
            }
            throw new IllegalArgumentException("args == null");
        }
    }

    public Class<? extends d> a() {
        return this.f30125a;
    }

    public com.bytedance.sdk.openadsdk.preload.b.b.a b() {
        return this.f30126b;
    }

    public Object[] c() {
        return this.f30127c;
    }

    public h(a aVar) {
        this.f30125a = aVar.f30128a;
        this.f30126b = aVar.f30129b;
        this.f30127c = aVar.f30130c;
        if (this.f30125a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }
}
