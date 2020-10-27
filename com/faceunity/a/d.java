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
    private static final int[] oRi = {1, 0, 5, 7, 6};
    private int bRb;
    private int cig;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private h mSh;
    private int mTextureId;
    private int mWidth;
    private final Object oRA;
    private boolean oRB;
    private final Object oRC;
    private boolean oRD;
    private boolean oRE;
    private boolean oRF;
    private long oRG;
    private com.faceunity.a.c oRh;
    private com.faceunity.gles.e oRn;
    private com.faceunity.gles.a oRo;
    private com.faceunity.gles.c oRp;
    private com.faceunity.a.e oRq;
    private com.faceunity.a.a oRr;
    private volatile HandlerC0964d oRs;
    private c oRu;
    private int oRx;
    private int oRy;
    private b oRz;
    private Object oRt = new Object();
    private long oRv = 0;
    private long oRw = 0;

    /* loaded from: classes23.dex */
    public interface c {
        void Sm();

        void dOq();
    }

    public boolean Py(int i) {
        return this.bRb == i;
    }

    public d() {
        this.bRb = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mSh = lVar.dbR();
        }
        this.oRz = null;
        this.oRA = new Object();
        this.oRB = false;
        this.oRC = new Object();
        this.oRD = false;
        this.oRE = false;
        this.oRF = false;
        this.oRG = 0L;
        this.bRb = 2;
    }

    /* loaded from: classes23.dex */
    public static class b {
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final File ngj;
        final int oRI;
        final long oRv;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.ngj = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.oRI = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.oRv = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.oRI + " to '" + this.ngj.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.oRx = iArr[0];
        GLES20.glBindTexture(3553, this.oRx);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.oRy = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.bRb = 5;
        this.oRv = bVar.oRv;
        this.oRw = System.nanoTime();
        synchronized (this.oRt) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.oRt.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.oRs.sendMessage(this.oRs.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.oRy}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.oRx}, 0);
        this.oRy = 0;
        this.oRx = 0;
        if (this.oRh == null || !this.oRh.isStarted()) {
            this.oRF = true;
            if (this.oRq != null) {
                this.oRq.requestStop();
            }
        }
        this.bRb = 4;
        this.oRs.sendMessage(this.oRs.obtainMessage(1));
        this.oRs.sendMessage(this.oRs.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.oRt) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.oRs.sendMessage(this.oRs.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.oRx != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.oRy);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.oRx, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.oRt) {
                if (this.mReady) {
                    this.oRs.sendMessage(this.oRs.obtainMessage(3, this.oRx, 0, null));
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
            synchronized (d.this.oRt) {
                d.this.oRs = new HandlerC0964d(d.this);
                d.this.mReady = true;
                d.this.oRt.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.oRt) {
                d.this.mReady = d.this.mRunning = false;
                d.this.oRs = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private static class HandlerC0964d extends Handler {
        private WeakReference<d> oRJ;

        public HandlerC0964d(d dVar) {
            this.oRJ = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.oRJ.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.Xb();
                        return;
                    case 2:
                        if (dVar.oRE) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.oRE) {
                            dVar.Pz(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.oRE) {
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
        this.oRz = bVar;
        this.cig = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.oRI, bVar.ngj);
        this.oRF = false;
        if (this.oRu != null) {
            this.oRu.Sm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.oRx != 0) {
            try {
                this.oRq.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.oRz.mWidth, this.oRz.mHeight);
            synchronized (d.class) {
                this.oRp.drawFrame(this.mTextureId, fArr);
            }
            if (this.oRn != null) {
                this.oRn.setPresentationTime(eon() * 1000);
                this.oRn.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xb() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.oRq.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.oRF = true;
        Xj();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.oRD) {
            synchronized (this.oRC) {
                try {
                    this.oRC.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.oRD = false;
        if (this.oRu != null) {
            this.oRu.dOq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pz(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.oRn != null) {
            this.oRn.releaseEglSurface();
        }
        this.oRp.release(false);
        if (this.oRo != null) {
            this.oRo.release();
        }
        this.oRo = new com.faceunity.gles.a(eGLContext, 1);
        if (this.oRn != null) {
            this.oRn.a(this.oRo);
            this.oRn.makeCurrent();
        }
        this.oRp = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.oRh = new com.faceunity.a.c(file.toString());
            this.oRq = new com.faceunity.a.e(i, i2, i3, this.oRh);
            this.oRr = new com.faceunity.a.a(this.oRh);
            this.oRE = true;
            synchronized (this.oRA) {
                this.oRB = true;
                this.oRA.notify();
            }
        } catch (IOException e2) {
            if (this.mSh != null) {
                this.mSh.bB(12, com.baidu.tieba.k.a.r(e2));
            }
        } catch (IllegalStateException e3) {
            this.oRE = false;
            if (this.mSh != null) {
                this.mSh.bB(13, com.baidu.tieba.k.a.r(e3));
                return;
            }
            return;
        }
        this.oRo = new com.faceunity.gles.a(eGLContext, 1);
        this.oRn = new com.faceunity.gles.e(this.oRo, this.oRq.getInputSurface(), true);
        this.oRn.makeCurrent();
        this.oRp = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void Xj() {
        try {
            this.oRq.release();
            if (this.oRn != null) {
                this.oRn.release();
                this.oRn = null;
            }
            if (this.oRp != null) {
                this.oRp.release(false);
                this.oRp = null;
            }
            if (this.oRo != null) {
                this.oRo.release();
                this.oRo = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.mSh != null) {
                this.mSh.bB(14, com.baidu.tieba.k.a.r(e2));
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
            synchronized (d.this.oRA) {
                while (!d.this.oRB) {
                    try {
                        d.this.oRA.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.oRB = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.eom() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.bRb = 1;
                    while (!d.this.oRF) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.oRr.f(allocateDirect, e2, d.this.eon());
                                d.this.oRr.eol();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.oRr.f(null, 0, d.this.eon());
                    bVar.release();
                    d.this.oRr.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.oRC) {
                d.this.oRD = true;
                d.this.oRC.notify();
            }
        }
    }

    protected long eon() {
        long nanoTime = System.nanoTime();
        if (this.oRv != 0) {
            if (this.oRw == 0) {
                this.oRw = nanoTime;
            }
            nanoTime = (nanoTime - this.oRw) + this.oRv;
        }
        long j = nanoTime / 1000;
        if (j < this.oRG) {
            j += this.oRG - j;
        }
        if (j == this.oRG) {
            j += 100;
        }
        this.oRG = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.oRu = cVar;
    }
}
