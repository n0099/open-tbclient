package com.kwai.player.vr;

import android.content.Context;
import android.hardware.SensorEvent;
import android.util.Log;
import android.view.MotionEvent;
/* loaded from: classes3.dex */
public class KwaiVR {
    public static final int INTERACTIVE_MODE_MOTION = 0;
    public static final int INTERACTIVE_MODE_MOTION_WITH_TOUCH = 2;
    public static final int INTERACTIVE_MODE_TOUCH = 1;
    public static final int STEREO_TYPE_NON = 0;
    public static final int STEREO_TYPE_SPHERE = 1;
    private static final String TAG = "KwaiVR";
    private Context mContext;
    private KwaiGestureHelper mGestureHelper;
    private int mInteractiveMode;
    private boolean mInteractiveValid = false;
    private KwaiOrientationHelper mKwaiOrientationHelper = KwaiOrientationHelper.builder().build();
    protected KwaiPlayerStereoMesh mKwaiPlayerStereoMesh;
    private boolean mPinchEnabled;
    private KwaiSensorHelper mSensorHelper;
    private int mStereoType;

    /* loaded from: classes3.dex */
    public static class Builder {
        private Context mContext;
        private boolean mPinchEnabled = false;
        private int mInteractiveMode = 2;
        private int mStereoType = 1;

        public KwaiVR build() {
            return new KwaiVR(this);
        }

        public Builder setContext(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder setInteractive(int i) {
            this.mInteractiveMode = i;
            return this;
        }

        public Builder setPinchEnabled(boolean z) {
            this.mPinchEnabled = z;
            return this;
        }

        public Builder setStereoType(int i) {
            this.mStereoType = i;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface IAdvanceGestureListener {
        void onDrag(float f, float f2);

        void onPinch(float f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface IAdvanceSensorListener {
        void OnRotation(int i);

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
        if (this.mGestureHelper != null) {
            this.mGestureHelper.setGestureEnabled(z);
        }
        this.mGestureHelper.setPinchEnabled(this.mPinchEnabled);
    }

    private void setSensorEnabled(boolean z) {
        if (this.mSensorHelper != null && z) {
            this.mSensorHelper.turnOnInGL(this.mContext, true);
        } else if (this.mSensorHelper != null) {
            this.mSensorHelper.turnOffInGL(this.mContext);
        }
    }

    public int getInteractiveMode() {
        return this.mInteractiveMode;
    }

    public KwaiMesh getKwaiMesh() {
        if (this.mKwaiPlayerStereoMesh != null) {
            return this.mKwaiPlayerStereoMesh.getKwaiMesh();
        }
        return null;
    }

    public float[] getMVPMatrix() {
        if (this.mKwaiOrientationHelper != null) {
            return this.mKwaiOrientationHelper.getMVPMatrix();
        }
        return null;
    }

    public int getOrientaionDegrees() {
        if (this.mKwaiOrientationHelper != null) {
            this.mKwaiOrientationHelper.getOrientaionDegrees();
            return 0;
        }
        return 0;
    }

    public float[] getOrientation() {
        if (this.mKwaiOrientationHelper != null) {
            return this.mKwaiOrientationHelper.getOrientation();
        }
        return null;
    }

    public void handleSensorEvent(SensorEvent sensorEvent) {
        if (!this.mInteractiveValid) {
            Log.d(TAG, "handleSensorEvent: mInteractive is not Valid");
        } else if (this.mSensorHelper != null) {
            this.mSensorHelper.onSensorChanged(sensorEvent);
        } else {
            Log.d(TAG, "handleSensorEvent: mSensorHelper nil");
        }
    }

    public boolean handleTouchEvent(MotionEvent motionEvent) {
        if (!this.mInteractiveValid) {
            Log.d(TAG, "handleTouchEvent: mInteractive is not Valid");
            return false;
        } else if (this.mGestureHelper != null) {
            return this.mGestureHelper.handleTouchEvent(motionEvent);
        } else {
            Log.d(TAG, "handleTouchEvent: mGestureHelper nil");
            return false;
        }
    }

    public void initGeusture() {
        this.mGestureHelper = new KwaiGestureHelper(this.mContext);
        if (this.mGestureHelper != null) {
            this.mGestureHelper.setAdvanceGestureListener(new IAdvanceGestureListener() { // from class: com.kwai.player.vr.KwaiVR.1
                @Override // com.kwai.player.vr.KwaiVR.IAdvanceGestureListener
                public void onDrag(float f, float f2) {
                    KwaiVR.this.mKwaiOrientationHelper.setDelta(f, f2);
                }

                @Override // com.kwai.player.vr.KwaiVR.IAdvanceGestureListener
                public void onPinch(float f) {
                    KwaiVR.this.mKwaiOrientationHelper.setNearScale(f);
                }
            });
        }
    }

    public void initSensor() {
        this.mSensorHelper = new KwaiSensorHelper(this.mContext);
        if (this.mSensorHelper != null) {
            this.mSensorHelper.setAdvanceSensorListener(new IAdvanceSensorListener() { // from class: com.kwai.player.vr.KwaiVR.2
                @Override // com.kwai.player.vr.KwaiVR.IAdvanceSensorListener
                public void OnRotation(int i) {
                    KwaiVR.this.mKwaiOrientationHelper.setRotation(i);
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
        switch (this.mStereoType) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    public void recenterOrientation() {
        if (this.mSensorHelper != null) {
            this.mSensorHelper.resetYaw();
        }
    }

    public void registerSensorEvent() {
        if (this.mSensorHelper != null) {
            this.mSensorHelper.turnOnInGL(this.mContext, true);
        }
    }

    public void release() {
        if (this.mGestureHelper != null) {
            this.mGestureHelper.setGestureEnabled(false);
            this.mGestureHelper = null;
        }
        if (this.mSensorHelper != null) {
            this.mSensorHelper.turnOffInGL(this.mContext);
            this.mSensorHelper = null;
        }
    }

    public void resetGesture() {
        if (this.mGestureHelper != null) {
            this.mGestureHelper.reset();
        }
    }

    public void setInteractiveMode(int i) {
        Log.d(TAG, "setInteractiveMode: " + i);
        this.mInteractiveMode = i;
        switch (this.mInteractiveMode) {
            case 0:
                setGestureEnabled(false);
                setSensorEnabled(true);
                return;
            case 1:
                setGestureEnabled(true);
                setSensorEnabled(false);
                return;
            case 2:
                setGestureEnabled(true);
                setSensorEnabled(true);
                return;
            default:
                return;
        }
    }

    public void setInteractiveValid() {
        this.mInteractiveValid = true;
        Log.d(TAG, "set interactive valid");
    }

    public void setPinchEnabled(boolean z) {
        this.mPinchEnabled = z;
        this.mGestureHelper.setPinchEnabled(this.mPinchEnabled);
    }

    public void setUp() {
        initGeusture();
        initSensor();
        setInteractiveMode(this.mInteractiveMode);
    }

    public void setViewport(int i, int i2) {
        if (this.mKwaiOrientationHelper != null) {
            this.mKwaiOrientationHelper.setViewport(i, i2);
        }
    }

    public void unRegisterSensorEvent() {
        if (this.mSensorHelper != null) {
            this.mSensorHelper.turnOffInGL(this.mContext);
        }
    }
}
