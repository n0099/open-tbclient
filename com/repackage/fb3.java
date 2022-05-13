package com.repackage;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.datacollector.growth.utils.UBCEncryptor;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class fb3 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755713638, "Lcom/repackage/fb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755713638, "Lcom/repackage/fb3;");
                return;
            }
        }
        c = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fb3(r13 r13Var) {
        super(r13Var, "/swanAPI/getSystemRiskInfo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r13Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.r23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u03Var)) == null) {
            rk1 h0 = bk2.h0();
            JSONObject jSONObject = new JSONObject();
            if (context == null) {
                try {
                    context = bk2.c();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            String str = "";
            jSONObject.put(DpStatConstants.KEY_USER_ID, h0 == null ? "" : h0.h(context));
            jSONObject.put("zid", h0 == null ? "" : bk2.G0().a(context));
            jSONObject.put("idfa", "");
            jSONObject.put("imei", oe3.r());
            jSONObject.put("appkey", u03Var == null ? "" : u03Var.N());
            jSONObject.put("os", "android");
            jSONObject.put("osVersion", Build.VERSION.RELEASE);
            jSONObject.put("hostName", context.getPackageName());
            jSONObject.put("hostVersion", oe3.D());
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("uuid", fh4.b(context).a());
            jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
            if (h0 != null) {
                str = h0.i(context);
            }
            jSONObject.put("cuid", str);
            if (c) {
                Log.d("GetSystemRiskInfoAction", jSONObject.toString());
            }
            String b = oh4.b(UUID.randomUUID().toString().getBytes(), false);
            String a = md3.a(b, jSONObject.toString(), UBCEncryptor.TRANSFORMATION, "4c6579b50ff05adb");
            String d = md3.d("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjP7b5s3ozPgXpS7d9k2dGaie8KLNmCbhybWPxVjLTmN4Jj3c7GnwdzyIQOix7t95Kipd75AXcnP2c4vUnmXPpZwh6ejNAmiGLkLE7fobPCZKfI3aTweSKxIav3QPHMaZrra1aiGtnZ+rTHXD3chBpNCGbuAEUqN+psHjvnHO72QIDAQAB", b, "RSA/ECB/PKCS1Padding");
            if (c) {
                Log.d("GetSystemRiskInfoAction", "aesKey=" + b + ", aesValue=" + a + ", rsaKey=" + d);
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("key", d);
                jSONObject3.put("value", a);
                jSONObject2.put("content", jSONObject3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
