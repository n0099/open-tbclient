package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f67610a;

    /* renamed from: b  reason: collision with root package name */
    public String f67611b;

    /* renamed from: c  reason: collision with root package name */
    public String f67612c;

    /* renamed from: d  reason: collision with root package name */
    public String f67613d;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f67614a;

        /* renamed from: b  reason: collision with root package name */
        public String f67615b;

        /* renamed from: c  reason: collision with root package name */
        public String f67616c;

        /* renamed from: d  reason: collision with root package name */
        public String f67617d;

        public a a(String str) {
            this.f67614a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f67615b = str;
            return this;
        }

        public a c(String str) {
            this.f67616c = str;
            return this;
        }

        public a d(String str) {
            this.f67617d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f67610a = !TextUtils.isEmpty(aVar.f67614a) ? aVar.f67614a : "";
        this.f67611b = !TextUtils.isEmpty(aVar.f67615b) ? aVar.f67615b : "";
        this.f67612c = !TextUtils.isEmpty(aVar.f67616c) ? aVar.f67616c : "";
        this.f67613d = TextUtils.isEmpty(aVar.f67617d) ? "" : aVar.f67617d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f67610a);
        cVar.a("seq_id", this.f67611b);
        cVar.a("push_timestamp", this.f67612c);
        cVar.a("device_id", this.f67613d);
        return cVar.toString();
    }

    public String c() {
        return this.f67610a;
    }

    public String d() {
        return this.f67611b;
    }

    public String e() {
        return this.f67612c;
    }

    public String f() {
        return this.f67613d;
    }
}
