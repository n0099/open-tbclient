package com.win.opensdk;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.List;
/* loaded from: classes4.dex */
public class au {
    public static final String java = au.class.getSimpleName();

    public static void iK(Context context) {
        b bVar = new b((byte) 0);
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            String str = null;
            List<String> providers = locationManager.getProviders(true);
            if (providers.contains("network")) {
                str = "network";
            } else if (providers.contains("gps")) {
                str = "gps";
            }
            if (!TextUtils.isEmpty(str)) {
                Location lastKnownLocation = locationManager.getLastKnownLocation(str);
                if (lastKnownLocation != null) {
                    bVar.onLocationChanged(lastKnownLocation);
                } else {
                    locationManager.requestLocationUpdates(str, 1000L, 0.0f, bVar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* loaded from: classes4.dex */
    static class b implements LocationListener {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            a.eKa().qcY = location.getLatitude();
            a.eKa().qcZ = location.getLongitude();
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private static final a qcX = new a();
        public double qcY;
        public double qcZ;

        public static a eKa() {
            return qcX;
        }
    }
}
