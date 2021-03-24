package com.bytedance.sdk.openadsdk.preload.b;
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public Class<? extends d> f30159a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.b.b.a f30160b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f30161c;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Class<? extends d> f30162a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.b.b.a f30163b;

        /* renamed from: c  reason: collision with root package name */
        public Object[] f30164c;

        public static a a() {
            return new a();
        }

        public h b() {
            return new h(this);
        }

        public a a(Class<? extends d> cls) {
            if (cls != null) {
                this.f30162a = cls;
                return this;
            }
            throw new IllegalArgumentException("interceptor class == null");
        }

        public a a(com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
            this.f30163b = aVar;
            return this;
        }

        public a a(Object... objArr) {
            if (objArr != null) {
                this.f30164c = objArr;
                return this;
            }
            throw new IllegalArgumentException("args == null");
        }
    }

    public Class<? extends d> a() {
        return this.f30159a;
    }

    public com.bytedance.sdk.openadsdk.preload.b.b.a b() {
        return this.f30160b;
    }

    public Object[] c() {
        return this.f30161c;
    }

    public h(a aVar) {
        this.f30159a = aVar.f30162a;
        this.f30160b = aVar.f30163b;
        this.f30161c = aVar.f30164c;
        if (this.f30159a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }
}
