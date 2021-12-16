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
/* loaded from: classes3.dex */
public class bg {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f60220b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<com.kwad.sdk.core.request.model.a> f60221c;
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
        f60221c = new ArrayList();
    }

    public static List<com.kwad.sdk.core.request.model.a> a(Context context, int i2) {
        InterceptResult invokeLI;
        WifiManager wifiManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i2)) == null) {
            if (ao.k()) {
                return new ArrayList();
            }
            if (f60220b || !a || !f60221c.isEmpty() || context == null) {
                return f60221c;
            }
            if (com.kwad.sdk.core.config.b.a(32L)) {
                return f60221c;
            }
            try {
            } catch (Exception e2) {
                f60220b = true;
                com.kwad.sdk.core.d.a.b(e2);
            }
            if (!a(context) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                List<ScanResult> wifiScanResults = com.kwad.sdk.b.a.booleanValue() ? DeviceInfo.getWifiScanResults(context) : wifiManager.getScanResults();
                if (wifiScanResults != null) {
                    for (ScanResult scanResult : wifiScanResults) {
                        com.kwad.sdk.core.request.model.a aVar = new com.kwad.sdk.core.request.model.a();
                        aVar.f58343b = scanResult.SSID;
                        aVar.f58344c = scanResult.BSSID;
                        aVar.a = scanResult.level;
                        if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                            f60221c.add(aVar);
                        } else {
                            f60221c.add(0, aVar);
                        }
                        if (f60221c.size() >= i2) {
                            return f60221c;
                        }
                    }
                }
                return f60221c;
            }
            return f60221c;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f57423g) == -1 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f57424h) == -1 : ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f57423g) == -1 : invokeL.booleanValue;
    }
}
