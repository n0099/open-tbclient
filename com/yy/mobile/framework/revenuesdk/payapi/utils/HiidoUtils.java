package com.yy.mobile.framework.revenuesdk.payapi.utils;

import android.content.Context;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes2.dex */
public class HiidoUtils {
    public static final String TAG = "HiidoUtils";

    public static String getHdid(Context context) {
        if (context == null) {
            RLog.error(TAG, "getHdid error context null", new Object[0]);
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String hdidSync = HiidoSDK.instance().getHdidSync(context);
        if (hdidSync != null) {
            RLog.debug(TAG, "getHdid hdid:" + hdidSync);
        } else {
            RLog.error(TAG, "getHdid hdid null", new Object[0]);
        }
        RLog.debug(TAG, "getHdid cost time = " + (System.currentTimeMillis() - currentTimeMillis));
        if (hdidSync == null) {
            return "";
        }
        return hdidSync;
    }
}
