package com.kwad.sdk.contentalliance.tube.model;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.d.a;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TubeInfo implements b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 4200733339719277993L;
    public transient /* synthetic */ FieldHolder $fh;
    public long authorId;
    public String authorName;
    public boolean isFinished;
    public String name;
    public String summary;
    public List<String> tagList;
    public int totalEpisodeCount;
    public long tubeId;

    public TubeInfo() {
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
        this.tagList = new ArrayList();
        this.totalEpisodeCount = -1;
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.tubeId = jSONObject.optLong(URLPackage.KEY_TUBE_ID, 0L);
        this.name = jSONObject.optString("name", "");
        this.authorId = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID, 0L);
        this.authorName = jSONObject.optString("authorName", "");
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("tagList");
            if (optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString = optJSONArray.optString(i2);
                    if (optString != null && !optString.isEmpty()) {
                        this.tagList.add(optString);
                    }
                }
            }
        } catch (Exception e2) {
            a.a(e2);
        }
        this.totalEpisodeCount = jSONObject.optInt("totalEpisodeCount", -1);
        this.isFinished = jSONObject.optBoolean("isFinished", false);
        this.summary = jSONObject.optString("summary", "");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, URLPackage.KEY_TUBE_ID, this.tubeId);
            o.a(jSONObject, "name", this.name);
            o.a(jSONObject, URLPackage.KEY_AUTHOR_ID, this.authorId);
            o.a(jSONObject, "authorName", this.authorName);
            o.a(jSONObject, "tagList", this.tagList);
            o.a(jSONObject, "totalEpisodeCount", this.totalEpisodeCount);
            o.a(jSONObject, "isFinished", this.isFinished);
            o.a(jSONObject, "summary", this.summary);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "TubeProfileResultData{name='" + this.name + "', authorId=" + this.authorId + ", authorName='" + this.authorName + "', tagList=" + this.tagList + ", totalEpisodeCount=" + this.totalEpisodeCount + ", isFinished=" + this.isFinished + ", summary='" + this.summary + "'}";
        }
        return (String) invokeV.objValue;
    }
}
