package com.kuaishou.aegon.httpdns;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import com.kuaishou.aegon.Aegon;
import java.util.ArrayList;
import java.util.List;
@Keep
/* loaded from: classes5.dex */
public class HttpDnsResolver {
    public static a sLogger;
    public static Handler sLoggerHandler;

    /* loaded from: classes5.dex */
    public interface a {
        void onResolveFinish(ResolveFinishedInfo resolveFinishedInfo);
    }

    public static void increasePriority(List<String> list) {
        if (!Aegon.isInitialized() || list == null) {
            return;
        }
        Aegon.eDm();
        com.kuaishou.aegon.a.a.b(com.kuaishou.aegon.httpdns.a.gQ(list));
    }

    public static native void nativeIncreasePriority(String[] strArr);

    public static native List<ResolvedIP> nativeResolve(String str);

    public static native void nativeSetJsonConfig(String str);

    @Keep
    public static void onResolveFinish(ResolveFinishedInfo resolveFinishedInfo) {
        synchronized (HttpDnsResolver.class) {
            if (sLogger != null && sLoggerHandler != null) {
                sLoggerHandler.post(d.a(resolveFinishedInfo));
            }
        }
    }

    public static List<ResolvedIP> resolve(String str) {
        if (Aegon.isInitialized()) {
            Aegon.eDm();
            List<ResolvedIP> list = (List) com.kuaishou.aegon.a.a.a(b.ZW(str));
            return list == null ? new ArrayList() : list;
        }
        return new ArrayList();
    }

    public static void setLogger(a aVar) {
        synchronized (HttpDnsResolver.class) {
            sLogger = aVar;
            sLoggerHandler = new Handler(Looper.getMainLooper());
        }
    }

    public static void updateConfig(String str) {
        if (Aegon.isInitialized()) {
            Aegon.eDm();
            com.kuaishou.aegon.a.a.b(c.ZX(str));
        }
    }
}
