package com.kwad.sdk.core.config.item;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsAdSDK;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends a<Integer> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("batchReportCacheType", 2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static int a(@Nullable Context context) {
        InterceptResult invokeL;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            com.kwad.sdk.core.d.a.a("BatchReportCacheTypeConfigItem", "loadBatchReportCacheType");
            if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0)) == null) {
                return 2;
            }
            return sharedPreferences.getInt("batchReportCacheType", 2);
        }
        return invokeL.intValue;
    }

    public static void a(@Nullable Context context, int i2) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, context, i2) == null) {
            com.kwad.sdk.core.d.a.a("BatchReportCacheTypeConfigItem", "saveBatchReportCacheType");
            if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0)) == null) {
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("batchReportCacheType", i2);
            edit.apply();
        }
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editor) == null) {
            a(KsAdSDK.getContext(), b().intValue());
        }
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sharedPreferences) == null) {
            a((b) Integer.valueOf(a(KsAdSDK.getContext())));
        }
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            a((b) (jSONObject != null ? Integer.valueOf(jSONObject.optInt(a(), c().intValue())) : c()));
        }
    }
}
