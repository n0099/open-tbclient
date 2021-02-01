package com.yy.mediaframework.gles;

import android.opengl.EGLContext;
import android.os.Build;
import android.view.SurfaceHolder;
import com.yy.mediaframework.model.AbstractSurfaceInfo;
import com.yy.mediaframework.model.SurfaceHolderInfo;
/* loaded from: classes4.dex */
public class EglFactory {
    private static IEglCore mIEglCore;

    public static IEglCore createEGL() {
        if (Build.VERSION.SDK_INT >= 17) {
            return new EglCore();
        }
        return new EglCoreKhronos();
    }

    public static IEglCore createEGL(Object obj, int i) {
        IEglCore eglCoreKhronos;
        if (Build.VERSION.SDK_INT >= 17 && (obj == null || (obj instanceof EGLContext))) {
            eglCoreKhronos = new EglCore(obj, i);
        } else if (obj != null && (obj instanceof javax.microedition.khronos.egl.EGLContext)) {
            eglCoreKhronos = new EglCoreKhronos((javax.microedition.khronos.egl.EGLContext) obj);
        } else {
            eglCoreKhronos = new EglCoreKhronos();
        }
        mIEglCore = eglCoreKhronos;
        return eglCoreKhronos;
    }

    public static boolean android_opengl_egl_support() {
        return Build.VERSION.SDK_INT >= 17;
    }

    public static AbstractSurfaceInfo newSurfaceInfo(SurfaceHolder surfaceHolder, int i, int i2) {
        return new SurfaceHolderInfo(surfaceHolder, i, i2);
    }

    public static IWindowSurface newWindowSurface(IEglCore iEglCore, AbstractSurfaceInfo abstractSurfaceInfo, boolean z) {
        if (android_opengl_egl_support()) {
            return iEglCore.createWindowSurface(((SurfaceHolderInfo) abstractSurfaceInfo).mSurfaceHolder.getSurface(), z);
        }
        return iEglCore.createWindowSurface(((SurfaceHolderInfo) abstractSurfaceInfo).mSurfaceHolder, z);
    }

    public Object getEGLContext() {
        return mIEglCore.getEGLContext();
    }
}
