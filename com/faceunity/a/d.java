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
import com.baidu.tieba.k.h;
import com.baidu.tieba.k.l;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes23.dex */
public class d {
    private static final int[] paD = {1, 0, 5, 7, 6};
    private int bWL;
    private int cob;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private h mYk;
    private com.faceunity.a.c paC;
    private com.faceunity.gles.e paI;
    private com.faceunity.gles.a paJ;
    private com.faceunity.gles.c paK;
    private com.faceunity.a.e paL;
    private com.faceunity.a.a paM;
    private volatile HandlerC0983d paN;
    private c paP;
    private int paS;
    private int paT;
    private b paU;
    private final Object paV;
    private boolean paW;
    private final Object paX;
    private boolean paY;
    private boolean paZ;
    private boolean pba;
    private long pbb;
    private Object paO = new Object();
    private long paQ = 0;
    private long paR = 0;

    /* loaded from: classes23.dex */
    public interface c {
        void UV();

        void dQS();
    }

    public boolean PT(int i) {
        return this.bWL == i;
    }

    public d() {
        this.bWL = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mYk = lVar.det();
        }
        this.paU = null;
        this.paV = new Object();
        this.paW = false;
        this.paX = new Object();
        this.paY = false;
        this.paZ = false;
        this.pba = false;
        this.pbb = 0L;
        this.bWL = 2;
    }

    /* loaded from: classes23.dex */
    public static class b {
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final File nmf;
        final long paQ;
        final int pbd;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.nmf = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.pbd = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.paQ = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.pbd + " to '" + this.nmf.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.paS = iArr[0];
        GLES20.glBindTexture(3553, this.paS);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.paT = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.bWL = 5;
        this.paQ = bVar.paQ;
        this.paR = System.nanoTime();
        synchronized (this.paO) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.paO.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.paN.sendMessage(this.paN.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.paT}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.paS}, 0);
        this.paT = 0;
        this.paS = 0;
        if (this.paC == null || !this.paC.isStarted()) {
            this.pba = true;
            if (this.paL != null) {
                this.paL.requestStop();
            }
        }
        this.bWL = 4;
        this.paN.sendMessage(this.paN.obtainMessage(1));
        this.paN.sendMessage(this.paN.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.paO) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.paN.sendMessage(this.paN.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.paS != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.paT);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.paS, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.paO) {
                if (this.mReady) {
                    this.paN.sendMessage(this.paN.obtainMessage(3, this.paS, 0, null));
                }
            }
        }
    }

    /* loaded from: classes23.dex */
    private class e extends Thread {
        public e(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (d.this.paO) {
                d.this.paN = new HandlerC0983d(d.this);
                d.this.mReady = true;
                d.this.paO.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.paO) {
                d.this.mReady = d.this.mRunning = false;
                d.this.paN = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private static class HandlerC0983d extends Handler {
        private WeakReference<d> pbe;

        public HandlerC0983d(d dVar) {
            this.pbe = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.pbe.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.ZA();
                        return;
                    case 2:
                        if (dVar.paZ) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.paZ) {
                            dVar.PU(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.paZ) {
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
        this.paU = bVar;
        this.cob = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.pbd, bVar.nmf);
        this.pba = false;
        if (this.paP != null) {
            this.paP.UV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.paS != 0) {
            try {
                this.paL.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.paU.mWidth, this.paU.mHeight);
            synchronized (d.class) {
                this.paK.drawFrame(this.mTextureId, fArr);
            }
            if (this.paI != null) {
                this.paI.setPresentationTime(esc() * 1000);
                this.paI.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZA() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.paL.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.pba = true;
        ZI();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.paY) {
            synchronized (this.paX) {
                try {
                    this.paX.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.paY = false;
        if (this.paP != null) {
            this.paP.dQS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PU(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.paI != null) {
            this.paI.releaseEglSurface();
        }
        this.paK.release(false);
        if (this.paJ != null) {
            this.paJ.release();
        }
        this.paJ = new com.faceunity.gles.a(eGLContext, 1);
        if (this.paI != null) {
            this.paI.a(this.paJ);
            this.paI.makeCurrent();
        }
        this.paK = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.paC = new com.faceunity.a.c(file.toString());
            this.paL = new com.faceunity.a.e(i, i2, i3, this.paC);
            this.paM = new com.faceunity.a.a(this.paC);
            this.paZ = true;
            synchronized (this.paV) {
                this.paW = true;
                this.paV.notify();
            }
        } catch (IOException e2) {
            if (this.mYk != null) {
                this.mYk.bF(12, com.baidu.tieba.k.a.r(e2));
            }
        } catch (IllegalStateException e3) {
            this.paZ = false;
            if (this.mYk != null) {
                this.mYk.bF(13, com.baidu.tieba.k.a.r(e3));
                return;
            }
            return;
        }
        this.paJ = new com.faceunity.gles.a(eGLContext, 1);
        this.paI = new com.faceunity.gles.e(this.paJ, this.paL.getInputSurface(), true);
        this.paI.makeCurrent();
        this.paK = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void ZI() {
        try {
            this.paL.release();
            if (this.paI != null) {
                this.paI.release();
                this.paI = null;
            }
            if (this.paK != null) {
                this.paK.release(false);
                this.paK = null;
            }
            if (this.paJ != null) {
                this.paJ.release();
                this.paJ = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.mYk != null) {
                this.mYk.bF(14, com.baidu.tieba.k.a.r(e2));
            }
        }
    }

    /* loaded from: classes23.dex */
    private class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            synchronized (d.this.paV) {
                while (!d.this.paW) {
                    try {
                        d.this.paV.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.paW = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.esb() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.bWL = 1;
                    while (!d.this.pba) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.paM.f(allocateDirect, e2, d.this.esc());
                                d.this.paM.esa();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.paM.f(null, 0, d.this.esc());
                    bVar.release();
                    d.this.paM.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.paX) {
                d.this.paY = true;
                d.this.paX.notify();
            }
        }
    }

    protected long esc() {
        long nanoTime = System.nanoTime();
        if (this.paQ != 0) {
            if (this.paR == 0) {
                this.paR = nanoTime;
            }
            nanoTime = (nanoTime - this.paR) + this.paQ;
        }
        long j = nanoTime / 1000;
        if (j < this.pbb) {
            j += this.pbb - j;
        }
        if (j == this.pbb) {
            j += 100;
        }
        this.pbb = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.paP = cVar;
    }
}
