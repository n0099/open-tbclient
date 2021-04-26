package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class r implements com.kwad.sdk.core.c<PhotoInfo.AuthorInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(PhotoInfo.AuthorInfo authorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        authorInfo.authorId = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        authorInfo.kwaiId = jSONObject.optString("kwaiId");
        authorInfo.authorName = jSONObject.optString("authorName");
        authorInfo.rawAuthorName = jSONObject.optString("rawAuthorName");
        authorInfo.authorIcon = jSONObject.optString("authorIcon");
        authorInfo.authorGender = jSONObject.optString("authorGender");
        authorInfo.authorText = jSONObject.optString("authorText");
        authorInfo.authorIconGuide = jSONObject.optString("authorIconGuide");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(PhotoInfo.AuthorInfo authorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, URLPackage.KEY_AUTHOR_ID, authorInfo.authorId);
        com.kwad.sdk.utils.o.a(jSONObject, "kwaiId", authorInfo.kwaiId);
        com.kwad.sdk.utils.o.a(jSONObject, "authorName", authorInfo.authorName);
        com.kwad.sdk.utils.o.a(jSONObject, "rawAuthorName", authorInfo.rawAuthorName);
        com.kwad.sdk.utils.o.a(jSONObject, "authorIcon", authorInfo.authorIcon);
        com.kwad.sdk.utils.o.a(jSONObject, "authorGender", authorInfo.authorGender);
        com.kwad.sdk.utils.o.a(jSONObject, "authorText", authorInfo.authorText);
        com.kwad.sdk.utils.o.a(jSONObject, "authorIconGuide", authorInfo.authorIconGuide);
        return jSONObject;
    }
}
