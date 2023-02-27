package com.kwad.components.core.offline.init.kwai;

import com.kwad.components.offline.api.core.api.IAsync;
import com.kwad.sdk.utils.bd;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class a implements IAsync {
    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void execute(Runnable runnable) {
        com.kwad.sdk.utils.g.execute(runnable);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void runOnDefaultExecutor(Runnable runnable) {
        com.kwad.sdk.utils.g.runOnDefaultExecutor(runnable);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void runOnUiThread(Runnable runnable) {
        bd.runOnUiThread(runnable);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void runOnUiThreadDelay(Runnable runnable, long j) {
        bd.runOnUiThreadDelay(runnable, j);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        com.kwad.sdk.utils.g.schedule(runnable, j, timeUnit);
    }
}
