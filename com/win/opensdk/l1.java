package com.win.opensdk;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* loaded from: classes7.dex */
public class l1 implements LocationListener {
    public /* synthetic */ l1(k1 k1Var) {
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        m1.f37085c.f37086a = location.getLatitude();
        m1.f37085c.f37087b = location.getLongitude();
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
