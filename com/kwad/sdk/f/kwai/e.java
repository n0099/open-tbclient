package com.kwad.sdk.f.kwai;

import android.hardware.SensorEvent;
import androidx.lifecycle.SavedStateHandle;
import com.kwad.sdk.utils.r;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class e extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int sensorType = -1;
    public List amD = new ArrayList();
    public long timestamp = 0;

    public static e a(SensorEvent sensorEvent, long j) {
        if (sensorEvent == null) {
            return null;
        }
        e eVar = new e();
        eVar.sensorType = sensorEvent.sensor.getType();
        eVar.timestamp = j / 1000;
        for (float f : sensorEvent.values) {
            eVar.amD.add(Float.valueOf(f));
        }
        return eVar;
    }

    private void a(e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.sensorType = jSONObject.optInt("sensorType");
        eVar.timestamp = jSONObject.optLong("timestamp");
        super.afterToJson(jSONObject);
    }

    public static JSONObject b(e eVar, JSONObject jSONObject) {
        r.putValue(jSONObject, "sensorType", eVar.sensorType);
        r.putValue(jSONObject, "timestamp", eVar.timestamp);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public final void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        r.putValue(jSONObject, SavedStateHandle.VALUES, this.amD);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject b = b(this, new JSONObject());
        afterToJson(b);
        return b;
    }
}
