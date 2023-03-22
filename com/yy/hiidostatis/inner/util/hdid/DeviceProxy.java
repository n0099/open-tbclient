package com.yy.hiidostatis.inner.util.hdid;

import android.content.Context;
import com.yy.hiidostatis.inner.util.log.L;
/* loaded from: classes9.dex */
public class DeviceProxy {
    public static String getAndroidId(Context context) {
        return getDevice(context).arid;
    }

    public static long getCreateTime(Context context) {
        return getDevice(context).crtTime;
    }

    public static Device getDevice(Context context) {
        return DeviceManagerV2.instance.getDevice(context);
    }

    public static int getHFrom(Context context) {
        return getDevice(context).hFrom;
    }

    public static String getHdid(Context context) {
        return getDevice(context).hdid;
    }

    public static String getImei(Context context) {
        return getDevice(context).imei;
    }

    public static String getMac(Context context) {
        return getDevice(context).mac;
    }

    public static String getSdPermission(Context context) {
        return getDevice(context).sdPermission;
    }

    public static String getType(Context context) {
        return getDevice(context).type;
    }

    public static void test(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        L.debug("DeviceProxy", "DeviceTest:%d==>%s,%s,%s,%s,%s,%d,%s,%d,%d", Long.valueOf(Thread.currentThread().getId()), getHdid(context), getImei(context), getMac(context), getAndroidId(context), getType(context) + "", Integer.valueOf(getHFrom(context)), getSdPermission(context), Long.valueOf(getCreateTime(context)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }
}
