package com.example.utility_plugin;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class SharePrefNameTransform {
    public static HashMap<String, String> sharePrefNameMap;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        sharePrefNameMap = hashMap;
        hashMap.put("CashLoanRedPoint", "key_has_borrow_cash_clicked");
        sharePrefNameMap.put("BaiduFinanceRedPoint", "key_baidu_financial_has_clicked");
        sharePrefNameMap.put("kPreferenceKeyRedPacketRedPoint", "key_has_my_redpacket_clicked");
        sharePrefNameMap.put("ServiceCenter", "key_feedback_tip_show");
        sharePrefNameMap.put("MyTabGuidanceAnimationHasShown", "has_shown_person_center_guide");
    }

    public static String getAndroidNameFromIos(String str) {
        return sharePrefNameMap.containsKey(str) ? sharePrefNameMap.get(str) : str;
    }
}
