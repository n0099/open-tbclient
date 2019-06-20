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
    private static final int[] kew = {1, 0, 5, 7, 6};
    private int adF;
    private h iZX;
    private com.faceunity.gles.e keD;
    private com.faceunity.gles.a keE;
    private com.faceunity.gles.c keF;
    private int keG;
    private com.faceunity.a.e keH;
    private com.faceunity.a.a keI;
    private volatile HandlerC0457d keJ;
    private c keL;
    private int keO;
    private int keP;
    private b keQ;
    private final Object keR;
    private boolean keS;
    private final Object keT;
    private boolean keU;
    private boolean keV;
    private boolean keW;
    private long keX;
    private com.faceunity.a.c keu;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object keK = new Object();
    private long keM = 0;
    private long keN = 0;

    /* loaded from: classes5.dex */
    public interface c {
        void ctw();

        void ctx();
    }

    public boolean DN(int i) {
        return this.adF == i;
    }

    public d() {
        this.adF = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iZX = lVar.bMo();
        }
        this.keQ = null;
        this.keR = new Object();
        this.keS = false;
        this.keT = new Object();
        this.keU = false;
        this.keV = false;
        this.keW = false;
        this.keX = 0L;
        this.adF = 2;
    }

    /* loaded from: classes5.dex */
    public static class b {
        final int ipK;
        final File jnO;
        final long keM;
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.jnO = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.ipK = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.keM = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.ipK + " to '" + this.jnO.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.keO = iArr[0];
        GLES20.glBindTexture(3553, this.keO);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.keP = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.adF = 5;
        this.keM = bVar.keM;
        this.keN = System.nanoTime();
        synchronized (this.keK) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.keK.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.keJ.sendMessage(this.keJ.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.keP}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.keO}, 0);
        this.keP = 0;
        this.keO = 0;
        if (this.keu == null || !this.keu.isStarted()) {
            this.keW = true;
            if (this.keH != null) {
                this.keH.requestStop();
            }
        }
        this.adF = 4;
        this.keJ.sendMessage(this.keJ.obtainMessage(1));
        this.keJ.sendMessage(this.keJ.obtainMessage(5));
    }

    public void d(SurfaceTexture surfaceTexture) {
        synchronized (this.keK) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.keJ.sendMessage(this.keJ.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.keO != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.keP);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.keO, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.keK) {
                if (this.mReady) {
                    this.keJ.sendMessage(this.keJ.obtainMessage(3, this.keO, 0, null));
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
            synchronized (d.this.keK) {
                d.this.keJ = new HandlerC0457d(d.this);
                d.this.mReady = true;
                d.this.keK.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.keK) {
                d.this.mReady = d.this.mRunning = false;
                d.this.keJ = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class HandlerC0457d extends Handler {
        private WeakReference<d> keZ;

        public HandlerC0457d(d dVar) {
            this.keZ = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.keZ.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.th();
                        return;
                    case 2:
                        if (dVar.keV) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.keV) {
                            dVar.DO(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.keV) {
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
        this.keQ = bVar;
        this.keG = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.ipK, bVar.jnO);
        this.keW = false;
        if (this.keL != null) {
            this.keL.ctw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.keO != 0) {
            try {
                this.keH.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.keQ.mWidth, this.keQ.mHeight);
            synchronized (d.class) {
                this.keF.drawFrame(this.mTextureId, fArr);
            }
            if (this.keD != null) {
                this.keD.setPresentationTime(cIF() * 1000);
                this.keD.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.keH.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.keW = true;
        tp();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.keU) {
            synchronized (this.keT) {
                try {
                    this.keT.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.keU = false;
        if (this.keL != null) {
            this.keL.ctx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DO(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.keD != null) {
            this.keD.releaseEglSurface();
        }
        this.keF.release(false);
        if (this.keE != null) {
            this.keE.release();
        }
        this.keE = new com.faceunity.gles.a(eGLContext, 1);
        if (this.keD != null) {
            this.keD.a(this.keE);
            this.keD.makeCurrent();
        }
        this.keF = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.keu = new com.faceunity.a.c(file.toString());
            this.keH = new com.faceunity.a.e(i, i2, i3, this.keu);
            this.keI = new com.faceunity.a.a(this.keu);
            this.keV = true;
            synchronized (this.keR) {
                this.keS = true;
                this.keR.notify();
            }
        } catch (IOException e2) {
            if (this.iZX != null) {
                this.iZX.av(12, com.baidu.tieba.j.a.p(e2));
            }
        } catch (IllegalStateException e3) {
            this.keV = false;
            if (this.iZX != null) {
                this.iZX.av(13, com.baidu.tieba.j.a.p(e3));
                return;
            }
            return;
        }
        this.keE = new com.faceunity.gles.a(eGLContext, 1);
        this.keD = new com.faceunity.gles.e(this.keE, this.keH.getInputSurface(), true);
        this.keD.makeCurrent();
        this.keF = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void tp() {
        try {
            this.keH.release();
            if (this.keD != null) {
                this.keD.release();
                this.keD = null;
            }
            if (this.keF != null) {
                this.keF.release(false);
                this.keF = null;
            }
            if (this.keE != null) {
                this.keE.release();
                this.keE = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.iZX != null) {
                this.iZX.av(14, com.baidu.tieba.j.a.p(e2));
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
            synchronized (d.this.keR) {
                while (!d.this.keS) {
                    try {
                        d.this.keR.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.keS = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.cIE() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.adF = 1;
                    while (!d.this.keW) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.keI.f(allocateDirect, read, d.this.cIF());
                                d.this.keI.cID();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.keI.f(null, 0, d.this.cIF());
                    bVar.release();
                    d.this.keI.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.keT) {
                d.this.keU = true;
                d.this.keT.notify();
            }
        }
    }

    protected long cIF() {
        long nanoTime = System.nanoTime();
        if (this.keM != 0) {
            if (this.keN == 0) {
                this.keN = nanoTime;
            }
            nanoTime = (nanoTime - this.keN) + this.keM;
        }
        long j = nanoTime / 1000;
        if (j < this.keX) {
            j += this.keX - j;
        }
        if (j == this.keX) {
            j += 100;
        }
        this.keX = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.keL = cVar;
    }
}
