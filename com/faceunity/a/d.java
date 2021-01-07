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
import com.baidu.tieba.l.g;
import com.baidu.tieba.l.k;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes8.dex */
public class d {
    private static final int[] pId = {1, 0, 5, 7, 6};
    private int cha;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private g nsO;
    private boolean pIA;
    private boolean pIB;
    private long pIC;
    private com.faceunity.a.c pIc;
    private com.faceunity.gles.e pIi;
    private com.faceunity.gles.a pIj;
    private com.faceunity.gles.c pIk;
    private int pIl;
    private com.faceunity.a.e pIm;
    private com.faceunity.a.a pIn;
    private volatile HandlerC1068d pIo;
    private c pIq;
    private int pIt;
    private int pIu;
    private b pIv;
    private final Object pIw;
    private boolean pIx;
    private final Object pIy;
    private boolean pIz;
    private Object pIp = new Object();
    private long pIr = 0;
    private long pIs = 0;

    /* loaded from: classes8.dex */
    public interface c {
        void XV();

        void dVP();
    }

    public boolean RE(int i) {
        return this.cha == i;
    }

    public d() {
        this.cha = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.nsO = kVar.diQ();
        }
        this.pIv = null;
        this.pIw = new Object();
        this.pIx = false;
        this.pIy = new Object();
        this.pIz = false;
        this.pIA = false;
        this.pIB = false;
        this.pIC = 0L;
        this.cha = 2;
    }

    /* loaded from: classes8.dex */
    public static class b {
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final File nFx;
        final int pIE;
        final long pIr;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.nFx = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.pIE = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.pIr = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.pIE + " to '" + this.nFx.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.pIt = iArr[0];
        GLES20.glBindTexture(3553, this.pIt);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.pIu = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.cha = 5;
        this.pIr = bVar.pIr;
        this.pIs = System.nanoTime();
        synchronized (this.pIp) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.pIp.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.pIo.sendMessage(this.pIo.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.pIu}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.pIt}, 0);
        this.pIu = 0;
        this.pIt = 0;
        if (this.pIc == null || !this.pIc.isStarted()) {
            this.pIB = true;
            if (this.pIm != null) {
                this.pIm.requestStop();
            }
        }
        this.cha = 4;
        this.pIo.sendMessage(this.pIo.obtainMessage(1));
        this.pIo.sendMessage(this.pIo.obtainMessage(5));
    }

    public void d(SurfaceTexture surfaceTexture) {
        synchronized (this.pIp) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.pIo.sendMessage(this.pIo.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.pIt != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.pIu);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.pIt, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.pIp) {
                if (this.mReady) {
                    this.pIo.sendMessage(this.pIo.obtainMessage(3, this.pIt, 0, null));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    private class e extends Thread {
        public e(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (d.this.pIp) {
                d.this.pIo = new HandlerC1068d(d.this);
                d.this.mReady = true;
                d.this.pIp.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.pIp) {
                d.this.mReady = d.this.mRunning = false;
                d.this.pIo = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class HandlerC1068d extends Handler {
        private WeakReference<d> pIF;

        public HandlerC1068d(d dVar) {
            this.pIF = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.pIF.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.adg();
                        return;
                    case 2:
                        if (dVar.pIA) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.pIA) {
                            dVar.RF(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.pIA) {
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
        this.pIv = bVar;
        this.pIl = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.pIE, bVar.nFx);
        this.pIB = false;
        if (this.pIq != null) {
            this.pIq.XV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.pIt != 0) {
            try {
                this.pIm.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.pIv.mWidth, this.pIv.mHeight);
            synchronized (d.class) {
                this.pIk.drawFrame(this.mTextureId, fArr);
            }
            if (this.pIi != null) {
                this.pIi.setPresentationTime(eBM() * 1000);
                this.pIi.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adg() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.pIm.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.pIB = true;
        ado();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.pIz) {
            synchronized (this.pIy) {
                try {
                    this.pIy.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.pIz = false;
        if (this.pIq != null) {
            this.pIq.dVP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RF(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.pIi != null) {
            this.pIi.releaseEglSurface();
        }
        this.pIk.release(false);
        if (this.pIj != null) {
            this.pIj.release();
        }
        this.pIj = new com.faceunity.gles.a(eGLContext, 1);
        if (this.pIi != null) {
            this.pIi.a(this.pIj);
            this.pIi.makeCurrent();
        }
        this.pIk = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.pIc = new com.faceunity.a.c(file.toString());
            this.pIm = new com.faceunity.a.e(i, i2, i3, this.pIc);
            this.pIn = new com.faceunity.a.a(this.pIc);
            this.pIA = true;
            synchronized (this.pIw) {
                this.pIx = true;
                this.pIw.notify();
            }
        } catch (IOException e2) {
            if (this.nsO != null) {
                this.nsO.bD(12, com.baidu.tieba.l.a.p(e2));
            }
        } catch (IllegalStateException e3) {
            this.pIA = false;
            if (this.nsO != null) {
                this.nsO.bD(13, com.baidu.tieba.l.a.p(e3));
                return;
            }
            return;
        }
        this.pIj = new com.faceunity.gles.a(eGLContext, 1);
        this.pIi = new com.faceunity.gles.e(this.pIj, this.pIm.getInputSurface(), true);
        this.pIi.makeCurrent();
        this.pIk = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void ado() {
        try {
            this.pIm.release();
            if (this.pIi != null) {
                this.pIi.release();
                this.pIi = null;
            }
            if (this.pIk != null) {
                this.pIk.release(false);
                this.pIk = null;
            }
            if (this.pIj != null) {
                this.pIj.release();
                this.pIj = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.nsO != null) {
                this.nsO.bD(14, com.baidu.tieba.l.a.p(e2));
            }
        }
    }

    /* loaded from: classes8.dex */
    private class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            synchronized (d.this.pIw) {
                while (!d.this.pIx) {
                    try {
                        d.this.pIw.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.pIx = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.eBL() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.cha = 1;
                    while (!d.this.pIB) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.pIn.f(allocateDirect, e2, d.this.eBM());
                                d.this.pIn.eBK();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.pIn.f(null, 0, d.this.eBM());
                    bVar.release();
                    d.this.pIn.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.pIy) {
                d.this.pIz = true;
                d.this.pIy.notify();
            }
        }
    }

    protected long eBM() {
        long nanoTime = System.nanoTime();
        if (this.pIr != 0) {
            if (this.pIs == 0) {
                this.pIs = nanoTime;
            }
            nanoTime = (nanoTime - this.pIs) + this.pIr;
        }
        long j = nanoTime / 1000;
        if (j < this.pIC) {
            j += this.pIC - j;
        }
        if (j == this.pIC) {
            j += 100;
        }
        this.pIC = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.pIq = cVar;
    }
}
