package com.kwad.sdk.live.mode;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class LiveAudienceListResultData extends BaseResultData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -1400500562354543457L;
    public transient /* synthetic */ FieldHolder $fh;
    public List<CurrentWatchingUser> currentWatchingUsers;
    public String displayWatchingCount;
    public int pendingDuration;
    public int sequenceId;

    /* loaded from: classes7.dex */
    public static class CurrentWatchingUser implements b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8900509159435327530L;
        public transient /* synthetic */ FieldHolder $fh;
        public List<HeadUrl> headurls;
        public long user_id;
        public long user_name;

        /* loaded from: classes7.dex */
        public static class HeadUrl implements b, Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -8081450700792739733L;
            public transient /* synthetic */ FieldHolder $fh;
            public String cdn;
            public String url;
            public String urlPattern;

            public HeadUrl() {
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

            public void parseJson(@Nullable JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                    return;
                }
                this.cdn = jSONObject.optString("cdn");
                this.url = jSONObject.optString("url");
                this.urlPattern = jSONObject.optString("urlPattern");
            }

            @Override // com.kwad.sdk.core.b
            public JSONObject toJson() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    JSONObject jSONObject = new JSONObject();
                    o.a(jSONObject, "cdn", this.cdn);
                    o.a(jSONObject, "url", this.url);
                    o.a(jSONObject, "urlPattern", this.urlPattern);
                    return jSONObject;
                }
                return (JSONObject) invokeV.objValue;
            }
        }

        public CurrentWatchingUser() {
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
            this.headurls = new ArrayList();
        }

        public void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("headurls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        HeadUrl headUrl = new HeadUrl();
                        headUrl.parseJson(optJSONObject);
                        this.headurls.add(headUrl);
                    }
                }
            }
            this.user_id = jSONObject.optLong("user_id");
            this.user_name = jSONObject.optLong("user_name");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                o.a(jSONObject, "headurls", this.headurls);
                o.a(jSONObject, "user_id", this.user_id);
                o.a(jSONObject, "user_name", this.user_name);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public LiveAudienceListResultData() {
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
        this.currentWatchingUsers = new ArrayList();
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.parseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("currentWatchingUsers");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        CurrentWatchingUser currentWatchingUser = new CurrentWatchingUser();
                        currentWatchingUser.parseJson(optJSONObject);
                        this.currentWatchingUsers.add(currentWatchingUser);
                    }
                }
            }
            this.pendingDuration = jSONObject.optInt("pendingDuration");
            this.displayWatchingCount = jSONObject.optString("displayWatchingCount");
            this.sequenceId = jSONObject.optInt("sequenceId");
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject json = super.toJson();
            o.a(json, "currentWatchingUsers", this.currentWatchingUsers);
            o.a(json, "pendingDuration", this.pendingDuration);
            o.a(json, "displayWatchingCount", this.displayWatchingCount);
            o.a(json, "sequenceId", this.sequenceId);
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }
}
