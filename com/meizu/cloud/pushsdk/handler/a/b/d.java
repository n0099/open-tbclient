package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class d {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f60506b;

    /* renamed from: c  reason: collision with root package name */
    public String f60507c;

    /* renamed from: d  reason: collision with root package name */
    public String f60508d;

    /* loaded from: classes2.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f60509b;

        /* renamed from: c  reason: collision with root package name */
        public String f60510c;

        /* renamed from: d  reason: collision with root package name */
        public String f60511d;

        public a a(String str) {
            this.a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f60509b = str;
            return this;
        }

        public a c(String str) {
            this.f60510c = str;
            return this;
        }

        public a d(String str) {
            this.f60511d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.a = !TextUtils.isEmpty(aVar.a) ? aVar.a : "";
        this.f60506b = !TextUtils.isEmpty(aVar.f60509b) ? aVar.f60509b : "";
        this.f60507c = !TextUtils.isEmpty(aVar.f60510c) ? aVar.f60510c : "";
        this.f60508d = TextUtils.isEmpty(aVar.f60511d) ? "" : aVar.f60511d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.a);
        cVar.a("seq_id", this.f60506b);
        cVar.a("push_timestamp", this.f60507c);
        cVar.a("device_id", this.f60508d);
        return cVar.toString();
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.f60506b;
    }

    public String e() {
        return this.f60507c;
    }

    public String f() {
        return this.f60508d;
    }
}
