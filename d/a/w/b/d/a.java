package d.a.w.b.d;

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
    public static final String f68443d = "a";

    /* renamed from: a  reason: collision with root package name */
    public EGLDisplay f68444a;

    /* renamed from: b  reason: collision with root package name */
    public EGLContext f68445b;

    /* renamed from: c  reason: collision with root package name */
    public EGLConfig f68446c;

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
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f68444a, this.f68446c, obj, new int[]{ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
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
        if (!EGL14.eglChooseConfig(this.f68444a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            String str = f68443d;
            Log.w(str, "unable to find RGB8888 / " + i3 + " EGLConfig");
            return null;
        }
        return eGLConfigArr[0];
    }

    public boolean d(EGLSurface eGLSurface) {
        return this.f68445b.equals(EGL14.eglGetCurrentContext()) && eGLSurface.equals(EGL14.eglGetCurrentSurface(12377));
    }

    public void e(EGLSurface eGLSurface) {
        if (this.f68444a == EGL14.EGL_NO_DISPLAY) {
            Log.d(f68443d, "NOTE: makeCurrent w/o display");
        }
        if (!EGL14.eglMakeCurrent(this.f68444a, eGLSurface, eGLSurface, this.f68445b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void f() {
        EGLDisplay eGLDisplay = this.f68444a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f68444a, this.f68445b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f68444a);
        }
        this.f68444a = EGL14.EGL_NO_DISPLAY;
        this.f68445b = EGL14.EGL_NO_CONTEXT;
        this.f68446c = null;
    }

    public void finalize() {
        try {
            if (this.f68444a != EGL14.EGL_NO_DISPLAY) {
                Log.w(f68443d, "WARNING: EGLCore was not explicitly released -- state may be leaked");
                f();
            }
        } finally {
            super.finalize();
        }
    }

    public void g(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.f68444a, eGLSurface);
    }

    public void h(EGLSurface eGLSurface, long j) {
        EGLExt.eglPresentationTimeANDROID(this.f68444a, eGLSurface, j);
    }

    public boolean i(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers(this.f68444a, eGLSurface);
    }

    public a(EGLContext eGLContext, int i2, boolean z) {
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.f68444a = eGLDisplay;
        this.f68445b = EGL14.EGL_NO_CONTEXT;
        this.f68446c = null;
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f68444a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    if ((i2 & 2) != 0) {
                        Log.d(f68443d, "Trying GLES 3");
                        EGLConfig c2 = c(i2, 3, z);
                        if (c2 != null) {
                            EGLContext eglCreateContext = EGL14.eglCreateContext(this.f68444a, c2, eGLContext, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 3, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
                            if (EGL14.eglGetError() == 12288) {
                                this.f68446c = c2;
                                this.f68445b = eglCreateContext;
                            }
                        }
                    }
                    if (this.f68445b == EGL14.EGL_NO_CONTEXT) {
                        Log.d(f68443d, "Trying GLES 2");
                        EGLConfig c3 = c(i2, 2, z);
                        if (c3 != null) {
                            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.f68444a, c3, eGLContext, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
                            a("eglCreateContext");
                            this.f68446c = c3;
                            this.f68445b = eglCreateContext2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig");
                        }
                    }
                    int[] iArr2 = new int[1];
                    EGL14.eglQueryContext(this.f68444a, this.f68445b, EglBase10.EGL_CONTEXT_CLIENT_VERSION, iArr2, 0);
                    String str = f68443d;
                    Log.d(str, "EGLContext created, client version " + iArr2[0]);
                    return;
                }
                this.f68444a = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
        throw new RuntimeException("EGL already set up");
    }
}
