package com.kwad.components.ad;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.components.ad.adbit.c;
import com.kwad.components.core.a.d;
import com.kwad.components.core.a.f;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes10.dex */
public final class KsAdLoadManager {

    /* loaded from: classes10.dex */
    public enum Holder {
        INSTANCE;
        
        public KsAdLoadManager mInstance = new KsAdLoadManager((byte) 0);

        Holder() {
        }
    }

    public KsAdLoadManager() {
    }

    public /* synthetic */ KsAdLoadManager(byte b) {
        this();
    }

    public static void a(@NonNull com.kwad.components.core.k.kwai.a aVar) {
        if (c.b(aVar)) {
            return;
        }
        d.lS().c(aVar);
    }

    public static void a(AdResultData adResultData, long j) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
            return;
        }
        com.kwad.components.core.j.a.og().c(adTemplate, elapsedRealtime - j);
    }

    public static KsAdLoadManager ab() {
        return Holder.INSTANCE.mInstance;
    }

    public final synchronized <T> void a(T t) {
        f.mb().add(t);
    }

    public final synchronized <T> void b(List<T> list) {
        for (T t : list) {
            f.mb().add(t);
        }
    }
}
