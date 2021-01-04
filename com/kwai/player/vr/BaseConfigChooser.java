package com.kwai.player.vr;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes5.dex */
public abstract class BaseConfigChooser implements EGLConfigChooser {
    protected int[] mConfigSpec;
    private int mEGLContextClientVersion;

    /* loaded from: classes5.dex */
    public static class ComponentSizeChooser extends BaseConfigChooser {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue;

        public ComponentSizeChooser(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344}, i7);
            this.mValue = new int[1];
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue) ? this.mValue[0] : i2;
        }

        @Override // com.kwai.player.vr.BaseConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class SimpleEGLConfigChooser extends ComponentSizeChooser {
        public SimpleEGLConfigChooser(boolean z, int i) {
            super(8, 8, 8, 0, z ? 16 : 0, 0, i);
        }
    }

    public BaseConfigChooser(int[] iArr, int i) {
        this.mEGLContextClientVersion = i;
        this.mConfigSpec = filterConfigSpec(iArr);
    }

    private int[] filterConfigSpec(int[] iArr) {
        if (this.mEGLContextClientVersion == 2 || this.mEGLContextClientVersion == 3) {
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            System.arraycopy(iArr, 0, iArr2, 0, length - 1);
            iArr2[length - 1] = 12352;
            if (this.mEGLContextClientVersion == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }
        return iArr;
    }

    @Override // com.kwai.player.vr.EGLConfigChooser
    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr = new int[1];
        if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, null, 0, iArr)) {
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, eGLConfigArr, i, iArr)) {
                EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
                if (chooseConfig == null) {
                    throw new IllegalArgumentException("No config chosen");
                }
                return chooseConfig;
            }
            throw new IllegalArgumentException("eglChooseConfig#2 failed");
        }
        throw new IllegalArgumentException("eglChooseConfig failed");
    }

    abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);
}
