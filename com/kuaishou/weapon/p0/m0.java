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
/* loaded from: classes8.dex */
public class m0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m0() {
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

    /* JADX DEBUG: Throwable added to exception handler: 'SecurityException', keep only Throwable */
    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT > 22) {
                    LocationManager locationManager = (LocationManager) context.getSystemService("location");
                    LocationProvider provider = locationManager.getProvider("gps");
                    if (provider != null) {
                        locationManager.addTestProvider(provider.getName(), provider.requiresNetwork(), provider.requiresSatellite(), provider.requiresCell(), provider.hasMonetaryCost(), provider.supportsAltitude(), provider.supportsSpeed(), provider.supportsBearing(), provider.getPowerRequirement(), provider.getAccuracy());
                    } else {
                        locationManager.addTestProvider("gps", true, true, false, false, true, true, true, 3, 1);
                    }
                    locationManager.setTestProviderEnabled("gps", true);
                    locationManager.setTestProviderStatus("gps", 2, null, System.currentTimeMillis());
                } else if (Settings.Secure.getInt(context.getContentResolver(), "mock_location", 0) == 0) {
                    return false;
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
