package com.bytedance.sdk.openadsdk.preload.b;
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    Class<? extends d> f5043a;
    private com.bytedance.sdk.openadsdk.preload.b.b.a b;
    private Object[] c;

    private h(a aVar) {
        this.f5043a = aVar.f5044a;
        this.b = aVar.b;
        this.c = aVar.c;
        if (this.f5043a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<? extends d> a() {
        return this.f5043a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.openadsdk.preload.b.b.a b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] c() {
        return this.c;
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Class<? extends d> f5044a;
        private com.bytedance.sdk.openadsdk.preload.b.b.a b;
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
            this.f5044a = cls;
            return this;
        }

        public a a(com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
            this.b = aVar;
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
