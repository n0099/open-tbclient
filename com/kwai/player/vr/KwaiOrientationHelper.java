package com.kwai.player.vr;

import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class KwaiOrientationHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "KwaiOrientationHelper";
    public static final int UIDeviceOrientationFaceDown = 5;
    public static final int UIDeviceOrientationFaceUp = 4;
    public static final int UIDeviceOrientationLandscapeLeft = 2;
    public static final int UIDeviceOrientationLandscapeRight = 3;
    public static final int UIDeviceOrientationPortrait = 1;
    public static final int UIDeviceOrientationUnknown = 0;
    public static final float mNear = 0.7f;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] mCameraMatrix;
    public float[] mCurrentRotationPost;
    public int mDegrees;
    public float mDeltaX;
    public float mDeltaY;
    public int mDeviceorientation;
    public float mEyeX;
    public float mEyeY;
    public float mEyeZ;
    public float mLookX;
    public float mLookY;
    public float mLookZ;
    public float[] mMVPMatrix;
    public float[] mModelMatrix;
    public boolean mModelValidate;
    public float mNearScale;
    public float[] mOrientation;
    public boolean mPositionValidate;
    public float[] mProjectionMatrix;
    public boolean mProjectionValidate;
    public float mRatio;
    public int mRotation;
    public float[] mSensorMatrix;
    public float[] mStartFromSensorTransformation;
    public float[] mTempMatrix;
    public float[] mViewMatrix;
    public int mViewportHeight;
    public int mViewportWidth;
    public float[] mWorldRotationInvertMatrix;
    public float[] mWorldRotationMatrix;
    public boolean mWorldRotationMatrixInvalidate;
    public float mscale;
    public float threshold;

    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float mEyeX;
        public float mEyeY;
        public float mEyeZ;
        public float mLookX;
        public float mLookY;
        public float mNearScale;

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
            this.mEyeX = 0.0f;
            this.mEyeY = 0.0f;
            this.mEyeZ = 0.0f;
            this.mLookX = 0.0f;
            this.mLookY = 0.0f;
            this.mNearScale = 1.0f;
        }

        public KwaiOrientationHelper build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new KwaiOrientationHelper(this) : (KwaiOrientationHelper) invokeV.objValue;
        }

        public Builder setEyeX(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
                this.mEyeX = f2;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder setEyeY(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) {
                this.mEyeY = f2;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder setEyeZ(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
                this.mEyeZ = f2;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder setLookX(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f2)) == null) {
                this.mLookX = f2;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder setLookY(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
                this.mLookY = f2;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder setNearScale(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f2)) == null) {
                this.mNearScale = f2;
                return this;
            }
            return (Builder) invokeF.objValue;
        }
    }

    public KwaiOrientationHelper(Builder builder) {
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
        this.mViewMatrix = new float[16];
        this.mProjectionMatrix = new float[16];
        this.mMVPMatrix = new float[16];
        this.mWorldRotationMatrix = new float[16];
        this.mWorldRotationInvertMatrix = new float[16];
        this.mCurrentRotationPost = new float[16];
        this.mSensorMatrix = new float[16];
        this.mTempMatrix = new float[16];
        this.mCameraMatrix = new float[16];
        this.mModelMatrix = new float[16];
        this.mStartFromSensorTransformation = new float[3];
        this.mOrientation = new float[3];
        this.mscale = 0.5f;
        this.mEyeX = 0.0f;
        this.mEyeY = 0.0f;
        this.mEyeZ = 0.0f;
        this.mLookX = 0.0f;
        this.mLookY = 0.0f;
        this.mLookZ = -1.0f;
        this.mProjectionValidate = false;
        this.mPositionValidate = true;
        this.mModelValidate = true;
        this.mNearScale = 1.0f;
        this.mRatio = 1.5f;
        this.mViewportWidth = 0;
        this.mViewportHeight = 0;
        this.mRotation = 0;
        this.threshold = 40.0f;
        this.mDeviceorientation = 0;
        this.mWorldRotationMatrixInvalidate = true;
        this.mEyeX = builder.mEyeX;
        this.mEyeY = builder.mEyeY;
        this.mEyeZ = builder.mEyeZ;
        this.mLookX = builder.mLookX;
        this.mLookY = builder.mLookY;
        this.mNearScale = builder.mNearScale;
        initModel();
    }

    public static Builder builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
    }

    private void initModel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            Matrix.setIdentityM(this.mViewMatrix, 0);
            Matrix.setIdentityM(this.mViewMatrix, 0);
            Matrix.setIdentityM(this.mSensorMatrix, 0);
        }
    }

    private void updateCameraMatrix() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            Matrix.setIdentityM(this.mCameraMatrix, 0);
            Matrix.setLookAtM(this.mCameraMatrix, 0, this.mEyeX, this.mEyeY, this.mEyeZ, this.mLookX, this.mLookY, this.mLookZ, 0.0f, 1.0f, 0.0f);
        }
    }

    private void updateModelMatrix() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            Matrix.setIdentityM(this.mModelMatrix, 0);
            float[] fArr = this.mStartFromSensorTransformation;
            if (fArr != null) {
                Matrix.rotateM(this.mModelMatrix, 0, -fArr[0], 0.0f, 1.0f, 0.0f);
                Matrix.rotateM(this.mModelMatrix, 0, this.mStartFromSensorTransformation[2], 0.0f, 1.0f, 0.0f);
            }
            Matrix.rotateM(this.mModelMatrix, 0, 0.0f, 0.0f, 0.0f, 1.0f);
        }
    }

    private void updateProjectionIfNeed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) && this.mProjectionValidate) {
            updateProjection();
            this.mProjectionValidate = false;
        }
    }

    private void updateViewMatrixIfNeed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            boolean z = this.mWorldRotationMatrixInvalidate;
            if (this.mPositionValidate) {
                updateCameraMatrix();
                this.mPositionValidate = false;
            }
            if (this.mModelValidate) {
                updateModelMatrix();
                this.mModelValidate = false;
            }
            if (z) {
                updateWorldRotationMatrix();
                this.mWorldRotationMatrixInvalidate = false;
            }
            if (this.mPositionValidate || z) {
                Matrix.multiplyMM(this.mViewMatrix, 0, this.mCameraMatrix, 0, this.mWorldRotationMatrix, 0);
            }
            calDegrees();
        }
    }

    private void updateWorldRotationMatrix() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            Matrix.setIdentityM(this.mWorldRotationMatrix, 0);
            Matrix.rotateM(this.mWorldRotationMatrix, 0, -this.mDeltaY, 1.0f, 0.0f, 0.0f);
            Matrix.setIdentityM(this.mCurrentRotationPost, 0);
            Matrix.rotateM(this.mCurrentRotationPost, 0, -this.mDeltaX, 0.0f, 1.0f, 0.0f);
            Matrix.setIdentityM(this.mTempMatrix, 0);
            Matrix.multiplyMM(this.mTempMatrix, 0, this.mCurrentRotationPost, 0, this.mModelMatrix, 0);
            synchronized (this) {
                Matrix.multiplyMM(this.mCurrentRotationPost, 0, this.mSensorMatrix, 0, this.mTempMatrix, 0);
            }
            Matrix.multiplyMM(this.mTempMatrix, 0, this.mWorldRotationMatrix, 0, this.mCurrentRotationPost, 0);
            System.arraycopy(this.mTempMatrix, 0, this.mWorldRotationMatrix, 0, 16);
            if (Matrix.invertM(this.mWorldRotationInvertMatrix, 0, this.mWorldRotationMatrix, 0)) {
                return;
            }
            Matrix.setIdentityM(this.mWorldRotationInvertMatrix, 0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b3, code lost:
        if (r1 > 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00bc, code lost:
        if (r1 > 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c2, code lost:
        if (r1 > 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c4, code lost:
        r1 = 360 - r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c7, code lost:
        r1 = -r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void calDegrees() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MDQuaternion mDQuaternion = new MDQuaternion();
            SensorManager.getOrientation(this.mWorldRotationMatrix, this.mOrientation);
            mDQuaternion.fromMatrix(this.mWorldRotationMatrix);
            float pitch = mDQuaternion.getPitch();
            float yaw = mDQuaternion.getYaw();
            float roll = mDQuaternion.getRoll();
            int i2 = this.mDeviceorientation;
            if (isNearValueABS(0.0f, pitch) && isNearValueABS(0.0f, roll)) {
                i2 = 1;
            } else if ((isNearValue(-90.0f, pitch) && isNearValueABS(180.0f, roll)) || (isNearValue(-90.0f, pitch) && isNearValueABS(0.0f, roll))) {
                i2 = 4;
            } else if (isNearValue(90.0f, pitch) && isNearValueABS(180.0f, roll)) {
                i2 = 5;
            } else if (isNearValue(0.0f, pitch) && isNearValue(-90.0f, roll)) {
                i2 = 3;
            } else if (isNearValue(0.0f, pitch) && isNearValue(90.0f, roll)) {
                i2 = 2;
            }
            if (this.mDeviceorientation != i2) {
                this.mDeviceorientation = i2;
                Log.d(TAG, "mdevice orientation " + this.mDeviceorientation);
            }
            int i3 = (int) yaw;
            int i4 = this.mDeviceorientation;
            if (i4 != 1 && i4 != 2 && i4 != 3) {
                if (i4 == 4) {
                    if (isNearValue(0.0f, roll)) {
                    }
                    i3 = 180 - i3;
                } else if (i4 == 5) {
                    if (!isNearValue(0.0f, roll)) {
                    }
                    i3 = 180 - i3;
                }
            }
            this.mDegrees = i3 % 360;
        }
    }

    public float getDeltaX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDeltaX : invokeV.floatValue;
    }

    public float getDeltaY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDeltaY : invokeV.floatValue;
    }

    public float[] getMVPMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            updateProjectionIfNeed();
            updateViewMatrixIfNeed();
            Matrix.multiplyMM(this.mMVPMatrix, 0, this.mProjectionMatrix, 0, this.mViewMatrix, 0);
            return this.mMVPMatrix;
        }
        return (float[]) invokeV.objValue;
    }

    public float getNear() {
        InterceptResult invokeV;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float f3 = 0.7f;
            if (this.mRatio < 1.0f) {
                f2 = this.mNearScale * 0.7f;
                f3 = this.mscale;
            } else {
                f2 = this.mNearScale;
            }
            return f2 * f3;
        }
        return invokeV.floatValue;
    }

    public int getOrientaionDegrees() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mDegrees : invokeV.intValue;
    }

    public float[] getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mOrientation : (float[]) invokeV.objValue;
    }

    public float[] getProjectionMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mProjectionMatrix : (float[]) invokeV.objValue;
    }

    public float[] getViewMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mViewMatrix : (float[]) invokeV.objValue;
    }

    public int getViewportHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mViewportHeight : invokeV.intValue;
    }

    public int getViewportWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mViewportWidth : invokeV.intValue;
    }

    public float[] getWorldRotationInvert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mWorldRotationInvertMatrix : (float[]) invokeV.objValue;
    }

    public boolean isNearValue(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? Math.abs(f2 - f3) < this.threshold : invokeCommon.booleanValue;
    }

    public boolean isNearValueABS(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? isNearValue(Math.abs(f2), Math.abs(f3)) : invokeCommon.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mDeltaY = 0.0f;
            this.mDeltaX = 0.0f;
            Matrix.setIdentityM(this.mSensorMatrix, 0);
            this.mWorldRotationMatrixInvalidate = true;
        }
    }

    public void setDelta(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.mDeltaX = f2;
            this.mDeltaY = f3;
            this.mWorldRotationMatrixInvalidate = true;
        }
    }

    public void setNearScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.mNearScale = f2;
            this.mProjectionValidate = true;
        }
    }

    public void setRotation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mRotation = i2;
            Log.d(TAG, "KwaiOrientationHelper setRotation: " + this.mRotation);
            this.mProjectionValidate = true;
        }
    }

    public void setViewport(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i2, i3) == null) {
            this.mViewportWidth = i2;
            this.mViewportHeight = i3;
            this.mRatio = (i2 * 1.0f) / i3;
            this.mProjectionValidate = true;
            Log.d(TAG, "KwaiOrientationHelper setViewport width:" + i2 + " height:" + i3);
        }
    }

    public void updateProjection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            float f2 = this.mRatio;
            Matrix.frustumM(getProjectionMatrix(), 0, (-f2) / 2.0f, f2 / 2.0f, -0.5f, 0.5f, getNear(), 500.0f);
        }
    }

    public void updateSensorMatrix(float[] fArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, fArr) == null) || fArr == null || fArr.length != 16 || Float.isNaN(fArr[0]) || Float.isNaN(fArr[1])) {
            return;
        }
        synchronized (this) {
            System.arraycopy(fArr, 0, this.mSensorMatrix, 0, 16);
        }
        this.mWorldRotationMatrixInvalidate = true;
    }

    public boolean updateSensorOrigin(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, fArr)) == null) {
            synchronized (this) {
                this.mStartFromSensorTransformation = fArr;
                this.mModelValidate = true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
