package defpackage;

import android.location.Location;
import android.util.Log;
import com.baidu.cloudsdk.common.util.PositionManager;
/* renamed from: r  reason: default package */
/* loaded from: classes.dex */
class r implements PositionManager.IPositionManagerListener {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar) {
        this.a = nVar;
    }

    @Override // com.baidu.cloudsdk.common.util.PositionManager.IPositionManagerListener
    public void onComplete(Location location) {
        this.a.a.f = location;
        this.a.a.b(location);
    }

    @Override // com.baidu.cloudsdk.common.util.PositionManager.IPositionManagerListener
    public void onFailed() {
        String str;
        str = m.a;
        Log.e(str, "request location failed");
        this.a.a.d();
    }
}
