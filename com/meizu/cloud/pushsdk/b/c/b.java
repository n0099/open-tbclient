package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.a.c;
import com.meizu.cloud.pushsdk.b.c.a;
/* loaded from: classes2.dex */
public class b extends com.meizu.cloud.pushsdk.b.c.a {
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;

    /* loaded from: classes2.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC0184a<T> {
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

    /* renamed from: com.meizu.cloud.pushsdk.b.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0185b extends a<C0185b> {
        private C0185b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.meizu.cloud.pushsdk.b.c.a.AbstractC0184a
        /* renamed from: c */
        public C0185b a() {
            return this;
        }
    }

    public static a<?> d() {
        return new C0185b();
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
