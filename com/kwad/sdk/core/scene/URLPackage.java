package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.q;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class URLPackage extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_AUTHOR_ID = "authorId";
    public static final String KEY_TREND_ID = "trendId";
    public static final String KEY_TUBE_ID = "tubeId";
    public static final long serialVersionUID = -7365796297335816787L;
    public transient /* synthetic */ FieldHolder $fh;
    public String identity;
    public transient JSONObject mJsonObjectParams;
    public int page;

    public URLPackage() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public URLPackage(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.page = i2;
        this.identity = str;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.afterParseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            String optString = jSONObject.optString("params");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            try {
                this.mJsonObjectParams = new JSONObject(optString);
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.afterToJson(jSONObject);
            JSONObject jSONObject2 = this.mJsonObjectParams;
            if (jSONObject2 != null) {
                q.a(jSONObject, "params", jSONObject2.toString());
            }
        }
    }

    public void putParams(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j) == null) {
            if (this.mJsonObjectParams == null) {
                this.mJsonObjectParams = new JSONObject();
            }
            q.a(this.mJsonObjectParams, str, j);
        }
    }
}
