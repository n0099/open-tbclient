package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static Location a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                Location a2 = locationManager.isProviderEnabled("gps") ? a(context, locationManager) : null;
                if (a2 == null && locationManager.isProviderEnabled("network")) {
                    a2 = b(context, locationManager);
                }
                return (a2 == null && locationManager.isProviderEnabled("passive")) ? c(context, locationManager) : a2;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return null;
            }
        }
        return (Location) invokeL.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public static Location a(Context context, LocationManager locationManager) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, locationManager)) == null) {
            try {
                if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                    return locationManager.getLastKnownLocation("gps");
                }
                return null;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return null;
            }
        }
        return (Location) invokeLL.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public static Location b(Context context, LocationManager locationManager) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, locationManager)) == null) {
            try {
                if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    return locationManager.getLastKnownLocation("network");
                }
                return null;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return null;
            }
        }
        return (Location) invokeLL.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public static Location c(Context context, LocationManager locationManager) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, locationManager)) == null) {
            try {
                if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    return locationManager.getLastKnownLocation("passive");
                }
                return null;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return null;
            }
        }
        return (Location) invokeLL.objValue;
    }
}
