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
/* loaded from: classes6.dex */
public class eo2 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements xv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ u03 c;
        public final /* synthetic */ mo2 d;
        public final /* synthetic */ eo2 e;

        public a(eo2 eo2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var, mo2 mo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo2Var, unitedSchemeEntity, callbackHandler, u03Var, mo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = eo2Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = u03Var;
            this.d = mo2Var;
        }

        @Override // com.repackage.xv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (r23.b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.e.p(this.a, this.b, this.c, this.d);
            }
        }

        @Override // com.repackage.xv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.safeCallback(this.b, this.a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.d.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements xv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ u03 d;
        public final /* synthetic */ mo2 e;
        public final /* synthetic */ eo2 f;

        public b(eo2 eo2Var, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var, mo2 mo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo2Var, context, unitedSchemeEntity, callbackHandler, u03Var, mo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = eo2Var;
            this.a = context;
            this.b = unitedSchemeEntity;
            this.c = callbackHandler;
            this.d = u03Var;
            this.e = mo2Var;
        }

        @Override // com.repackage.xv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (r23.b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f.r(this.a, this.b, this.c, this.d, this.e);
            }
        }

        @Override // com.repackage.xv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.safeCallback(this.c, this.b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.e.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements qo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u03 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ mo2 d;

        public c(eo2 eo2Var, u03 u03Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, mo2 mo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo2Var, u03Var, callbackHandler, unitedSchemeEntity, mo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u03Var;
            this.b = callbackHandler;
            this.c = unitedSchemeEntity;
            this.d = mo2Var;
        }

        @Override // com.repackage.qo2
        public void a(boolean z, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, obj}) == null) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (r23.b) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).getTempPath());
                        }
                    }
                    ux1.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.b, this.c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(ko2.n(arrayList, this.a), 0).toString(), this.d.c);
                }
                lo2.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements oo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mo2 a;
        public final /* synthetic */ u03 b;
        public final /* synthetic */ qo2 c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ UnitedSchemeEntity e;

        public d(eo2 eo2Var, mo2 mo2Var, u03 u03Var, qo2 qo2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo2Var, mo2Var, u03Var, qo2Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mo2Var;
            this.b = u03Var;
            this.c = qo2Var;
            this.d = callbackHandler;
            this.e = unitedSchemeEntity;
        }

        @Override // com.repackage.oo2
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                ux1.i("chooseVideo", "capture success");
                lo2.i(io2.c(file));
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", hm2.U().G().k());
                bundle.putBoolean("compressed", this.a.b);
                bundle.putString("swanAppId", this.b.b);
                bundle.putParcelableArrayList("mediaModels", lo2.e());
                ko2.h(this.b.x(), bundle, this.c);
            }
        }

        @Override // com.repackage.oo2
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.d, this.e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.a.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements po2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ mo2 c;
        public final /* synthetic */ u03 d;

        public e(eo2 eo2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, mo2 mo2Var, u03 u03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo2Var, callbackHandler, unitedSchemeEntity, mo2Var, u03Var};
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
            this.c = mo2Var;
            this.d = u03Var;
        }

        @Override // com.repackage.po2
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ux1.i("chooseVideo", str);
                UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.c.c);
            }
        }

        @Override // com.repackage.po2
        public void f(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    ux1.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(ko2.n(list, this.d), 0).toString(), this.c.c);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.c.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eo2(r13 r13Var) {
        super(r13Var, "/swanAPI/chooseVideo");
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
            if (u03Var != null && u03Var.m0()) {
                if (r23.b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            mo2 a2 = mo2.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
            if (a2.a == 2) {
                q(context, unitedSchemeEntity, callbackHandler, u03Var, a2);
            } else {
                o(context, unitedSchemeEntity, callbackHandler, u03Var, a2);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var, mo2 mo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, u03Var, mo2Var) == null) {
            wv2.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new b(this, context, unitedSchemeEntity, callbackHandler, u03Var, mo2Var));
        }
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var, mo2 mo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, callbackHandler, u03Var, mo2Var) == null) {
            d dVar = new d(this, mo2Var, u03Var, new c(this, u03Var, callbackHandler, unitedSchemeEntity, mo2Var), callbackHandler, unitedSchemeEntity);
            io2.e(u03Var.x(), u03Var.b, mo2Var.e, TextUtils.equals(mo2Var.d, "front"), dVar);
        }
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var, mo2 mo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, u03Var, mo2Var) == null) {
            wv2.e("android.permission.CAMERA", new String[]{"android.permission.CAMERA"}, 1, context, new a(this, unitedSchemeEntity, callbackHandler, u03Var, mo2Var));
        }
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var, mo2 mo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, context, unitedSchemeEntity, callbackHandler, u03Var, mo2Var) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "video");
            bundle.putBoolean("isShowCamera", mo2Var.a == 3);
            bundle.putBoolean("isFrontCamera", TextUtils.equals(mo2Var.d, "front"));
            bundle.putInt("maxDuration", mo2Var.e);
            bundle.putInt("count", 1);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", mo2Var.b);
            bundle.putString("swanAppId", u03Var.b);
            bundle.putString("swanTmpPath", hm2.U().G().k());
            ko2.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, mo2Var, u03Var));
        }
    }
}
