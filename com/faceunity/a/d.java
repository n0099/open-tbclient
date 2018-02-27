package com.faceunity.a;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ar.util.Constants;
import com.baidu.tieba.i.h;
import com.baidu.tieba.i.k;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes2.dex */
public class d {
    private static final int[] hWR = {1, 0, 5, 7, 6};
    private com.faceunity.a.c hWN;
    private com.faceunity.gles.e hWX;
    private com.faceunity.gles.a hWY;
    private com.faceunity.gles.c hWZ;
    private int hXa;
    private com.faceunity.a.e hXb;
    private com.faceunity.a.a hXc;
    private volatile HandlerC0262d hXd;
    private int hXe;
    private c hXf;
    private int hXi;
    private int hXj;
    private b hXk;
    private final Object hXl;
    private boolean hXm;
    private final Object hXn;
    private boolean hXo;
    private boolean hXp;
    private boolean hXq;
    private long hXr;
    private h hbC;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long hXg = 0;
    private long hXh = 0;

    /* loaded from: classes2.dex */
    public interface c {
        void bDA();

        void bDB();
    }

    public boolean yG(int i) {
        return this.hXe == i;
    }

    public d() {
        this.hXe = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.hbC = kVar.aXf();
        }
        this.hXk = null;
        this.hXl = new Object();
        this.hXm = false;
        this.hXn = new Object();
        this.hXo = false;
        this.hXp = false;
        this.hXq = false;
        this.hXr = 0L;
        this.hXe = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final int guh;
        final long hXg;
        final EGLContext hXt;
        final File hnZ;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.hnZ = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.guh = i3;
            if (eGLContext != null) {
                this.hXt = eGLContext;
            } else {
                this.hXt = EGL14.eglGetCurrentContext();
            }
            this.hXg = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Constants.MSG_SDK_LUA_BRIDGE_ACCELERATION_X + this.mHeight + " @" + this.guh + " to '" + this.hnZ.toString() + "' ctxt=" + this.hXt;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.hXi = iArr[0];
        GLES20.glBindTexture(3553, this.hXi);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.hXj = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.hXe = 5;
        this.hXg = bVar.hXg;
        this.hXh = System.nanoTime();
        synchronized (this.mReadyFence) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.mReadyFence.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.hXd.sendMessage(this.hXd.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.hXj}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.hXi}, 0);
        this.hXj = 0;
        this.hXi = 0;
        if (this.hWN == null || !this.hWN.isStarted()) {
            this.hXq = true;
            if (this.hXb != null) {
                this.hXb.requestStop();
            }
        }
        this.hXe = 4;
        this.hXd.sendMessage(this.hXd.obtainMessage(1));
        this.hXd.sendMessage(this.hXd.obtainMessage(5));
    }

    public void c(SurfaceTexture surfaceTexture) {
        synchronized (this.mReadyFence) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.hXd.sendMessage(this.hXd.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.hXi != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.hXj);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.hXi, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.hXd.sendMessage(this.hXd.obtainMessage(3, this.hXi, 0, null));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private class e extends Thread {
        public e(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (d.this.mReadyFence) {
                d.this.hXd = new HandlerC0262d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.hXd = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class HandlerC0262d extends Handler {
        private WeakReference<d> mWeakEncoder;

        public HandlerC0262d(d dVar) {
            this.mWeakEncoder = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.mWeakEncoder.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.handleStopRecording();
                        return;
                    case 2:
                        if (dVar.hXp) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.hXp) {
                            dVar.yH(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.hXp) {
                            dVar.handleUpdateSharedContext((EGLContext) message.obj);
                            return;
                        }
                        return;
                    case 5:
                        Looper.myLooper().quit();
                        return;
                    default:
                        throw new RuntimeException("Unhandled msg what=" + i);
                }
            }
            Log.w("TextureMovieEncoder", "VideoEncoderHandler.handleMessage: encoder is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        Log.d("TextureMovieEncoder", "handleStartRecording " + bVar);
        this.hXk = bVar;
        this.hXa = 0;
        a(bVar.hXt, bVar.mWidth, bVar.mHeight, bVar.guh, bVar.hnZ);
        this.hXq = false;
        if (this.hXf != null) {
            this.hXf.bDA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.hXi != 0) {
            try {
                this.hXb.ol(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.hXk.mWidth, this.hXk.mHeight);
            synchronized (d.class) {
                this.hWZ.drawFrame(this.mTextureId, fArr);
            }
            if (this.hWX != null) {
                this.hWX.setPresentationTime(bMI() * 1000);
                this.hWX.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.hXb.ol(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.hXq = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.hXo) {
            synchronized (this.hXn) {
                try {
                    this.hXn.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.hXo = false;
        if (this.hXf != null) {
            this.hXf.bDB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yH(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.hWX != null) {
            this.hWX.releaseEglSurface();
        }
        this.hWZ.release(false);
        if (this.hWY != null) {
            this.hWY.release();
        }
        this.hWY = new com.faceunity.gles.a(eGLContext, 1);
        if (this.hWX != null) {
            this.hWX.a(this.hWY);
            this.hWX.makeCurrent();
        }
        this.hWZ = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.hWN = new com.faceunity.a.c(file.toString());
            this.hXb = new com.faceunity.a.e(i, i2, i3, this.hWN);
            this.hXc = new com.faceunity.a.a(this.hWN);
            this.hXp = true;
            synchronized (this.hXl) {
                this.hXm = true;
                this.hXl.notify();
            }
        } catch (IOException e2) {
            if (this.hbC != null) {
                this.hbC.U(12, com.baidu.tieba.i.a.i(e2));
            }
        } catch (IllegalStateException e3) {
            this.hXp = false;
            if (this.hbC != null) {
                this.hbC.U(13, com.baidu.tieba.i.a.i(e3));
                return;
            }
            return;
        }
        this.hWY = new com.faceunity.gles.a(eGLContext, 1);
        this.hWX = new com.faceunity.gles.e(this.hWY, this.hXb.getInputSurface(), true);
        this.hWX.makeCurrent();
        this.hWZ = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.hXb.release();
            if (this.hWX != null) {
                this.hWX.release();
                this.hWX = null;
            }
            if (this.hWZ != null) {
                this.hWZ.release(false);
                this.hWZ = null;
            }
            if (this.hWY != null) {
                this.hWY.release();
                this.hWY = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.hbC != null) {
                this.hbC.U(14, com.baidu.tieba.i.a.i(e2));
            }
        }
    }

    /* loaded from: classes2.dex */
    private class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            synchronized (d.this.hXl) {
                while (!d.this.hXm) {
                    try {
                        d.this.hXl.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.hXm = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.bMH() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.hXe = 1;
                    while (!d.this.hXq) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.hXc.c(allocateDirect, read, d.this.bMI());
                                d.this.hXc.bMF();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.hXc.c(null, 0, d.this.bMI());
                    bVar.release();
                    d.this.hXc.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.hXn) {
                d.this.hXo = true;
                d.this.hXn.notify();
            }
        }
    }

    protected long bMI() {
        long nanoTime = System.nanoTime();
        if (this.hXg != 0) {
            if (this.hXh == 0) {
                this.hXh = nanoTime;
            }
            nanoTime = (nanoTime - this.hXh) + this.hXg;
        }
        long j = nanoTime / 1000;
        if (j < this.hXr) {
            j += this.hXr - j;
        }
        if (j == this.hXr) {
            j += 100;
        }
        this.hXr = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.hXf = cVar;
    }
}
