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
    private static final int[] klD = {1, 0, 5, 7, 6};
    private int aec;
    private h jgo;
    private com.faceunity.a.c klB;
    private com.faceunity.gles.e klJ;
    private com.faceunity.gles.a klK;
    private com.faceunity.gles.c klL;
    private int klM;
    private com.faceunity.a.e klN;
    private com.faceunity.a.a klO;
    private volatile HandlerC0456d klP;
    private c klR;
    private int klU;
    private int klV;
    private b klW;
    private final Object klX;
    private boolean klY;
    private final Object klZ;
    private boolean kma;
    private boolean kmb;
    private boolean kmc;
    private long kmd;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object klQ = new Object();
    private long klS = 0;
    private long klT = 0;

    /* loaded from: classes5.dex */
    public interface c {
        void cwl();

        void cwm();
    }

    public boolean Eu(int i) {
        return this.aec == i;
    }

    public d() {
        this.aec = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.jgo = lVar.bOW();
        }
        this.klW = null;
        this.klX = new Object();
        this.klY = false;
        this.klZ = new Object();
        this.kma = false;
        this.kmb = false;
        this.kmc = false;
        this.kmd = 0L;
        this.aec = 2;
    }

    /* loaded from: classes5.dex */
    public static class b {
        final int iwa;
        final File jtV;
        final long klS;
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.jtV = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.iwa = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.klS = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.iwa + " to '" + this.jtV.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.klU = iArr[0];
        GLES20.glBindTexture(3553, this.klU);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.klV = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.aec = 5;
        this.klS = bVar.klS;
        this.klT = System.nanoTime();
        synchronized (this.klQ) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.klQ.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.klP.sendMessage(this.klP.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.klV}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.klU}, 0);
        this.klV = 0;
        this.klU = 0;
        if (this.klB == null || !this.klB.isStarted()) {
            this.kmc = true;
            if (this.klN != null) {
                this.klN.requestStop();
            }
        }
        this.aec = 4;
        this.klP.sendMessage(this.klP.obtainMessage(1));
        this.klP.sendMessage(this.klP.obtainMessage(5));
    }

    public void d(SurfaceTexture surfaceTexture) {
        synchronized (this.klQ) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.klP.sendMessage(this.klP.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.klU != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.klV);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.klU, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.klQ) {
                if (this.mReady) {
                    this.klP.sendMessage(this.klP.obtainMessage(3, this.klU, 0, null));
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
            synchronized (d.this.klQ) {
                d.this.klP = new HandlerC0456d(d.this);
                d.this.mReady = true;
                d.this.klQ.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.klQ) {
                d.this.mReady = d.this.mRunning = false;
                d.this.klP = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class HandlerC0456d extends Handler {
        private WeakReference<d> kmf;

        public HandlerC0456d(d dVar) {
            this.kmf = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.kmf.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.tH();
                        return;
                    case 2:
                        if (dVar.kmb) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.kmb) {
                            dVar.Ev(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.kmb) {
                            dVar.d((EGLContext) message.obj);
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
        this.klW = bVar;
        this.klM = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.iwa, bVar.jtV);
        this.kmc = false;
        if (this.klR != null) {
            this.klR.cwl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.klU != 0) {
            try {
                this.klN.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.klW.mWidth, this.klW.mHeight);
            synchronized (d.class) {
                this.klL.drawFrame(this.mTextureId, fArr);
            }
            if (this.klJ != null) {
                this.klJ.setPresentationTime(cLK() * 1000);
                this.klJ.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tH() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.klN.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.kmc = true;
        tO();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.kma) {
            synchronized (this.klZ) {
                try {
                    this.klZ.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.kma = false;
        if (this.klR != null) {
            this.klR.cwm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ev(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.klJ != null) {
            this.klJ.releaseEglSurface();
        }
        this.klL.release(false);
        if (this.klK != null) {
            this.klK.release();
        }
        this.klK = new com.faceunity.gles.a(eGLContext, 1);
        if (this.klJ != null) {
            this.klJ.a(this.klK);
            this.klJ.makeCurrent();
        }
        this.klL = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.klB = new com.faceunity.a.c(file.toString());
            this.klN = new com.faceunity.a.e(i, i2, i3, this.klB);
            this.klO = new com.faceunity.a.a(this.klB);
            this.kmb = true;
            synchronized (this.klX) {
                this.klY = true;
                this.klX.notify();
            }
        } catch (IOException e2) {
            if (this.jgo != null) {
                this.jgo.av(12, com.baidu.tieba.j.a.p(e2));
            }
        } catch (IllegalStateException e3) {
            this.kmb = false;
            if (this.jgo != null) {
                this.jgo.av(13, com.baidu.tieba.j.a.p(e3));
                return;
            }
            return;
        }
        this.klK = new com.faceunity.gles.a(eGLContext, 1);
        this.klJ = new com.faceunity.gles.e(this.klK, this.klN.getInputSurface(), true);
        this.klJ.makeCurrent();
        this.klL = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void tO() {
        try {
            this.klN.release();
            if (this.klJ != null) {
                this.klJ.release();
                this.klJ = null;
            }
            if (this.klL != null) {
                this.klL.release(false);
                this.klL = null;
            }
            if (this.klK != null) {
                this.klK.release();
                this.klK = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.jgo != null) {
                this.jgo.av(14, com.baidu.tieba.j.a.p(e2));
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
            synchronized (d.this.klX) {
                while (!d.this.klY) {
                    try {
                        d.this.klX.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.klY = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.cLJ() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.tE();
                    d.this.aec = 1;
                    while (!d.this.kmc) {
                        try {
                            allocateDirect.clear();
                            int b = bVar.b(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (b > 0) {
                                allocateDirect.position(b);
                                allocateDirect.flip();
                                d.this.klO.f(allocateDirect, b, d.this.cLK());
                                d.this.klO.cLH();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.klO.f(null, 0, d.this.cLK());
                    bVar.release();
                    d.this.klO.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.klZ) {
                d.this.kma = true;
                d.this.klZ.notify();
            }
        }
    }

    protected long cLK() {
        long nanoTime = System.nanoTime();
        if (this.klS != 0) {
            if (this.klT == 0) {
                this.klT = nanoTime;
            }
            nanoTime = (nanoTime - this.klT) + this.klS;
        }
        long j = nanoTime / 1000;
        if (j < this.kmd) {
            j += this.kmd - j;
        }
        if (j == this.kmd) {
            j += 100;
        }
        this.kmd = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.klR = cVar;
    }
}
