package com.kwad.sdk.commercial;

import androidx.annotation.NonNull;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import com.kwai.adclient.kscommerciallogger.model.d;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {
    public d anC;
    public String category;
    public String eventId;
    public JSONObject msg;
    public String primaryKey;
    public String tag;
    public double anx = 0.01d;
    public double any = 1.0d;
    public double anz = 0.001d;
    public BusinessType anA = BusinessType.OTHER;
    public SubBusinessType anB = SubBusinessType.OTHER;

    public static b zP() {
        return new b();
    }

    public final b L(String str, String str2) {
        this.eventId = str;
        this.primaryKey = str2;
        return this;
    }

    public final b a(BusinessType businessType) {
        this.anA = businessType;
        return this;
    }

    public final b cl(String str) {
        this.category = str;
        return this;
    }

    public final b cm(String str) {
        this.tag = str;
        return this;
    }

    @Deprecated
    public final b h(JSONObject jSONObject) {
        this.msg = jSONObject;
        return this;
    }

    public final b i(double d) {
        this.anx = d;
        return this;
    }

    public final b j(double d) {
        this.any = d;
        return this;
    }

    public final b k(double d) {
        this.anz = 0.001d;
        return this;
    }

    public final b u(com.kwad.sdk.commercial.d.a aVar) {
        this.msg = aVar.toJson();
        return this;
    }

    public final b a(SubBusinessType subBusinessType) {
        this.anB = subBusinessType;
        return this;
    }

    public final b a(d dVar) {
        this.anC = dVar;
        return this;
    }

    @NonNull
    public final String toString() {
        return "ReportItem{category='" + this.category + "', eventId='" + this.eventId + "', bizType='" + this.anA + "', primaryKey='" + this.primaryKey + "', msg=" + this.msg + '}';
    }
}
