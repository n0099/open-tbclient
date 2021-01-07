package com.bytedance.sdk.openadsdk.preload.a;
/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    Class<? extends d> f7722a;

    /* renamed from: b  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.preload.a.b.a f7723b;
    private Object[] c;

    private h(a aVar) {
        this.f7722a = aVar.f7724a;
        this.f7723b = aVar.f7725b;
        this.c = aVar.c;
        if (this.f7722a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<? extends d> a() {
        return this.f7722a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.openadsdk.preload.a.b.a b() {
        return this.f7723b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] c() {
        return this.c;
    }

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Class<? extends d> f7724a;

        /* renamed from: b  reason: collision with root package name */
        private com.bytedance.sdk.openadsdk.preload.a.b.a f7725b;
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
            this.f7724a = cls;
            return this;
        }

        public a a(com.bytedance.sdk.openadsdk.preload.a.b.a aVar) {
            this.f7725b = aVar;
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
