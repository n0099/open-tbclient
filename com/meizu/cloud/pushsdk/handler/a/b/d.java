package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class d {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f58774b;

    /* renamed from: c  reason: collision with root package name */
    public String f58775c;

    /* renamed from: d  reason: collision with root package name */
    public String f58776d;

    /* loaded from: classes3.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f58777b;

        /* renamed from: c  reason: collision with root package name */
        public String f58778c;

        /* renamed from: d  reason: collision with root package name */
        public String f58779d;

        public a a(String str) {
            this.a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f58777b = str;
            return this;
        }

        public a c(String str) {
            this.f58778c = str;
            return this;
        }

        public a d(String str) {
            this.f58779d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.a = !TextUtils.isEmpty(aVar.a) ? aVar.a : "";
        this.f58774b = !TextUtils.isEmpty(aVar.f58777b) ? aVar.f58777b : "";
        this.f58775c = !TextUtils.isEmpty(aVar.f58778c) ? aVar.f58778c : "";
        this.f58776d = TextUtils.isEmpty(aVar.f58779d) ? "" : aVar.f58779d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.a);
        cVar.a("seq_id", this.f58774b);
        cVar.a("push_timestamp", this.f58775c);
        cVar.a("device_id", this.f58776d);
        return cVar.toString();
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.f58774b;
    }

    public String e() {
        return this.f58775c;
    }

    public String f() {
        return this.f58776d;
    }
}
