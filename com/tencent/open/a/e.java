package com.tencent.open.a;
/* loaded from: classes8.dex */
public class e {
    public static int a() {
        int a = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Common_HttpRetryCount");
        if (a == 0) {
            return 2;
        }
        return a;
    }

    public static int a(String str) {
        int a;
        if (com.tencent.open.utils.f.a() == null || (a = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), str).a("Common_BusinessReportFrequency")) == 0) {
            return 100;
        }
        return a;
    }
}
