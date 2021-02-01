package com.kwad.sdk.core.c.a;

import com.kwad.sdk.emotion.model.EmotionCode;
import com.kwai.video.player.KsMediaMeta;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o implements com.kwad.sdk.core.c<EmotionCode> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(EmotionCode emotionCode) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, KsMediaMeta.KSM_KEY_LANGUAGE, emotionCode.language);
        com.kwad.sdk.utils.o.a(jSONObject, "codes", emotionCode.codes);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(EmotionCode emotionCode, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        emotionCode.language = jSONObject.optString(KsMediaMeta.KSM_KEY_LANGUAGE);
        emotionCode.codes = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("codes");
        if (optJSONArray == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                return;
            }
            emotionCode.codes.add((String) optJSONArray.opt(i2));
            i = i2 + 1;
        }
    }
}
