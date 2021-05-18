package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f34998a;

    /* renamed from: b  reason: collision with root package name */
    public String f34999b;

    /* renamed from: c  reason: collision with root package name */
    public String f35000c;

    /* renamed from: d  reason: collision with root package name */
    public String f35001d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f35002a;

        /* renamed from: b  reason: collision with root package name */
        public String f35003b;

        /* renamed from: c  reason: collision with root package name */
        public String f35004c;

        /* renamed from: d  reason: collision with root package name */
        public String f35005d;

        public a a(String str) {
            this.f35002a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f35003b = str;
            return this;
        }

        public a c(String str) {
            this.f35004c = str;
            return this;
        }

        public a d(String str) {
            this.f35005d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f34998a = !TextUtils.isEmpty(aVar.f35002a) ? aVar.f35002a : "";
        this.f34999b = !TextUtils.isEmpty(aVar.f35003b) ? aVar.f35003b : "";
        this.f35000c = !TextUtils.isEmpty(aVar.f35004c) ? aVar.f35004c : "";
        this.f35001d = TextUtils.isEmpty(aVar.f35005d) ? "" : aVar.f35005d;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f34998a);
        cVar.a("seq_id", this.f34999b);
        cVar.a("push_timestamp", this.f35000c);
        cVar.a(Constants.KEY_DEVICE_ID, this.f35001d);
        return cVar.toString();
    }

    public String c() {
        return this.f34998a;
    }

    public String d() {
        return this.f34999b;
    }

    public String e() {
        return this.f35000c;
    }

    public String f() {
        return this.f35001d;
    }
}
