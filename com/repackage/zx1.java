package com.repackage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.el2;
import com.repackage.fl2;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class zx1 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public by1 c;
    public ExecutorService d;
    public int e;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ File b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ zx1 e;

        public a(zx1 zx1Var, Context context, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx1Var, context, file, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zx1Var;
            this.a = context;
            this.b = file;
            this.c = unitedSchemeEntity;
            this.d = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zx1 zx1Var = this.e;
                zx1Var.q(this.a, zx1Var.c.b, this.e.c.c, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ File d;
        public final /* synthetic */ UnitedSchemeEntity e;
        public final /* synthetic */ CallbackHandler f;
        public final /* synthetic */ zx1 g;

        public b(zx1 zx1Var, Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx1Var, context, str, str2, file, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = zx1Var;
            this.a = context;
            this.b = str;
            this.c = str2;
            this.d = file;
            this.e = unitedSchemeEntity;
            this.f = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.q(this.a, this.b, this.c, this.d, this.e, this.f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zx1(e13 e13Var) {
        super(e13Var, "/swanAPI/wirelessdebuglaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e13Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                by1 e = by1.e(optParamsAsJo);
                this.c = e;
                if (e != null && !e.d()) {
                    l(context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
                if (e23.b) {
                    Log.e("WirelessDebugAction", "Wireless Debug params is invalid");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            hx1.c("WirelessDebugAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler) == null) {
            File b2 = ay1.b();
            if (b2.exists()) {
                b2.delete();
            }
            this.d = Executors.newFixedThreadPool(4);
            this.e = 0;
            JSONArray jSONArray = this.c.g;
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = this.c.g.length();
                for (int i = 0; i < length; i++) {
                    String a2 = this.c.a(i);
                    if (TextUtils.isEmpty(a2)) {
                        int i2 = this.e + 1;
                        this.e = i2;
                        if (i2 >= length) {
                            hx1.c("WirelessDebugAction", "Hosts are invalid");
                            p(context, "404");
                        }
                    } else {
                        this.d.execute(new b(this, context, a2, this.c.c(i), b2, unitedSchemeEntity, callbackHandler));
                    }
                }
                return;
            }
            ExecutorUtilsExt.postOnSerial(new a(this, context, b2, unitedSchemeEntity, callbackHandler), "WirelessDebugAction");
        }
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                if (e23.b) {
                    Log.e("WirelessDebugAction", "url encode fail", e);
                    return str;
                }
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            el2.a W = g03.K().q().W();
            k73 k73Var = new k73();
            k73Var.j(W);
            k73Var.a = a73.n(W.G());
            k73Var.b = "launch";
            k73Var.c = "adb-debug";
            k73Var.e = "download_fail";
            a73.onEvent(k73Var);
        }
    }

    public final fl2.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (fl2.a) ((fl2.a) ((fl2.a) new fl2.a().v0(this.c.a)).A0(false)).P0(this.c.d) : (fl2.a) invokeV.objValue;
    }

    public final void p(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) {
            String string = v83.a().getString("errorURL", "");
            if (TextUtils.isEmpty(string)) {
                zz2.g(context, "IPs are invalid ：" + str).G();
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(SchemeConfig.getSchemeHead());
            sb.append("://v1/easybrowse/open?url=");
            sb.append(m(string + "?" + str));
            SchemeRouter.invoke(context, sb.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b9, code lost:
        if (r6 >= r4.c.g.length()) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, str2, file, unitedSchemeEntity, callbackHandler}) == null) {
            try {
                Response executeSync = j74.g().getRequest().url(str).connectionTimeout(1500).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                    mg4.a(executeSync.body().byteStream(), file);
                    Intent g1 = fl2.g1(context, o());
                    g1.putExtra(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, this.c.e);
                    g1.putExtra("slavePreload", this.c.f);
                    g1.putExtra("extraWSUrl", str2);
                    context.startActivity(g1);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.d != null) {
                        this.d.shutdownNow();
                        this.d = null;
                    }
                    if (!ProcessUtils.isMainProcess()) {
                        if (e23.b) {
                            Log.d("WirelessDebugAction", "Suicide for reload.");
                        }
                        cy1.d();
                    }
                }
                if (executeSync != null) {
                    executeSync.close();
                }
            } catch (IOException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                synchronized (this) {
                    if (this.c.g != null) {
                        int i = this.e + 1;
                        this.e = i;
                    }
                    hx1.c("WirelessDebugAction", "Host IPs are invalid");
                    p(context, "404");
                    n();
                }
            }
        }
    }
}
