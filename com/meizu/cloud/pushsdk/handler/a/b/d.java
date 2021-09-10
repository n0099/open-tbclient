package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f74898a;

    /* renamed from: b  reason: collision with root package name */
    public String f74899b;

    /* renamed from: c  reason: collision with root package name */
    public String f74900c;

    /* renamed from: d  reason: collision with root package name */
    public String f74901d;

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f74902a;

        /* renamed from: b  reason: collision with root package name */
        public String f74903b;

        /* renamed from: c  reason: collision with root package name */
        public String f74904c;

        /* renamed from: d  reason: collision with root package name */
        public String f74905d;

        public a a(String str) {
            this.f74902a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f74903b = str;
            return this;
        }

        public a c(String str) {
            this.f74904c = str;
            return this;
        }

        public a d(String str) {
            this.f74905d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f74898a = !TextUtils.isEmpty(aVar.f74902a) ? aVar.f74902a : "";
        this.f74899b = !TextUtils.isEmpty(aVar.f74903b) ? aVar.f74903b : "";
        this.f74900c = !TextUtils.isEmpty(aVar.f74904c) ? aVar.f74904c : "";
        this.f74901d = TextUtils.isEmpty(aVar.f74905d) ? "" : aVar.f74905d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f74898a);
        cVar.a("seq_id", this.f74899b);
        cVar.a("push_timestamp", this.f74900c);
        cVar.a("device_id", this.f74901d);
        return cVar.toString();
    }

    public String c() {
        return this.f74898a;
    }

    public String d() {
        return this.f74899b;
    }

    public String e() {
        return this.f74900c;
    }

    public String f() {
        return this.f74901d;
    }
}
