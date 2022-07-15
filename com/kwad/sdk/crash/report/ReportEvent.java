package com.kwad.sdk.crash.report;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.r;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ReportEvent implements com.kwad.sdk.core.b, Serializable {
    public static final long serialVersionUID = 8652448382850235426L;
    public long clientIncrementId;
    public long clientTimeStamp;
    public String sessionId;
    public StatPackage statPackage;
    public String timeZone;

    /* loaded from: classes5.dex */
    public static class CustomStatEvent implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = 5177557263564436342L;
        public String key;
        public String value;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.key = jSONObject.optString("key");
            this.value = jSONObject.optString("value");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            r.a(jSONObject, "key", this.key);
            r.a(jSONObject, "value", this.value);
            return jSONObject;
        }
    }

    /* loaded from: classes5.dex */
    public static class ExceptionEvent implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = 5177557263564436344L;
        public String flag;
        public String message;
        public int type;
        public UrlPackage urlPackage;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.message = jSONObject.optString("message");
            this.urlPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
            this.flag = jSONObject.optString("flag");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            r.a(jSONObject, "type", this.type);
            r.a(jSONObject, "message", this.message);
            r.a(jSONObject, "urlPackage", this.urlPackage);
            r.a(jSONObject, "flag", this.flag);
            return jSONObject;
        }
    }

    /* loaded from: classes5.dex */
    public static class StatPackage implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = -6225392281821567840L;
        public CustomStatEvent customStatEvent;
        public ExceptionEvent exceptionEvent;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.exceptionEvent.parseJson(jSONObject.optJSONObject("exceptionEvent"));
            this.customStatEvent.parseJson(jSONObject.optJSONObject("customStatEvent"));
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            r.a(jSONObject, "exceptionEvent", this.exceptionEvent);
            r.a(jSONObject, "customStatEvent", this.customStatEvent);
            return jSONObject;
        }
    }

    /* loaded from: classes5.dex */
    public static class UrlPackage implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = 2535768638193007414L;
        public String identity;
        public String page;
        public int pageType;
        public String params;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.page = jSONObject.optString("page");
            this.params = jSONObject.optString("params");
            this.identity = jSONObject.optString("identity");
            this.pageType = jSONObject.optInt("pageType");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            r.a(jSONObject, "page", this.page);
            r.a(jSONObject, "params", this.params);
            r.a(jSONObject, "identity", this.identity);
            r.a(jSONObject, "pageType", this.pageType);
            return jSONObject;
        }
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.clientTimeStamp = jSONObject.optLong("clientTimeStamp");
        this.clientIncrementId = jSONObject.optLong("clientIncrementId");
        this.sessionId = jSONObject.optString("sessionId");
        this.statPackage.parseJson(jSONObject.optJSONObject("statPackage"));
        this.timeZone = jSONObject.optString("timeZone");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.a(jSONObject, "clientTimeStamp", this.clientTimeStamp);
        r.a(jSONObject, "clientIncrementId", this.clientIncrementId);
        r.a(jSONObject, "sessionId", this.sessionId);
        r.a(jSONObject, "statPackage", this.statPackage);
        r.a(jSONObject, "timeZone", this.timeZone);
        return jSONObject;
    }
}
