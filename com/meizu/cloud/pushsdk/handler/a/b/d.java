package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes16.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    String f4186a;
    String b;
    String c;
    String d;

    /* loaded from: classes16.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f4187a;
        private String b;
        private String c;
        private String d;

        public a a(String str) {
            this.f4187a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.b = str;
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
        this.f4186a = !TextUtils.isEmpty(aVar.f4187a) ? aVar.f4187a : "";
        this.b = !TextUtils.isEmpty(aVar.b) ? aVar.b : "";
        this.c = !TextUtils.isEmpty(aVar.c) ? aVar.c : "";
        this.d = !TextUtils.isEmpty(aVar.d) ? aVar.d : "";
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.f4186a);
        cVar.a(BdStatsConstant.StatsKey.SEQUENCEID, this.b);
        cVar.a("push_timestamp", this.c);
        cVar.a("device_id", this.d);
        return cVar.toString();
    }

    public String c() {
        return this.f4186a;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.c;
    }

    public String f() {
        return this.d;
    }
}
