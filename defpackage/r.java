package defpackage;

import android.location.Location;
import android.util.Log;
import com.baidu.cloudsdk.common.util.PositionManager;
/* renamed from: r  reason: default package */
/* loaded from: classes.dex */
class r implements PositionManager.IPositionManagerListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f2969a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar) {
        this.f2969a = nVar;
    }

    @Override // com.baidu.cloudsdk.common.util.PositionManager.IPositionManagerListener
    public void onComplete(Location location) {
        this.f2969a.f2866a.f = location;
        this.f2969a.f2866a.b(location);
    }

    @Override // com.baidu.cloudsdk.common.util.PositionManager.IPositionManagerListener
    public void onFailed() {
        String str;
        str = m.f2865a;
        Log.e(str, "request location failed");
        this.f2969a.f2866a.d();
    }
}
