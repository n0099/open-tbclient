package com.kwai.player.vr;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.util.Log;
import android.view.WindowManager;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.google.b.a.a.b;
import com.google.b.a.a.c;
import com.google.b.a.a.e;
import com.kwai.player.vr.KwaiVR;
import java.lang.reflect.Array;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class KwaiSensorHelper implements SensorEventListener {
    private static final String TAG = "KwaiSensorHelper";
    private KwaiVR.IAdvanceSensorListener mAdvanceSensorListener;
    private b mDeviceSensorLooper;
    private c mHeadTracker;
    private boolean mIsOn;
    private int mRotation;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private float[] mStartFromSensorTransformation;
    private WindowManager windowManager;
    private static boolean mIsTruncated = false;
    private static float[] mUIThreadTmp = new float[16];
    private static float[] mTruncatedVector = new float[4];
    private float[] mSensorMatrix = new float[16];
    private float[] mTmpMatrix = new float[16];
    private float[] mOrientation = new float[3];
    private boolean mRegistered = false;
    private Boolean mIsSupport = null;
    private boolean mUseInnerSensorListener = true;
    private int mSensorType = 1;
    private float[] mPhoneInWorldSpaceMatrix = new float[16];
    private final int mAvgCount = 5;
    private int mCount = 0;
    private int mStartIndex = 0;
    private float[][] mSensorArr = (float[][]) Array.newInstance(Float.TYPE, 5, 16);

    public KwaiSensorHelper(Context context) {
        this.windowManager = (WindowManager) context.getSystemService("window");
        this.mRotation = this.windowManager.getDefaultDisplay().getRotation();
        turnOnInGL(context, this.mUseInnerSensorListener);
    }

    public void calSmoothSensor(float[] fArr) {
        float[] fArr2 = new float[16];
        for (int i = 0; i < 16; i++) {
            this.mSensorArr[this.mStartIndex][i] = fArr[i];
        }
        this.mStartIndex++;
        if (this.mStartIndex == 5) {
            this.mStartIndex %= 5;
        }
        if (this.mCount < 5) {
            this.mCount++;
        }
        for (int i2 = 0; i2 < this.mCount; i2++) {
            for (int i3 = 0; i3 < 16; i3++) {
                fArr2[i3] = fArr2[i3] + this.mSensorArr[i2][i3];
            }
        }
        for (int i4 = 0; i4 < 16; i4++) {
            fArr[i4] = fArr2[i4] / this.mCount;
        }
    }

    public boolean isSupport(Context context) {
        if (this.mIsSupport == null) {
            this.mIsSupport = Boolean.valueOf(((SensorManager) context.getSystemService("sensor")).getDefaultSensor(15) != null);
        }
        return this.mIsSupport.booleanValue();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!this.mIsOn || sensorEvent.accuracy == 0) {
            return;
        }
        int type = sensorEvent.sensor.getType();
        int rotation = this.windowManager.getDefaultDisplay().getRotation();
        if (rotation != this.mRotation) {
            this.mRotation = rotation;
            if (this.mAdvanceSensorListener != null) {
                this.mAdvanceSensorListener.OnRotation(this.mRotation);
            }
        }
        switch (type) {
            case 1:
            case 2:
            case 4:
                Matrix.setIdentityM(this.mTmpMatrix, 0);
                this.mHeadTracker.a(this.mTmpMatrix, 0);
                calSmoothSensor(this.mTmpMatrix);
                remapHeadTrackerCoordinateSystem(this.mRotation, this.mTmpMatrix);
                if (this.mAdvanceSensorListener != null) {
                    this.mAdvanceSensorListener.onSensorMatrix(this.mTmpMatrix);
                    return;
                }
                return;
            case 11:
            case 15:
                sensorRotationVector2Matrix(sensorEvent, this.mRotation, this.mSensorMatrix);
                System.arraycopy(this.mSensorMatrix, 0, this.mTmpMatrix, 0, 16);
                SensorManager.getRotationMatrixFromVector(this.mPhoneInWorldSpaceMatrix, sensorEvent.values);
                if (this.mStartFromSensorTransformation == null) {
                    float[] orientation = SensorManager.getOrientation(this.mPhoneInWorldSpaceMatrix, new float[3]);
                    this.mStartFromSensorTransformation = new float[3];
                    for (int i = 0; i < 3; i++) {
                        this.mStartFromSensorTransformation[i] = (float) Math.toDegrees(orientation[i]);
                    }
                    Log.d(TAG, "calculateOrientation: mStartFromSensorTransformation " + Arrays.toString(this.mStartFromSensorTransformation));
                    if (this.mAdvanceSensorListener != null) {
                        this.mAdvanceSensorListener.onStartOrientation(this.mStartFromSensorTransformation);
                    }
                }
                if (this.mAdvanceSensorListener != null) {
                    this.mAdvanceSensorListener.onSensorMatrix(this.mSensorMatrix);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected boolean registerSensor(Context context) {
        if (this.mRegistered) {
            return true;
        }
        this.mSensorManager = (SensorManager) context.getSystemService("sensor");
        if (this.mSensorType == 1) {
            if (this.mDeviceSensorLooper == null) {
                this.mDeviceSensorLooper = new b(this.mSensorManager, 1);
            }
            if (this.mHeadTracker == null) {
                this.mHeadTracker = new c(this.mDeviceSensorLooper, new e(), ((WindowManager) context.getSystemService("window")).getDefaultDisplay());
            }
            this.mDeviceSensorLooper.a(this);
            this.mHeadTracker.a();
            this.mRegistered = true;
        } else {
            this.mSensor = this.mSensorManager.getDefaultSensor(15);
            if (this.mSensor == null) {
                Log.e(TAG, "TYPE_GAME_ROTATION_VECTOR sensor not support!");
                return false;
            }
            Log.d(TAG, "registerSensor: " + this.mSensor.toString());
            this.mRegistered = this.mSensorManager.registerListener(this, this.mSensor, 1);
        }
        Log.d(TAG, "registerSensor out");
        return this.mRegistered;
    }

    void remapHeadTrackerCoordinateSystem(int i, float[] fArr) {
        switch (i) {
            case 0:
            case 2:
            default:
                return;
            case 1:
                Matrix.rotateM(fArr, 0, 90.0f, 0.0f, 1.0f, 0.0f);
                return;
            case 3:
                Matrix.rotateM(fArr, 0, -90.0f, 0.0f, 1.0f, 0.0f);
                return;
        }
    }

    public void resetYaw() {
        this.mStartFromSensorTransformation = null;
    }

    public void sensorRotationVector2Matrix(SensorEvent sensorEvent, int i, float[] fArr) {
        if (!mIsTruncated) {
            try {
                SensorManager.getRotationMatrixFromVector(mUIThreadTmp, sensorEvent.values);
            } catch (Exception e) {
                Log.e(TAG, "maybe Samsung bug, will truncate vector");
                mIsTruncated = true;
            }
        }
        if (mIsTruncated) {
            System.arraycopy(sensorEvent.values, 0, mTruncatedVector, 0, 4);
            SensorManager.getRotationMatrixFromVector(mUIThreadTmp, mTruncatedVector);
        }
        float[] fArr2 = sensorEvent.values;
        switch (i) {
            case 0:
                SensorManager.getRotationMatrixFromVector(fArr, fArr2);
                break;
            case 1:
                SensorManager.getRotationMatrixFromVector(mUIThreadTmp, fArr2);
                SensorManager.remapCoordinateSystem(mUIThreadTmp, 2, 129, fArr);
                break;
            case 2:
                SensorManager.getRotationMatrixFromVector(mUIThreadTmp, fArr2);
                SensorManager.remapCoordinateSystem(mUIThreadTmp, 129, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, fArr);
                break;
            case 3:
                SensorManager.getRotationMatrixFromVector(mUIThreadTmp, fArr2);
                SensorManager.remapCoordinateSystem(mUIThreadTmp, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, 1, fArr);
                break;
        }
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    public void setAdvanceSensorListener(KwaiVR.IAdvanceSensorListener iAdvanceSensorListener) {
        this.mAdvanceSensorListener = iAdvanceSensorListener;
    }

    public void turnOffInGL(Context context) {
        this.mIsOn = false;
        if (this.mUseInnerSensorListener) {
            unregisterSensor(context);
        }
    }

    public void turnOnInGL(Context context, boolean z) {
        this.mIsOn = true;
        this.mUseInnerSensorListener = z;
        if (this.mUseInnerSensorListener) {
            registerSensor(context);
        }
    }

    protected void unregisterSensor(Context context) {
        if (this.mRegistered) {
            if (this.mSensorType == 1) {
                this.mDeviceSensorLooper.b(this);
                this.mHeadTracker.b();
                this.mHeadTracker = null;
            } else {
                this.mSensorManager.unregisterListener(this);
                this.mSensor = null;
            }
            this.mSensorManager = null;
            this.mRegistered = false;
            Log.d(TAG, "unregisterSensor out");
        }
    }
}
