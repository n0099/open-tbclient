package com.kwad.components.core.offline.init;

import android.content.Context;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.core.offline.init.kwai.g;
import com.kwad.components.offline.api.OfflineHostProvider;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public final class b {
    public static final AtomicBoolean EL = new AtomicBoolean();

    @ForInvoker(methodId = "initOC")
    public static void ao(Context context) {
        com.kwad.components.offline.obiwan.a.aC(context);
        com.kwad.components.offline.tk.a.aC(context);
    }

    public static void init(Context context) {
        if (EL.get()) {
            return;
        }
        EL.set(true);
        OfflineHostProvider.get().init(context, new g());
        ao(context);
    }
}
