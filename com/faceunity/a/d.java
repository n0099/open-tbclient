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
    private static final int[] hXe = {1, 0, 5, 7, 6};
    private final Object hXA;
    private boolean hXB;
    private boolean hXC;
    private boolean hXD;
    private long hXE;
    private com.faceunity.a.c hXa;
    private com.faceunity.gles.e hXk;
    private com.faceunity.gles.a hXl;
    private com.faceunity.gles.c hXm;
    private int hXn;
    private com.faceunity.a.e hXo;
    private com.faceunity.a.a hXp;
    private volatile HandlerC0261d hXq;
    private int hXr;
    private c hXs;
    private int hXv;
    private int hXw;
    private b hXx;
    private final Object hXy;
    private boolean hXz;
    private h hbR;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long hXt = 0;
    private long hXu = 0;

    /* loaded from: classes2.dex */
    public interface c {
        void bDB();

        void bDC();
    }

    public boolean yF(int i) {
        return this.hXr == i;
    }

    public d() {
        this.hXr = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.hbR = kVar.aXg();
        }
        this.hXx = null;
        this.hXy = new Object();
        this.hXz = false;
        this.hXA = new Object();
        this.hXB = false;
        this.hXC = false;
        this.hXD = false;
        this.hXE = 0L;
        this.hXr = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final int gus;
        final EGLContext hXG;
        final long hXt;
        final File hom;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.hom = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.gus = i3;
            if (eGLContext != null) {
                this.hXG = eGLContext;
            } else {
                this.hXG = EGL14.eglGetCurrentContext();
            }
            this.hXt = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Constants.MSG_SDK_LUA_BRIDGE_ACCELERATION_X + this.mHeight + " @" + this.gus + " to '" + this.hom.toString() + "' ctxt=" + this.hXG;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.hXv = iArr[0];
        GLES20.glBindTexture(3553, this.hXv);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.hXw = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.hXr = 5;
        this.hXt = bVar.hXt;
        this.hXu = System.nanoTime();
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
            this.hXq.sendMessage(this.hXq.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.hXw}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.hXv}, 0);
        this.hXw = 0;
        this.hXv = 0;
        if (this.hXa == null || !this.hXa.isStarted()) {
            this.hXD = true;
            if (this.hXo != null) {
                this.hXo.requestStop();
            }
        }
        this.hXr = 4;
        this.hXq.sendMessage(this.hXq.obtainMessage(1));
        this.hXq.sendMessage(this.hXq.obtainMessage(5));
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
                    this.hXq.sendMessage(this.hXq.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.hXv != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.hXw);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.hXv, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.hXq.sendMessage(this.hXq.obtainMessage(3, this.hXv, 0, null));
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
                d.this.hXq = new HandlerC0261d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.hXq = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class HandlerC0261d extends Handler {
        private WeakReference<d> mWeakEncoder;

        public HandlerC0261d(d dVar) {
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
                        if (dVar.hXC) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.hXC) {
                            dVar.yG(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.hXC) {
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
        this.hXx = bVar;
        this.hXn = 0;
        a(bVar.hXG, bVar.mWidth, bVar.mHeight, bVar.gus, bVar.hom);
        this.hXD = false;
        if (this.hXs != null) {
            this.hXs.bDB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.hXv != 0) {
            try {
                this.hXo.ol(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.hXx.mWidth, this.hXx.mHeight);
            synchronized (d.class) {
                this.hXm.drawFrame(this.mTextureId, fArr);
            }
            if (this.hXk != null) {
                this.hXk.setPresentationTime(bMJ() * 1000);
                this.hXk.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.hXo.ol(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.hXD = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.hXB) {
            synchronized (this.hXA) {
                try {
                    this.hXA.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.hXB = false;
        if (this.hXs != null) {
            this.hXs.bDC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yG(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.hXk != null) {
            this.hXk.releaseEglSurface();
        }
        this.hXm.release(false);
        if (this.hXl != null) {
            this.hXl.release();
        }
        this.hXl = new com.faceunity.gles.a(eGLContext, 1);
        if (this.hXk != null) {
            this.hXk.a(this.hXl);
            this.hXk.makeCurrent();
        }
        this.hXm = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.hXa = new com.faceunity.a.c(file.toString());
            this.hXo = new com.faceunity.a.e(i, i2, i3, this.hXa);
            this.hXp = new com.faceunity.a.a(this.hXa);
            this.hXC = true;
            synchronized (this.hXy) {
                this.hXz = true;
                this.hXy.notify();
            }
        } catch (IOException e2) {
            if (this.hbR != null) {
                this.hbR.U(12, com.baidu.tieba.i.a.i(e2));
            }
        } catch (IllegalStateException e3) {
            this.hXC = false;
            if (this.hbR != null) {
                this.hbR.U(13, com.baidu.tieba.i.a.i(e3));
                return;
            }
            return;
        }
        this.hXl = new com.faceunity.gles.a(eGLContext, 1);
        this.hXk = new com.faceunity.gles.e(this.hXl, this.hXo.getInputSurface(), true);
        this.hXk.makeCurrent();
        this.hXm = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.hXo.release();
            if (this.hXk != null) {
                this.hXk.release();
                this.hXk = null;
            }
            if (this.hXm != null) {
                this.hXm.release(false);
                this.hXm = null;
            }
            if (this.hXl != null) {
                this.hXl.release();
                this.hXl = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.hbR != null) {
                this.hbR.U(14, com.baidu.tieba.i.a.i(e2));
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
            synchronized (d.this.hXy) {
                while (!d.this.hXz) {
                    try {
                        d.this.hXy.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.hXz = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.bMI() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.hXr = 1;
                    while (!d.this.hXD) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.hXp.c(allocateDirect, read, d.this.bMJ());
                                d.this.hXp.bMG();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.hXp.c(null, 0, d.this.bMJ());
                    bVar.release();
                    d.this.hXp.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.hXA) {
                d.this.hXB = true;
                d.this.hXA.notify();
            }
        }
    }

    protected long bMJ() {
        long nanoTime = System.nanoTime();
        if (this.hXt != 0) {
            if (this.hXu == 0) {
                this.hXu = nanoTime;
            }
            nanoTime = (nanoTime - this.hXu) + this.hXt;
        }
        long j = nanoTime / 1000;
        if (j < this.hXE) {
            j += this.hXE - j;
        }
        if (j == this.hXE) {
            j += 100;
        }
        this.hXE = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.hXs = cVar;
    }
}
