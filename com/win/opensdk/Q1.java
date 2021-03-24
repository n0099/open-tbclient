package com.win.opensdk;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
/* loaded from: classes7.dex */
public class Q1 {
    public static void a(Context context) {
        O1 o1 = new O1(null);
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            List<String> providers = locationManager.getProviders(true);
            String str = providers.contains("network") ? "network" : providers.contains("gps") ? "gps" : null;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation(str);
            if (lastKnownLocation != null) {
                o1.onLocationChanged(lastKnownLocation);
            } else {
                locationManager.requestLocationUpdates(str, 1000L, 0.0f, o1, Looper.getMainLooper());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
