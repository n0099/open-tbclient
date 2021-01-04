package com.kwad.sdk.core.c.a;

import com.kwad.sdk.emotion.model.EmotionAuthor;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class n implements com.kwad.sdk.core.c<EmotionAuthor> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(EmotionAuthor emotionAuthor) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "id", emotionAuthor.id);
        com.kwad.sdk.utils.o.a(jSONObject, "name", emotionAuthor.name);
        com.kwad.sdk.utils.o.a(jSONObject, "userHead", emotionAuthor.userHead);
        com.kwad.sdk.utils.o.a(jSONObject, "userDesc", emotionAuthor.userDesc);
        com.kwad.sdk.utils.o.a(jSONObject, "followed", emotionAuthor.followed);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(EmotionAuthor emotionAuthor, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        emotionAuthor.id = jSONObject.optString("id");
        emotionAuthor.name = jSONObject.optString("name");
        emotionAuthor.userHead = jSONObject.optString("userHead");
        emotionAuthor.userDesc = jSONObject.optString("userDesc");
        emotionAuthor.followed = jSONObject.optString("followed");
    }
}
