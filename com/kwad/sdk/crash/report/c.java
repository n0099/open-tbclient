package com.kwad.sdk.crash.report;

import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes5.dex */
public abstract class c implements e {
    public ArrayList<a> a = new ArrayList<>();

    /* loaded from: classes5.dex */
    public static class a {
        public ExceptionMessage a;
        public int b;

        public a(ExceptionMessage exceptionMessage, int i) {
            this.a = exceptionMessage;
            this.b = i;
        }
    }

    private void b() {
        if (this.a.isEmpty()) {
            return;
        }
        try {
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                b(next.a, next.b, null);
                it.remove();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.b(th);
        }
    }

    public static void b(ExceptionMessage exceptionMessage, int i, @Nullable CountDownLatch countDownLatch) {
        if (exceptionMessage == null) {
            return;
        }
        if (i == 3) {
            com.kwad.sdk.crash.report.a.a(exceptionMessage);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.a(exceptionMessage));
        new com.kwad.sdk.crash.report.request.b().a(arrayList, countDownLatch);
    }

    public final void a(ExceptionMessage exceptionMessage, int i, @Nullable CountDownLatch countDownLatch) {
        try {
            b();
            b(exceptionMessage, i, countDownLatch);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.b(th);
            this.a.add(new a(exceptionMessage, i));
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}
