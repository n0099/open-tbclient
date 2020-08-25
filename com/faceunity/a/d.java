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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.k.h;
import com.baidu.tieba.k.l;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes17.dex */
public class d {
    private static final int[] nAk = {1, 0, 5, 7, 6};
    private int bOh;
    private int byE;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private h mgf;
    private int nAA;
    private b nAB;
    private final Object nAC;
    private boolean nAD;
    private final Object nAE;
    private boolean nAF;
    private boolean nAG;
    private boolean nAH;
    private long nAI;
    private com.faceunity.a.c nAj;
    private com.faceunity.gles.e nAp;
    private com.faceunity.gles.a nAq;
    private com.faceunity.gles.c nAr;
    private com.faceunity.a.e nAs;
    private com.faceunity.a.a nAt;
    private volatile HandlerC0877d nAu;
    private c nAw;
    private int nAz;
    private Object nAv = new Object();
    private long nAx = 0;
    private long nAy = 0;

    /* loaded from: classes17.dex */
    public interface c {
        void Pt();

        void dDt();
    }

    public boolean Mw(int i) {
        return this.byE == i;
    }

    public d() {
        this.byE = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mgf = lVar.cRt();
        }
        this.nAB = null;
        this.nAC = new Object();
        this.nAD = false;
        this.nAE = new Object();
        this.nAF = false;
        this.nAG = false;
        this.nAH = false;
        this.nAI = 0L;
        this.byE = 2;
    }

    /* loaded from: classes17.dex */
    public static class b {
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final File mtS;
        final int nAK;
        final long nAx;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.mtS = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.nAK = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.nAx = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.nAK + " to '" + this.mtS.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.nAz = iArr[0];
        GLES20.glBindTexture(3553, this.nAz);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.nAA = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.byE = 5;
        this.nAx = bVar.nAx;
        this.nAy = System.nanoTime();
        synchronized (this.nAv) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.nAv.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.nAu.sendMessage(this.nAu.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.nAA}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.nAz}, 0);
        this.nAA = 0;
        this.nAz = 0;
        if (this.nAj == null || !this.nAj.isStarted()) {
            this.nAH = true;
            if (this.nAs != null) {
                this.nAs.requestStop();
            }
        }
        this.byE = 4;
        this.nAu.sendMessage(this.nAu.obtainMessage(1));
        this.nAu.sendMessage(this.nAu.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.nAv) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.nAu.sendMessage(this.nAu.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.nAz != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.nAA);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.nAz, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.nAv) {
                if (this.mReady) {
                    this.nAu.sendMessage(this.nAu.obtainMessage(3, this.nAz, 0, null));
                }
            }
        }
    }

    /* loaded from: classes17.dex */
    private class e extends Thread {
        public e(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (d.this.nAv) {
                d.this.nAu = new HandlerC0877d(d.this);
                d.this.mReady = true;
                d.this.nAv.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.nAv) {
                d.this.mReady = d.this.mRunning = false;
                d.this.nAu = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    private static class HandlerC0877d extends Handler {
        private WeakReference<d> nAL;

        public HandlerC0877d(d dVar) {
            this.nAL = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.nAL.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.Sx();
                        return;
                    case 2:
                        if (dVar.nAG) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.nAG) {
                            dVar.Mx(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.nAG) {
                            dVar.c((EGLContext) message.obj);
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
        this.nAB = bVar;
        this.bOh = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.nAK, bVar.mtS);
        this.nAH = false;
        if (this.nAw != null) {
            this.nAw.Pt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.nAz != 0) {
            try {
                this.nAs.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.nAB.mWidth, this.nAB.mHeight);
            synchronized (d.class) {
                this.nAr.drawFrame(this.mTextureId, fArr);
            }
            if (this.nAp != null) {
                this.nAp.setPresentationTime(dWv() * 1000);
                this.nAp.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sx() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.nAs.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.nAH = true;
        SF();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.nAF) {
            synchronized (this.nAE) {
                try {
                    this.nAE.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.nAF = false;
        if (this.nAw != null) {
            this.nAw.dDt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mx(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.nAp != null) {
            this.nAp.releaseEglSurface();
        }
        this.nAr.release(false);
        if (this.nAq != null) {
            this.nAq.release();
        }
        this.nAq = new com.faceunity.gles.a(eGLContext, 1);
        if (this.nAp != null) {
            this.nAp.a(this.nAq);
            this.nAp.makeCurrent();
        }
        this.nAr = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.nAj = new com.faceunity.a.c(file.toString());
            this.nAs = new com.faceunity.a.e(i, i2, i3, this.nAj);
            this.nAt = new com.faceunity.a.a(this.nAj);
            this.nAG = true;
            synchronized (this.nAC) {
                this.nAD = true;
                this.nAC.notify();
            }
        } catch (IOException e2) {
            if (this.mgf != null) {
                this.mgf.bn(12, com.baidu.tieba.k.a.r(e2));
            }
        } catch (IllegalStateException e3) {
            this.nAG = false;
            if (this.mgf != null) {
                this.mgf.bn(13, com.baidu.tieba.k.a.r(e3));
                return;
            }
            return;
        }
        this.nAq = new com.faceunity.gles.a(eGLContext, 1);
        this.nAp = new com.faceunity.gles.e(this.nAq, this.nAs.getInputSurface(), true);
        this.nAp.makeCurrent();
        this.nAr = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void SF() {
        try {
            this.nAs.release();
            if (this.nAp != null) {
                this.nAp.release();
                this.nAp = null;
            }
            if (this.nAr != null) {
                this.nAr.release(false);
                this.nAr = null;
            }
            if (this.nAq != null) {
                this.nAq.release();
                this.nAq = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.mgf != null) {
                this.mgf.bn(14, com.baidu.tieba.k.a.r(e2));
            }
        }
    }

    /* loaded from: classes17.dex */
    private class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            synchronized (d.this.nAC) {
                while (!d.this.nAD) {
                    try {
                        d.this.nAC.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.nAD = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.dWu() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.byE = 1;
                    while (!d.this.nAH) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.nAt.f(allocateDirect, e2, d.this.dWv());
                                d.this.nAt.dWt();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.nAt.f(null, 0, d.this.dWv());
                    bVar.release();
                    d.this.nAt.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.nAE) {
                d.this.nAF = true;
                d.this.nAE.notify();
            }
        }
    }

    protected long dWv() {
        long nanoTime = System.nanoTime();
        if (this.nAx != 0) {
            if (this.nAy == 0) {
                this.nAy = nanoTime;
            }
            nanoTime = (nanoTime - this.nAy) + this.nAx;
        }
        long j = nanoTime / 1000;
        if (j < this.nAI) {
            j += this.nAI - j;
        }
        if (j == this.nAI) {
            j += 100;
        }
        this.nAI = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.nAw = cVar;
    }
}
