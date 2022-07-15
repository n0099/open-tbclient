package com.kuaishou.weapon.p0;

import android.content.Context;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.provider.Settings;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* renamed from: com.kuaishou.weapon.p0.ﾞ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0454 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public C0454() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static boolean m1015(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (Build.VERSION.SDK_INT > 22) {
                try {
                    LocationManager locationManager = (LocationManager) context.getSystemService("location");
                    LocationProvider provider = locationManager.getProvider("gps");
                    if (provider != null) {
                        locationManager.addTestProvider(provider.getName(), provider.requiresNetwork(), provider.requiresSatellite(), provider.requiresCell(), provider.hasMonetaryCost(), provider.supportsAltitude(), provider.supportsSpeed(), provider.supportsBearing(), provider.getPowerRequirement(), provider.getAccuracy());
                    } else {
                        locationManager.addTestProvider("gps", true, true, false, false, true, true, true, 3, 1);
                    }
                    locationManager.setTestProviderEnabled("gps", true);
                    locationManager.setTestProviderStatus("gps", 2, null, System.currentTimeMillis());
                    return true;
                } catch (SecurityException unused) {
                }
            } else if (Settings.Secure.getInt(context.getContentResolver(), "mock_location", 0) != 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
