package com.kwai.video.ksvodplayerkit.d;

import android.content.Context;
import com.kwai.video.hodor.AbstractHodorPreloadTask;
import com.kwai.video.hodor.VodAdaptivePreloadPriorityTask;
import com.kwai.video.ksvodplayerkit.b.m;
import com.kwai.video.ksvodplayerkit.i;
/* loaded from: classes7.dex */
public class a extends b {

    /* renamed from: h  reason: collision with root package name */
    public String f38061h;

    /* renamed from: i  reason: collision with root package name */
    public VodAdaptivePreloadPriorityTask.VodAdaptiveInit f38062i;

    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask a() {
        this.f38063a.a(false);
        if (this.f38063a.f() <= 0 || this.f38063a.e() || this.f38064b.get() >= i.a().e() || !this.f38063a.a()) {
            return null;
        }
        this.f38061h = m.a(this.f38063a.g());
        VodAdaptivePreloadPriorityTask vodAdaptivePreloadPriorityTask = new VodAdaptivePreloadPriorityTask(this.f38061h, this.f38062i);
        this.f38067e = vodAdaptivePreloadPriorityTask;
        return vodAdaptivePreloadPriorityTask;
    }

    public void a(Context context) {
        VodAdaptivePreloadPriorityTask.VodAdaptiveInit vodAdaptiveInit = new VodAdaptivePreloadPriorityTask.VodAdaptiveInit();
        this.f38062i = vodAdaptiveInit;
        vodAdaptiveInit.rateConfig = i.a().k();
        this.f38062i.lowDevice = i.a().l();
        this.f38062i.netType = com.kwai.video.ksvodplayerkit.c.a.d(context);
        this.f38062i.devResHeigh = com.kwai.video.ksvodplayerkit.c.c.b(context);
        this.f38062i.devResWidth = com.kwai.video.ksvodplayerkit.c.c.a(context);
    }

    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask b() {
        if (this.f38067e == null) {
            this.f38067e = new VodAdaptivePreloadPriorityTask(this.f38061h, this.f38062i);
        }
        return this.f38067e;
    }
}
