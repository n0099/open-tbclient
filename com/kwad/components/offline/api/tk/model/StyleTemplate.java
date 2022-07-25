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
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class StyleTemplate extends BaseOfflineCompoJsonParse<StyleTemplate> implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -6279192768068169498L;
    public transient /* synthetic */ FieldHolder $fh;
    public String templateId;
    public String templateMd5;
    public String templateUrl;
    public String templateVersion;
    public int templateVersionCode;
    public String tkFileName;
    public int tkSouce;

    public StyleTemplate() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(StyleTemplate styleTemplate, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, styleTemplate, jSONObject) == null) || jSONObject == null) {
            return;
        }
        styleTemplate.templateId = jSONObject.optString("templateId");
        if (jSONObject.opt("templateId") == JSONObject.NULL) {
            styleTemplate.templateId = "";
        }
        styleTemplate.templateUrl = jSONObject.optString("templateUrl");
        if (jSONObject.opt("templateUrl") == JSONObject.NULL) {
            styleTemplate.templateUrl = "";
        }
        styleTemplate.templateVersion = jSONObject.optString("templateVersion");
        if (jSONObject.opt("templateVersion") == JSONObject.NULL) {
            styleTemplate.templateVersion = "";
        }
        styleTemplate.templateVersionCode = jSONObject.optInt("templateVersionCode");
        styleTemplate.templateMd5 = jSONObject.optString("templateMd5");
        if (jSONObject.opt("templateMd5") == JSONObject.NULL) {
            styleTemplate.templateMd5 = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(StyleTemplate styleTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, styleTemplate)) == null) ? toJson(styleTemplate, (JSONObject) null) : (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(StyleTemplate styleTemplate, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, styleTemplate, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            String str = styleTemplate.templateId;
            if (str != null && !str.equals("")) {
                r.putValue(jSONObject, "templateId", styleTemplate.templateId);
            }
            String str2 = styleTemplate.templateUrl;
            if (str2 != null && !str2.equals("")) {
                r.putValue(jSONObject, "templateUrl", styleTemplate.templateUrl);
            }
            String str3 = styleTemplate.templateVersion;
            if (str3 != null && !str3.equals("")) {
                r.putValue(jSONObject, "templateVersion", styleTemplate.templateVersion);
            }
            int i = styleTemplate.templateVersionCode;
            if (i != 0) {
                r.putValue(jSONObject, "templateVersionCode", i);
            }
            String str4 = styleTemplate.templateMd5;
            if (str4 != null && !str4.equals("")) {
                r.putValue(jSONObject, "templateMd5", styleTemplate.templateMd5);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
