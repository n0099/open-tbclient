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
    private static final int[] jLG = {1, 0, 5, 7, 6};
    private h iGY;
    private com.faceunity.a.c jLD;
    private com.faceunity.gles.e jLM;
    private com.faceunity.gles.a jLN;
    private com.faceunity.gles.c jLO;
    private int jLP;
    private com.faceunity.a.e jLQ;
    private com.faceunity.a.a jLR;
    private volatile HandlerC0438d jLS;
    private int jLU;
    private c jLV;
    private int jLY;
    private int jLZ;
    private b jMa;
    private final Object jMb;
    private boolean jMc;
    private final Object jMd;
    private boolean jMe;
    private boolean jMf;
    private boolean jMg;
    private long jMh;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object jLT = new Object();
    private long jLW = 0;
    private long jLX = 0;

    /* loaded from: classes5.dex */
    public interface c {
        void cls();

        void clt();
    }

    public boolean CJ(int i) {
        return this.jLU == i;
    }

    public d() {
        this.jLU = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iGY = lVar.bEz();
        }
        this.jMa = null;
        this.jMb = new Object();
        this.jMc = false;
        this.jMd = new Object();
        this.jMe = false;
        this.jMf = false;
        this.jMg = false;
        this.jMh = 0L;
        this.jLU = 2;
    }

    /* loaded from: classes5.dex */
    public static class b {
        final int hWX;
        final File iUM;
        final long jLW;
        final EGLContext jMj;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.iUM = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.hWX = i3;
            if (eGLContext != null) {
                this.jMj = eGLContext;
            } else {
                this.jMj = EGL14.eglGetCurrentContext();
            }
            this.jLW = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.hWX + " to '" + this.iUM.toString() + "' ctxt=" + this.jMj;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.jLY = iArr[0];
        GLES20.glBindTexture(3553, this.jLY);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.jLZ = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.jLU = 5;
        this.jLW = bVar.jLW;
        this.jLX = System.nanoTime();
        synchronized (this.jLT) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.jLT.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.jLS.sendMessage(this.jLS.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.jLZ}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.jLY}, 0);
        this.jLZ = 0;
        this.jLY = 0;
        if (this.jLD == null || !this.jLD.isStarted()) {
            this.jMg = true;
            if (this.jLQ != null) {
                this.jLQ.requestStop();
            }
        }
        this.jLU = 4;
        this.jLS.sendMessage(this.jLS.obtainMessage(1));
        this.jLS.sendMessage(this.jLS.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.jLT) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.jLS.sendMessage(this.jLS.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.jLY != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.jLZ);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.jLY, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.jLT) {
                if (this.mReady) {
                    this.jLS.sendMessage(this.jLS.obtainMessage(3, this.jLY, 0, null));
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
            synchronized (d.this.jLT) {
                d.this.jLS = new HandlerC0438d(d.this);
                d.this.mReady = true;
                d.this.jLT.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.jLT) {
                d.this.mReady = d.this.mRunning = false;
                d.this.jLS = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class HandlerC0438d extends Handler {
        private WeakReference<d> jMk;

        public HandlerC0438d(d dVar) {
            this.jMk = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.jMk.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.cAI();
                        return;
                    case 2:
                        if (dVar.jMf) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.jMf) {
                            dVar.CK(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.jMf) {
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
        this.jMa = bVar;
        this.jLP = 0;
        a(bVar.jMj, bVar.mWidth, bVar.mHeight, bVar.hWX, bVar.iUM);
        this.jMg = false;
        if (this.jLV != null) {
            this.jLV.cls();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.jLY != 0) {
            try {
                this.jLQ.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.jMa.mWidth, this.jMa.mHeight);
            synchronized (d.class) {
                this.jLO.drawFrame(this.mTextureId, fArr);
            }
            if (this.jLM != null) {
                this.jLM.setPresentationTime(cAK() * 1000);
                this.jLM.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAI() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.jLQ.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.jMg = true;
        cAJ();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.jMe) {
            synchronized (this.jMd) {
                try {
                    this.jMd.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.jMe = false;
        if (this.jLV != null) {
            this.jLV.clt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CK(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.jLM != null) {
            this.jLM.releaseEglSurface();
        }
        this.jLO.release(false);
        if (this.jLN != null) {
            this.jLN.release();
        }
        this.jLN = new com.faceunity.gles.a(eGLContext, 1);
        if (this.jLM != null) {
            this.jLM.a(this.jLN);
            this.jLM.makeCurrent();
        }
        this.jLO = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.jLD = new com.faceunity.a.c(file.toString());
            this.jLQ = new com.faceunity.a.e(i, i2, i3, this.jLD);
            this.jLR = new com.faceunity.a.a(this.jLD);
            this.jMf = true;
            synchronized (this.jMb) {
                this.jMc = true;
                this.jMb.notify();
            }
        } catch (IOException e2) {
            if (this.iGY != null) {
                this.iGY.as(12, com.baidu.tieba.j.a.p(e2));
            }
        } catch (IllegalStateException e3) {
            this.jMf = false;
            if (this.iGY != null) {
                this.iGY.as(13, com.baidu.tieba.j.a.p(e3));
                return;
            }
            return;
        }
        this.jLN = new com.faceunity.gles.a(eGLContext, 1);
        this.jLM = new com.faceunity.gles.e(this.jLN, this.jLQ.getInputSurface(), true);
        this.jLM.makeCurrent();
        this.jLO = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void cAJ() {
        try {
            this.jLQ.release();
            if (this.jLM != null) {
                this.jLM.release();
                this.jLM = null;
            }
            if (this.jLO != null) {
                this.jLO.release(false);
                this.jLO = null;
            }
            if (this.jLN != null) {
                this.jLN.release();
                this.jLN = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.iGY != null) {
                this.iGY.as(14, com.baidu.tieba.j.a.p(e2));
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
            synchronized (d.this.jMb) {
                while (!d.this.jMc) {
                    try {
                        d.this.jMb.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.jMc = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.cAH() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.jLU = 1;
                    while (!d.this.jMg) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.jLR.c(allocateDirect, read, d.this.cAK());
                                d.this.jLR.cAG();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.jLR.c(null, 0, d.this.cAK());
                    bVar.release();
                    d.this.jLR.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.jMd) {
                d.this.jMe = true;
                d.this.jMd.notify();
            }
        }
    }

    protected long cAK() {
        long nanoTime = System.nanoTime();
        if (this.jLW != 0) {
            if (this.jLX == 0) {
                this.jLX = nanoTime;
            }
            nanoTime = (nanoTime - this.jLX) + this.jLW;
        }
        long j = nanoTime / 1000;
        if (j < this.jMh) {
            j += this.jMh - j;
        }
        if (j == this.jMh) {
            j += 100;
        }
        this.jMh = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.jLV = cVar;
    }
}
