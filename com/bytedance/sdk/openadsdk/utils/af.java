package com.bytedance.sdk.openadsdk.utils;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.yy.videoplayer.decoder.VideoConstant;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class af {
    public static AdSlot a(String str) {
        try {
            return a(new JSONObject(str));
        } catch (Exception e) {
            return null;
        }
    }

    public static AdSlot a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        AdSlot.Builder builder = new AdSlot.Builder();
        try {
            int optInt = jSONObject.optInt("width", 640);
            int optInt2 = jSONObject.optInt("height", VideoConstant.THUMBNAIL_WIDTH);
            double optDouble = jSONObject.optDouble("expressWidth", 0.0d);
            double optDouble2 = jSONObject.optDouble("expressHeight", 0.0d);
            builder.setAdCount(jSONObject.optInt("adCount", 1));
            builder.setCodeId(jSONObject.optString("codeId", null));
            builder.setImageAcceptedSize(optInt, optInt2);
            builder.setMediaExtra(jSONObject.optString("extra", null));
            builder.setNativeAdType(jSONObject.optInt("adType"));
            builder.setOrientation(jSONObject.optInt("orientation"));
            builder.setSupportDeepLink(jSONObject.optBoolean("supportDeepLink", true));
            builder.setUserID(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID, null));
            builder.setIsAutoPlay(jSONObject.optBoolean("autoPlay", true));
            builder.setExpressViewAcceptedSize(Double.valueOf(optDouble).floatValue(), Double.valueOf(optDouble2).floatValue());
            builder.setPrimeRit(jSONObject.optString("prime_rit", null));
            builder.setAdloadSeq(jSONObject.optInt("show_seq", 0));
            builder.setExtraParam(jSONObject.optString("extraSmartLookParam", null));
            builder.setExtraParam(jSONObject.optString(LegoListActivityConfig.AD_ID, null));
            builder.setExtraParam(jSONObject.optString("creative_id", null));
        } catch (Exception e) {
        }
        return builder.build();
    }

    public static String a(AdSlot adSlot) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adCount", adSlot.getAdCount());
            jSONObject.put("codeId", adSlot.getCodeId());
            jSONObject.put("width", adSlot.getImgAcceptedWidth());
            jSONObject.put("height", adSlot.getImgAcceptedHeight());
            jSONObject.put("extra", adSlot.getMediaExtra());
            jSONObject.put("adType", adSlot.getNativeAdType());
            jSONObject.put("orientation", adSlot.getOrientation());
            jSONObject.put("supportDeepLink", adSlot.isSupportDeepLink());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, adSlot.getUserID());
            jSONObject.put("expressWidth", adSlot.getExpressViewAcceptedWidth());
            jSONObject.put("expressHeight", adSlot.getExpressViewAcceptedHeight());
            jSONObject.put("autoPlay", adSlot.isAutoPlay());
            jSONObject.put("prime_rit", adSlot.getPrimeRit());
            jSONObject.put("show_seq", adSlot.getAdloadSeq());
            jSONObject.put("extraSmartLookParam", adSlot.getExtraSmartLookParam());
            jSONObject.put(LegoListActivityConfig.AD_ID, adSlot.getAdId());
            jSONObject.put("creative_id", adSlot.getCreativeId());
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }
}
