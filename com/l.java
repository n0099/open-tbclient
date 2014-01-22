package com;

import android.location.Location;
import android.util.Log;
import com.baidu.cloudsdk.common.util.PositionManager;
import com.baidu.cloudsdk.social.share.uiwithlayout.LocationPreview;
/* loaded from: classes.dex */
class l implements PositionManager.IPositionManagerListener {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.a = kVar;
    }

    @Override // com.baidu.cloudsdk.common.util.PositionManager.IPositionManagerListener
    public void onComplete(Location location) {
        this.a.a.g = location;
        this.a.a.a(location);
    }

    @Override // com.baidu.cloudsdk.common.util.PositionManager.IPositionManagerListener
    public void onFailed() {
        String str;
        str = LocationPreview.a;
        Log.e(str, "request location failed");
        this.a.a.b();
    }
}
