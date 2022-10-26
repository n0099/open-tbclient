package com.kwad.sdk.core.report;

import android.content.Context;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.x;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class v implements Runnable {
    public final j ZH;
    public final b acj;
    public final AtomicInteger ack;
    public final Context mContext;

    public v(Context context, j jVar, b bVar, AtomicInteger atomicInteger) {
        this.mContext = context;
        this.ZH = jVar;
        this.acj = bVar;
        this.ack = atomicInteger;
    }

    private void r(List list) {
        List d = x.d(list, 200);
        int size = d.size();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (int i = 0; i < size; i++) {
            this.acj.a((List) d.get(i), atomicBoolean);
        }
    }

    private void uL() {
        List uy = this.ZH.uy();
        if (uy.isEmpty()) {
            return;
        }
        r(uy);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.ack.get() > 0 || !ae.isNetworkConnected(this.mContext)) {
            return;
        }
        uL();
    }
}
