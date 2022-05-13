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
/* loaded from: classes7.dex */
public class r13 extends UnitedSchemeBaseDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, r23> a;

    public r13() {
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
        List<r23> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new l23(this));
            b(new es2(this));
            b(new u23(this));
            b(new x13(this));
            b(new xr2(this));
            b(new g23(this));
            b(new q83(this));
            b(new r83(this));
            b(new k83(this));
            b(new l83(this));
            b(new s83(this));
            b(new t83(this));
            b(new n83(this));
            b(new o83(this));
            b(new f83(this));
            b(new g83(this));
            b(new l53(this));
            b(new k53(this));
            b(new i53(this));
            b(new g53(this));
            b(new f53(this));
            b(new e53(this));
            b(new h53(this));
            b(new o53(this));
            b(new a23(this));
            b(new p23(this));
            b(new q72(this));
            b(new t23(this));
            b(new i23(this));
            b(new h23(this));
            b(new ua3(this));
            b(new va3(this));
            b(new ha3(this));
            b(new ia3(this));
            b(new hp2(this));
            b(new k23(this));
            b(new pp2(this));
            b(new js2(this));
            b(new b23(this));
            b(new r33(this));
            b(new o33(this));
            b(new zs1(this));
            b(new o23(this));
            b(new SwanAppDownloadAction(this));
            b(new s23(this));
            b(new p33(this));
            b(new m33(this));
            b(new l33(this));
            b(new db3(this));
            b(new eb3(this));
            b(new qa3(this));
            b(new oa3(this));
            b(new ja3(this));
            b(new gb3(this));
            b(new ka3(this));
            b(new la3(this));
            b(new fb3(this));
            b(new lo1(this));
            b(new m53(this));
            b(new nh2(this));
            b(new mo1(this));
            b(new dy2(this));
            b(new by2(this));
            b(new ey2(this));
            b(new cy2(this));
            zh1 d = ck2.d();
            if (d == null || (c = d.c(this)) == null || c.isEmpty()) {
                return;
            }
            for (r23 r23Var : c) {
                b(r23Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void b(r23 r23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r23Var) == null) {
            this.a.put(r23Var.a, r23Var);
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
                        r23 r23Var = this.a.get(str);
                        if (r23Var != null) {
                            if (unitedSchemeEntity.isOnlyVerify()) {
                                return true;
                            }
                            return r23Var.h(context, unitedSchemeEntity, callbackHandler, "/swanAPI" + uri.getPath());
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
