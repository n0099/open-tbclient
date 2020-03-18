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
/* loaded from: classes6.dex */
public final class DummySurface extends Surface {
    private static final int EGL_PROTECTED_CONTENT_EXT = 12992;
    private static final String TAG = "DummySurface";
    private static boolean secureSupported;
    private static boolean secureSupportedInitialized;
    public final boolean secure;
    private final a thread;
    private boolean threadReleased;

    public static synchronized boolean gq(Context context) {
        boolean z;
        boolean z2 = true;
        synchronized (DummySurface.class) {
            if (!secureSupportedInitialized) {
                secureSupported = (v.SDK_INT < 24 || !gr(context)) ? false : false;
                secureSupportedInitialized = true;
            }
            z = secureSupported;
        }
        return z;
    }

    public static DummySurface o(Context context, boolean z) {
        dAs();
        com.google.android.exoplayer2.util.a.checkState(!z || gq(context));
        return new a().wc(z);
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

    private static void dAs() {
        if (v.SDK_INT < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    @TargetApi(24)
    private static boolean gr(Context context) {
        String eglQueryString;
        if (v.SDK_INT >= 26 || !"samsung".equals(v.MANUFACTURER)) {
            return (v.SDK_INT >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_EXT_protected_content");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {
        private Handler handler;
        private final int[] mJP;
        private EGLDisplay mJQ;
        private EGLContext mJR;
        private EGLSurface mJS;
        private Error mJT;
        private RuntimeException mJU;
        private DummySurface mJV;
        private SurfaceTexture surfaceTexture;

        public a() {
            super("dummySurface");
            this.mJP = new int[1];
        }

        public DummySurface wc(boolean z) {
            boolean z2 = false;
            start();
            this.handler = new Handler(getLooper(), this);
            synchronized (this) {
                this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
                while (this.mJV == null && this.mJU == null && this.mJT == null) {
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
            if (this.mJU != null) {
                throw this.mJU;
            }
            if (this.mJT != null) {
                throw this.mJT;
            }
            return this.mJV;
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
                            wd(message.arg1 != 0);
                            synchronized (this) {
                                notify();
                            }
                        } catch (Error e) {
                            Log.e(DummySurface.TAG, "Failed to initialize dummy surface", e);
                            this.mJT = e;
                            synchronized (this) {
                                notify();
                            }
                        } catch (RuntimeException e2) {
                            Log.e(DummySurface.TAG, "Failed to initialize dummy surface", e2);
                            this.mJU = e2;
                            synchronized (this) {
                                notify();
                            }
                        }
                        break;
                    case 2:
                        this.surfaceTexture.updateTexImage();
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

        private void wd(boolean z) {
            int[] iArr;
            int[] iArr2;
            this.mJQ = EGL14.eglGetDisplay(0);
            com.google.android.exoplayer2.util.a.d(this.mJQ != null, "eglGetDisplay failed");
            int[] iArr3 = new int[2];
            com.google.android.exoplayer2.util.a.d(EGL14.eglInitialize(this.mJQ, iArr3, 0, iArr3, 1), "eglInitialize failed");
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr4 = new int[1];
            com.google.android.exoplayer2.util.a.d(EGL14.eglChooseConfig(this.mJQ, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr4, 0) && iArr4[0] > 0 && eGLConfigArr[0] != null, "eglChooseConfig failed");
            EGLConfig eGLConfig = eGLConfigArr[0];
            if (z) {
                iArr = new int[]{12440, 2, DummySurface.EGL_PROTECTED_CONTENT_EXT, 1, 12344};
            } else {
                iArr = new int[]{12440, 2, 12344};
            }
            this.mJR = EGL14.eglCreateContext(this.mJQ, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
            com.google.android.exoplayer2.util.a.d(this.mJR != null, "eglCreateContext failed");
            if (z) {
                iArr2 = new int[]{12375, 1, 12374, 1, DummySurface.EGL_PROTECTED_CONTENT_EXT, 1, 12344};
            } else {
                iArr2 = new int[]{12375, 1, 12374, 1, 12344};
            }
            this.mJS = EGL14.eglCreatePbufferSurface(this.mJQ, eGLConfig, iArr2, 0);
            com.google.android.exoplayer2.util.a.d(this.mJS != null, "eglCreatePbufferSurface failed");
            com.google.android.exoplayer2.util.a.d(EGL14.eglMakeCurrent(this.mJQ, this.mJS, this.mJS, this.mJR), "eglMakeCurrent failed");
            GLES20.glGenTextures(1, this.mJP, 0);
            this.surfaceTexture = new SurfaceTexture(this.mJP[0]);
            this.surfaceTexture.setOnFrameAvailableListener(this);
            this.mJV = new DummySurface(this, this.surfaceTexture, z);
        }

        /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE] complete}, expected: {[IGET] complete} */
        /* JADX WARN: Finally extract failed */
        private void releaseInternal() {
            try {
                if (this.surfaceTexture != null) {
                    this.surfaceTexture.release();
                    GLES20.glDeleteTextures(1, this.mJP, 0);
                }
                if (this.mJS != null) {
                    EGL14.eglDestroySurface(this.mJQ, this.mJS);
                }
                if (this.mJR != null) {
                    EGL14.eglDestroyContext(this.mJQ, this.mJR);
                }
                this.mJS = null;
                this.mJR = null;
                this.mJQ = null;
                this.mJV = null;
                this.surfaceTexture = null;
            } catch (Throwable th) {
                if (this.mJS != null) {
                    EGL14.eglDestroySurface(this.mJQ, this.mJS);
                }
                if (this.mJR != null) {
                    EGL14.eglDestroyContext(this.mJQ, this.mJR);
                }
                this.mJS = null;
                this.mJR = null;
                this.mJQ = null;
                this.mJV = null;
                this.surfaceTexture = null;
                throw th;
            }
        }
    }
}
