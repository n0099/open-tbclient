package com.win.opensdk;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
/* loaded from: classes14.dex */
public class bc {
    public static void a(Context context) {
        String str = null;
        as asVar = new as(null);
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(Headers.LOCATION);
            List<String> providers = locationManager.getProviders(true);
            if (providers.contains("network")) {
                str = "network";
            } else if (providers.contains("gps")) {
                str = "gps";
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation(str);
            if (lastKnownLocation != null) {
                asVar.onLocationChanged(lastKnownLocation);
            } else {
                locationManager.requestLocationUpdates(str, 1000L, 0.0f, asVar, Looper.getMainLooper());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
