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
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TubeProfileResultData extends BaseResultData implements b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 4200733339719277993L;
    public transient /* synthetic */ FieldHolder $fh;
    public SceneImpl mSceneImpl;
    public List<TubeProfile> trendList;
    public TubeProfile tubeProfile;

    public TubeProfileResultData() {
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
        this.tubeProfile = new TubeProfile();
        this.trendList = new ArrayList();
    }

    public TubeProfileResultData(SceneImpl sceneImpl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sceneImpl};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.tubeProfile = new TubeProfile();
        this.trendList = new ArrayList();
        this.mSceneImpl = sceneImpl;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.parseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            try {
                this.tubeProfile.llsid = this.llsid;
                this.tubeProfile.extra = this.extra;
                this.tubeProfile.mSceneImpl = this.mSceneImpl;
                this.tubeProfile.parseJson(jSONObject.optJSONObject("tubeProfile"));
                JSONArray optJSONArray = jSONObject.optJSONArray("trendList");
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    return;
                }
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        TubeProfile tubeProfile = new TubeProfile();
                        tubeProfile.llsid = this.llsid;
                        tubeProfile.extra = this.extra;
                        tubeProfile.mSceneImpl = this.mSceneImpl;
                        tubeProfile.parseJson(optJSONObject);
                        this.trendList.add(tubeProfile);
                    }
                }
            } catch (Exception e2) {
                a.a(e2);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject json = super.toJson();
            o.a(json, "trendList", this.trendList);
            o.a(json, "tubeProfile", this.tubeProfile);
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }
}
