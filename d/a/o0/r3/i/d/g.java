package d.a.o0.r3.i.d;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import com.baidu.searchbox.afx.recode.InputSurface;
import com.baidu.webkit.internal.monitor.ZeusMonitorType;
import org.webrtc.EglBase10;
@TargetApi(18)
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public EGLDisplay f63918a;

    /* renamed from: b  reason: collision with root package name */
    public EGLContext f63919b;

    /* renamed from: c  reason: collision with root package name */
    public EGLSurface f63920c;

    /* renamed from: d  reason: collision with root package name */
    public Surface f63921d;

    public g(Surface surface) {
        if (surface != null) {
            this.f63921d = surface;
            b();
            return;
        }
        throw null;
    }

    public final void a(String str) {
        boolean z = false;
        while (true) {
            int eglGetError = EGL14.eglGetError();
            if (eglGetError == 12288) {
                break;
            }
            Log.e(InputSurface.TAG, str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            z = true;
        }
        if (z) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    public final void b() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f63918a = eglGetDisplay;
        if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                this.f63918a = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.f63918a, new int[]{ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, 8, 12352, 4, 12610, 1, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                this.f63919b = EGL14.eglCreateContext(this.f63918a, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
                a("eglCreateContext");
                if (this.f63919b != null) {
                    this.f63920c = EGL14.eglCreateWindowSurface(this.f63918a, eGLConfigArr[0], this.f63921d, new int[]{ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
                    a("eglCreateWindowSurface");
                    if (this.f63920c == null) {
                        throw new RuntimeException("surface was null");
                    }
                    return;
                }
                throw new RuntimeException("null context");
            }
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        throw new RuntimeException("unable to get EGL14 display");
    }

    public void c() {
        EGLDisplay eGLDisplay = this.f63918a;
        EGLSurface eGLSurface = this.f63920c;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f63919b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void d() {
        if (EGL14.eglGetCurrentContext().equals(this.f63919b)) {
            EGLDisplay eGLDisplay = this.f63918a;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        }
        EGL14.eglDestroySurface(this.f63918a, this.f63920c);
        EGL14.eglDestroyContext(this.f63918a, this.f63919b);
        this.f63921d.release();
        this.f63918a = null;
        this.f63919b = null;
        this.f63920c = null;
        this.f63921d = null;
    }

    public void e(long j) {
        EGLExt.eglPresentationTimeANDROID(this.f63918a, this.f63920c, j);
    }

    public boolean f() {
        return EGL14.eglSwapBuffers(this.f63918a, this.f63920c);
    }
}
