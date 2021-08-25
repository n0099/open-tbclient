package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f74718a;

    /* renamed from: b  reason: collision with root package name */
    public String f74719b;

    /* renamed from: c  reason: collision with root package name */
    public String f74720c;

    /* renamed from: d  reason: collision with root package name */
    public String f74721d;

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f74722a;

        /* renamed from: b  reason: collision with root package name */
        public String f74723b;

        /* renamed from: c  reason: collision with root package name */
        public String f74724c;

        /* renamed from: d  reason: collision with root package name */
        public String f74725d;

        public a a(String str) {
            this.f74722a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f74723b = str;
            return this;
        }

        public a c(String str) {
            this.f74724c = str;
            return this;
        }

        public a d(String str) {
            this.f74725d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f74718a = !TextUtils.isEmpty(aVar.f74722a) ? aVar.f74722a : "";
        this.f74719b = !TextUtils.isEmpty(aVar.f74723b) ? aVar.f74723b : "";
        this.f74720c = !TextUtils.isEmpty(aVar.f74724c) ? aVar.f74724c : "";
        this.f74721d = TextUtils.isEmpty(aVar.f74725d) ? "" : aVar.f74725d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f74718a);
        cVar.a("seq_id", this.f74719b);
        cVar.a("push_timestamp", this.f74720c);
        cVar.a("device_id", this.f74721d);
        return cVar.toString();
    }

    public String c() {
        return this.f74718a;
    }

    public String d() {
        return this.f74719b;
    }

    public String e() {
        return this.f74720c;
    }

    public String f() {
        return this.f74721d;
    }
}
