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
    private static final int[] mAX = {1, 0, 5, 7, 6};
    private int bDt;
    private int bnw;
    private h lmg;
    private com.faceunity.a.c mAW;
    private com.faceunity.gles.e mBc;
    private com.faceunity.gles.a mBd;
    private com.faceunity.gles.c mBe;
    private com.faceunity.a.e mBf;
    private com.faceunity.a.a mBh;
    private volatile HandlerC0789d mBi;
    private c mBk;
    private int mBn;
    private int mBo;
    private b mBp;
    private final Object mBq;
    private boolean mBr;
    private final Object mBs;
    private boolean mBt;
    private boolean mBu;
    private boolean mBv;
    private long mBw;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mBj = new Object();
    private long mBl = 0;
    private long mBm = 0;

    /* loaded from: classes10.dex */
    public interface c {
        void Ih();

        void dkj();
    }

    public boolean Io(int i) {
        return this.bnw == i;
    }

    public d() {
        this.bnw = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.lmg = lVar.cyB();
        }
        this.mBp = null;
        this.mBq = new Object();
        this.mBr = false;
        this.mBs = new Object();
        this.mBt = false;
        this.mBu = false;
        this.mBv = false;
        this.mBw = 0L;
        this.bnw = 2;
    }

    /* loaded from: classes10.dex */
    public static class b {
        final int kyP;
        final File lzX;
        final long mBl;
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.lzX = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.kyP = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.mBl = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.kyP + " to '" + this.lzX.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.mBn = iArr[0];
        GLES20.glBindTexture(3553, this.mBn);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.mBo = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.bnw = 5;
        this.mBl = bVar.mBl;
        this.mBm = System.nanoTime();
        synchronized (this.mBj) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.mBj.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.mBi.sendMessage(this.mBi.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.mBo}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.mBn}, 0);
        this.mBo = 0;
        this.mBn = 0;
        if (this.mAW == null || !this.mAW.isStarted()) {
            this.mBv = true;
            if (this.mBf != null) {
                this.mBf.requestStop();
            }
        }
        this.bnw = 4;
        this.mBi.sendMessage(this.mBi.obtainMessage(1));
        this.mBi.sendMessage(this.mBi.obtainMessage(5));
    }

    public void f(SurfaceTexture surfaceTexture) {
        synchronized (this.mBj) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.mBi.sendMessage(this.mBi.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.mBn != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.mBo);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mBn, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mBj) {
                if (this.mReady) {
                    this.mBi.sendMessage(this.mBi.obtainMessage(3, this.mBn, 0, null));
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
            synchronized (d.this.mBj) {
                d.this.mBi = new HandlerC0789d(d.this);
                d.this.mReady = true;
                d.this.mBj.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mBj) {
                d.this.mReady = d.this.mRunning = false;
                d.this.mBi = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class HandlerC0789d extends Handler {
        private WeakReference<d> mBy;

        public HandlerC0789d(d dVar) {
            this.mBy = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.mBy.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.Li();
                        return;
                    case 2:
                        if (dVar.mBu) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.mBu) {
                            dVar.Ip(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.mBu) {
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
        this.mBp = bVar;
        this.bDt = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.kyP, bVar.lzX);
        this.mBv = false;
        if (this.mBk != null) {
            this.mBk.Ih();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.mBn != 0) {
            try {
                this.mBf.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.mBp.mWidth, this.mBp.mHeight);
            synchronized (d.class) {
                this.mBe.drawFrame(this.mTextureId, fArr);
            }
            if (this.mBc != null) {
                this.mBc.setPresentationTime(dCp() * 1000);
                this.mBc.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Li() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.mBf.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mBv = true;
        Lq();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.mBt) {
            synchronized (this.mBs) {
                try {
                    this.mBs.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.mBt = false;
        if (this.mBk != null) {
            this.mBk.dkj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ip(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.mBc != null) {
            this.mBc.releaseEglSurface();
        }
        this.mBe.release(false);
        if (this.mBd != null) {
            this.mBd.release();
        }
        this.mBd = new com.faceunity.gles.a(eGLContext, 1);
        if (this.mBc != null) {
            this.mBc.a(this.mBd);
            this.mBc.makeCurrent();
        }
        this.mBe = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.mAW = new com.faceunity.a.c(file.toString());
            this.mBf = new com.faceunity.a.e(i, i2, i3, this.mAW);
            this.mBh = new com.faceunity.a.a(this.mAW);
            this.mBu = true;
            synchronized (this.mBq) {
                this.mBr = true;
                this.mBq.notify();
            }
        } catch (IOException e2) {
            if (this.lmg != null) {
                this.lmg.bj(12, com.baidu.tieba.k.a.t(e2));
            }
        } catch (IllegalStateException e3) {
            this.mBu = false;
            if (this.lmg != null) {
                this.lmg.bj(13, com.baidu.tieba.k.a.t(e3));
                return;
            }
            return;
        }
        this.mBd = new com.faceunity.gles.a(eGLContext, 1);
        this.mBc = new com.faceunity.gles.e(this.mBd, this.mBf.getInputSurface(), true);
        this.mBc.makeCurrent();
        this.mBe = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void Lq() {
        try {
            this.mBf.release();
            if (this.mBc != null) {
                this.mBc.release();
                this.mBc = null;
            }
            if (this.mBe != null) {
                this.mBe.release(false);
                this.mBe = null;
            }
            if (this.mBd != null) {
                this.mBd.release();
                this.mBd = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.lmg != null) {
                this.lmg.bj(14, com.baidu.tieba.k.a.t(e2));
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
            synchronized (d.this.mBq) {
                while (!d.this.mBr) {
                    try {
                        d.this.mBq.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.mBr = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.dCo() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.bnw = 1;
                    while (!d.this.mBv) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.mBh.f(allocateDirect, e2, d.this.dCp());
                                d.this.mBh.dCn();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.mBh.f(null, 0, d.this.dCp());
                    bVar.release();
                    d.this.mBh.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.mBs) {
                d.this.mBt = true;
                d.this.mBs.notify();
            }
        }
    }

    protected long dCp() {
        long nanoTime = System.nanoTime();
        if (this.mBl != 0) {
            if (this.mBm == 0) {
                this.mBm = nanoTime;
            }
            nanoTime = (nanoTime - this.mBm) + this.mBl;
        }
        long j = nanoTime / 1000;
        if (j < this.mBw) {
            j += this.mBw - j;
        }
        if (j == this.mBw) {
            j += 100;
        }
        this.mBw = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.mBk = cVar;
    }
}
