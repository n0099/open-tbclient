package com;

import android.location.Location;
import android.util.Log;
import com.baidu.cloudsdk.common.util.PositionManager;
import com.baidu.cloudsdk.social.share.uiwithlayout.LocationPreview;
/* loaded from: classes.dex */
class r implements PositionManager.IPositionManagerListener {
    final /* synthetic */ q cX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cX = qVar;
    }

    @Override // com.baidu.cloudsdk.common.util.PositionManager.IPositionManagerListener
    public void onComplete(Location location) {
        this.cX.cW.g = location;
        this.cX.cW.a(location);
    }

    @Override // com.baidu.cloudsdk.common.util.PositionManager.IPositionManagerListener
    public void onFailed() {
        String str;
        str = LocationPreview.a;
        Log.e(str, "request location failed");
        this.cX.cW.b();
    }
}
