package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f35753a;

    /* renamed from: b  reason: collision with root package name */
    public String f35754b;

    /* renamed from: c  reason: collision with root package name */
    public String f35755c;

    /* renamed from: d  reason: collision with root package name */
    public String f35756d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f35757a;

        /* renamed from: b  reason: collision with root package name */
        public String f35758b;

        /* renamed from: c  reason: collision with root package name */
        public String f35759c;

        /* renamed from: d  reason: collision with root package name */
        public String f35760d;

        public a a(String str) {
            this.f35757a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f35758b = str;
            return this;
        }

        public a c(String str) {
            this.f35759c = str;
            return this;
        }

        public a d(String str) {
            this.f35760d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f35753a = !TextUtils.isEmpty(aVar.f35757a) ? aVar.f35757a : "";
        this.f35754b = !TextUtils.isEmpty(aVar.f35758b) ? aVar.f35758b : "";
        this.f35755c = !TextUtils.isEmpty(aVar.f35759c) ? aVar.f35759c : "";
        this.f35756d = TextUtils.isEmpty(aVar.f35760d) ? "" : aVar.f35760d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f35753a);
        cVar.a("seq_id", this.f35754b);
        cVar.a("push_timestamp", this.f35755c);
        cVar.a(Constants.KEY_DEVICE_ID, this.f35756d);
        return cVar.toString();
    }

    public String c() {
        return this.f35753a;
    }

    public String d() {
        return this.f35754b;
    }

    public String e() {
        return this.f35755c;
    }

    public String f() {
        return this.f35756d;
    }
}
