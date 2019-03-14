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
import com.baidu.mobstat.Config;
import com.baidu.tieba.j.h;
import com.baidu.tieba.j.l;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes5.dex */
public class d {
    private static final int[] jMl = {1, 0, 5, 7, 6};
    private h iHn;
    private c jMA;
    private int jMD;
    private int jME;
    private b jMF;
    private final Object jMG;
    private boolean jMH;
    private final Object jMI;
    private boolean jMJ;
    private boolean jMK;
    private boolean jML;
    private long jMM;
    private com.faceunity.a.c jMi;
    private com.faceunity.gles.e jMr;
    private com.faceunity.gles.a jMs;
    private com.faceunity.gles.c jMt;
    private int jMu;
    private com.faceunity.a.e jMv;
    private com.faceunity.a.a jMw;
    private volatile HandlerC0438d jMx;
    private int jMz;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object jMy = new Object();
    private long jMB = 0;
    private long jMC = 0;

    /* loaded from: classes5.dex */
    public interface c {
        void clu();

        void clv();
    }

    public boolean CT(int i) {
        return this.jMz == i;
    }

    public d() {
        this.jMz = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iHn = lVar.bEC();
        }
        this.jMF = null;
        this.jMG = new Object();
        this.jMH = false;
        this.jMI = new Object();
        this.jMJ = false;
        this.jMK = false;
        this.jML = false;
        this.jMM = 0L;
        this.jMz = 2;
    }

    /* loaded from: classes5.dex */
    public static class b {
        final int hXk;
        final File iUX;
        final long jMB;
        final EGLContext jMO;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.iUX = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.hXk = i3;
            if (eGLContext != null) {
                this.jMO = eGLContext;
            } else {
                this.jMO = EGL14.eglGetCurrentContext();
            }
            this.jMB = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.hXk + " to '" + this.iUX.toString() + "' ctxt=" + this.jMO;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.jMD = iArr[0];
        GLES20.glBindTexture(3553, this.jMD);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.jME = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.jMz = 5;
        this.jMB = bVar.jMB;
        this.jMC = System.nanoTime();
        synchronized (this.jMy) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.jMy.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.jMx.sendMessage(this.jMx.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.jME}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.jMD}, 0);
        this.jME = 0;
        this.jMD = 0;
        if (this.jMi == null || !this.jMi.isStarted()) {
            this.jML = true;
            if (this.jMv != null) {
                this.jMv.requestStop();
            }
        }
        this.jMz = 4;
        this.jMx.sendMessage(this.jMx.obtainMessage(1));
        this.jMx.sendMessage(this.jMx.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.jMy) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.jMx.sendMessage(this.jMx.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.jMD != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.jME);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.jMD, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.jMy) {
                if (this.mReady) {
                    this.jMx.sendMessage(this.jMx.obtainMessage(3, this.jMD, 0, null));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    private class e extends Thread {
        public e(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (d.this.jMy) {
                d.this.jMx = new HandlerC0438d(d.this);
                d.this.mReady = true;
                d.this.jMy.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.jMy) {
                d.this.mReady = d.this.mRunning = false;
                d.this.jMx = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class HandlerC0438d extends Handler {
        private WeakReference<d> jMP;

        public HandlerC0438d(d dVar) {
            this.jMP = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.jMP.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.cAP();
                        return;
                    case 2:
                        if (dVar.jMK) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.jMK) {
                            dVar.CU(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.jMK) {
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
        this.jMF = bVar;
        this.jMu = 0;
        a(bVar.jMO, bVar.mWidth, bVar.mHeight, bVar.hXk, bVar.iUX);
        this.jML = false;
        if (this.jMA != null) {
            this.jMA.clu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.jMD != 0) {
            try {
                this.jMv.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.jMF.mWidth, this.jMF.mHeight);
            synchronized (d.class) {
                this.jMt.drawFrame(this.mTextureId, fArr);
            }
            if (this.jMr != null) {
                this.jMr.setPresentationTime(cAR() * 1000);
                this.jMr.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAP() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.jMv.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.jML = true;
        cAQ();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.jMJ) {
            synchronized (this.jMI) {
                try {
                    this.jMI.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.jMJ = false;
        if (this.jMA != null) {
            this.jMA.clv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CU(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.jMr != null) {
            this.jMr.releaseEglSurface();
        }
        this.jMt.release(false);
        if (this.jMs != null) {
            this.jMs.release();
        }
        this.jMs = new com.faceunity.gles.a(eGLContext, 1);
        if (this.jMr != null) {
            this.jMr.a(this.jMs);
            this.jMr.makeCurrent();
        }
        this.jMt = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.jMi = new com.faceunity.a.c(file.toString());
            this.jMv = new com.faceunity.a.e(i, i2, i3, this.jMi);
            this.jMw = new com.faceunity.a.a(this.jMi);
            this.jMK = true;
            synchronized (this.jMG) {
                this.jMH = true;
                this.jMG.notify();
            }
        } catch (IOException e2) {
            if (this.iHn != null) {
                this.iHn.aq(12, com.baidu.tieba.j.a.p(e2));
            }
        } catch (IllegalStateException e3) {
            this.jMK = false;
            if (this.iHn != null) {
                this.iHn.aq(13, com.baidu.tieba.j.a.p(e3));
                return;
            }
            return;
        }
        this.jMs = new com.faceunity.gles.a(eGLContext, 1);
        this.jMr = new com.faceunity.gles.e(this.jMs, this.jMv.getInputSurface(), true);
        this.jMr.makeCurrent();
        this.jMt = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void cAQ() {
        try {
            this.jMv.release();
            if (this.jMr != null) {
                this.jMr.release();
                this.jMr = null;
            }
            if (this.jMt != null) {
                this.jMt.release(false);
                this.jMt = null;
            }
            if (this.jMs != null) {
                this.jMs.release();
                this.jMs = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.iHn != null) {
                this.iHn.aq(14, com.baidu.tieba.j.a.p(e2));
            }
        }
    }

    /* loaded from: classes5.dex */
    private class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            synchronized (d.this.jMG) {
                while (!d.this.jMH) {
                    try {
                        d.this.jMG.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.jMH = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.cAO() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.jMz = 1;
                    while (!d.this.jML) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.jMw.c(allocateDirect, read, d.this.cAR());
                                d.this.jMw.cAN();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.jMw.c(null, 0, d.this.cAR());
                    bVar.release();
                    d.this.jMw.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.jMI) {
                d.this.jMJ = true;
                d.this.jMI.notify();
            }
        }
    }

    protected long cAR() {
        long nanoTime = System.nanoTime();
        if (this.jMB != 0) {
            if (this.jMC == 0) {
                this.jMC = nanoTime;
            }
            nanoTime = (nanoTime - this.jMC) + this.jMB;
        }
        long j = nanoTime / 1000;
        if (j < this.jMM) {
            j += this.jMM - j;
        }
        if (j == this.jMM) {
            j += 100;
        }
        this.jMM = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.jMA = cVar;
    }
}
