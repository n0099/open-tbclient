package com.kwai.player.vr;

import com.baidu.webkit.internal.monitor.ZeusMonitorType;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes7.dex */
public abstract class BaseConfigChooser implements EGLConfigChooser {
    public int[] mConfigSpec;
    public int mEGLContextClientVersion;

    /* loaded from: classes7.dex */
    public static class ComponentSizeChooser extends BaseConfigChooser {
        public int mAlphaSize;
        public int mBlueSize;
        public int mDepthSize;
        public int mGreenSize;
        public int mRedSize;
        public int mStencilSize;
        public int[] mValue;

        public ComponentSizeChooser(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            super(new int[]{ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i2, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, i3, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, i4, ZeusMonitorType.MONITOR_TYPE_MAGICFILTER_ABORT_RESOURCE_COUNT, i5, ZeusMonitorType.MONITOR_TYPE_SUB_RESOURCE_SAFE, i6, ZeusMonitorType.MONITOR_TYPE_NET_INJECT, i7, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, i8);
            this.mValue = new int[1];
            this.mRedSize = i2;
            this.mGreenSize = i3;
            this.mBlueSize = i4;
            this.mAlphaSize = i5;
            this.mDepthSize = i6;
            this.mStencilSize = i7;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, int i3) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.mValue) ? this.mValue[0] : i3;
        }

        @Override // com.kwai.player.vr.BaseConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, ZeusMonitorType.MONITOR_TYPE_SUB_RESOURCE_SAFE, 0);
                int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, ZeusMonitorType.MONITOR_TYPE_NET_INJECT, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, ZeusMonitorType.MONITOR_TYPE_MAGICFILTER_ABORT_RESOURCE_COUNT, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public static class SimpleEGLConfigChooser extends ComponentSizeChooser {
        public SimpleEGLConfigChooser(boolean z, int i2) {
            super(8, 8, 8, 0, z ? 16 : 0, 0, i2);
        }
    }

    public BaseConfigChooser(int[] iArr, int i2) {
        this.mEGLContextClientVersion = i2;
        this.mConfigSpec = filterConfigSpec(iArr);
    }

    private int[] filterConfigSpec(int[] iArr) {
        int i2 = this.mEGLContextClientVersion;
        if (i2 == 2 || i2 == 3) {
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i3 = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            iArr2[i3] = 12352;
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
            int i2 = iArr[0];
            if (i2 > 0) {
                EGLConfig[] eGLConfigArr = new EGLConfig[i2];
                if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, eGLConfigArr, i2, iArr)) {
                    EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
                    if (chooseConfig != null) {
                        return chooseConfig;
                    }
                    throw new IllegalArgumentException("No config chosen");
                }
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            throw new IllegalArgumentException("No configs match configSpec");
        }
        throw new IllegalArgumentException("eglChooseConfig failed");
    }

    public abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);
}
