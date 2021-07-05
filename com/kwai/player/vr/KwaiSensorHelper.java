package com.kwai.player.vr;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.util.Log;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.player.vr.KwaiVR;
import d.f.e.a.a.c;
import d.f.e.a.a.d;
import d.f.e.a.a.f;
import java.lang.reflect.Array;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class KwaiSensorHelper implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "KwaiSensorHelper";
    public static boolean mIsTruncated;
    public static float[] mTruncatedVector;
    public static float[] mUIThreadTmp;
    public transient /* synthetic */ FieldHolder $fh;
    public KwaiVR.IAdvanceSensorListener mAdvanceSensorListener;
    public final int mAvgCount;
    public int mCount;
    public c mDeviceSensorLooper;
    public d mHeadTracker;
    public boolean mIsOn;
    public Boolean mIsSupport;
    public float[] mOrientation;
    public float[] mPhoneInWorldSpaceMatrix;
    public boolean mRegistered;
    public int mRotation;
    public Sensor mSensor;
    public float[][] mSensorArr;
    public SensorManager mSensorManager;
    public float[] mSensorMatrix;
    public int mSensorType;
    public float[] mStartFromSensorTransformation;
    public int mStartIndex;
    public float[] mTmpMatrix;
    public boolean mUseInnerSensorListener;
    public WindowManager windowManager;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-290655015, "Lcom/kwai/player/vr/KwaiSensorHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-290655015, "Lcom/kwai/player/vr/KwaiSensorHelper;");
                return;
            }
        }
        mUIThreadTmp = new float[16];
        mTruncatedVector = new float[4];
    }

    public KwaiSensorHelper(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSensorMatrix = new float[16];
        this.mTmpMatrix = new float[16];
        this.mOrientation = new float[3];
        this.mRegistered = false;
        this.mIsSupport = null;
        this.mUseInnerSensorListener = true;
        this.mSensorType = 1;
        this.mPhoneInWorldSpaceMatrix = new float[16];
        this.mAvgCount = 5;
        this.mCount = 0;
        this.mStartIndex = 0;
        this.mSensorArr = (float[][]) Array.newInstance(float.class, 5, 16);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.windowManager = windowManager;
        this.mRotation = windowManager.getDefaultDisplay().getRotation();
        turnOnInGL(context, this.mUseInnerSensorListener);
    }

    public void calSmoothSensor(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fArr) == null) {
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
    }

    public boolean isSupport(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (this.mIsSupport == null) {
                this.mIsSupport = Boolean.valueOf(((SensorManager) context.getSystemService("sensor")).getDefaultSensor(15) != null);
            }
            return this.mIsSupport.booleanValue();
        }
        return invokeL.booleanValue;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, sensor, i2) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, sensorEvent) == null) && this.mIsOn && sensorEvent.accuracy != 0) {
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
    }

    public boolean registerSensor(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
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
        return invokeL.booleanValue;
    }

    public void remapHeadTrackerCoordinateSystem(int i2, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, fArr) == null) {
            if (i2 == 1) {
                Matrix.rotateM(fArr, 0, 90.0f, 0.0f, 1.0f, 0.0f);
            } else if (i2 != 3) {
            } else {
                Matrix.rotateM(fArr, 0, -90.0f, 0.0f, 1.0f, 0.0f);
            }
        }
    }

    public void resetYaw() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mStartFromSensorTransformation = null;
        }
    }

    public void sensorRotationVector2Matrix(SensorEvent sensorEvent, int i2, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048583, this, sensorEvent, i2, fArr) == null) {
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
    }

    public void setAdvanceSensorListener(KwaiVR.IAdvanceSensorListener iAdvanceSensorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iAdvanceSensorListener) == null) {
            this.mAdvanceSensorListener = iAdvanceSensorListener;
        }
    }

    public void turnOffInGL(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            this.mIsOn = false;
            if (this.mUseInnerSensorListener) {
                unregisterSensor(context);
            }
        }
    }

    public void turnOnInGL(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, context, z) == null) {
            this.mIsOn = true;
            this.mUseInnerSensorListener = z;
            if (z) {
                registerSensor(context);
            }
        }
    }

    public void unregisterSensor(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, context) == null) && this.mRegistered) {
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
