package defpackage;

import android.location.Location;
import android.util.Log;
import com.baidu.cloudsdk.common.util.PositionManager;
/* renamed from: r  reason: default package */
/* loaded from: classes.dex */
class r implements PositionManager.IPositionManagerListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f2937a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar) {
        this.f2937a = nVar;
    }

    @Override // com.baidu.cloudsdk.common.util.PositionManager.IPositionManagerListener
    public void onComplete(Location location) {
        this.f2937a.f2834a.f = location;
        this.f2937a.f2834a.b(location);
    }

    @Override // com.baidu.cloudsdk.common.util.PositionManager.IPositionManagerListener
    public void onFailed() {
        String str;
        str = m.f2833a;
        Log.e(str, "request location failed");
        this.f2937a.f2834a.d();
    }
}
