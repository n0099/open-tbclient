package com;

import android.location.Location;
import android.util.Log;
import com.baidu.cloudsdk.common.util.PositionManager;
import com.baidu.cloudsdk.social.share.uiwithlayout.LocationPreview;
/* loaded from: classes.dex */
class r implements PositionManager.IPositionManagerListener {
    final /* synthetic */ q dB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.dB = qVar;
    }

    @Override // com.baidu.cloudsdk.common.util.PositionManager.IPositionManagerListener
    public void onComplete(Location location) {
        this.dB.dA.g = location;
        this.dB.dA.a(location);
    }

    @Override // com.baidu.cloudsdk.common.util.PositionManager.IPositionManagerListener
    public void onFailed() {
        String str;
        str = LocationPreview.a;
        Log.e(str, "request location failed");
        this.dB.dA.b();
    }
}
