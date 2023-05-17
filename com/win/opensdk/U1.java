package com.win.opensdk;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes10.dex */
public class U1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            S1 s1 = new S1(null);
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                List<String> providers = locationManager.getProviders(true);
                if (providers.contains("network")) {
                    str = "network";
                } else if (providers.contains("gps")) {
                    str = "gps";
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    Location lastKnownLocation = locationManager.getLastKnownLocation(str);
                    if (lastKnownLocation != null) {
                        s1.onLocationChanged(lastKnownLocation);
                    } else {
                        locationManager.requestLocationUpdates(str, 1000L, 0.0f, s1, Looper.getMainLooper());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
