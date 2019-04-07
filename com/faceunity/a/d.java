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
    private static final int[] jLF = {1, 0, 5, 7, 6};
    private h iGX;
    private com.faceunity.a.c jLC;
    private com.faceunity.gles.e jLL;
    private com.faceunity.gles.a jLM;
    private com.faceunity.gles.c jLN;
    private int jLO;
    private com.faceunity.a.e jLP;
    private com.faceunity.a.a jLQ;
    private volatile HandlerC0438d jLR;
    private int jLT;
    private c jLU;
    private int jLX;
    private int jLY;
    private b jLZ;
    private final Object jMa;
    private boolean jMb;
    private final Object jMc;
    private boolean jMd;
    private boolean jMe;
    private boolean jMf;
    private long jMg;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object jLS = new Object();
    private long jLV = 0;
    private long jLW = 0;

    /* loaded from: classes5.dex */
    public interface c {
        void cls();

        void clt();
    }

    public boolean CJ(int i) {
        return this.jLT == i;
    }

    public d() {
        this.jLT = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iGX = lVar.bEz();
        }
        this.jLZ = null;
        this.jMa = new Object();
        this.jMb = false;
        this.jMc = new Object();
        this.jMd = false;
        this.jMe = false;
        this.jMf = false;
        this.jMg = 0L;
        this.jLT = 2;
    }

    /* loaded from: classes5.dex */
    public static class b {
        final int hWW;
        final File iUL;
        final long jLV;
        final EGLContext jMi;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.iUL = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.hWW = i3;
            if (eGLContext != null) {
                this.jMi = eGLContext;
            } else {
                this.jMi = EGL14.eglGetCurrentContext();
            }
            this.jLV = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.hWW + " to '" + this.iUL.toString() + "' ctxt=" + this.jMi;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.jLX = iArr[0];
        GLES20.glBindTexture(3553, this.jLX);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.jLY = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.jLT = 5;
        this.jLV = bVar.jLV;
        this.jLW = System.nanoTime();
        synchronized (this.jLS) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.jLS.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.jLR.sendMessage(this.jLR.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.jLY}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.jLX}, 0);
        this.jLY = 0;
        this.jLX = 0;
        if (this.jLC == null || !this.jLC.isStarted()) {
            this.jMf = true;
            if (this.jLP != null) {
                this.jLP.requestStop();
            }
        }
        this.jLT = 4;
        this.jLR.sendMessage(this.jLR.obtainMessage(1));
        this.jLR.sendMessage(this.jLR.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.jLS) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.jLR.sendMessage(this.jLR.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.jLX != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.jLY);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.jLX, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.jLS) {
                if (this.mReady) {
                    this.jLR.sendMessage(this.jLR.obtainMessage(3, this.jLX, 0, null));
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
            synchronized (d.this.jLS) {
                d.this.jLR = new HandlerC0438d(d.this);
                d.this.mReady = true;
                d.this.jLS.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.jLS) {
                d.this.mReady = d.this.mRunning = false;
                d.this.jLR = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class HandlerC0438d extends Handler {
        private WeakReference<d> jMj;

        public HandlerC0438d(d dVar) {
            this.jMj = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.jMj.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.cAI();
                        return;
                    case 2:
                        if (dVar.jMe) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.jMe) {
                            dVar.CK(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.jMe) {
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
        this.jLZ = bVar;
        this.jLO = 0;
        a(bVar.jMi, bVar.mWidth, bVar.mHeight, bVar.hWW, bVar.iUL);
        this.jMf = false;
        if (this.jLU != null) {
            this.jLU.cls();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.jLX != 0) {
            try {
                this.jLP.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.jLZ.mWidth, this.jLZ.mHeight);
            synchronized (d.class) {
                this.jLN.drawFrame(this.mTextureId, fArr);
            }
            if (this.jLL != null) {
                this.jLL.setPresentationTime(cAK() * 1000);
                this.jLL.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAI() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.jLP.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.jMf = true;
        cAJ();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.jMd) {
            synchronized (this.jMc) {
                try {
                    this.jMc.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.jMd = false;
        if (this.jLU != null) {
            this.jLU.clt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CK(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.jLL != null) {
            this.jLL.releaseEglSurface();
        }
        this.jLN.release(false);
        if (this.jLM != null) {
            this.jLM.release();
        }
        this.jLM = new com.faceunity.gles.a(eGLContext, 1);
        if (this.jLL != null) {
            this.jLL.a(this.jLM);
            this.jLL.makeCurrent();
        }
        this.jLN = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.jLC = new com.faceunity.a.c(file.toString());
            this.jLP = new com.faceunity.a.e(i, i2, i3, this.jLC);
            this.jLQ = new com.faceunity.a.a(this.jLC);
            this.jMe = true;
            synchronized (this.jMa) {
                this.jMb = true;
                this.jMa.notify();
            }
        } catch (IOException e2) {
            if (this.iGX != null) {
                this.iGX.as(12, com.baidu.tieba.j.a.p(e2));
            }
        } catch (IllegalStateException e3) {
            this.jMe = false;
            if (this.iGX != null) {
                this.iGX.as(13, com.baidu.tieba.j.a.p(e3));
                return;
            }
            return;
        }
        this.jLM = new com.faceunity.gles.a(eGLContext, 1);
        this.jLL = new com.faceunity.gles.e(this.jLM, this.jLP.getInputSurface(), true);
        this.jLL.makeCurrent();
        this.jLN = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void cAJ() {
        try {
            this.jLP.release();
            if (this.jLL != null) {
                this.jLL.release();
                this.jLL = null;
            }
            if (this.jLN != null) {
                this.jLN.release(false);
                this.jLN = null;
            }
            if (this.jLM != null) {
                this.jLM.release();
                this.jLM = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.iGX != null) {
                this.iGX.as(14, com.baidu.tieba.j.a.p(e2));
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
            synchronized (d.this.jMa) {
                while (!d.this.jMb) {
                    try {
                        d.this.jMa.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.jMb = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.cAH() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.jLT = 1;
                    while (!d.this.jMf) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.jLQ.c(allocateDirect, read, d.this.cAK());
                                d.this.jLQ.cAG();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.jLQ.c(null, 0, d.this.cAK());
                    bVar.release();
                    d.this.jLQ.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.jMc) {
                d.this.jMd = true;
                d.this.jMc.notify();
            }
        }
    }

    protected long cAK() {
        long nanoTime = System.nanoTime();
        if (this.jLV != 0) {
            if (this.jLW == 0) {
                this.jLW = nanoTime;
            }
            nanoTime = (nanoTime - this.jLW) + this.jLV;
        }
        long j = nanoTime / 1000;
        if (j < this.jMg) {
            j += this.jMg - j;
        }
        if (j == this.jMg) {
            j += 100;
        }
        this.jMg = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.jLU = cVar;
    }
}
