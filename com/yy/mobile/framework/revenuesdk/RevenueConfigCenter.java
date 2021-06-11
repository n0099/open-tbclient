package com.yy.mobile.framework.revenuesdk;

import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class RevenueConfigCenter {
    public static final String TAG = "RevenueConfigCenter";
    public static Map<String, RevenueConfig> configMap = new HashMap();

    public static void addConfig(int i2, int i3, RevenueConfig revenueConfig) {
        String revenueConfigMapKey = getRevenueConfigMapKey(i2, i3);
        RLog.info(TAG, "addConfig mapKey:" + revenueConfigMapKey);
        configMap.put(revenueConfigMapKey, revenueConfig);
    }

    public static RevenueConfig getConfig(int i2, int i3) {
        String revenueConfigMapKey = getRevenueConfigMapKey(i2, i3);
        RLog.debug(TAG, "getConfig mapKey:" + revenueConfigMapKey);
        return configMap.get(revenueConfigMapKey);
    }

    public static String getRevenueConfigMapKey(int i2, int i3) {
        return i2 + "-" + i3;
    }

    public static void removeConfig(int i2, int i3) {
        String revenueConfigMapKey = getRevenueConfigMapKey(i2, i3);
        RLog.info(TAG, "removeConfig mapKey:" + revenueConfigMapKey);
        configMap.remove(revenueConfigMapKey);
    }
}
