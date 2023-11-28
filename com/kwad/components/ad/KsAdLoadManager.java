package com.kwad.components.ad;

import androidx.annotation.NonNull;
import com.kwad.components.ad.adbit.c;
import com.kwad.components.core.c.d;
import com.kwad.components.core.c.g;
import java.util.List;
/* loaded from: classes10.dex */
public final class KsAdLoadManager {
    public KsAdLoadManager() {
    }

    public static KsAdLoadManager M() {
        return Holder.INSTANCE.mInstance;
    }

    /* loaded from: classes10.dex */
    public enum Holder {
        INSTANCE;
        
        public final KsAdLoadManager mInstance = new KsAdLoadManager((byte) 0);

        Holder() {
        }
    }

    public /* synthetic */ KsAdLoadManager(byte b) {
        this();
    }

    public static void a(@NonNull com.kwad.components.core.request.model.a aVar) {
        if (c.b(aVar)) {
            return;
        }
        d.mq().c(aVar);
    }

    public final synchronized <T> void b(List<T> list) {
        for (T t : list) {
            g.mC().add(t);
        }
    }

    public final synchronized <T> void a(T t) {
        g.mC().add(t);
    }
}
