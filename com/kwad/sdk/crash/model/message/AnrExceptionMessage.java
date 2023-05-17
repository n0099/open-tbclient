package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.crash.offline.monitor.mem.message.OfflineMemExceptionMessage;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class AnrExceptionMessage extends ExceptionMessage {
    public static final long serialVersionUID = 2116476830162477947L;
    public String mReason = "";
    public String mMessageQueueDetail = "";
    public String mThreadDetail = "";
    public String mThreadStatus = "";
    public int mIndex = -1;

    public AnrExceptionMessage() {
        this.mExceptionType = 3;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    public final String getTypePrefix() {
        return "ANR_";
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.mReason = jSONObject.optString(OfflineMemExceptionMessage.REASON);
        this.mMessageQueueDetail = jSONObject.optString(OfflineMemExceptionMessage.MSG_QUEUE_DETAIL);
        this.mThreadDetail = jSONObject.optString(OfflineMemExceptionMessage.THREAD_DETAIL);
        this.mThreadStatus = jSONObject.optString(OfflineMemExceptionMessage.THREAD_STATUS);
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject json = super.toJson();
        r.putValue(json, OfflineMemExceptionMessage.REASON, this.mReason);
        r.putValue(json, OfflineMemExceptionMessage.MSG_QUEUE_DETAIL, this.mMessageQueueDetail);
        r.putValue(json, OfflineMemExceptionMessage.THREAD_DETAIL, this.mThreadDetail);
        r.putValue(json, OfflineMemExceptionMessage.THREAD_STATUS, this.mThreadStatus);
        return json;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    public final String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        try {
            if (!TextUtils.isEmpty(this.mReason)) {
                sb.append("ANR 原因:\n");
                sb.append(this.mReason);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mThreadStatus)) {
                sb.append("线程状态: \n");
                sb.append(this.mThreadStatus);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mThreadDetail)) {
                sb.append("线程状态: \n");
                sb.append(this.mThreadDetail);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mMessageQueueDetail)) {
                sb.append("消息队列: \n");
                sb.append(this.mMessageQueueDetail);
                sb.append("\n");
            }
        } catch (Exception e) {
            b.printStackTraceOnly(e);
        }
        return sb.substring(0);
    }
}
