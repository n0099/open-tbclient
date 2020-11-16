package com.example.utility_plugin;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import java.util.HashMap;
/* loaded from: classes12.dex */
public class SharePrefNameTransform {
    private static HashMap<String, String> sharePrefNameMap = new HashMap<>();

    static {
        sharePrefNameMap.put("CashLoanRedPoint", SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED);
        sharePrefNameMap.put("BaiduFinanceRedPoint", "key_baidu_financial_has_clicked");
        sharePrefNameMap.put("kPreferenceKeyRedPacketRedPoint", "key_has_my_redpacket_clicked");
        sharePrefNameMap.put("ServiceCenter", SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW);
        sharePrefNameMap.put("MyTabGuidanceAnimationHasShown", "has_shown_person_center_guide");
    }

    public static String getAndroidNameFromIos(String str) {
        return sharePrefNameMap.containsKey(str) ? sharePrefNameMap.get(str) : str;
    }
}
