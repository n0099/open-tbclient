package com.yy.mobile.framework.revenuesdk.payservice.utils;

import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class JsonDataParerUtil {
    public static final String TAG = "AppPayServiceImpl";

    public static String getCHOrderId(String str) {
        String str2 = "";
        if (str != null) {
            try {
                String string = new JSONObject(str).getString("developerPayload");
                if (string != null && !string.equals("")) {
                    String string2 = new JSONObject(string).getString("chOrderId");
                    if (string2 != null) {
                        str2 = string2;
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                RLog.error("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getCHOrderId--PayCallbackProxy data =%s , Exception =%s", str, e2.getMessage()), new Object[0]);
            }
        }
        RLog.info("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser success ---PayCallbackProxy data =%s , chorderId =%s", str, str2));
        return str2;
    }

    public static String getChOrderidByPayload(String str) {
        if (str != null) {
            try {
                String string = new JSONObject(str).getString("chOrderId");
                if (string != null && !string.equals("")) {
                    return string;
                }
                RLog.warn("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getChOrderidByPayload =null ", new Object[0]));
                return "";
            } catch (JSONException e2) {
                e2.printStackTrace();
                RLog.warn("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getPayLoad--getChOrderidByPayload data =%s , Exception =%s", str, e2.getMessage()));
            }
        }
        RLog.debug("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser success ---getChOrderidByPayload data =%s , getPayLoad =%s", str, ""));
        return "";
    }

    public static String getChallengeExtension(String str) {
        String str2 = "";
        if (str != null) {
            try {
                String string = new JSONObject(str).getString("riskData");
                if (string != null && !string.equals("")) {
                    str2 = new JSONObject(string).getString("challengeExtension");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                RLog.debug("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getChallengeExtension--PayCallbackProxy data =%s , Exception =%s", str, e2.getMessage()));
            }
        }
        RLog.debug("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser success ---getChallengeExtension data =%s , purchaseTime =%s", str, str2));
        return str2;
    }

    public static String getGPOrderId(String str) {
        String str2 = "";
        if (str != null) {
            try {
                String string = new JSONObject(str).getString("orderId");
                if (string != null) {
                    str2 = string;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                RLog.error("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getPurchaseTime--PayCallbackProxy data =%s , Exception =%s", str, e2.getMessage()), new Object[0]);
            }
        }
        RLog.info("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser success ---PayCallbackProxy data =%s , orderId =%s", str, str2));
        return str2;
    }

    public static String getPayLoad(String str) {
        if (str != null) {
            try {
                String string = new JSONObject(str).getString("developerPayload");
                if (string != null && !string.equals("")) {
                    return string;
                }
                RLog.error("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getPayLoad =null ", new Object[0]), new Object[0]);
                return "";
            } catch (JSONException e2) {
                e2.printStackTrace();
                RLog.warn("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getPayLoad--PayCallbackProxy data =%s , Exception =%s", str, e2.getMessage()));
            }
        }
        RLog.info("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser success ---PayCallbackProxy data =%s , getPayLoad =%s", str, ""));
        return "";
    }

    public static String getProductId(String str) {
        String str2 = "";
        if (str != null) {
            try {
                String string = new JSONObject(str).getString("productId");
                if (string != null) {
                    str2 = string;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                RLog.error("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --productId--PayCallbackProxy data =%s , Exception =%s", str, e2.getMessage()), new Object[0]);
            }
        }
        RLog.info("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser success ---PayCallbackProxy data =%s , orderId =%s", str, str2));
        return str2;
    }

    public static PurchaseInfo getPurchaseInfoByProductId(String str, List<PurchaseInfo> list) {
        for (PurchaseInfo purchaseInfo : list) {
            try {
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (str == new JSONObject(purchaseInfo.data).optString("productId")) {
                return purchaseInfo;
            }
        }
        return null;
    }

    public static long getPurchaseTime(String str) {
        long j;
        if (str != null) {
            try {
                j = new JSONObject(str).getLong("purchaseTime");
            } catch (JSONException e2) {
                e2.printStackTrace();
                RLog.error("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getPurchaseTime--PayCallbackProxy data =%s , Exception =%s", str, e2.getMessage()), new Object[0]);
            }
            RLog.info("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser success ---PayCallbackProxy data =%s , purchaseTime =%s", str, Long.valueOf(j)));
            return j;
        }
        j = 0;
        RLog.info("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser success ---PayCallbackProxy data =%s , purchaseTime =%s", str, Long.valueOf(j)));
        return j;
    }
}
