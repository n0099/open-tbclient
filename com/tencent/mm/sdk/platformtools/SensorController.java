package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
/* loaded from: classes.dex */
public class SensorController extends BroadcastReceiver implements SensorEventListener {
    private static float aR = 4.2949673E9f;
    private static float aU = 0.5f;
    private SensorManager aS;
    private float aT;
    private SensorEventCallBack aV;
    private Sensor aW;
    private final boolean aX;
    private boolean aY = false;
    private boolean aZ = false;

    /* loaded from: classes.dex */
    public interface SensorEventCallBack {
        void onSensorEvent(boolean z);
    }

    public SensorController(Context context) {
        this.aS = (SensorManager) context.getSystemService("sensor");
        this.aW = this.aS.getDefaultSensor(8);
        this.aX = this.aW != null;
        this.aT = aU + 1.0f;
    }

    public boolean isSensorEnable() {
        return this.aX;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            int intExtra = intent.getIntExtra("state", 0);
            if (intExtra == 1) {
                this.aY = true;
            }
            if (intExtra == 0) {
                this.aY = false;
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.aY) {
            return;
        }
        float f = sensorEvent.values[0];
        switch (sensorEvent.sensor.getType()) {
            case 8:
                if (f < aR) {
                    aR = f;
                    aU = 0.5f + f;
                }
                if (this.aT < aU || f >= aU) {
                    if (this.aT <= aU && f > aU && this.aV != null) {
                        Log.v("MicroMsg.SensorController", "sensor event true");
                        this.aV.onSensorEvent(true);
                    }
                } else if (this.aV != null) {
                    Log.v("MicroMsg.SensorController", "sensor event false");
                    this.aV.onSensorEvent(false);
                }
                this.aT = f;
                return;
            default:
                return;
        }
    }

    public void removeSensorCallBack() {
        Log.v("MicroMsg.SensorController", "sensor callback removed");
        this.aS.unregisterListener(this, this.aW);
        this.aS.unregisterListener(this);
        this.aZ = false;
        this.aV = null;
    }

    public void setSensorCallBack(SensorEventCallBack sensorEventCallBack) {
        Log.v("MicroMsg.SensorController", "sensor callback set");
        if (!this.aZ) {
            this.aS.registerListener(this, this.aW, 2);
            this.aZ = true;
        }
        this.aV = sensorEventCallBack;
    }
}
