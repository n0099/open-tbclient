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
    private static final int[] ket = {1, 0, 5, 7, 6};
    private int adF;
    private h iZT;
    private com.faceunity.gles.e keA;
    private com.faceunity.gles.a keB;
    private com.faceunity.gles.c keC;
    private int keD;
    private com.faceunity.a.e keE;
    private com.faceunity.a.a keF;
    private volatile HandlerC0457d keG;
    private c keI;
    private int keL;
    private int keM;
    private b keN;
    private final Object keO;
    private boolean keP;
    private final Object keQ;
    private boolean keR;
    private boolean keS;
    private boolean keT;
    private long keU;
    private com.faceunity.a.c ker;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object keH = new Object();
    private long keJ = 0;
    private long keK = 0;

    /* loaded from: classes5.dex */
    public interface c {
        void ctx();

        void cty();
    }

    public boolean DN(int i) {
        return this.adF == i;
    }

    public d() {
        this.adF = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iZT = lVar.bMn();
        }
        this.keN = null;
        this.keO = new Object();
        this.keP = false;
        this.keQ = new Object();
        this.keR = false;
        this.keS = false;
        this.keT = false;
        this.keU = 0L;
        this.adF = 2;
    }

    /* loaded from: classes5.dex */
    public static class b {
        final int ipJ;
        final File jnK;
        final long keJ;
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.jnK = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.ipJ = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.keJ = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.ipJ + " to '" + this.jnK.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.keL = iArr[0];
        GLES20.glBindTexture(3553, this.keL);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.keM = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.adF = 5;
        this.keJ = bVar.keJ;
        this.keK = System.nanoTime();
        synchronized (this.keH) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.keH.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.keG.sendMessage(this.keG.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.keM}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.keL}, 0);
        this.keM = 0;
        this.keL = 0;
        if (this.ker == null || !this.ker.isStarted()) {
            this.keT = true;
            if (this.keE != null) {
                this.keE.requestStop();
            }
        }
        this.adF = 4;
        this.keG.sendMessage(this.keG.obtainMessage(1));
        this.keG.sendMessage(this.keG.obtainMessage(5));
    }

    public void d(SurfaceTexture surfaceTexture) {
        synchronized (this.keH) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.keG.sendMessage(this.keG.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.keL != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.keM);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.keL, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.keH) {
                if (this.mReady) {
                    this.keG.sendMessage(this.keG.obtainMessage(3, this.keL, 0, null));
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
            synchronized (d.this.keH) {
                d.this.keG = new HandlerC0457d(d.this);
                d.this.mReady = true;
                d.this.keH.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.keH) {
                d.this.mReady = d.this.mRunning = false;
                d.this.keG = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class HandlerC0457d extends Handler {
        private WeakReference<d> keW;

        public HandlerC0457d(d dVar) {
            this.keW = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.keW.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.th();
                        return;
                    case 2:
                        if (dVar.keS) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.keS) {
                            dVar.DO(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.keS) {
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
        this.keN = bVar;
        this.keD = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.ipJ, bVar.jnK);
        this.keT = false;
        if (this.keI != null) {
            this.keI.ctx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.keL != 0) {
            try {
                this.keE.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.keN.mWidth, this.keN.mHeight);
            synchronized (d.class) {
                this.keC.drawFrame(this.mTextureId, fArr);
            }
            if (this.keA != null) {
                this.keA.setPresentationTime(cIG() * 1000);
                this.keA.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.keE.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.keT = true;
        tp();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.keR) {
            synchronized (this.keQ) {
                try {
                    this.keQ.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.keR = false;
        if (this.keI != null) {
            this.keI.cty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DO(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.keA != null) {
            this.keA.releaseEglSurface();
        }
        this.keC.release(false);
        if (this.keB != null) {
            this.keB.release();
        }
        this.keB = new com.faceunity.gles.a(eGLContext, 1);
        if (this.keA != null) {
            this.keA.a(this.keB);
            this.keA.makeCurrent();
        }
        this.keC = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.ker = new com.faceunity.a.c(file.toString());
            this.keE = new com.faceunity.a.e(i, i2, i3, this.ker);
            this.keF = new com.faceunity.a.a(this.ker);
            this.keS = true;
            synchronized (this.keO) {
                this.keP = true;
                this.keO.notify();
            }
        } catch (IOException e2) {
            if (this.iZT != null) {
                this.iZT.av(12, com.baidu.tieba.j.a.p(e2));
            }
        } catch (IllegalStateException e3) {
            this.keS = false;
            if (this.iZT != null) {
                this.iZT.av(13, com.baidu.tieba.j.a.p(e3));
                return;
            }
            return;
        }
        this.keB = new com.faceunity.gles.a(eGLContext, 1);
        this.keA = new com.faceunity.gles.e(this.keB, this.keE.getInputSurface(), true);
        this.keA.makeCurrent();
        this.keC = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void tp() {
        try {
            this.keE.release();
            if (this.keA != null) {
                this.keA.release();
                this.keA = null;
            }
            if (this.keC != null) {
                this.keC.release(false);
                this.keC = null;
            }
            if (this.keB != null) {
                this.keB.release();
                this.keB = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.iZT != null) {
                this.iZT.av(14, com.baidu.tieba.j.a.p(e2));
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
            synchronized (d.this.keO) {
                while (!d.this.keP) {
                    try {
                        d.this.keO.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.keP = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.cIF() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.adF = 1;
                    while (!d.this.keT) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.keF.f(allocateDirect, read, d.this.cIG());
                                d.this.keF.cIE();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.keF.f(null, 0, d.this.cIG());
                    bVar.release();
                    d.this.keF.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.keQ) {
                d.this.keR = true;
                d.this.keQ.notify();
            }
        }
    }

    protected long cIG() {
        long nanoTime = System.nanoTime();
        if (this.keJ != 0) {
            if (this.keK == 0) {
                this.keK = nanoTime;
            }
            nanoTime = (nanoTime - this.keK) + this.keJ;
        }
        long j = nanoTime / 1000;
        if (j < this.keU) {
            j += this.keU - j;
        }
        if (j == this.keU) {
            j += 100;
        }
        this.keU = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.keI = cVar;
    }
}
