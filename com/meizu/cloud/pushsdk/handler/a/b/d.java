package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class d {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f61087b;

    /* renamed from: c  reason: collision with root package name */
    public String f61088c;

    /* renamed from: d  reason: collision with root package name */
    public String f61089d;

    /* loaded from: classes3.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f61090b;

        /* renamed from: c  reason: collision with root package name */
        public String f61091c;

        /* renamed from: d  reason: collision with root package name */
        public String f61092d;

        public a a(String str) {
            this.a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f61090b = str;
            return this;
        }

        public a c(String str) {
            this.f61091c = str;
            return this;
        }

        public a d(String str) {
            this.f61092d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.a = !TextUtils.isEmpty(aVar.a) ? aVar.a : "";
        this.f61087b = !TextUtils.isEmpty(aVar.f61090b) ? aVar.f61090b : "";
        this.f61088c = !TextUtils.isEmpty(aVar.f61091c) ? aVar.f61091c : "";
        this.f61089d = TextUtils.isEmpty(aVar.f61092d) ? "" : aVar.f61092d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.a);
        cVar.a("seq_id", this.f61087b);
        cVar.a("push_timestamp", this.f61088c);
        cVar.a("device_id", this.f61089d);
        return cVar.toString();
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.f61087b;
    }

    public String e() {
        return this.f61088c;
    }

    public String f() {
        return this.f61089d;
    }
}
