package d.a.m0.b.n.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.f.a0;
import d.a.m0.b.i;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public int f50126c;

    /* loaded from: classes3.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50127a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50128b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f50129c;

        public a(CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
            this.f50127a = callbackHandler;
            this.f50128b = str;
            this.f50129c = jSONObject;
        }

        @Override // d.a.m0.b.n.a.g.c
        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                g.this.p(this.f50127a, this.f50128b, this.f50129c);
                return;
            }
            g gVar = g.this;
            gVar.f50126c = gVar.m(jSONObject);
            g.this.p(this.f50127a, this.f50128b, this.f50129c);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends StringResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f50131a;

        public b(g gVar, c cVar) {
            this.f50131a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            try {
                this.f50131a.a(new JSONObject(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f50131a.a(null);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f50131a.a(null);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(JSONObject jSONObject);
    }

    public g(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/privateGetUserInfo");
        this.f50126c = -1;
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        }
        try {
            o(context, callbackHandler, eVar, optString);
        } catch (JSONException unused) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final int m(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONObject == null) {
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    optJSONObject = optJSONArray.getJSONObject(0);
                } else {
                    if (a0.f44733b) {
                        Log.d(BaseJsonData.TAG, "Invalid data field!");
                    }
                    optJSONObject = null;
                }
            }
            if (optJSONObject == null || (jSONObject2 = optJSONObject.getJSONObject("userx")) == null || (jSONObject3 = jSONObject2.getJSONObject(Config.EVENT_ATTR)) == null || (jSONObject4 = jSONObject3.getJSONObject(ActionJsonData.TAG_DATASET)) == null) {
                return -1;
            }
            return jSONObject4.optInt("gender");
        } catch (JSONException unused) {
            return -1;
        }
    }

    public final void n(c cVar) {
        if (cVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("gender", "1");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(d.a.m0.a.d0.c.v(i.c()))).addParam("data", jSONObject.toString()).cookieManager(d.a.m0.a.c1.a.p().a())).build().executeAsync(new b(this, cVar));
    }

    public final void o(Context context, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar, String str) throws JSONException {
        String y = d.a.m0.b.j.a.y(context);
        if (!TextUtils.isEmpty(d.a.m0.b.j.a.i(context)) && !TextUtils.isEmpty(y)) {
            JSONObject jSONObject = new JSONObject();
            d.a.m0.b.j.a0 g2 = d.a.m0.b.j.a.g(context);
            jSONObject.put("displayname", g2.f50030a);
            jSONObject.put("portrait", g2.f50031b);
            if (this.f50126c != -1) {
                p(callbackHandler, str, jSONObject);
                return;
            } else {
                n(new a(callbackHandler, str, jSONObject));
                return;
            }
        }
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(10003).toString());
    }

    public final void p(CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
        int i2 = this.f50126c;
        if (i2 != -1) {
            try {
                jSONObject.put("gender", String.valueOf(i2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
    }
}
