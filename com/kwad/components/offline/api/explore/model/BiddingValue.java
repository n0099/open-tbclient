package com.kwad.components.offline.api.explore.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class BiddingValue extends BaseOfflineCompoJsonParse<BiddingValue> implements Serializable {
    public static final long serialVersionUID = -6149616231567033423L;
    public double biddingRitCpm;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(BiddingValue biddingValue, JSONObject jSONObject) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(BiddingValue biddingValue) {
        return toJson(biddingValue, (JSONObject) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(BiddingValue biddingValue, JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        return jSONObject;
    }
}
