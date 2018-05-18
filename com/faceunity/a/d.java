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
    private static final int[] hvq = {1, 0, 5, 7, 6};
    private h gyx;
    private com.faceunity.a.e hvA;
    private com.faceunity.a.a hvB;
    private volatile HandlerC0247d hvC;
    private int hvD;
    private c hvE;
    private int hvH;
    private int hvI;
    private b hvJ;
    private final Object hvK;
    private boolean hvL;
    private final Object hvM;
    private boolean hvN;
    private boolean hvO;
    private boolean hvP;
    private long hvQ;
    private com.faceunity.a.c hvm;
    private com.faceunity.gles.e hvw;
    private com.faceunity.gles.a hvx;
    private com.faceunity.gles.c hvy;
    private int hvz;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long hvF = 0;
    private long hvG = 0;

    /* loaded from: classes2.dex */
    public interface c {
        void byx();

        void byy();
    }

    public boolean we(int i) {
        return this.hvD == i;
    }

    public d() {
        this.hvD = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gyx = kVar.aSb();
        }
        this.hvJ = null;
        this.hvK = new Object();
        this.hvL = false;
        this.hvM = new Object();
        this.hvN = false;
        this.hvO = false;
        this.hvP = false;
        this.hvQ = 0L;
        this.hvD = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final int fQm;
        final File gLf;
        final long hvF;
        final EGLContext hvS;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.gLf = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.fQm = i3;
            if (eGLContext != null) {
                this.hvS = eGLContext;
            } else {
                this.hvS = EGL14.eglGetCurrentContext();
            }
            this.hvF = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Constants.MSG_SDK_LUA_BRIDGE_ACCELERATION_X + this.mHeight + " @" + this.fQm + " to '" + this.gLf.toString() + "' ctxt=" + this.hvS;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.hvH = iArr[0];
        GLES20.glBindTexture(3553, this.hvH);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.hvI = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.hvD = 5;
        this.hvF = bVar.hvF;
        this.hvG = System.nanoTime();
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
            this.hvC.sendMessage(this.hvC.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.hvI}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.hvH}, 0);
        this.hvI = 0;
        this.hvH = 0;
        if (this.hvm == null || !this.hvm.isStarted()) {
            this.hvP = true;
            if (this.hvA != null) {
                this.hvA.requestStop();
            }
        }
        this.hvD = 4;
        this.hvC.sendMessage(this.hvC.obtainMessage(1));
        this.hvC.sendMessage(this.hvC.obtainMessage(5));
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
                    this.hvC.sendMessage(this.hvC.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.hvH != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.hvI);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.hvH, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.hvC.sendMessage(this.hvC.obtainMessage(3, this.hvH, 0, null));
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
                d.this.hvC = new HandlerC0247d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.hvC = null;
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
                        if (dVar.hvO) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.hvO) {
                            dVar.wf(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.hvO) {
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
        this.hvJ = bVar;
        this.hvz = 0;
        a(bVar.hvS, bVar.mWidth, bVar.mHeight, bVar.fQm, bVar.gLf);
        this.hvP = false;
        if (this.hvE != null) {
            this.hvE.byx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.hvH != 0) {
            try {
                this.hvA.nT(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.hvJ.mWidth, this.hvJ.mHeight);
            synchronized (d.class) {
                this.hvy.drawFrame(this.mTextureId, fArr);
            }
            if (this.hvw != null) {
                this.hvw.setPresentationTime(bIk() * 1000);
                this.hvw.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.hvA.nT(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.hvP = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.hvN) {
            synchronized (this.hvM) {
                try {
                    this.hvM.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.hvN = false;
        if (this.hvE != null) {
            this.hvE.byy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wf(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.hvw != null) {
            this.hvw.releaseEglSurface();
        }
        this.hvy.release(false);
        if (this.hvx != null) {
            this.hvx.release();
        }
        this.hvx = new com.faceunity.gles.a(eGLContext, 1);
        if (this.hvw != null) {
            this.hvw.a(this.hvx);
            this.hvw.makeCurrent();
        }
        this.hvy = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.hvm = new com.faceunity.a.c(file.toString());
            this.hvA = new com.faceunity.a.e(i, i2, i3, this.hvm);
            this.hvB = new com.faceunity.a.a(this.hvm);
            this.hvO = true;
            synchronized (this.hvK) {
                this.hvL = true;
                this.hvK.notify();
            }
        } catch (IOException e2) {
            if (this.gyx != null) {
                this.gyx.ac(12, com.baidu.tieba.j.a.g(e2));
            }
        } catch (IllegalStateException e3) {
            this.hvO = false;
            if (this.gyx != null) {
                this.gyx.ac(13, com.baidu.tieba.j.a.g(e3));
                return;
            }
            return;
        }
        this.hvx = new com.faceunity.gles.a(eGLContext, 1);
        this.hvw = new com.faceunity.gles.e(this.hvx, this.hvA.getInputSurface(), true);
        this.hvw.makeCurrent();
        this.hvy = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.hvA.release();
            if (this.hvw != null) {
                this.hvw.release();
                this.hvw = null;
            }
            if (this.hvy != null) {
                this.hvy.release(false);
                this.hvy = null;
            }
            if (this.hvx != null) {
                this.hvx.release();
                this.hvx = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.gyx != null) {
                this.gyx.ac(14, com.baidu.tieba.j.a.g(e2));
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
            synchronized (d.this.hvK) {
                while (!d.this.hvL) {
                    try {
                        d.this.hvK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.hvL = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.bIj() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.hvD = 1;
                    while (!d.this.hvP) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.hvB.c(allocateDirect, read, d.this.bIk());
                                d.this.hvB.bIh();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.hvB.c(null, 0, d.this.bIk());
                    bVar.release();
                    d.this.hvB.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.hvM) {
                d.this.hvN = true;
                d.this.hvM.notify();
            }
        }
    }

    protected long bIk() {
        long nanoTime = System.nanoTime();
        if (this.hvF != 0) {
            if (this.hvG == 0) {
                this.hvG = nanoTime;
            }
            nanoTime = (nanoTime - this.hvG) + this.hvF;
        }
        long j = nanoTime / 1000;
        if (j < this.hvQ) {
            j += this.hvQ - j;
        }
        if (j == this.hvQ) {
            j += 100;
        }
        this.hvQ = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.hvE = cVar;
    }
}
