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
    private static final int[] kes = {1, 0, 5, 7, 6};
    private int adF;
    private h iZR;
    private com.faceunity.gles.a keA;
    private com.faceunity.gles.c keB;
    private int keC;
    private com.faceunity.a.e keD;
    private com.faceunity.a.a keE;
    private volatile HandlerC0457d keF;
    private c keH;
    private int keK;
    private int keL;
    private b keM;
    private final Object keN;
    private boolean keO;
    private final Object keP;
    private boolean keQ;
    private boolean keR;
    private boolean keS;
    private long keT;
    private com.faceunity.a.c keq;
    private com.faceunity.gles.e kez;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object keG = new Object();
    private long keI = 0;
    private long keJ = 0;

    /* loaded from: classes5.dex */
    public interface c {
        void ctv();

        void ctw();
    }

    public boolean DN(int i) {
        return this.adF == i;
    }

    public d() {
        this.adF = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iZR = lVar.bMk();
        }
        this.keM = null;
        this.keN = new Object();
        this.keO = false;
        this.keP = new Object();
        this.keQ = false;
        this.keR = false;
        this.keS = false;
        this.keT = 0L;
        this.adF = 2;
    }

    /* loaded from: classes5.dex */
    public static class b {
        final int ipG;
        final File jnJ;
        final long keI;
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.jnJ = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.ipG = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.keI = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.ipG + " to '" + this.jnJ.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.keK = iArr[0];
        GLES20.glBindTexture(3553, this.keK);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.keL = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.adF = 5;
        this.keI = bVar.keI;
        this.keJ = System.nanoTime();
        synchronized (this.keG) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.keG.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.keF.sendMessage(this.keF.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.keL}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.keK}, 0);
        this.keL = 0;
        this.keK = 0;
        if (this.keq == null || !this.keq.isStarted()) {
            this.keS = true;
            if (this.keD != null) {
                this.keD.requestStop();
            }
        }
        this.adF = 4;
        this.keF.sendMessage(this.keF.obtainMessage(1));
        this.keF.sendMessage(this.keF.obtainMessage(5));
    }

    public void d(SurfaceTexture surfaceTexture) {
        synchronized (this.keG) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.keF.sendMessage(this.keF.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.keK != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.keL);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.keK, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.keG) {
                if (this.mReady) {
                    this.keF.sendMessage(this.keF.obtainMessage(3, this.keK, 0, null));
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
            synchronized (d.this.keG) {
                d.this.keF = new HandlerC0457d(d.this);
                d.this.mReady = true;
                d.this.keG.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.keG) {
                d.this.mReady = d.this.mRunning = false;
                d.this.keF = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class HandlerC0457d extends Handler {
        private WeakReference<d> keV;

        public HandlerC0457d(d dVar) {
            this.keV = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.keV.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.th();
                        return;
                    case 2:
                        if (dVar.keR) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.keR) {
                            dVar.DO(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.keR) {
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
        this.keM = bVar;
        this.keC = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.ipG, bVar.jnJ);
        this.keS = false;
        if (this.keH != null) {
            this.keH.ctv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.keK != 0) {
            try {
                this.keD.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.keM.mWidth, this.keM.mHeight);
            synchronized (d.class) {
                this.keB.drawFrame(this.mTextureId, fArr);
            }
            if (this.kez != null) {
                this.kez.setPresentationTime(cIE() * 1000);
                this.kez.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.keD.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.keS = true;
        tp();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.keQ) {
            synchronized (this.keP) {
                try {
                    this.keP.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.keQ = false;
        if (this.keH != null) {
            this.keH.ctw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DO(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.kez != null) {
            this.kez.releaseEglSurface();
        }
        this.keB.release(false);
        if (this.keA != null) {
            this.keA.release();
        }
        this.keA = new com.faceunity.gles.a(eGLContext, 1);
        if (this.kez != null) {
            this.kez.a(this.keA);
            this.kez.makeCurrent();
        }
        this.keB = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.keq = new com.faceunity.a.c(file.toString());
            this.keD = new com.faceunity.a.e(i, i2, i3, this.keq);
            this.keE = new com.faceunity.a.a(this.keq);
            this.keR = true;
            synchronized (this.keN) {
                this.keO = true;
                this.keN.notify();
            }
        } catch (IOException e2) {
            if (this.iZR != null) {
                this.iZR.av(12, com.baidu.tieba.j.a.p(e2));
            }
        } catch (IllegalStateException e3) {
            this.keR = false;
            if (this.iZR != null) {
                this.iZR.av(13, com.baidu.tieba.j.a.p(e3));
                return;
            }
            return;
        }
        this.keA = new com.faceunity.gles.a(eGLContext, 1);
        this.kez = new com.faceunity.gles.e(this.keA, this.keD.getInputSurface(), true);
        this.kez.makeCurrent();
        this.keB = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void tp() {
        try {
            this.keD.release();
            if (this.kez != null) {
                this.kez.release();
                this.kez = null;
            }
            if (this.keB != null) {
                this.keB.release(false);
                this.keB = null;
            }
            if (this.keA != null) {
                this.keA.release();
                this.keA = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.iZR != null) {
                this.iZR.av(14, com.baidu.tieba.j.a.p(e2));
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
            synchronized (d.this.keN) {
                while (!d.this.keO) {
                    try {
                        d.this.keN.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.keO = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.cID() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.adF = 1;
                    while (!d.this.keS) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.keE.f(allocateDirect, read, d.this.cIE());
                                d.this.keE.cIC();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.keE.f(null, 0, d.this.cIE());
                    bVar.release();
                    d.this.keE.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.keP) {
                d.this.keQ = true;
                d.this.keP.notify();
            }
        }
    }

    protected long cIE() {
        long nanoTime = System.nanoTime();
        if (this.keI != 0) {
            if (this.keJ == 0) {
                this.keJ = nanoTime;
            }
            nanoTime = (nanoTime - this.keJ) + this.keI;
        }
        long j = nanoTime / 1000;
        if (j < this.keT) {
            j += this.keT - j;
        }
        if (j == this.keT) {
            j += 100;
        }
        this.keT = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.keH = cVar;
    }
}
