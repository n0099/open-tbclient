package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.aa;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class q extends b<List<String>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(String str, List<String> list) {
        super(str, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, list};
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
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences.Editor editor) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, editor) == null) && aa.a(a())) {
            editor.putString(b(), com.kwad.sdk.utils.q.a(a()).toString());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sharedPreferences) == null) {
            List a2 = com.kwad.sdk.utils.q.a(sharedPreferences.getString(b(), ""));
            if (aa.a(a2)) {
                a((q) a2);
            } else {
                a((q) c());
            }
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray(b())) != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString = optJSONArray.optString(i2);
                    if (optString != null && !optString.isEmpty()) {
                        arrayList.add(optString);
                    }
                }
                if (arrayList.size() > 0) {
                    a((q) arrayList);
                    return;
                }
            }
            a((q) c());
        }
    }
}
