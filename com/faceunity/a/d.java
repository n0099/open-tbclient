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
    private static final int[] mhg = {1, 0, 5, 7, 6};
    private int bfX;
    private int bvQ;
    private h kTM;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private final Object mhA;
    private boolean mhB;
    private boolean mhC;
    private boolean mhD;
    private long mhE;
    private com.faceunity.a.c mhf;
    private com.faceunity.gles.e mhl;
    private com.faceunity.gles.a mhm;
    private com.faceunity.gles.c mhn;
    private com.faceunity.a.e mho;
    private com.faceunity.a.a mhp;
    private volatile HandlerC0734d mhq;
    private c mhs;
    private int mhv;
    private int mhw;
    private b mhx;
    private final Object mhy;
    private boolean mhz;
    private Object mhr = new Object();
    private long mht = 0;
    private long mhu = 0;

    /* loaded from: classes10.dex */
    public interface c {
        void Go();

        void dcU();
    }

    public boolean HC(int i) {
        return this.bfX == i;
    }

    public d() {
        this.bfX = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.kTM = lVar.crX();
        }
        this.mhx = null;
        this.mhy = new Object();
        this.mhz = false;
        this.mhA = new Object();
        this.mhB = false;
        this.mhC = false;
        this.mhD = false;
        this.mhE = 0L;
        this.bfX = 2;
    }

    /* loaded from: classes10.dex */
    public static class b {
        final int kgX;
        final File lhm;
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final long mht;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.lhm = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.kgX = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.mht = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.kgX + " to '" + this.lhm.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.mhv = iArr[0];
        GLES20.glBindTexture(3553, this.mhv);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.mhw = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.bfX = 5;
        this.mht = bVar.mht;
        this.mhu = System.nanoTime();
        synchronized (this.mhr) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.mhr.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.mhq.sendMessage(this.mhq.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.mhw}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.mhv}, 0);
        this.mhw = 0;
        this.mhv = 0;
        if (this.mhf == null || !this.mhf.isStarted()) {
            this.mhD = true;
            if (this.mho != null) {
                this.mho.requestStop();
            }
        }
        this.bfX = 4;
        this.mhq.sendMessage(this.mhq.obtainMessage(1));
        this.mhq.sendMessage(this.mhq.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.mhr) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.mhq.sendMessage(this.mhq.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.mhv != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.mhw);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mhv, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mhr) {
                if (this.mReady) {
                    this.mhq.sendMessage(this.mhq.obtainMessage(3, this.mhv, 0, null));
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
            synchronized (d.this.mhr) {
                d.this.mhq = new HandlerC0734d(d.this);
                d.this.mReady = true;
                d.this.mhr.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mhr) {
                d.this.mReady = d.this.mRunning = false;
                d.this.mhq = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class HandlerC0734d extends Handler {
        private WeakReference<d> mhG;

        public HandlerC0734d(d dVar) {
            this.mhG = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.mhG.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.Jp();
                        return;
                    case 2:
                        if (dVar.mhC) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.mhC) {
                            dVar.HD(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.mhC) {
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
        this.mhx = bVar;
        this.bvQ = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.kgX, bVar.lhm);
        this.mhD = false;
        if (this.mhs != null) {
            this.mhs.Go();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.mhv != 0) {
            try {
                this.mho.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.mhx.mWidth, this.mhx.mHeight);
            synchronized (d.class) {
                this.mhn.drawFrame(this.mTextureId, fArr);
            }
            if (this.mhl != null) {
                this.mhl.setPresentationTime(duX() * 1000);
                this.mhl.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jp() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.mho.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mhD = true;
        Jx();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.mhB) {
            synchronized (this.mhA) {
                try {
                    this.mhA.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.mhB = false;
        if (this.mhs != null) {
            this.mhs.dcU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HD(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.mhl != null) {
            this.mhl.releaseEglSurface();
        }
        this.mhn.release(false);
        if (this.mhm != null) {
            this.mhm.release();
        }
        this.mhm = new com.faceunity.gles.a(eGLContext, 1);
        if (this.mhl != null) {
            this.mhl.a(this.mhm);
            this.mhl.makeCurrent();
        }
        this.mhn = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.mhf = new com.faceunity.a.c(file.toString());
            this.mho = new com.faceunity.a.e(i, i2, i3, this.mhf);
            this.mhp = new com.faceunity.a.a(this.mhf);
            this.mhC = true;
            synchronized (this.mhy) {
                this.mhz = true;
                this.mhy.notify();
            }
        } catch (IOException e2) {
            if (this.kTM != null) {
                this.kTM.be(12, com.baidu.tieba.k.a.s(e2));
            }
        } catch (IllegalStateException e3) {
            this.mhC = false;
            if (this.kTM != null) {
                this.kTM.be(13, com.baidu.tieba.k.a.s(e3));
                return;
            }
            return;
        }
        this.mhm = new com.faceunity.gles.a(eGLContext, 1);
        this.mhl = new com.faceunity.gles.e(this.mhm, this.mho.getInputSurface(), true);
        this.mhl.makeCurrent();
        this.mhn = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void Jx() {
        try {
            this.mho.release();
            if (this.mhl != null) {
                this.mhl.release();
                this.mhl = null;
            }
            if (this.mhn != null) {
                this.mhn.release(false);
                this.mhn = null;
            }
            if (this.mhm != null) {
                this.mhm.release();
                this.mhm = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.kTM != null) {
                this.kTM.be(14, com.baidu.tieba.k.a.s(e2));
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
            synchronized (d.this.mhy) {
                while (!d.this.mhz) {
                    try {
                        d.this.mhy.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.mhz = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.duW() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.bfX = 1;
                    while (!d.this.mhD) {
                        try {
                            allocateDirect.clear();
                            int b = bVar.b(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (b > 0) {
                                allocateDirect.position(b);
                                allocateDirect.flip();
                                d.this.mhp.f(allocateDirect, b, d.this.duX());
                                d.this.mhp.duV();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.mhp.f(null, 0, d.this.duX());
                    bVar.release();
                    d.this.mhp.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.mhA) {
                d.this.mhB = true;
                d.this.mhA.notify();
            }
        }
    }

    protected long duX() {
        long nanoTime = System.nanoTime();
        if (this.mht != 0) {
            if (this.mhu == 0) {
                this.mhu = nanoTime;
            }
            nanoTime = (nanoTime - this.mhu) + this.mht;
        }
        long j = nanoTime / 1000;
        if (j < this.mhE) {
            j += this.mhE - j;
        }
        if (j == this.mhE) {
            j += 100;
        }
        this.mhE = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.mhs = cVar;
    }
}
