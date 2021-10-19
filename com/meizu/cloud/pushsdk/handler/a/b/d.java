package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f75252a;

    /* renamed from: b  reason: collision with root package name */
    public String f75253b;

    /* renamed from: c  reason: collision with root package name */
    public String f75254c;

    /* renamed from: d  reason: collision with root package name */
    public String f75255d;

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f75256a;

        /* renamed from: b  reason: collision with root package name */
        public String f75257b;

        /* renamed from: c  reason: collision with root package name */
        public String f75258c;

        /* renamed from: d  reason: collision with root package name */
        public String f75259d;

        public a a(String str) {
            this.f75256a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f75257b = str;
            return this;
        }

        public a c(String str) {
            this.f75258c = str;
            return this;
        }

        public a d(String str) {
            this.f75259d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f75252a = !TextUtils.isEmpty(aVar.f75256a) ? aVar.f75256a : "";
        this.f75253b = !TextUtils.isEmpty(aVar.f75257b) ? aVar.f75257b : "";
        this.f75254c = !TextUtils.isEmpty(aVar.f75258c) ? aVar.f75258c : "";
        this.f75255d = TextUtils.isEmpty(aVar.f75259d) ? "" : aVar.f75259d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f75252a);
        cVar.a("seq_id", this.f75253b);
        cVar.a("push_timestamp", this.f75254c);
        cVar.a("device_id", this.f75255d);
        return cVar.toString();
    }

    public String c() {
        return this.f75252a;
    }

    public String d() {
        return this.f75253b;
    }

    public String e() {
        return this.f75254c;
    }

    public String f() {
        return this.f75255d;
    }
}
