package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class d {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f42161b;

    /* renamed from: c  reason: collision with root package name */
    public String f42162c;

    /* renamed from: d  reason: collision with root package name */
    public String f42163d;

    /* loaded from: classes7.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f42164b;

        /* renamed from: c  reason: collision with root package name */
        public String f42165c;

        /* renamed from: d  reason: collision with root package name */
        public String f42166d;

        public a a(String str) {
            this.a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f42164b = str;
            return this;
        }

        public a c(String str) {
            this.f42165c = str;
            return this;
        }

        public a d(String str) {
            this.f42166d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.a = !TextUtils.isEmpty(aVar.a) ? aVar.a : "";
        this.f42161b = !TextUtils.isEmpty(aVar.f42164b) ? aVar.f42164b : "";
        this.f42162c = !TextUtils.isEmpty(aVar.f42165c) ? aVar.f42165c : "";
        this.f42163d = TextUtils.isEmpty(aVar.f42166d) ? "" : aVar.f42166d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.a);
        cVar.a("seq_id", this.f42161b);
        cVar.a("push_timestamp", this.f42162c);
        cVar.a("device_id", this.f42163d);
        return cVar.toString();
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.f42161b;
    }

    public String e() {
        return this.f42162c;
    }

    public String f() {
        return this.f42163d;
    }
}
