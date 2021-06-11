package com.yy.mobile.framework.revenuesdk;

import com.yy.mobile.framework.revenuesdk.baseapi.data.RevenueDataParser;
import com.yy.mobile.framework.revenuesdk.baseapi.log.IRLogDelegate;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class RevenueSdk {
    public static final String TAG = "RevenueSdk";
    public static Map<String, IRevenue> iRevenueMap = new HashMap();

    public static void addLogDelegate(IRLogDelegate iRLogDelegate) {
        RLog.addLogDelegate(iRLogDelegate);
    }

    public static synchronized IRevenue addRevenueConfig(int i2, int i3, RevenueConfig revenueConfig) {
        IRevenue iRevenue;
        synchronized (RevenueSdk.class) {
            String revenueMapKey = getRevenueMapKey(i2, i3);
            RLog.info(TAG, "initRevenue: appId =" + i2 + " userchanel=" + i3 + " mapKey=" + revenueMapKey);
            if (iRevenueMap.get(revenueMapKey) == null) {
                try {
                    Revenue revenue = new Revenue(i2, i3);
                    revenue.initConfig(revenueConfig);
                    RevenueDataParser.INSTANCE.registerDataReceivers(revenue);
                    iRevenueMap.put(revenueMapKey, revenue);
                } catch (Exception e2) {
                    RLog.error(TAG, "initRevenue error.", e2);
                    return null;
                }
            } else {
                RevenueConfigCenter.addConfig(i2, i3, revenueConfig);
            }
            iRevenue = iRevenueMap.get(revenueMapKey);
        }
        return iRevenue;
    }

    public static synchronized List<IRevenue> getAllRevenue() {
        ArrayList arrayList;
        synchronized (RevenueSdk.class) {
            arrayList = new ArrayList();
            for (int i2 = 0; i2 < iRevenueMap.size(); i2++) {
                arrayList.add(iRevenueMap.get(Integer.valueOf(i2)));
            }
        }
        return arrayList;
    }

    public static synchronized IRevenue getRevenue(int i2, int i3) {
        IRevenue iRevenue;
        synchronized (RevenueSdk.class) {
            String revenueMapKey = getRevenueMapKey(i2, i3);
            iRevenue = iRevenueMap.get(revenueMapKey);
            if (iRevenue == null) {
                RLog.error(TAG, "getRevenue == null,mapKey = %d", revenueMapKey);
            }
        }
        return iRevenue;
    }

    public static String getRevenueMapKey(int i2, int i3) {
        return i2 + "-" + i3;
    }

    public static synchronized void removeRevenueConfig(int i2, int i3) {
        synchronized (RevenueSdk.class) {
            String revenueMapKey = getRevenueMapKey(i2, i3);
            if (iRevenueMap.get(revenueMapKey) == null) {
                RLog.error(TAG, "removeRevenueConfig buy get null mapKey:" + revenueMapKey, new Object[0]);
                return;
            }
            iRevenueMap.remove(revenueMapKey);
            RLog.info(TAG, "removeRevenueConfig: appId =" + i2 + " userchanel=" + i3 + " mapKey=" + revenueMapKey + " mapSize:" + iRevenueMap.size());
            RevenueConfigCenter.removeConfig(i2, i3);
        }
    }
}
