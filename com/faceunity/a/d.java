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
import com.baidu.tieba.k.h;
import com.baidu.tieba.k.l;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes10.dex */
public class d {
    private static final int[] mYs = {1, 0, 5, 7, 6};
    private int bIh;
    private int bsw;
    private h lHf;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private com.faceunity.a.e mYA;
    private com.faceunity.a.a mYB;
    private volatile HandlerC0810d mYC;
    private c mYE;
    private int mYH;
    private int mYI;
    private b mYJ;
    private final Object mYK;
    private boolean mYL;
    private final Object mYM;
    private boolean mYN;
    private boolean mYO;
    private boolean mYP;
    private long mYQ;
    private com.faceunity.a.c mYr;
    private com.faceunity.gles.e mYx;
    private com.faceunity.gles.a mYy;
    private com.faceunity.gles.c mYz;
    private Object mYD = new Object();
    private long mYF = 0;
    private long mYG = 0;

    /* loaded from: classes10.dex */
    public interface c {
        void Ju();

        void doO();
    }

    public boolean Jx(int i) {
        return this.bsw == i;
    }

    public d() {
        this.bsw = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.lHf = lVar.cCQ();
        }
        this.mYJ = null;
        this.mYK = new Object();
        this.mYL = false;
        this.mYM = new Object();
        this.mYN = false;
        this.mYO = false;
        this.mYP = false;
        this.mYQ = 0L;
        this.bsw = 2;
    }

    /* loaded from: classes10.dex */
    public static class b {
        final int kTS;
        final File lUP;
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final long mYF;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.lUP = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.kTS = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.mYF = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.kTS + " to '" + this.lUP.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.mYH = iArr[0];
        GLES20.glBindTexture(3553, this.mYH);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.mYI = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.bsw = 5;
        this.mYF = bVar.mYF;
        this.mYG = System.nanoTime();
        synchronized (this.mYD) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.mYD.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.mYC.sendMessage(this.mYC.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.mYI}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.mYH}, 0);
        this.mYI = 0;
        this.mYH = 0;
        if (this.mYr == null || !this.mYr.isStarted()) {
            this.mYP = true;
            if (this.mYA != null) {
                this.mYA.requestStop();
            }
        }
        this.bsw = 4;
        this.mYC.sendMessage(this.mYC.obtainMessage(1));
        this.mYC.sendMessage(this.mYC.obtainMessage(5));
    }

    public void f(SurfaceTexture surfaceTexture) {
        synchronized (this.mYD) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.mYC.sendMessage(this.mYC.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.mYH != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.mYI);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mYH, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mYD) {
                if (this.mReady) {
                    this.mYC.sendMessage(this.mYC.obtainMessage(3, this.mYH, 0, null));
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    private class e extends Thread {
        public e(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (d.this.mYD) {
                d.this.mYC = new HandlerC0810d(d.this);
                d.this.mReady = true;
                d.this.mYD.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mYD) {
                d.this.mReady = d.this.mRunning = false;
                d.this.mYC = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class HandlerC0810d extends Handler {
        private WeakReference<d> mYS;

        public HandlerC0810d(d dVar) {
            this.mYS = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.mYS.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.Mr();
                        return;
                    case 2:
                        if (dVar.mYO) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.mYO) {
                            dVar.Jy(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.mYO) {
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
        this.mYJ = bVar;
        this.bIh = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.kTS, bVar.lUP);
        this.mYP = false;
        if (this.mYE != null) {
            this.mYE.Ju();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.mYH != 0) {
            try {
                this.mYA.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.mYJ.mWidth, this.mYJ.mHeight);
            synchronized (d.class) {
                this.mYz.drawFrame(this.mTextureId, fArr);
            }
            if (this.mYx != null) {
                this.mYx.setPresentationTime(dHj() * 1000);
                this.mYx.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mr() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.mYA.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mYP = true;
        Mz();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.mYN) {
            synchronized (this.mYM) {
                try {
                    this.mYM.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.mYN = false;
        if (this.mYE != null) {
            this.mYE.doO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jy(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.mYx != null) {
            this.mYx.releaseEglSurface();
        }
        this.mYz.release(false);
        if (this.mYy != null) {
            this.mYy.release();
        }
        this.mYy = new com.faceunity.gles.a(eGLContext, 1);
        if (this.mYx != null) {
            this.mYx.a(this.mYy);
            this.mYx.makeCurrent();
        }
        this.mYz = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.mYr = new com.faceunity.a.c(file.toString());
            this.mYA = new com.faceunity.a.e(i, i2, i3, this.mYr);
            this.mYB = new com.faceunity.a.a(this.mYr);
            this.mYO = true;
            synchronized (this.mYK) {
                this.mYL = true;
                this.mYK.notify();
            }
        } catch (IOException e2) {
            if (this.lHf != null) {
                this.lHf.bn(12, com.baidu.tieba.k.a.t(e2));
            }
        } catch (IllegalStateException e3) {
            this.mYO = false;
            if (this.lHf != null) {
                this.lHf.bn(13, com.baidu.tieba.k.a.t(e3));
                return;
            }
            return;
        }
        this.mYy = new com.faceunity.gles.a(eGLContext, 1);
        this.mYx = new com.faceunity.gles.e(this.mYy, this.mYA.getInputSurface(), true);
        this.mYx.makeCurrent();
        this.mYz = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void Mz() {
        try {
            this.mYA.release();
            if (this.mYx != null) {
                this.mYx.release();
                this.mYx = null;
            }
            if (this.mYz != null) {
                this.mYz.release(false);
                this.mYz = null;
            }
            if (this.mYy != null) {
                this.mYy.release();
                this.mYy = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.lHf != null) {
                this.lHf.bn(14, com.baidu.tieba.k.a.t(e2));
            }
        }
    }

    /* loaded from: classes10.dex */
    private class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            synchronized (d.this.mYK) {
                while (!d.this.mYL) {
                    try {
                        d.this.mYK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.mYL = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.dHi() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.bsw = 1;
                    while (!d.this.mYP) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.mYB.f(allocateDirect, e2, d.this.dHj());
                                d.this.mYB.dHh();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.mYB.f(null, 0, d.this.dHj());
                    bVar.release();
                    d.this.mYB.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.mYM) {
                d.this.mYN = true;
                d.this.mYM.notify();
            }
        }
    }

    protected long dHj() {
        long nanoTime = System.nanoTime();
        if (this.mYF != 0) {
            if (this.mYG == 0) {
                this.mYG = nanoTime;
            }
            nanoTime = (nanoTime - this.mYG) + this.mYF;
        }
        long j = nanoTime / 1000;
        if (j < this.mYQ) {
            j += this.mYQ - j;
        }
        if (j == this.mYQ) {
            j += 100;
        }
        this.mYQ = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.mYE = cVar;
    }
}
