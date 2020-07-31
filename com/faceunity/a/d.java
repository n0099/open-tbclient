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
import com.baidu.mobstat.Config;
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
    private static final int[] ngt = {1, 0, 5, 7, 6};
    private int bIG;
    private int bsR;
    private h lOt;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private com.faceunity.gles.c ngA;
    private com.faceunity.a.e ngB;
    private com.faceunity.a.a ngC;
    private volatile HandlerC0819d ngD;
    private c ngF;
    private int ngI;
    private int ngJ;
    private b ngK;
    private final Object ngL;
    private boolean ngM;
    private final Object ngN;
    private boolean ngO;
    private boolean ngP;
    private boolean ngQ;
    private long ngR;
    private com.faceunity.a.c ngs;
    private com.faceunity.gles.e ngy;
    private com.faceunity.gles.a ngz;
    private Object ngE = new Object();
    private long ngG = 0;
    private long ngH = 0;

    /* loaded from: classes17.dex */
    public interface c {
        void JB();

        void drX();
    }

    public boolean JS(int i) {
        return this.bsR == i;
    }

    public d() {
        this.bsR = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.lOt = lVar.cGE();
        }
        this.ngK = null;
        this.ngL = new Object();
        this.ngM = false;
        this.ngN = new Object();
        this.ngO = false;
        this.ngP = false;
        this.ngQ = false;
        this.ngR = 0L;
        this.bsR = 2;
    }

    /* loaded from: classes17.dex */
    public static class b {
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final File mcf;
        final long ngG;
        final int ngT;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.mcf = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.ngT = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.ngG = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.ngT + " to '" + this.mcf.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.ngI = iArr[0];
        GLES20.glBindTexture(3553, this.ngI);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.ngJ = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.bsR = 5;
        this.ngG = bVar.ngG;
        this.ngH = System.nanoTime();
        synchronized (this.ngE) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.ngE.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.ngD.sendMessage(this.ngD.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.ngJ}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.ngI}, 0);
        this.ngJ = 0;
        this.ngI = 0;
        if (this.ngs == null || !this.ngs.isStarted()) {
            this.ngQ = true;
            if (this.ngB != null) {
                this.ngB.requestStop();
            }
        }
        this.bsR = 4;
        this.ngD.sendMessage(this.ngD.obtainMessage(1));
        this.ngD.sendMessage(this.ngD.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.ngE) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.ngD.sendMessage(this.ngD.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.ngI != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.ngJ);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.ngI, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.ngE) {
                if (this.mReady) {
                    this.ngD.sendMessage(this.ngD.obtainMessage(3, this.ngI, 0, null));
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
            synchronized (d.this.ngE) {
                d.this.ngD = new HandlerC0819d(d.this);
                d.this.mReady = true;
                d.this.ngE.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.ngE) {
                d.this.mReady = d.this.mRunning = false;
                d.this.ngD = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    private static class HandlerC0819d extends Handler {
        private WeakReference<d> ngU;

        public HandlerC0819d(d dVar) {
            this.ngU = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.ngU.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.My();
                        return;
                    case 2:
                        if (dVar.ngP) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.ngP) {
                            dVar.JT(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.ngP) {
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
        this.ngK = bVar;
        this.bIG = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.ngT, bVar.mcf);
        this.ngQ = false;
        if (this.ngF != null) {
            this.ngF.JB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.ngI != 0) {
            try {
                this.ngB.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.ngK.mWidth, this.ngK.mHeight);
            synchronized (d.class) {
                this.ngA.drawFrame(this.mTextureId, fArr);
            }
            if (this.ngy != null) {
                this.ngy.setPresentationTime(dKv() * 1000);
                this.ngy.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void My() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.ngB.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.ngQ = true;
        MG();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.ngO) {
            synchronized (this.ngN) {
                try {
                    this.ngN.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.ngO = false;
        if (this.ngF != null) {
            this.ngF.drX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JT(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.ngy != null) {
            this.ngy.releaseEglSurface();
        }
        this.ngA.release(false);
        if (this.ngz != null) {
            this.ngz.release();
        }
        this.ngz = new com.faceunity.gles.a(eGLContext, 1);
        if (this.ngy != null) {
            this.ngy.a(this.ngz);
            this.ngy.makeCurrent();
        }
        this.ngA = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.ngs = new com.faceunity.a.c(file.toString());
            this.ngB = new com.faceunity.a.e(i, i2, i3, this.ngs);
            this.ngC = new com.faceunity.a.a(this.ngs);
            this.ngP = true;
            synchronized (this.ngL) {
                this.ngM = true;
                this.ngL.notify();
            }
        } catch (IOException e2) {
            if (this.lOt != null) {
                this.lOt.bp(12, com.baidu.tieba.k.a.s(e2));
            }
        } catch (IllegalStateException e3) {
            this.ngP = false;
            if (this.lOt != null) {
                this.lOt.bp(13, com.baidu.tieba.k.a.s(e3));
                return;
            }
            return;
        }
        this.ngz = new com.faceunity.gles.a(eGLContext, 1);
        this.ngy = new com.faceunity.gles.e(this.ngz, this.ngB.getInputSurface(), true);
        this.ngy.makeCurrent();
        this.ngA = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void MG() {
        try {
            this.ngB.release();
            if (this.ngy != null) {
                this.ngy.release();
                this.ngy = null;
            }
            if (this.ngA != null) {
                this.ngA.release(false);
                this.ngA = null;
            }
            if (this.ngz != null) {
                this.ngz.release();
                this.ngz = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.lOt != null) {
                this.lOt.bp(14, com.baidu.tieba.k.a.s(e2));
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
            synchronized (d.this.ngL) {
                while (!d.this.ngM) {
                    try {
                        d.this.ngL.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.ngM = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.dKu() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.bsR = 1;
                    while (!d.this.ngQ) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.ngC.f(allocateDirect, e2, d.this.dKv());
                                d.this.ngC.dKt();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.ngC.f(null, 0, d.this.dKv());
                    bVar.release();
                    d.this.ngC.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.ngN) {
                d.this.ngO = true;
                d.this.ngN.notify();
            }
        }
    }

    protected long dKv() {
        long nanoTime = System.nanoTime();
        if (this.ngG != 0) {
            if (this.ngH == 0) {
                this.ngH = nanoTime;
            }
            nanoTime = (nanoTime - this.ngH) + this.ngG;
        }
        long j = nanoTime / 1000;
        if (j < this.ngR) {
            j += this.ngR - j;
        }
        if (j == this.ngR) {
            j += 100;
        }
        this.ngR = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.ngF = cVar;
    }
}
