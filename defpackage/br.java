package defpackage;

import com.baidu.cloudsdk.common.util.PositionManager;
/* renamed from: br  reason: default package */
/* loaded from: classes.dex */
public class br implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PositionManager f386a;

    public br(PositionManager positionManager) {
        this.f386a = positionManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        PositionManager.a aVar;
        PositionManager.a aVar2;
        aVar = this.f386a.c;
        if (aVar.isCancelled()) {
            return;
        }
        aVar2 = this.f386a.c;
        aVar2.cancel(true);
    }
}
