package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f67609a;

    /* renamed from: b  reason: collision with root package name */
    public String f67610b;

    /* renamed from: c  reason: collision with root package name */
    public String f67611c;

    /* renamed from: d  reason: collision with root package name */
    public String f67612d;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f67613a;

        /* renamed from: b  reason: collision with root package name */
        public String f67614b;

        /* renamed from: c  reason: collision with root package name */
        public String f67615c;

        /* renamed from: d  reason: collision with root package name */
        public String f67616d;

        public a a(String str) {
            this.f67613a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f67614b = str;
            return this;
        }

        public a c(String str) {
            this.f67615c = str;
            return this;
        }

        public a d(String str) {
            this.f67616d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f67609a = !TextUtils.isEmpty(aVar.f67613a) ? aVar.f67613a : "";
        this.f67610b = !TextUtils.isEmpty(aVar.f67614b) ? aVar.f67614b : "";
        this.f67611c = !TextUtils.isEmpty(aVar.f67615c) ? aVar.f67615c : "";
        this.f67612d = TextUtils.isEmpty(aVar.f67616d) ? "" : aVar.f67616d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f67609a);
        cVar.a("seq_id", this.f67610b);
        cVar.a("push_timestamp", this.f67611c);
        cVar.a("device_id", this.f67612d);
        return cVar.toString();
    }

    public String c() {
        return this.f67609a;
    }

    public String d() {
        return this.f67610b;
    }

    public String e() {
        return this.f67611c;
    }

    public String f() {
        return this.f67612d;
    }
}
