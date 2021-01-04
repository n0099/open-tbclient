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
import com.baidu.tieba.l.g;
import com.baidu.tieba.l.k;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes8.dex */
public class d {
    private static final int[] pGv = {1, 0, 5, 7, 6};
    private int cha;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private g nsP;
    private com.faceunity.gles.e pGA;
    private com.faceunity.gles.a pGB;
    private com.faceunity.gles.c pGC;
    private int pGD;
    private com.faceunity.a.e pGE;
    private com.faceunity.a.a pGF;
    private volatile HandlerC1027d pGG;
    private c pGI;
    private int pGL;
    private int pGM;
    private b pGN;
    private final Object pGO;
    private boolean pGP;
    private final Object pGQ;
    private boolean pGR;
    private boolean pGS;
    private boolean pGT;
    private long pGU;
    private com.faceunity.a.c pGu;
    private Object pGH = new Object();
    private long pGJ = 0;
    private long pGK = 0;

    /* loaded from: classes8.dex */
    public interface c {
        void XU();

        void dVO();
    }

    public boolean Ro(int i) {
        return this.cha == i;
    }

    public d() {
        this.cha = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.nsP = kVar.diP();
        }
        this.pGN = null;
        this.pGO = new Object();
        this.pGP = false;
        this.pGQ = new Object();
        this.pGR = false;
        this.pGS = false;
        this.pGT = false;
        this.pGU = 0L;
        this.cha = 2;
    }

    /* loaded from: classes8.dex */
    public static class b {
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final File nFy;
        final long pGJ;
        final int pGW;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.nFy = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.pGW = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.pGJ = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.pGW + " to '" + this.nFy.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.pGL = iArr[0];
        GLES20.glBindTexture(3553, this.pGL);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.pGM = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.cha = 5;
        this.pGJ = bVar.pGJ;
        this.pGK = System.nanoTime();
        synchronized (this.pGH) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.pGH.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.pGG.sendMessage(this.pGG.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.pGM}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.pGL}, 0);
        this.pGM = 0;
        this.pGL = 0;
        if (this.pGu == null || !this.pGu.isStarted()) {
            this.pGT = true;
            if (this.pGE != null) {
                this.pGE.requestStop();
            }
        }
        this.cha = 4;
        this.pGG.sendMessage(this.pGG.obtainMessage(1));
        this.pGG.sendMessage(this.pGG.obtainMessage(5));
    }

    public void d(SurfaceTexture surfaceTexture) {
        synchronized (this.pGH) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.pGG.sendMessage(this.pGG.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.pGL != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.pGM);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.pGL, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.pGH) {
                if (this.mReady) {
                    this.pGG.sendMessage(this.pGG.obtainMessage(3, this.pGL, 0, null));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    private class e extends Thread {
        public e(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (d.this.pGH) {
                d.this.pGG = new HandlerC1027d(d.this);
                d.this.mReady = true;
                d.this.pGH.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.pGH) {
                d.this.mReady = d.this.mRunning = false;
                d.this.pGG = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class HandlerC1027d extends Handler {
        private WeakReference<d> pGX;

        public HandlerC1027d(d dVar) {
            this.pGX = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.pGX.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.adf();
                        return;
                    case 2:
                        if (dVar.pGS) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.pGS) {
                            dVar.Rp(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.pGS) {
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
        this.pGN = bVar;
        this.pGD = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.pGW, bVar.nFy);
        this.pGT = false;
        if (this.pGI != null) {
            this.pGI.XU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.pGL != 0) {
            try {
                this.pGE.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.pGN.mWidth, this.pGN.mHeight);
            synchronized (d.class) {
                this.pGC.drawFrame(this.mTextureId, fArr);
            }
            if (this.pGA != null) {
                this.pGA.setPresentationTime(eBi() * 1000);
                this.pGA.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adf() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.pGE.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.pGT = true;
        adn();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.pGR) {
            synchronized (this.pGQ) {
                try {
                    this.pGQ.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.pGR = false;
        if (this.pGI != null) {
            this.pGI.dVO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rp(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.pGA != null) {
            this.pGA.releaseEglSurface();
        }
        this.pGC.release(false);
        if (this.pGB != null) {
            this.pGB.release();
        }
        this.pGB = new com.faceunity.gles.a(eGLContext, 1);
        if (this.pGA != null) {
            this.pGA.a(this.pGB);
            this.pGA.makeCurrent();
        }
        this.pGC = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.pGu = new com.faceunity.a.c(file.toString());
            this.pGE = new com.faceunity.a.e(i, i2, i3, this.pGu);
            this.pGF = new com.faceunity.a.a(this.pGu);
            this.pGS = true;
            synchronized (this.pGO) {
                this.pGP = true;
                this.pGO.notify();
            }
        } catch (IOException e2) {
            if (this.nsP != null) {
                this.nsP.bD(12, com.baidu.tieba.l.a.p(e2));
            }
        } catch (IllegalStateException e3) {
            this.pGS = false;
            if (this.nsP != null) {
                this.nsP.bD(13, com.baidu.tieba.l.a.p(e3));
                return;
            }
            return;
        }
        this.pGB = new com.faceunity.gles.a(eGLContext, 1);
        this.pGA = new com.faceunity.gles.e(this.pGB, this.pGE.getInputSurface(), true);
        this.pGA.makeCurrent();
        this.pGC = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void adn() {
        try {
            this.pGE.release();
            if (this.pGA != null) {
                this.pGA.release();
                this.pGA = null;
            }
            if (this.pGC != null) {
                this.pGC.release(false);
                this.pGC = null;
            }
            if (this.pGB != null) {
                this.pGB.release();
                this.pGB = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.nsP != null) {
                this.nsP.bD(14, com.baidu.tieba.l.a.p(e2));
            }
        }
    }

    /* loaded from: classes8.dex */
    private class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            synchronized (d.this.pGO) {
                while (!d.this.pGP) {
                    try {
                        d.this.pGO.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.pGP = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.eBh() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.cha = 1;
                    while (!d.this.pGT) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.pGF.f(allocateDirect, e2, d.this.eBi());
                                d.this.pGF.eBg();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.pGF.f(null, 0, d.this.eBi());
                    bVar.release();
                    d.this.pGF.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.pGQ) {
                d.this.pGR = true;
                d.this.pGQ.notify();
            }
        }
    }

    protected long eBi() {
        long nanoTime = System.nanoTime();
        if (this.pGJ != 0) {
            if (this.pGK == 0) {
                this.pGK = nanoTime;
            }
            nanoTime = (nanoTime - this.pGK) + this.pGJ;
        }
        long j = nanoTime / 1000;
        if (j < this.pGU) {
            j += this.pGU - j;
        }
        if (j == this.pGU) {
            j += 100;
        }
        this.pGU = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.pGI = cVar;
    }
}
