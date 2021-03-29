package com.bytedance.sdk.openadsdk.preload.b;
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public Class<? extends d> f30160a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.b.b.a f30161b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f30162c;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Class<? extends d> f30163a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.b.b.a f30164b;

        /* renamed from: c  reason: collision with root package name */
        public Object[] f30165c;

        public static a a() {
            return new a();
        }

        public h b() {
            return new h(this);
        }

        public a a(Class<? extends d> cls) {
            if (cls != null) {
                this.f30163a = cls;
                return this;
            }
            throw new IllegalArgumentException("interceptor class == null");
        }

        public a a(com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
            this.f30164b = aVar;
            return this;
        }

        public a a(Object... objArr) {
            if (objArr != null) {
                this.f30165c = objArr;
                return this;
            }
            throw new IllegalArgumentException("args == null");
        }
    }

    public Class<? extends d> a() {
        return this.f30160a;
    }

    public com.bytedance.sdk.openadsdk.preload.b.b.a b() {
        return this.f30161b;
    }

    public Object[] c() {
        return this.f30162c;
    }

    public h(a aVar) {
        this.f30160a = aVar.f30163a;
        this.f30161b = aVar.f30164b;
        this.f30162c = aVar.f30165c;
        if (this.f30160a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }
}
