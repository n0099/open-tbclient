package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f37670a;

    /* renamed from: b  reason: collision with root package name */
    public String f37671b;

    /* renamed from: c  reason: collision with root package name */
    public String f37672c;

    /* renamed from: d  reason: collision with root package name */
    public String f37673d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f37674a;

        /* renamed from: b  reason: collision with root package name */
        public String f37675b;

        /* renamed from: c  reason: collision with root package name */
        public String f37676c;

        /* renamed from: d  reason: collision with root package name */
        public String f37677d;

        public a a(String str) {
            this.f37674a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f37675b = str;
            return this;
        }

        public a c(String str) {
            this.f37676c = str;
            return this;
        }

        public a d(String str) {
            this.f37677d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f37670a = !TextUtils.isEmpty(aVar.f37674a) ? aVar.f37674a : "";
        this.f37671b = !TextUtils.isEmpty(aVar.f37675b) ? aVar.f37675b : "";
        this.f37672c = !TextUtils.isEmpty(aVar.f37676c) ? aVar.f37676c : "";
        this.f37673d = TextUtils.isEmpty(aVar.f37677d) ? "" : aVar.f37677d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f37670a);
        cVar.a("seq_id", this.f37671b);
        cVar.a("push_timestamp", this.f37672c);
        cVar.a("device_id", this.f37673d);
        return cVar.toString();
    }

    public String c() {
        return this.f37670a;
    }

    public String d() {
        return this.f37671b;
    }

    public String e() {
        return this.f37672c;
    }

    public String f() {
        return this.f37673d;
    }
}
