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
    private static final int[] pqW = {1, 0, 5, 7, 6};
    private int caq;
    private int ctl;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private h nnb;
    private com.faceunity.a.c pqV;
    private com.faceunity.gles.e prb;
    private com.faceunity.gles.a prc;
    private com.faceunity.gles.c prd;
    private com.faceunity.a.e pre;
    private com.faceunity.a.a prf;
    private volatile HandlerC1001d prg;
    private c pri;
    private int prl;
    private int prm;
    private b prn;
    private final Object pro;
    private boolean prp;
    private final Object prq;
    private boolean prr;
    private boolean prs;
    private boolean prt;
    private long pru;
    private Object prh = new Object();
    private long prj = 0;
    private long prk = 0;

    /* loaded from: classes23.dex */
    public interface c {
        void WO();

        void dWl();
    }

    public boolean Rr(int i) {
        return this.caq == i;
    }

    public d() {
        this.caq = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.nnb = lVar.djb();
        }
        this.prn = null;
        this.pro = new Object();
        this.prp = false;
        this.prq = new Object();
        this.prr = false;
        this.prs = false;
        this.prt = false;
        this.pru = 0L;
        this.caq = 2;
    }

    /* loaded from: classes23.dex */
    public static class b {
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final File nBp;
        final long prj;
        final int prw;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.nBp = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.prw = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.prj = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.prw + " to '" + this.nBp.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.prl = iArr[0];
        GLES20.glBindTexture(3553, this.prl);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.prm = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.caq = 5;
        this.prj = bVar.prj;
        this.prk = System.nanoTime();
        synchronized (this.prh) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.prh.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.prg.sendMessage(this.prg.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.prm}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.prl}, 0);
        this.prm = 0;
        this.prl = 0;
        if (this.pqV == null || !this.pqV.isStarted()) {
            this.prt = true;
            if (this.pre != null) {
                this.pre.requestStop();
            }
        }
        this.caq = 4;
        this.prg.sendMessage(this.prg.obtainMessage(1));
        this.prg.sendMessage(this.prg.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.prh) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.prg.sendMessage(this.prg.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.prl != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.prm);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.prl, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.prh) {
                if (this.mReady) {
                    this.prg.sendMessage(this.prg.obtainMessage(3, this.prl, 0, null));
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
            synchronized (d.this.prh) {
                d.this.prg = new HandlerC1001d(d.this);
                d.this.mReady = true;
                d.this.prh.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.prh) {
                d.this.mReady = d.this.mRunning = false;
                d.this.prg = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private static class HandlerC1001d extends Handler {
        private WeakReference<d> prx;

        public HandlerC1001d(d dVar) {
            this.prx = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.prx.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.abu();
                        return;
                    case 2:
                        if (dVar.prs) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.prs) {
                            dVar.Rs(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.prs) {
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
        this.prn = bVar;
        this.ctl = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.prw, bVar.nBp);
        this.prt = false;
        if (this.pri != null) {
            this.pri.WO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.prl != 0) {
            try {
                this.pre.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.prn.mWidth, this.prn.mHeight);
            synchronized (d.class) {
                this.prd.drawFrame(this.mTextureId, fArr);
            }
            if (this.prb != null) {
                this.prb.setPresentationTime(exA() * 1000);
                this.prb.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abu() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.pre.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.prt = true;
        abC();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.prr) {
            synchronized (this.prq) {
                try {
                    this.prq.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.prr = false;
        if (this.pri != null) {
            this.pri.dWl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rs(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.prb != null) {
            this.prb.releaseEglSurface();
        }
        this.prd.release(false);
        if (this.prc != null) {
            this.prc.release();
        }
        this.prc = new com.faceunity.gles.a(eGLContext, 1);
        if (this.prb != null) {
            this.prb.a(this.prc);
            this.prb.makeCurrent();
        }
        this.prd = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.pqV = new com.faceunity.a.c(file.toString());
            this.pre = new com.faceunity.a.e(i, i2, i3, this.pqV);
            this.prf = new com.faceunity.a.a(this.pqV);
            this.prs = true;
            synchronized (this.pro) {
                this.prp = true;
                this.pro.notify();
            }
        } catch (IOException e2) {
            if (this.nnb != null) {
                this.nnb.bD(12, com.baidu.tieba.l.a.r(e2));
            }
        } catch (IllegalStateException e3) {
            this.prs = false;
            if (this.nnb != null) {
                this.nnb.bD(13, com.baidu.tieba.l.a.r(e3));
                return;
            }
            return;
        }
        this.prc = new com.faceunity.gles.a(eGLContext, 1);
        this.prb = new com.faceunity.gles.e(this.prc, this.pre.getInputSurface(), true);
        this.prb.makeCurrent();
        this.prd = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void abC() {
        try {
            this.pre.release();
            if (this.prb != null) {
                this.prb.release();
                this.prb = null;
            }
            if (this.prd != null) {
                this.prd.release(false);
                this.prd = null;
            }
            if (this.prc != null) {
                this.prc.release();
                this.prc = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.nnb != null) {
                this.nnb.bD(14, com.baidu.tieba.l.a.r(e2));
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
            synchronized (d.this.pro) {
                while (!d.this.prp) {
                    try {
                        d.this.pro.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.prp = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.exz() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.caq = 1;
                    while (!d.this.prt) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.prf.f(allocateDirect, e2, d.this.exA());
                                d.this.prf.exy();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.prf.f(null, 0, d.this.exA());
                    bVar.release();
                    d.this.prf.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.prq) {
                d.this.prr = true;
                d.this.prq.notify();
            }
        }
    }

    protected long exA() {
        long nanoTime = System.nanoTime();
        if (this.prj != 0) {
            if (this.prk == 0) {
                this.prk = nanoTime;
            }
            nanoTime = (nanoTime - this.prk) + this.prj;
        }
        long j = nanoTime / 1000;
        if (j < this.pru) {
            j += this.pru - j;
        }
        if (j == this.pru) {
            j += 100;
        }
        this.pru = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.pri = cVar;
    }
}
