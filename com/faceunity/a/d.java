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
    private static final int[] pNL = {1, 0, 5, 7, 6};
    private int cgw;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private g nxU;
    private com.faceunity.a.c pNK;
    private com.faceunity.gles.e pNQ;
    private com.faceunity.gles.a pNR;
    private com.faceunity.gles.c pNS;
    private int pNT;
    private com.faceunity.a.e pNU;
    private com.faceunity.a.a pNV;
    private volatile HandlerC1055d pNW;
    private c pNX;
    private int pOa;
    private int pOb;
    private b pOc;
    private final Object pOd;
    private boolean pOe;
    private final Object pOf;
    private boolean pOg;
    private boolean pOh;
    private boolean pOi;
    private long pOj;
    private Object mReadyFence = new Object();
    private long pNY = 0;
    private long pNZ = 0;

    /* loaded from: classes8.dex */
    public interface c {
        void VL();

        void dUi();
    }

    public boolean Qs(int i) {
        return this.cgw == i;
    }

    public d() {
        this.cgw = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.nxU = kVar.dgY();
        }
        this.pOc = null;
        this.pOd = new Object();
        this.pOe = false;
        this.pOf = new Object();
        this.pOg = false;
        this.pOh = false;
        this.pOi = false;
        this.pOj = 0L;
        this.cgw = 2;
    }

    /* loaded from: classes8.dex */
    public static class b {
        final int mBitRate;
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final File nKD;
        final long pNY;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.nKD = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.mBitRate = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.pNY = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.mBitRate + " to '" + this.nKD.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.pOa = iArr[0];
        GLES20.glBindTexture(3553, this.pOa);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.pOb = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.cgw = 5;
        this.pNY = bVar.pNY;
        this.pNZ = System.nanoTime();
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
            this.pNW.sendMessage(this.pNW.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.pOb}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.pOa}, 0);
        this.pOb = 0;
        this.pOa = 0;
        if (this.pNK == null || !this.pNK.isStarted()) {
            this.pOi = true;
            if (this.pNU != null) {
                this.pNU.requestStop();
            }
        }
        this.cgw = 4;
        this.pNW.sendMessage(this.pNW.obtainMessage(1));
        this.pNW.sendMessage(this.pNW.obtainMessage(5));
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
                    this.pNW.sendMessage(this.pNW.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.pOa != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.pOb);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.pOa, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.pNW.sendMessage(this.pNW.obtainMessage(3, this.pOa, 0, null));
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
                d.this.pNW = new HandlerC1055d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.pNW = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class HandlerC1055d extends Handler {
        private WeakReference<d> mWeakEncoder;

        public HandlerC1055d(d dVar) {
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
                        if (dVar.pOh) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.pOh) {
                            dVar.Qt(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.pOh) {
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
        this.pOc = bVar;
        this.pNT = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.mBitRate, bVar.nKD);
        this.pOi = false;
        if (this.pNX != null) {
            this.pNX.VL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.pOa != 0) {
            try {
                this.pNU.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.pOc.mWidth, this.pOc.mHeight);
            synchronized (d.class) {
                this.pNS.drawFrame(this.mTextureId, fArr);
            }
            if (this.pNQ != null) {
                this.pNQ.setPresentationTime(eAm() * 1000);
                this.pNQ.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.pNU.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.pOi = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.pOg) {
            synchronized (this.pOf) {
                try {
                    this.pOf.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.pOg = false;
        if (this.pNX != null) {
            this.pNX.dUi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qt(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.pNQ != null) {
            this.pNQ.releaseEglSurface();
        }
        this.pNS.release(false);
        if (this.pNR != null) {
            this.pNR.release();
        }
        this.pNR = new com.faceunity.gles.a(eGLContext, 1);
        if (this.pNQ != null) {
            this.pNQ.a(this.pNR);
            this.pNQ.makeCurrent();
        }
        this.pNS = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.pNK = new com.faceunity.a.c(file.toString());
            this.pNU = new com.faceunity.a.e(i, i2, i3, this.pNK);
            this.pNV = new com.faceunity.a.a(this.pNK);
            this.pOh = true;
            synchronized (this.pOd) {
                this.pOe = true;
                this.pOd.notify();
            }
        } catch (IOException e2) {
            if (this.nxU != null) {
                this.nxU.bK(12, com.baidu.tieba.l.a.o(e2));
            }
        } catch (IllegalStateException e3) {
            this.pOh = false;
            if (this.nxU != null) {
                this.nxU.bK(13, com.baidu.tieba.l.a.o(e3));
                return;
            }
            return;
        }
        this.pNR = new com.faceunity.gles.a(eGLContext, 1);
        this.pNQ = new com.faceunity.gles.e(this.pNR, this.pNU.getInputSurface(), true);
        this.pNQ.makeCurrent();
        this.pNS = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.pNU.release();
            if (this.pNQ != null) {
                this.pNQ.release();
                this.pNQ = null;
            }
            if (this.pNS != null) {
                this.pNS.release(false);
                this.pNS = null;
            }
            if (this.pNR != null) {
                this.pNR.release();
                this.pNR = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.nxU != null) {
                this.nxU.bK(14, com.baidu.tieba.l.a.o(e2));
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
            synchronized (d.this.pOd) {
                while (!d.this.pOe) {
                    try {
                        d.this.pOd.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.pOe = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.eAl() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.cgw = 1;
                    while (!d.this.pOi) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.pNV.f(allocateDirect, e2, d.this.eAm());
                                d.this.pNV.eAk();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.pNV.f(null, 0, d.this.eAm());
                    bVar.release();
                    d.this.pNV.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.pOf) {
                d.this.pOg = true;
                d.this.pOf.notify();
            }
        }
    }

    protected long eAm() {
        long nanoTime = System.nanoTime();
        if (this.pNY != 0) {
            if (this.pNZ == 0) {
                this.pNZ = nanoTime;
            }
            nanoTime = (nanoTime - this.pNZ) + this.pNY;
        }
        long j = nanoTime / 1000;
        if (j < this.pOj) {
            j += this.pOj - j;
        }
        if (j == this.pOj) {
            j += 100;
        }
        this.pOj = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.pNX = cVar;
    }
}
