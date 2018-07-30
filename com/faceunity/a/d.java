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
import com.baidu.tieba.j.l;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes2.dex */
public class d {
    private static final int[] hEn = {1, 0, 5, 7, 6};
    private h gOY;
    private int hEA;
    private c hEB;
    private int hEE;
    private int hEF;
    private b hEG;
    private final Object hEH;
    private boolean hEI;
    private final Object hEJ;
    private boolean hEK;
    private boolean hEL;
    private boolean hEM;
    private long hEN;
    private com.faceunity.a.c hEj;
    private com.faceunity.gles.e hEt;
    private com.faceunity.gles.a hEu;
    private com.faceunity.gles.c hEv;
    private int hEw;
    private com.faceunity.a.e hEx;
    private com.faceunity.a.a hEy;
    private volatile HandlerC0266d hEz;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long hEC = 0;
    private long hED = 0;

    /* loaded from: classes2.dex */
    public interface c {
        void bCN();

        void bCO();
    }

    public boolean vV(int i) {
        return this.hEA == i;
    }

    public d() {
        this.hEA = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.gOY = lVar.aWa();
        }
        this.hEG = null;
        this.hEH = new Object();
        this.hEI = false;
        this.hEJ = new Object();
        this.hEK = false;
        this.hEL = false;
        this.hEM = false;
        this.hEN = 0L;
        this.hEA = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final int gfZ;
        final long hEC;
        final EGLContext hEP;
        final File hbZ;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.hbZ = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.gfZ = i3;
            if (eGLContext != null) {
                this.hEP = eGLContext;
            } else {
                this.hEP = EGL14.eglGetCurrentContext();
            }
            this.hEC = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.gfZ + " to '" + this.hbZ.toString() + "' ctxt=" + this.hEP;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.hEE = iArr[0];
        GLES20.glBindTexture(3553, this.hEE);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.hEF = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.hEA = 5;
        this.hEC = bVar.hEC;
        this.hED = System.nanoTime();
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
            this.hEz.sendMessage(this.hEz.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.hEF}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.hEE}, 0);
        this.hEF = 0;
        this.hEE = 0;
        if (this.hEj == null || !this.hEj.isStarted()) {
            this.hEM = true;
            if (this.hEx != null) {
                this.hEx.requestStop();
            }
        }
        this.hEA = 4;
        this.hEz.sendMessage(this.hEz.obtainMessage(1));
        this.hEz.sendMessage(this.hEz.obtainMessage(5));
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
                    this.hEz.sendMessage(this.hEz.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.hEE != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.hEF);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.hEE, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.hEz.sendMessage(this.hEz.obtainMessage(3, this.hEE, 0, null));
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
                d.this.hEz = new HandlerC0266d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.hEz = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class HandlerC0266d extends Handler {
        private WeakReference<d> mWeakEncoder;

        public HandlerC0266d(d dVar) {
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
                        if (dVar.hEL) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.hEL) {
                            dVar.vW(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.hEL) {
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
        this.hEG = bVar;
        this.hEw = 0;
        a(bVar.hEP, bVar.mWidth, bVar.mHeight, bVar.gfZ, bVar.hbZ);
        this.hEM = false;
        if (this.hEB != null) {
            this.hEB.bCN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.hEE != 0) {
            try {
                this.hEx.nI(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.hEG.mWidth, this.hEG.mHeight);
            synchronized (d.class) {
                this.hEv.drawFrame(this.mTextureId, fArr);
            }
            if (this.hEt != null) {
                this.hEt.setPresentationTime(bJH() * 1000);
                this.hEt.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.hEx.nI(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.hEM = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.hEK) {
            synchronized (this.hEJ) {
                try {
                    this.hEJ.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.hEK = false;
        if (this.hEB != null) {
            this.hEB.bCO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vW(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.hEt != null) {
            this.hEt.releaseEglSurface();
        }
        this.hEv.release(false);
        if (this.hEu != null) {
            this.hEu.release();
        }
        this.hEu = new com.faceunity.gles.a(eGLContext, 1);
        if (this.hEt != null) {
            this.hEt.a(this.hEu);
            this.hEt.makeCurrent();
        }
        this.hEv = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.hEj = new com.faceunity.a.c(file.toString());
            this.hEx = new com.faceunity.a.e(i, i2, i3, this.hEj);
            this.hEy = new com.faceunity.a.a(this.hEj);
            this.hEL = true;
            synchronized (this.hEH) {
                this.hEI = true;
                this.hEH.notify();
            }
        } catch (IOException e2) {
            if (this.gOY != null) {
                this.gOY.ab(12, com.baidu.tieba.j.a.m(e2));
            }
        } catch (IllegalStateException e3) {
            this.hEL = false;
            if (this.gOY != null) {
                this.gOY.ab(13, com.baidu.tieba.j.a.m(e3));
                return;
            }
            return;
        }
        this.hEu = new com.faceunity.gles.a(eGLContext, 1);
        this.hEt = new com.faceunity.gles.e(this.hEu, this.hEx.getInputSurface(), true);
        this.hEt.makeCurrent();
        this.hEv = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.hEx.release();
            if (this.hEt != null) {
                this.hEt.release();
                this.hEt = null;
            }
            if (this.hEv != null) {
                this.hEv.release(false);
                this.hEv = null;
            }
            if (this.hEu != null) {
                this.hEu.release();
                this.hEu = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.gOY != null) {
                this.gOY.ab(14, com.baidu.tieba.j.a.m(e2));
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
            synchronized (d.this.hEH) {
                while (!d.this.hEI) {
                    try {
                        d.this.hEH.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.hEI = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.bJG() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.hEA = 1;
                    while (!d.this.hEM) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.hEy.c(allocateDirect, read, d.this.bJH());
                                d.this.hEy.bJF();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.hEy.c(null, 0, d.this.bJH());
                    bVar.release();
                    d.this.hEy.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.hEJ) {
                d.this.hEK = true;
                d.this.hEJ.notify();
            }
        }
    }

    protected long bJH() {
        long nanoTime = System.nanoTime();
        if (this.hEC != 0) {
            if (this.hED == 0) {
                this.hED = nanoTime;
            }
            nanoTime = (nanoTime - this.hED) + this.hEC;
        }
        long j = nanoTime / 1000;
        if (j < this.hEN) {
            j += this.hEN - j;
        }
        if (j == this.hEN) {
            j += 100;
        }
        this.hEN = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.hEB = cVar;
    }
}
