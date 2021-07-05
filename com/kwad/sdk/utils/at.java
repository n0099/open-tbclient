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
/* loaded from: classes7.dex */
public class at {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f39380a = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(408734607, "Lcom/kwad/sdk/utils/at;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(408734607, "Lcom/kwad/sdk/utils/at;");
        }
    }

    public static List<com.kwad.sdk.core.g.a.a> a(Context context, int i2) {
        InterceptResult invokeLI;
        WifiManager wifiManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context != null && f39380a) {
                try {
                    if ((Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == -1) || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null) {
                        return arrayList;
                    }
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    List<ScanResult> scanResults = wifiManager.getScanResults();
                    if (scanResults != null) {
                        for (ScanResult scanResult : scanResults) {
                            com.kwad.sdk.core.g.a.a aVar = new com.kwad.sdk.core.g.a.a();
                            aVar.f36117b = scanResult.SSID;
                            aVar.f36118c = scanResult.BSSID;
                            aVar.f36116a = scanResult.level;
                            if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                                arrayList.add(aVar);
                            } else {
                                arrayList.add(0, aVar);
                            }
                            if (arrayList.size() >= i2) {
                                return arrayList;
                            }
                        }
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
            return arrayList;
        }
        return (List) invokeLI.objValue;
    }

    public static void a(SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, sdkConfig) == null) {
            f39380a = sdkConfig.canReadNearbyWifiList();
        }
    }
}
