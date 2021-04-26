package com.win.opensdk;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* loaded from: classes6.dex */
public class l1 implements LocationListener {
    public /* synthetic */ l1(k1 k1Var) {
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        m1.f37911c.f37912a = location.getLatitude();
        m1.f37911c.f37913b = location.getLongitude();
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i2, Bundle bundle) {
    }
}
