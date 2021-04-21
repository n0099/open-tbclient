package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f38194a;

    /* renamed from: b  reason: collision with root package name */
    public String f38195b;

    /* renamed from: c  reason: collision with root package name */
    public String f38196c;

    /* renamed from: d  reason: collision with root package name */
    public String f38197d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f38198a;

        /* renamed from: b  reason: collision with root package name */
        public String f38199b;

        /* renamed from: c  reason: collision with root package name */
        public String f38200c;

        /* renamed from: d  reason: collision with root package name */
        public String f38201d;

        public a a(String str) {
            this.f38198a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f38199b = str;
            return this;
        }

        public a c(String str) {
            this.f38200c = str;
            return this;
        }

        public a d(String str) {
            this.f38201d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f38194a = !TextUtils.isEmpty(aVar.f38198a) ? aVar.f38198a : "";
        this.f38195b = !TextUtils.isEmpty(aVar.f38199b) ? aVar.f38199b : "";
        this.f38196c = !TextUtils.isEmpty(aVar.f38200c) ? aVar.f38200c : "";
        this.f38197d = TextUtils.isEmpty(aVar.f38201d) ? "" : aVar.f38201d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f38194a);
        cVar.a("seq_id", this.f38195b);
        cVar.a("push_timestamp", this.f38196c);
        cVar.a(Constants.KEY_DEVICE_ID, this.f38197d);
        return cVar.toString();
    }

    public String c() {
        return this.f38194a;
    }

    public String d() {
        return this.f38195b;
    }

    public String e() {
        return this.f38196c;
    }

    public String f() {
        return this.f38197d;
    }
}
