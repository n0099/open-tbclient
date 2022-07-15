package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dj2;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hv3 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements dj2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv3 a;

        public a(hv3 hv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv3Var;
        }

        @Override // com.repackage.dj2.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.repackage.dj2.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.l(R.string.obfuscated_res_0x7f0f0162);
            }
        }

        @Override // com.repackage.dj2.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                File c = iv3.c();
                File b = iv3.b();
                if (!c.exists() || !jg4.U(c.getPath(), b.getPath())) {
                    this.a.l(R.string.obfuscated_res_0x7f0f0162);
                } else {
                    this.a.l(R.string.obfuscated_res_0x7f0f0163);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hv3(e13 e13Var) {
        super(e13Var, "/swanAPI/debug/dashboardConnect");
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
            if (e23.b) {
                JSONObject a2 = e23.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    l(R.string.obfuscated_res_0x7f0f012e);
                    return false;
                }
                String optString = a2.optString("meterUrl");
                if (TextUtils.isEmpty(optString)) {
                    l(R.string.obfuscated_res_0x7f0f012f);
                    return false;
                }
                iv3.a();
                dj2.d dVar = new dj2.d();
                dVar.a = k(context, optString);
                new o72().e(dVar, iv3.c().getPath(), new a(this));
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String k(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            String i = oj2.h0().i(context);
            String str2 = new String(xw3.g().a("BASE64", (i + "\u0000\u0000").getBytes()));
            String str3 = str.contains("?") ? "&" : "?";
            return str + str3 + "cuid=" + str2;
        }
        return (String) invokeLL.objValue;
    }

    public final void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            Toast.makeText(oj2.c(), i, 1).show();
        }
    }
}
