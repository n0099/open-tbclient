package d.e.c;

import android.annotation.TargetApi;
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
@TargetApi(18)
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public EGLDisplay f66074a;

    /* renamed from: b  reason: collision with root package name */
    public EGLContext f66075b;

    /* renamed from: c  reason: collision with root package name */
    public EGLConfig f66076c;

    public a(EGLContext eGLContext, int i2) {
        EGLConfig c2;
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.f66074a = eGLDisplay;
        this.f66075b = EGL14.EGL_NO_CONTEXT;
        this.f66076c = null;
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f66074a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    if ((i2 & 2) != 0 && (c2 = c(i2, 3)) != null) {
                        EGLContext eglCreateContext = EGL14.eglCreateContext(this.f66074a, c2, eGLContext, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 3, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
                        if (EGL14.eglGetError() == 12288) {
                            this.f66076c = c2;
                            this.f66075b = eglCreateContext;
                        }
                    }
                    if (this.f66075b == EGL14.EGL_NO_CONTEXT) {
                        EGLConfig c3 = c(i2, 2);
                        if (c3 != null) {
                            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.f66074a, c3, eGLContext, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
                            a("eglCreateContext");
                            this.f66076c = c3;
                            this.f66075b = eglCreateContext2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig");
                        }
                    }
                    int[] iArr2 = new int[1];
                    EGL14.eglQueryContext(this.f66074a, this.f66075b, EglBase10.EGL_CONTEXT_CLIENT_VERSION, iArr2, 0);
                    Log.d("Grafika", "EGLContext created, client version " + iArr2[0]);
                    return;
                }
                this.f66074a = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
        throw new RuntimeException("EGL already set up");
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
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f66074a, this.f66076c, obj, new int[]{ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
        a("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public final EGLConfig c(int i2, int i3) {
        int[] iArr = {ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, 8, ZeusMonitorType.MONITOR_TYPE_MAGICFILTER_ABORT_RESOURCE_COUNT, 8, 12352, i3 >= 3 ? 68 : 4, ZeusMonitorType.MONITOR_TYPE_AD_FILTER, 0, ZeusMonitorType.MONITOR_TYPE_AD_FILTER};
        if ((i2 & 1) != 0) {
            iArr[10] = 12610;
            iArr[11] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.f66074a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            Log.w("Grafika", "unable to find RGB8888 / " + i3 + " EGLConfig");
            return null;
        }
        return eGLConfigArr[0];
    }

    public void d(EGLSurface eGLSurface) {
        if (this.f66074a == EGL14.EGL_NO_DISPLAY) {
            Log.d("Grafika", "NOTE: makeCurrent w/o display");
        }
        if (!EGL14.eglMakeCurrent(this.f66074a, eGLSurface, eGLSurface, this.f66075b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void e() {
        EGLDisplay eGLDisplay = this.f66074a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f66074a, this.f66075b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f66074a);
        }
        this.f66074a = EGL14.EGL_NO_DISPLAY;
        this.f66075b = EGL14.EGL_NO_CONTEXT;
        this.f66076c = null;
    }

    public void f(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.f66074a, eGLSurface);
    }

    public void finalize() throws Throwable {
        try {
            if (this.f66074a != EGL14.EGL_NO_DISPLAY) {
                Log.w("Grafika", "WARNING: EglCore was not explicitly released -- state may be leaked");
                e();
            }
        } finally {
            super.finalize();
        }
    }

    public void g(EGLSurface eGLSurface, long j) {
        EGLExt.eglPresentationTimeANDROID(this.f66074a, eGLSurface, j);
    }

    public boolean h(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers(this.f66074a, eGLSurface);
    }
}
