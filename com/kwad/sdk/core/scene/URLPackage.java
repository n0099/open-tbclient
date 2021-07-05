package com.kwad.sdk.core.scene;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.b;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class URLPackage implements b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_AUTHOR_ID = "authorId";
    public static final String KEY_TREND_ID = "trendId";
    public static final String KEY_TUBE_ID = "tubeId";
    public static final long serialVersionUID = -7365796297335816787L;
    public transient /* synthetic */ FieldHolder $fh;
    public String identity;
    public transient JSONObject mJsonObjectParams;
    public int page;
    public String params;

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

    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.page = jSONObject.optInt("page");
        this.identity = jSONObject.optString("identity");
        String optString = jSONObject.optString("params");
        this.params = optString;
        try {
            if (ag.a(optString)) {
                return;
            }
            this.mJsonObjectParams = new JSONObject(this.params);
        } catch (JSONException unused) {
        }
    }

    public void putParams(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            if (this.mJsonObjectParams == null) {
                this.mJsonObjectParams = new JSONObject();
            }
            o.a(this.mJsonObjectParams, str, j);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "page", this.page);
            o.a(jSONObject, "identity", this.identity);
            JSONObject jSONObject2 = this.mJsonObjectParams;
            if (jSONObject2 != null) {
                o.a(jSONObject, "params", jSONObject2.toString());
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
