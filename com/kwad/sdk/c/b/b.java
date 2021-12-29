package com.kwad.sdk.c.b;

import android.text.TextUtils;
import com.kwad.sdk.c.kwai.d;
import com.kwad.sdk.core.report.ReportAction;
import com.kwad.sdk.core.report.f;
import java.util.Random;
/* loaded from: classes3.dex */
public class b {
    public static void a(d dVar, int i2) {
        if (a()) {
            ReportAction reportAction = new ReportAction(230L);
            reportAction.bz = dVar.a;
            reportAction.bA = dVar.f57656e;
            reportAction.bB = dVar.f57658g;
            reportAction.bC = i2;
            reportAction.bD = System.currentTimeMillis();
            f.a(reportAction);
        }
    }

    public static void a(d dVar, int i2, String str) {
        if (a()) {
            ReportAction reportAction = new ReportAction(230L);
            reportAction.bz = dVar.a;
            reportAction.bA = dVar.f57656e;
            reportAction.bB = dVar.f57658g;
            reportAction.bC = 0;
            reportAction.bE = i2;
            reportAction.bD = System.currentTimeMillis();
            reportAction.bF = str;
            f.a(reportAction);
        }
    }

    public static boolean a() {
        String U = com.kwad.sdk.core.config.b.U();
        if (TextUtils.isEmpty(U)) {
            return false;
        }
        String[] split = U.split(":");
        if (split.length == 2) {
            return new Random().nextInt(Integer.parseInt(split[0])) <= Integer.parseInt(split[1]);
        }
        return false;
    }
}
