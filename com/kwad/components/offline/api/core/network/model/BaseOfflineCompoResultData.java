package com.kwad.components.offline.api.core.network.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.EmptyResultData;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class BaseOfflineCompoResultData implements Serializable {
    public static final int CODE_RESULT_OK = 1;
    public static final long serialVersionUID = 7464537023322307192L;
    public String cookie;
    public String errorMsg;
    public String extra;
    public boolean hasAd;
    public long llsid;
    public BaseResultData mBaseResultData = new EmptyResultData();
    public int result;

    public boolean hasData() {
        return this.hasAd;
    }

    public boolean isDataEmpty() {
        return false;
    }

    public boolean isResultOk() {
        return this.result == 1;
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (this.mBaseResultData == null) {
            this.mBaseResultData = new EmptyResultData();
        }
        this.mBaseResultData.parseJson(jSONObject);
        BaseResultData baseResultData = this.mBaseResultData;
        this.llsid = baseResultData.llsid;
        this.result = baseResultData.result;
        this.hasAd = baseResultData.hasAd;
        this.errorMsg = baseResultData.errorMsg;
        this.extra = baseResultData.extra;
        this.cookie = baseResultData.cookie;
    }

    public JSONObject toJson() {
        BaseResultData baseResultData = this.mBaseResultData;
        return baseResultData == null ? new JSONObject() : baseResultData.toJson();
    }
}
