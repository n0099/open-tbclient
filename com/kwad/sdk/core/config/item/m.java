package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.ae;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m extends b<List<com.kwad.sdk.core.response.model.b>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m() {
        super("posContentInfoList", new ArrayList());
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

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences.Editor editor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editor) == null) {
            List<com.kwad.sdk.core.response.model.b> a = a();
            if (ae.a(a)) {
                JSONArray jSONArray = new JSONArray();
                for (com.kwad.sdk.core.response.model.b bVar : a) {
                    jSONArray.put(bVar.toJson());
                }
                editor.putString("posContentInfoList", jSONArray.toString());
            }
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sharedPreferences) == null) {
            try {
                String string = sharedPreferences.getString("posContentInfoList", "");
                if (!TextUtils.isEmpty(string)) {
                    JSONArray jSONArray = new JSONArray(string);
                    if (jSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                            com.kwad.sdk.core.response.model.b bVar = new com.kwad.sdk.core.response.model.b();
                            bVar.parseJson(optJSONObject);
                            arrayList.add(bVar);
                        }
                        if (arrayList.size() > 0) {
                            a((m) arrayList);
                            return;
                        }
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
            a((m) c());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("posContentInfoList")) != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        com.kwad.sdk.core.response.model.b bVar = new com.kwad.sdk.core.response.model.b();
                        bVar.parseJson(optJSONObject);
                        arrayList.add(bVar);
                    }
                }
                if (arrayList.size() > 0) {
                    a((m) arrayList);
                    return;
                }
            }
            a((m) c());
        }
    }
}
