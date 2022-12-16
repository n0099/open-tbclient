package com.kwad.components.offline.api.tk.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.sdk.utils.r;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class StyleTemplatesConfig extends BaseOfflineCompoJsonParse<StyleTemplatesConfig> implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -6279192768068169498L;
    public transient /* synthetic */ FieldHolder $fh;
    public List<StyleTemplate> styleTemplates;

    public StyleTemplatesConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.styleTemplates = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(StyleTemplatesConfig styleTemplatesConfig, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, styleTemplatesConfig, jSONObject) == null) || jSONObject == null) {
            return;
        }
        styleTemplatesConfig.styleTemplates = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("styleTemplates");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                StyleTemplate styleTemplate = new StyleTemplate();
                styleTemplate.parseJson(optJSONArray.optJSONObject(i));
                styleTemplatesConfig.styleTemplates.add(styleTemplate);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(StyleTemplatesConfig styleTemplatesConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, styleTemplatesConfig)) == null) ? toJson(styleTemplatesConfig, (JSONObject) null) : (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(StyleTemplatesConfig styleTemplatesConfig, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, styleTemplatesConfig, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            r.putValue(jSONObject, "styleTemplates", styleTemplatesConfig.styleTemplates);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
