package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.b.d;
import com.kwad.sdk.core.b.e;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TrendListResultData extends BaseResultData implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FeedResultData";
    public static final long serialVersionUID = -2356227162833699895L;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public List<TrendInfo> trends;

    public TrendListResultData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.trends = new ArrayList();
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.trends.isEmpty()) {
                com.kwad.sdk.core.d.a.d(TAG, "trends list is empty");
                return true;
            }
            com.kwad.sdk.core.d.a.a(TAG, "trends size = " + this.trends.size());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.parseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            String optString = jSONObject.optString("data");
            e.a(jSONObject.optString("egid"));
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONObject(d.b(optString)).getJSONArray("trends");
                if (jSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        TrendInfo trendInfo = new TrendInfo();
                        trendInfo.parseJson(jSONArray.optJSONObject(i2));
                        this.trends.add(trendInfo);
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            o.a(new JSONObject(), "trends", this.trends);
            return new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }
}
