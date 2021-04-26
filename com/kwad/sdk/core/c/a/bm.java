package com.kwad.sdk.core.c.a;

import com.kwad.sdk.collector.AppStatusRules;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class bm implements com.kwad.sdk.core.c<AppStatusRules.UploadConfig> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AppStatusRules.UploadConfig uploadConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uploadConfig.fileMaxSize = jSONObject.optLong("fileMaxSize");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(AppStatusRules.UploadConfig uploadConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "fileMaxSize", uploadConfig.fileMaxSize);
        return jSONObject;
    }
}
