package com.kwad.sdk.crash.model.message;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes5.dex */
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
    public final void parseJson(@Nullable JSONObject jSONObject) {
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
        r.a(json, "mFingerprint", this.mFingerprint);
        r.a(json, "mRevision", this.mRevision);
        r.a(json, "mRegister", this.mRegister);
        r.a(json, "mSignal", this.mSignal);
        r.a(json, "mCode", this.mCode);
        r.a(json, "mManuallyKill", this.mManuallyKill);
        r.a(json, "mFaultAddr", this.mFaultAddr);
        r.a(json, "mAbortMsg", this.mAbortMsg);
        return json;
    }
}
