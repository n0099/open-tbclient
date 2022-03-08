package com.kuaishou.weapon;

import android.location.Location;
import java.util.List;
/* loaded from: classes7.dex */
public interface IWeaponInitParams {
    String getAndroidID();

    String getAppKey();

    String getChannel();

    String getDeviceId();

    String getHost();

    String getImei();

    String[] getImeis();

    List<String> getInstalledPackages();

    Location getLocation();

    String getMacAddress();

    String getOaid();

    int getPS();

    boolean getPrivacySwitch();

    String getProductName();

    String getSecKey();

    String getUserId();
}
