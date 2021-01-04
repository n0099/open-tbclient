package com.kwai.player.vr;

import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.util.Log;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
/* loaded from: classes5.dex */
public class KwaiOrientationHelper {
    private static final String TAG = "KwaiOrientationHelper";
    public static final int UIDeviceOrientationFaceDown = 5;
    public static final int UIDeviceOrientationFaceUp = 4;
    public static final int UIDeviceOrientationLandscapeLeft = 2;
    public static final int UIDeviceOrientationLandscapeRight = 3;
    public static final int UIDeviceOrientationPortrait = 1;
    public static final int UIDeviceOrientationUnknown = 0;
    private static final float mNear = 0.7f;
    private int mDegrees;
    private float mDeltaX;
    private float mDeltaY;
    private float mEyeX;
    private float mEyeY;
    private float mEyeZ;
    private float mLookX;
    private float mLookY;
    private float mNearScale;
    private float[] mViewMatrix = new float[16];
    private float[] mProjectionMatrix = new float[16];
    private float[] mMVPMatrix = new float[16];
    private float[] mWorldRotationMatrix = new float[16];
    private float[] mWorldRotationInvertMatrix = new float[16];
    private float[] mCurrentRotationPost = new float[16];
    private float[] mSensorMatrix = new float[16];
    private float[] mTempMatrix = new float[16];
    private float[] mCameraMatrix = new float[16];
    private float[] mModelMatrix = new float[16];
    private float[] mStartFromSensorTransformation = new float[3];
    private float[] mOrientation = new float[3];
    private float mscale = 0.5f;
    private float mLookZ = -1.0f;
    private boolean mProjectionValidate = false;
    private boolean mPositionValidate = true;
    private boolean mModelValidate = true;
    private float mRatio = 1.5f;
    private int mViewportWidth = 0;
    private int mViewportHeight = 0;
    private int mRotation = 0;
    private float threshold = 40.0f;
    private int mDeviceorientation = 0;
    private boolean mWorldRotationMatrixInvalidate = true;

    /* loaded from: classes5.dex */
    public static class Builder {
        private float mEyeX = 0.0f;
        private float mEyeY = 0.0f;
        private float mEyeZ = 0.0f;
        private float mLookX = 0.0f;
        private float mLookY = 0.0f;
        private float mNearScale = 1.0f;

        public KwaiOrientationHelper build() {
            return new KwaiOrientationHelper(this);
        }

        public Builder setEyeX(float f) {
            this.mEyeX = f;
            return this;
        }

        public Builder setEyeY(float f) {
            this.mEyeY = f;
            return this;
        }

        public Builder setEyeZ(float f) {
            this.mEyeZ = f;
            return this;
        }

        public Builder setLookX(float f) {
            this.mLookX = f;
            return this;
        }

        public Builder setLookY(float f) {
            this.mLookY = f;
            return this;
        }

        public Builder setNearScale(float f) {
            this.mNearScale = f;
            return this;
        }
    }

