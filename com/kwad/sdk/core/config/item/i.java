package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
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
public class i extends a<String> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile String[] f35939a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(String str, String str2) {
        super(str, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        f35939a = null;
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        f35939a = str.split(",");
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editor) == null) {
            editor.putString(a(), b());
        }
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sharedPreferences) == null) {
            String string = sharedPreferences.getString(a(), c());
            a((i) string);
            a(string);
        }
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            if (jSONObject == null) {
                a((i) c());
                return;
            }
            String optString = jSONObject.optString(a(), c());
            a((i) optString);
            a(optString);
        }
    }

    public boolean a(long j) {
        InterceptResult invokeJ;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            if (f35939a == null) {
                return false;
            }
            for (String str : f35939a) {
                if (str != null && String.valueOf(j).equals(str.trim())) {
                    return true;
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }
}
