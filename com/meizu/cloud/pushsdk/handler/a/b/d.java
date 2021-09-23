package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f75217a;

    /* renamed from: b  reason: collision with root package name */
    public String f75218b;

    /* renamed from: c  reason: collision with root package name */
    public String f75219c;

    /* renamed from: d  reason: collision with root package name */
    public String f75220d;

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f75221a;

        /* renamed from: b  reason: collision with root package name */
        public String f75222b;

        /* renamed from: c  reason: collision with root package name */
        public String f75223c;

        /* renamed from: d  reason: collision with root package name */
        public String f75224d;

        public a a(String str) {
            this.f75221a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f75222b = str;
            return this;
        }

        public a c(String str) {
            this.f75223c = str;
            return this;
        }

        public a d(String str) {
            this.f75224d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f75217a = !TextUtils.isEmpty(aVar.f75221a) ? aVar.f75221a : "";
        this.f75218b = !TextUtils.isEmpty(aVar.f75222b) ? aVar.f75222b : "";
        this.f75219c = !TextUtils.isEmpty(aVar.f75223c) ? aVar.f75223c : "";
        this.f75220d = TextUtils.isEmpty(aVar.f75224d) ? "" : aVar.f75224d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f75217a);
        cVar.a("seq_id", this.f75218b);
        cVar.a("push_timestamp", this.f75219c);
        cVar.a("device_id", this.f75220d);
        return cVar.toString();
    }

    public String c() {
        return this.f75217a;
    }

    public String d() {
        return this.f75218b;
    }

    public String e() {
        return this.f75219c;
    }

    public String f() {
        return this.f75220d;
    }
}
