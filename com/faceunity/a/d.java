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
    private static final int[] nZQ = {1, 0, 5, 7, 6};
    private int bIG;
    private int bZH;
    private h mFB;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private com.faceunity.a.c nZP;
    private com.faceunity.gles.e nZV;
    private com.faceunity.gles.a nZW;
    private com.faceunity.gles.c nZX;
    private com.faceunity.a.e nZY;
    private com.faceunity.a.a nZZ;
    private volatile HandlerC0892d oaa;
    private c oac;
    private int oaf;
    private int oag;
    private b oah;
    private final Object oai;
    private boolean oaj;
    private final Object oak;
    private boolean oal;
    private boolean oam;
    private boolean oan;
    private long oao;
    private Object oab = new Object();
    private long oad = 0;
    private long oae = 0;

    /* loaded from: classes23.dex */
    public interface c {
        void Rm();

        void dLi();
    }

    public boolean NH(int i) {
        return this.bIG == i;
    }

    public d() {
        this.bIG = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mFB = lVar.cYJ();
        }
        this.oah = null;
        this.oai = new Object();
        this.oaj = false;
        this.oak = new Object();
        this.oal = false;
        this.oam = false;
        this.oan = false;
        this.oao = 0L;
        this.bIG = 2;
    }

    /* loaded from: classes23.dex */
    public static class b {
        final EGLContext mEglContext;
        final int mHeight;
        final File mTI;
        final int mWidth;
        final long oad;
        final int oaq;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.mTI = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.oaq = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.oad = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.oaq + " to '" + this.mTI.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.oaf = iArr[0];
        GLES20.glBindTexture(3553, this.oaf);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.oag = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.bIG = 5;
        this.oad = bVar.oad;
        this.oae = System.nanoTime();
        synchronized (this.oab) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.oab.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.oaa.sendMessage(this.oaa.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.oag}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.oaf}, 0);
        this.oag = 0;
        this.oaf = 0;
        if (this.nZP == null || !this.nZP.isStarted()) {
            this.oan = true;
            if (this.nZY != null) {
                this.nZY.requestStop();
            }
        }
        this.bIG = 4;
        this.oaa.sendMessage(this.oaa.obtainMessage(1));
        this.oaa.sendMessage(this.oaa.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.oab) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.oaa.sendMessage(this.oaa.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.oaf != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.oag);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.oaf, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.oab) {
                if (this.mReady) {
                    this.oaa.sendMessage(this.oaa.obtainMessage(3, this.oaf, 0, null));
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
            synchronized (d.this.oab) {
                d.this.oaa = new HandlerC0892d(d.this);
                d.this.mReady = true;
                d.this.oab.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.oab) {
                d.this.mReady = d.this.mRunning = false;
                d.this.oaa = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private static class HandlerC0892d extends Handler {
        private WeakReference<d> oar;

        public HandlerC0892d(d dVar) {
            this.oar = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.oar.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.Vh();
                        return;
                    case 2:
                        if (dVar.oam) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.oam) {
                            dVar.NI(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.oam) {
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
        this.oah = bVar;
        this.bZH = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.oaq, bVar.mTI);
        this.oan = false;
        if (this.oac != null) {
            this.oac.Rm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.oaf != 0) {
            try {
                this.nZY.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.oah.mWidth, this.oah.mHeight);
            synchronized (d.class) {
                this.nZX.drawFrame(this.mTextureId, fArr);
            }
            if (this.nZV != null) {
                this.nZV.setPresentationTime(een() * 1000);
                this.nZV.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.nZY.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.oan = true;
        Vp();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.oal) {
            synchronized (this.oak) {
                try {
                    this.oak.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.oal = false;
        if (this.oac != null) {
            this.oac.dLi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NI(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.nZV != null) {
            this.nZV.releaseEglSurface();
        }
        this.nZX.release(false);
        if (this.nZW != null) {
            this.nZW.release();
        }
        this.nZW = new com.faceunity.gles.a(eGLContext, 1);
        if (this.nZV != null) {
            this.nZV.a(this.nZW);
            this.nZV.makeCurrent();
        }
        this.nZX = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.nZP = new com.faceunity.a.c(file.toString());
            this.nZY = new com.faceunity.a.e(i, i2, i3, this.nZP);
            this.nZZ = new com.faceunity.a.a(this.nZP);
            this.oam = true;
            synchronized (this.oai) {
                this.oaj = true;
                this.oai.notify();
            }
        } catch (IOException e2) {
            if (this.mFB != null) {
                this.mFB.bA(12, com.baidu.tieba.k.a.r(e2));
            }
        } catch (IllegalStateException e3) {
            this.oam = false;
            if (this.mFB != null) {
                this.mFB.bA(13, com.baidu.tieba.k.a.r(e3));
                return;
            }
            return;
        }
        this.nZW = new com.faceunity.gles.a(eGLContext, 1);
        this.nZV = new com.faceunity.gles.e(this.nZW, this.nZY.getInputSurface(), true);
        this.nZV.makeCurrent();
        this.nZX = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void Vp() {
        try {
            this.nZY.release();
            if (this.nZV != null) {
                this.nZV.release();
                this.nZV = null;
            }
            if (this.nZX != null) {
                this.nZX.release(false);
                this.nZX = null;
            }
            if (this.nZW != null) {
                this.nZW.release();
                this.nZW = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.mFB != null) {
                this.mFB.bA(14, com.baidu.tieba.k.a.r(e2));
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
            synchronized (d.this.oai) {
                while (!d.this.oaj) {
                    try {
                        d.this.oai.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.oaj = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.eem() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.bIG = 1;
                    while (!d.this.oan) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.nZZ.f(allocateDirect, e2, d.this.een());
                                d.this.nZZ.eel();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.nZZ.f(null, 0, d.this.een());
                    bVar.release();
                    d.this.nZZ.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.oak) {
                d.this.oal = true;
                d.this.oak.notify();
            }
        }
    }

    protected long een() {
        long nanoTime = System.nanoTime();
        if (this.oad != 0) {
            if (this.oae == 0) {
                this.oae = nanoTime;
            }
            nanoTime = (nanoTime - this.oae) + this.oad;
        }
        long j = nanoTime / 1000;
        if (j < this.oao) {
            j += this.oao - j;
        }
        if (j == this.oao) {
            j += 100;
        }
        this.oao = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.oac = cVar;
    }
}
