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
public class e13 extends UnitedSchemeBaseDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, e23> a;

    public e13() {
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
        List<e23> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new y13(this));
            b(new rr2(this));
            b(new h23(this));
            b(new k13(this));
            b(new kr2(this));
            b(new t13(this));
            b(new d83(this));
            b(new e83(this));
            b(new x73(this));
            b(new y73(this));
            b(new f83(this));
            b(new g83(this));
            b(new a83(this));
            b(new b83(this));
            b(new s73(this));
            b(new t73(this));
            b(new y43(this));
            b(new x43(this));
            b(new v43(this));
            b(new t43(this));
            b(new s43(this));
            b(new r43(this));
            b(new u43(this));
            b(new b53(this));
            b(new n13(this));
            b(new c23(this));
            b(new d72(this));
            b(new g23(this));
            b(new v13(this));
            b(new u13(this));
            b(new ha3(this));
            b(new ia3(this));
            b(new u93(this));
            b(new v93(this));
            b(new uo2(this));
            b(new x13(this));
            b(new cp2(this));
            b(new wr2(this));
            b(new o13(this));
            b(new e33(this));
            b(new b33(this));
            b(new ms1(this));
            b(new b23(this));
            b(new SwanAppDownloadAction(this));
            b(new f23(this));
            b(new c33(this));
            b(new z23(this));
            b(new y23(this));
            b(new qa3(this));
            b(new ra3(this));
            b(new da3(this));
            b(new ba3(this));
            b(new w93(this));
            b(new ta3(this));
            b(new x93(this));
            b(new y93(this));
            b(new sa3(this));
            b(new yn1(this));
            b(new z43(this));
            b(new ah2(this));
            b(new zn1(this));
            b(new qx2(this));
            b(new ox2(this));
            b(new rx2(this));
            b(new px2(this));
            mh1 d = pj2.d();
            if (d == null || (c = d.c(this)) == null || c.isEmpty()) {
                return;
            }
            for (e23 e23Var : c) {
                b(e23Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void b(e23 e23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e23Var) == null) {
            this.a.put(e23Var.a, e23Var);
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
                        e23 e23Var = this.a.get(str);
                        if (e23Var != null) {
                            if (unitedSchemeEntity.isOnlyVerify()) {
                                return true;
                            }
                            return e23Var.h(context, unitedSchemeEntity, callbackHandler, "/swanAPI" + uri.getPath());
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
