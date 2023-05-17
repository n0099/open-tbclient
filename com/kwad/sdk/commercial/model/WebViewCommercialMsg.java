package com.kwad.sdk.commercial.model;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.response.kwai.a;
import com.kwad.sdk.utils.r;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import com.qq.e.comm.constants.Constants;
import java.io.Serializable;
import org.json.JSONObject;
@KsJson
/* loaded from: classes9.dex */
public class WebViewCommercialMsg extends a implements b, Serializable {
    public static final long serialVersionUID = -1007322423487775751L;
    public BusinessType biz;
    public String category;
    public String eventId;
    public JSONObject extraParam;
    public JSONObject msg;
    public double rate;
    public SubBusinessType subBiz;
    public String tag;
    public com.kwai.adclient.kscommerciallogger.model.b type;

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has("subBiz")) {
            try {
                this.subBiz = SubBusinessType.valueOf(jSONObject.optString("subBiz"));
            } catch (Exception unused) {
                this.subBiz = SubBusinessType.OTHER;
            }
        }
        if (jSONObject.has(Constants.KEYS.BIZ)) {
            try {
                this.biz = BusinessType.valueOf(jSONObject.optString(Constants.KEYS.BIZ));
            } catch (Exception unused2) {
                this.biz = BusinessType.OTHER;
            }
        }
        if (jSONObject.has("type")) {
            try {
                this.type = new com.kwai.adclient.kscommerciallogger.model.b(jSONObject.optString("type"));
            } catch (Exception unused3) {
                this.type = new com.kwai.adclient.kscommerciallogger.model.b("OTHER");
            }
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        r.putValue(jSONObject, Constants.KEYS.BIZ, this.biz.value);
        r.putValue(jSONObject, "subBiz", this.subBiz.value);
        r.putValue(jSONObject, "type", this.type.getValue());
    }
}
