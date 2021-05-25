package d.a.l0.a.c2.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import d.a.l0.a.v2.q0;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41136e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41137f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41138g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f41139h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f41140i;
        public final /* synthetic */ String j;

        public a(CallbackHandler callbackHandler, String str, String str2, Context context, JSONObject jSONObject, String str3) {
            this.f41136e = callbackHandler;
            this.f41137f = str;
            this.f41138g = str2;
            this.f41139h = context;
            this.f41140i = jSONObject;
            this.j = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.f fVar) {
            if (fVar != null && !fVar.f41697d) {
                if (n.this.m(fVar, this.f41138g)) {
                    n.this.l(this.f41139h, this.f41140i, this.f41136e, this.f41137f, this.j);
                    return;
                } else {
                    this.f41136e.handleSchemeDispatchCallback(this.f41137f, UnitedSchemeUtility.wrapCallbackParams(1003, "打开APP失败，打开App条件未满足").toString());
                    return;
                }
            }
            if (a0.f40949b) {
                Log.i("OpenAppAction", "no configuration of authority");
            }
            d.a.l0.a.e2.c.d.n(10005, this.f41136e, this.f41137f);
            d.a.l0.a.j2.k.p(10005, fVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements q0.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41141a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41142b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f41143c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f41144d;

        public b(n nVar, CallbackHandler callbackHandler, String str, String str2, String str3) {
            this.f41141a = callbackHandler;
            this.f41142b = str;
            this.f41143c = str2;
            this.f41144d = str3;
        }

        @Override // d.a.l0.a.v2.q0.g
        public void a(boolean z) {
            this.f41141a.handleSchemeDispatchCallback(this.f41142b, UnitedSchemeUtility.wrapCallbackParams(z ? 0 : 1001, z ? "打开APP成功" : "打开APP失败，本地没有安装").toString());
            c.a("open", this.f41143c, "confirm", this.f41144d);
        }

        @Override // d.a.l0.a.v2.q0.g
        public void onCancel() {
            this.f41141a.handleSchemeDispatchCallback(this.f41142b, UnitedSchemeUtility.wrapCallbackParams(1004, "取消打开APP").toString());
            c.a("open", this.f41143c, QueryResponse.Options.CANCEL, this.f41144d);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {
        public static void a(String str, String str2, String str3, String str4) {
            String str5;
            String str6;
            String str7;
            d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
            d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
            String str8 = "";
            if (Q != null) {
                str8 = d.a.l0.a.j2.k.m(Q.l());
                str6 = Q.getAppId();
                str7 = Q.O();
                str5 = Q.L().T();
            } else {
                str5 = "";
                str6 = str5;
                str7 = str6;
            }
            String a2 = d.a.l0.a.c1.a.m().a();
            eVar.f43185a = str8;
            eVar.f43186b = str;
            eVar.f43189e = str2;
            eVar.f43190f = str6;
            eVar.f43187c = str5;
            eVar.a("appName", str7);
            eVar.a("hostName", a2);
            eVar.a("hostVersion", q0.D());
            eVar.a(PushConstants.CLICK_TYPE, str3);
            try {
                str4 = URLDecoder.decode(str4, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
            eVar.a("scheme", str4);
            d.a.l0.a.j2.b.i("2572", "90", eVar.f());
            if (a0.f40949b) {
                Log.d("OpenAppAction", String.format("ubcId=%s && ceresId=%s , content:%s ", "2572", "90", eVar.f()));
            }
        }
    }

    public n(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/openApp");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
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
        if (a0.f40949b) {
            Log.i("OpenAppAction", "params is " + a2.toString());
        }
        String optString2 = a2.optString("open", "");
        String optString3 = a2.optString("invokeFrom", "");
        c.a("invoke", optString3, null, optString2);
        eVar.T().e("scope_open_app", new a(callbackHandler, optString, optString2, context, a2, optString3));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public final void l(Context context, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
        boolean z;
        String optString = jSONObject.optString("open");
        if (TextUtils.isEmpty(optString)) {
            z = false;
        } else {
            optString = Uri.decode(optString);
            d.a.l0.a.c1.a.K().a(optString, jSONObject.optJSONObject("extraParams"));
            if (a0.f40949b) {
                Log.i("OpenAppAction", "openUrl:" + optString);
            }
            z = o(context, optString, callbackHandler, str, str2);
        }
        boolean optBoolean = jSONObject.optBoolean("isNeedDownload", true);
        if (a0.f40949b) {
            Log.i("OpenAppAction", "open app result=" + z + "\nisNeedDownload=" + optBoolean);
        }
        if (!optBoolean) {
            if (z) {
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1002, "打开APP失败，本地没有安装").toString());
        } else if (z) {
        } else {
            boolean e2 = q0.e(context, jSONObject.optString("download"));
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(e2 ? 0 : 1001, e2 ? "下载APP成功" : "下载APP失败").toString());
            c.a("download", str2, null, optString);
        }
    }

    public final boolean m(d.a.l0.a.e2.c.f fVar, String str) {
        if (fVar != null && !TextUtils.isEmpty(str)) {
            String T = d.a.l0.a.a2.d.g().r().L().T();
            if (TextUtils.isEmpty(T)) {
                T = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
            }
            JSONObject jSONObject = fVar.o;
            if (jSONObject != null && jSONObject.keys() != null) {
                if (a0.f40949b) {
                    Log.i("OpenAppAction", "source: " + T + " openUrl:" + str + " 配置数据:" + jSONObject);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("scene");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("package_name");
                int length = optJSONArray == null ? 0 : optJSONArray.length();
                if (length > 0) {
                    boolean z = false;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (T.equals(optJSONArray.optString(i2))) {
                            z = true;
                        }
                    }
                    return z && n(str, optJSONArray2);
                }
                return n(str, optJSONArray2);
            }
        }
        return false;
    }

    public final boolean n(String str, JSONArray jSONArray) {
        int length = jSONArray == null ? 0 : jSONArray.length();
        if (length > 0 && !TextUtils.isEmpty(str)) {
            for (int i2 = 0; i2 < length; i2++) {
                String optString = jSONArray.optString(i2);
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

    public final boolean o(Context context, String str, CallbackHandler callbackHandler, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return q0.W(context, str, new b(this, callbackHandler, str2, str3, str));
    }
}
