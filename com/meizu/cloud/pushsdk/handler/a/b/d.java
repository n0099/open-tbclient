package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f40467a;

    /* renamed from: b  reason: collision with root package name */
    public String f40468b;

    /* renamed from: c  reason: collision with root package name */
    public String f40469c;

    /* renamed from: d  reason: collision with root package name */
    public String f40470d;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f40471a;

        /* renamed from: b  reason: collision with root package name */
        public String f40472b;

        /* renamed from: c  reason: collision with root package name */
        public String f40473c;

        /* renamed from: d  reason: collision with root package name */
        public String f40474d;

        public a a(String str) {
            this.f40471a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f40472b = str;
            return this;
        }

        public a c(String str) {
            this.f40473c = str;
            return this;
        }

        public a d(String str) {
            this.f40474d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f40467a = !TextUtils.isEmpty(aVar.f40471a) ? aVar.f40471a : "";
        this.f40468b = !TextUtils.isEmpty(aVar.f40472b) ? aVar.f40472b : "";
        this.f40469c = !TextUtils.isEmpty(aVar.f40473c) ? aVar.f40473c : "";
        this.f40470d = TextUtils.isEmpty(aVar.f40474d) ? "" : aVar.f40474d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f40467a);
        cVar.a("seq_id", this.f40468b);
        cVar.a("push_timestamp", this.f40469c);
        cVar.a("device_id", this.f40470d);
        return cVar.toString();
    }

    public String c() {
        return this.f40467a;
    }

    public String d() {
        return this.f40468b;
    }

    public String e() {
        return this.f40469c;
    }

    public String f() {
        return this.f40470d;
    }
}
