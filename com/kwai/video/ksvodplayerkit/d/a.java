package com.kwai.video.ksvodplayerkit.d;

import android.content.Context;
import com.kwai.video.hodor.AbstractHodorPreloadTask;
import com.kwai.video.hodor.VodAdaptivePreloadPriorityTask;
import com.kwai.video.ksvodplayerkit.b.m;
import com.kwai.video.ksvodplayerkit.i;
/* loaded from: classes7.dex */
public class a extends b {

    /* renamed from: h  reason: collision with root package name */
    public String f38159h;

    /* renamed from: i  reason: collision with root package name */
    public VodAdaptivePreloadPriorityTask.VodAdaptiveInit f38160i;

    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask a() {
        this.f38161a.a(false);
        if (this.f38161a.f() <= 0 || this.f38161a.e() || this.f38162b.get() >= i.a().e() || !this.f38161a.a()) {
            return null;
        }
        this.f38159h = m.a(this.f38161a.g());
        VodAdaptivePreloadPriorityTask vodAdaptivePreloadPriorityTask = new VodAdaptivePreloadPriorityTask(this.f38159h, this.f38160i);
        this.f38165e = vodAdaptivePreloadPriorityTask;
        return vodAdaptivePreloadPriorityTask;
    }

    public void a(Context context) {
        VodAdaptivePreloadPriorityTask.VodAdaptiveInit vodAdaptiveInit = new VodAdaptivePreloadPriorityTask.VodAdaptiveInit();
        this.f38160i = vodAdaptiveInit;
        vodAdaptiveInit.rateConfig = i.a().k();
        this.f38160i.lowDevice = i.a().l();
        this.f38160i.netType = com.kwai.video.ksvodplayerkit.c.a.d(context);
        this.f38160i.devResHeigh = com.kwai.video.ksvodplayerkit.c.c.b(context);
        this.f38160i.devResWidth = com.kwai.video.ksvodplayerkit.c.c.a(context);
    }

    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask b() {
        if (this.f38165e == null) {
            this.f38165e = new VodAdaptivePreloadPriorityTask(this.f38159h, this.f38160i);
        }
        return this.f38165e;
    }
}
