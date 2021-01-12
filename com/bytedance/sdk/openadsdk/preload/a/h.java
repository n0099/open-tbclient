package com.bytedance.sdk.openadsdk.preload.a;
/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    Class<? extends d> f7422a;

    /* renamed from: b  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.preload.a.b.a f7423b;
    private Object[] c;

    private h(a aVar) {
        this.f7422a = aVar.f7424a;
        this.f7423b = aVar.f7425b;
        this.c = aVar.c;
        if (this.f7422a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<? extends d> a() {
        return this.f7422a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.openadsdk.preload.a.b.a b() {
        return this.f7423b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] c() {
        return this.c;
    }

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Class<? extends d> f7424a;

        /* renamed from: b  reason: collision with root package name */
        private com.bytedance.sdk.openadsdk.preload.a.b.a f7425b;
        private Object[] c;

        private a() {
        }

        public static a a() {
            return new a();
        }

        public a a(Class<? extends d> cls) {
            if (cls == null) {
                throw new IllegalArgumentException("interceptor class == null");
            }
            this.f7424a = cls;
            return this;
        }

        public a a(com.bytedance.sdk.openadsdk.preload.a.b.a aVar) {
            this.f7425b = aVar;
            return this;
        }

        public a a(Object... objArr) {
            if (objArr == null) {
                throw new IllegalArgumentException("args == null");
            }
            this.c = objArr;
            return this;
        }

        public h b() {
            return new h(this);
        }
    }
}
