package com.tencent.open.b;
/* loaded from: classes8.dex */
public class e {
    public static int a(String str) {
        int a;
        if (com.tencent.open.utils.e.a() == null || (a = com.tencent.open.utils.f.a(com.tencent.open.utils.e.a(), str).a("Common_BusinessReportFrequency")) == 0) {
            return 100;
        }
        return a;
    }

    public static int a() {
        int a = com.tencent.open.utils.f.a(com.tencent.open.utils.e.a(), (String) null).a("Common_HttpRetryCount");
        if (a == 0) {
            return 2;
        }
        return a;
    }
}
