package com.bytedance.sdk.openadsdk.preload.b;
/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public Class<? extends d> f30766a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.b.b.a f30767b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f30768c;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Class<? extends d> f30769a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.b.b.a f30770b;

        /* renamed from: c  reason: collision with root package name */
        public Object[] f30771c;

        public static a a() {
            return new a();
        }

        public h b() {
            return new h(this);
        }

        public a a(Class<? extends d> cls) {
            if (cls != null) {
                this.f30769a = cls;
                return this;
            }
            throw new IllegalArgumentException("interceptor class == null");
        }

        public a a(com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
            this.f30770b = aVar;
            return this;
        }

        public a a(Object... objArr) {
            if (objArr != null) {
                this.f30771c = objArr;
                return this;
            }
            throw new IllegalArgumentException("args == null");
        }
    }

    public Class<? extends d> a() {
        return this.f30766a;
    }

    public com.bytedance.sdk.openadsdk.preload.b.b.a b() {
        return this.f30767b;
    }

    public Object[] c() {
        return this.f30768c;
    }

    public h(a aVar) {
        this.f30766a = aVar.f30769a;
        this.f30767b = aVar.f30770b;
        this.f30768c = aVar.f30771c;
        if (this.f30766a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }
}
