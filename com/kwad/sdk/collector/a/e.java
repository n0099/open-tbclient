package com.kwad.sdk.collector.a;

import android.hardware.SensorEvent;
import androidx.lifecycle.SavedStateHandle;
import com.kwad.sdk.utils.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f32700a;

    /* renamed from: b  reason: collision with root package name */
    public List<Float> f32701b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public long f32702c;

    public static e a(SensorEvent sensorEvent) {
        if (sensorEvent == null) {
            return null;
        }
        e eVar = new e();
        eVar.f32700a = sensorEvent.sensor.getType();
        eVar.f32702c = sensorEvent.timestamp;
        for (float f2 : sensorEvent.values) {
            eVar.f32701b.add(Float.valueOf(f2));
        }
        return eVar;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        o.a(jSONObject, SavedStateHandle.VALUES, this.f32701b);
    }
}
