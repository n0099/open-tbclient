package com.yy.mobile.framework.revenuesdk;

import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class RevenueConfigCenter {
    public static final String TAG = "RevenueConfigCenter";
    public static Map<String, RevenueConfig> configMap = new HashMap();

    public static void addConfig(int i, int i2, RevenueConfig revenueConfig) {
        String revenueConfigMapKey = getRevenueConfigMapKey(i, i2);
        RLog.info(TAG, "addConfig mapKey:" + revenueConfigMapKey);
        configMap.put(revenueConfigMapKey, revenueConfig);
    }

    public static RevenueConfig getConfig(int i, int i2) {
        String revenueConfigMapKey = getRevenueConfigMapKey(i, i2);
        RLog.debug(TAG, "getConfig mapKey:" + revenueConfigMapKey);
        return configMap.get(revenueConfigMapKey);
    }

    public static String getRevenueConfigMapKey(int i, int i2) {
        return i + "-" + i2;
    }

    public static void removeConfig(int i, int i2) {
        String revenueConfigMapKey = getRevenueConfigMapKey(i, i2);
        RLog.info(TAG, "removeConfig mapKey:" + revenueConfigMapKey);
        configMap.remove(revenueConfigMapKey);
    }
}
