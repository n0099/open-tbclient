package defpackage;

import android.location.Location;
import android.util.Log;
import com.baidu.cloudsdk.common.util.PositionManager;
/* renamed from: r  reason: default package */
/* loaded from: classes.dex */
class r implements PositionManager.IPositionManagerListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f3150a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar) {
        this.f3150a = nVar;
    }

    @Override // com.baidu.cloudsdk.common.util.PositionManager.IPositionManagerListener
    public void onComplete(Location location) {
        this.f3150a.f3047a.f = location;
        this.f3150a.f3047a.b(location);
    }

    @Override // com.baidu.cloudsdk.common.util.PositionManager.IPositionManagerListener
    public void onFailed() {
        String str;
        str = m.f3046a;
        Log.e(str, "request location failed");
        this.f3150a.f3047a.d();
    }
}
