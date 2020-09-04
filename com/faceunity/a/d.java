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
    private static final int[] nAC = {1, 0, 5, 7, 6};
    private int bOl;
    private int byH;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private h mgu;
    private com.faceunity.a.c nAB;
    private com.faceunity.gles.e nAH;
    private com.faceunity.gles.a nAI;
    private com.faceunity.gles.c nAJ;
    private com.faceunity.a.e nAK;
    private com.faceunity.a.a nAL;
    private volatile HandlerC0877d nAM;
    private c nAO;
    private int nAR;
    private int nAS;
    private b nAT;
    private final Object nAU;
    private boolean nAV;
    private final Object nAW;
    private boolean nAX;
    private boolean nAY;
    private boolean nAZ;
    private long nBa;
    private Object nAN = new Object();
    private long nAP = 0;
    private long nAQ = 0;

    /* loaded from: classes17.dex */
    public interface c {
        void Pt();

        void dDC();
    }

    public boolean Mw(int i) {
        return this.byH == i;
    }

    public d() {
        this.byH = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mgu = lVar.cRu();
        }
        this.nAT = null;
        this.nAU = new Object();
        this.nAV = false;
        this.nAW = new Object();
        this.nAX = false;
        this.nAY = false;
        this.nAZ = false;
        this.nBa = 0L;
        this.byH = 2;
    }

    /* loaded from: classes17.dex */
    public static class b {
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final File muk;
        final long nAP;
        final int nBc;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.muk = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.nBc = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.nAP = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.nBc + " to '" + this.muk.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.nAR = iArr[0];
        GLES20.glBindTexture(3553, this.nAR);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.nAS = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.byH = 5;
        this.nAP = bVar.nAP;
        this.nAQ = System.nanoTime();
        synchronized (this.nAN) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.nAN.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.nAM.sendMessage(this.nAM.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.nAS}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.nAR}, 0);
        this.nAS = 0;
        this.nAR = 0;
        if (this.nAB == null || !this.nAB.isStarted()) {
            this.nAZ = true;
            if (this.nAK != null) {
                this.nAK.requestStop();
            }
        }
        this.byH = 4;
        this.nAM.sendMessage(this.nAM.obtainMessage(1));
        this.nAM.sendMessage(this.nAM.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.nAN) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.nAM.sendMessage(this.nAM.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.nAR != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.nAS);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.nAR, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.nAN) {
                if (this.mReady) {
                    this.nAM.sendMessage(this.nAM.obtainMessage(3, this.nAR, 0, null));
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
            synchronized (d.this.nAN) {
                d.this.nAM = new HandlerC0877d(d.this);
                d.this.mReady = true;
                d.this.nAN.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.nAN) {
                d.this.mReady = d.this.mRunning = false;
                d.this.nAM = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    private static class HandlerC0877d extends Handler {
        private WeakReference<d> nBd;

        public HandlerC0877d(d dVar) {
            this.nBd = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.nBd.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.Sx();
                        return;
                    case 2:
                        if (dVar.nAY) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.nAY) {
                            dVar.Mx(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.nAY) {
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
        this.nAT = bVar;
        this.bOl = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.nBc, bVar.muk);
        this.nAZ = false;
        if (this.nAO != null) {
            this.nAO.Pt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.nAR != 0) {
            try {
                this.nAK.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.nAT.mWidth, this.nAT.mHeight);
            synchronized (d.class) {
                this.nAJ.drawFrame(this.mTextureId, fArr);
            }
            if (this.nAH != null) {
                this.nAH.setPresentationTime(dWE() * 1000);
                this.nAH.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sx() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.nAK.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.nAZ = true;
        SF();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.nAX) {
            synchronized (this.nAW) {
                try {
                    this.nAW.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.nAX = false;
        if (this.nAO != null) {
            this.nAO.dDC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mx(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.nAH != null) {
            this.nAH.releaseEglSurface();
        }
        this.nAJ.release(false);
        if (this.nAI != null) {
            this.nAI.release();
        }
        this.nAI = new com.faceunity.gles.a(eGLContext, 1);
        if (this.nAH != null) {
            this.nAH.a(this.nAI);
            this.nAH.makeCurrent();
        }
        this.nAJ = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.nAB = new com.faceunity.a.c(file.toString());
            this.nAK = new com.faceunity.a.e(i, i2, i3, this.nAB);
            this.nAL = new com.faceunity.a.a(this.nAB);
            this.nAY = true;
            synchronized (this.nAU) {
                this.nAV = true;
                this.nAU.notify();
            }
        } catch (IOException e2) {
            if (this.mgu != null) {
                this.mgu.bm(12, com.baidu.tieba.k.a.r(e2));
            }
        } catch (IllegalStateException e3) {
            this.nAY = false;
            if (this.mgu != null) {
                this.mgu.bm(13, com.baidu.tieba.k.a.r(e3));
                return;
            }
            return;
        }
        this.nAI = new com.faceunity.gles.a(eGLContext, 1);
        this.nAH = new com.faceunity.gles.e(this.nAI, this.nAK.getInputSurface(), true);
        this.nAH.makeCurrent();
        this.nAJ = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void SF() {
        try {
            this.nAK.release();
            if (this.nAH != null) {
                this.nAH.release();
                this.nAH = null;
            }
            if (this.nAJ != null) {
                this.nAJ.release(false);
                this.nAJ = null;
            }
            if (this.nAI != null) {
                this.nAI.release();
                this.nAI = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.mgu != null) {
                this.mgu.bm(14, com.baidu.tieba.k.a.r(e2));
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
            synchronized (d.this.nAU) {
                while (!d.this.nAV) {
                    try {
                        d.this.nAU.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.nAV = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.dWD() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.byH = 1;
                    while (!d.this.nAZ) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.nAL.f(allocateDirect, e2, d.this.dWE());
                                d.this.nAL.dWC();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.nAL.f(null, 0, d.this.dWE());
                    bVar.release();
                    d.this.nAL.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.nAW) {
                d.this.nAX = true;
                d.this.nAW.notify();
            }
        }
    }

    protected long dWE() {
        long nanoTime = System.nanoTime();
        if (this.nAP != 0) {
            if (this.nAQ == 0) {
                this.nAQ = nanoTime;
            }
            nanoTime = (nanoTime - this.nAQ) + this.nAP;
        }
        long j = nanoTime / 1000;
        if (j < this.nBa) {
            j += this.nBa - j;
        }
        if (j == this.nBa) {
            j += 100;
        }
        this.nBa = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.nAO = cVar;
    }
}
