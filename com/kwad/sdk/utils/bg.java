package com.kwad.sdk.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kuaishou.weapon.adsdk.DeviceInfo;
import com.kwad.sdk.api.SdkConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class bg {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f59639b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<com.kwad.sdk.core.request.model.a> f59640c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(408735165, "Lcom/kwad/sdk/utils/bg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(408735165, "Lcom/kwad/sdk/utils/bg;");
                return;
            }
        }
        f59640c = new ArrayList();
    }

    public static List<com.kwad.sdk.core.request.model.a> a(Context context, int i2) {
        InterceptResult invokeLI;
        WifiManager wifiManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i2)) == null) {
            if (ao.k()) {
                return new ArrayList();
            }
            if (f59639b || !a || !f59640c.isEmpty() || context == null) {
                return f59640c;
            }
            if (com.kwad.sdk.core.config.b.a(32L)) {
                return f59640c;
            }
            try {
            } catch (Exception e2) {
                f59639b = true;
                com.kwad.sdk.core.d.a.b(e2);
            }
            if (!a(context) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                List<ScanResult> wifiScanResults = com.kwad.sdk.b.a.booleanValue() ? DeviceInfo.getWifiScanResults(context) : wifiManager.getScanResults();
                if (wifiScanResults != null) {
                    for (ScanResult scanResult : wifiScanResults) {
                        com.kwad.sdk.core.request.model.a aVar = new com.kwad.sdk.core.request.model.a();
                        aVar.f57762b = scanResult.SSID;
                        aVar.f57763c = scanResult.BSSID;
                        aVar.a = scanResult.level;
                        if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                            f59640c.add(aVar);
                        } else {
                            f59640c.add(0, aVar);
                        }
                        if (f59640c.size() >= i2) {
                            return f59640c;
                        }
                    }
                }
                return f59640c;
            }
            return f59640c;
        }
        return (List) invokeLI.objValue;
    }

    public static void a(SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, sdkConfig) == null) {
            a = sdkConfig.canReadNearbyWifiList();
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f56842g) == -1 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f56843h) == -1 : ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f56842g) == -1 : invokeL.booleanValue;
    }
}
