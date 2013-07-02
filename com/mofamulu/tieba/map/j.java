package com.mofamulu.tieba.map;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements LocationListener {
    final /* synthetic */ FreeLocationService a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FreeLocationService freeLocationService, boolean z) {
        this.a = freeLocationService;
        this.b = z;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        LocationManager locationManager;
        try {
            this.a.a(location);
            if (location.getProvider() != null) {
                this.a.k = location.getProvider();
            }
            if (this.b) {
                this.a.a((String) null);
            }
        } catch (Throwable th) {
            this.a.b(this.b);
        }
        locationManager = this.a.j;
        locationManager.removeUpdates(this);
        this.a.b = null;
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        LocationManager locationManager;
        this.a.b(this.b);
        locationManager = this.a.j;
        locationManager.removeUpdates(this);
        this.a.b = null;
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
