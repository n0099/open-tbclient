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
public class rm2 extends e13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements ku2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ hz2 c;
        public final /* synthetic */ zm2 d;
        public final /* synthetic */ rm2 e;

        public a(rm2 rm2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var, zm2 zm2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm2Var, unitedSchemeEntity, callbackHandler, hz2Var, zm2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = rm2Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = hz2Var;
            this.d = zm2Var;
        }

        @Override // com.repackage.ku2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (e13.b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.e.p(this.a, this.b, this.c, this.d);
            }
        }

        @Override // com.repackage.ku2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.safeCallback(this.b, this.a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.d.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ku2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ hz2 d;
        public final /* synthetic */ zm2 e;
        public final /* synthetic */ rm2 f;

        public b(rm2 rm2Var, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var, zm2 zm2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm2Var, context, unitedSchemeEntity, callbackHandler, hz2Var, zm2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = rm2Var;
            this.a = context;
            this.b = unitedSchemeEntity;
            this.c = callbackHandler;
            this.d = hz2Var;
            this.e = zm2Var;
        }

        @Override // com.repackage.ku2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (e13.b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f.r(this.a, this.b, this.c, this.d, this.e);
            }
        }

        @Override // com.repackage.ku2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.safeCallback(this.c, this.b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.e.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements dn2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz2 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ zm2 d;

        public c(rm2 rm2Var, hz2 hz2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, zm2 zm2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm2Var, hz2Var, callbackHandler, unitedSchemeEntity, zm2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hz2Var;
            this.b = callbackHandler;
            this.c = unitedSchemeEntity;
            this.d = zm2Var;
        }

        @Override // com.repackage.dn2
        public void a(boolean z, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, obj}) == null) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (e13.b) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).getTempPath());
                        }
                    }
                    hw1.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.b, this.c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(xm2.n(arrayList, this.a), 0).toString(), this.d.c);
                }
                ym2.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements bn2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zm2 a;
        public final /* synthetic */ hz2 b;
        public final /* synthetic */ dn2 c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ UnitedSchemeEntity e;

        public d(rm2 rm2Var, zm2 zm2Var, hz2 hz2Var, dn2 dn2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm2Var, zm2Var, hz2Var, dn2Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zm2Var;
            this.b = hz2Var;
            this.c = dn2Var;
            this.d = callbackHandler;
            this.e = unitedSchemeEntity;
        }

        @Override // com.repackage.bn2
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                hw1.i("chooseVideo", "capture success");
                ym2.i(vm2.c(file));
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", uk2.U().G().k());
                bundle.putBoolean("compressed", this.a.b);
                bundle.putString("swanAppId", this.b.b);
                bundle.putParcelableArrayList("mediaModels", ym2.e());
                xm2.h(this.b.x(), bundle, this.c);
            }
        }

        @Override // com.repackage.bn2
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.d, this.e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.a.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements cn2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ zm2 c;
        public final /* synthetic */ hz2 d;

        public e(rm2 rm2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, zm2 zm2Var, hz2 hz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm2Var, callbackHandler, unitedSchemeEntity, zm2Var, hz2Var};
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
            this.c = zm2Var;
            this.d = hz2Var;
        }

        @Override // com.repackage.cn2
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                hw1.i("chooseVideo", str);
                UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.c.c);
            }
        }

        @Override // com.repackage.cn2
        public void f(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    hw1.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(xm2.n(list, this.d), 0).toString(), this.c.c);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.c.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rm2(e03 e03Var) {
        super(e03Var, "/swanAPI/chooseVideo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e03Var};
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

    @Override // com.repackage.e13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hz2Var)) == null) {
            if (hz2Var != null && hz2Var.m0()) {
                if (e13.b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            zm2 a2 = zm2.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
            if (a2.a == 2) {
                q(context, unitedSchemeEntity, callbackHandler, hz2Var, a2);
            } else {
                o(context, unitedSchemeEntity, callbackHandler, hz2Var, a2);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var, zm2 zm2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, hz2Var, zm2Var) == null) {
            ju2.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new b(this, context, unitedSchemeEntity, callbackHandler, hz2Var, zm2Var));
        }
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var, zm2 zm2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, callbackHandler, hz2Var, zm2Var) == null) {
            d dVar = new d(this, zm2Var, hz2Var, new c(this, hz2Var, callbackHandler, unitedSchemeEntity, zm2Var), callbackHandler, unitedSchemeEntity);
            vm2.e(hz2Var.x(), hz2Var.b, zm2Var.e, TextUtils.equals(zm2Var.d, "front"), dVar);
        }
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var, zm2 zm2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, hz2Var, zm2Var) == null) {
            ju2.e("android.permission.CAMERA", new String[]{"android.permission.CAMERA"}, 1, context, new a(this, unitedSchemeEntity, callbackHandler, hz2Var, zm2Var));
        }
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var, zm2 zm2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, context, unitedSchemeEntity, callbackHandler, hz2Var, zm2Var) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "video");
            bundle.putBoolean("isShowCamera", zm2Var.a == 3);
            bundle.putBoolean("isFrontCamera", TextUtils.equals(zm2Var.d, "front"));
            bundle.putInt("maxDuration", zm2Var.e);
            bundle.putInt("count", 1);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", zm2Var.b);
            bundle.putString("swanAppId", hz2Var.b);
            bundle.putString("swanTmpPath", uk2.U().G().k());
            xm2.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, zm2Var, hz2Var));
        }
    }
}
