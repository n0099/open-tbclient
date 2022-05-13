package com.repackage;

import android.app.Application;
import android.net.Uri;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rl2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class et3 extends zs3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public et3() {
        super("navigateToSwanGame");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.zs3
    public us1 a(JSONObject paramsJson, yd2 callback) {
        InterceptResult invokeLL;
        rl2.a V;
        String I;
        rl2.a V2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, paramsJson, callback)) == null) {
            Intrinsics.checkNotNullParameter(paramsJson, "paramsJson");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Application c = bk2.c();
            if (c == null) {
                callback.onFail(202, "params may be error");
                return null;
            }
            String optString = paramsJson.optString("appKey");
            boolean z = false;
            if (optString == null || optString.length() == 0) {
                callback.onFail(202, "params may be error");
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            u03 a0 = u03.a0();
            String str = "";
            jSONObject.put("pre_source", (a0 == null || (V2 = a0.V()) == null || (r8 = V2.T()) == null) ? "" : "");
            u03 a02 = u03.a0();
            if (a02 != null && (V = a02.V()) != null && (I = V.I()) != null) {
                str = I;
            }
            jSONObject.put("pre_appid", str);
            paramsJson.put(UBCCloudControlProcessor.UBC_KEY, jSONObject);
            String d1 = sl2.d1(optString, 1, paramsJson);
            Uri parse = (d1 == null || d1.length() == 0) ? true : true ? null : Uri.parse(d1);
            if (parse == null) {
                callback.onFail(202, "params may be error");
                return null;
            }
            if (SchemeRouter.invokeScheme(c, parse, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                callback.a(null);
            } else {
                callback.onFail(202, "params may be error");
            }
            return null;
        }
        return (us1) invokeLL.objValue;
    }
}
