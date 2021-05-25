package d.a.l0.a.i1.f;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.wallet.router.RouterCallback;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42917c = k.f43199a;

    /* renamed from: d  reason: collision with root package name */
    public static String f42918d;

    /* renamed from: e  reason: collision with root package name */
    public static String f42919e;

    /* renamed from: f  reason: collision with root package name */
    public static String f42920f;

    /* renamed from: g  reason: collision with root package name */
    public static String f42921g;

    /* renamed from: h  reason: collision with root package name */
    public static String f42922h;

    /* renamed from: i  reason: collision with root package name */
    public static String f42923i;
    public static String j;

    /* renamed from: a  reason: collision with root package name */
    public CallbackHandler f42924a;

    /* renamed from: b  reason: collision with root package name */
    public UnitedSchemeEntity f42925b;

    public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f42924a = callbackHandler;
        this.f42925b = unitedSchemeEntity;
        f42918d = str;
        f42919e = str2;
        f42920f = str3;
        f42921g = str4;
        f42922h = str5;
        f42923i = str6;
        j = str7;
    }

    public static b a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, b bVar) {
        if (str == null) {
            return bVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(MissionEvent.MESSAGE_START);
            String optString2 = jSONObject.optString(MissionEvent.MESSAGE_PAUSE);
            String optString3 = jSONObject.optString(MissionEvent.MESSAGE_RESUME);
            String optString4 = jSONObject.optString(MissionEvent.MESSAGE_STOP);
            String optString5 = jSONObject.optString("onError");
            String optString6 = jSONObject.optString("onInterruptionBegin");
            String optString7 = jSONObject.optString("onInterruptionEnd");
            if (callbackHandler != null && unitedSchemeEntity != null && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                return new b(callbackHandler, unitedSchemeEntity, optString, optString2, optString3, optString4, optString5, optString6, optString7);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return bVar;
    }

    public void b(String str) {
        c(str, null);
    }

    public void c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
        UnitedSchemeUtility.safeCallback(this.f42924a, this.f42925b, wrapCallbackParams.toString(), str);
        if (f42917c) {
            Log.d("AudioStatusCallBack", "Audio callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
        }
    }

    public void d(int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(RouterCallback.KEY_ERROR_CODE, Integer.valueOf(i2));
            jSONObject.putOpt("errMsg", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c(f42922h, jSONObject);
    }
}
