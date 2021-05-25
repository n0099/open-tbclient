package d.a.n0.t.a.i;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.util.CommonParam;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.heytap.mcssdk.mode.CommandMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static String a(Context context, AdInfo adInfo) {
        if (adInfo != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(XAdRemoteAPKDownloadExtraInfo.PLACE_ID, adInfo.placeId);
                jSONObject.put(CommandMessage.SDK_VERSION, "1.1.4");
                jSONObject.put("adType", adInfo.adShowType.getValue());
                if (TextUtils.isEmpty(adInfo.redirectUrl)) {
                    jSONObject.put("landingPage", adInfo.downLoadUrl);
                } else {
                    jSONObject.put("landingPage", adInfo.redirectUrl);
                }
                jSONObject.put("showStamp", String.valueOf(System.currentTimeMillis()));
                jSONObject.put("packageName", adInfo.packageName);
                jSONObject.put("finalPrice", adInfo.finalPrice);
                jSONObject.put("chargingMode", adInfo.chargingMode);
                jSONObject.put("token", adInfo.token);
                jSONObject.put("adpUserId", adInfo.adpUserId);
                jSONObject.put("bdId", CommonParam.getCUID(context));
                jSONObject.put("unitId", adInfo.unitId);
                jSONObject.put("planId", adInfo.planId);
                jSONObject.put("ideaId", adInfo.ideaId);
                jSONObject.put("ideaType", adInfo.sourceType);
                jSONObject.put("s", "0");
                return jSONObject.toString();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return "";
            }
        }
        return "";
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            BdLog.e(e2);
            return null;
        }
    }
}
