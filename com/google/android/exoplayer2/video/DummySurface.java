package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.util.v;
@TargetApi(17)
/* loaded from: classes5.dex */
public final class DummySurface extends Surface {
    private static final int EGL_PROTECTED_CONTENT_EXT = 12992;
    private static final String TAG = "DummySurface";
    private static boolean secureSupported;
    private static boolean secureSupportedInitialized;
    public final boolean secure;
    private final a thread;
    private boolean threadReleased;

    public static synchronized boolean gs(Context context) {
        boolean z;
        boolean z2 = true;
        synchronized (DummySurface.class) {
            if (!secureSupportedInitialized) {
                secureSupported = (v.SDK_INT < 24 || !gt(context)) ? false : false;
                secureSupportedInitialized = true;
            }
            z = secureSupported;
        }
        return z;
    }

    public static DummySurface p(Context context, boolean z) {
        dyI();
        com.google.android.exoplayer2.util.a.checkState(!z || gs(context));
        return new a().vR(z);
    }

    private DummySurface(a aVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.thread = aVar;
        this.secure = z;
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.thread) {
            if (!this.threadReleased) {
                this.thread.release();
                this.threadReleased = true;
            }
        }
    }

    private static void dyI() {
        if (v.SDK_INT < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    @TargetApi(24)
    private static boolean gt(Context context) {
        String eglQueryString;
        if (v.SDK_INT >= 26 || !"samsung".equals(v.MANUFACTURER)) {
            return (v.SDK_INT >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_EXT_protected_content");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {
        private SurfaceTexture dQG;
        private Handler handler;
        private final int[] mHn;
        private EGLDisplay mHo;
        private EGLContext mHp;
        private EGLSurface mHq;
        private Error mHr;
        private RuntimeException mHs;
        private DummySurface mHt;

        public a() {
            super("dummySurface");
            this.mHn = new int[1];
        }

        public DummySurface vR(boolean z) {
            boolean z2 = false;
            start();
            this.handler = new Handler(getLooper(), this);
            synchronized (this) {
                this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
                while (this.mHt == null && this.mHs == null && this.mHr == null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
            if (this.mHs != null) {
                throw this.mHs;
            }
            if (this.mHr != null) {
                throw this.mHr;
            }
            return this.mHt;
        }

        public void release() {
            this.handler.sendEmptyMessage(3);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.handler.sendEmptyMessage(2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [244=4, 245=4, 246=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 1:
                        try {
                            vS(message.arg1 != 0);
                            synchronized (this) {
                                notify();
                            }
                        } catch (Error e) {
                            Log.e(DummySurface.TAG, "Failed to initialize dummy surface", e);
                            this.mHr = e;
                            synchronized (this) {
                                notify();
                            }
                        } catch (RuntimeException e2) {
                            Log.e(DummySurface.TAG, "Failed to initialize dummy surface", e2);
                            this.mHs = e2;
                            synchronized (this) {
                                notify();
                            }
                        }
                        break;
                    case 2:
                        this.dQG.updateTexImage();
                        break;
                    case 3:
                        try {
                            releaseInternal();
                            break;
                        } catch (Throwable th) {
                            try {
                                Log.e(DummySurface.TAG, "Failed to release dummy surface", th);
                                break;
                            } finally {
                                quit();
                            }
                        }
                }
                return true;
            } catch (Throwable th2) {
                synchronized (this) {
                    notify();
                    throw th2;
                }
            }
        }

        private void vS(boolean z) {
            int[] iArr;
            int[] iArr2;
            this.mHo = EGL14.eglGetDisplay(0);
            com.google.android.exoplayer2.util.a.d(this.mHo != null, "eglGetDisplay failed");
            int[] iArr3 = new int[2];
            com.google.android.exoplayer2.util.a.d(EGL14.eglInitialize(this.mHo, iArr3, 0, iArr3, 1), "eglInitialize failed");
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr4 = new int[1];
            com.google.android.exoplayer2.util.a.d(EGL14.eglChooseConfig(this.mHo, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr4, 0) && iArr4[0] > 0 && eGLConfigArr[0] != null, "eglChooseConfig failed");
            EGLConfig eGLConfig = eGLConfigArr[0];
            if (z) {
                iArr = new int[]{12440, 2, DummySurface.EGL_PROTECTED_CONTENT_EXT, 1, 12344};
            } else {
                iArr = new int[]{12440, 2, 12344};
            }
            this.mHp = EGL14.eglCreateContext(this.mHo, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
            com.google.android.exoplayer2.util.a.d(this.mHp != null, "eglCreateContext failed");
            if (z) {
                iArr2 = new int[]{12375, 1, 12374, 1, DummySurface.EGL_PROTECTED_CONTENT_EXT, 1, 12344};
            } else {
                iArr2 = new int[]{12375, 1, 12374, 1, 12344};
            }
            this.mHq = EGL14.eglCreatePbufferSurface(this.mHo, eGLConfig, iArr2, 0);
            com.google.android.exoplayer2.util.a.d(this.mHq != null, "eglCreatePbufferSurface failed");
            com.google.android.exoplayer2.util.a.d(EGL14.eglMakeCurrent(this.mHo, this.mHq, this.mHq, this.mHp), "eglMakeCurrent failed");
            GLES20.glGenTextures(1, this.mHn, 0);
            this.dQG = new SurfaceTexture(this.mHn[0]);
            this.dQG.setOnFrameAvailableListener(this);
            this.mHt = new DummySurface(this, this.dQG, z);
        }

        /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE] complete}, expected: {[IGET] complete} */
        /* JADX WARN: Finally extract failed */
        private void releaseInternal() {
            try {
                if (this.dQG != null) {
                    this.dQG.release();
                    GLES20.glDeleteTextures(1, this.mHn, 0);
                }
                if (this.mHq != null) {
                    EGL14.eglDestroySurface(this.mHo, this.mHq);
                }
                if (this.mHp != null) {
                    EGL14.eglDestroyContext(this.mHo, this.mHp);
                }
                this.mHq = null;
                this.mHp = null;
                this.mHo = null;
                this.mHt = null;
                this.dQG = null;
            } catch (Throwable th) {
                if (this.mHq != null) {
                    EGL14.eglDestroySurface(this.mHo, this.mHq);
                }
                if (this.mHp != null) {
                    EGL14.eglDestroyContext(this.mHo, this.mHp);
                }
                this.mHq = null;
                this.mHp = null;
                this.mHo = null;
                this.mHt = null;
                this.dQG = null;
                throw th;
            }
        }
    }
}
