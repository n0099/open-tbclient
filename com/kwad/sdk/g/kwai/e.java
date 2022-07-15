package com.kwad.sdk.g.kwai;

import android.hardware.SensorEvent;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;
import com.kwad.sdk.utils.r;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class e extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int a = -1;
    public List<Float> b = new ArrayList();
    public long c = 0;

    public static e a(SensorEvent sensorEvent, long j) {
        if (sensorEvent == null) {
            return null;
        }
        e eVar = new e();
        eVar.a = sensorEvent.sensor.getType();
        eVar.c = j / 1000;
        for (float f : sensorEvent.values) {
            eVar.b.add(Float.valueOf(f));
        }
        return eVar;
    }

    private void a(e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.a = jSONObject.optInt("sensorType");
        eVar.c = jSONObject.optLong("timestamp");
        super.afterToJson(jSONObject);
    }

    public static JSONObject b(e eVar, JSONObject jSONObject) {
        r.a(jSONObject, "sensorType", eVar.a);
        r.a(jSONObject, "timestamp", eVar.c);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public final void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        r.a(jSONObject, SavedStateHandle.VALUES, this.b);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
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
