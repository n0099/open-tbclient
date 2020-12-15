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
import com.baidu.tieba.l.h;
import com.baidu.tieba.l.l;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes23.dex */
public class d {
    private static final int[] pqY = {1, 0, 5, 7, 6};
    private int caq;
    private int ctl;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private h nnd;
    private com.faceunity.a.c pqX;
    private com.faceunity.gles.e prd;
    private com.faceunity.gles.a pre;
    private com.faceunity.gles.c prf;
    private com.faceunity.a.e prg;
    private com.faceunity.a.a prh;
    private volatile HandlerC1001d pri;
    private c prk;
    private int prn;
    private int pro;
    private b prp;
    private final Object prq;
    private boolean prr;
    private final Object prs;
    private boolean prt;
    private boolean pru;
    private boolean prv;
    private long prw;
    private Object prj = new Object();
    private long prl = 0;
    private long prm = 0;

    /* loaded from: classes23.dex */
    public interface c {
        void WO();

        void dWm();
    }

    public boolean Rr(int i) {
        return this.caq == i;
    }

    public d() {
        this.caq = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.nnd = lVar.djc();
        }
        this.prp = null;
        this.prq = new Object();
        this.prr = false;
        this.prs = new Object();
        this.prt = false;
        this.pru = false;
        this.prv = false;
        this.prw = 0L;
        this.caq = 2;
    }

    /* loaded from: classes23.dex */
    public static class b {
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final File nBr;
        final long prl;
        final int pry;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.nBr = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.pry = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.prl = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.pry + " to '" + this.nBr.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.prn = iArr[0];
        GLES20.glBindTexture(3553, this.prn);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.pro = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.caq = 5;
        this.prl = bVar.prl;
        this.prm = System.nanoTime();
        synchronized (this.prj) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.prj.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.pri.sendMessage(this.pri.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.pro}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.prn}, 0);
        this.pro = 0;
        this.prn = 0;
        if (this.pqX == null || !this.pqX.isStarted()) {
            this.prv = true;
            if (this.prg != null) {
                this.prg.requestStop();
            }
        }
        this.caq = 4;
        this.pri.sendMessage(this.pri.obtainMessage(1));
        this.pri.sendMessage(this.pri.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.prj) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.pri.sendMessage(this.pri.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.prn != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.pro);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.prn, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.prj) {
                if (this.mReady) {
                    this.pri.sendMessage(this.pri.obtainMessage(3, this.prn, 0, null));
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
            synchronized (d.this.prj) {
                d.this.pri = new HandlerC1001d(d.this);
                d.this.mReady = true;
                d.this.prj.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.prj) {
                d.this.mReady = d.this.mRunning = false;
                d.this.pri = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private static class HandlerC1001d extends Handler {
        private WeakReference<d> prz;

        public HandlerC1001d(d dVar) {
            this.prz = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.prz.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.abu();
                        return;
                    case 2:
                        if (dVar.pru) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.pru) {
                            dVar.Rs(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.pru) {
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
        this.prp = bVar;
        this.ctl = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.pry, bVar.nBr);
        this.prv = false;
        if (this.prk != null) {
            this.prk.WO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.prn != 0) {
            try {
                this.prg.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.prp.mWidth, this.prp.mHeight);
            synchronized (d.class) {
                this.prf.drawFrame(this.mTextureId, fArr);
            }
            if (this.prd != null) {
                this.prd.setPresentationTime(exB() * 1000);
                this.prd.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abu() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.prg.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.prv = true;
        abC();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.prt) {
            synchronized (this.prs) {
                try {
                    this.prs.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.prt = false;
        if (this.prk != null) {
            this.prk.dWm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rs(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.prd != null) {
            this.prd.releaseEglSurface();
        }
        this.prf.release(false);
        if (this.pre != null) {
            this.pre.release();
        }
        this.pre = new com.faceunity.gles.a(eGLContext, 1);
        if (this.prd != null) {
            this.prd.a(this.pre);
            this.prd.makeCurrent();
        }
        this.prf = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.pqX = new com.faceunity.a.c(file.toString());
            this.prg = new com.faceunity.a.e(i, i2, i3, this.pqX);
            this.prh = new com.faceunity.a.a(this.pqX);
            this.pru = true;
            synchronized (this.prq) {
                this.prr = true;
                this.prq.notify();
            }
        } catch (IOException e2) {
            if (this.nnd != null) {
                this.nnd.bD(12, com.baidu.tieba.l.a.r(e2));
            }
        } catch (IllegalStateException e3) {
            this.pru = false;
            if (this.nnd != null) {
                this.nnd.bD(13, com.baidu.tieba.l.a.r(e3));
                return;
            }
            return;
        }
        this.pre = new com.faceunity.gles.a(eGLContext, 1);
        this.prd = new com.faceunity.gles.e(this.pre, this.prg.getInputSurface(), true);
        this.prd.makeCurrent();
        this.prf = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void abC() {
        try {
            this.prg.release();
            if (this.prd != null) {
                this.prd.release();
                this.prd = null;
            }
            if (this.prf != null) {
                this.prf.release(false);
                this.prf = null;
            }
            if (this.pre != null) {
                this.pre.release();
                this.pre = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.nnd != null) {
                this.nnd.bD(14, com.baidu.tieba.l.a.r(e2));
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
            synchronized (d.this.prq) {
                while (!d.this.prr) {
                    try {
                        d.this.prq.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.prr = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.exA() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.caq = 1;
                    while (!d.this.prv) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.prh.f(allocateDirect, e2, d.this.exB());
                                d.this.prh.exz();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.prh.f(null, 0, d.this.exB());
                    bVar.release();
                    d.this.prh.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.prs) {
                d.this.prt = true;
                d.this.prs.notify();
            }
        }
    }

    protected long exB() {
        long nanoTime = System.nanoTime();
        if (this.prl != 0) {
            if (this.prm == 0) {
                this.prm = nanoTime;
            }
            nanoTime = (nanoTime - this.prm) + this.prl;
        }
        long j = nanoTime / 1000;
        if (j < this.prw) {
            j += this.prw - j;
        }
        if (j == this.prw) {
            j += 100;
        }
        this.prw = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.prk = cVar;
    }
}
