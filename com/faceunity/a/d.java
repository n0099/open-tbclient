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
/* loaded from: classes2.dex */
public class d {
    private static final int[] hMJ = {1, 0, 5, 7, 6};
    private h gWF;
    private com.faceunity.a.c hMF;
    private com.faceunity.gles.e hMP;
    private com.faceunity.gles.a hMQ;
    private com.faceunity.gles.c hMR;
    private int hMS;
    private com.faceunity.a.e hMT;
    private com.faceunity.a.a hMU;
    private volatile HandlerC0272d hMV;
    private int hMW;
    private c hMX;
    private int hNa;
    private int hNb;
    private b hNc;
    private final Object hNd;
    private boolean hNe;
    private final Object hNf;
    private boolean hNg;
    private boolean hNh;
    private boolean hNi;
    private long hNj;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long hMY = 0;
    private long hMZ = 0;

    /* loaded from: classes2.dex */
    public interface c {
        void bFE();

        void bFF();
    }

    public boolean wu(int i) {
        return this.hMW == i;
    }

    public d() {
        this.hMW = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.gWF = lVar.aYk();
        }
        this.hNc = null;
        this.hNd = new Object();
        this.hNe = false;
        this.hNf = new Object();
        this.hNg = false;
        this.hNh = false;
        this.hNi = false;
        this.hNj = 0L;
        this.hMW = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final int gns;
        final long hMY;
        final EGLContext hNl;
        final File hjS;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.hjS = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.gns = i3;
            if (eGLContext != null) {
                this.hNl = eGLContext;
            } else {
                this.hNl = EGL14.eglGetCurrentContext();
            }
            this.hMY = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.gns + " to '" + this.hjS.toString() + "' ctxt=" + this.hNl;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.hNa = iArr[0];
        GLES20.glBindTexture(3553, this.hNa);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.hNb = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.hMW = 5;
        this.hMY = bVar.hMY;
        this.hMZ = System.nanoTime();
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
            this.hMV.sendMessage(this.hMV.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.hNb}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.hNa}, 0);
        this.hNb = 0;
        this.hNa = 0;
        if (this.hMF == null || !this.hMF.isStarted()) {
            this.hNi = true;
            if (this.hMT != null) {
                this.hMT.requestStop();
            }
        }
        this.hMW = 4;
        this.hMV.sendMessage(this.hMV.obtainMessage(1));
        this.hMV.sendMessage(this.hMV.obtainMessage(5));
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
                    this.hMV.sendMessage(this.hMV.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.hNa != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.hNb);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.hNa, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.hMV.sendMessage(this.hMV.obtainMessage(3, this.hNa, 0, null));
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
                d.this.hMV = new HandlerC0272d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.hMV = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class HandlerC0272d extends Handler {
        private WeakReference<d> mWeakEncoder;

        public HandlerC0272d(d dVar) {
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
                        if (dVar.hNh) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.hNh) {
                            dVar.wv(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.hNh) {
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
        this.hNc = bVar;
        this.hMS = 0;
        a(bVar.hNl, bVar.mWidth, bVar.mHeight, bVar.gns, bVar.hjS);
        this.hNi = false;
        if (this.hMX != null) {
            this.hMX.bFE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.hNa != 0) {
            try {
                this.hMT.of(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.hNc.mWidth, this.hNc.mHeight);
            synchronized (d.class) {
                this.hMR.drawFrame(this.mTextureId, fArr);
            }
            if (this.hMP != null) {
                this.hMP.setPresentationTime(bMC() * 1000);
                this.hMP.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.hMT.of(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.hNi = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.hNg) {
            synchronized (this.hNf) {
                try {
                    this.hNf.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.hNg = false;
        if (this.hMX != null) {
            this.hMX.bFF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wv(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.hMP != null) {
            this.hMP.releaseEglSurface();
        }
        this.hMR.release(false);
        if (this.hMQ != null) {
            this.hMQ.release();
        }
        this.hMQ = new com.faceunity.gles.a(eGLContext, 1);
        if (this.hMP != null) {
            this.hMP.a(this.hMQ);
            this.hMP.makeCurrent();
        }
        this.hMR = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.hMF = new com.faceunity.a.c(file.toString());
            this.hMT = new com.faceunity.a.e(i, i2, i3, this.hMF);
            this.hMU = new com.faceunity.a.a(this.hMF);
            this.hNh = true;
            synchronized (this.hNd) {
                this.hNe = true;
                this.hNd.notify();
            }
        } catch (IOException e2) {
            if (this.gWF != null) {
                this.gWF.ab(12, com.baidu.tieba.j.a.m(e2));
            }
        } catch (IllegalStateException e3) {
            this.hNh = false;
            if (this.gWF != null) {
                this.gWF.ab(13, com.baidu.tieba.j.a.m(e3));
                return;
            }
            return;
        }
        this.hMQ = new com.faceunity.gles.a(eGLContext, 1);
        this.hMP = new com.faceunity.gles.e(this.hMQ, this.hMT.getInputSurface(), true);
        this.hMP.makeCurrent();
        this.hMR = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.hMT.release();
            if (this.hMP != null) {
                this.hMP.release();
                this.hMP = null;
            }
            if (this.hMR != null) {
                this.hMR.release(false);
                this.hMR = null;
            }
            if (this.hMQ != null) {
                this.hMQ.release();
                this.hMQ = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.gWF != null) {
                this.gWF.ab(14, com.baidu.tieba.j.a.m(e2));
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
            synchronized (d.this.hNd) {
                while (!d.this.hNe) {
                    try {
                        d.this.hNd.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.hNe = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.bMB() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.hMW = 1;
                    while (!d.this.hNi) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.hMU.c(allocateDirect, read, d.this.bMC());
                                d.this.hMU.bMA();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.hMU.c(null, 0, d.this.bMC());
                    bVar.release();
                    d.this.hMU.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.hNf) {
                d.this.hNg = true;
                d.this.hNf.notify();
            }
        }
    }

    protected long bMC() {
        long nanoTime = System.nanoTime();
        if (this.hMY != 0) {
            if (this.hMZ == 0) {
                this.hMZ = nanoTime;
            }
            nanoTime = (nanoTime - this.hMZ) + this.hMY;
        }
        long j = nanoTime / 1000;
        if (j < this.hNj) {
            j += this.hNj - j;
        }
        if (j == this.hNj) {
            j += 100;
        }
        this.hNj = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.hMX = cVar;
    }
}
