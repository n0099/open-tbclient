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
    private static final int[] mhc = {1, 0, 5, 7, 6};
    private int bfS;
    private int bvL;
    private h kTI;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private long mhA;
    private com.faceunity.a.c mhb;
    private com.faceunity.gles.e mhh;
    private com.faceunity.gles.a mhi;
    private com.faceunity.gles.c mhj;
    private com.faceunity.a.e mhk;
    private com.faceunity.a.a mhl;
    private volatile HandlerC0713d mhm;
    private c mho;
    private int mhr;
    private int mhs;
    private b mht;
    private final Object mhu;
    private boolean mhv;
    private final Object mhw;
    private boolean mhx;
    private boolean mhy;
    private boolean mhz;
    private Object mhn = new Object();
    private long mhp = 0;
    private long mhq = 0;

    /* loaded from: classes10.dex */
    public interface c {
        void Gp();

        void dcX();
    }

    public boolean HC(int i) {
        return this.bfS == i;
    }

    public d() {
        this.bfS = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.kTI = lVar.csa();
        }
        this.mht = null;
        this.mhu = new Object();
        this.mhv = false;
        this.mhw = new Object();
        this.mhx = false;
        this.mhy = false;
        this.mhz = false;
        this.mhA = 0L;
        this.bfS = 2;
    }

    /* loaded from: classes10.dex */
    public static class b {
        final int kgT;
        final File lhi;
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final long mhp;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.lhi = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.kgT = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.mhp = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.kgT + " to '" + this.lhi.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.mhr = iArr[0];
        GLES20.glBindTexture(3553, this.mhr);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.mhs = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.bfS = 5;
        this.mhp = bVar.mhp;
        this.mhq = System.nanoTime();
        synchronized (this.mhn) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.mhn.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.mhm.sendMessage(this.mhm.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.mhs}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.mhr}, 0);
        this.mhs = 0;
        this.mhr = 0;
        if (this.mhb == null || !this.mhb.isStarted()) {
            this.mhz = true;
            if (this.mhk != null) {
                this.mhk.requestStop();
            }
        }
        this.bfS = 4;
        this.mhm.sendMessage(this.mhm.obtainMessage(1));
        this.mhm.sendMessage(this.mhm.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.mhn) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.mhm.sendMessage(this.mhm.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.mhr != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.mhs);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mhr, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mhn) {
                if (this.mReady) {
                    this.mhm.sendMessage(this.mhm.obtainMessage(3, this.mhr, 0, null));
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
            synchronized (d.this.mhn) {
                d.this.mhm = new HandlerC0713d(d.this);
                d.this.mReady = true;
                d.this.mhn.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mhn) {
                d.this.mReady = d.this.mRunning = false;
                d.this.mhm = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class HandlerC0713d extends Handler {
        private WeakReference<d> mhC;

        public HandlerC0713d(d dVar) {
            this.mhC = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.mhC.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.Jq();
                        return;
                    case 2:
                        if (dVar.mhy) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.mhy) {
                            dVar.HD(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.mhy) {
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
        this.mht = bVar;
        this.bvL = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.kgT, bVar.lhi);
        this.mhz = false;
        if (this.mho != null) {
            this.mho.Gp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.mhr != 0) {
            try {
                this.mhk.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.mht.mWidth, this.mht.mHeight);
            synchronized (d.class) {
                this.mhj.drawFrame(this.mTextureId, fArr);
            }
            if (this.mhh != null) {
                this.mhh.setPresentationTime(dva() * 1000);
                this.mhh.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jq() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.mhk.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mhz = true;
        Jy();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.mhx) {
            synchronized (this.mhw) {
                try {
                    this.mhw.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.mhx = false;
        if (this.mho != null) {
            this.mho.dcX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HD(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.mhh != null) {
            this.mhh.releaseEglSurface();
        }
        this.mhj.release(false);
        if (this.mhi != null) {
            this.mhi.release();
        }
        this.mhi = new com.faceunity.gles.a(eGLContext, 1);
        if (this.mhh != null) {
            this.mhh.a(this.mhi);
            this.mhh.makeCurrent();
        }
        this.mhj = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.mhb = new com.faceunity.a.c(file.toString());
            this.mhk = new com.faceunity.a.e(i, i2, i3, this.mhb);
            this.mhl = new com.faceunity.a.a(this.mhb);
            this.mhy = true;
            synchronized (this.mhu) {
                this.mhv = true;
                this.mhu.notify();
            }
        } catch (IOException e2) {
            if (this.kTI != null) {
                this.kTI.be(12, com.baidu.tieba.k.a.s(e2));
            }
        } catch (IllegalStateException e3) {
            this.mhy = false;
            if (this.kTI != null) {
                this.kTI.be(13, com.baidu.tieba.k.a.s(e3));
                return;
            }
            return;
        }
        this.mhi = new com.faceunity.gles.a(eGLContext, 1);
        this.mhh = new com.faceunity.gles.e(this.mhi, this.mhk.getInputSurface(), true);
        this.mhh.makeCurrent();
        this.mhj = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void Jy() {
        try {
            this.mhk.release();
            if (this.mhh != null) {
                this.mhh.release();
                this.mhh = null;
            }
            if (this.mhj != null) {
                this.mhj.release(false);
                this.mhj = null;
            }
            if (this.mhi != null) {
                this.mhi.release();
                this.mhi = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.kTI != null) {
                this.kTI.be(14, com.baidu.tieba.k.a.s(e2));
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
            synchronized (d.this.mhu) {
                while (!d.this.mhv) {
                    try {
                        d.this.mhu.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.mhv = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.duZ() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.bfS = 1;
                    while (!d.this.mhz) {
                        try {
                            allocateDirect.clear();
                            int b = bVar.b(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (b > 0) {
                                allocateDirect.position(b);
                                allocateDirect.flip();
                                d.this.mhl.f(allocateDirect, b, d.this.dva());
                                d.this.mhl.duY();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.mhl.f(null, 0, d.this.dva());
                    bVar.release();
                    d.this.mhl.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.mhw) {
                d.this.mhx = true;
                d.this.mhw.notify();
            }
        }
    }

    protected long dva() {
        long nanoTime = System.nanoTime();
        if (this.mhp != 0) {
            if (this.mhq == 0) {
                this.mhq = nanoTime;
            }
            nanoTime = (nanoTime - this.mhq) + this.mhp;
        }
        long j = nanoTime / 1000;
        if (j < this.mhA) {
            j += this.mhA - j;
        }
        if (j == this.mhA) {
            j += 100;
        }
        this.mhA = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.mho = cVar;
    }
}
