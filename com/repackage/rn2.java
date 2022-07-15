package com.repackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class rn2 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements kv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ h03 c;
        public final /* synthetic */ zn2 d;
        public final /* synthetic */ rn2 e;

        public a(rn2 rn2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var, zn2 zn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn2Var, unitedSchemeEntity, callbackHandler, h03Var, zn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = rn2Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = h03Var;
            this.d = zn2Var;
        }

        @Override // com.repackage.kv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (e23.b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.e.p(this.a, this.b, this.c, this.d);
            }
        }

        @Override // com.repackage.kv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.safeCallback(this.b, this.a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.d.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements kv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ h03 d;
        public final /* synthetic */ zn2 e;
        public final /* synthetic */ rn2 f;

        public b(rn2 rn2Var, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var, zn2 zn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn2Var, context, unitedSchemeEntity, callbackHandler, h03Var, zn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = rn2Var;
            this.a = context;
            this.b = unitedSchemeEntity;
            this.c = callbackHandler;
            this.d = h03Var;
            this.e = zn2Var;
        }

        @Override // com.repackage.kv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (e23.b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f.r(this.a, this.b, this.c, this.d, this.e);
            }
        }

        @Override // com.repackage.kv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.safeCallback(this.c, this.b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.e.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements do2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h03 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ zn2 d;

        public c(rn2 rn2Var, h03 h03Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, zn2 zn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn2Var, h03Var, callbackHandler, unitedSchemeEntity, zn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h03Var;
            this.b = callbackHandler;
            this.c = unitedSchemeEntity;
            this.d = zn2Var;
        }

        @Override // com.repackage.do2
        public void a(boolean z, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, obj}) == null) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (e23.b) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).getTempPath());
                        }
                    }
                    hx1.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.b, this.c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(xn2.n(arrayList, this.a), 0).toString(), this.d.c);
                }
                yn2.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements bo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zn2 a;
        public final /* synthetic */ h03 b;
        public final /* synthetic */ do2 c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ UnitedSchemeEntity e;

        public d(rn2 rn2Var, zn2 zn2Var, h03 h03Var, do2 do2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn2Var, zn2Var, h03Var, do2Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zn2Var;
            this.b = h03Var;
            this.c = do2Var;
            this.d = callbackHandler;
            this.e = unitedSchemeEntity;
        }

        @Override // com.repackage.bo2
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                hx1.i("chooseVideo", "capture success");
                yn2.i(vn2.c(file));
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", ul2.U().G().k());
                bundle.putBoolean("compressed", this.a.b);
                bundle.putString("swanAppId", this.b.b);
                bundle.putParcelableArrayList("mediaModels", yn2.e());
                xn2.h(this.b.w(), bundle, this.c);
            }
        }

        @Override // com.repackage.bo2
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.d, this.e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.a.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements co2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ zn2 c;
        public final /* synthetic */ h03 d;

        public e(rn2 rn2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, zn2 zn2Var, h03 h03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn2Var, callbackHandler, unitedSchemeEntity, zn2Var, h03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = zn2Var;
            this.d = h03Var;
        }

        @Override // com.repackage.co2
        public void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                hx1.i("chooseVideo", str);
                UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.c.c);
            }
        }

        @Override // com.repackage.co2
        public void g(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    hx1.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(xn2.n(list, this.d), 0).toString(), this.c.c);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.c.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rn2(e13 e13Var) {
        super(e13Var, "/swanAPI/chooseVideo");
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
            if (h03Var != null && h03Var.n0()) {
                if (e23.b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            zn2 a2 = zn2.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
            if (a2.a == 2) {
                q(context, unitedSchemeEntity, callbackHandler, h03Var, a2);
            } else {
                o(context, unitedSchemeEntity, callbackHandler, h03Var, a2);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var, zn2 zn2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, h03Var, zn2Var) == null) {
            jv2.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new b(this, context, unitedSchemeEntity, callbackHandler, h03Var, zn2Var));
        }
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var, zn2 zn2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, callbackHandler, h03Var, zn2Var) == null) {
            d dVar = new d(this, zn2Var, h03Var, new c(this, h03Var, callbackHandler, unitedSchemeEntity, zn2Var), callbackHandler, unitedSchemeEntity);
            vn2.e(h03Var.w(), h03Var.b, zn2Var.e, TextUtils.equals(zn2Var.d, "front"), dVar);
        }
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var, zn2 zn2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, h03Var, zn2Var) == null) {
            jv2.e("android.permission.CAMERA", new String[]{"android.permission.CAMERA"}, 1, context, new a(this, unitedSchemeEntity, callbackHandler, h03Var, zn2Var));
        }
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var, zn2 zn2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, context, unitedSchemeEntity, callbackHandler, h03Var, zn2Var) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "video");
            bundle.putBoolean("isShowCamera", zn2Var.a == 3);
            bundle.putBoolean("isFrontCamera", TextUtils.equals(zn2Var.d, "front"));
            bundle.putInt("maxDuration", zn2Var.e);
            bundle.putInt("count", 1);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", zn2Var.b);
            bundle.putString("swanAppId", h03Var.b);
            bundle.putString("swanTmpPath", ul2.U().G().k());
            xn2.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, zn2Var, h03Var));
        }
    }
}
