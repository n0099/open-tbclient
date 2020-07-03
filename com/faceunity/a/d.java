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
    private static final int[] mYp = {1, 0, 5, 7, 6};
    private int bIh;
    private int bsw;
    private h lHf;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private c mYB;
    private int mYE;
    private int mYF;
    private b mYG;
    private final Object mYH;
    private boolean mYI;
    private final Object mYJ;
    private boolean mYK;
    private boolean mYL;
    private boolean mYM;
    private long mYN;
    private com.faceunity.a.c mYo;
    private com.faceunity.gles.e mYu;
    private com.faceunity.gles.a mYv;
    private com.faceunity.gles.c mYw;
    private com.faceunity.a.e mYx;
    private com.faceunity.a.a mYy;
    private volatile HandlerC0809d mYz;
    private Object mYA = new Object();
    private long mYC = 0;
    private long mYD = 0;

    /* loaded from: classes10.dex */
    public interface c {
        void Ju();

        void doK();
    }

    public boolean Jx(int i) {
        return this.bsw == i;
    }

    public d() {
        this.bsw = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.lHf = lVar.cCP();
        }
        this.mYG = null;
        this.mYH = new Object();
        this.mYI = false;
        this.mYJ = new Object();
        this.mYK = false;
        this.mYL = false;
        this.mYM = false;
        this.mYN = 0L;
        this.bsw = 2;
    }

    /* loaded from: classes10.dex */
    public static class b {
        final int kTS;
        final File lUM;
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final long mYC;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.lUM = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.kTS = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.mYC = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.kTS + " to '" + this.lUM.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.mYE = iArr[0];
        GLES20.glBindTexture(3553, this.mYE);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.mYF = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.bsw = 5;
        this.mYC = bVar.mYC;
        this.mYD = System.nanoTime();
        synchronized (this.mYA) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.mYA.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.mYz.sendMessage(this.mYz.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.mYF}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.mYE}, 0);
        this.mYF = 0;
        this.mYE = 0;
        if (this.mYo == null || !this.mYo.isStarted()) {
            this.mYM = true;
            if (this.mYx != null) {
                this.mYx.requestStop();
            }
        }
        this.bsw = 4;
        this.mYz.sendMessage(this.mYz.obtainMessage(1));
        this.mYz.sendMessage(this.mYz.obtainMessage(5));
    }

    public void f(SurfaceTexture surfaceTexture) {
        synchronized (this.mYA) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.mYz.sendMessage(this.mYz.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.mYE != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.mYF);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mYE, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mYA) {
                if (this.mReady) {
                    this.mYz.sendMessage(this.mYz.obtainMessage(3, this.mYE, 0, null));
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
            synchronized (d.this.mYA) {
                d.this.mYz = new HandlerC0809d(d.this);
                d.this.mReady = true;
                d.this.mYA.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mYA) {
                d.this.mReady = d.this.mRunning = false;
                d.this.mYz = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class HandlerC0809d extends Handler {
        private WeakReference<d> mYP;

        public HandlerC0809d(d dVar) {
            this.mYP = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.mYP.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.Mr();
                        return;
                    case 2:
                        if (dVar.mYL) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.mYL) {
                            dVar.Jy(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.mYL) {
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
        this.mYG = bVar;
        this.bIh = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.kTS, bVar.lUM);
        this.mYM = false;
        if (this.mYB != null) {
            this.mYB.Ju();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.mYE != 0) {
            try {
                this.mYx.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.mYG.mWidth, this.mYG.mHeight);
            synchronized (d.class) {
                this.mYw.drawFrame(this.mTextureId, fArr);
            }
            if (this.mYu != null) {
                this.mYu.setPresentationTime(dHf() * 1000);
                this.mYu.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mr() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.mYx.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mYM = true;
        Mz();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.mYK) {
            synchronized (this.mYJ) {
                try {
                    this.mYJ.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.mYK = false;
        if (this.mYB != null) {
            this.mYB.doK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jy(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.mYu != null) {
            this.mYu.releaseEglSurface();
        }
        this.mYw.release(false);
        if (this.mYv != null) {
            this.mYv.release();
        }
        this.mYv = new com.faceunity.gles.a(eGLContext, 1);
        if (this.mYu != null) {
            this.mYu.a(this.mYv);
            this.mYu.makeCurrent();
        }
        this.mYw = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.mYo = new com.faceunity.a.c(file.toString());
            this.mYx = new com.faceunity.a.e(i, i2, i3, this.mYo);
            this.mYy = new com.faceunity.a.a(this.mYo);
            this.mYL = true;
            synchronized (this.mYH) {
                this.mYI = true;
                this.mYH.notify();
            }
        } catch (IOException e2) {
            if (this.lHf != null) {
                this.lHf.bn(12, com.baidu.tieba.k.a.t(e2));
            }
        } catch (IllegalStateException e3) {
            this.mYL = false;
            if (this.lHf != null) {
                this.lHf.bn(13, com.baidu.tieba.k.a.t(e3));
                return;
            }
            return;
        }
        this.mYv = new com.faceunity.gles.a(eGLContext, 1);
        this.mYu = new com.faceunity.gles.e(this.mYv, this.mYx.getInputSurface(), true);
        this.mYu.makeCurrent();
        this.mYw = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void Mz() {
        try {
            this.mYx.release();
            if (this.mYu != null) {
                this.mYu.release();
                this.mYu = null;
            }
            if (this.mYw != null) {
                this.mYw.release(false);
                this.mYw = null;
            }
            if (this.mYv != null) {
                this.mYv.release();
                this.mYv = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.lHf != null) {
                this.lHf.bn(14, com.baidu.tieba.k.a.t(e2));
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
            synchronized (d.this.mYH) {
                while (!d.this.mYI) {
                    try {
                        d.this.mYH.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.mYI = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.dHe() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.bsw = 1;
                    while (!d.this.mYM) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.mYy.f(allocateDirect, e2, d.this.dHf());
                                d.this.mYy.dHd();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.mYy.f(null, 0, d.this.dHf());
                    bVar.release();
                    d.this.mYy.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.mYJ) {
                d.this.mYK = true;
                d.this.mYJ.notify();
            }
        }
    }

    protected long dHf() {
        long nanoTime = System.nanoTime();
        if (this.mYC != 0) {
            if (this.mYD == 0) {
                this.mYD = nanoTime;
            }
            nanoTime = (nanoTime - this.mYD) + this.mYC;
        }
        long j = nanoTime / 1000;
        if (j < this.mYN) {
            j += this.mYN - j;
        }
        if (j == this.mYN) {
            j += 100;
        }
        this.mYN = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.mYB = cVar;
    }
}
