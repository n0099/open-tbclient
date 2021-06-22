package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f38704a;

    /* renamed from: b  reason: collision with root package name */
    public String f38705b;

    /* renamed from: c  reason: collision with root package name */
    public String f38706c;

    /* renamed from: d  reason: collision with root package name */
    public String f38707d;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f38708a;

        /* renamed from: b  reason: collision with root package name */
        public String f38709b;

        /* renamed from: c  reason: collision with root package name */
        public String f38710c;

        /* renamed from: d  reason: collision with root package name */
        public String f38711d;

        public a a(String str) {
            this.f38708a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f38709b = str;
            return this;
        }

        public a c(String str) {
            this.f38710c = str;
            return this;
        }

        public a d(String str) {
            this.f38711d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f38704a = !TextUtils.isEmpty(aVar.f38708a) ? aVar.f38708a : "";
        this.f38705b = !TextUtils.isEmpty(aVar.f38709b) ? aVar.f38709b : "";
        this.f38706c = !TextUtils.isEmpty(aVar.f38710c) ? aVar.f38710c : "";
        this.f38707d = TextUtils.isEmpty(aVar.f38711d) ? "" : aVar.f38711d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f38704a);
        cVar.a("seq_id", this.f38705b);
        cVar.a("push_timestamp", this.f38706c);
        cVar.a(Constants.KEY_DEVICE_ID, this.f38707d);
        return cVar.toString();
    }

    public String c() {
        return this.f38704a;
    }

    public String d() {
        return this.f38705b;
    }

    public String e() {
        return this.f38706c;
    }

    public String f() {
        return this.f38707d;
    }
}
