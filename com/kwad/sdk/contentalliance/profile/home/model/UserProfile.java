package com.kwad.sdk.contentalliance.profile.home.model;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class UserProfile implements b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 8190442197779201133L;
    public transient /* synthetic */ FieldHolder $fh;
    public String authorGender;
    public String authorIcon;
    public long authorId;
    public String authorName;
    public OwnerCount ownerCount;
    public List<TabInfo> tabList;

    /* loaded from: classes7.dex */
    public static class OwnerCount implements b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6850889799944988895L;
        public transient /* synthetic */ FieldHolder $fh;
        public long fansCount;
        public long followCount;
        public long ownerCount;
        public long publicPhotoCount;

        public OwnerCount() {
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
            this.fansCount = jSONObject.optLong("fansCount");
            this.followCount = jSONObject.optLong("followCount");
            this.ownerCount = jSONObject.optLong("ownerCount");
            this.publicPhotoCount = jSONObject.optLong("publicPhotoCount");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                o.a(jSONObject, "fansCount", this.fansCount);
                o.a(jSONObject, "followCount", this.followCount);
                o.a(jSONObject, "ownerCount", this.ownerCount);
                o.a(jSONObject, "publicPhotoCount", this.publicPhotoCount);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class TabInfo implements b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4013982742376017878L;
        public transient /* synthetic */ FieldHolder $fh;
        public long tabId;
        public String tabName;

        public TabInfo() {
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
            this.tabId = jSONObject.optLong("tabId");
            this.tabName = jSONObject.optString("tabName");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                o.a(jSONObject, "tabId", this.tabId);
                o.a(jSONObject, "tabName", this.tabName);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public UserProfile() {
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
        this.ownerCount = new OwnerCount();
        this.tabList = new ArrayList();
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.authorId = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        this.authorName = jSONObject.optString("authorName");
        this.authorIcon = jSONObject.optString("authorIcon");
        this.authorGender = jSONObject.optString("authorGender");
        this.ownerCount.parseJson(jSONObject.optJSONObject("ownerCount"));
        JSONArray optJSONArray = jSONObject.optJSONArray("tabList");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                TabInfo tabInfo = new TabInfo();
                tabInfo.parseJson(optJSONObject);
                this.tabList.add(tabInfo);
            }
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, URLPackage.KEY_AUTHOR_ID, this.authorId);
            o.a(jSONObject, "authorName", this.authorName);
            o.a(jSONObject, "authorGender", this.authorGender);
            o.a(jSONObject, "authorIcon", this.authorIcon);
            o.a(jSONObject, "ownerCount", this.ownerCount);
            o.a(jSONObject, "tabList", this.tabList);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
