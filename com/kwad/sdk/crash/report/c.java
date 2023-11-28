package com.kwad.sdk.crash.report;

import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes10.dex */
public abstract class c implements e {
    public ArrayList<a> aGa = new ArrayList<>();

    /* loaded from: classes10.dex */
    public static class a {
        public ExceptionMessage aGb;
        public int aGc;

        public a(ExceptionMessage exceptionMessage, int i) {
            this.aGb = exceptionMessage;
            this.aGc = i;
        }
    }

    private void GP() {
        if (!this.aGa.isEmpty()) {
            try {
                Iterator<a> it = this.aGa.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    b(next.aGb, next.aGc, null);
                    it.remove();
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            }
        }
    }

    public static boolean a(String str, List<String> list) {
        for (String str2 : list) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private void b(ExceptionMessage exceptionMessage, int i, @Nullable CountDownLatch countDownLatch) {
        if (exceptionMessage != null && c(exceptionMessage)) {
            if (i == 3) {
                com.kwad.sdk.crash.report.a.b(exceptionMessage);
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(com.kwad.sdk.crash.report.request.c.d(exceptionMessage));
            com.kwad.sdk.crash.report.request.b.a(arrayList, countDownLatch);
        }
    }

    public final void a(ExceptionMessage exceptionMessage, int i, @Nullable CountDownLatch countDownLatch) {
        try {
            GP();
            b(exceptionMessage, i, countDownLatch);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            this.aGa.add(new a(exceptionMessage, i));
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    private boolean c(ExceptionMessage exceptionMessage) {
        try {
            com.kwad.sdk.crash.e Gl = com.kwad.sdk.crash.e.Gl();
            if (Gl.Gq() != null && Gl.Gp() != 2) {
                List<com.kwad.sdk.crash.a> list = Gl.Gq().aEu;
                double d = Gl.Gq().aDX;
                String appId = Gl.getAppId();
                String sdkVersion = Gl.getSdkVersion();
                for (com.kwad.sdk.crash.a aVar : list) {
                    if (aVar != null && (com.kwad.sdk.crash.utils.c.b(aVar.aDU) || aVar.aDU.contains(appId))) {
                        if (com.kwad.sdk.crash.utils.c.b(aVar.aDV) || aVar.aDV.contains(sdkVersion)) {
                            if (com.kwad.sdk.crash.utils.c.b(aVar.aDW) || a(exceptionMessage.mCrashDetail, aVar.aDW)) {
                                d = aVar.aDX;
                            }
                        }
                    }
                }
                if (Math.random() < d) {
                    return true;
                }
                return false;
            }
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.w("BaseExceptionUploader", Log.getStackTraceString(e));
            return true;
        }
    }
}
