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
    private static final int[] hEp = {1, 0, 5, 7, 6};
    private h gPa;
    private com.faceunity.a.a hEA;
    private volatile HandlerC0266d hEB;
    private int hEC;
    private c hED;
    private int hEG;
    private int hEH;
    private b hEI;
    private final Object hEJ;
    private boolean hEK;
    private final Object hEL;
    private boolean hEM;
    private boolean hEN;
    private boolean hEO;
    private long hEP;
    private com.faceunity.a.c hEl;
    private com.faceunity.gles.e hEv;
    private com.faceunity.gles.a hEw;
    private com.faceunity.gles.c hEx;
    private int hEy;
    private com.faceunity.a.e hEz;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long hEE = 0;
    private long hEF = 0;

    /* loaded from: classes2.dex */
    public interface c {
        void bCP();

        void bCQ();
    }

    public boolean vV(int i) {
        return this.hEC == i;
    }

    public d() {
        this.hEC = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.gPa = lVar.aVW();
        }
        this.hEI = null;
        this.hEJ = new Object();
        this.hEK = false;
        this.hEL = new Object();
        this.hEM = false;
        this.hEN = false;
        this.hEO = false;
        this.hEP = 0L;
        this.hEC = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final int gfY;
        final long hEE;
        final EGLContext hER;
        final File hca;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.hca = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.gfY = i3;
            if (eGLContext != null) {
                this.hER = eGLContext;
            } else {
                this.hER = EGL14.eglGetCurrentContext();
            }
            this.hEE = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.gfY + " to '" + this.hca.toString() + "' ctxt=" + this.hER;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.hEG = iArr[0];
        GLES20.glBindTexture(3553, this.hEG);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.hEH = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.hEC = 5;
        this.hEE = bVar.hEE;
        this.hEF = System.nanoTime();
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
            this.hEB.sendMessage(this.hEB.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.hEH}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.hEG}, 0);
        this.hEH = 0;
        this.hEG = 0;
        if (this.hEl == null || !this.hEl.isStarted()) {
            this.hEO = true;
            if (this.hEz != null) {
                this.hEz.requestStop();
            }
        }
        this.hEC = 4;
        this.hEB.sendMessage(this.hEB.obtainMessage(1));
        this.hEB.sendMessage(this.hEB.obtainMessage(5));
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
                    this.hEB.sendMessage(this.hEB.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.hEG != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.hEH);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.hEG, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.hEB.sendMessage(this.hEB.obtainMessage(3, this.hEG, 0, null));
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
                d.this.hEB = new HandlerC0266d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.hEB = null;
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
                        if (dVar.hEN) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.hEN) {
                            dVar.vW(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.hEN) {
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
        this.hEI = bVar;
        this.hEy = 0;
        a(bVar.hER, bVar.mWidth, bVar.mHeight, bVar.gfY, bVar.hca);
        this.hEO = false;
        if (this.hED != null) {
            this.hED.bCP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.hEG != 0) {
            try {
                this.hEz.nI(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.hEI.mWidth, this.hEI.mHeight);
            synchronized (d.class) {
                this.hEx.drawFrame(this.mTextureId, fArr);
            }
            if (this.hEv != null) {
                this.hEv.setPresentationTime(bJL() * 1000);
                this.hEv.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.hEz.nI(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.hEO = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.hEM) {
            synchronized (this.hEL) {
                try {
                    this.hEL.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.hEM = false;
        if (this.hED != null) {
            this.hED.bCQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vW(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.hEv != null) {
            this.hEv.releaseEglSurface();
        }
        this.hEx.release(false);
        if (this.hEw != null) {
            this.hEw.release();
        }
        this.hEw = new com.faceunity.gles.a(eGLContext, 1);
        if (this.hEv != null) {
            this.hEv.a(this.hEw);
            this.hEv.makeCurrent();
        }
        this.hEx = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.hEl = new com.faceunity.a.c(file.toString());
            this.hEz = new com.faceunity.a.e(i, i2, i3, this.hEl);
            this.hEA = new com.faceunity.a.a(this.hEl);
            this.hEN = true;
            synchronized (this.hEJ) {
                this.hEK = true;
                this.hEJ.notify();
            }
        } catch (IOException e2) {
            if (this.gPa != null) {
                this.gPa.ab(12, com.baidu.tieba.j.a.m(e2));
            }
        } catch (IllegalStateException e3) {
            this.hEN = false;
            if (this.gPa != null) {
                this.gPa.ab(13, com.baidu.tieba.j.a.m(e3));
                return;
            }
            return;
        }
        this.hEw = new com.faceunity.gles.a(eGLContext, 1);
        this.hEv = new com.faceunity.gles.e(this.hEw, this.hEz.getInputSurface(), true);
        this.hEv.makeCurrent();
        this.hEx = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.hEz.release();
            if (this.hEv != null) {
                this.hEv.release();
                this.hEv = null;
            }
            if (this.hEx != null) {
                this.hEx.release(false);
                this.hEx = null;
            }
            if (this.hEw != null) {
                this.hEw.release();
                this.hEw = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.gPa != null) {
                this.gPa.ab(14, com.baidu.tieba.j.a.m(e2));
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
            synchronized (d.this.hEJ) {
                while (!d.this.hEK) {
                    try {
                        d.this.hEJ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.hEK = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.bJK() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.hEC = 1;
                    while (!d.this.hEO) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.hEA.c(allocateDirect, read, d.this.bJL());
                                d.this.hEA.bJJ();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.hEA.c(null, 0, d.this.bJL());
                    bVar.release();
                    d.this.hEA.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.hEL) {
                d.this.hEM = true;
                d.this.hEL.notify();
            }
        }
    }

    protected long bJL() {
        long nanoTime = System.nanoTime();
        if (this.hEE != 0) {
            if (this.hEF == 0) {
                this.hEF = nanoTime;
            }
            nanoTime = (nanoTime - this.hEF) + this.hEE;
        }
        long j = nanoTime / 1000;
        if (j < this.hEP) {
            j += this.hEP - j;
        }
        if (j == this.hEP) {
            j += 100;
        }
        this.hEP = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.hED = cVar;
    }
}
