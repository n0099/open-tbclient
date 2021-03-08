package com.win.opensdk;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* loaded from: classes14.dex */
public class as implements LocationListener {
    public /* synthetic */ as(aq aqVar) {
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        av.qkR.f8113a = location.getLatitude();
        av.qkR.b = location.getLongitude();
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
