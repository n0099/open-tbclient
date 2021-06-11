package com.kwai.player.vr;

import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.util.Log;
/* loaded from: classes7.dex */
public class KwaiOrientationHelper {
    public static final String TAG = "KwaiOrientationHelper";
    public static final int UIDeviceOrientationFaceDown = 5;
    public static final int UIDeviceOrientationFaceUp = 4;
    public static final int UIDeviceOrientationLandscapeLeft = 2;
    public static final int UIDeviceOrientationLandscapeRight = 3;
    public static final int UIDeviceOrientationPortrait = 1;
    public static final int UIDeviceOrientationUnknown = 0;
    public static final float mNear = 0.7f;
    public int mDegrees;
    public float mDeltaX;
    public float mDeltaY;
    public float mEyeX;
    public float mEyeY;
    public float mEyeZ;
    public float mLookX;
    public float mLookY;
    public float mNearScale;
    public float[] mViewMatrix = new float[16];
    public float[] mProjectionMatrix = new float[16];
    public float[] mMVPMatrix = new float[16];
    public float[] mWorldRotationMatrix = new float[16];
    public float[] mWorldRotationInvertMatrix = new float[16];
    public float[] mCurrentRotationPost = new float[16];
    public float[] mSensorMatrix = new float[16];
    public float[] mTempMatrix = new float[16];
    public float[] mCameraMatrix = new float[16];
    public float[] mModelMatrix = new float[16];
    public float[] mStartFromSensorTransformation = new float[3];
    public float[] mOrientation = new float[3];
    public float mscale = 0.5f;
    public float mLookZ = -1.0f;
    public boolean mProjectionValidate = false;
    public boolean mPositionValidate = true;
    public boolean mModelValidate = true;
    public float mRatio = 1.5f;
    public int mViewportWidth = 0;
    public int mViewportHeight = 0;
    public int mRotation = 0;
    public float threshold = 40.0f;
    public int mDeviceorientation = 0;
    public boolean mWorldRotationMatrixInvalidate = true;

    /* loaded from: classes7.dex */
    public static class Builder {
        public float mEyeX = 0.0f;
        public float mEyeY = 0.0f;
        public float mEyeZ = 0.0f;
        public float mLookX = 0.0f;
        public float mLookY = 0.0f;
        public float mNearScale = 1.0f;

        public KwaiOrientationHelper build() {
            return new KwaiOrientationHelper(this);
        }

        public Builder setEyeX(float f2) {
            this.mEyeX = f2;
            return this;
        }

        public Builder setEyeY(float f2) {
            this.mEyeY = f2;
            return this;
        }

        public Builder setEyeZ(float f2) {
            this.mEyeZ = f2;
            return this;
        }

        public Builder setLookX(float f2) {
            this.mLookX = f2;
            return this;
        }

        public Builder setLookY(float f2) {
            this.mLookY = f2;
            return this;
        }

        public Builder setNearScale(float f2) {
            this.mNearScale = f2;
            return this;
        }
    }

    public KwaiOrientationHelper(Builder builder) {
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
        float[] fArr = this.mStartFromSensorTransformation;
        if (fArr != null) {
            Matrix.rotateM(this.mModelMatrix, 0, -fArr[0], 0.0f, 1.0f, 0.0f);
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

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00af, code lost:
        if (r1 > 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b8, code lost:
        if (r1 > 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00be, code lost:
        if (r1 > 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c0, code lost:
        r1 = 360 - r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c3, code lost:
        r1 = -r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void calDegrees() {
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

    public float getNear() {
        float f2;
        float f3 = 0.7f;
        if (this.mRatio < 1.0f) {
            f2 = this.mNearScale * 0.7f;
            f3 = this.mscale;
        } else {
            f2 = this.mNearScale;
        }
        return f2 * f3;
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

    public boolean isNearValue(float f2, float f3) {
        return Math.abs(f2 - f3) < this.threshold;
    }

    public boolean isNearValueABS(float f2, float f3) {
        return isNearValue(Math.abs(f2), Math.abs(f3));
    }

    public void reset() {
        this.mDeltaY = 0.0f;
        this.mDeltaX = 0.0f;
        Matrix.setIdentityM(this.mSensorMatrix, 0);
        this.mWorldRotationMatrixInvalidate = true;
    }

    public void setDelta(float f2, float f3) {
        this.mDeltaX = f2;
        this.mDeltaY = f3;
        this.mWorldRotationMatrixInvalidate = true;
    }

    public void setNearScale(float f2) {
        this.mNearScale = f2;
        this.mProjectionValidate = true;
    }

    public void setRotation(int i2) {
        this.mRotation = i2;
        Log.d(TAG, "KwaiOrientationHelper setRotation: " + this.mRotation);
        this.mProjectionValidate = true;
    }

    public void setViewport(int i2, int i3) {
        this.mViewportWidth = i2;
        this.mViewportHeight = i3;
        this.mRatio = (i2 * 1.0f) / i3;
        this.mProjectionValidate = true;
        Log.d(TAG, "KwaiOrientationHelper setViewport width:" + i2 + " height:" + i3);
    }

    public void updateProjection() {
        float f2 = this.mRatio;
        Matrix.frustumM(getProjectionMatrix(), 0, (-f2) / 2.0f, f2 / 2.0f, -0.5f, 0.5f, getNear(), 500.0f);
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
