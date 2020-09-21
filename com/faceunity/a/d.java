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
/* loaded from: classes22.dex */
public class d {
    private static final int[] nKz = {1, 0, 5, 7, 6};
    private int bCe;
    private int bQl;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private h mpU;
    private com.faceunity.gles.e nKE;
    private com.faceunity.gles.a nKF;
    private com.faceunity.gles.c nKG;
    private com.faceunity.a.e nKH;
    private com.faceunity.a.a nKI;
    private volatile HandlerC0874d nKJ;
    private c nKL;
    private int nKO;
    private int nKP;
    private b nKQ;
    private final Object nKR;
    private boolean nKS;
    private final Object nKT;
    private boolean nKU;
    private boolean nKV;
    private boolean nKW;
    private long nKX;
    private com.faceunity.a.c nKy;
    private Object nKK = new Object();
    private long nKM = 0;
    private long nKN = 0;

    /* loaded from: classes22.dex */
    public interface c {
        void Qb();

        void dHw();
    }

    public boolean Nb(int i) {
        return this.bCe == i;
    }

    public d() {
        this.bCe = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mpU = lVar.cVa();
        }
        this.nKQ = null;
        this.nKR = new Object();
        this.nKS = false;
        this.nKT = new Object();
        this.nKU = false;
        this.nKV = false;
        this.nKW = false;
        this.nKX = 0L;
        this.bCe = 2;
    }

    /* loaded from: classes22.dex */
    public static class b {
        final File mDV;
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final long nKM;
        final int nKZ;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.mDV = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.nKZ = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.nKM = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.nKZ + " to '" + this.mDV.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.nKO = iArr[0];
        GLES20.glBindTexture(3553, this.nKO);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.nKP = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.bCe = 5;
        this.nKM = bVar.nKM;
        this.nKN = System.nanoTime();
        synchronized (this.nKK) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.nKK.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.nKJ.sendMessage(this.nKJ.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.nKP}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.nKO}, 0);
        this.nKP = 0;
        this.nKO = 0;
        if (this.nKy == null || !this.nKy.isStarted()) {
            this.nKW = true;
            if (this.nKH != null) {
                this.nKH.requestStop();
            }
        }
        this.bCe = 4;
        this.nKJ.sendMessage(this.nKJ.obtainMessage(1));
        this.nKJ.sendMessage(this.nKJ.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.nKK) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.nKJ.sendMessage(this.nKJ.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.nKO != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.nKP);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.nKO, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.nKK) {
                if (this.mReady) {
                    this.nKJ.sendMessage(this.nKJ.obtainMessage(3, this.nKO, 0, null));
                }
            }
        }
    }

    /* loaded from: classes22.dex */
    private class e extends Thread {
        public e(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (d.this.nKK) {
                d.this.nKJ = new HandlerC0874d(d.this);
                d.this.mReady = true;
                d.this.nKK.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.nKK) {
                d.this.mReady = d.this.mRunning = false;
                d.this.nKJ = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    private static class HandlerC0874d extends Handler {
        private WeakReference<d> nLa;

        public HandlerC0874d(d dVar) {
            this.nLa = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.nLa.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.To();
                        return;
                    case 2:
                        if (dVar.nKV) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.nKV) {
                            dVar.Nc(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.nKV) {
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
        this.nKQ = bVar;
        this.bQl = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.nKZ, bVar.mDV);
        this.nKW = false;
        if (this.nKL != null) {
            this.nKL.Qb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.nKO != 0) {
            try {
                this.nKH.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.nKQ.mWidth, this.nKQ.mHeight);
            synchronized (d.class) {
                this.nKG.drawFrame(this.mTextureId, fArr);
            }
            if (this.nKE != null) {
                this.nKE.setPresentationTime(eaC() * 1000);
                this.nKE.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void To() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.nKH.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.nKW = true;
        Tw();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.nKU) {
            synchronized (this.nKT) {
                try {
                    this.nKT.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.nKU = false;
        if (this.nKL != null) {
            this.nKL.dHw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nc(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.nKE != null) {
            this.nKE.releaseEglSurface();
        }
        this.nKG.release(false);
        if (this.nKF != null) {
            this.nKF.release();
        }
        this.nKF = new com.faceunity.gles.a(eGLContext, 1);
        if (this.nKE != null) {
            this.nKE.a(this.nKF);
            this.nKE.makeCurrent();
        }
        this.nKG = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.nKy = new com.faceunity.a.c(file.toString());
            this.nKH = new com.faceunity.a.e(i, i2, i3, this.nKy);
            this.nKI = new com.faceunity.a.a(this.nKy);
            this.nKV = true;
            synchronized (this.nKR) {
                this.nKS = true;
                this.nKR.notify();
            }
        } catch (IOException e2) {
            if (this.mpU != null) {
                this.mpU.bq(12, com.baidu.tieba.k.a.r(e2));
            }
        } catch (IllegalStateException e3) {
            this.nKV = false;
            if (this.mpU != null) {
                this.mpU.bq(13, com.baidu.tieba.k.a.r(e3));
                return;
            }
            return;
        }
        this.nKF = new com.faceunity.gles.a(eGLContext, 1);
        this.nKE = new com.faceunity.gles.e(this.nKF, this.nKH.getInputSurface(), true);
        this.nKE.makeCurrent();
        this.nKG = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void Tw() {
        try {
            this.nKH.release();
            if (this.nKE != null) {
                this.nKE.release();
                this.nKE = null;
            }
            if (this.nKG != null) {
                this.nKG.release(false);
                this.nKG = null;
            }
            if (this.nKF != null) {
                this.nKF.release();
                this.nKF = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.mpU != null) {
                this.mpU.bq(14, com.baidu.tieba.k.a.r(e2));
            }
        }
    }

    /* loaded from: classes22.dex */
    private class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            synchronized (d.this.nKR) {
                while (!d.this.nKS) {
                    try {
                        d.this.nKR.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.nKS = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.eaB() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.bCe = 1;
                    while (!d.this.nKW) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.nKI.f(allocateDirect, e2, d.this.eaC());
                                d.this.nKI.eaA();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.nKI.f(null, 0, d.this.eaC());
                    bVar.release();
                    d.this.nKI.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.nKT) {
                d.this.nKU = true;
                d.this.nKT.notify();
            }
        }
    }

    protected long eaC() {
        long nanoTime = System.nanoTime();
        if (this.nKM != 0) {
            if (this.nKN == 0) {
                this.nKN = nanoTime;
            }
            nanoTime = (nanoTime - this.nKN) + this.nKM;
        }
        long j = nanoTime / 1000;
        if (j < this.nKX) {
            j += this.nKX - j;
        }
        if (j == this.nKX) {
            j += 100;
        }
        this.nKX = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.nKL = cVar;
    }
}
