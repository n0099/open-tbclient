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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
    private static final int[] hXt = {1, 0, 5, 7, 6};
    private com.faceunity.gles.a hXA;
    private com.faceunity.gles.c hXB;
    private int hXC;
    private com.faceunity.a.e hXD;
    private com.faceunity.a.a hXE;
    private volatile HandlerC0179d hXF;
    private int hXG;
    private c hXH;
    private int hXK;
    private int hXL;
    private b hXM;
    private final Object hXN;
    private boolean hXO;
    private final Object hXP;
    private boolean hXQ;
    private boolean hXR;
    private boolean hXS;
    private long hXT;
    private com.faceunity.a.c hXp;
    private com.faceunity.gles.e hXz;
    private h hjJ;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long hXI = 0;
    private long hXJ = 0;

    /* loaded from: classes2.dex */
    public interface c {
        void bJu();

        void bJv();
    }

    public boolean zv(int i) {
        return this.hXG == i;
    }

    public d() {
        this.hXG = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.hjJ = kVar.aVn();
        }
        this.hXM = null;
        this.hXN = new Object();
        this.hXO = false;
        this.hXP = new Object();
        this.hXQ = false;
        this.hXR = false;
        this.hXS = false;
        this.hXT = 0L;
        this.hXG = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final int gDk;
        final long hXI;
        final EGLContext hXV;
        final File hxa;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.hxa = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.gDk = i3;
            if (eGLContext != null) {
                this.hXV = eGLContext;
            } else {
                this.hXV = EGL14.eglGetCurrentContext();
            }
            this.hXI = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.gDk + " to '" + this.hxa.toString() + "' ctxt=" + this.hXV;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.hXK = iArr[0];
        GLES20.glBindTexture(3553, this.hXK);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.hXL = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.hXG = 5;
        this.hXI = bVar.hXI;
        this.hXJ = System.nanoTime();
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
            this.hXF.sendMessage(this.hXF.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.hXL}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.hXK}, 0);
        this.hXL = 0;
        this.hXK = 0;
        if (this.hXp == null || !this.hXp.isStarted()) {
            this.hXS = true;
            if (this.hXD != null) {
                this.hXD.requestStop();
            }
        }
        this.hXG = 4;
        this.hXF.sendMessage(this.hXF.obtainMessage(1));
        this.hXF.sendMessage(this.hXF.obtainMessage(5));
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
                    this.hXF.sendMessage(this.hXF.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.hXK != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.hXL);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.hXK, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.hXF.sendMessage(this.hXF.obtainMessage(3, this.hXK, 0, null));
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
                d.this.hXF = new HandlerC0179d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.hXF = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class HandlerC0179d extends Handler {
        private WeakReference<d> mWeakEncoder;

        public HandlerC0179d(d dVar) {
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
                        if (dVar.hXR) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.hXR) {
                            dVar.zw(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.hXR) {
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
        this.hXM = bVar;
        this.hXC = 0;
        a(bVar.hXV, bVar.mWidth, bVar.mHeight, bVar.gDk, bVar.hxa);
        this.hXS = false;
        if (this.hXH != null) {
            this.hXH.bJu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.hXK != 0) {
            try {
                this.hXD.oJ(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.hXM.mWidth, this.hXM.mHeight);
            synchronized (d.class) {
                this.hXB.drawFrame(this.mTextureId, fArr);
            }
            if (this.hXz != null) {
                this.hXz.setPresentationTime(bPF() * 1000);
                this.hXz.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.hXD.oJ(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.hXS = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.hXQ) {
            synchronized (this.hXP) {
                try {
                    this.hXP.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.hXQ = false;
        if (this.hXH != null) {
            this.hXH.bJv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zw(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.hXz != null) {
            this.hXz.releaseEglSurface();
        }
        this.hXB.release(false);
        if (this.hXA != null) {
            this.hXA.release();
        }
        this.hXA = new com.faceunity.gles.a(eGLContext, 1);
        if (this.hXz != null) {
            this.hXz.a(this.hXA);
            this.hXz.makeCurrent();
        }
        this.hXB = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.hXp = new com.faceunity.a.c(file.toString());
            this.hXD = new com.faceunity.a.e(i, i2, i3, this.hXp);
            this.hXE = new com.faceunity.a.a(this.hXp);
            this.hXR = true;
            synchronized (this.hXN) {
                this.hXO = true;
                this.hXN.notify();
            }
        } catch (IOException e2) {
            if (this.hjJ != null) {
                this.hjJ.P(12, com.baidu.tieba.i.a.i(e2));
            }
        } catch (IllegalStateException e3) {
            this.hXR = false;
            if (this.hjJ != null) {
                this.hjJ.P(13, com.baidu.tieba.i.a.i(e3));
                return;
            }
            return;
        }
        this.hXA = new com.faceunity.gles.a(eGLContext, 1);
        this.hXz = new com.faceunity.gles.e(this.hXA, this.hXD.getInputSurface(), true);
        this.hXz.makeCurrent();
        this.hXB = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.hXD.release();
            if (this.hXz != null) {
                this.hXz.release();
                this.hXz = null;
            }
            if (this.hXB != null) {
                this.hXB.release(false);
                this.hXB = null;
            }
            if (this.hXA != null) {
                this.hXA.release();
                this.hXA = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.hjJ != null) {
                this.hjJ.P(14, com.baidu.tieba.i.a.i(e2));
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
            synchronized (d.this.hXN) {
                while (!d.this.hXO) {
                    try {
                        d.this.hXN.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.hXO = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.bPE() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.hXG = 1;
                    while (!d.this.hXS) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.hXE.a(allocateDirect, read, d.this.bPF());
                                d.this.hXE.bPC();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.hXE.a(null, 0, d.this.bPF());
                    bVar.release();
                    d.this.hXE.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.hXP) {
                d.this.hXQ = true;
                d.this.hXP.notify();
            }
        }
    }

    protected long bPF() {
        long nanoTime = System.nanoTime();
        if (this.hXI != 0) {
            if (this.hXJ == 0) {
                this.hXJ = nanoTime;
            }
            nanoTime = (nanoTime - this.hXJ) + this.hXI;
        }
        long j = nanoTime / 1000;
        if (j < this.hXT) {
            j += this.hXT - j;
        }
        if (j == this.hXT) {
            j += 100;
        }
        this.hXT = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.hXH = cVar;
    }
}
