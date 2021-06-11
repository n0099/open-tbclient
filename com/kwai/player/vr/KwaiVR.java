package com.kwai.player.vr;

import android.content.Context;
import android.hardware.SensorEvent;
import android.util.Log;
import android.view.MotionEvent;
/* loaded from: classes7.dex */
public class KwaiVR {
    public static final int INTERACTIVE_MODE_MOTION = 0;
    public static final int INTERACTIVE_MODE_MOTION_WITH_TOUCH = 2;
    public static final int INTERACTIVE_MODE_TOUCH = 1;
    public static final int STEREO_TYPE_NON = 0;
    public static final int STEREO_TYPE_SPHERE = 1;
    public static final String TAG = "KwaiVR";
    public Context mContext;
    public KwaiGestureHelper mGestureHelper;
    public int mInteractiveMode;
    public boolean mInteractiveValid = false;
    public KwaiOrientationHelper mKwaiOrientationHelper = KwaiOrientationHelper.builder().build();
    public KwaiPlayerStereoMesh mKwaiPlayerStereoMesh;
    public boolean mPinchEnabled;
    public KwaiSensorHelper mSensorHelper;
    public int mStereoType;

    /* loaded from: classes7.dex */
    public static class Builder {
        public Context mContext;
        public boolean mPinchEnabled = false;
        public int mInteractiveMode = 2;
        public int mStereoType = 1;

        public KwaiVR build() {
            return new KwaiVR(this);
        }

