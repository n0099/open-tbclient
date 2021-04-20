package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f38099a;

    /* renamed from: b  reason: collision with root package name */
    public String f38100b;

    /* renamed from: c  reason: collision with root package name */
    public String f38101c;

    /* renamed from: d  reason: collision with root package name */
    public String f38102d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f38103a;

        /* renamed from: b  reason: collision with root package name */
        public String f38104b;

        /* renamed from: c  reason: collision with root package name */
        public String f38105c;

        /* renamed from: d  reason: collision with root package name */
        public String f38106d;

        public a a(String str) {
            this.f38103a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f38104b = str;
            return this;
        }

        public a c(String str) {
            this.f38105c = str;
            return this;
        }

        public a d(String str) {
            this.f38106d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f38099a = !TextUtils.isEmpty(aVar.f38103a) ? aVar.f38103a : "";
        this.f38100b = !TextUtils.isEmpty(aVar.f38104b) ? aVar.f38104b : "";
        this.f38101c = !TextUtils.isEmpty(aVar.f38105c) ? aVar.f38105c : "";
        this.f38102d = TextUtils.isEmpty(aVar.f38106d) ? "" : aVar.f38106d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f38099a);
        cVar.a("seq_id", this.f38100b);
        cVar.a("push_timestamp", this.f38101c);
        cVar.a(Constants.KEY_DEVICE_ID, this.f38102d);
        return cVar.toString();
    }

    public String c() {
        return this.f38099a;
    }

    public String d() {
        return this.f38100b;
    }

    public String e() {
        return this.f38101c;
    }

    public String f() {
        return this.f38102d;
    }
}
