package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f74518a;

    /* renamed from: b  reason: collision with root package name */
    public String f74519b;

    /* renamed from: c  reason: collision with root package name */
    public String f74520c;

    /* renamed from: d  reason: collision with root package name */
    public String f74521d;

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f74522a;

        /* renamed from: b  reason: collision with root package name */
        public String f74523b;

        /* renamed from: c  reason: collision with root package name */
        public String f74524c;

        /* renamed from: d  reason: collision with root package name */
        public String f74525d;

        public a a(String str) {
            this.f74522a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f74523b = str;
            return this;
        }

        public a c(String str) {
            this.f74524c = str;
            return this;
        }

        public a d(String str) {
            this.f74525d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f74518a = !TextUtils.isEmpty(aVar.f74522a) ? aVar.f74522a : "";
        this.f74519b = !TextUtils.isEmpty(aVar.f74523b) ? aVar.f74523b : "";
        this.f74520c = !TextUtils.isEmpty(aVar.f74524c) ? aVar.f74524c : "";
        this.f74521d = TextUtils.isEmpty(aVar.f74525d) ? "" : aVar.f74525d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f74518a);
        cVar.a("seq_id", this.f74519b);
        cVar.a("push_timestamp", this.f74520c);
        cVar.a("device_id", this.f74521d);
        return cVar.toString();
    }

    public String c() {
        return this.f74518a;
    }

    public String d() {
        return this.f74519b;
    }

    public String e() {
        return this.f74520c;
    }

    public String f() {
        return this.f74521d;
    }
}
