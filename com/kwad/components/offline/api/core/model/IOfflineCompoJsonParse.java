package com.kwad.components.offline.api.core.model;

import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface IOfflineCompoJsonParse {
    void parseJson(@Nullable JSONObject jSONObject);

    JSONObject toJson();
}
