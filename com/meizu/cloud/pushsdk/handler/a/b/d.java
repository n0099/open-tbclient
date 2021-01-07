package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    String f11613a;

    /* renamed from: b  reason: collision with root package name */
    String f11614b;
    String c;
    String d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f11615a;

        /* renamed from: b  reason: collision with root package name */
        private String f11616b;
        private String c;
        private String d;

        public a a(String str) {
            this.f11615a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.f11616b = str;
            return this;
        }

        public a c(String str) {
            this.c = str;
            return this;
        }

        public a d(String str) {
            this.d = str;
            return this;
        }
    }

    public d() {
    }

    public d(a aVar) {
        this.f11613a = !TextUtils.isEmpty(aVar.f11615a) ? aVar.f11615a : "";
        this.f11614b = !TextUtils.isEmpty(aVar.f11616b) ? aVar.f11616b : "";
        this.c = !TextUtils.isEmpty(aVar.c) ? aVar.c : "";
        this.d = !TextUtils.isEmpty(aVar.d) ? aVar.d : "";
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f11613a);
        cVar.a(BdStatsConstant.StatsKey.SEQUENCEID, this.f11614b);
        cVar.a("push_timestamp", this.c);
        cVar.a("device_id", this.d);
        return cVar.toString();
    }

    public String c() {
        return this.f11613a;
    }

    public String d() {
        return this.f11614b;
    }

    public String e() {
        return this.c;
    }

    public String f() {
        return this.d;
    }
}
