package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f37810a;

    /* renamed from: b  reason: collision with root package name */
    public String f37811b;

    /* renamed from: c  reason: collision with root package name */
    public String f37812c;

    /* renamed from: d  reason: collision with root package name */
    public String f37813d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f37814a;

        /* renamed from: b  reason: collision with root package name */
        public String f37815b;

        /* renamed from: c  reason: collision with root package name */
        public String f37816c;

        /* renamed from: d  reason: collision with root package name */
        public String f37817d;

        public a a(String str) {
            this.f37814a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f37815b = str;
            return this;
        }

        public a c(String str) {
            this.f37816c = str;
            return this;
        }

        public a d(String str) {
            this.f37817d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f37810a = !TextUtils.isEmpty(aVar.f37814a) ? aVar.f37814a : "";
        this.f37811b = !TextUtils.isEmpty(aVar.f37815b) ? aVar.f37815b : "";
        this.f37812c = !TextUtils.isEmpty(aVar.f37816c) ? aVar.f37816c : "";
        this.f37813d = TextUtils.isEmpty(aVar.f37817d) ? "" : aVar.f37817d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f37810a);
        cVar.a("seq_id", this.f37811b);
        cVar.a("push_timestamp", this.f37812c);
        cVar.a(Constants.KEY_DEVICE_ID, this.f37813d);
        return cVar.toString();
    }

    public String c() {
        return this.f37810a;
    }

    public String d() {
        return this.f37811b;
    }

    public String e() {
        return this.f37812c;
    }

    public String f() {
        return this.f37813d;
    }
}
