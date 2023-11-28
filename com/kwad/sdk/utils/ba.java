package com.kwad.sdk.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes10.dex */
public class ba {
    public static volatile ba aOh;
    public SensorManager aOi;
    public final Map<String, a> aOj = new ConcurrentHashMap();
    public final Map<String, CopyOnWriteArraySet<SensorEventListener>> aOk = new ConcurrentHashMap();

    /* loaded from: classes10.dex */
    public interface b {
        void onFailed();
    }

    public static int dE(int i) {
        if (i != -3) {
            if (i != -2) {
                return i != -1 ? 3 : 0;
            }
            return 1;
        }
        return 2;
    }

    /* loaded from: classes10.dex */
    public static class a implements SensorEventListener {
        public final WeakReference<ba> XG;
        public final String key;

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public a(String str, ba baVar) {
            this.key = str;
            this.XG = new WeakReference<>(baVar);
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            ba baVar = this.XG.get();
            if (baVar == null) {
                return;
            }
            baVar.a(this.key, sensorEvent);
        }
    }

    @NonNull
    public static ba KZ() {
        if (aOh == null) {
            synchronized (ba.class) {
                if (aOh == null) {
                    aOh = new ba();
                }
            }
        }
        return aOh;
    }

    private SensorManager getSensorManager() {
        if (this.aOi == null) {
            this.aOi = (SensorManager) ServiceProvider.getContext().getSystemService("sensor");
        }
        return this.aOi;
    }

    public static String C(int i, int i2) {
        return i + "_" + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, SensorEvent sensorEvent) {
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.aOk.get(str);
        if (copyOnWriteArraySet != null) {
            Iterator<SensorEventListener> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                it.next().onSensorChanged(sensorEvent);
            }
        }
    }

    private void a(String str, int i, Sensor sensor) {
        getSensorManager().registerListener(gf(str), sensor, dE(i));
    }

    @Nullable
    private Sensor dD(int i) {
        if (getSensorManager() == null) {
            return null;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return getSensorManager().getDefaultSensor(9);
                }
                return getSensorManager().getDefaultSensor(1);
            }
            return getSensorManager().getDefaultSensor(4);
        }
        return getSensorManager().getDefaultSensor(10);
    }

    private void ge(String str) {
        a aVar = this.aOj.get(str);
        if (aVar != null) {
            this.aOj.remove(str);
            getSensorManager().unregisterListener(aVar);
        }
    }

    private a gf(String str) {
        a aVar = this.aOj.get(str);
        if (aVar == null) {
            a aVar2 = new a(str, this);
            this.aOj.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    public final synchronized void a(int i, int i2, SensorEventListener sensorEventListener, b bVar) {
        Sensor dD = dD(i);
        if (dD == null) {
            if (bVar != null) {
                bVar.onFailed();
            }
            return;
        }
        String C = C(i, i2);
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.aOk.get(C);
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        }
        copyOnWriteArraySet.add(sensorEventListener);
        if (copyOnWriteArraySet.size() == 1) {
            this.aOk.put(C, copyOnWriteArraySet);
            a(C, i2, dD);
        }
    }

    public final synchronized void a(SensorEventListener sensorEventListener) {
        for (Map.Entry<String, CopyOnWriteArraySet<SensorEventListener>> entry : this.aOk.entrySet()) {
            CopyOnWriteArraySet<SensorEventListener> value = entry.getValue();
            Iterator<SensorEventListener> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SensorEventListener next = it.next();
                if (next.equals(sensorEventListener)) {
                    value.remove(next);
                    break;
                }
            }
            if (value.size() == 0) {
                ge(entry.getKey());
            }
        }
    }
}
