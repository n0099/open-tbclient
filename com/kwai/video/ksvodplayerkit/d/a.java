package com.kwai.video.ksvodplayerkit.d;

import android.content.Context;
import com.kwai.video.hodor.AbstractHodorPreloadTask;
import com.kwai.video.hodor.VodAdaptivePreloadPriorityTask;
import com.kwai.video.ksvodplayerkit.b.m;
import com.kwai.video.ksvodplayerkit.i;
/* loaded from: classes6.dex */
public class a extends b {

    /* renamed from: h  reason: collision with root package name */
    public String f37286h;
    public VodAdaptivePreloadPriorityTask.VodAdaptiveInit i;

    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask a() {
        this.f37287a.a(false);
        if (this.f37287a.f() <= 0 || this.f37287a.e() || this.f37288b.get() >= i.a().e() || !this.f37287a.a()) {
            return null;
        }
        this.f37286h = m.a(this.f37287a.g());
        VodAdaptivePreloadPriorityTask vodAdaptivePreloadPriorityTask = new VodAdaptivePreloadPriorityTask(this.f37286h, this.i);
        this.f37291e = vodAdaptivePreloadPriorityTask;
        return vodAdaptivePreloadPriorityTask;
    }

    public void a(Context context) {
        VodAdaptivePreloadPriorityTask.VodAdaptiveInit vodAdaptiveInit = new VodAdaptivePreloadPriorityTask.VodAdaptiveInit();
        this.i = vodAdaptiveInit;
        vodAdaptiveInit.rateConfig = i.a().k();
        this.i.lowDevice = i.a().l();
        this.i.netType = com.kwai.video.ksvodplayerkit.c.a.d(context);
        this.i.devResHeigh = com.kwai.video.ksvodplayerkit.c.c.b(context);
        this.i.devResWidth = com.kwai.video.ksvodplayerkit.c.c.a(context);
    }

    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask b() {
        if (this.f37291e == null) {
            this.f37291e = new VodAdaptivePreloadPriorityTask(this.f37286h, this.i);
        }
        return this.f37291e;
    }
}
