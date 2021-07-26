package com.bytedance.sdk.openadsdk.q;

import android.support.v4.media.session.MediaSessionCompat;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.AdSlot;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static AdSlot a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                return a(new JSONObject(str));
            } catch (Exception unused) {
                return null;
            }
        }
        return (AdSlot) invokeL.objValue;
    }

    public static AdSlot a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            AdSlot.Builder builder = new AdSlot.Builder();
            try {
                int optInt = jSONObject.optInt("width", 640);
                int optInt2 = jSONObject.optInt("height", MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
                double optDouble = jSONObject.optDouble("expressWidth", 0.0d);
                double optDouble2 = jSONObject.optDouble("expressHeight", 0.0d);
                builder.setAdCount(jSONObject.optInt("adCount", 1));
                builder.setCodeId(jSONObject.optString("codeId", null));
                builder.setImageAcceptedSize(optInt, optInt2);
                builder.setMediaExtra(jSONObject.optString("extra", null));
                builder.setNativeAdType(jSONObject.optInt("adType"));
                builder.setOrientation(jSONObject.optInt("orientation"));
                builder.setSupportDeepLink(jSONObject.optBoolean("supportDeepLink", true));
                builder.setUserID(jSONObject.optString("userId", null));
                builder.setIsAutoPlay(jSONObject.optBoolean("autoPlay", true));
                builder.setExpressViewAcceptedSize(Double.valueOf(optDouble).floatValue(), Double.valueOf(optDouble2).floatValue());
                builder.setPrimeRit(jSONObject.optString("prime_rit", null));
                builder.setAdloadSeq(jSONObject.optInt("show_seq", 0));
                builder.setExtraParam(jSONObject.optString("extraSmartLookParam", null));
                builder.setAdId(jSONObject.optString(LegoListActivityConfig.AD_ID, null));
                builder.setCreativeId(jSONObject.optString("creative_id", null));
                builder.withBid(jSONObject.optString("mBidAdm"));
                builder.setUserData(jSONObject.optString("mUserData"));
                builder.setExternalABVid(com.bytedance.sdk.openadsdk.n.g.d.d(jSONObject.optString("external_ab_vid", null)));
            } catch (Exception unused) {
            }
            return builder.build();
        }
        return (AdSlot) invokeL.objValue;
    }

    public static String a(AdSlot adSlot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adSlot)) == null) {
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
                jSONObject.put("userId", adSlot.getUserID());
                jSONObject.put("expressWidth", adSlot.getExpressViewAcceptedWidth());
                jSONObject.put("expressHeight", adSlot.getExpressViewAcceptedHeight());
                jSONObject.put("autoPlay", adSlot.isAutoPlay());
                jSONObject.put("prime_rit", adSlot.getPrimeRit());
                jSONObject.put("show_seq", adSlot.getAdloadSeq());
                jSONObject.put(LegoListActivityConfig.AD_ID, adSlot.getAdId());
                jSONObject.put("creative_id", adSlot.getCreativeId());
                jSONObject.put("mBidAdm", adSlot.getBidAdm());
                jSONObject.put("mUserData", adSlot.getUserData());
                jSONObject.put("external_ab_vid", com.bytedance.sdk.openadsdk.n.g.d.a(adSlot.getExternalABVid()));
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
