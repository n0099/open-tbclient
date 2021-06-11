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
import com.kwai.player.vr.KwaiVR;
import d.g.d.a.a.c;
import d.g.d.a.a.d;
import d.g.d.a.a.f;
import java.lang.reflect.Array;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class KwaiSensorHelper implements SensorEventListener {
    public static final String TAG = "KwaiSensorHelper";
    public static boolean mIsTruncated = false;
    public KwaiVR.IAdvanceSensorListener mAdvanceSensorListener;
    public c mDeviceSensorLooper;
    public d mHeadTracker;
    public boolean mIsOn;
    public int mRotation;
    public Sensor mSensor;
    public SensorManager mSensorManager;
    public float[] mStartFromSensorTransformation;
    public WindowManager windowManager;
    public static float[] mUIThreadTmp = new float[16];
    public static float[] mTruncatedVector = new float[4];
    public float[] mSensorMatrix = new float[16];
    public float[] mTmpMatrix = new float[16];
    public float[] mOrientation = new float[3];
    public boolean mRegistered = false;
    public Boolean mIsSupport = null;
    public boolean mUseInnerSensorListener = true;
    public int mSensorType = 1;
    public float[] mPhoneInWorldSpaceMatrix = new float[16];
    public final int mAvgCount = 5;
    public int mCount = 0;
    public int mStartIndex = 0;
    public float[][] mSensorArr = (float[][]) Array.newInstance(float.class, 5, 16);

    public KwaiSensorHelper(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.windowManager = windowManager;
        this.mRotation = windowManager.getDefaultDisplay().getRotation();
        turnOnInGL(context, this.mUseInnerSensorListener);
    }

    public void calSmoothSensor(float[] fArr) {
        float[] fArr2 = new float[16];
        for (int i2 = 0; i2 < 16; i2++) {
            this.mSensorArr[this.mStartIndex][i2] = fArr[i2];
        }
        int i3 = this.mStartIndex + 1;
        this.mStartIndex = i3;
        if (i3 == 5) {
            this.mStartIndex = i3 % 5;
        }
        int i4 = this.mCount;
        if (i4 < 5) {
            this.mCount = i4 + 1;
        }
        for (int i5 = 0; i5 < this.mCount; i5++) {
            for (int i6 = 0; i6 < 16; i6++) {
                fArr2[i6] = fArr2[i6] + this.mSensorArr[i5][i6];
            }
        }
        for (int i7 = 0; i7 < 16; i7++) {
            fArr[i7] = fArr2[i7] / this.mCount;
        }
    }

    public boolean isSupport(Context context) {
        if (this.mIsSupport == null) {
            this.mIsSupport = Boolean.valueOf(((SensorManager) context.getSystemService("sensor")).getDefaultSensor(15) != null);
        }
        return this.mIsSupport.booleanValue();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
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
            KwaiVR.IAdvanceSensorListener iAdvanceSensorListener = this.mAdvanceSensorListener;
            if (iAdvanceSensorListener != null) {
                iAdvanceSensorListener.OnRotation(rotation);
            }
        }
        if (type == 1 || type == 2 || type == 4) {
            Matrix.setIdentityM(this.mTmpMatrix, 0);
            this.mHeadTracker.c(this.mTmpMatrix, 0);
            calSmoothSensor(this.mTmpMatrix);
            remapHeadTrackerCoordinateSystem(this.mRotation, this.mTmpMatrix);
            KwaiVR.IAdvanceSensorListener iAdvanceSensorListener2 = this.mAdvanceSensorListener;
            if (iAdvanceSensorListener2 != null) {
                iAdvanceSensorListener2.onSensorMatrix(this.mTmpMatrix);
            }
        } else if (type == 11 || type == 15) {
            sensorRotationVector2Matrix(sensorEvent, this.mRotation, this.mSensorMatrix);
            System.arraycopy(this.mSensorMatrix, 0, this.mTmpMatrix, 0, 16);
            SensorManager.getRotationMatrixFromVector(this.mPhoneInWorldSpaceMatrix, sensorEvent.values);
            if (this.mStartFromSensorTransformation == null) {
                float[] orientation = SensorManager.getOrientation(this.mPhoneInWorldSpaceMatrix, new float[3]);
                this.mStartFromSensorTransformation = new float[3];
                for (int i2 = 0; i2 < 3; i2++) {
                    this.mStartFromSensorTransformation[i2] = (float) Math.toDegrees(orientation[i2]);
                }
                Log.d(TAG, "calculateOrientation: mStartFromSensorTransformation " + Arrays.toString(this.mStartFromSensorTransformation));
                KwaiVR.IAdvanceSensorListener iAdvanceSensorListener3 = this.mAdvanceSensorListener;
                if (iAdvanceSensorListener3 != null) {
                    iAdvanceSensorListener3.onStartOrientation(this.mStartFromSensorTransformation);
                }
            }
            KwaiVR.IAdvanceSensorListener iAdvanceSensorListener4 = this.mAdvanceSensorListener;
            if (iAdvanceSensorListener4 != null) {
                iAdvanceSensorListener4.onSensorMatrix(this.mSensorMatrix);
            }
        }
    }

    public boolean registerSensor(Context context) {
        if (this.mRegistered) {
            return true;
        }
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.mSensorManager = sensorManager;
        if (this.mSensorType == 1) {
            if (this.mDeviceSensorLooper == null) {
                this.mDeviceSensorLooper = new c(this.mSensorManager, 1);
            }
            if (this.mHeadTracker == null) {
                this.mHeadTracker = new d(this.mDeviceSensorLooper, new f(), ((WindowManager) context.getSystemService("window")).getDefaultDisplay());
            }
            this.mDeviceSensorLooper.b(this);
            this.mHeadTracker.a();
            this.mRegistered = true;
        } else {
            Sensor defaultSensor = sensorManager.getDefaultSensor(15);
            this.mSensor = defaultSensor;
            if (defaultSensor == null) {
                Log.e(TAG, "TYPE_GAME_ROTATION_VECTOR sensor not support!");
                return false;
            }
            Log.d(TAG, "registerSensor: " + this.mSensor.toString());
            this.mRegistered = this.mSensorManager.registerListener(this, this.mSensor, 1);
        }
        Log.d(TAG, "registerSensor out");
        return this.mRegistered;
    }

    public void remapHeadTrackerCoordinateSystem(int i2, float[] fArr) {
        if (i2 == 1) {
            Matrix.rotateM(fArr, 0, 90.0f, 0.0f, 1.0f, 0.0f);
        } else if (i2 != 3) {
        } else {
            Matrix.rotateM(fArr, 0, -90.0f, 0.0f, 1.0f, 0.0f);
        }
    }

    public void resetYaw() {
        this.mStartFromSensorTransformation = null;
    }

    public void sensorRotationVector2Matrix(SensorEvent sensorEvent, int i2, float[] fArr) {
        if (!mIsTruncated) {
            try {
                SensorManager.getRotationMatrixFromVector(mUIThreadTmp, sensorEvent.values);
            } catch (Exception unused) {
                Log.e(TAG, "maybe Samsung bug, will truncate vector");
                mIsTruncated = true;
            }
        }
        if (mIsTruncated) {
            System.arraycopy(sensorEvent.values, 0, mTruncatedVector, 0, 4);
            SensorManager.getRotationMatrixFromVector(mUIThreadTmp, mTruncatedVector);
        }
        float[] fArr2 = sensorEvent.values;
        if (i2 == 0) {
            SensorManager.getRotationMatrixFromVector(fArr, fArr2);
        } else if (i2 == 1) {
            SensorManager.getRotationMatrixFromVector(mUIThreadTmp, fArr2);
            SensorManager.remapCoordinateSystem(mUIThreadTmp, 2, 129, fArr);
        } else if (i2 == 2) {
            SensorManager.getRotationMatrixFromVector(mUIThreadTmp, fArr2);
            SensorManager.remapCoordinateSystem(mUIThreadTmp, 129, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, fArr);
        } else if (i2 == 3) {
            SensorManager.getRotationMatrixFromVector(mUIThreadTmp, fArr2);
            SensorManager.remapCoordinateSystem(mUIThreadTmp, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, 1, fArr);
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
        if (z) {
            registerSensor(context);
        }
    }

    public void unregisterSensor(Context context) {
        if (this.mRegistered) {
            if (this.mSensorType == 1) {
                this.mDeviceSensorLooper.a(this);
                this.mHeadTracker.d();
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
