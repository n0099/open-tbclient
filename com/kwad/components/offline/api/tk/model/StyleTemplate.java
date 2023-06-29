package com.kwad.components.offline.api.tk.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.sdk.utils.r;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class StyleTemplate extends BaseOfflineCompoJsonParse<StyleTemplate> implements Serializable {
    public static final long serialVersionUID = -6279192768068169498L;
    public String templateId;
    public String templateMd5;
    public String templateUrl;
    public String templateVersion;
    public int templateVersionCode;
    public String tkFileName;
    public int tkSouce;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(StyleTemplate styleTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
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
        return toJson(styleTemplate, (JSONObject) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(StyleTemplate styleTemplate, JSONObject jSONObject) {
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
}
