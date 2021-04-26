package d.r.b.a.a.j.e;

import d.r.b.a.a.f.d.d;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static String a(String str) {
        if (str != null) {
            try {
                String string = new JSONObject(str).getString("chOrderId");
                if (string != null && !string.equals("")) {
                    return string;
                }
                d.h("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getChOrderidByPayload =null ", new Object[0]));
                return "";
            } catch (JSONException e2) {
                e2.printStackTrace();
                d.h("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getPayLoad--getChOrderidByPayload data =%s , Exception =%s", str, e2.getMessage()));
            }
        }
        d.f("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser success ---getChOrderidByPayload data =%s , getPayLoad =%s", str, ""));
        return "";
    }

    public static String b(String str) {
        String str2 = "";
        if (str != null) {
            try {
                String string = new JSONObject(str).getString("riskData");
                if (string != null && !string.equals("")) {
                    str2 = new JSONObject(string).getString("challengeExtension");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                d.h("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getChallengeExtension--PayCallbackProxy data =%s , Exception =%s", str, e2.getMessage()));
            }
        }
        d.f("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser success ---getChallengeExtension data =%s , purchaseTime =%s", str, str2));
        return str2;
    }
}
