package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = z;
        if (a(TextUtils.isEmpty(str) ? "grs_app_global_route_config.json" : str, context) == 0) {
            this.d = true;
        }
    }

    public d(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = z2;
        this.d = z;
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.a = new com.huawei.hms.framework.network.grs.local.model.a();
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONArray("applications").getJSONObject(0);
                this.a.b(jSONObject.getString("name"));
                JSONArray jSONArray = jSONObject.getJSONArray("services");
                if (jSONArray != null && jSONArray.length() != 0) {
                    if (jSONObject.has("customservices")) {
                        b(jSONObject.getJSONArray("customservices"));
                    }
                    return 0;
                }
                return -1;
            } catch (JSONException e) {
                Logger.w("LocalManagerV2", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
                return -1;
            }
        }
        return invokeL.intValue;
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int b(String str) {
        InterceptResult invokeL;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.b = new ArrayList(16);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("countryOrAreaGroups")) {
                    jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
                } else if (jSONObject.has("countryGroups")) {
                    jSONArray = jSONObject.getJSONArray("countryGroups");
                } else {
                    Logger.e("LocalManagerV2", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                    jSONArray = null;
                }
                if (jSONArray == null) {
                    return -1;
                }
                if (jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        com.huawei.hms.framework.network.grs.local.model.b bVar = new com.huawei.hms.framework.network.grs.local.model.b();
                        bVar.b(jSONObject2.getString("id"));
                        bVar.c(jSONObject2.getString("name"));
                        bVar.a(jSONObject2.getString("description"));
                        if (jSONObject2.has("countriesOrAreas")) {
                            jSONArray2 = jSONObject2.getJSONArray("countriesOrAreas");
                        } else if (jSONObject2.has("countries")) {
                            jSONArray2 = jSONObject2.getJSONArray("countries");
                        } else {
                            Logger.w("LocalManagerV2", "current country or area group has not config countries or areas.");
                            jSONArray2 = null;
                        }
                        HashSet hashSet = new HashSet(16);
                        if (jSONArray2 != null && jSONArray2.length() != 0) {
                            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                hashSet.add((String) jSONArray2.get(i2));
                            }
                            bVar.a(hashSet);
                            this.b.add(bVar);
                        }
                        return -1;
                    }
                }
                return 0;
            } catch (JSONException e) {
                Logger.w("LocalManagerV2", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
                return -1;
            }
        }
        return invokeL.intValue;
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? d(str) : invokeL.intValue;
    }
}
