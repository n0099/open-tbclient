package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bi;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class z<T extends g, R extends com.kwad.sdk.core.network.f> implements Runnable {
    public static AtomicLong axW = new AtomicLong(-1);
    public final o<T> avl;
    public final d<T, R> axX;
    public final AtomicInteger axY;
    public final Context mContext;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.axY.get() <= 0 && ag.isNetworkConnected(this.mContext)) {
            DO();
        }
    }

    public z(Context context, o<T> oVar, d<T, R> dVar, AtomicInteger atomicInteger) {
        this.mContext = context;
        this.avl = oVar;
        this.axX = dVar;
        this.axY = atomicInteger;
    }

    private void DO() {
        long Ls = bi.Ls();
        if (Ls >= axW.get() * 2) {
            try {
                List<T> Dw = this.avl.Dw();
                if (!Dw.isEmpty()) {
                    y(Dw);
                }
            } catch (OutOfMemoryError e) {
                axW.set(Ls);
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(e);
            } catch (Throwable th) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
            }
        }
    }

    private void y(@NonNull List<T> list) {
        List d = com.kwad.sdk.utils.z.d(list, 200);
        int size = d.size();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (int i = 0; i < size; i++) {
            this.axX.a((List) d.get(i), atomicBoolean);
        }
    }
}
