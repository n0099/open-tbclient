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
import com.baidu.tieba.j.h;
import com.baidu.tieba.j.k;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes2.dex */
public class d {
    private static final int[] hHk = {1, 0, 5, 7, 6};
    private h gJZ;
    private int hHB;
    private int hHC;
    private b hHD;
    private final Object hHE;
    private boolean hHF;
    private final Object hHG;
    private boolean hHH;
    private boolean hHI;
    private boolean hHJ;
    private long hHK;
    private com.faceunity.a.c hHg;
    private com.faceunity.gles.e hHq;
    private com.faceunity.gles.a hHr;
    private com.faceunity.gles.c hHs;
    private int hHt;
    private com.faceunity.a.e hHu;
    private com.faceunity.a.a hHv;
    private volatile HandlerC0264d hHw;
    private int hHx;
    private c hHy;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long hHz = 0;
    private long hHA = 0;

    /* loaded from: classes2.dex */
    public interface c {
        void bDD();

        void bDE();
    }

    public boolean ww(int i) {
        return this.hHx == i;
    }

    public d() {
        this.hHx = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gJZ = kVar.aWY();
        }
        this.hHD = null;
        this.hHE = new Object();
        this.hHF = false;
        this.hHG = new Object();
        this.hHH = false;
        this.hHI = false;
        this.hHJ = false;
        this.hHK = 0L;
        this.hHx = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final File gWH;
        final int gby;
        final EGLContext hHM;
        final long hHz;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.gWH = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.gby = i3;
            if (eGLContext != null) {
                this.hHM = eGLContext;
            } else {
                this.hHM = EGL14.eglGetCurrentContext();
            }
            this.hHz = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.gby + " to '" + this.gWH.toString() + "' ctxt=" + this.hHM;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.hHB = iArr[0];
        GLES20.glBindTexture(3553, this.hHB);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.hHC = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.hHx = 5;
        this.hHz = bVar.hHz;
        this.hHA = System.nanoTime();
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
            this.hHw.sendMessage(this.hHw.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.hHC}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.hHB}, 0);
        this.hHC = 0;
        this.hHB = 0;
        if (this.hHg == null || !this.hHg.isStarted()) {
            this.hHJ = true;
            if (this.hHu != null) {
                this.hHu.requestStop();
            }
        }
        this.hHx = 4;
        this.hHw.sendMessage(this.hHw.obtainMessage(1));
        this.hHw.sendMessage(this.hHw.obtainMessage(5));
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
                    this.hHw.sendMessage(this.hHw.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.hHB != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.hHC);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.hHB, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.hHw.sendMessage(this.hHw.obtainMessage(3, this.hHB, 0, null));
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
                d.this.hHw = new HandlerC0264d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.hHw = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class HandlerC0264d extends Handler {
        private WeakReference<d> mWeakEncoder;

        public HandlerC0264d(d dVar) {
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
                        if (dVar.hHI) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.hHI) {
                            dVar.wx(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.hHI) {
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
        this.hHD = bVar;
        this.hHt = 0;
        a(bVar.hHM, bVar.mWidth, bVar.mHeight, bVar.gby, bVar.gWH);
        this.hHJ = false;
        if (this.hHy != null) {
            this.hHy.bDD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.hHB != 0) {
            try {
                this.hHu.ob(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.hHD.mWidth, this.hHD.mHeight);
            synchronized (d.class) {
                this.hHs.drawFrame(this.mTextureId, fArr);
            }
            if (this.hHq != null) {
                this.hHq.setPresentationTime(bNm() * 1000);
                this.hHq.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.hHu.ob(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.hHJ = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.hHH) {
            synchronized (this.hHG) {
                try {
                    this.hHG.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.hHH = false;
        if (this.hHy != null) {
            this.hHy.bDE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wx(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.hHq != null) {
            this.hHq.releaseEglSurface();
        }
        this.hHs.release(false);
        if (this.hHr != null) {
            this.hHr.release();
        }
        this.hHr = new com.faceunity.gles.a(eGLContext, 1);
        if (this.hHq != null) {
            this.hHq.a(this.hHr);
            this.hHq.makeCurrent();
        }
        this.hHs = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.hHg = new com.faceunity.a.c(file.toString());
            this.hHu = new com.faceunity.a.e(i, i2, i3, this.hHg);
            this.hHv = new com.faceunity.a.a(this.hHg);
            this.hHI = true;
            synchronized (this.hHE) {
                this.hHF = true;
                this.hHE.notify();
            }
        } catch (IOException e2) {
            if (this.gJZ != null) {
                this.gJZ.ac(12, com.baidu.tieba.j.a.m(e2));
            }
        } catch (IllegalStateException e3) {
            this.hHI = false;
            if (this.gJZ != null) {
                this.gJZ.ac(13, com.baidu.tieba.j.a.m(e3));
                return;
            }
            return;
        }
        this.hHr = new com.faceunity.gles.a(eGLContext, 1);
        this.hHq = new com.faceunity.gles.e(this.hHr, this.hHu.getInputSurface(), true);
        this.hHq.makeCurrent();
        this.hHs = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.hHu.release();
            if (this.hHq != null) {
                this.hHq.release();
                this.hHq = null;
            }
            if (this.hHs != null) {
                this.hHs.release(false);
                this.hHs = null;
            }
            if (this.hHr != null) {
                this.hHr.release();
                this.hHr = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.gJZ != null) {
                this.gJZ.ac(14, com.baidu.tieba.j.a.m(e2));
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
            synchronized (d.this.hHE) {
                while (!d.this.hHF) {
                    try {
                        d.this.hHE.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.hHF = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.bNl() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.hHx = 1;
                    while (!d.this.hHJ) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.hHv.c(allocateDirect, read, d.this.bNm());
                                d.this.hHv.bNk();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.hHv.c(null, 0, d.this.bNm());
                    bVar.release();
                    d.this.hHv.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.hHG) {
                d.this.hHH = true;
                d.this.hHG.notify();
            }
        }
    }

    protected long bNm() {
        long nanoTime = System.nanoTime();
        if (this.hHz != 0) {
            if (this.hHA == 0) {
                this.hHA = nanoTime;
            }
            nanoTime = (nanoTime - this.hHA) + this.hHz;
        }
        long j = nanoTime / 1000;
        if (j < this.hHK) {
            j += this.hHK - j;
        }
        if (j == this.hHK) {
            j += 100;
        }
        this.hHK = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.hHy = cVar;
    }
}
