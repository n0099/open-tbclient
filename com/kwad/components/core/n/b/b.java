package com.kwad.components.core.n.b;

import android.content.Context;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.core.n.b.a.j;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.c.c;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class b {
    public static final AtomicBoolean JB = new AtomicBoolean();

    @ForInvoker(methodId = "initOC")
    public static void ac(Context context) {
        com.kwad.components.offline.a.b.aj(context);
        com.kwad.components.offline.b.b.aj(context);
        c.aj(context);
    }

    public static void init(final Context context) {
        if (JB.get()) {
            return;
        }
        JB.set(true);
        OfflineHostProvider.get().init(context, new j());
        g.execute(new ay() { // from class: com.kwad.components.core.n.b.b.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                b.ac(context);
            }
        });
    }
}
