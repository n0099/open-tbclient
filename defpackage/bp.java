package defpackage;

import com.baidu.cloudsdk.common.util.CoordinateManager;
/* renamed from: bp  reason: default package */
/* loaded from: classes.dex */
public class bp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CoordinateManager f384a;

    public bp(CoordinateManager coordinateManager) {
        this.f384a = coordinateManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        CoordinateManager.a aVar;
        CoordinateManager.a aVar2;
        aVar = this.f384a.d;
        if (aVar.isCancelled()) {
            return;
        }
        aVar2 = this.f384a.d;
        aVar2.cancel(true);
    }
}
