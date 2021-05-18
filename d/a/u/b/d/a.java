package d.a.u.b.d;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import com.baidu.webkit.internal.monitor.ZeusMonitorType;
import org.webrtc.EglBase10;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f64672d = "a";

    /* renamed from: a  reason: collision with root package name */
    public EGLDisplay f64673a;

    /* renamed from: b  reason: collision with root package name */
    public EGLContext f64674b;

    /* renamed from: c  reason: collision with root package name */
    public EGLConfig f64675c;

    public a(EGLContext eGLContext, int i2) {
        this(eGLContext, i2, false);
    }

    public final void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    public EGLSurface b(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + obj);
        }
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f64673a, this.f64675c, obj, new int[]{ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
        a("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public final EGLConfig c(int i2, int i3, boolean z) {
        int[] iArr = {ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, 8, ZeusMonitorType.MONITOR_TYPE_MAGICFILTER_ABORT_RESOURCE_COUNT, 8, ZeusMonitorType.MONITOR_TYPE_SUB_RESOURCE_SAFE, z ? 16 : 0, ZeusMonitorType.MONITOR_TYPE_NET_INJECT, 0, 12352, i3 >= 3 ? 68 : 4, ZeusMonitorType.MONITOR_TYPE_AD_FILTER, 0, ZeusMonitorType.MONITOR_TYPE_AD_FILTER};
        if ((i2 & 1) != 0) {
            iArr[14] = 12610;
            iArr[15] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.f64673a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            String str = f64672d;
            Log.w(str, "unable to find RGB8888 / " + i3 + " EGLConfig");
            return null;
        }
        return eGLConfigArr[0];
    }

    public boolean d(EGLSurface eGLSurface) {
        return this.f64674b.equals(EGL14.eglGetCurrentContext()) && eGLSurface.equals(EGL14.eglGetCurrentSurface(12377));
    }

    public void e(EGLSurface eGLSurface) {
        if (this.f64673a == EGL14.EGL_NO_DISPLAY) {
            Log.d(f64672d, "NOTE: makeCurrent w/o display");
        }
        if (!EGL14.eglMakeCurrent(this.f64673a, eGLSurface, eGLSurface, this.f64674b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void f() {
        EGLDisplay eGLDisplay = this.f64673a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f64673a, this.f64674b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f64673a);
        }
        this.f64673a = EGL14.EGL_NO_DISPLAY;
        this.f64674b = EGL14.EGL_NO_CONTEXT;
        this.f64675c = null;
    }

    public void finalize() {
        try {
            if (this.f64673a != EGL14.EGL_NO_DISPLAY) {
                Log.w(f64672d, "WARNING: EGLCore was not explicitly released -- state may be leaked");
                f();
            }
        } finally {
            super.finalize();
        }
    }

    public void g(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.f64673a, eGLSurface);
    }

    public void h(EGLSurface eGLSurface, long j) {
        EGLExt.eglPresentationTimeANDROID(this.f64673a, eGLSurface, j);
    }

    public boolean i(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers(this.f64673a, eGLSurface);
    }

    public a(EGLContext eGLContext, int i2, boolean z) {
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.f64673a = eGLDisplay;
        this.f64674b = EGL14.EGL_NO_CONTEXT;
        this.f64675c = null;
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f64673a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    if ((i2 & 2) != 0) {
                        Log.d(f64672d, "Trying GLES 3");
                        EGLConfig c2 = c(i2, 3, z);
                        if (c2 != null) {
                            EGLContext eglCreateContext = EGL14.eglCreateContext(this.f64673a, c2, eGLContext, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 3, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
                            if (EGL14.eglGetError() == 12288) {
                                this.f64675c = c2;
                                this.f64674b = eglCreateContext;
                            }
                        }
                    }
                    if (this.f64674b == EGL14.EGL_NO_CONTEXT) {
                        Log.d(f64672d, "Trying GLES 2");
                        EGLConfig c3 = c(i2, 2, z);
                        if (c3 != null) {
                            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.f64673a, c3, eGLContext, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
                            a("eglCreateContext");
                            this.f64675c = c3;
                            this.f64674b = eglCreateContext2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig");
                        }
                    }
                    int[] iArr2 = new int[1];
                    EGL14.eglQueryContext(this.f64673a, this.f64674b, EglBase10.EGL_CONTEXT_CLIENT_VERSION, iArr2, 0);
                    String str = f64672d;
                    Log.d(str, "EGLContext created, client version " + iArr2[0]);
                    return;
                }
                this.f64673a = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
        throw new RuntimeException("EGL already set up");
    }
}
