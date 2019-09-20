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
import com.baidu.mobstat.Config;
import com.baidu.tieba.j.h;
import com.baidu.tieba.j.l;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes5.dex */
public class d {
    private static final int[] kpg = {1, 0, 5, 7, 6};
    private int aec;
    private h jjR;
    private final Object kpA;
    private boolean kpB;
    private final Object kpC;
    private boolean kpD;
    private boolean kpE;
    private boolean kpF;
    private long kpG;
    private com.faceunity.a.c kpe;
    private com.faceunity.gles.e kpm;
    private com.faceunity.gles.a kpn;
    private com.faceunity.gles.c kpo;
    private int kpp;
    private com.faceunity.a.e kpq;
    private com.faceunity.a.a kpr;
    private volatile HandlerC0473d kps;
    private c kpu;
    private int kpx;
    private int kpy;
    private b kpz;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object kpt = new Object();
    private long kpv = 0;
    private long kpw = 0;

    /* loaded from: classes5.dex */
    public interface c {
        void cxv();

        void cxw();
    }

    public boolean EA(int i) {
        return this.aec == i;
    }

    public d() {
        this.aec = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.jjR = lVar.bPY();
        }
        this.kpz = null;
        this.kpA = new Object();
        this.kpB = false;
        this.kpC = new Object();
        this.kpD = false;
        this.kpE = false;
        this.kpF = false;
        this.kpG = 0L;
        this.aec = 2;
    }

    /* loaded from: classes5.dex */
    public static class b {
        final int izf;
        final File jxy;
        final long kpv;
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.jxy = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.izf = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.kpv = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.izf + " to '" + this.jxy.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.kpx = iArr[0];
        GLES20.glBindTexture(3553, this.kpx);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.kpy = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.aec = 5;
        this.kpv = bVar.kpv;
        this.kpw = System.nanoTime();
        synchronized (this.kpt) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.kpt.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.kps.sendMessage(this.kps.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.kpy}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.kpx}, 0);
        this.kpy = 0;
        this.kpx = 0;
        if (this.kpe == null || !this.kpe.isStarted()) {
            this.kpF = true;
            if (this.kpq != null) {
                this.kpq.requestStop();
            }
        }
        this.aec = 4;
        this.kps.sendMessage(this.kps.obtainMessage(1));
        this.kps.sendMessage(this.kps.obtainMessage(5));
    }

    public void d(SurfaceTexture surfaceTexture) {
        synchronized (this.kpt) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.kps.sendMessage(this.kps.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.kpx != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.kpy);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.kpx, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.kpt) {
                if (this.mReady) {
                    this.kps.sendMessage(this.kps.obtainMessage(3, this.kpx, 0, null));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    private class e extends Thread {
        public e(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (d.this.kpt) {
                d.this.kps = new HandlerC0473d(d.this);
                d.this.mReady = true;
                d.this.kpt.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.kpt) {
                d.this.mReady = d.this.mRunning = false;
                d.this.kps = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class HandlerC0473d extends Handler {
        private WeakReference<d> kpI;

        public HandlerC0473d(d dVar) {
            this.kpI = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.kpI.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.tH();
                        return;
                    case 2:
                        if (dVar.kpE) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.kpE) {
                            dVar.EB(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.kpE) {
                            dVar.d((EGLContext) message.obj);
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
        this.kpz = bVar;
        this.kpp = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.izf, bVar.jxy);
        this.kpF = false;
        if (this.kpu != null) {
            this.kpu.cxv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.kpx != 0) {
            try {
                this.kpq.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.kpz.mWidth, this.kpz.mHeight);
            synchronized (d.class) {
                this.kpo.drawFrame(this.mTextureId, fArr);
            }
            if (this.kpm != null) {
                this.kpm.setPresentationTime(cMT() * 1000);
                this.kpm.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tH() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.kpq.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.kpF = true;
        tO();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.kpD) {
            synchronized (this.kpC) {
                try {
                    this.kpC.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.kpD = false;
        if (this.kpu != null) {
            this.kpu.cxw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EB(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.kpm != null) {
            this.kpm.releaseEglSurface();
        }
        this.kpo.release(false);
        if (this.kpn != null) {
            this.kpn.release();
        }
        this.kpn = new com.faceunity.gles.a(eGLContext, 1);
        if (this.kpm != null) {
            this.kpm.a(this.kpn);
            this.kpm.makeCurrent();
        }
        this.kpo = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.kpe = new com.faceunity.a.c(file.toString());
            this.kpq = new com.faceunity.a.e(i, i2, i3, this.kpe);
            this.kpr = new com.faceunity.a.a(this.kpe);
            this.kpE = true;
            synchronized (this.kpA) {
                this.kpB = true;
                this.kpA.notify();
            }
        } catch (IOException e2) {
            if (this.jjR != null) {
                this.jjR.av(12, com.baidu.tieba.j.a.p(e2));
            }
        } catch (IllegalStateException e3) {
            this.kpE = false;
            if (this.jjR != null) {
                this.jjR.av(13, com.baidu.tieba.j.a.p(e3));
                return;
            }
            return;
        }
        this.kpn = new com.faceunity.gles.a(eGLContext, 1);
        this.kpm = new com.faceunity.gles.e(this.kpn, this.kpq.getInputSurface(), true);
        this.kpm.makeCurrent();
        this.kpo = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void tO() {
        try {
            this.kpq.release();
            if (this.kpm != null) {
                this.kpm.release();
                this.kpm = null;
            }
            if (this.kpo != null) {
                this.kpo.release(false);
                this.kpo = null;
            }
            if (this.kpn != null) {
                this.kpn.release();
                this.kpn = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.jjR != null) {
                this.jjR.av(14, com.baidu.tieba.j.a.p(e2));
            }
        }
    }

    /* loaded from: classes5.dex */
    private class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            synchronized (d.this.kpA) {
                while (!d.this.kpB) {
                    try {
                        d.this.kpA.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.kpB = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.cMS() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.tE();
                    d.this.aec = 1;
                    while (!d.this.kpF) {
                        try {
                            allocateDirect.clear();
                            int b = bVar.b(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (b > 0) {
                                allocateDirect.position(b);
                                allocateDirect.flip();
                                d.this.kpr.f(allocateDirect, b, d.this.cMT());
                                d.this.kpr.cMQ();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.kpr.f(null, 0, d.this.cMT());
                    bVar.release();
                    d.this.kpr.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.kpC) {
                d.this.kpD = true;
                d.this.kpC.notify();
            }
        }
    }

    protected long cMT() {
        long nanoTime = System.nanoTime();
        if (this.kpv != 0) {
            if (this.kpw == 0) {
                this.kpw = nanoTime;
            }
            nanoTime = (nanoTime - this.kpw) + this.kpv;
        }
        long j = nanoTime / 1000;
        if (j < this.kpG) {
            j += this.kpG - j;
        }
        if (j == this.kpG) {
            j += 100;
        }
        this.kpG = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.kpu = cVar;
    }
}
