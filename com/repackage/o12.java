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
/* loaded from: classes6.dex */
public class o12 extends i12<JSONObject, hs1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o12() {
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
            if (jSONObject == null) {
                return new hs1(202);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return new hs1(202, "data is required");
            }
            String optString = optJSONObject.optString("content");
            String optString2 = optJSONObject.optString("type");
            String optString3 = optJSONObject.optString("source");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                hx1.k("Api-HandleException", String.format("发生jserror: type = %s, source = %s, content = %s", optString2, optString3, optString));
                m02.d().e(k02.a(optString2, optString, optString3));
                return new hs1(0);
            }
            return new hs1(202);
        }
        return (hs1) invokeL.objValue;
    }
}
