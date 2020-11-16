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
/* loaded from: classes22.dex */
public class d {
    private static final int[] pcg = {1, 0, 5, 7, 6};
    private int bVb;
    private int cmq;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private h mZc;
    private final Object pcA;
    private boolean pcB;
    private boolean pcC;
    private boolean pcD;
    private long pcE;
    private com.faceunity.a.c pcf;
    private com.faceunity.gles.e pcl;
    private com.faceunity.gles.a pcm;
    private com.faceunity.gles.c pcn;
    private com.faceunity.a.e pco;
    private com.faceunity.a.a pcp;
    private volatile HandlerC0986d pcq;
    private c pcs;
    private int pcv;
    private int pcw;
    private b pcx;
    private final Object pcy;
    private boolean pcz;
    private Object pcr = new Object();
    private long pct = 0;
    private long pcu = 0;

    /* loaded from: classes22.dex */
    public interface c {
        void Um();

        void dQR();
    }

    public boolean Qw(int i) {
        return this.bVb == i;
    }

    public d() {
        this.bVb = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mZc = lVar.ddQ();
        }
        this.pcx = null;
        this.pcy = new Object();
        this.pcz = false;
        this.pcA = new Object();
        this.pcB = false;
        this.pcC = false;
        this.pcD = false;
        this.pcE = 0L;
        this.bVb = 2;
    }

    /* loaded from: classes22.dex */
    public static class b {
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final File nnm;
        final int pcG;
        final long pct;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.nnm = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.pcG = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.pct = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.pcG + " to '" + this.nnm.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.pcv = iArr[0];
        GLES20.glBindTexture(3553, this.pcv);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.pcw = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.bVb = 5;
        this.pct = bVar.pct;
        this.pcu = System.nanoTime();
        synchronized (this.pcr) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.pcr.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.pcq.sendMessage(this.pcq.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.pcw}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.pcv}, 0);
        this.pcw = 0;
        this.pcv = 0;
        if (this.pcf == null || !this.pcf.isStarted()) {
            this.pcD = true;
            if (this.pco != null) {
                this.pco.requestStop();
            }
        }
        this.bVb = 4;
        this.pcq.sendMessage(this.pcq.obtainMessage(1));
        this.pcq.sendMessage(this.pcq.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.pcr) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.pcq.sendMessage(this.pcq.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.pcv != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.pcw);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.pcv, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.pcr) {
                if (this.mReady) {
                    this.pcq.sendMessage(this.pcq.obtainMessage(3, this.pcv, 0, null));
                }
            }
        }
    }

    /* loaded from: classes22.dex */
    private class e extends Thread {
        public e(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (d.this.pcr) {
                d.this.pcq = new HandlerC0986d(d.this);
                d.this.mReady = true;
                d.this.pcr.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.pcr) {
                d.this.mReady = d.this.mRunning = false;
                d.this.pcq = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    private static class HandlerC0986d extends Handler {
        private WeakReference<d> pcH;

        public HandlerC0986d(d dVar) {
            this.pcH = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.pcH.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.YR();
                        return;
                    case 2:
                        if (dVar.pcC) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.pcC) {
                            dVar.Qx(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.pcC) {
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
        this.pcx = bVar;
        this.cmq = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.pcG, bVar.nnm);
        this.pcD = false;
        if (this.pcs != null) {
            this.pcs.Um();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.pcv != 0) {
            try {
                this.pco.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.pcx.mWidth, this.pcx.mHeight);
            synchronized (d.class) {
                this.pcn.drawFrame(this.mTextureId, fArr);
            }
            if (this.pcl != null) {
                this.pcl.setPresentationTime(esa() * 1000);
                this.pcl.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YR() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.pco.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.pcD = true;
        YZ();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.pcB) {
            synchronized (this.pcA) {
                try {
                    this.pcA.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.pcB = false;
        if (this.pcs != null) {
            this.pcs.dQR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qx(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.pcl != null) {
            this.pcl.releaseEglSurface();
        }
        this.pcn.release(false);
        if (this.pcm != null) {
            this.pcm.release();
        }
        this.pcm = new com.faceunity.gles.a(eGLContext, 1);
        if (this.pcl != null) {
            this.pcl.a(this.pcm);
            this.pcl.makeCurrent();
        }
        this.pcn = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.pcf = new com.faceunity.a.c(file.toString());
            this.pco = new com.faceunity.a.e(i, i2, i3, this.pcf);
            this.pcp = new com.faceunity.a.a(this.pcf);
            this.pcC = true;
            synchronized (this.pcy) {
                this.pcz = true;
                this.pcy.notify();
            }
        } catch (IOException e2) {
            if (this.mZc != null) {
                this.mZc.bD(12, com.baidu.tieba.l.a.r(e2));
            }
        } catch (IllegalStateException e3) {
            this.pcC = false;
            if (this.mZc != null) {
                this.mZc.bD(13, com.baidu.tieba.l.a.r(e3));
                return;
            }
            return;
        }
        this.pcm = new com.faceunity.gles.a(eGLContext, 1);
        this.pcl = new com.faceunity.gles.e(this.pcm, this.pco.getInputSurface(), true);
        this.pcl.makeCurrent();
        this.pcn = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void YZ() {
        try {
            this.pco.release();
            if (this.pcl != null) {
                this.pcl.release();
                this.pcl = null;
            }
            if (this.pcn != null) {
                this.pcn.release(false);
                this.pcn = null;
            }
            if (this.pcm != null) {
                this.pcm.release();
                this.pcm = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.mZc != null) {
                this.mZc.bD(14, com.baidu.tieba.l.a.r(e2));
            }
        }
    }

    /* loaded from: classes22.dex */
    private class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            synchronized (d.this.pcy) {
                while (!d.this.pcz) {
                    try {
                        d.this.pcy.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.pcz = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.erZ() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.bVb = 1;
                    while (!d.this.pcD) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.pcp.f(allocateDirect, e2, d.this.esa());
                                d.this.pcp.erY();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.pcp.f(null, 0, d.this.esa());
                    bVar.release();
                    d.this.pcp.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.pcA) {
                d.this.pcB = true;
                d.this.pcA.notify();
            }
        }
    }

    protected long esa() {
        long nanoTime = System.nanoTime();
        if (this.pct != 0) {
            if (this.pcu == 0) {
                this.pcu = nanoTime;
            }
            nanoTime = (nanoTime - this.pcu) + this.pct;
        }
        long j = nanoTime / 1000;
        if (j < this.pcE) {
            j += this.pcE - j;
        }
        if (j == this.pcE) {
            j += 100;
        }
        this.pcE = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.pcs = cVar;
    }
}
