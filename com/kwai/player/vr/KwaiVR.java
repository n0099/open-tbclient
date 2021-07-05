package com.kwai.player.vr;

import android.content.Context;
import android.hardware.SensorEvent;
import android.util.Log;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class KwaiVR {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INTERACTIVE_MODE_MOTION = 0;
    public static final int INTERACTIVE_MODE_MOTION_WITH_TOUCH = 2;
    public static final int INTERACTIVE_MODE_TOUCH = 1;
    public static final int STEREO_TYPE_NON = 0;
    public static final int STEREO_TYPE_SPHERE = 1;
    public static final String TAG = "KwaiVR";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public KwaiGestureHelper mGestureHelper;
    public int mInteractiveMode;
    public boolean mInteractiveValid;
    public KwaiOrientationHelper mKwaiOrientationHelper;
    public KwaiPlayerStereoMesh mKwaiPlayerStereoMesh;
    public boolean mPinchEnabled;
    public KwaiSensorHelper mSensorHelper;
    public int mStereoType;

    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public int mInteractiveMode;
        public boolean mPinchEnabled;
        public int mStereoType;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPinchEnabled = false;
            this.mInteractiveMode = 2;
            this.mStereoType = 1;
        }

        public KwaiVR build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new KwaiVR(this) : (KwaiVR) invokeV.objValue;
        }

        public Builder setContext(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                this.mContext = context;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setInteractive(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.mInteractiveMode = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setPinchEnabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.mPinchEnabled = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setStereoType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.mStereoType = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface IAdvanceGestureListener {
        void onDrag(float f2, float f3);

        void onPinch(float f2);
    }

    /* loaded from: classes7.dex */
    public interface IAdvanceSensorListener {
        void OnRotation(int i2);

        void onSensorMatrix(float[] fArr);

        boolean onStartOrientation(float[] fArr);
    }

    public KwaiVR(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mInteractiveMode = 0;
        this.mStereoType = 1;
        this.mInteractiveValid = false;
        this.mContext = builder.mContext;
        this.mInteractiveMode = builder.mInteractiveMode;
        this.mPinchEnabled = builder.mPinchEnabled;
        this.mStereoType = builder.mStereoType;
        this.mKwaiOrientationHelper = KwaiOrientationHelper.builder().build();
        this.mKwaiPlayerStereoMesh = new KwaiPlayerStereoMesh(this.mStereoType);
        setUp();
    }

    public static Builder builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
    }

    private void setGestureEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            KwaiGestureHelper kwaiGestureHelper = this.mGestureHelper;
            if (kwaiGestureHelper != null) {
                kwaiGestureHelper.setGestureEnabled(z);
            }
            this.mGestureHelper.setPinchEnabled(this.mPinchEnabled);
        }
    }

    private void setSensorEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65540, this, z) == null) {
            KwaiSensorHelper kwaiSensorHelper = this.mSensorHelper;
            if (kwaiSensorHelper != null && z) {
                kwaiSensorHelper.turnOnInGL(this.mContext, true);
                return;
            }
            KwaiSensorHelper kwaiSensorHelper2 = this.mSensorHelper;
            if (kwaiSensorHelper2 != null) {
                kwaiSensorHelper2.turnOffInGL(this.mContext);
            }
        }
    }

    public int getInteractiveMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mInteractiveMode : invokeV.intValue;
    }

    public KwaiMesh getKwaiMesh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            KwaiPlayerStereoMesh kwaiPlayerStereoMesh = this.mKwaiPlayerStereoMesh;
            if (kwaiPlayerStereoMesh != null) {
                return kwaiPlayerStereoMesh.getKwaiMesh();
            }
            return null;
        }
        return (KwaiMesh) invokeV.objValue;
    }

    public float[] getMVPMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            KwaiOrientationHelper kwaiOrientationHelper = this.mKwaiOrientationHelper;
            if (kwaiOrientationHelper != null) {
                return kwaiOrientationHelper.getMVPMatrix();
            }
            return null;
        }
        return (float[]) invokeV.objValue;
    }

    public int getOrientaionDegrees() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            KwaiOrientationHelper kwaiOrientationHelper = this.mKwaiOrientationHelper;
            if (kwaiOrientationHelper != null) {
                kwaiOrientationHelper.getOrientaionDegrees();
                return 0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public float[] getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            KwaiOrientationHelper kwaiOrientationHelper = this.mKwaiOrientationHelper;
            if (kwaiOrientationHelper != null) {
                return kwaiOrientationHelper.getOrientation();
            }
            return null;
        }
        return (float[]) invokeV.objValue;
    }

    public void handleSensorEvent(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sensorEvent) == null) {
            if (!this.mInteractiveValid) {
                Log.d(TAG, "handleSensorEvent: mInteractive is not Valid");
                return;
            }
            KwaiSensorHelper kwaiSensorHelper = this.mSensorHelper;
            if (kwaiSensorHelper != null) {
                kwaiSensorHelper.onSensorChanged(sensorEvent);
            } else {
                Log.d(TAG, "handleSensorEvent: mSensorHelper nil");
            }
        }
    }

    public boolean handleTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (this.mInteractiveValid) {
                KwaiGestureHelper kwaiGestureHelper = this.mGestureHelper;
                if (kwaiGestureHelper != null) {
                    return kwaiGestureHelper.handleTouchEvent(motionEvent);
                }
                str = "handleTouchEvent: mGestureHelper nil";
            } else {
                str = "handleTouchEvent: mInteractive is not Valid";
            }
            Log.d(TAG, str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void initGeusture() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            KwaiGestureHelper kwaiGestureHelper = new KwaiGestureHelper(this.mContext);
            this.mGestureHelper = kwaiGestureHelper;
            if (kwaiGestureHelper != null) {
                kwaiGestureHelper.setAdvanceGestureListener(new IAdvanceGestureListener(this) { // from class: com.kwai.player.vr.KwaiVR.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ KwaiVR this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.kwai.player.vr.KwaiVR.IAdvanceGestureListener
                    public void onDrag(float f2, float f3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                            this.this$0.mKwaiOrientationHelper.setDelta(f2, f3);
                        }
                    }

                    @Override // com.kwai.player.vr.KwaiVR.IAdvanceGestureListener
                    public void onPinch(float f2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                            this.this$0.mKwaiOrientationHelper.setNearScale(f2);
                        }
                    }
                });
            }
        }
    }

    public void initSensor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            KwaiSensorHelper kwaiSensorHelper = new KwaiSensorHelper(this.mContext);
            this.mSensorHelper = kwaiSensorHelper;
            if (kwaiSensorHelper != null) {
                kwaiSensorHelper.setAdvanceSensorListener(new IAdvanceSensorListener(this) { // from class: com.kwai.player.vr.KwaiVR.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ KwaiVR this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.kwai.player.vr.KwaiVR.IAdvanceSensorListener
                    public void OnRotation(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.this$0.mKwaiOrientationHelper.setRotation(i2);
                        }
                    }

                    @Override // com.kwai.player.vr.KwaiVR.IAdvanceSensorListener
                    public void onSensorMatrix(float[] fArr) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fArr) == null) {
                            this.this$0.mKwaiOrientationHelper.updateSensorMatrix(fArr);
                        }
                    }

                    @Override // com.kwai.player.vr.KwaiVR.IAdvanceSensorListener
                    public boolean onStartOrientation(float[] fArr) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, fArr)) == null) ? this.this$0.mKwaiOrientationHelper.updateSensorOrigin(fArr) : invokeL.booleanValue;
                    }
                });
            }
        }
    }

    public boolean isSupport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mStereoType == 1 : invokeV.booleanValue;
    }

    public void recenterOrientation() {
        KwaiSensorHelper kwaiSensorHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (kwaiSensorHelper = this.mSensorHelper) == null) {
            return;
        }
        kwaiSensorHelper.resetYaw();
    }

    public void registerSensorEvent() {
        KwaiSensorHelper kwaiSensorHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (kwaiSensorHelper = this.mSensorHelper) == null) {
            return;
        }
        kwaiSensorHelper.turnOnInGL(this.mContext, true);
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            KwaiGestureHelper kwaiGestureHelper = this.mGestureHelper;
            if (kwaiGestureHelper != null) {
                kwaiGestureHelper.setGestureEnabled(false);
                this.mGestureHelper = null;
            }
            KwaiSensorHelper kwaiSensorHelper = this.mSensorHelper;
            if (kwaiSensorHelper != null) {
                kwaiSensorHelper.turnOffInGL(this.mContext);
                this.mSensorHelper = null;
            }
        }
    }

    public void resetGesture() {
        KwaiGestureHelper kwaiGestureHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (kwaiGestureHelper = this.mGestureHelper) == null) {
            return;
        }
        kwaiGestureHelper.reset();
    }

    public void setInteractiveMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            Log.d(TAG, "setInteractiveMode: " + i2);
            this.mInteractiveMode = i2;
            if (i2 == 0) {
                setGestureEnabled(false);
            } else if (i2 == 1) {
                setGestureEnabled(true);
                setSensorEnabled(false);
                return;
            } else if (i2 != 2) {
                return;
            } else {
                setGestureEnabled(true);
            }
            setSensorEnabled(true);
        }
    }

    public void setInteractiveValid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.mInteractiveValid = true;
            Log.d(TAG, "set interactive valid");
        }
    }

    public void setPinchEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.mPinchEnabled = z;
            this.mGestureHelper.setPinchEnabled(z);
        }
    }

    public void setUp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            initGeusture();
            initSensor();
            setInteractiveMode(this.mInteractiveMode);
        }
    }

    public void setViewport(int i2, int i3) {
        KwaiOrientationHelper kwaiOrientationHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048594, this, i2, i3) == null) || (kwaiOrientationHelper = this.mKwaiOrientationHelper) == null) {
            return;
        }
        kwaiOrientationHelper.setViewport(i2, i3);
    }

    public void unRegisterSensorEvent() {
        KwaiSensorHelper kwaiSensorHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (kwaiSensorHelper = this.mSensorHelper) == null) {
            return;
        }
        kwaiSensorHelper.turnOffInGL(this.mContext);
    }
}
