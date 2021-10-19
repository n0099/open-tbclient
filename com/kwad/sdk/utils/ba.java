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
import com.kwad.sdk.api.SdkConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class ba {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f74294a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f74295b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<com.kwad.sdk.core.g.a.a> f74296c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(408734979, "Lcom/kwad/sdk/utils/ba;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(408734979, "Lcom/kwad/sdk/utils/ba;");
                return;
            }
        }
        f74296c = new ArrayList();
    }

    public static List<com.kwad.sdk.core.g.a.a> a(Context context, int i2) {
        InterceptResult invokeLI;
        WifiManager wifiManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i2)) == null) {
            if (f74295b || !f74294a || !f74296c.isEmpty() || context == null) {
                return f74296c;
            }
            if (com.kwad.sdk.core.config.c.a(32L)) {
                return f74296c;
            }
            try {
            } catch (Exception e2) {
                f74295b = true;
                com.kwad.sdk.core.d.a.b(e2);
            }
            if ((Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != -1 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != -1) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                List<ScanResult> scanResults = wifiManager.getScanResults();
                if (scanResults != null) {
                    for (ScanResult scanResult : scanResults) {
                        com.kwad.sdk.core.g.a.a aVar = new com.kwad.sdk.core.g.a.a();
                        aVar.f72113b = scanResult.SSID;
                        aVar.f72114c = scanResult.BSSID;
                        aVar.f72112a = scanResult.level;
                        if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                            f74296c.add(aVar);
                        } else {
                            f74296c.add(0, aVar);
                        }
                        if (f74296c.size() >= i2) {
                            return f74296c;
                        }
                    }
                }
                return f74296c;
            }
            return f74296c;
        }
        return (List) invokeLI.objValue;
    }

    public static void a(SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, sdkConfig) == null) {
            f74294a = sdkConfig.canReadNearbyWifiList();
        }
    }
}
