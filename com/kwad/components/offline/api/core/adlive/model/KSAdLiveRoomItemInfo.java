package com.kwad.components.offline.api.core.adlive.model;

import androidx.transition.Transition;
import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class KSAdLiveRoomItemInfo extends BaseOfflineCompoJsonParse<KSAdLiveRoomItemInfo> implements Serializable {
    public static final long serialVersionUID = -6149616231567033413L;
    public String imageUrl;
    public String itemId;
    public String price;
    public String title;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(KSAdLiveRoomItemInfo kSAdLiveRoomItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdLiveRoomItemInfo.itemId = jSONObject.optString(Transition.MATCH_ITEM_ID_STR);
        if (jSONObject.opt(Transition.MATCH_ITEM_ID_STR) == JSONObject.NULL) {
            kSAdLiveRoomItemInfo.itemId = "";
        }
        kSAdLiveRoomItemInfo.imageUrl = jSONObject.optString("imageUrl");
        if (jSONObject.opt("imageUrl") == JSONObject.NULL) {
            kSAdLiveRoomItemInfo.imageUrl = "";
        }
        kSAdLiveRoomItemInfo.title = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            kSAdLiveRoomItemInfo.title = "";
        }
        kSAdLiveRoomItemInfo.price = jSONObject.optString("templateVersion");
        if (jSONObject.opt("price") == JSONObject.NULL) {
            kSAdLiveRoomItemInfo.price = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(KSAdLiveRoomItemInfo kSAdLiveRoomItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = kSAdLiveRoomItemInfo.itemId;
        if (str != null && !str.equals("")) {
            t.putValue(jSONObject, Transition.MATCH_ITEM_ID_STR, kSAdLiveRoomItemInfo.itemId);
        }
        String str2 = kSAdLiveRoomItemInfo.imageUrl;
        if (str2 != null && !str2.equals("")) {
            t.putValue(jSONObject, "imageUrl", kSAdLiveRoomItemInfo.imageUrl);
        }
        String str3 = kSAdLiveRoomItemInfo.title;
        if (str3 != null && !str3.equals("")) {
            t.putValue(jSONObject, "title", kSAdLiveRoomItemInfo.title);
        }
        String str4 = kSAdLiveRoomItemInfo.price;
        if (str4 != null && !str4.equals("")) {
            t.putValue(jSONObject, "price", kSAdLiveRoomItemInfo.price);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(KSAdLiveRoomItemInfo kSAdLiveRoomItemInfo) {
        return toJson(kSAdLiveRoomItemInfo, (JSONObject) null);
    }
}
