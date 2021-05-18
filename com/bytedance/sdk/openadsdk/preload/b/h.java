package com.bytedance.sdk.openadsdk.preload.b;
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public Class<? extends d> f30011a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.b.b.a f30012b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f30013c;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Class<? extends d> f30014a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.b.b.a f30015b;

        /* renamed from: c  reason: collision with root package name */
        public Object[] f30016c;

        public static a a() {
            return new a();
        }

        public h b() {
            return new h(this);
        }

        public a a(Class<? extends d> cls) {
            if (cls != null) {
                this.f30014a = cls;
                return this;
            }
            throw new IllegalArgumentException("interceptor class == null");
        }

        public a a(com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
            this.f30015b = aVar;
            return this;
        }

        public a a(Object... objArr) {
            if (objArr != null) {
                this.f30016c = objArr;
                return this;
            }
            throw new IllegalArgumentException("args == null");
        }
    }

    public Class<? extends d> a() {
        return this.f30011a;
    }

    public com.bytedance.sdk.openadsdk.preload.b.b.a b() {
        return this.f30012b;
    }

    public Object[] c() {
        return this.f30013c;
    }

    public h(a aVar) {
        this.f30011a = aVar.f30014a;
        this.f30012b = aVar.f30015b;
        this.f30013c = aVar.f30016c;
        if (this.f30011a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }
}
