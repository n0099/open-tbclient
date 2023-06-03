package org.chromium.base.compat;

import android.annotation.TargetApi;
import android.content.pm.PackageInfo;
import android.location.LocationManager;
import android.net.LinkProperties;
import org.chromium.base.annotations.VerifiesOnP;
@TargetApi(28)
@VerifiesOnP
/* loaded from: classes2.dex */
public final class ApiHelperForP {
    public static long getLongVersionCode(PackageInfo packageInfo) {
        return packageInfo.getLongVersionCode();
    }

    public static String getPrivateDnsServerName(LinkProperties linkProperties) {
        return linkProperties.getPrivateDnsServerName();
    }

    public static boolean isLocationEnabled(LocationManager locationManager) {
        return locationManager.isLocationEnabled();
    }

    public static boolean isPrivateDnsActive(LinkProperties linkProperties) {
        return linkProperties.isPrivateDnsActive();
    }
}
