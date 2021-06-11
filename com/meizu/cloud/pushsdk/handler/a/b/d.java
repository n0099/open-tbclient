package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f38606a;

    /* renamed from: b  reason: collision with root package name */
    public String f38607b;

    /* renamed from: c  reason: collision with root package name */
    public String f38608c;

    /* renamed from: d  reason: collision with root package name */
    public String f38609d;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f38610a;

        /* renamed from: b  reason: collision with root package name */
        public String f38611b;

        /* renamed from: c  reason: collision with root package name */
        public String f38612c;

        /* renamed from: d  reason: collision with root package name */
        public String f38613d;

        public a a(String str) {
            this.f38610a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f38611b = str;
            return this;
        }

        public a c(String str) {
            this.f38612c = str;
            return this;
        }

        public a d(String str) {
            this.f38613d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f38606a = !TextUtils.isEmpty(aVar.f38610a) ? aVar.f38610a : "";
        this.f38607b = !TextUtils.isEmpty(aVar.f38611b) ? aVar.f38611b : "";
        this.f38608c = !TextUtils.isEmpty(aVar.f38612c) ? aVar.f38612c : "";
        this.f38609d = TextUtils.isEmpty(aVar.f38613d) ? "" : aVar.f38613d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f38606a);
        cVar.a("seq_id", this.f38607b);
        cVar.a("push_timestamp", this.f38608c);
        cVar.a(Constants.KEY_DEVICE_ID, this.f38609d);
        return cVar.toString();
    }

    public String c() {
        return this.f38606a;
    }

    public String d() {
        return this.f38607b;
    }

    public String e() {
        return this.f38608c;
    }

    public String f() {
        return this.f38609d;
    }
}
