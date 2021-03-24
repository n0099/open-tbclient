package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f37809a;

    /* renamed from: b  reason: collision with root package name */
    public String f37810b;

    /* renamed from: c  reason: collision with root package name */
    public String f37811c;

    /* renamed from: d  reason: collision with root package name */
    public String f37812d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f37813a;

        /* renamed from: b  reason: collision with root package name */
        public String f37814b;

        /* renamed from: c  reason: collision with root package name */
        public String f37815c;

        /* renamed from: d  reason: collision with root package name */
        public String f37816d;

        public a a(String str) {
            this.f37813a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f37814b = str;
            return this;
        }

        public a c(String str) {
            this.f37815c = str;
            return this;
        }

        public a d(String str) {
            this.f37816d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f37809a = !TextUtils.isEmpty(aVar.f37813a) ? aVar.f37813a : "";
        this.f37810b = !TextUtils.isEmpty(aVar.f37814b) ? aVar.f37814b : "";
        this.f37811c = !TextUtils.isEmpty(aVar.f37815c) ? aVar.f37815c : "";
        this.f37812d = TextUtils.isEmpty(aVar.f37816d) ? "" : aVar.f37816d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f37809a);
        cVar.a("seq_id", this.f37810b);
        cVar.a("push_timestamp", this.f37811c);
        cVar.a(Constants.KEY_DEVICE_ID, this.f37812d);
        return cVar.toString();
    }

    public String c() {
        return this.f37809a;
    }

    public String d() {
        return this.f37810b;
    }

    public String e() {
        return this.f37811c;
    }

    public String f() {
        return this.f37812d;
    }
}
