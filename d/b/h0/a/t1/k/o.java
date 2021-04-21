package d.b.h0.a.t1.k;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.i2.k0;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47180e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47181f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47182g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f47183h;
        public final /* synthetic */ JSONObject i;

        public a(CallbackHandler callbackHandler, String str, String str2, Context context, JSONObject jSONObject) {
            this.f47180e = callbackHandler;
            this.f47181f = str;
            this.f47182g = str2;
            this.f47183h = context;
            this.i = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.e eVar) {
            if (eVar != null && !eVar.f47492d) {
                if (o.this.n(eVar, this.f47182g)) {
                    o.this.m(this.f47183h, this.i, this.f47180e, this.f47181f);
                    return;
                } else {
                    this.f47180e.handleSchemeDispatchCallback(this.f47181f, UnitedSchemeUtility.wrapCallbackParams(1003, "打开APP失败，打开App条件未满足").toString());
                    return;
                }
            }
            if (a0.f47009b) {
                Log.i("OpenAppAction", "no configuration of authority");
            }
            d.b.h0.a.v1.c.c.m(10005, this.f47180e, this.f47181f);
            d.b.h0.a.z1.h.q(10005, eVar);
        }
    }

    public o(d.b.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/openApp");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            return false;
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "invalid params");
            return false;
        }
        String optString = a2.optString("cb");
        if (a0.f47009b) {
            Log.i("OpenAppAction", "params is " + a2.toString());
        }
        String optString2 = a2.optString("open", "");
        l(eVar, optString2);
        eVar.R().e("scope_open_app", new a(callbackHandler, optString, optString2, context, a2));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public final void l(@NonNull d.b.h0.a.r1.e eVar, @NonNull String str) {
        d.b.h0.a.z1.k.e eVar2 = new d.b.h0.a.z1.k.e();
        eVar2.f47974c = eVar.L().S();
        eVar2.a("appkey", eVar.getAppId());
        eVar2.a(Config.ROM, "Android");
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
        eVar2.a("schema", str);
        d.b.h0.a.z1.h.u("1303", eVar2);
    }

    public final void m(Context context, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        String optString = jSONObject.optString("open");
        boolean S = !TextUtils.isEmpty(optString) ? k0.S(context, optString, callbackHandler, str) : false;
        boolean optBoolean = jSONObject.optBoolean("isNeedDownload", true);
        if (a0.f47009b) {
            Log.i("OpenAppAction", "open app result=" + S + "\nisNeedDownload=" + optBoolean);
        }
        if (optBoolean) {
            boolean f2 = S ? true : k0.f(context, jSONObject.optString("download"));
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(f2 ? 0 : 1001, f2 ? "下载APP成功" : "下载APP失败").toString());
        } else if (S) {
        } else {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1002, "打开APP失败，本地没有安装").toString());
        }
    }

    public final boolean n(d.b.h0.a.v1.c.e eVar, String str) {
        if (eVar != null && !TextUtils.isEmpty(str)) {
            String S = d.b.h0.a.r1.d.e().s().J().S();
            if (TextUtils.isEmpty(S)) {
                S = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
            }
            JSONObject jSONObject = eVar.o;
            if (jSONObject != null && jSONObject.keys() != null) {
                if (a0.f47009b) {
                    Log.i("OpenAppAction", "source: " + S + " openUrl:" + str + " 配置数据:" + jSONObject);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("scene");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("package_name");
                int length = optJSONArray == null ? 0 : optJSONArray.length();
                if (length > 0) {
                    boolean z = false;
                    for (int i = 0; i < length; i++) {
                        if (S.equals(optJSONArray.optString(i))) {
                            z = true;
                        }
                    }
                    return z && o(str, optJSONArray2);
                }
                return o(str, optJSONArray2);
            }
        }
        return false;
    }

    public final boolean o(String str, JSONArray jSONArray) {
        int length = jSONArray == null ? 0 : jSONArray.length();
        if (length > 0 && !TextUtils.isEmpty(str)) {
            for (int i = 0; i < length; i++) {
                String optString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    String decode = Uri.decode(optString);
                    int indexOf = decode.indexOf(":");
                    if (indexOf > 0) {
                        decode = decode.substring(0, indexOf);
                    }
                    if (str.startsWith(decode)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
