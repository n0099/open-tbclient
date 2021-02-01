package com.yy.mediaframework.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.WindowManager;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes4.dex */
public class RotationVectorSensor implements SensorEventListener {
    private static final String RV_SENSOR = "[RotationVectorSensor]";
    private static boolean sIsTruncated = false;
    private Context mContext;
    private int mDeviceRotation;
    private final Object mMatrixLock = new Object();
    private boolean mIsRegistered = false;
    private boolean mIsSupport = false;
    private float[] mCamModelViewMatrix = new float[16];
    private float[] mMvpMatrix = new float[16];
    private float[] mTmpMatrix = new float[16];
    private float[] mResultMatrix = new float[16];
    private float[] sUIThreadTmp = new float[16];
    private float[] sTruncatedVector = new float[4];

    public RotationVectorSensor(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void registerSensor() {
        if (!this.mIsRegistered) {
            YMFLog.info(this, "[Util    ]", "registerSensor");
            SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(11);
            if (defaultSensor == null) {
                YMFLog.error(this, "[Util    ]", " RotationVectorSensor is not support!!!!");
                return;
            }
            sensorManager.registerListener(this, defaultSensor, 1);
            this.mIsRegistered = true;
            return;
        }
        YMFLog.info(this, "[Util    ]", "has registerSensor, not need...");
    }

    public void unregisterSensor() {
        if (this.mIsRegistered) {
            YMFLog.info(this, "[Util    ]", "unregisterSensor");
            ((SensorManager) this.mContext.getSystemService("sensor")).unregisterListener(this);
            this.mIsRegistered = false;
            return;
        }
        YMFLog.info(this, "[Util    ]", "has unregisterSensor, not need....");
    }

    public boolean isSensorSupport() {
        this.mIsSupport = ((SensorManager) this.mContext.getSystemService("sensor")).getDefaultSensor(11) != null;
        YMFLog.info(this, "[Util    ]", "isSensorSupport:" + this.mIsSupport);
        return this.mIsSupport;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Matrix.setIdentityM(this.mCamModelViewMatrix, 0);
        this.mDeviceRotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        if (sensorEvent.accuracy != 0) {
            switch (sensorEvent.sensor.getType()) {
                case 11:
                    sensorRotationVector2Matrix(sensorEvent, this.mDeviceRotation, this.mCamModelViewMatrix);
                    synchronized (this.mMatrixLock) {
                        System.arraycopy(this.mCamModelViewMatrix, 0, this.mTmpMatrix, 0, 16);
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public float[] getMvpMatrix() {
        synchronized (this.mMatrixLock) {
            System.arraycopy(this.mTmpMatrix, 0, this.mResultMatrix, 0, 16);
        }
        return this.mResultMatrix;
    }

    private void sensorRotationVector2Matrix(SensorEvent sensorEvent, int i, float[] fArr) {
        float[] fArr2;
        if (!sIsTruncated) {
            try {
                SensorManager.getRotationMatrixFromVector(this.sUIThreadTmp, sensorEvent.values);
            } catch (Exception e) {
                YMFLog.error(this, "[Util    ]", "maybe SamSung Android 4.3 bug , will truncate vector");
                sIsTruncated = true;
            }
        }
        if (sIsTruncated) {
            System.arraycopy(sensorEvent.values, 0, this.sTruncatedVector, 0, 4);
            SensorManager.getRotationMatrixFromVector(this.sUIThreadTmp, this.sTruncatedVector);
            fArr2 = this.sTruncatedVector;
        } else {
            fArr2 = sensorEvent.values;
        }
        try {
            switch (i) {
                case 0:
                case 2:
                    SensorManager.getRotationMatrixFromVector(fArr, fArr2);
                    break;
                case 1:
                    SensorManager.getRotationMatrixFromVector(this.sUIThreadTmp, fArr2);
                    SensorManager.remapCoordinateSystem(this.sUIThreadTmp, 2, 129, fArr);
                    break;
                case 3:
                    SensorManager.getRotationMatrixFromVector(this.sUIThreadTmp, fArr2);
                    SensorManager.remapCoordinateSystem(this.sUIThreadTmp, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, 1, fArr);
                    break;
            }
            Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
        } catch (Exception e2) {
            YMFLog.error(this, "[Util    ]", "getRotationMatrixFromVector exception:" + e2.toString());
        }
    }
}
