package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f68522a;

    /* renamed from: b  reason: collision with root package name */
    public String f68523b;

    /* renamed from: c  reason: collision with root package name */
    public String f68524c;

    /* renamed from: d  reason: collision with root package name */
    public String f68525d;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f68526a;

        /* renamed from: b  reason: collision with root package name */
        public String f68527b;

        /* renamed from: c  reason: collision with root package name */
        public String f68528c;

        /* renamed from: d  reason: collision with root package name */
        public String f68529d;

        public a a(String str) {
            this.f68526a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f68527b = str;
            return this;
        }

        public a c(String str) {
            this.f68528c = str;
            return this;
        }

        public a d(String str) {
            this.f68529d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f68522a = !TextUtils.isEmpty(aVar.f68526a) ? aVar.f68526a : "";
        this.f68523b = !TextUtils.isEmpty(aVar.f68527b) ? aVar.f68527b : "";
        this.f68524c = !TextUtils.isEmpty(aVar.f68528c) ? aVar.f68528c : "";
        this.f68525d = TextUtils.isEmpty(aVar.f68529d) ? "" : aVar.f68529d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f68522a);
        cVar.a("seq_id", this.f68523b);
        cVar.a("push_timestamp", this.f68524c);
        cVar.a("device_id", this.f68525d);
        return cVar.toString();
    }

    public String c() {
        return this.f68522a;
    }

    public String d() {
        return this.f68523b;
    }

    public String e() {
        return this.f68524c;
    }

    public String f() {
        return this.f68525d;
    }
}
