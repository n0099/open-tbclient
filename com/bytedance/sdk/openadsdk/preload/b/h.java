package com.bytedance.sdk.openadsdk.preload.b;
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public Class<? extends d> f30043a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.b.b.a f30044b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f30045c;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Class<? extends d> f30046a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.b.b.a f30047b;

        /* renamed from: c  reason: collision with root package name */
        public Object[] f30048c;

        public static a a() {
            return new a();
        }

        public h b() {
            return new h(this);
        }

        public a a(Class<? extends d> cls) {
            if (cls != null) {
                this.f30046a = cls;
                return this;
            }
            throw new IllegalArgumentException("interceptor class == null");
        }

        public a a(com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
            this.f30047b = aVar;
            return this;
        }

        public a a(Object... objArr) {
            if (objArr != null) {
                this.f30048c = objArr;
                return this;
            }
            throw new IllegalArgumentException("args == null");
        }
    }

    public Class<? extends d> a() {
        return this.f30043a;
    }

    public com.bytedance.sdk.openadsdk.preload.b.b.a b() {
        return this.f30044b;
    }

    public Object[] c() {
        return this.f30045c;
    }

    public h(a aVar) {
        this.f30043a = aVar.f30046a;
        this.f30044b = aVar.f30047b;
        this.f30045c = aVar.f30048c;
        if (this.f30043a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }
}
