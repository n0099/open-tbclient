package com.thunder.livesdk;
/* loaded from: classes4.dex */
public class ThunderNotificationInside {
    public static final int kThunderAPINotification_PublishVideoCfg = 1000;
    public static final int kThunderAPINotification_Start_Tag = 1000;

    /* loaded from: classes4.dex */
    public static class PublishVideoCfg {
        private boolean mBHardwareEncoder;
        private boolean mBMirrorFrontCamera;
        private boolean mBPubToGroupAndName;
        private int mEncodeBitrate;
        private int mEncodeFrameRate;
        private int mEncodeResolutionHeight;
        private int mEncodeResolutionWidth;
        private int mEncodeType;
        private int mMode;
        private int mPlayType;
        private int mScreenOrientation;

        public PublishVideoCfg(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, int i6, int i7, int i8) {
            this.mEncodeFrameRate = i;
            this.mEncodeBitrate = i2;
            this.mEncodeResolutionWidth = i3;
            this.mEncodeResolutionHeight = i4;
            this.mEncodeType = i5;
            this.mBHardwareEncoder = z;
            this.mBMirrorFrontCamera = z2;
            this.mBPubToGroupAndName = z3;
            this.mMode = i6;
            this.mPlayType = i7;
            this.mScreenOrientation = i8;
        }

        public int getEncodeFrameRate() {
            return this.mEncodeFrameRate;
        }

        public int getEncodeBitrate() {
            return this.mEncodeBitrate;
        }

        public int getEncodeResolutionWidth() {
            return this.mEncodeResolutionWidth;
        }

        public int getEncodeResolutionHeight() {
            return this.mEncodeResolutionHeight;
        }

        public int getEncodeType() {
            return this.mEncodeType;
        }

        public boolean isHardwareEncoder() {
            return this.mBHardwareEncoder;
        }

        public boolean isMirrorFrontCamera() {
            return this.mBMirrorFrontCamera;
        }

        public boolean isPubToGroupAndName() {
            return this.mBPubToGroupAndName;
        }

        public int getMode() {
            return this.mMode;
        }

        public int getPlayType() {
            return this.mPlayType;
        }

        public int getScreenOrientation() {
            return this.mScreenOrientation;
        }
    }
}
