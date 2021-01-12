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
import com.baidu.tieba.l.g;
import com.baidu.tieba.l.k;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes7.dex */
public class d {
    private static final int[] pDC = {1, 0, 5, 7, 6};
    private int ccl;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private g noh;
    private com.faceunity.a.c pDB;
    private com.faceunity.gles.e pDH;
    private com.faceunity.gles.a pDI;
    private com.faceunity.gles.c pDJ;
    private int pDK;
    private com.faceunity.a.e pDL;
    private com.faceunity.a.a pDM;
    private volatile HandlerC1051d pDN;
    private c pDP;
    private int pDS;
    private int pDT;
    private b pDU;
    private final Object pDV;
    private boolean pDW;
    private final Object pDX;
    private boolean pDY;
    private boolean pDZ;
    private boolean pEa;
    private long pEb;
    private Object pDO = new Object();
    private long pDQ = 0;
    private long pDR = 0;

    /* loaded from: classes7.dex */
    public interface c {
        void Uc();

        void dRX();
    }

    public boolean PX(int i) {
        return this.ccl == i;
    }

    public d() {
        this.ccl = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.noh = kVar.deY();
        }
        this.pDU = null;
        this.pDV = new Object();
        this.pDW = false;
        this.pDX = new Object();
        this.pDY = false;
        this.pDZ = false;
        this.pEa = false;
        this.pEb = 0L;
        this.ccl = 2;
    }

    /* loaded from: classes7.dex */
    public static class b {
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final File nAS;
        final long pDQ;
        final int pEd;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.nAS = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.pEd = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.pDQ = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.pEd + " to '" + this.nAS.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.pDS = iArr[0];
        GLES20.glBindTexture(3553, this.pDS);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.pDT = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.ccl = 5;
        this.pDQ = bVar.pDQ;
        this.pDR = System.nanoTime();
        synchronized (this.pDO) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.pDO.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.pDN.sendMessage(this.pDN.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.pDT}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.pDS}, 0);
        this.pDT = 0;
        this.pDS = 0;
        if (this.pDB == null || !this.pDB.isStarted()) {
            this.pEa = true;
            if (this.pDL != null) {
                this.pDL.requestStop();
            }
        }
        this.ccl = 4;
        this.pDN.sendMessage(this.pDN.obtainMessage(1));
        this.pDN.sendMessage(this.pDN.obtainMessage(5));
    }

    public void d(SurfaceTexture surfaceTexture) {
        synchronized (this.pDO) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.pDN.sendMessage(this.pDN.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.pDS != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.pDT);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.pDS, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.pDO) {
                if (this.mReady) {
                    this.pDN.sendMessage(this.pDN.obtainMessage(3, this.pDS, 0, null));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    private class e extends Thread {
        public e(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (d.this.pDO) {
                d.this.pDN = new HandlerC1051d(d.this);
                d.this.mReady = true;
                d.this.pDO.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.pDO) {
                d.this.mReady = d.this.mRunning = false;
                d.this.pDN = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static class HandlerC1051d extends Handler {
        private WeakReference<d> pEe;

        public HandlerC1051d(d dVar) {
            this.pEe = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.pEe.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.Zn();
                        return;
                    case 2:
                        if (dVar.pDZ) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.pDZ) {
                            dVar.PY(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.pDZ) {
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
        this.pDU = bVar;
        this.pDK = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.pEd, bVar.nAS);
        this.pEa = false;
        if (this.pDP != null) {
            this.pDP.Uc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.pDS != 0) {
            try {
                this.pDL.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.pDU.mWidth, this.pDU.mHeight);
            synchronized (d.class) {
                this.pDJ.drawFrame(this.mTextureId, fArr);
            }
            if (this.pDH != null) {
                this.pDH.setPresentationTime(exU() * 1000);
                this.pDH.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zn() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.pDL.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.pEa = true;
        Zv();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.pDY) {
            synchronized (this.pDX) {
                try {
                    this.pDX.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.pDY = false;
        if (this.pDP != null) {
            this.pDP.dRX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PY(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.pDH != null) {
            this.pDH.releaseEglSurface();
        }
        this.pDJ.release(false);
        if (this.pDI != null) {
            this.pDI.release();
        }
        this.pDI = new com.faceunity.gles.a(eGLContext, 1);
        if (this.pDH != null) {
            this.pDH.a(this.pDI);
            this.pDH.makeCurrent();
        }
        this.pDJ = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.pDB = new com.faceunity.a.c(file.toString());
            this.pDL = new com.faceunity.a.e(i, i2, i3, this.pDB);
            this.pDM = new com.faceunity.a.a(this.pDB);
            this.pDZ = true;
            synchronized (this.pDV) {
                this.pDW = true;
                this.pDV.notify();
            }
        } catch (IOException e2) {
            if (this.noh != null) {
                this.noh.bE(12, com.baidu.tieba.l.a.p(e2));
            }
        } catch (IllegalStateException e3) {
            this.pDZ = false;
            if (this.noh != null) {
                this.noh.bE(13, com.baidu.tieba.l.a.p(e3));
                return;
            }
            return;
        }
        this.pDI = new com.faceunity.gles.a(eGLContext, 1);
        this.pDH = new com.faceunity.gles.e(this.pDI, this.pDL.getInputSurface(), true);
        this.pDH.makeCurrent();
        this.pDJ = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void Zv() {
        try {
            this.pDL.release();
            if (this.pDH != null) {
                this.pDH.release();
                this.pDH = null;
            }
            if (this.pDJ != null) {
                this.pDJ.release(false);
                this.pDJ = null;
            }
            if (this.pDI != null) {
                this.pDI.release();
                this.pDI = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.noh != null) {
                this.noh.bE(14, com.baidu.tieba.l.a.p(e2));
            }
        }
    }

    /* loaded from: classes7.dex */
    private class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            synchronized (d.this.pDV) {
                while (!d.this.pDW) {
                    try {
                        d.this.pDV.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.pDW = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.exT() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.ccl = 1;
                    while (!d.this.pEa) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.pDM.f(allocateDirect, e2, d.this.exU());
                                d.this.pDM.exS();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.pDM.f(null, 0, d.this.exU());
                    bVar.release();
                    d.this.pDM.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.pDX) {
                d.this.pDY = true;
                d.this.pDX.notify();
            }
        }
    }

    protected long exU() {
        long nanoTime = System.nanoTime();
        if (this.pDQ != 0) {
            if (this.pDR == 0) {
                this.pDR = nanoTime;
            }
            nanoTime = (nanoTime - this.pDR) + this.pDQ;
        }
        long j = nanoTime / 1000;
        if (j < this.pEb) {
            j += this.pEb - j;
        }
        if (j == this.pEb) {
            j += 100;
        }
        this.pEb = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.pDP = cVar;
    }
}
