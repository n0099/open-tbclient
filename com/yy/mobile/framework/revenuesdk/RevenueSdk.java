package com.yy.mobile.framework.revenuesdk;

import com.yy.mobile.framework.revenuesdk.baseapi.data.RevenueDataParser;
import com.yy.mobile.framework.revenuesdk.baseapi.log.IRLogDelegate;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class RevenueSdk {
    public static final String TAG = "RevenueSdk";
    public static Map<String, IRevenue> iRevenueMap = new HashMap();

    public static synchronized List<IRevenue> getAllRevenue() {
        ArrayList arrayList;
        synchronized (RevenueSdk.class) {
            arrayList = new ArrayList();
            for (int i = 0; i < iRevenueMap.size(); i++) {
                arrayList.add(iRevenueMap.get(Integer.valueOf(i)));
            }
        }
        return arrayList;
    }

    public static void addLogDelegate(IRLogDelegate iRLogDelegate) {
        RLog.addLogDelegate(iRLogDelegate);
    }

    public static synchronized IRevenue addRevenueConfig(int i, int i2, RevenueConfig revenueConfig) {
        IRevenue iRevenue;
        synchronized (RevenueSdk.class) {
            String revenueMapKey = getRevenueMapKey(i, i2);
            RLog.info(TAG, "initRevenue: appId =" + i + " userchanel=" + i2 + " mapKey=" + revenueMapKey);
            if (iRevenueMap.get(revenueMapKey) == null) {
                try {
                    Revenue revenue = new Revenue(i, i2);
                    revenue.initConfig(revenueConfig);
                    RevenueDataParser.INSTANCE.registerDataReceivers(revenue);
                    iRevenueMap.put(revenueMapKey, revenue);
                } catch (Exception e) {
                    RLog.error(TAG, "initRevenue error.", e);
                    return null;
                }
            } else {
                RevenueConfigCenter.addConfig(i, i2, revenueConfig);
            }
            iRevenue = iRevenueMap.get(revenueMapKey);
        }
        return iRevenue;
    }

    public static synchronized IRevenue getRevenue(int i, int i2) {
        IRevenue iRevenue;
        synchronized (RevenueSdk.class) {
            String revenueMapKey = getRevenueMapKey(i, i2);
            iRevenue = iRevenueMap.get(revenueMapKey);
            if (iRevenue == null) {
                RLog.error(TAG, "getRevenue == null,mapKey = %d", revenueMapKey);
            }
        }
        return iRevenue;
    }

    public static String getRevenueMapKey(int i, int i2) {
        return i + "-" + i2;
    }

    public static synchronized void removeRevenueConfig(int i, int i2) {
        synchronized (RevenueSdk.class) {
            String revenueMapKey = getRevenueMapKey(i, i2);
            if (iRevenueMap.get(revenueMapKey) == null) {
                RLog.error(TAG, "removeRevenueConfig buy get null mapKey:" + revenueMapKey, new Object[0]);
                return;
            }
            iRevenueMap.remove(revenueMapKey);
            RLog.info(TAG, "removeRevenueConfig: appId =" + i + " userchanel=" + i2 + " mapKey=" + revenueMapKey + " mapSize:" + iRevenueMap.size());
            RevenueConfigCenter.removeConfig(i, i2);
        }
    }
}
