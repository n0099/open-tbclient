package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class d {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f57336b;

    /* renamed from: c  reason: collision with root package name */
    public String f57337c;

    /* renamed from: d  reason: collision with root package name */
    public String f57338d;

    /* loaded from: classes8.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f57339b;

        /* renamed from: c  reason: collision with root package name */
        public String f57340c;

        /* renamed from: d  reason: collision with root package name */
        public String f57341d;

        public a a(String str) {
            this.a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f57339b = str;
            return this;
        }

        public a c(String str) {
            this.f57340c = str;
            return this;
        }

        public a d(String str) {
            this.f57341d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.a = !TextUtils.isEmpty(aVar.a) ? aVar.a : "";
        this.f57336b = !TextUtils.isEmpty(aVar.f57339b) ? aVar.f57339b : "";
        this.f57337c = !TextUtils.isEmpty(aVar.f57340c) ? aVar.f57340c : "";
        this.f57338d = TextUtils.isEmpty(aVar.f57341d) ? "" : aVar.f57341d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.a);
        cVar.a("seq_id", this.f57336b);
        cVar.a("push_timestamp", this.f57337c);
        cVar.a("device_id", this.f57338d);
        return cVar.toString();
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.f57336b;
    }

    public String e() {
        return this.f57337c;
    }

    public String f() {
        return this.f57338d;
    }
}
