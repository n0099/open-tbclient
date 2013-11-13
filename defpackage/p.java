package defpackage;

import android.util.Log;
import com.baidu.cloudsdk.Build;
import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.social.core.SessionManager;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.core.SocialWidget;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: p  reason: default package */
/* loaded from: classes.dex */
public class p extends JsonHttpResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SocialWidget f2983a;

    public p(SocialWidget socialWidget) {
        this.f2983a = socialWidget;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
    public void onFailure(Throwable th, String str) {
        String str2;
        str2 = SocialWidget.f849a;
        Log.e(str2, "load social tokens from server failed");
    }

    @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
    protected void onSuccess(JSONArray jSONArray) {
        SessionManager sessionManager = SessionManager.getInstance(this.f2983a.mContext);
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                sessionManager.save(jSONArray.getJSONObject(i));
            } catch (JSONException e) {
            }
        }
    }

    @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
    protected void onSuccess(JSONObject jSONObject) {
        String str;
        String str2;
        try {
            String string = jSONObject.getString(SocialConstants.PARAM_ERROR_CODE);
            String string2 = jSONObject.getString("error_msg");
            if (Build.DEBUG) {
                str2 = SocialWidget.f849a;
                Log.d(str2, "error_code: " + string + ", error_msg: " + string2);
            }
        } catch (JSONException e) {
            str = SocialWidget.f849a;
            Log.e(str, "unkown error");
            e.printStackTrace();
        }
    }
}
