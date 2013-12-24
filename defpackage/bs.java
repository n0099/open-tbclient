package defpackage;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.baidu.cloudsdk.common.util.PositionManager;
/* renamed from: bs  reason: default package */
/* loaded from: classes.dex */
public class bs implements LocationListener {
    final /* synthetic */ PositionManager.a a;

    public bs(PositionManager.a aVar) {
        this.a = aVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        PositionManager.this.b = location;
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
