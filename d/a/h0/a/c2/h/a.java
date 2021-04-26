package d.a.h0.a.c2.h;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.n;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.q.b;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f41824c = k.f43101a;

    public a(j jVar) {
        super(jVar, "/swanAPI/getSystemRiskInfo");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        d.a.h0.a.p.c.e O = d.a.h0.a.w0.a.O();
        JSONObject jSONObject = new JSONObject();
        if (context == null) {
            try {
                context = d.a.h0.a.w0.a.c();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        String str = "";
        jSONObject.put(DpStatConstants.KEY_USER_ID, O == null ? "" : O.e(context));
        jSONObject.put("zid", O == null ? "" : d.a.h0.a.w0.a.g0().a(context));
        jSONObject.put("idfa", "");
        jSONObject.put("imei", k0.r());
        jSONObject.put("appkey", eVar == null ? "" : eVar.B());
        jSONObject.put(IAdRequestParam.OS, "android");
        jSONObject.put("osVersion", Build.VERSION.RELEASE);
        jSONObject.put("hostName", context.getPackageName());
        jSONObject.put("hostVersion", k0.z());
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("uuid", b.b(context).a());
        jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        if (O != null) {
            str = O.f(context);
        }
        jSONObject.put("cuid", str);
        if (f41824c) {
            Log.d("GetSystemRiskInfoAction", jSONObject.toString());
        }
        String b2 = d.a.h0.q.d.b.b(UUID.randomUUID().toString().getBytes(), false);
        String a2 = n.a(b2, jSONObject.toString(), "AES/CTR/NoPadding", "4c6579b50ff05adb");
        String d2 = n.d("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjP7b5s3ozPgXpS7d9k2dGaie8KLNmCbhybWPxVjLTmN4Jj3c7GnwdzyIQOix7t95Kipd75AXcnP2c4vUnmXPpZwh6ejNAmiGLkLE7fobPCZKfI3aTweSKxIav3QPHMaZrra1aiGtnZ+rTHXD3chBpNCGbuAEUqN+psHjvnHO72QIDAQAB", b2, "RSA/ECB/PKCS1Padding");
        if (f41824c) {
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
