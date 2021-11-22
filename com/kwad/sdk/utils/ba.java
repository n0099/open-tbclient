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
/* loaded from: classes2.dex */
public class ba {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f67589a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f67590b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<com.kwad.sdk.core.g.a.a> f67591c;
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
        f67591c = new ArrayList();
    }

    public static List<com.kwad.sdk.core.g.a.a> a(Context context, int i2) {
        InterceptResult invokeLI;
        WifiManager wifiManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i2)) == null) {
            if (f67590b || !f67589a || !f67591c.isEmpty() || context == null) {
                return f67591c;
            }
            if (com.kwad.sdk.core.config.c.a(32L)) {
                return f67591c;
            }
            try {
            } catch (Exception e2) {
                f67590b = true;
                com.kwad.sdk.core.d.a.b(e2);
            }
            if ((Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != -1 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != -1) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                List<ScanResult> scanResults = wifiManager.getScanResults();
                if (scanResults != null) {
                    for (ScanResult scanResult : scanResults) {
                        com.kwad.sdk.core.g.a.a aVar = new com.kwad.sdk.core.g.a.a();
                        aVar.f65489b = scanResult.SSID;
                        aVar.f65490c = scanResult.BSSID;
                        aVar.f65488a = scanResult.level;
                        if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                            f67591c.add(aVar);
                        } else {
                            f67591c.add(0, aVar);
                        }
                        if (f67591c.size() >= i2) {
                            return f67591c;
                        }
                    }
                }
                return f67591c;
            }
            return f67591c;
        }
        return (List) invokeLI.objValue;
    }

    public static void a(SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, sdkConfig) == null) {
            f67589a = sdkConfig.canReadNearbyWifiList();
        }
    }
}
