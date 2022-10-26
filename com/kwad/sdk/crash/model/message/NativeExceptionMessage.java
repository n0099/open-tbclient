package com.kwad.sdk.crash.model.message;

import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class NativeExceptionMessage extends ExceptionMessage {
    public static final long serialVersionUID = -7790706181005700630L;
    public String mFingerprint = "Unknown";
    public String mRevision = "Unknown";
    public String mRegister = "Unknown";
    public String mSignal = "Unknown";
    public String mCode = "Unknown";
    public String mManuallyKill = "Unknown";
    public String mFaultAddr = "Unknown";
    public String mAbortMsg = "";

    public NativeExceptionMessage() {
        this.mExceptionType = 4;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    public final String getTypePrefix() {
        return "NATIVE_";
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.mFingerprint = jSONObject.optString("mFingerprint");
        this.mRevision = jSONObject.optString("mRevision");
        this.mRegister = jSONObject.optString("mRegister");
        this.mSignal = jSONObject.optString("mSignal");
        this.mCode = jSONObject.optString("mCode");
        this.mManuallyKill = jSONObject.optString("mManuallyKill");
        this.mFaultAddr = jSONObject.optString("mFaultAddr");
        this.mAbortMsg = jSONObject.optString("mAbortMsg");
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject json = super.toJson();
        r.putValue(json, "mFingerprint", this.mFingerprint);
        r.putValue(json, "mRevision", this.mRevision);
        r.putValue(json, "mRegister", this.mRegister);
        r.putValue(json, "mSignal", this.mSignal);
        r.putValue(json, "mCode", this.mCode);
        r.putValue(json, "mManuallyKill", this.mManuallyKill);
        r.putValue(json, "mFaultAddr", this.mFaultAddr);
        r.putValue(json, "mAbortMsg", this.mAbortMsg);
        return json;
    }
}
