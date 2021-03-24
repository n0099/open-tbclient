package com.kwai.player.vr;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes6.dex */
public interface EGLConfigChooser {
    EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
}
