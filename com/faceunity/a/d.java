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
    private static final int[] ngv = {1, 0, 5, 7, 6};
    private int bIG;
    private int bsR;
    private h lOv;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private com.faceunity.gles.e ngA;
    private com.faceunity.gles.a ngB;
    private com.faceunity.gles.c ngC;
    private com.faceunity.a.e ngD;
    private com.faceunity.a.a ngE;
    private volatile HandlerC0819d ngF;
    private c ngH;
    private int ngK;
    private int ngL;
    private b ngM;
    private final Object ngN;
    private boolean ngO;
    private final Object ngP;
    private boolean ngQ;
    private boolean ngR;
    private boolean ngS;
    private long ngT;
    private com.faceunity.a.c ngu;
    private Object ngG = new Object();
    private long ngI = 0;
    private long ngJ = 0;

    /* loaded from: classes17.dex */
    public interface c {
        void JB();

        void drY();
    }

    public boolean JS(int i) {
        return this.bsR == i;
    }

    public d() {
        this.bsR = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.lOv = lVar.cGE();
        }
        this.ngM = null;
        this.ngN = new Object();
        this.ngO = false;
        this.ngP = new Object();
        this.ngQ = false;
        this.ngR = false;
        this.ngS = false;
        this.ngT = 0L;
        this.bsR = 2;
    }

    /* loaded from: classes17.dex */
    public static class b {
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final File mch;
        final long ngI;
        final int ngV;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.mch = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.ngV = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.ngI = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.ngV + " to '" + this.mch.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.ngK = iArr[0];
        GLES20.glBindTexture(3553, this.ngK);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.ngL = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.bsR = 5;
        this.ngI = bVar.ngI;
        this.ngJ = System.nanoTime();
        synchronized (this.ngG) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.ngG.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.ngF.sendMessage(this.ngF.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.ngL}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.ngK}, 0);
        this.ngL = 0;
        this.ngK = 0;
        if (this.ngu == null || !this.ngu.isStarted()) {
            this.ngS = true;
            if (this.ngD != null) {
                this.ngD.requestStop();
            }
        }
        this.bsR = 4;
        this.ngF.sendMessage(this.ngF.obtainMessage(1));
        this.ngF.sendMessage(this.ngF.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.ngG) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.ngF.sendMessage(this.ngF.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.ngK != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.ngL);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.ngK, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.ngG) {
                if (this.mReady) {
                    this.ngF.sendMessage(this.ngF.obtainMessage(3, this.ngK, 0, null));
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
            synchronized (d.this.ngG) {
                d.this.ngF = new HandlerC0819d(d.this);
                d.this.mReady = true;
                d.this.ngG.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.ngG) {
                d.this.mReady = d.this.mRunning = false;
                d.this.ngF = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    private static class HandlerC0819d extends Handler {
        private WeakReference<d> ngW;

        public HandlerC0819d(d dVar) {
            this.ngW = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.ngW.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.My();
                        return;
                    case 2:
                        if (dVar.ngR) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.ngR) {
                            dVar.JT(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.ngR) {
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
        this.ngM = bVar;
        this.bIG = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.ngV, bVar.mch);
        this.ngS = false;
        if (this.ngH != null) {
            this.ngH.JB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.ngK != 0) {
            try {
                this.ngD.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.ngM.mWidth, this.ngM.mHeight);
            synchronized (d.class) {
                this.ngC.drawFrame(this.mTextureId, fArr);
            }
            if (this.ngA != null) {
                this.ngA.setPresentationTime(dKw() * 1000);
                this.ngA.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void My() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.ngD.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.ngS = true;
        MG();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.ngQ) {
            synchronized (this.ngP) {
                try {
                    this.ngP.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.ngQ = false;
        if (this.ngH != null) {
            this.ngH.drY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JT(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.ngA != null) {
            this.ngA.releaseEglSurface();
        }
        this.ngC.release(false);
        if (this.ngB != null) {
            this.ngB.release();
        }
        this.ngB = new com.faceunity.gles.a(eGLContext, 1);
        if (this.ngA != null) {
            this.ngA.a(this.ngB);
            this.ngA.makeCurrent();
        }
        this.ngC = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.ngu = new com.faceunity.a.c(file.toString());
            this.ngD = new com.faceunity.a.e(i, i2, i3, this.ngu);
            this.ngE = new com.faceunity.a.a(this.ngu);
            this.ngR = true;
            synchronized (this.ngN) {
                this.ngO = true;
                this.ngN.notify();
            }
        } catch (IOException e2) {
            if (this.lOv != null) {
                this.lOv.bp(12, com.baidu.tieba.k.a.s(e2));
            }
        } catch (IllegalStateException e3) {
            this.ngR = false;
            if (this.lOv != null) {
                this.lOv.bp(13, com.baidu.tieba.k.a.s(e3));
                return;
            }
            return;
        }
        this.ngB = new com.faceunity.gles.a(eGLContext, 1);
        this.ngA = new com.faceunity.gles.e(this.ngB, this.ngD.getInputSurface(), true);
        this.ngA.makeCurrent();
        this.ngC = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void MG() {
        try {
            this.ngD.release();
            if (this.ngA != null) {
                this.ngA.release();
                this.ngA = null;
            }
            if (this.ngC != null) {
                this.ngC.release(false);
                this.ngC = null;
            }
            if (this.ngB != null) {
                this.ngB.release();
                this.ngB = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.lOv != null) {
                this.lOv.bp(14, com.baidu.tieba.k.a.s(e2));
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
            synchronized (d.this.ngN) {
                while (!d.this.ngO) {
                    try {
                        d.this.ngN.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.ngO = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.dKv() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.bsR = 1;
                    while (!d.this.ngS) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.ngE.f(allocateDirect, e2, d.this.dKw());
                                d.this.ngE.dKu();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.ngE.f(null, 0, d.this.dKw());
                    bVar.release();
                    d.this.ngE.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.ngP) {
                d.this.ngQ = true;
                d.this.ngP.notify();
            }
        }
    }

    protected long dKw() {
        long nanoTime = System.nanoTime();
        if (this.ngI != 0) {
            if (this.ngJ == 0) {
                this.ngJ = nanoTime;
            }
            nanoTime = (nanoTime - this.ngJ) + this.ngI;
        }
        long j = nanoTime / 1000;
        if (j < this.ngT) {
            j += this.ngT - j;
        }
        if (j == this.ngT) {
            j += 100;
        }
        this.ngT = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.ngH = cVar;
    }
}
