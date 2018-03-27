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
import com.baidu.tieba.i.h;
import com.baidu.tieba.i.k;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes2.dex */
public class d {
    private static final int[] hXp = {1, 0, 5, 7, 6};
    private com.faceunity.a.a hXA;
    private volatile HandlerC0262d hXB;
    private int hXC;
    private c hXD;
    private int hXG;
    private int hXH;
    private b hXI;
    private final Object hXJ;
    private boolean hXK;
    private final Object hXL;
    private boolean hXM;
    private boolean hXN;
    private boolean hXO;
    private long hXP;
    private com.faceunity.a.c hXl;
    private com.faceunity.gles.e hXv;
    private com.faceunity.gles.a hXw;
    private com.faceunity.gles.c hXx;
    private int hXy;
    private com.faceunity.a.e hXz;
    private h hca;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long hXE = 0;
    private long hXF = 0;

    /* loaded from: classes2.dex */
    public interface c {
        void bDF();

        void bDG();
    }

    public boolean yG(int i) {
        return this.hXC == i;
    }

    public d() {
        this.hXC = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.hca = kVar.aXg();
        }
        this.hXI = null;
        this.hXJ = new Object();
        this.hXK = false;
        this.hXL = new Object();
        this.hXM = false;
        this.hXN = false;
        this.hXO = false;
        this.hXP = 0L;
        this.hXC = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final int gux;
        final long hXE;
        final EGLContext hXR;
        final File hox;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.hox = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.gux = i3;
            if (eGLContext != null) {
                this.hXR = eGLContext;
            } else {
                this.hXR = EGL14.eglGetCurrentContext();
            }
            this.hXE = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Constants.MSG_SDK_LUA_BRIDGE_ACCELERATION_X + this.mHeight + " @" + this.gux + " to '" + this.hox.toString() + "' ctxt=" + this.hXR;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.hXG = iArr[0];
        GLES20.glBindTexture(3553, this.hXG);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.hXH = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.hXC = 5;
        this.hXE = bVar.hXE;
        this.hXF = System.nanoTime();
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
            this.hXB.sendMessage(this.hXB.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.hXH}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.hXG}, 0);
        this.hXH = 0;
        this.hXG = 0;
        if (this.hXl == null || !this.hXl.isStarted()) {
            this.hXO = true;
            if (this.hXz != null) {
                this.hXz.requestStop();
            }
        }
        this.hXC = 4;
        this.hXB.sendMessage(this.hXB.obtainMessage(1));
        this.hXB.sendMessage(this.hXB.obtainMessage(5));
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
                    this.hXB.sendMessage(this.hXB.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.hXG != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.hXH);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.hXG, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.hXB.sendMessage(this.hXB.obtainMessage(3, this.hXG, 0, null));
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
                d.this.hXB = new HandlerC0262d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.hXB = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class HandlerC0262d extends Handler {
        private WeakReference<d> mWeakEncoder;

        public HandlerC0262d(d dVar) {
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
                        if (dVar.hXN) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.hXN) {
                            dVar.yH(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.hXN) {
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
        this.hXI = bVar;
        this.hXy = 0;
        a(bVar.hXR, bVar.mWidth, bVar.mHeight, bVar.gux, bVar.hox);
        this.hXO = false;
        if (this.hXD != null) {
            this.hXD.bDF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.hXG != 0) {
            try {
                this.hXz.oq(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.hXI.mWidth, this.hXI.mHeight);
            synchronized (d.class) {
                this.hXx.drawFrame(this.mTextureId, fArr);
            }
            if (this.hXv != null) {
                this.hXv.setPresentationTime(bMN() * 1000);
                this.hXv.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.hXz.oq(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.hXO = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.hXM) {
            synchronized (this.hXL) {
                try {
                    this.hXL.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.hXM = false;
        if (this.hXD != null) {
            this.hXD.bDG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yH(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.hXv != null) {
            this.hXv.releaseEglSurface();
        }
        this.hXx.release(false);
        if (this.hXw != null) {
            this.hXw.release();
        }
        this.hXw = new com.faceunity.gles.a(eGLContext, 1);
        if (this.hXv != null) {
            this.hXv.a(this.hXw);
            this.hXv.makeCurrent();
        }
        this.hXx = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.hXl = new com.faceunity.a.c(file.toString());
            this.hXz = new com.faceunity.a.e(i, i2, i3, this.hXl);
            this.hXA = new com.faceunity.a.a(this.hXl);
            this.hXN = true;
            synchronized (this.hXJ) {
                this.hXK = true;
                this.hXJ.notify();
            }
        } catch (IOException e2) {
            if (this.hca != null) {
                this.hca.U(12, com.baidu.tieba.i.a.i(e2));
            }
        } catch (IllegalStateException e3) {
            this.hXN = false;
            if (this.hca != null) {
                this.hca.U(13, com.baidu.tieba.i.a.i(e3));
                return;
            }
            return;
        }
        this.hXw = new com.faceunity.gles.a(eGLContext, 1);
        this.hXv = new com.faceunity.gles.e(this.hXw, this.hXz.getInputSurface(), true);
        this.hXv.makeCurrent();
        this.hXx = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.hXz.release();
            if (this.hXv != null) {
                this.hXv.release();
                this.hXv = null;
            }
            if (this.hXx != null) {
                this.hXx.release(false);
                this.hXx = null;
            }
            if (this.hXw != null) {
                this.hXw.release();
                this.hXw = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.hca != null) {
                this.hca.U(14, com.baidu.tieba.i.a.i(e2));
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
            synchronized (d.this.hXJ) {
                while (!d.this.hXK) {
                    try {
                        d.this.hXJ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.hXK = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.bMM() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.hXC = 1;
                    while (!d.this.hXO) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.hXA.c(allocateDirect, read, d.this.bMN());
                                d.this.hXA.bMK();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.hXA.c(null, 0, d.this.bMN());
                    bVar.release();
                    d.this.hXA.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.hXL) {
                d.this.hXM = true;
                d.this.hXL.notify();
            }
        }
    }

    protected long bMN() {
        long nanoTime = System.nanoTime();
        if (this.hXE != 0) {
            if (this.hXF == 0) {
                this.hXF = nanoTime;
            }
            nanoTime = (nanoTime - this.hXF) + this.hXE;
        }
        long j = nanoTime / 1000;
        if (j < this.hXP) {
            j += this.hXP - j;
        }
        if (j == this.hXP) {
            j += 100;
        }
        this.hXP = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.hXD = cVar;
    }
}
