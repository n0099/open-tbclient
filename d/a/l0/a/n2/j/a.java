package d.a.l0.a.n2.j;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.yy.hiidostatis.inner.util.cipher.RsaCipher;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.k;
import d.a.l0.a.p.d.n;
import d.a.l0.a.v2.o;
import d.a.l0.a.v2.q0;
import d.a.l0.u.b;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47531c = k.f46875a;

    public a(e eVar) {
        super(eVar, "/swanAPI/getSystemRiskInfo");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        n a0 = d.a.l0.a.c1.a.a0();
        JSONObject jSONObject = new JSONObject();
        if (context == null) {
            try {
                context = d.a.l0.a.c1.a.b();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        String str = "";
        jSONObject.put(DpStatConstants.KEY_USER_ID, a0 == null ? "" : a0.h(context));
        jSONObject.put("zid", a0 == null ? "" : d.a.l0.a.c1.a.u0().a(context));
        jSONObject.put("idfa", "");
        jSONObject.put("imei", q0.r());
        jSONObject.put("appkey", eVar == null ? "" : eVar.D());
        jSONObject.put(IAdRequestParam.OS, "android");
        jSONObject.put("osVersion", Build.VERSION.RELEASE);
        jSONObject.put("hostName", context.getPackageName());
        jSONObject.put("hostVersion", q0.D());
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("uuid", b.b(context).a());
        jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        if (a0 != null) {
            str = a0.i(context);
        }
        jSONObject.put("cuid", str);
        if (f47531c) {
            Log.d("GetSystemRiskInfoAction", jSONObject.toString());
        }
        String b2 = d.a.l0.u.d.b.b(UUID.randomUUID().toString().getBytes(), false);
        String a2 = o.a(b2, jSONObject.toString(), "AES/CTR/NoPadding", "4c6579b50ff05adb");
        String d2 = o.d("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjP7b5s3ozPgXpS7d9k2dGaie8KLNmCbhybWPxVjLTmN4Jj3c7GnwdzyIQOix7t95Kipd75AXcnP2c4vUnmXPpZwh6ejNAmiGLkLE7fobPCZKfI3aTweSKxIav3QPHMaZrra1aiGtnZ+rTHXD3chBpNCGbuAEUqN+psHjvnHO72QIDAQAB", b2, RsaCipher.RSA_PADDING);
        if (f47531c) {
            Log.d("GetSystemRiskInfoAction", "aesKey=" + b2 + ", aesValue=" + a2 + ", rsaKey=" + d2);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("key", d2);
            jSONObject3.put("value", a2);
            jSONObject2.put("content", jSONObject3);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
        return true;
    }
}
