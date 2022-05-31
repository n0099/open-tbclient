package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class e03 extends UnitedSchemeBaseDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, e13> a;

    public e03() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        a();
    }

    public void a() {
        List<e13> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new y03(this));
            b(new rq2(this));
            b(new h13(this));
            b(new k03(this));
            b(new kq2(this));
            b(new t03(this));
            b(new d73(this));
            b(new e73(this));
            b(new x63(this));
            b(new y63(this));
            b(new f73(this));
            b(new g73(this));
            b(new a73(this));
            b(new b73(this));
            b(new s63(this));
            b(new t63(this));
            b(new y33(this));
            b(new x33(this));
            b(new v33(this));
            b(new t33(this));
            b(new s33(this));
            b(new r33(this));
            b(new u33(this));
            b(new b43(this));
            b(new n03(this));
            b(new c13(this));
            b(new d62(this));
            b(new g13(this));
            b(new v03(this));
            b(new u03(this));
            b(new h93(this));
            b(new i93(this));
            b(new u83(this));
            b(new v83(this));
            b(new un2(this));
            b(new x03(this));
            b(new co2(this));
            b(new wq2(this));
            b(new o03(this));
            b(new e23(this));
            b(new b23(this));
            b(new mr1(this));
            b(new b13(this));
            b(new SwanAppDownloadAction(this));
            b(new f13(this));
            b(new c23(this));
            b(new z13(this));
            b(new y13(this));
            b(new q93(this));
            b(new r93(this));
            b(new d93(this));
            b(new b93(this));
            b(new w83(this));
            b(new t93(this));
            b(new x83(this));
            b(new y83(this));
            b(new s93(this));
            b(new ym1(this));
            b(new z33(this));
            b(new ag2(this));
            b(new zm1(this));
            b(new qw2(this));
            b(new ow2(this));
            b(new rw2(this));
            b(new pw2(this));
            mg1 d = pi2.d();
            if (d == null || (c = d.c(this)) == null || c.isEmpty()) {
                return;
            }
            for (e13 e13Var : c) {
                b(e13Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void b(e13 e13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e13Var) == null) {
            this.a.put(e13Var.a, e13Var);
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "swanAPI" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return null;
        }
        return (Class) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            Uri uri = unitedSchemeEntity.getUri();
            if (uri == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty url");
                return false;
            } else if (uri.getPathSegments() != null && !uri.getPathSegments().isEmpty()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("swanAPI");
                arrayList.addAll(uri.getPathSegments());
                String str = "/swanAPI" + uri.getPath();
                if (!TextUtils.isEmpty(str) && str.startsWith("/")) {
                    for (int size = arrayList.size(); size > 0; size--) {
                        String str2 = "/" + ((String) arrayList.get(size - 1));
                        if (str.isEmpty() || str.length() < str2.length()) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "err path ：" + str + " @ " + str2);
                            return false;
                        }
                        e13 e13Var = this.a.get(str);
                        if (e13Var != null) {
                            if (unitedSchemeEntity.isOnlyVerify()) {
                                return true;
                            }
                            return e13Var.h(context, unitedSchemeEntity, callbackHandler, "/swanAPI" + uri.getPath());
                        }
                        str = str.substring(0, str.length() - str2.length());
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "not support such action ：" + uri.getPath());
                    return false;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "err path ：" + str);
                return false;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty Segment");
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