    protected KwaiOrientationHelper(Builder builder) {
        this.mEyeX = 0.0f;
        this.mEyeY = 0.0f;
        this.mEyeZ = 0.0f;
        this.mLookX = 0.0f;
        this.mLookY = 0.0f;
        this.mNearScale = 1.0f;
        this.mEyeX = builder.mEyeX;
        this.mEyeY = builder.mEyeY;
        this.mEyeZ = builder.mEyeZ;
        this.mLookX = builder.mLookX;
        this.mLookY = builder.mLookY;
        this.mNearScale = builder.mNearScale;
        initModel();
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initModel() {
        Matrix.setIdentityM(this.mViewMatrix, 0);
        Matrix.setIdentityM(this.mViewMatrix, 0);
        Matrix.setIdentityM(this.mSensorMatrix, 0);
    }

    private void updateCameraMatrix() {
        Matrix.setIdentityM(this.mCameraMatrix, 0);
        Matrix.setLookAtM(this.mCameraMatrix, 0, this.mEyeX, this.mEyeY, this.mEyeZ, this.mLookX, this.mLookY, this.mLookZ, 0.0f, 1.0f, 0.0f);
    }

    private void updateModelMatrix() {
        Matrix.setIdentityM(this.mModelMatrix, 0);
        if (this.mStartFromSensorTransformation != null) {
            Matrix.rotateM(this.mModelMatrix, 0, -this.mStartFromSensorTransformation[0], 0.0f, 1.0f, 0.0f);
            Matrix.rotateM(this.mModelMatrix, 0, this.mStartFromSensorTransformation[2], 0.0f, 1.0f, 0.0f);
        }
        Matrix.rotateM(this.mModelMatrix, 0, 0.0f, 0.0f, 0.0f, 1.0f);
    }

    private void updateProjectionIfNeed() {
        if (this.mProjectionValidate) {
            updateProjection();
            this.mProjectionValidate = false;
        }
    }

    private void updateViewMatrixIfNeed() {
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

    private void updateWorldRotationMatrix() {
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

    public void calDegrees() {
        MDQuaternion mDQuaternion = new MDQuaternion();
        if (mDQuaternion == null) {
            return;
        }
        SensorManager.getOrientation(this.mWorldRotationMatrix, this.mOrientation);
        mDQuaternion.fromMatrix(this.mWorldRotationMatrix);
        float pitch = mDQuaternion.getPitch();
        float yaw = mDQuaternion.getYaw();
        float roll = mDQuaternion.getRoll();
        int i = this.mDeviceorientation;
        if (isNearValueABS(0.0f, pitch) && isNearValueABS(0.0f, roll)) {
            i = 1;
        } else if ((isNearValue(-90.0f, pitch) && isNearValueABS(180.0f, roll)) || (isNearValue(-90.0f, pitch) && isNearValueABS(0.0f, roll))) {
            i = 4;
        } else if (isNearValue(90.0f, pitch) && isNearValueABS(180.0f, roll)) {
            i = 5;
        } else if (isNearValue(0.0f, pitch) && isNearValue(-90.0f, roll)) {
            i = 3;
        } else if (isNearValue(0.0f, pitch) && isNearValue(90.0f, roll)) {
            i = 2;
        }
        if (this.mDeviceorientation != i) {
            this.mDeviceorientation = i;
            Log.d(TAG, "mdevice orientation " + this.mDeviceorientation);
        }
        int i2 = (int) yaw;
        switch (this.mDeviceorientation) {
            case 1:
            case 2:
            case 3:
                if (i2 <= 0) {
                    i2 = -i2;
                    break;
                } else {
                    i2 = 360 - i2;
                    break;
                }
            case 4:
                if (!isNearValue(0.0f, roll)) {
                    i2 = 180 - i2;
                    break;
                } else if (i2 <= 0) {
                    i2 = -i2;
                    break;
                } else {
                    i2 = 360 - i2;
                    break;
                }
            case 5:
                if (!isNearValue(0.0f, roll)) {
                    if (i2 <= 0) {
                        i2 = -i2;
                        break;
                    } else {
                        i2 = 360 - i2;
                        break;
                    }
                } else {
                    i2 = 180 - i2;
                    break;
                }
        }
        this.mDegrees = i2 % EncoderTextureDrawer.X264_WIDTH;
    }

    public float getDeltaX() {
        return this.mDeltaX;
    }

    public float getDeltaY() {
        return this.mDeltaY;
    }

    public float[] getMVPMatrix() {
        updateProjectionIfNeed();
        updateViewMatrixIfNeed();
        Matrix.multiplyMM(this.mMVPMatrix, 0, this.mProjectionMatrix, 0, this.mViewMatrix, 0);
        return this.mMVPMatrix;
    }

    protected float getNear() {
        return this.mRatio < 1.0f ? this.mNearScale * mNear * this.mscale : this.mNearScale * mNear;
    }

    public int getOrientaionDegrees() {
        return this.mDegrees;
    }

    public float[] getOrientation() {
        return this.mOrientation;
    }

    public float[] getProjectionMatrix() {
        return this.mProjectionMatrix;
    }

    public float[] getViewMatrix() {
        return this.mViewMatrix;
    }

    public int getViewportHeight() {
        return this.mViewportHeight;
    }

    public int getViewportWidth() {
        return this.mViewportWidth;
    }

    public float[] getWorldRotationInvert() {
        return this.mWorldRotationInvertMatrix;
    }

    public boolean isNearValue(float f, float f2) {
        return Math.abs(f - f2) < this.threshold;
    }

    public boolean isNearValueABS(float f, float f2) {
        return isNearValue(Math.abs(f), Math.abs(f2));
    }

    public void reset() {
        this.mDeltaY = 0.0f;
        this.mDeltaX = 0.0f;
        Matrix.setIdentityM(this.mSensorMatrix, 0);
        this.mWorldRotationMatrixInvalidate = true;
    }

    public void setDelta(float f, float f2) {
        this.mDeltaX = f;
        this.mDeltaY = f2;
        this.mWorldRotationMatrixInvalidate = true;
    }

    public void setNearScale(float f) {
        this.mNearScale = f;
        this.mProjectionValidate = true;
    }

    public void setRotation(int i) {
        this.mRotation = i;
        Log.d(TAG, "KwaiOrientationHelper setRotation: " + this.mRotation);
        this.mProjectionValidate = true;
    }

    public void setViewport(int i, int i2) {
        this.mViewportWidth = i;
        this.mViewportHeight = i2;
        this.mRatio = (this.mViewportWidth * 1.0f) / this.mViewportHeight;
        this.mProjectionValidate = true;
        Log.d(TAG, "KwaiOrientationHelper setViewport width:" + i + " height:" + i2);
    }

    protected void updateProjection() {
        Matrix.frustumM(getProjectionMatrix(), 0, (-this.mRatio) / 2.0f, this.mRatio / 2.0f, -0.5f, 0.5f, getNear(), 500.0f);
    }

    public void updateSensorMatrix(float[] fArr) {
        if (fArr == null || fArr.length != 16 || Float.isNaN(fArr[0]) || Float.isNaN(fArr[1])) {
            return;
        }
        synchronized (this) {
            System.arraycopy(fArr, 0, this.mSensorMatrix, 0, 16);
        }
        this.mWorldRotationMatrixInvalidate = true;
    }

    public boolean updateSensorOrigin(float[] fArr) {
        synchronized (this) {
            this.mStartFromSensorTransformation = fArr;
            this.mModelValidate = true;
        }
        return true;
    }
}
