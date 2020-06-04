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
    private static final int[] mCi = {1, 0, 5, 7, 6};
    private int bDt;
    private int bnw;
    private h lnq;
    private b mCA;
    private final Object mCB;
    private boolean mCC;
    private final Object mCD;
    private boolean mCE;
    private boolean mCF;
    private boolean mCG;
    private long mCH;
    private com.faceunity.a.c mCh;
    private com.faceunity.gles.e mCn;
    private com.faceunity.gles.a mCo;
    private com.faceunity.gles.c mCp;
    private com.faceunity.a.e mCq;
    private com.faceunity.a.a mCr;
    private volatile HandlerC0790d mCs;
    private c mCu;
    private int mCy;
    private int mCz;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mCt = new Object();
    private long mCw = 0;
    private long mCx = 0;

    /* loaded from: classes10.dex */
    public interface c {
        void Ih();

        void dky();
    }

    public boolean Iq(int i) {
        return this.bnw == i;
    }

    public d() {
        this.bnw = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.lnq = lVar.cyS();
        }
        this.mCA = null;
        this.mCB = new Object();
        this.mCC = false;
        this.mCD = new Object();
        this.mCE = false;
        this.mCF = false;
        this.mCG = false;
        this.mCH = 0L;
        this.bnw = 2;
    }

    /* loaded from: classes10.dex */
    public static class b {
        final int kzV;
        final File lBg;
        final long mCw;
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.lBg = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.kzV = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.mCw = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.kzV + " to '" + this.lBg.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.mCy = iArr[0];
        GLES20.glBindTexture(3553, this.mCy);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.mCz = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.bnw = 5;
        this.mCw = bVar.mCw;
        this.mCx = System.nanoTime();
        synchronized (this.mCt) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.mCt.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.mCs.sendMessage(this.mCs.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.mCz}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.mCy}, 0);
        this.mCz = 0;
        this.mCy = 0;
        if (this.mCh == null || !this.mCh.isStarted()) {
            this.mCG = true;
            if (this.mCq != null) {
                this.mCq.requestStop();
            }
        }
        this.bnw = 4;
        this.mCs.sendMessage(this.mCs.obtainMessage(1));
        this.mCs.sendMessage(this.mCs.obtainMessage(5));
    }

    public void f(SurfaceTexture surfaceTexture) {
        synchronized (this.mCt) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.mCs.sendMessage(this.mCs.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.mCy != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.mCz);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mCy, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mCt) {
                if (this.mReady) {
                    this.mCs.sendMessage(this.mCs.obtainMessage(3, this.mCy, 0, null));
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
            synchronized (d.this.mCt) {
                d.this.mCs = new HandlerC0790d(d.this);
                d.this.mReady = true;
                d.this.mCt.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mCt) {
                d.this.mReady = d.this.mRunning = false;
                d.this.mCs = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class HandlerC0790d extends Handler {
        private WeakReference<d> mCJ;

        public HandlerC0790d(d dVar) {
            this.mCJ = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.mCJ.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.Li();
                        return;
                    case 2:
                        if (dVar.mCF) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.mCF) {
                            dVar.Ir(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.mCF) {
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
        this.mCA = bVar;
        this.bDt = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.kzV, bVar.lBg);
        this.mCG = false;
        if (this.mCu != null) {
            this.mCu.Ih();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.mCy != 0) {
            try {
                this.mCq.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.mCA.mWidth, this.mCA.mHeight);
            synchronized (d.class) {
                this.mCp.drawFrame(this.mTextureId, fArr);
            }
            if (this.mCn != null) {
                this.mCn.setPresentationTime(dCD() * 1000);
                this.mCn.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Li() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.mCq.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mCG = true;
        Lq();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.mCE) {
            synchronized (this.mCD) {
                try {
                    this.mCD.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.mCE = false;
        if (this.mCu != null) {
            this.mCu.dky();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ir(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.mCn != null) {
            this.mCn.releaseEglSurface();
        }
        this.mCp.release(false);
        if (this.mCo != null) {
            this.mCo.release();
        }
        this.mCo = new com.faceunity.gles.a(eGLContext, 1);
        if (this.mCn != null) {
            this.mCn.a(this.mCo);
            this.mCn.makeCurrent();
        }
        this.mCp = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.mCh = new com.faceunity.a.c(file.toString());
            this.mCq = new com.faceunity.a.e(i, i2, i3, this.mCh);
            this.mCr = new com.faceunity.a.a(this.mCh);
            this.mCF = true;
            synchronized (this.mCB) {
                this.mCC = true;
                this.mCB.notify();
            }
        } catch (IOException e2) {
            if (this.lnq != null) {
                this.lnq.bj(12, com.baidu.tieba.k.a.t(e2));
            }
        } catch (IllegalStateException e3) {
            this.mCF = false;
            if (this.lnq != null) {
                this.lnq.bj(13, com.baidu.tieba.k.a.t(e3));
                return;
            }
            return;
        }
        this.mCo = new com.faceunity.gles.a(eGLContext, 1);
        this.mCn = new com.faceunity.gles.e(this.mCo, this.mCq.getInputSurface(), true);
        this.mCn.makeCurrent();
        this.mCp = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void Lq() {
        try {
            this.mCq.release();
            if (this.mCn != null) {
                this.mCn.release();
                this.mCn = null;
            }
            if (this.mCp != null) {
                this.mCp.release(false);
                this.mCp = null;
            }
            if (this.mCo != null) {
                this.mCo.release();
                this.mCo = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.lnq != null) {
                this.lnq.bj(14, com.baidu.tieba.k.a.t(e2));
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
            synchronized (d.this.mCB) {
                while (!d.this.mCC) {
                    try {
                        d.this.mCB.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.mCC = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.dCC() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.bnw = 1;
                    while (!d.this.mCG) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.mCr.f(allocateDirect, e2, d.this.dCD());
                                d.this.mCr.dCB();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.mCr.f(null, 0, d.this.dCD());
                    bVar.release();
                    d.this.mCr.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.mCD) {
                d.this.mCE = true;
                d.this.mCD.notify();
            }
        }
    }

    protected long dCD() {
        long nanoTime = System.nanoTime();
        if (this.mCw != 0) {
            if (this.mCx == 0) {
                this.mCx = nanoTime;
            }
            nanoTime = (nanoTime - this.mCx) + this.mCw;
        }
        long j = nanoTime / 1000;
        if (j < this.mCH) {
            j += this.mCH - j;
        }
        if (j == this.mCH) {
            j += 100;
        }
        this.mCH = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.mCu = cVar;
    }
}
