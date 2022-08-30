package com.kwad.sdk.crash.report;

import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes7.dex */
public abstract class c implements e {
    public ArrayList<a> ahB = new ArrayList<>();

    /* loaded from: classes7.dex */
    public static class a {
        public ExceptionMessage ahC;
        public int ahD;

        public a(ExceptionMessage exceptionMessage, int i) {
            this.ahC = exceptionMessage;
            this.ahD = i;
        }
    }

    public static void b(ExceptionMessage exceptionMessage, int i, @Nullable CountDownLatch countDownLatch) {
        if (exceptionMessage == null) {
            return;
        }
        if (i == 3) {
            com.kwad.sdk.crash.report.a.b(exceptionMessage);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.c(exceptionMessage));
        new com.kwad.sdk.crash.report.request.b().a(arrayList, countDownLatch);
    }

    private void wR() {
        if (this.ahB.isEmpty()) {
            return;
        }
        try {
            Iterator<a> it = this.ahB.iterator();
            while (it.hasNext()) {
                a next = it.next();
                b(next.ahC, next.ahD, null);
                it.remove();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
        }
    }

    public final void a(ExceptionMessage exceptionMessage, int i, @Nullable CountDownLatch countDownLatch) {
        try {
            wR();
            b(exceptionMessage, i, countDownLatch);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            this.ahB.add(new a(exceptionMessage, i));
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}
