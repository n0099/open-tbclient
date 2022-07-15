package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.report.c;
import com.kwad.sdk.utils.ac;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class v<T extends c, R extends com.kwad.sdk.core.network.g> implements Runnable {
    public final j<T> a;
    public final Context b;
    public final b<T, R> c;
    public final AtomicInteger d;

    public v(Context context, j<T> jVar, b<T, R> bVar, AtomicInteger atomicInteger) {
        this.b = context;
        this.a = jVar;
        this.c = bVar;
        this.d = atomicInteger;
    }

    private void a() {
        List<T> b = this.a.b();
        if (b.isEmpty()) {
            return;
        }
        a(b);
    }

    private void a(@NonNull List<T> list) {
        List a = com.kwad.sdk.utils.v.a(list, 200);
        int size = a.size();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (int i = 0; i < size; i++) {
            this.c.a((List) a.get(i), atomicBoolean);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.d.get() > 0 || !ac.b(this.b)) {
            return;
        }
        a();
    }
}
