package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class r12 extends i12<JSONObject, hs1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public r12() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.m12
    @NonNull
    /* renamed from: c */
    public hs1 a(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            if (b()) {
                if (i12.a) {
                    hx1.b("Api-HandleException", "has triggered fmp before remove skeleton");
                }
                return new hs1(0);
            } else if (jSONObject == null) {
                return new hs1(202);
            } else {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    return new hs1(202, "data is required");
                }
                String optString = optJSONObject.optString("path");
                if (TextUtils.isEmpty(optString)) {
                    return new hs1(202, "path is required");
                }
                g12 g12Var = new g12();
                g12Var.g(optString);
                g12Var.e();
                return new hs1(0);
            }
        }
        return (hs1) invokeL.objValue;
    }
}
