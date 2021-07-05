package com.kwad.sdk.contentalliance.tube.model;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.b.d;
import com.kwad.sdk.core.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TubeProfile implements b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 7887251687731744372L;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.lib.widget.b<AdTemplate> adTemplateList;
    public String extra;
    public long llsid;
    public SceneImpl mSceneImpl;
    public TubeInfo tubeInfo;

    public TubeProfile() {
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
        this.tubeInfo = new TubeInfo();
        this.adTemplateList = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.tubeInfo.parseJson(jSONObject.getJSONObject("tubeInfo"));
            JSONArray jSONArray = new JSONArray(d.b(jSONObject.optString("impAdInfo")));
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        AdTemplate adTemplate = new AdTemplate();
                        adTemplate.parseJson(optJSONObject);
                        adTemplate.llsid = this.llsid;
                        adTemplate.extra = this.extra;
                        adTemplate.mAdScene = this.mSceneImpl;
                        this.adTemplateList.add(adTemplate);
                    }
                }
            }
        } catch (Exception e2) {
            a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "tubeInfo", this.tubeInfo);
            o.a(jSONObject, "impAdInfo", this.adTemplateList);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
