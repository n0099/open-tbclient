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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tieba.l.g;
import com.baidu.tieba.l.k;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes7.dex */
public class d {
    private static final int[] pQq = {1, 0, 5, 7, 6};
    private int chW;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private g nAz;
    private com.faceunity.a.a pQA;
    private volatile HandlerC1072d pQB;
    private c pQC;
    private int pQF;
    private int pQG;
    private b pQH;
    private final Object pQI;
    private boolean pQJ;
    private final Object pQK;
    private boolean pQL;
    private boolean pQM;
    private boolean pQN;
    private long pQO;
    private com.faceunity.a.c pQp;
    private com.faceunity.gles.e pQv;
    private com.faceunity.gles.a pQw;
    private com.faceunity.gles.c pQx;
    private int pQy;
    private com.faceunity.a.e pQz;
    private Object mReadyFence = new Object();
    private long pQD = 0;
    private long pQE = 0;

    /* loaded from: classes7.dex */
    public interface c {
        void VO();

        void dUy();
    }

    public boolean Qx(int i) {
        return this.chW == i;
    }

    public d() {
        this.chW = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.nAz = kVar.dho();
        }
        this.pQH = null;
        this.pQI = new Object();
        this.pQJ = false;
        this.pQK = new Object();
        this.pQL = false;
        this.pQM = false;
        this.pQN = false;
        this.pQO = 0L;
        this.chW = 2;
    }

    /* loaded from: classes7.dex */
    public static class b {
        final int mBitRate;
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final File nNi;
        final long pQD;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.nNi = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.mBitRate = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.pQD = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.mBitRate + " to '" + this.nNi.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.pQF = iArr[0];
        GLES20.glBindTexture(3553, this.pQF);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.pQG = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.chW = 5;
        this.pQD = bVar.pQD;
        this.pQE = System.nanoTime();
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
            this.pQB.sendMessage(this.pQB.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.pQG}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.pQF}, 0);
        this.pQG = 0;
        this.pQF = 0;
        if (this.pQp == null || !this.pQp.isStarted()) {
            this.pQN = true;
            if (this.pQz != null) {
                this.pQz.requestStop();
            }
        }
        this.chW = 4;
        this.pQB.sendMessage(this.pQB.obtainMessage(1));
        this.pQB.sendMessage(this.pQB.obtainMessage(5));
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
                    this.pQB.sendMessage(this.pQB.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.pQF != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.pQG);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.pQF, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.pQB.sendMessage(this.pQB.obtainMessage(3, this.pQF, 0, null));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    private class e extends Thread {
        public e(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (d.this.mReadyFence) {
                d.this.pQB = new HandlerC1072d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.pQB = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static class HandlerC1072d extends Handler {
        private WeakReference<d> mWeakEncoder;

        public HandlerC1072d(d dVar) {
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
                        if (dVar.pQM) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.pQM) {
                            dVar.Qy(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.pQM) {
                            dVar.c((EGLContext) message.obj);
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
        this.pQH = bVar;
        this.pQy = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.mBitRate, bVar.nNi);
        this.pQN = false;
        if (this.pQC != null) {
            this.pQC.VO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.pQF != 0) {
            try {
                this.pQz.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.pQH.mWidth, this.pQH.mHeight);
            synchronized (d.class) {
                this.pQx.drawFrame(this.mTextureId, fArr);
            }
            if (this.pQv != null) {
                this.pQv.setPresentationTime(eAD() * 1000);
                this.pQv.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.pQz.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.pQN = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.pQL) {
            synchronized (this.pQK) {
                try {
                    this.pQK.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.pQL = false;
        if (this.pQC != null) {
            this.pQC.dUy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qy(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.pQv != null) {
            this.pQv.releaseEglSurface();
        }
        this.pQx.release(false);
        if (this.pQw != null) {
            this.pQw.release();
        }
        this.pQw = new com.faceunity.gles.a(eGLContext, 1);
        if (this.pQv != null) {
            this.pQv.a(this.pQw);
            this.pQv.makeCurrent();
        }
        this.pQx = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.pQp = new com.faceunity.a.c(file.toString());
            this.pQz = new com.faceunity.a.e(i, i2, i3, this.pQp);
            this.pQA = new com.faceunity.a.a(this.pQp);
            this.pQM = true;
            synchronized (this.pQI) {
                this.pQJ = true;
                this.pQI.notify();
            }
        } catch (IOException e2) {
            if (this.nAz != null) {
                this.nAz.bK(12, com.baidu.tieba.l.a.o(e2));
            }
        } catch (IllegalStateException e3) {
            this.pQM = false;
            if (this.nAz != null) {
                this.nAz.bK(13, com.baidu.tieba.l.a.o(e3));
                return;
            }
            return;
        }
        this.pQw = new com.faceunity.gles.a(eGLContext, 1);
        this.pQv = new com.faceunity.gles.e(this.pQw, this.pQz.getInputSurface(), true);
        this.pQv.makeCurrent();
        this.pQx = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.pQz.release();
            if (this.pQv != null) {
                this.pQv.release();
                this.pQv = null;
            }
            if (this.pQx != null) {
                this.pQx.release(false);
                this.pQx = null;
            }
            if (this.pQw != null) {
                this.pQw.release();
                this.pQw = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.nAz != null) {
                this.nAz.bK(14, com.baidu.tieba.l.a.o(e2));
            }
        }
    }

    /* loaded from: classes7.dex */
    private class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            synchronized (d.this.pQI) {
                while (!d.this.pQJ) {
                    try {
                        d.this.pQI.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.pQJ = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.eAC() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.chW = 1;
                    while (!d.this.pQN) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.pQA.f(allocateDirect, e2, d.this.eAD());
                                d.this.pQA.eAB();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.pQA.f(null, 0, d.this.eAD());
                    bVar.release();
                    d.this.pQA.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.pQK) {
                d.this.pQL = true;
                d.this.pQK.notify();
            }
        }
    }

    protected long eAD() {
        long nanoTime = System.nanoTime();
        if (this.pQD != 0) {
            if (this.pQE == 0) {
                this.pQE = nanoTime;
            }
            nanoTime = (nanoTime - this.pQE) + this.pQD;
        }
        long j = nanoTime / 1000;
        if (j < this.pQO) {
            j += this.pQO - j;
        }
        if (j == this.pQO) {
            j += 100;
        }
        this.pQO = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.pQC = cVar;
    }
}
