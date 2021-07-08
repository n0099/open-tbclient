package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f37481a;

    /* renamed from: b  reason: collision with root package name */
    public String f37482b;

    /* renamed from: c  reason: collision with root package name */
    public String f37483c;

    /* renamed from: d  reason: collision with root package name */
    public String f37484d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f37485a;

        /* renamed from: b  reason: collision with root package name */
        public String f37486b;

        /* renamed from: c  reason: collision with root package name */
        public String f37487c;

        /* renamed from: d  reason: collision with root package name */
        public String f37488d;

        public a a(String str) {
            this.f37485a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f37486b = str;
            return this;
        }

        public a c(String str) {
            this.f37487c = str;
            return this;
        }

        public a d(String str) {
            this.f37488d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f37481a = !TextUtils.isEmpty(aVar.f37485a) ? aVar.f37485a : "";
        this.f37482b = !TextUtils.isEmpty(aVar.f37486b) ? aVar.f37486b : "";
        this.f37483c = !TextUtils.isEmpty(aVar.f37487c) ? aVar.f37487c : "";
        this.f37484d = TextUtils.isEmpty(aVar.f37488d) ? "" : aVar.f37488d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f37481a);
        cVar.a("seq_id", this.f37482b);
        cVar.a("push_timestamp", this.f37483c);
        cVar.a("device_id", this.f37484d);
        return cVar.toString();
    }

    public String c() {
        return this.f37481a;
    }

    public String d() {
        return this.f37482b;
    }

    public String e() {
        return this.f37483c;
    }

    public String f() {
        return this.f37484d;
    }
}
