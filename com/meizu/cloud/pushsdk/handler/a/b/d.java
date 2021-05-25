package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f34927a;

    /* renamed from: b  reason: collision with root package name */
    public String f34928b;

    /* renamed from: c  reason: collision with root package name */
    public String f34929c;

    /* renamed from: d  reason: collision with root package name */
    public String f34930d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f34931a;

        /* renamed from: b  reason: collision with root package name */
        public String f34932b;

        /* renamed from: c  reason: collision with root package name */
        public String f34933c;

        /* renamed from: d  reason: collision with root package name */
        public String f34934d;

        public a a(String str) {
            this.f34931a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f34932b = str;
            return this;
        }

        public a c(String str) {
            this.f34933c = str;
            return this;
        }

        public a d(String str) {
            this.f34934d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f34927a = !TextUtils.isEmpty(aVar.f34931a) ? aVar.f34931a : "";
        this.f34928b = !TextUtils.isEmpty(aVar.f34932b) ? aVar.f34932b : "";
        this.f34929c = !TextUtils.isEmpty(aVar.f34933c) ? aVar.f34933c : "";
        this.f34930d = TextUtils.isEmpty(aVar.f34934d) ? "" : aVar.f34934d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f34927a);
        cVar.a("seq_id", this.f34928b);
        cVar.a("push_timestamp", this.f34929c);
        cVar.a(Constants.KEY_DEVICE_ID, this.f34930d);
        return cVar.toString();
    }

    public String c() {
        return this.f34927a;
    }

    public String d() {
        return this.f34928b;
    }

    public String e() {
        return this.f34929c;
    }

    public String f() {
        return this.f34930d;
    }
}
