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
/* loaded from: classes5.dex */
public class d22 extends v12<JSONObject, us1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d22() {
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
    @Override // com.repackage.z12
    @NonNull
    /* renamed from: c */
    public us1 a(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new us1(202);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return new us1(202, "data is required");
            }
            String optString = optJSONObject.optString("status");
            if (TextUtils.isEmpty(optString)) {
                return new us1(202, "status is required");
            }
            char c = 65535;
            int hashCode = optString.hashCode();
            if (hashCode != 48) {
                if (hashCode == 49 && optString.equals("1")) {
                    c = 0;
                }
            } else if (optString.equals("0")) {
                c = 1;
            }
            if (c != 0) {
                if (c != 1) {
                    return new us1(202, "status value is invalid");
                }
                new t12().d();
            }
            return new us1(0);
        }
        return (us1) invokeL.objValue;
    }
}
