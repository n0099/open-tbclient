package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class d {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f58819b;

    /* renamed from: c  reason: collision with root package name */
    public String f58820c;

    /* renamed from: d  reason: collision with root package name */
    public String f58821d;

    /* loaded from: classes3.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f58822b;

        /* renamed from: c  reason: collision with root package name */
        public String f58823c;

        /* renamed from: d  reason: collision with root package name */
        public String f58824d;

        public a a(String str) {
            this.a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f58822b = str;
            return this;
        }

        public a c(String str) {
            this.f58823c = str;
            return this;
        }

        public a d(String str) {
            this.f58824d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.a = !TextUtils.isEmpty(aVar.a) ? aVar.a : "";
        this.f58819b = !TextUtils.isEmpty(aVar.f58822b) ? aVar.f58822b : "";
        this.f58820c = !TextUtils.isEmpty(aVar.f58823c) ? aVar.f58823c : "";
        this.f58821d = TextUtils.isEmpty(aVar.f58824d) ? "" : aVar.f58824d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.a);
        cVar.a("seq_id", this.f58819b);
        cVar.a("push_timestamp", this.f58820c);
        cVar.a("device_id", this.f58821d);
        return cVar.toString();
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.f58819b;
    }

    public String e() {
        return this.f58820c;
    }

    public String f() {
        return this.f58821d;
    }
}
