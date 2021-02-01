package com.kwad.sdk.crash.report;

import androidx.annotation.Nullable;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ReportEvent implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = 8652448382850235426L;
    public long clientIncrementId;
    public long clientTimeStamp;
    public String sessionId;
    public StatPackage statPackage;
    public String timeZone;

    /* loaded from: classes3.dex */
    public static class ExceptionEvent implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 5177557263564436344L;
        public String flag;
        public String message;
        public int type;
        public UrlPackage urlPackage;

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.message = jSONObject.optString("message");
            this.urlPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
            this.flag = jSONObject.optString(FrsActivityConfig.FLAG);
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "type", this.type);
            o.a(jSONObject, "message", this.message);
            o.a(jSONObject, "urlPackage", this.urlPackage);
            o.a(jSONObject, FrsActivityConfig.FLAG, this.flag);
            return jSONObject;
        }
    }

    /* loaded from: classes3.dex */
    public static class StatPackage implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -6225392281821567840L;
        public ExceptionEvent exceptionEvent;

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.exceptionEvent.parseJson(jSONObject.optJSONObject("exceptionEvent"));
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "exceptionEvent", this.exceptionEvent);
            return jSONObject;
        }
    }

    /* loaded from: classes3.dex */
    public static class UrlPackage implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 2535768638193007414L;
        public String identity;
        public String page;
        public int pageType;
        public String params;

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.page = jSONObject.optString("page");
            this.params = jSONObject.optString("params");
            this.identity = jSONObject.optString("identity");
            this.pageType = jSONObject.optInt(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE);
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "page", this.page);
            o.a(jSONObject, "params", this.params);
            o.a(jSONObject, "identity", this.identity);
            o.a(jSONObject, InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, this.pageType);
            return jSONObject;
        }
    }

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
        o.a(jSONObject, "clientTimeStamp", this.clientTimeStamp);
        o.a(jSONObject, "clientIncrementId", this.clientIncrementId);
        o.a(jSONObject, "sessionId", this.sessionId);
        o.a(jSONObject, "statPackage", this.statPackage);
        o.a(jSONObject, "timeZone", this.timeZone);
        return jSONObject;
    }
}
