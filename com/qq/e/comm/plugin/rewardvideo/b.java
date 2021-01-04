package com.qq.e.comm.plugin.rewardvideo;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f12683a = new AtomicInteger();

    public void a() {
        SM sm = GDTADManager.getInstance().getSM();
        if (sm != null) {
            this.f12683a.set(sm.getInteger("rewardVideoLoadRetryTimes", 2) - 1);
        } else {
            this.f12683a.set(1);
        }
    }

    public boolean b() {
        return this.f12683a.decrementAndGet() >= 0;
    }
}
