package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class d {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f58986b;

    /* renamed from: c  reason: collision with root package name */
    public String f58987c;

    /* renamed from: d  reason: collision with root package name */
    public String f58988d;

    /* loaded from: classes4.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f58989b;

        /* renamed from: c  reason: collision with root package name */
        public String f58990c;

        /* renamed from: d  reason: collision with root package name */
        public String f58991d;

        public a a(String str) {
            this.a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f58989b = str;
            return this;
        }

        public a c(String str) {
            this.f58990c = str;
            return this;
        }

        public a d(String str) {
            this.f58991d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.a = !TextUtils.isEmpty(aVar.a) ? aVar.a : "";
        this.f58986b = !TextUtils.isEmpty(aVar.f58989b) ? aVar.f58989b : "";
        this.f58987c = !TextUtils.isEmpty(aVar.f58990c) ? aVar.f58990c : "";
        this.f58988d = TextUtils.isEmpty(aVar.f58991d) ? "" : aVar.f58991d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.a);
        cVar.a("seq_id", this.f58986b);
        cVar.a("push_timestamp", this.f58987c);
        cVar.a("device_id", this.f58988d);
        return cVar.toString();
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.f58986b;
    }

    public String e() {
        return this.f58987c;
    }

    public String f() {
        return this.f58988d;
    }
}
