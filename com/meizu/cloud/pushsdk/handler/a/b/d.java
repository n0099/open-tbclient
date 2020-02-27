package com.meizu.cloud.pushsdk.handler.a.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes8.dex */
public class d {
    String a;
    String b;
    String c;
    String d;

    /* loaded from: classes8.dex */
    public static class a {
        private String a;
        private String b;
        private String c;
        private String d;

        public a a(String str) {
            this.a = str;
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
        this.a = !TextUtils.isEmpty(aVar.a) ? aVar.a : "";
        this.b = !TextUtils.isEmpty(aVar.b) ? aVar.b : "";
        this.c = !TextUtils.isEmpty(aVar.c) ? aVar.c : "";
        this.d = !TextUtils.isEmpty(aVar.d) ? aVar.d : "";
    }

    public static a a() {
        return new a();
    }

    public String b() {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        cVar.a("task_id", this.a);
        cVar.a(BdStatsConstant.StatsKey.SEQUENCEID, this.b);
        cVar.a("push_timestamp", this.c);
        cVar.a(Constants.KEY_DEVICE_ID, this.d);
        return cVar.toString();
    }

    public String c() {
        return this.a;
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
