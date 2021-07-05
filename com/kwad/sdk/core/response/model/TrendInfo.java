package com.kwad.sdk.core.response.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TrendInfo implements com.kwad.sdk.core.b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static Comparator<TrendInfo> mTrendsComparator = null;
    public static final long serialVersionUID = 8690126962689904212L;
    public transient /* synthetic */ FieldHolder $fh;
    public String coverUrl;
    public String iconUrl;
    public String name;
    public long offlineTime;
    public int photoCount;
    public int rank;
    public long trendId;
    public long viewCount;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(193555375, "Lcom/kwad/sdk/core/response/model/TrendInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(193555375, "Lcom/kwad/sdk/core/response/model/TrendInfo;");
                return;
            }
        }
        mTrendsComparator = new Comparator<TrendInfo>() { // from class: com.kwad.sdk.core.response.model.TrendInfo.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(TrendInfo trendInfo, TrendInfo trendInfo2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, trendInfo, trendInfo2)) == null) {
                    int i2 = trendInfo.rank;
                    int i3 = trendInfo2.rank;
                    if (i2 == i3) {
                        return 0;
                    }
                    return i2 > i3 ? 1 : -1;
                }
                return invokeLL.intValue;
            }
        };
    }

    public TrendInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static List<TrendInfo> asList(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    TrendInfo trendInfo = new TrendInfo();
                    trendInfo.parseJson(new JSONObject(jSONArray.optString(i2)));
                    arrayList.add(trendInfo);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String toString(@NonNull List<TrendInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < list.size(); i2++) {
                jSONArray.put(list.get(i2).toJson().toString());
            }
            return jSONArray.toString();
        }
        return (String) invokeL.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof TrendInfo) && ((TrendInfo) obj).trendId == this.trendId : invokeL.booleanValue;
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.trendId = jSONObject.optLong(URLPackage.KEY_TREND_ID);
        this.name = jSONObject.optString("name");
        this.viewCount = jSONObject.optLong("viewCount");
        this.offlineTime = jSONObject.optLong("offlineTime");
        this.photoCount = jSONObject.optInt("photoCount");
        this.coverUrl = jSONObject.optString("coverUrl");
        this.iconUrl = jSONObject.optString("iconUrl");
        this.rank = jSONObject.optInt("rank");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, URLPackage.KEY_TREND_ID, this.trendId);
            o.a(jSONObject, "name", this.name);
            o.a(jSONObject, "viewCount", this.viewCount);
            o.a(jSONObject, "offlineTime", this.offlineTime);
            o.a(jSONObject, "photoCount", this.photoCount);
            o.a(jSONObject, "coverUrl", this.coverUrl);
            o.a(jSONObject, "iconUrl", this.iconUrl);
            o.a(jSONObject, "rank", this.rank);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
