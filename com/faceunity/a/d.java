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
import com.baidu.ar.util.Constants;
import com.baidu.tieba.j.h;
import com.baidu.tieba.j.k;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes2.dex */
public class d {
    private static final int[] hum = {1, 0, 5, 7, 6};
    private h gxt;
    private c huA;
    private int huD;
    private int huE;
    private b huF;
    private final Object huG;
    private boolean huH;
    private final Object huI;
    private boolean huJ;
    private boolean huK;
    private boolean huL;
    private long huM;
    private com.faceunity.a.c hui;
    private com.faceunity.gles.e hus;
    private com.faceunity.gles.a hut;
    private com.faceunity.gles.c huu;
    private int huv;
    private com.faceunity.a.e huw;
    private com.faceunity.a.a hux;
    private volatile HandlerC0247d huy;
    private int huz;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long huB = 0;
    private long huC = 0;

    /* loaded from: classes2.dex */
    public interface c {
        void byA();

        void byz();
    }

    public boolean wf(int i) {
        return this.huz == i;
    }

    public d() {
        this.huz = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gxt = kVar.aSb();
        }
        this.huF = null;
        this.huG = new Object();
        this.huH = false;
        this.huI = new Object();
        this.huJ = false;
        this.huK = false;
        this.huL = false;
        this.huM = 0L;
        this.huz = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final int fPg;
        final File gKc;
        final long huB;
        final EGLContext huO;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.gKc = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.fPg = i3;
            if (eGLContext != null) {
                this.huO = eGLContext;
            } else {
                this.huO = EGL14.eglGetCurrentContext();
            }
            this.huB = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Constants.MSG_SDK_LUA_BRIDGE_ACCELERATION_X + this.mHeight + " @" + this.fPg + " to '" + this.gKc.toString() + "' ctxt=" + this.huO;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.huD = iArr[0];
        GLES20.glBindTexture(3553, this.huD);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.huE = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.huz = 5;
        this.huB = bVar.huB;
        this.huC = System.nanoTime();
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
            this.huy.sendMessage(this.huy.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.huE}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.huD}, 0);
        this.huE = 0;
        this.huD = 0;
        if (this.hui == null || !this.hui.isStarted()) {
            this.huL = true;
            if (this.huw != null) {
                this.huw.requestStop();
            }
        }
        this.huz = 4;
        this.huy.sendMessage(this.huy.obtainMessage(1));
        this.huy.sendMessage(this.huy.obtainMessage(5));
    }

    public void c(SurfaceTexture surfaceTexture) {
        synchronized (this.mReadyFence) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.huy.sendMessage(this.huy.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.huD != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.huE);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.huD, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.huy.sendMessage(this.huy.obtainMessage(3, this.huD, 0, null));
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
                d.this.huy = new HandlerC0247d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.huy = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class HandlerC0247d extends Handler {
        private WeakReference<d> mWeakEncoder;

        public HandlerC0247d(d dVar) {
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
                        if (dVar.huK) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.huK) {
                            dVar.wg(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.huK) {
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
        this.huF = bVar;
        this.huv = 0;
        a(bVar.huO, bVar.mWidth, bVar.mHeight, bVar.fPg, bVar.gKc);
        this.huL = false;
        if (this.huA != null) {
            this.huA.byz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.huD != 0) {
            try {
                this.huw.nS(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.huF.mWidth, this.huF.mHeight);
            synchronized (d.class) {
                this.huu.drawFrame(this.mTextureId, fArr);
            }
            if (this.hus != null) {
                this.hus.setPresentationTime(bIm() * 1000);
                this.hus.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.huw.nS(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.huL = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.huJ) {
            synchronized (this.huI) {
                try {
                    this.huI.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.huJ = false;
        if (this.huA != null) {
            this.huA.byA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wg(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.hus != null) {
            this.hus.releaseEglSurface();
        }
        this.huu.release(false);
        if (this.hut != null) {
            this.hut.release();
        }
        this.hut = new com.faceunity.gles.a(eGLContext, 1);
        if (this.hus != null) {
            this.hus.a(this.hut);
            this.hus.makeCurrent();
        }
        this.huu = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.hui = new com.faceunity.a.c(file.toString());
            this.huw = new com.faceunity.a.e(i, i2, i3, this.hui);
            this.hux = new com.faceunity.a.a(this.hui);
            this.huK = true;
            synchronized (this.huG) {
                this.huH = true;
                this.huG.notify();
            }
        } catch (IOException e2) {
            if (this.gxt != null) {
                this.gxt.ac(12, com.baidu.tieba.j.a.g(e2));
            }
        } catch (IllegalStateException e3) {
            this.huK = false;
            if (this.gxt != null) {
                this.gxt.ac(13, com.baidu.tieba.j.a.g(e3));
                return;
            }
            return;
        }
        this.hut = new com.faceunity.gles.a(eGLContext, 1);
        this.hus = new com.faceunity.gles.e(this.hut, this.huw.getInputSurface(), true);
        this.hus.makeCurrent();
        this.huu = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.huw.release();
            if (this.hus != null) {
                this.hus.release();
                this.hus = null;
            }
            if (this.huu != null) {
                this.huu.release(false);
                this.huu = null;
            }
            if (this.hut != null) {
                this.hut.release();
                this.hut = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.gxt != null) {
                this.gxt.ac(14, com.baidu.tieba.j.a.g(e2));
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
            synchronized (d.this.huG) {
                while (!d.this.huH) {
                    try {
                        d.this.huG.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.huH = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.bIl() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.huz = 1;
                    while (!d.this.huL) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.hux.c(allocateDirect, read, d.this.bIm());
                                d.this.hux.bIj();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.hux.c(null, 0, d.this.bIm());
                    bVar.release();
                    d.this.hux.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.huI) {
                d.this.huJ = true;
                d.this.huI.notify();
            }
        }
    }

    protected long bIm() {
        long nanoTime = System.nanoTime();
        if (this.huB != 0) {
            if (this.huC == 0) {
                this.huC = nanoTime;
            }
            nanoTime = (nanoTime - this.huC) + this.huB;
        }
        long j = nanoTime / 1000;
        if (j < this.huM) {
            j += this.huM - j;
        }
        if (j == this.huM) {
            j += 100;
        }
        this.huM = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.huA = cVar;
    }
}
