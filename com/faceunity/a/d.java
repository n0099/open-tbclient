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
    private static final int[] ivi = {1, 0, 5, 7, 6};
    private h hpD;
    private int ivA;
    private b ivB;
    private final Object ivC;
    private boolean ivD;
    private final Object ivE;
    private boolean ivF;
    private boolean ivG;
    private boolean ivH;
    private long ivI;
    private com.faceunity.a.c ivf;
    private com.faceunity.gles.e ivo;
    private com.faceunity.gles.a ivp;
    private com.faceunity.gles.c ivq;
    private int ivr;
    private com.faceunity.a.e ivs;
    private com.faceunity.a.a ivt;
    private volatile HandlerC0367d ivu;
    private int ivw;
    private c ivx;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private int texture;
    private Object ivv = new Object();
    private long ivy = 0;
    private long ivz = 0;

    /* loaded from: classes5.dex */
    public interface c {
        void bLk();

        void bLl();
    }

    public boolean ze(int i) {
        return this.ivw == i;
    }

    public d() {
        this.ivw = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.hpD = lVar.bdz();
        }
        this.ivB = null;
        this.ivC = new Object();
        this.ivD = false;
        this.ivE = new Object();
        this.ivF = false;
        this.ivG = false;
        this.ivH = false;
        this.ivI = 0L;
        this.ivw = 2;
    }

    /* loaded from: classes5.dex */
    public static class b {
        final int gGd;
        final File hDp;
        final EGLContext ivK;
        final long ivy;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.hDp = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.gGd = i3;
            if (eGLContext != null) {
                this.ivK = eGLContext;
            } else {
                this.ivK = EGL14.eglGetCurrentContext();
            }
            this.ivy = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.gGd + " to '" + this.hDp.toString() + "' ctxt=" + this.ivK;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.texture = iArr[0];
        GLES20.glBindTexture(3553, this.texture);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.ivA = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.ivw = 5;
        this.ivy = bVar.ivy;
        this.ivz = System.nanoTime();
        synchronized (this.ivv) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.ivv.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.ivu.sendMessage(this.ivu.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.ivA}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.texture}, 0);
        this.ivA = 0;
        this.texture = 0;
        if (this.ivf == null || !this.ivf.isStarted()) {
            this.ivH = true;
            if (this.ivs != null) {
                this.ivs.requestStop();
            }
        }
        this.ivw = 4;
        this.ivu.sendMessage(this.ivu.obtainMessage(1));
        this.ivu.sendMessage(this.ivu.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.ivv) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.ivu.sendMessage(this.ivu.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.texture != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.ivA);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.ivv) {
                if (this.mReady) {
                    this.ivu.sendMessage(this.ivu.obtainMessage(3, this.texture, 0, null));
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
            synchronized (d.this.ivv) {
                d.this.ivu = new HandlerC0367d(d.this);
                d.this.mReady = true;
                d.this.ivv.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.ivv) {
                d.this.mReady = d.this.mRunning = false;
                d.this.ivu = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class HandlerC0367d extends Handler {
        private WeakReference<d> ivL;

        public HandlerC0367d(d dVar) {
            this.ivL = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.ivL.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.caP();
                        return;
                    case 2:
                        if (dVar.ivG) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.ivG) {
                            dVar.zf(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.ivG) {
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
        this.ivB = bVar;
        this.ivr = 0;
        a(bVar.ivK, bVar.mWidth, bVar.mHeight, bVar.gGd, bVar.hDp);
        this.ivH = false;
        if (this.ivx != null) {
            this.ivx.bLk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.texture != 0) {
            try {
                this.ivs.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.ivB.mWidth, this.ivB.mHeight);
            synchronized (d.class) {
                this.ivq.drawFrame(this.mTextureId, fArr);
            }
            if (this.ivo != null) {
                this.ivo.setPresentationTime(caR() * 1000);
                this.ivo.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caP() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.ivs.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.ivH = true;
        caQ();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.ivF) {
            synchronized (this.ivE) {
                try {
                    this.ivE.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.ivF = false;
        if (this.ivx != null) {
            this.ivx.bLl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zf(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.ivo != null) {
            this.ivo.releaseEglSurface();
        }
        this.ivq.release(false);
        if (this.ivp != null) {
            this.ivp.release();
        }
        this.ivp = new com.faceunity.gles.a(eGLContext, 1);
        if (this.ivo != null) {
            this.ivo.a(this.ivp);
            this.ivo.makeCurrent();
        }
        this.ivq = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.ivf = new com.faceunity.a.c(file.toString());
            this.ivs = new com.faceunity.a.e(i, i2, i3, this.ivf);
            this.ivt = new com.faceunity.a.a(this.ivf);
            this.ivG = true;
            synchronized (this.ivC) {
                this.ivD = true;
                this.ivC.notify();
            }
        } catch (IOException e2) {
            if (this.hpD != null) {
                this.hpD.Y(12, com.baidu.tieba.j.a.o(e2));
            }
        } catch (IllegalStateException e3) {
            this.ivG = false;
            if (this.hpD != null) {
                this.hpD.Y(13, com.baidu.tieba.j.a.o(e3));
                return;
            }
            return;
        }
        this.ivp = new com.faceunity.gles.a(eGLContext, 1);
        this.ivo = new com.faceunity.gles.e(this.ivp, this.ivs.getInputSurface(), true);
        this.ivo.makeCurrent();
        this.ivq = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void caQ() {
        try {
            this.ivs.release();
            if (this.ivo != null) {
                this.ivo.release();
                this.ivo = null;
            }
            if (this.ivq != null) {
                this.ivq.release(false);
                this.ivq = null;
            }
            if (this.ivp != null) {
                this.ivp.release();
                this.ivp = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.hpD != null) {
                this.hpD.Y(14, com.baidu.tieba.j.a.o(e2));
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
            synchronized (d.this.ivC) {
                while (!d.this.ivD) {
                    try {
                        d.this.ivC.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.ivD = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.caO() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.ivw = 1;
                    while (!d.this.ivH) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.ivt.c(allocateDirect, read, d.this.caR());
                                d.this.ivt.caN();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.ivt.c(null, 0, d.this.caR());
                    bVar.release();
                    d.this.ivt.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.ivE) {
                d.this.ivF = true;
                d.this.ivE.notify();
            }
        }
    }

    protected long caR() {
        long nanoTime = System.nanoTime();
        if (this.ivy != 0) {
            if (this.ivz == 0) {
                this.ivz = nanoTime;
            }
            nanoTime = (nanoTime - this.ivz) + this.ivy;
        }
        long j = nanoTime / 1000;
        if (j < this.ivI) {
            j += this.ivI - j;
        }
        if (j == this.ivI) {
            j += 100;
        }
        this.ivI = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.ivx = cVar;
    }
}
