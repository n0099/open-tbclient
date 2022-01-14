package com.kuaishou.weapon.un;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static Location f55053b;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Location a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a || f55053b != null || context == null) {
                return f55053b;
            }
            if (v.a(context).a(64)) {
                try {
                    LocationManager locationManager = (LocationManager) context.getSystemService("location");
                    if (locationManager.isProviderEnabled("gps")) {
                        f55053b = a(context, locationManager);
                    }
                    if (f55053b == null && locationManager.isProviderEnabled("network")) {
                        f55053b = b(context, locationManager);
                    }
                    if (f55053b == null && locationManager.isProviderEnabled("passive")) {
                        f55053b = c(context, locationManager);
                    }
                    return f55053b;
                } catch (Exception unused) {
                    a = true;
                    return null;
                }
            }
            return null;
        }
        return (Location) invokeL.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public static Location a(Context context, LocationManager locationManager) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, locationManager)) == null) {
            try {
                if (context.checkPermission(s.f55246g, Process.myPid(), Process.myUid()) == 0) {
                    Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
                    if (lastKnownLocation == null) {
                        a = true;
                    }
                    return lastKnownLocation;
                }
                return null;
            } catch (Exception unused) {
                a = true;
                return null;
            }
        }
        return (Location) invokeLL.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public static Location b(Context context, LocationManager locationManager) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, locationManager)) == null) {
            try {
                if (context.checkPermission(s.f55246g, Process.myPid(), Process.myUid()) == 0 || context.checkPermission(s.f55247h, Process.myPid(), Process.myUid()) == 0) {
                    Location lastKnownLocation = locationManager.getLastKnownLocation("network");
                    if (lastKnownLocation == null) {
                        a = true;
                    }
                    return lastKnownLocation;
                }
                return null;
            } catch (Exception unused) {
                a = true;
                return null;
            }
        }
        return (Location) invokeLL.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public static Location c(Context context, LocationManager locationManager) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, locationManager)) == null) {
            try {
                if (context.checkPermission(s.f55247h, Process.myPid(), Process.myUid()) == 0) {
                    Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
                    if (lastKnownLocation == null) {
                        a = true;
                    }
                    return lastKnownLocation;
                }
                return null;
            } catch (Exception unused) {
                a = true;
                return null;
            }
        }
        return (Location) invokeLL.objValue;
    }
}
