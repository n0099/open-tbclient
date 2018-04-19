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
    private static final int[] hup = {1, 0, 5, 7, 6};
    private h gxw;
    private com.faceunity.a.a huA;
    private volatile HandlerC0247d huB;
    private int huC;
    private c huD;
    private int huG;
    private int huH;
    private b huI;
    private final Object huJ;
    private boolean huK;
    private final Object huL;
    private boolean huM;
    private boolean huN;
    private boolean huO;
    private long huP;
    private com.faceunity.a.c hul;
    private com.faceunity.gles.e huv;
    private com.faceunity.gles.a huw;
    private com.faceunity.gles.c hux;
    private int huy;
    private com.faceunity.a.e huz;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long huE = 0;
    private long huF = 0;

    /* loaded from: classes2.dex */
    public interface c {
        void byA();

        void byz();
    }

    public boolean wf(int i) {
        return this.huC == i;
    }

    public d() {
        this.huC = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gxw = kVar.aSb();
        }
        this.huI = null;
        this.huJ = new Object();
        this.huK = false;
        this.huL = new Object();
        this.huM = false;
        this.huN = false;
        this.huO = false;
        this.huP = 0L;
        this.huC = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final int fPj;
        final File gKf;
        final long huE;
        final EGLContext huR;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.gKf = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.fPj = i3;
            if (eGLContext != null) {
                this.huR = eGLContext;
            } else {
                this.huR = EGL14.eglGetCurrentContext();
            }
            this.huE = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Constants.MSG_SDK_LUA_BRIDGE_ACCELERATION_X + this.mHeight + " @" + this.fPj + " to '" + this.gKf.toString() + "' ctxt=" + this.huR;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.huG = iArr[0];
        GLES20.glBindTexture(3553, this.huG);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.huH = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.huC = 5;
        this.huE = bVar.huE;
        this.huF = System.nanoTime();
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
            this.huB.sendMessage(this.huB.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.huH}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.huG}, 0);
        this.huH = 0;
        this.huG = 0;
        if (this.hul == null || !this.hul.isStarted()) {
            this.huO = true;
            if (this.huz != null) {
                this.huz.requestStop();
            }
        }
        this.huC = 4;
        this.huB.sendMessage(this.huB.obtainMessage(1));
        this.huB.sendMessage(this.huB.obtainMessage(5));
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
                    this.huB.sendMessage(this.huB.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.huG != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.huH);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.huG, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.huB.sendMessage(this.huB.obtainMessage(3, this.huG, 0, null));
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
                d.this.huB = new HandlerC0247d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.huB = null;
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
                        if (dVar.huN) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.huN) {
                            dVar.wg(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.huN) {
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
        this.huI = bVar;
        this.huy = 0;
        a(bVar.huR, bVar.mWidth, bVar.mHeight, bVar.fPj, bVar.gKf);
        this.huO = false;
        if (this.huD != null) {
            this.huD.byz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.huG != 0) {
            try {
                this.huz.nS(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.huI.mWidth, this.huI.mHeight);
            synchronized (d.class) {
                this.hux.drawFrame(this.mTextureId, fArr);
            }
            if (this.huv != null) {
                this.huv.setPresentationTime(bIm() * 1000);
                this.huv.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.huz.nS(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.huO = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.huM) {
            synchronized (this.huL) {
                try {
                    this.huL.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.huM = false;
        if (this.huD != null) {
            this.huD.byA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wg(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.huv != null) {
            this.huv.releaseEglSurface();
        }
        this.hux.release(false);
        if (this.huw != null) {
            this.huw.release();
        }
        this.huw = new com.faceunity.gles.a(eGLContext, 1);
        if (this.huv != null) {
            this.huv.a(this.huw);
            this.huv.makeCurrent();
        }
        this.hux = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.hul = new com.faceunity.a.c(file.toString());
            this.huz = new com.faceunity.a.e(i, i2, i3, this.hul);
            this.huA = new com.faceunity.a.a(this.hul);
            this.huN = true;
            synchronized (this.huJ) {
                this.huK = true;
                this.huJ.notify();
            }
        } catch (IOException e2) {
            if (this.gxw != null) {
                this.gxw.ac(12, com.baidu.tieba.j.a.g(e2));
            }
        } catch (IllegalStateException e3) {
            this.huN = false;
            if (this.gxw != null) {
                this.gxw.ac(13, com.baidu.tieba.j.a.g(e3));
                return;
            }
            return;
        }
        this.huw = new com.faceunity.gles.a(eGLContext, 1);
        this.huv = new com.faceunity.gles.e(this.huw, this.huz.getInputSurface(), true);
        this.huv.makeCurrent();
        this.hux = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.huz.release();
            if (this.huv != null) {
                this.huv.release();
                this.huv = null;
            }
            if (this.hux != null) {
                this.hux.release(false);
                this.hux = null;
            }
            if (this.huw != null) {
                this.huw.release();
                this.huw = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.gxw != null) {
                this.gxw.ac(14, com.baidu.tieba.j.a.g(e2));
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
            synchronized (d.this.huJ) {
                while (!d.this.huK) {
                    try {
                        d.this.huJ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.huK = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.bIl() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.huC = 1;
                    while (!d.this.huO) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.huA.c(allocateDirect, read, d.this.bIm());
                                d.this.huA.bIj();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.huA.c(null, 0, d.this.bIm());
                    bVar.release();
                    d.this.huA.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.huL) {
                d.this.huM = true;
                d.this.huL.notify();
            }
        }
    }

    protected long bIm() {
        long nanoTime = System.nanoTime();
        if (this.huE != 0) {
            if (this.huF == 0) {
                this.huF = nanoTime;
            }
            nanoTime = (nanoTime - this.huF) + this.huE;
        }
        long j = nanoTime / 1000;
        if (j < this.huP) {
            j += this.huP - j;
        }
        if (j == this.huP) {
            j += 100;
        }
        this.huP = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.huD = cVar;
    }
}
