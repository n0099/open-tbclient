package com.kwad.components.core.webview.jshandler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;
import com.kwad.sdk.utils.ba;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class q implements SensorEventListener, com.kwad.sdk.core.webview.c.a {
    public Map<Integer, com.kwad.sdk.core.webview.c.c> VS = new ConcurrentHashMap();

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerSensorListener";
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.utils.ba.KZ().a(this);
    }

    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int VV;
        public ArrayList<Float> VW;
        public int accuracy;
        public long timestamp;
        public int type;

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null || jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.VV = jSONObject.optInt("interval");
            this.timestamp = jSONObject.optLong("timestamp");
            this.accuracy = jSONObject.optInt("accuracy");
            JSONArray optJSONArray = jSONObject.optJSONArray(SavedStateHandle.VALUES);
            ArrayList<Float> arrayList = new ArrayList<>();
            if (optJSONArray == null) {
                this.VW = arrayList;
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    Object obj = optJSONArray.get(i);
                    if (obj != null) {
                        arrayList.add((Float) obj);
                    }
                } catch (Throwable unused) {
                }
            }
            this.VW = arrayList;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            int i = this.type;
            if (i != 0) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "type", i);
            }
            int i2 = this.VV;
            if (i2 != 0) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "interval", i2);
            }
            long j = this.timestamp;
            if (j != 0) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "timestamp", j);
            }
            int i3 = this.accuracy;
            if (i3 != 0) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "accuracy", i3);
            }
            if (!this.VW.isEmpty()) {
                com.kwad.sdk.utils.t.putValue(jSONObject, SavedStateHandle.VALUES, this.VW);
            }
            return jSONObject;
        }
    }

    private void a(int i, int i2, final com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.utils.ba.KZ().a(i, i2, this, new ba.b() { // from class: com.kwad.components.core.webview.jshandler.q.1
            @Override // com.kwad.sdk.utils.ba.b
            public final void onFailed() {
                cVar.onError(-1, "sensor is not support");
            }
        });
    }

    private void a(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type != 4) {
            if (type == 10) {
                type = 1;
            }
        } else {
            type = 2;
        }
        com.kwad.sdk.core.webview.c.c cVar = this.VS.get(Integer.valueOf(type));
        if (cVar != null) {
            ArrayList<Float> arrayList = new ArrayList<>();
            int i = 0;
            while (true) {
                float[] fArr = sensorEvent.values;
                if (i < fArr.length) {
                    arrayList.add(Float.valueOf(fArr[i]));
                    i++;
                } else {
                    a aVar = new a();
                    aVar.VW = arrayList;
                    aVar.timestamp = sensorEvent.timestamp;
                    aVar.accuracy = sensorEvent.accuracy;
                    cVar.a(aVar);
                    return;
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (!TextUtils.isEmpty(str)) {
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.VS.put(Integer.valueOf(aVar.type), cVar);
            a(aVar.type, aVar.VV, cVar);
            return;
        }
        cVar.onError(-1, "data is empty");
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        a(sensorEvent);
    }
}
