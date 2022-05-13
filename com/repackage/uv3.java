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
import com.repackage.qj2;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class uv3 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements qj2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uv3 a;

        public a(uv3 uv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uv3Var;
        }

        @Override // com.repackage.qj2.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.repackage.qj2.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.l(R.string.obfuscated_res_0x7f0f015f);
            }
        }

        @Override // com.repackage.qj2.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                File c = vv3.c();
                File b = vv3.b();
                if (!c.exists() || !xg4.U(c.getPath(), b.getPath())) {
                    this.a.l(R.string.obfuscated_res_0x7f0f015f);
                } else {
                    this.a.l(R.string.obfuscated_res_0x7f0f0160);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uv3(r13 r13Var) {
        super(r13Var, "/swanAPI/debug/dashboardConnect");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r13Var};
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

    @Override // com.repackage.r23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u03Var)) == null) {
            if (r23.b) {
                JSONObject a2 = r23.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    l(R.string.obfuscated_res_0x7f0f012b);
                    return false;
                }
                String optString = a2.optString("meterUrl");
                if (TextUtils.isEmpty(optString)) {
                    l(R.string.obfuscated_res_0x7f0f012c);
                    return false;
                }
                vv3.a();
                qj2.d dVar = new qj2.d();
                dVar.a = k(context, optString);
                new b82().e(dVar, vv3.c().getPath(), new a(this));
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
            String i = bk2.h0().i(context);
            String str2 = new String(kx3.g().a("BASE64", (i + "\u0000\u0000").getBytes()));
            String str3 = str.contains("?") ? "&" : "?";
            return str + str3 + "cuid=" + str2;
        }
        return (String) invokeLL.objValue;
    }

    public final void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            Toast.makeText(bk2.c(), i, 1).show();
        }
    }
}
