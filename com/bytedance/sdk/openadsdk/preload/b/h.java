package com.bytedance.sdk.openadsdk.preload.b;
/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public Class<? extends d> f29853a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.b.b.a f29854b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f29855c;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Class<? extends d> f29856a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.b.b.a f29857b;

        /* renamed from: c  reason: collision with root package name */
        public Object[] f29858c;

        public static a a() {
            return new a();
        }

        public h b() {
            return new h(this);
        }

        public a a(Class<? extends d> cls) {
            if (cls != null) {
                this.f29856a = cls;
                return this;
            }
            throw new IllegalArgumentException("interceptor class == null");
        }

        public a a(com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
            this.f29857b = aVar;
            return this;
        }

        public a a(Object... objArr) {
            if (objArr != null) {
                this.f29858c = objArr;
                return this;
            }
            throw new IllegalArgumentException("args == null");
        }
    }

    public Class<? extends d> a() {
        return this.f29853a;
    }

    public com.bytedance.sdk.openadsdk.preload.b.b.a b() {
        return this.f29854b;
    }

    public Object[] c() {
        return this.f29855c;
    }

    public h(a aVar) {
        this.f29853a = aVar.f29856a;
        this.f29854b = aVar.f29857b;
        this.f29855c = aVar.f29858c;
        if (this.f29853a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }
}
