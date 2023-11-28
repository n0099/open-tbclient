package com.kwad.sdk.crash.online.monitor.block;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import com.kwad.sdk.crash.online.monitor.block.report.BlockReportAction;
import com.kwad.sdk.crash.report.h;
import com.kwad.sdk.crash.report.request.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public final class f {
    public static boolean Do() {
        int GJ = GJ();
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return false;
        }
        long size = com.kwad.sdk.crash.online.monitor.block.report.a.bw(context).size();
        com.kwad.sdk.core.e.c.d("perfMonitor.Reporter", "size:" + size + " limit:" + GJ);
        if (size < GJ) {
            return false;
        }
        return true;
    }

    public static int GJ() {
        com.kwad.sdk.crash.online.monitor.a.a GH = e.GH();
        if (GH != null) {
            return GH.aFR;
        }
        return 20;
    }

    public static /* synthetic */ boolean GK() {
        return Do();
    }

    public static /* synthetic */ int yM() {
        return GJ();
    }

    public static void a(String str, long j, long j2, String str2, String str3, boolean z) {
        try {
            h(b(str, j, j2, str2, str3), false);
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public static String b(String str, long j, long j2, String str2, String str3) {
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.w("perfMonitor.Reporter", Log.getStackTraceString(e));
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str = fa(b.eY(str));
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (j2 == 0) {
            j2 = 2000;
        }
        return c(str, j, j2, str2, str3).toJson().toString();
    }

    public static BlockEvent c(String str, long j, long j2, String str2, String str3) {
        BlockEvent blockEvent = new BlockEvent();
        blockEvent.blockDuration = j2;
        blockEvent.currentActivity = str2;
        blockEvent.processName = str3;
        BlockEvent.a aVar = new BlockEvent.a();
        aVar.aFw = str;
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        aVar.aFu = j;
        aVar.repeatCount = (int) (j2 / blockEvent.blockLoopInterval);
        blockEvent.stackTraceSample.add(aVar);
        return blockEvent;
    }

    public static String fa(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            boolean startsWith = str.startsWith(" \n");
            com.kwad.sdk.core.e.c.d("perfMonitor.Reporter", "oldVersion:" + startsWith);
            if (startsWith) {
                if (str.contains("at ")) {
                    str = str.substring(str.indexOf("at "));
                }
                str = str.replaceAll(":", "\\.") + "\n";
            }
            String replaceAll = str.replaceAll("at ", "").replaceAll(" ", "");
            if (replaceAll.contains("\n")) {
                replaceAll = replaceAll.replaceAll("\n", "\n\tat ");
            }
            return "\n\tat " + (replaceAll + "_").replaceAll("\n\tat _", "\n");
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.w("perfMonitor.Reporter", Log.getStackTraceString(e));
            return str;
        }
    }

    public static void fb(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.core.e.c.d("perfMonitor.Reporter", "reportPrinterName:" + str);
        if (e.GI()) {
            d dVar = new d();
            dVar.aFC = str;
            dVar.aFE = a.GG();
            com.kwad.sdk.commercial.a.p(dVar);
        }
    }

    public static void fc(String str) {
        try {
            d dVar = new d();
            dVar.errorMsg = str;
            dVar.aFE = a.GG();
            com.kwad.sdk.commercial.a.p(dVar);
        } catch (Exception unused) {
        }
        com.kwad.sdk.core.e.c.w("perfMonitor.Reporter", str);
    }

    public static void h(final String str, final boolean z) {
        g.execute(new ay() { // from class: com.kwad.sdk.crash.online.monitor.block.f.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (!z && f.yM() != 1) {
                    BlockReportAction blockReportAction = new BlockReportAction(str);
                    com.kwad.sdk.core.e.c.d("perfMonitor.Reporter", "write to db :" + blockReportAction.toJson().toString());
                    final Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
                    if (context == null) {
                        return;
                    }
                    com.kwad.sdk.crash.online.monitor.block.report.a.bw(context).j(blockReportAction);
                    if (f.GK()) {
                        final List<com.kwad.sdk.core.report.g> Dw = com.kwad.sdk.crash.online.monitor.block.report.a.bw(context).Dw();
                        ArrayList arrayList = new ArrayList();
                        Iterator<com.kwad.sdk.core.report.g> it = Dw.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((BlockReportAction) it.next()).msg);
                        }
                        h.a("perf-block", arrayList, new b.a() { // from class: com.kwad.sdk.crash.online.monitor.block.f.1.1
                            @Override // com.kwad.sdk.crash.report.request.b.a
                            public final void onError(int i, String str2) {
                                com.kwad.sdk.core.e.c.w("perfMonitor.Reporter", "errorCode:" + i + " errorMsg:" + str2);
                            }

                            @Override // com.kwad.sdk.crash.report.request.b.a
                            public final void onSuccess() {
                                com.kwad.sdk.crash.online.monitor.block.report.a.bw(context).v(Dw);
                            }
                        });
                        return;
                    }
                    return;
                }
                com.kwad.sdk.core.e.c.d("perfMonitor.Reporter", "report now :" + str);
                h.af("perf-block", str);
            }
        });
    }
}
