package com.sina.weibo.sdk.call;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class WeiboPageUtilsV2 {
    private WeiboPageUtilsV2() {
    }

    public static void postNewWeibo(Context context, HashMap<String, String> hashMap) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.SENDWEIBO);
        if (hashMap != null) {
            sb.append(CommonUtils.buildUriQuery(hashMap));
        }
        if (hashMap != null && !TextUtils.isEmpty(hashMap.get("packagename"))) {
            StringBuilder sb2 = new StringBuilder(WBPageConstants.Scheme.SENDWEIBO);
            if (hashMap != null) {
                sb2.append(CommonUtils.buildUriQuery(hashMap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), hashMap.get("packagename"));
            return;
        }
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), null);
    }

    public static void viewNearbyPeople(Context context, HashMap<String, String> hashMap) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.NEARBYPEOPLE);
        if (hashMap != null) {
            sb.append(CommonUtils.buildUriQuery(hashMap));
        }
        if (hashMap != null && !TextUtils.isEmpty(hashMap.get("packagename"))) {
            StringBuilder sb2 = new StringBuilder(WBPageConstants.Scheme.NEARBYPEOPLE);
            if (hashMap != null) {
                sb2.append(CommonUtils.buildUriQuery(hashMap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), hashMap.get("packagename"));
            return;
        }
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), null);
    }

    public static void viewNearbyWeibo(Context context, HashMap<String, String> hashMap) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.NEARBYWEIBO);
        if (hashMap != null) {
            sb.append(CommonUtils.buildUriQuery(hashMap));
        }
        if (hashMap != null && !TextUtils.isEmpty(hashMap.get("packagename"))) {
            StringBuilder sb2 = new StringBuilder(WBPageConstants.Scheme.NEARBYWEIBO);
            if (hashMap != null) {
                sb2.append(CommonUtils.buildUriQuery(hashMap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), hashMap.get("packagename"));
            return;
        }
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), null);
    }

    public static void viewUserInfo(Context context, HashMap<String, String> hashMap) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (hashMap == null || (TextUtils.isEmpty(hashMap.get("uid")) && TextUtils.isEmpty(hashMap.get(WBPageConstants.ParamKey.NICK)))) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.UID_NICK_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.USERINFO);
        if (hashMap != null) {
            sb.append(CommonUtils.buildUriQuery(hashMap));
        }
        if (hashMap != null && !TextUtils.isEmpty(hashMap.get("packagename"))) {
            StringBuilder sb2 = new StringBuilder(WBPageConstants.Scheme.USERINFO);
            if (hashMap != null) {
                sb2.append(CommonUtils.buildUriQuery(hashMap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), hashMap.get("packagename"));
            return;
        }
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), null);
    }

    public static void viewUsertrends(Context context, HashMap<String, String> hashMap) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (hashMap == null || TextUtils.isEmpty(hashMap.get("uid"))) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.UID_NICK_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.USERTRENDS);
        if (hashMap != null) {
            sb.append(CommonUtils.buildUriQuery(hashMap));
        }
        if (hashMap != null && !TextUtils.isEmpty(hashMap.get("packagename"))) {
            StringBuilder sb2 = new StringBuilder(WBPageConstants.Scheme.USERTRENDS);
            if (hashMap != null) {
                sb2.append(CommonUtils.buildUriQuery(hashMap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), hashMap.get("packagename"));
            return;
        }
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), null);
    }

    public static void viewPageInfo(Context context, HashMap<String, String> hashMap) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (hashMap == null || TextUtils.isEmpty(hashMap.get(WBPageConstants.ParamKey.PAGEID))) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.PAGEID_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.PAGEINFO);
        if (hashMap != null) {
            sb.append(CommonUtils.buildUriQuery(hashMap));
        }
        if (hashMap != null && !TextUtils.isEmpty(hashMap.get("packagename"))) {
            StringBuilder sb2 = new StringBuilder(WBPageConstants.Scheme.PAGEINFO);
            if (hashMap != null) {
                sb2.append(CommonUtils.buildUriQuery(hashMap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), hashMap.get("packagename"));
            return;
        }
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), null);
    }

    public static void viewPageProductList(Context context, HashMap<String, String> hashMap) throws WeiboNotInstalledException {
        int i;
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (hashMap == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.PAGEID_ERROR);
        }
        if (TextUtils.isEmpty(hashMap.get(WBPageConstants.ParamKey.PAGEID))) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.PAGEID_ERROR);
        }
        if (TextUtils.isEmpty(hashMap.get(WBPageConstants.ParamKey.CARDID))) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CARDID_ERROR);
        }
        try {
            i = Integer.parseInt(hashMap.get(WBPageConstants.ParamKey.COUNT));
        } catch (NumberFormatException e) {
            i = -1;
        }
        if (i < 0) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.COUNT_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.PAGEPRODUCTLIST);
        if (hashMap != null) {
            sb.append(CommonUtils.buildUriQuery(hashMap));
        }
        if (hashMap != null && !TextUtils.isEmpty(hashMap.get("packagename"))) {
            StringBuilder sb2 = new StringBuilder(WBPageConstants.Scheme.PAGEPRODUCTLIST);
            if (hashMap != null) {
                sb2.append(CommonUtils.buildUriQuery(hashMap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), hashMap.get("packagename"));
            return;
        }
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), null);
    }

    public static void viewPageUserList(Context context, HashMap<String, String> hashMap) throws WeiboNotInstalledException {
        int i;
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (hashMap == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.PAGEID_ERROR);
        }
        if (TextUtils.isEmpty(hashMap.get(WBPageConstants.ParamKey.PAGEID))) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.PAGEID_ERROR);
        }
        if (TextUtils.isEmpty(hashMap.get(WBPageConstants.ParamKey.CARDID))) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CARDID_ERROR);
        }
        try {
            i = Integer.parseInt(hashMap.get(WBPageConstants.ParamKey.COUNT));
        } catch (NumberFormatException e) {
            i = -1;
        }
        if (i < 0) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.COUNT_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.PAGEUSERLIST);
        if (hashMap != null) {
            sb.append(CommonUtils.buildUriQuery(hashMap));
        }
        if (hashMap != null && !TextUtils.isEmpty(hashMap.get("packagename"))) {
            StringBuilder sb2 = new StringBuilder(WBPageConstants.Scheme.PAGEUSERLIST);
            if (hashMap != null) {
                sb2.append(CommonUtils.buildUriQuery(hashMap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), hashMap.get("packagename"));
            return;
        }
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), null);
    }

    public static void viewPageWeiboList(Context context, HashMap<String, String> hashMap) throws WeiboNotInstalledException {
        int i;
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (hashMap == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.PAGEID_ERROR);
        }
        if (TextUtils.isEmpty(hashMap.get(WBPageConstants.ParamKey.PAGEID))) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.PAGEID_ERROR);
        }
        if (TextUtils.isEmpty(hashMap.get(WBPageConstants.ParamKey.CARDID))) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CARDID_ERROR);
        }
        try {
            i = Integer.parseInt(hashMap.get(WBPageConstants.ParamKey.COUNT));
        } catch (NumberFormatException e) {
            i = -1;
        }
        if (i < 0) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.COUNT_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.PAGEWEIBOLIST);
        if (hashMap != null) {
            sb.append(CommonUtils.buildUriQuery(hashMap));
        }
        if (hashMap != null && !TextUtils.isEmpty(hashMap.get("packagename"))) {
            StringBuilder sb2 = new StringBuilder(WBPageConstants.Scheme.PAGEWEIBOLIST);
            if (hashMap != null) {
                sb2.append(CommonUtils.buildUriQuery(hashMap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), hashMap.get("packagename"));
            return;
        }
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), null);
    }

    public static void viewPagePhotoList(Context context, HashMap<String, String> hashMap) throws WeiboNotInstalledException {
        int i;
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (hashMap == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.PAGEID_ERROR);
        }
        if (TextUtils.isEmpty(hashMap.get(WBPageConstants.ParamKey.PAGEID))) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.PAGEID_ERROR);
        }
        if (TextUtils.isEmpty(hashMap.get(WBPageConstants.ParamKey.CARDID))) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CARDID_ERROR);
        }
        try {
            i = Integer.parseInt(hashMap.get(WBPageConstants.ParamKey.COUNT));
        } catch (NumberFormatException e) {
            i = -1;
        }
        if (i < 0) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.COUNT_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.PAGEPHOTOLIST);
        if (hashMap != null) {
            sb.append(CommonUtils.buildUriQuery(hashMap));
        }
        if (hashMap != null && !TextUtils.isEmpty(hashMap.get("packagename"))) {
            StringBuilder sb2 = new StringBuilder(WBPageConstants.Scheme.PAGEPHOTOLIST);
            if (hashMap != null) {
                sb2.append(CommonUtils.buildUriQuery(hashMap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), hashMap.get("packagename"));
            return;
        }
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), null);
    }

    public static void viewPageDetailInfo(Context context, HashMap<String, String> hashMap) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (hashMap == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.PAGEID_ERROR);
        }
        if (TextUtils.isEmpty(hashMap.get(WBPageConstants.ParamKey.PAGEID))) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.PAGEID_ERROR);
        }
        if (TextUtils.isEmpty(hashMap.get(WBPageConstants.ParamKey.CARDID))) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CARDID_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.PAGEDETAILINFO);
        if (hashMap != null) {
            sb.append(CommonUtils.buildUriQuery(hashMap));
        }
        if (hashMap != null && !TextUtils.isEmpty(hashMap.get("packagename"))) {
            StringBuilder sb2 = new StringBuilder(WBPageConstants.Scheme.PAGEDETAILINFO);
            if (hashMap != null) {
                sb2.append(CommonUtils.buildUriQuery(hashMap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), hashMap.get("packagename"));
            return;
        }
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), null);
    }

    public static void openInWeiboBrowser(Context context, String str, String str2, String str3, String str4) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (TextUtils.isEmpty(str)) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.URL_ERROR);
        }
        if (!TextUtils.isEmpty(str2) && !"topnav".equals(str2) && !"default".equals(str2) && !"fullscreen".equals(str2)) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.SINAINTERNALBROWSER);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.BROWSER);
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put(WBPageConstants.ParamKey.SINAINTERNALBROWSER, str2);
        hashMap.put(WBPageConstants.ParamKey.EXTPARAM, str3);
        sb.append(CommonUtils.buildUriQuery(hashMap));
        if (!TextUtils.isEmpty(str4)) {
            StringBuilder sb2 = new StringBuilder(WBPageConstants.Scheme.BROWSER);
            if (hashMap != null) {
                sb2.append(CommonUtils.buildUriQuery(hashMap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), str4);
            return;
        }
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), null);
    }

    public static void displayInWeiboMap(Context context, HashMap<String, String> hashMap) throws WeiboNotInstalledException {
        String str;
        String str2;
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        String str3 = "";
        if (hashMap == null) {
            str = "";
            str2 = "";
        } else {
            str3 = hashMap.get(WBPageConstants.ParamKey.OFFSET);
            str = hashMap.get(WBPageConstants.ParamKey.LATITUDE);
            str2 = hashMap.get(WBPageConstants.ParamKey.LONGITUDE);
        }
        String str4 = null;
        if (hashMap != null && !TextUtils.isEmpty(hashMap.get("packagename"))) {
            str4 = hashMap.get("packagename");
        }
        if (hashMap != null) {
            openInWeiboBrowser(context, String.format("http://weibo.cn/dpool/ttt/maps.php?xy=%s,%s&amp;size=320x320&amp;offset=%s", str2, str, str3), "default", hashMap.get(WBPageConstants.ParamKey.EXTPARAM), str4);
        }
    }

    public static void openQrcodeScanner(Context context, HashMap<String, String> hashMap) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.QRCODE);
        if (hashMap != null) {
            sb.append(CommonUtils.buildUriQuery(hashMap));
        }
        if (hashMap != null && !TextUtils.isEmpty(hashMap.get("packagename"))) {
            StringBuilder sb2 = new StringBuilder(WBPageConstants.Scheme.QRCODE);
            if (hashMap != null) {
                sb2.append(CommonUtils.buildUriQuery(hashMap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), hashMap.get("packagename"));
            return;
        }
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), null);
    }

    public static void weiboDetail(Context context, HashMap<String, String> hashMap) throws WeiboNotInstalledException {
        if (context == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.CONTEXT_ERROR);
        }
        if (hashMap == null) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.MBLOGID_ERROR);
        }
        if (TextUtils.isEmpty(hashMap.get(WBPageConstants.ParamKey.MBLOGID))) {
            throw new WeiboIllegalParameterException(WBPageConstants.ExceptionMsg.MBLOGID_ERROR);
        }
        StringBuilder sb = new StringBuilder(WBPageConstants.Scheme.MBLOGDETAIL);
        if (hashMap != null) {
            sb.append(CommonUtils.buildUriQuery(hashMap));
        }
        if (hashMap != null && !TextUtils.isEmpty(hashMap.get("packagename"))) {
            StringBuilder sb2 = new StringBuilder(WBPageConstants.Scheme.MBLOGDETAIL);
            if (hashMap != null) {
                sb2.append(CommonUtils.buildUriQuery(hashMap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), hashMap.get("packagename"));
            return;
        }
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", sb.toString(), null);
    }
}
