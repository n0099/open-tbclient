package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    public static final String TAG = "c";
    public static int azJ;
    public static int azK;
    public static int azL;
    public static final ConcurrentHashMap<ThreadPoolExecutor, Long> azM = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<ThreadPoolExecutor, String> azN = new ConcurrentHashMap<>();
    public static long interval;
    public static long startTime;

    public static /* synthetic */ int EJ() {
        int i = azJ;
        azJ = i + 1;
        return i;
    }

    public static void a(d dVar) {
        com.kwad.sdk.core.threads.a.b.azR = true;
        com.kwad.sdk.core.threads.a.a.azR = true;
        interval = dVar.interval;
        azL = dVar.azQ;
        HandlerThread handlerThread = new HandlerThread("pollingHT");
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        startTime = SystemClock.elapsedRealtime();
        handler.post(new ay() { // from class: com.kwad.sdk.core.threads.c.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                ExecutorService dX;
                for (String str : GlobalThreadPools.ED()) {
                    if (str != null && !c.azN.containsValue(str) && (dX = GlobalThreadPools.dX(str)) != null && (dX instanceof ThreadPoolExecutor) && !c.azM.containsKey(dX)) {
                        c.a((ThreadPoolExecutor) dX, str);
                    }
                }
                int i = 0;
                for (ThreadPoolExecutor threadPoolExecutor : c.azN.keySet()) {
                    i += threadPoolExecutor.getPoolSize();
                    b b = c.b(threadPoolExecutor, (String) c.azN.get(threadPoolExecutor));
                    if (b != null) {
                        com.kwad.sdk.commercial.a.r(b);
                    }
                }
                b bVar = new b();
                bVar.azz = "total";
                bVar.azC = i;
                com.kwad.sdk.commercial.a.r(bVar);
                c.EJ();
                if (c.azJ < c.azL) {
                    handler.postDelayed(this, c.interval);
                }
            }
        });
    }

    public static void dY(final String str) {
        g.execute(new ay() { // from class: com.kwad.sdk.core.threads.c.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                d dZ;
                int i;
                if (!TextUtils.isEmpty(str) && (dZ = c.dZ(str)) != null && (i = dZ.azK) != 0) {
                    int unused = c.azK = i;
                    if (Math.random() * c.azK < 1.0d) {
                        c.a(dZ);
                    }
                }
            }
        });
    }

    public static d dZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor, String str) {
        azM.put(threadPoolExecutor, Long.valueOf(threadPoolExecutor.getCompletedTaskCount()));
        azN.put(threadPoolExecutor, str);
    }

    public static b b(ThreadPoolExecutor threadPoolExecutor, String str) {
        int size;
        long j;
        if (threadPoolExecutor == null) {
            return null;
        }
        b bVar = new b();
        bVar.azz = str;
        bVar.azA = threadPoolExecutor.getCorePoolSize();
        bVar.azB = threadPoolExecutor.getMaximumPoolSize();
        bVar.azC = threadPoolExecutor.getPoolSize();
        bVar.azD = threadPoolExecutor.getActiveCount();
        if (threadPoolExecutor.getQueue() == null) {
            size = 0;
        } else {
            size = threadPoolExecutor.getQueue().size();
        }
        bVar.azG = size;
        if (azM.containsKey(threadPoolExecutor) && azM.get(threadPoolExecutor) != null) {
            j = azM.get(threadPoolExecutor).longValue();
        } else {
            j = 0;
        }
        long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
        bVar.azF = completedTaskCount - j;
        azM.put(threadPoolExecutor, Long.valueOf(completedTaskCount));
        if (threadPoolExecutor instanceof com.kwad.sdk.core.threads.a.c) {
            bVar.azE = ((com.kwad.sdk.core.threads.a.c) threadPoolExecutor).EN();
        } else {
            bVar.azE = 0L;
        }
        bVar.azH = SystemClock.elapsedRealtime() - startTime;
        bVar.interval = interval;
        bVar.azI = azK;
        return bVar;
    }
}
