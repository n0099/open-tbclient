package com.kwai.video.ksvodplayerkit.d;

import android.content.Context;
import com.kwai.video.hodor.AbstractHodorPreloadTask;
import com.kwai.video.hodor.VodAdaptivePreloadPriorityTask;
import com.kwai.video.ksvodplayerkit.b.m;
import com.kwai.video.ksvodplayerkit.i;
/* loaded from: classes3.dex */
public class a extends b {
    private String h;
    private VodAdaptivePreloadPriorityTask.VodAdaptiveInit i;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask a() {
        this.f11065a.a(false);
        if (this.f11065a.f() <= 0 || this.f11065a.e() || this.f11066b.get() >= i.a().e() || !this.f11065a.a()) {
            return null;
        }
        this.h = m.a(this.f11065a.g());
        this.e = new VodAdaptivePreloadPriorityTask(this.h, this.i);
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context) {
        this.i = new VodAdaptivePreloadPriorityTask.VodAdaptiveInit();
        this.i.rateConfig = i.a().k();
        this.i.lowDevice = i.a().l();
        this.i.netType = com.kwai.video.ksvodplayerkit.c.a.d(context);
        this.i.devResHeigh = com.kwai.video.ksvodplayerkit.c.c.b(context);
        this.i.devResWidth = com.kwai.video.ksvodplayerkit.c.c.a(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask b() {
        if (this.e == null) {
            this.e = new VodAdaptivePreloadPriorityTask(this.h, this.i);
        }
        return this.e;
    }
}
