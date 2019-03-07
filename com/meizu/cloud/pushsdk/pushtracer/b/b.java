package com.meizu.cloud.pushsdk.pushtracer.b;

import com.meizu.cloud.pushsdk.pushtracer.a.c;
import com.meizu.cloud.pushsdk.pushtracer.b.a;
/* loaded from: classes3.dex */
public class b extends com.meizu.cloud.pushsdk.pushtracer.b.a {
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;

    /* loaded from: classes3.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC0347a<T> {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;

        public T a(String str) {
            this.a = str;
            return (T) a();
        }

        public T b(String str) {
            this.b = str;
            return (T) a();
        }

        public T c(String str) {
            this.c = str;
            return (T) a();
        }

        public T d(String str) {
            this.d = str;
            return (T) a();
        }

        public T e(String str) {
            this.e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f = str;
            return (T) a();
        }

        public T g(String str) {
            this.g = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.pushtracer.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0348b extends a<C0348b> {
        private C0348b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.meizu.cloud.pushsdk.pushtracer.b.a.AbstractC0347a
        /* renamed from: c */
        public C0348b a() {
            return this;
        }
    }

    public static a<?> d() {
        return new C0348b();
    }

    protected b(a<?> aVar) {
        super(aVar);
        this.e = ((a) aVar).b;
        this.f = ((a) aVar).c;
        this.d = ((a) aVar).a;
        this.g = ((a) aVar).d;
        this.h = ((a) aVar).e;
        this.i = ((a) aVar).f;
        this.j = ((a) aVar).g;
    }

    public c e() {
        c cVar = new c();
        cVar.a("event_name", this.d);
        cVar.a("task_id", this.e);
        cVar.a("device_id", this.f);
        cVar.a("pushsdk_version", this.g);
        cVar.a("package_name", this.h);
        cVar.a("seq_id", this.i);
        cVar.a("message_seq", this.j);
        return a(cVar);
    }
}
