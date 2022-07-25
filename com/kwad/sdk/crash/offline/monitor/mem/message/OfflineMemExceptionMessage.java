package com.kwad.sdk.crash.offline.monitor.mem.message;

import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class OfflineMemExceptionMessage extends ExceptionMessage {
    public static final String MSG_QUEUE_DETAIL = "mMessageQueueDetail";
    public static final String REASON = "mReason";
    public static final String TAG = "OfflineMemExceptionMessage";
    public static final String THREAD_DETAIL = "mThreadDetail";
    public static final String THREAD_STATUS = "mThreadStatus";
    public static final long serialVersionUID = 2116476830162477948L;
    public String mReason = "";
    public String mMessageQueueDetail = "";
    public String mThreadDetail = "";
    public String mThreadStatus = "";

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    public String getTypePrefix() {
        return "offline_mem_";
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.mReason = jSONObject.optString(REASON);
        this.mMessageQueueDetail = jSONObject.optString(MSG_QUEUE_DETAIL);
        this.mThreadDetail = jSONObject.optString(THREAD_DETAIL);
        this.mThreadStatus = jSONObject.optString(THREAD_STATUS);
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        r.putValue(json, REASON, this.mReason);
        r.putValue(json, MSG_QUEUE_DETAIL, this.mMessageQueueDetail);
        r.putValue(json, THREAD_DETAIL, this.mThreadDetail);
        r.putValue(json, THREAD_STATUS, this.mThreadStatus);
        return json;
    }
}
