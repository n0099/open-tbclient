package com.kwad.components.offline.api.tk.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.sdk.utils.r;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class StyleTemplatesConfig extends BaseOfflineCompoJsonParse<StyleTemplatesConfig> implements Serializable {
    public static final long serialVersionUID = -6279192768068169498L;
    public List<StyleTemplate> styleTemplates = new ArrayList();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(StyleTemplatesConfig styleTemplatesConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
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
        return toJson(styleTemplatesConfig, (JSONObject) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(StyleTemplatesConfig styleTemplatesConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        r.putValue(jSONObject, "styleTemplates", styleTemplatesConfig.styleTemplates);
        return jSONObject;
    }
}
