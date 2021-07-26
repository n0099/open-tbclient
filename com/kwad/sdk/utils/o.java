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
/* loaded from: classes6.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f36774a;

    /* renamed from: b  reason: collision with root package name */
    public static Location f36775b;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static Location a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (f36774a || f36775b != null || context == null) {
                return f36775b;
            }
            if (com.kwad.sdk.core.config.c.a(64L)) {
                return null;
            }
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager.isProviderEnabled("gps")) {
                    f36775b = a(context, locationManager);
                }
                if (f36775b == null && locationManager.isProviderEnabled("network")) {
                    f36775b = b(context, locationManager);
                }
                if (f36775b == null && locationManager.isProviderEnabled("passive")) {
                    f36775b = c(context, locationManager);
                }
                return f36775b;
            } catch (Exception e2) {
                f36774a = true;
                com.kwad.sdk.core.d.a.b(e2);
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
                    Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
                    if (lastKnownLocation == null) {
                        f36774a = true;
                    }
                    return lastKnownLocation;
                }
                return null;
            } catch (Exception e2) {
                f36774a = true;
                com.kwad.sdk.core.d.a.b(e2);
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
                    Location lastKnownLocation = locationManager.getLastKnownLocation("network");
                    if (lastKnownLocation == null) {
                        f36774a = true;
                    }
                    return lastKnownLocation;
                }
                return null;
            } catch (Exception e2) {
                f36774a = true;
                com.kwad.sdk.core.d.a.b(e2);
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
                    Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
                    if (lastKnownLocation == null) {
                        f36774a = true;
                    }
                    return lastKnownLocation;
                }
                return null;
            } catch (Exception e2) {
                f36774a = true;
                com.kwad.sdk.core.d.a.b(e2);
                return null;
            }
        }
        return (Location) invokeLL.objValue;
    }
}
