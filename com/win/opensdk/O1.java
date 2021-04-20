package com.win.opensdk;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* loaded from: classes7.dex */
public class O1 implements LocationListener {
    public /* synthetic */ O1(N1 n1) {
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        P1.f40033c.f40034a = location.getLatitude();
        P1.f40033c.f40035b = location.getLongitude();
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
