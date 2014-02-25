package com;

import com.baidu.cloudsdk.common.util.PositionManager;
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ PositionManager a;

    public m(PositionManager positionManager) {
        this.a = positionManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        PositionManager.a aVar;
        PositionManager.a aVar2;
        aVar = this.a.c;
        if (aVar.isCancelled()) {
            return;
        }
        aVar2 = this.a.c;
        aVar2.cancel(true);
    }
}