        public Builder setContext(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder setInteractive(int i2) {
            this.mInteractiveMode = i2;
            return this;
        }

        public Builder setPinchEnabled(boolean z) {
            this.mPinchEnabled = z;
            return this;
        }

        public Builder setStereoType(int i2) {
            this.mStereoType = i2;
            return this;
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
        this.mInteractiveMode = 0;
        this.mStereoType = 1;
        this.mContext = builder.mContext;
        this.mInteractiveMode = builder.mInteractiveMode;
        this.mPinchEnabled = builder.mPinchEnabled;
        this.mStereoType = builder.mStereoType;
        this.mKwaiPlayerStereoMesh = new KwaiPlayerStereoMesh(this.mStereoType);
        setUp();
    }

    public static Builder builder() {
        return new Builder();
    }

    private void setGestureEnabled(boolean z) {
        KwaiGestureHelper kwaiGestureHelper = this.mGestureHelper;
        if (kwaiGestureHelper != null) {
            kwaiGestureHelper.setGestureEnabled(z);
        }
        this.mGestureHelper.setPinchEnabled(this.mPinchEnabled);
    }

    private void setSensorEnabled(boolean z) {
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

    public int getInteractiveMode() {
        return this.mInteractiveMode;
    }

    public KwaiMesh getKwaiMesh() {
        KwaiPlayerStereoMesh kwaiPlayerStereoMesh = this.mKwaiPlayerStereoMesh;
        if (kwaiPlayerStereoMesh != null) {
            return kwaiPlayerStereoMesh.getKwaiMesh();
        }
        return null;
    }

    public float[] getMVPMatrix() {
        KwaiOrientationHelper kwaiOrientationHelper = this.mKwaiOrientationHelper;
        if (kwaiOrientationHelper != null) {
            return kwaiOrientationHelper.getMVPMatrix();
        }
        return null;
    }

    public int getOrientaionDegrees() {
        KwaiOrientationHelper kwaiOrientationHelper = this.mKwaiOrientationHelper;
        if (kwaiOrientationHelper != null) {
            kwaiOrientationHelper.getOrientaionDegrees();
            return 0;
        }
        return 0;
    }

    public float[] getOrientation() {
        KwaiOrientationHelper kwaiOrientationHelper = this.mKwaiOrientationHelper;
        if (kwaiOrientationHelper != null) {
            return kwaiOrientationHelper.getOrientation();
        }
        return null;
    }

    public void handleSensorEvent(SensorEvent sensorEvent) {
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

    public boolean handleTouchEvent(MotionEvent motionEvent) {
        String str;
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

    public void initGeusture() {
        KwaiGestureHelper kwaiGestureHelper = new KwaiGestureHelper(this.mContext);
        this.mGestureHelper = kwaiGestureHelper;
        if (kwaiGestureHelper != null) {
            kwaiGestureHelper.setAdvanceGestureListener(new IAdvanceGestureListener() { // from class: com.kwai.player.vr.KwaiVR.1
                @Override // com.kwai.player.vr.KwaiVR.IAdvanceGestureListener
                public void onDrag(float f2, float f3) {
                    KwaiVR.this.mKwaiOrientationHelper.setDelta(f2, f3);
                }

                @Override // com.kwai.player.vr.KwaiVR.IAdvanceGestureListener
                public void onPinch(float f2) {
                    KwaiVR.this.mKwaiOrientationHelper.setNearScale(f2);
                }
            });
        }
    }

    public void initSensor() {
        KwaiSensorHelper kwaiSensorHelper = new KwaiSensorHelper(this.mContext);
        this.mSensorHelper = kwaiSensorHelper;
        if (kwaiSensorHelper != null) {
            kwaiSensorHelper.setAdvanceSensorListener(new IAdvanceSensorListener() { // from class: com.kwai.player.vr.KwaiVR.2
                @Override // com.kwai.player.vr.KwaiVR.IAdvanceSensorListener
                public void OnRotation(int i2) {
                    KwaiVR.this.mKwaiOrientationHelper.setRotation(i2);
                }

                @Override // com.kwai.player.vr.KwaiVR.IAdvanceSensorListener
                public void onSensorMatrix(float[] fArr) {
                    KwaiVR.this.mKwaiOrientationHelper.updateSensorMatrix(fArr);
                }

                @Override // com.kwai.player.vr.KwaiVR.IAdvanceSensorListener
                public boolean onStartOrientation(float[] fArr) {
                    return KwaiVR.this.mKwaiOrientationHelper.updateSensorOrigin(fArr);
                }
            });
        }
    }

    public boolean isSupport() {
        return this.mStereoType == 1;
    }

    public void recenterOrientation() {
        KwaiSensorHelper kwaiSensorHelper = this.mSensorHelper;
        if (kwaiSensorHelper != null) {
            kwaiSensorHelper.resetYaw();
        }
    }

    public void registerSensorEvent() {
        KwaiSensorHelper kwaiSensorHelper = this.mSensorHelper;
        if (kwaiSensorHelper != null) {
            kwaiSensorHelper.turnOnInGL(this.mContext, true);
        }
    }

    public void release() {
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

    public void resetGesture() {
        KwaiGestureHelper kwaiGestureHelper = this.mGestureHelper;
        if (kwaiGestureHelper != null) {
            kwaiGestureHelper.reset();
        }
    }

    public void setInteractiveMode(int i2) {
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

    public void setInteractiveValid() {
        this.mInteractiveValid = true;
        Log.d(TAG, "set interactive valid");
    }

    public void setPinchEnabled(boolean z) {
        this.mPinchEnabled = z;
        this.mGestureHelper.setPinchEnabled(z);
    }

    public void setUp() {
        initGeusture();
        initSensor();
        setInteractiveMode(this.mInteractiveMode);
    }

    public void setViewport(int i2, int i3) {
        KwaiOrientationHelper kwaiOrientationHelper = this.mKwaiOrientationHelper;
        if (kwaiOrientationHelper != null) {
            kwaiOrientationHelper.setViewport(i2, i3);
        }
    }

    public void unRegisterSensorEvent() {
        KwaiSensorHelper kwaiSensorHelper = this.mSensorHelper;
        if (kwaiSensorHelper != null) {
            kwaiSensorHelper.turnOffInGL(this.mContext);
        }
    }
}
