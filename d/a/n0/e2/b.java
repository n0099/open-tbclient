package d.a.n0.e2;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static String f52803a = "c12585";

        /* renamed from: b  reason: collision with root package name */
        public static String f52804b = "c12586";
    }

    public static CustomDialogData a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("tb_hudong")) != null && !TextUtils.isEmpty(optJSONObject.optString("content"))) {
            try {
                return CustomDialogData.praseJSON(new JSONObject(Uri.decode(optJSONObject.optString("content"))));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
