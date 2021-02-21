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
    private static final int[] pOl = {1, 0, 5, 7, 6};
    private int cgw;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private g nyu;
    private int pOA;
    private int pOB;
    private b pOC;
    private final Object pOD;
    private boolean pOE;
    private final Object pOF;
    private boolean pOG;
    private boolean pOH;
    private boolean pOI;
    private long pOJ;
    private com.faceunity.a.c pOk;
    private com.faceunity.gles.e pOq;
    private com.faceunity.gles.a pOr;
    private com.faceunity.gles.c pOs;
    private int pOt;
    private com.faceunity.a.e pOu;
    private com.faceunity.a.a pOv;
    private volatile HandlerC1057d pOw;
    private c pOx;
    private Object mReadyFence = new Object();
    private long pOy = 0;
    private long pOz = 0;

    /* loaded from: classes8.dex */
    public interface c {
        void VL();

        void dUq();
    }

    public boolean Qt(int i) {
        return this.cgw == i;
    }

    public d() {
        this.cgw = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.nyu = kVar.dhf();
        }
        this.pOC = null;
        this.pOD = new Object();
        this.pOE = false;
        this.pOF = new Object();
        this.pOG = false;
        this.pOH = false;
        this.pOI = false;
        this.pOJ = 0L;
        this.cgw = 2;
    }

    /* loaded from: classes8.dex */
    public static class b {
        final int mBitRate;
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final File nLd;
        final long pOy;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.nLd = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.mBitRate = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.pOy = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.mBitRate + " to '" + this.nLd.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.pOA = iArr[0];
        GLES20.glBindTexture(3553, this.pOA);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.pOB = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.cgw = 5;
        this.pOy = bVar.pOy;
        this.pOz = System.nanoTime();
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
            this.pOw.sendMessage(this.pOw.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.pOB}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.pOA}, 0);
        this.pOB = 0;
        this.pOA = 0;
        if (this.pOk == null || !this.pOk.isStarted()) {
            this.pOI = true;
            if (this.pOu != null) {
                this.pOu.requestStop();
            }
        }
        this.cgw = 4;
        this.pOw.sendMessage(this.pOw.obtainMessage(1));
        this.pOw.sendMessage(this.pOw.obtainMessage(5));
    }

    public void d(SurfaceTexture surfaceTexture) {
        synchronized (this.mReadyFence) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.pOw.sendMessage(this.pOw.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.pOA != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.pOB);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.pOA, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.pOw.sendMessage(this.pOw.obtainMessage(3, this.pOA, 0, null));
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
            synchronized (d.this.mReadyFence) {
                d.this.pOw = new HandlerC1057d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.pOw = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class HandlerC1057d extends Handler {
        private WeakReference<d> mWeakEncoder;

        public HandlerC1057d(d dVar) {
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
                        if (dVar.pOH) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.pOH) {
                            dVar.Qu(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.pOH) {
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
        this.pOC = bVar;
        this.pOt = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.mBitRate, bVar.nLd);
        this.pOI = false;
        if (this.pOx != null) {
            this.pOx.VL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.pOA != 0) {
            try {
                this.pOu.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.pOC.mWidth, this.pOC.mHeight);
            synchronized (d.class) {
                this.pOs.drawFrame(this.mTextureId, fArr);
            }
            if (this.pOq != null) {
                this.pOq.setPresentationTime(eAu() * 1000);
                this.pOq.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.pOu.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.pOI = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.pOG) {
            synchronized (this.pOF) {
                try {
                    this.pOF.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.pOG = false;
        if (this.pOx != null) {
            this.pOx.dUq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qu(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.pOq != null) {
            this.pOq.releaseEglSurface();
        }
        this.pOs.release(false);
        if (this.pOr != null) {
            this.pOr.release();
        }
        this.pOr = new com.faceunity.gles.a(eGLContext, 1);
        if (this.pOq != null) {
            this.pOq.a(this.pOr);
            this.pOq.makeCurrent();
        }
        this.pOs = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.pOk = new com.faceunity.a.c(file.toString());
            this.pOu = new com.faceunity.a.e(i, i2, i3, this.pOk);
            this.pOv = new com.faceunity.a.a(this.pOk);
            this.pOH = true;
            synchronized (this.pOD) {
                this.pOE = true;
                this.pOD.notify();
            }
        } catch (IOException e2) {
            if (this.nyu != null) {
                this.nyu.bK(12, com.baidu.tieba.l.a.o(e2));
            }
        } catch (IllegalStateException e3) {
            this.pOH = false;
            if (this.nyu != null) {
                this.nyu.bK(13, com.baidu.tieba.l.a.o(e3));
                return;
            }
            return;
        }
        this.pOr = new com.faceunity.gles.a(eGLContext, 1);
        this.pOq = new com.faceunity.gles.e(this.pOr, this.pOu.getInputSurface(), true);
        this.pOq.makeCurrent();
        this.pOs = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.pOu.release();
            if (this.pOq != null) {
                this.pOq.release();
                this.pOq = null;
            }
            if (this.pOs != null) {
                this.pOs.release(false);
                this.pOs = null;
            }
            if (this.pOr != null) {
                this.pOr.release();
                this.pOr = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.nyu != null) {
                this.nyu.bK(14, com.baidu.tieba.l.a.o(e2));
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
            synchronized (d.this.pOD) {
                while (!d.this.pOE) {
                    try {
                        d.this.pOD.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.pOE = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.eAt() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.cgw = 1;
                    while (!d.this.pOI) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.pOv.f(allocateDirect, e2, d.this.eAu());
                                d.this.pOv.eAs();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.pOv.f(null, 0, d.this.eAu());
                    bVar.release();
                    d.this.pOv.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.pOF) {
                d.this.pOG = true;
                d.this.pOF.notify();
            }
        }
    }

    protected long eAu() {
        long nanoTime = System.nanoTime();
        if (this.pOy != 0) {
            if (this.pOz == 0) {
                this.pOz = nanoTime;
            }
            nanoTime = (nanoTime - this.pOz) + this.pOy;
        }
        long j = nanoTime / 1000;
        if (j < this.pOJ) {
            j += this.pOJ - j;
        }
        if (j == this.pOJ) {
            j += 100;
        }
        this.pOJ = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.pOx = cVar;
    }
}
