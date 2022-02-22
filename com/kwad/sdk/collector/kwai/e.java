package com.kwad.sdk.collector.kwai;

import android.hardware.SensorEvent;
import androidx.lifecycle.SavedStateHandle;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int a = -1;

    /* renamed from: b  reason: collision with root package name */
    public List<Float> f55740b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public long f55741c = 0;

    public static e a(SensorEvent sensorEvent, long j2) {
        if (sensorEvent == null) {
            return null;
        }
        e eVar = new e();
        eVar.a = sensorEvent.sensor.getType();
        eVar.f55741c = j2 / 1000;
        for (float f2 : sensorEvent.values) {
            eVar.f55740b.add(Float.valueOf(f2));
        }
        return eVar;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        t.a(jSONObject, SavedStateHandle.VALUES, this.f55740b);
    }
}
