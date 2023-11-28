package com.kwad.sdk.crash.online.monitor.block;

import android.os.Looper;
import android.util.Printer;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class a {
    public static volatile boolean aFo;
    public static String aFp;
    public static List<String> aFq;
    public static List<String> aFr;
    public static volatile boolean aFs;
    public static volatile boolean aFt;

    public static boolean GF() {
        if (aFo) {
            return false;
        }
        try {
            if (((Printer) s.getField(Looper.getMainLooper(), "mLogging")) == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e);
            aFo = true;
            return false;
        }
    }

    public static boolean GG() {
        if (aFt) {
            return aFs;
        }
        try {
            String str = new String(com.kwad.sdk.core.a.c.Ck().decode("Y29tLnRlbmNlbnQubWF0cml4Lk1hdHJpeA=="));
            com.kwad.sdk.core.e.c.d("perfMonitor.MonitorDetector", "hasMatrix after:" + str);
            if (Class.forName(str) != null) {
                return true;
            }
        } catch (ClassNotFoundException unused) {
        }
        aFs = false;
        aFt = true;
        return aFs;
    }

    public static void a(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        aFq = aVar.aFM;
        aFr = aVar.aFN;
    }

    public static boolean bA(boolean z) {
        List<String> list = aFr;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return a(aFr, false);
    }

    public static boolean bz(boolean z) {
        List<String> list = aFq;
        if (list != null && !list.isEmpty()) {
            return a(aFq, true);
        }
        return g("Y29tLnRlbmNlbnQubWF0cml4LnRyYWNlLmNvcmUuTG9vcGVyTW9uaXRvcg==", true);
    }

    public static boolean a(List<String> list, boolean z) {
        if (aFo) {
            return false;
        }
        try {
            Printer printer = (Printer) s.getField(Looper.getMainLooper(), "mLogging");
            if (printer != null) {
                aFp = printer.getClass().getName();
                com.kwad.sdk.core.e.c.d("perfMonitor.MonitorDetector", "originPrinter name:" + printer.getClass().getName());
                if (z) {
                    f.fb(aFp);
                }
                for (String str : list) {
                    String str2 = new String(com.kwad.sdk.core.a.c.Ck().decode(str));
                    com.kwad.sdk.core.e.c.d("perfMonitor.MonitorDetector", "printer after:" + str2);
                    if (printer.getClass().getName().contains(str2)) {
                        com.kwad.sdk.core.e.c.d("perfMonitor.MonitorDetector", "printer monitor");
                        return true;
                    }
                }
            } else {
                com.kwad.sdk.core.e.c.d("perfMonitor.MonitorDetector", "printer not hook");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e);
            aFo = true;
        }
        return false;
    }

    public static boolean g(String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return a(arrayList, z);
    }
}
