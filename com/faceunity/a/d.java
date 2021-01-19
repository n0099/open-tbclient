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
    private static final int[] pDD = {1, 0, 5, 7, 6};
    private int ccl;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private g noi;
    private com.faceunity.a.c pDC;
    private com.faceunity.gles.e pDI;
    private com.faceunity.gles.a pDJ;
    private com.faceunity.gles.c pDK;
    private int pDL;
    private com.faceunity.a.e pDM;
    private com.faceunity.a.a pDN;
    private volatile HandlerC1051d pDO;
    private c pDQ;
    private int pDT;
    private int pDU;
    private b pDV;
    private final Object pDW;
    private boolean pDX;
    private final Object pDY;
    private boolean pDZ;
    private boolean pEa;
    private boolean pEb;
    private long pEc;
    private Object pDP = new Object();
    private long pDR = 0;
    private long pDS = 0;

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
            this.noi = kVar.deY();
        }
        this.pDV = null;
        this.pDW = new Object();
        this.pDX = false;
        this.pDY = new Object();
        this.pDZ = false;
        this.pEa = false;
        this.pEb = false;
        this.pEc = 0L;
        this.ccl = 2;
    }

    /* loaded from: classes7.dex */
    public static class b {
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;
        final File nAT;
        final long pDR;
        final int pEe;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.nAT = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.pEe = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.pDR = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.pEe + " to '" + this.nAT.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.pDT = iArr[0];
        GLES20.glBindTexture(3553, this.pDT);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.pDU = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.ccl = 5;
        this.pDR = bVar.pDR;
        this.pDS = System.nanoTime();
        synchronized (this.pDP) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.pDP.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.pDO.sendMessage(this.pDO.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.pDU}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.pDT}, 0);
        this.pDU = 0;
        this.pDT = 0;
        if (this.pDC == null || !this.pDC.isStarted()) {
            this.pEb = true;
            if (this.pDM != null) {
                this.pDM.requestStop();
            }
        }
        this.ccl = 4;
        this.pDO.sendMessage(this.pDO.obtainMessage(1));
        this.pDO.sendMessage(this.pDO.obtainMessage(5));
    }

    public void d(SurfaceTexture surfaceTexture) {
        synchronized (this.pDP) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.pDO.sendMessage(this.pDO.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.pDT != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.pDU);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.pDT, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.pDP) {
                if (this.mReady) {
                    this.pDO.sendMessage(this.pDO.obtainMessage(3, this.pDT, 0, null));
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
            synchronized (d.this.pDP) {
                d.this.pDO = new HandlerC1051d(d.this);
                d.this.mReady = true;
                d.this.pDP.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.pDP) {
                d.this.mReady = d.this.mRunning = false;
                d.this.pDO = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static class HandlerC1051d extends Handler {
        private WeakReference<d> pEf;

        public HandlerC1051d(d dVar) {
            this.pEf = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.pEf.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.Zn();
                        return;
                    case 2:
                        if (dVar.pEa) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.pEa) {
                            dVar.PY(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.pEa) {
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
        this.pDV = bVar;
        this.pDL = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.pEe, bVar.nAT);
        this.pEb = false;
        if (this.pDQ != null) {
            this.pDQ.Uc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.pDT != 0) {
            try {
                this.pDM.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.pDV.mWidth, this.pDV.mHeight);
            synchronized (d.class) {
                this.pDK.drawFrame(this.mTextureId, fArr);
            }
            if (this.pDI != null) {
                this.pDI.setPresentationTime(exU() * 1000);
                this.pDI.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zn() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.pDM.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.pEb = true;
        Zv();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.pDZ) {
            synchronized (this.pDY) {
                try {
                    this.pDY.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.pDZ = false;
        if (this.pDQ != null) {
            this.pDQ.dRX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PY(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.pDI != null) {
            this.pDI.releaseEglSurface();
        }
        this.pDK.release(false);
        if (this.pDJ != null) {
            this.pDJ.release();
        }
        this.pDJ = new com.faceunity.gles.a(eGLContext, 1);
        if (this.pDI != null) {
            this.pDI.a(this.pDJ);
            this.pDI.makeCurrent();
        }
        this.pDK = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.pDC = new com.faceunity.a.c(file.toString());
            this.pDM = new com.faceunity.a.e(i, i2, i3, this.pDC);
            this.pDN = new com.faceunity.a.a(this.pDC);
            this.pEa = true;
            synchronized (this.pDW) {
                this.pDX = true;
                this.pDW.notify();
            }
        } catch (IOException e2) {
            if (this.noi != null) {
                this.noi.bE(12, com.baidu.tieba.l.a.p(e2));
            }
        } catch (IllegalStateException e3) {
            this.pEa = false;
            if (this.noi != null) {
                this.noi.bE(13, com.baidu.tieba.l.a.p(e3));
                return;
            }
            return;
        }
        this.pDJ = new com.faceunity.gles.a(eGLContext, 1);
        this.pDI = new com.faceunity.gles.e(this.pDJ, this.pDM.getInputSurface(), true);
        this.pDI.makeCurrent();
        this.pDK = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void Zv() {
        try {
            this.pDM.release();
            if (this.pDI != null) {
                this.pDI.release();
                this.pDI = null;
            }
            if (this.pDK != null) {
                this.pDK.release(false);
                this.pDK = null;
            }
            if (this.pDJ != null) {
                this.pDJ.release();
                this.pDJ = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.noi != null) {
                this.noi.bE(14, com.baidu.tieba.l.a.p(e2));
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
            synchronized (d.this.pDW) {
                while (!d.this.pDX) {
                    try {
                        d.this.pDW.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.pDX = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.exT() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.ccl = 1;
                    while (!d.this.pEb) {
                        try {
                            allocateDirect.clear();
                            int e2 = bVar.e(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (e2 > 0) {
                                allocateDirect.position(e2);
                                allocateDirect.flip();
                                d.this.pDN.f(allocateDirect, e2, d.this.exU());
                                d.this.pDN.exS();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.pDN.f(null, 0, d.this.exU());
                    bVar.release();
                    d.this.pDN.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.pDY) {
                d.this.pDZ = true;
                d.this.pDY.notify();
            }
        }
    }

    protected long exU() {
        long nanoTime = System.nanoTime();
        if (this.pDR != 0) {
            if (this.pDS == 0) {
                this.pDS = nanoTime;
            }
            nanoTime = (nanoTime - this.pDS) + this.pDR;
        }
        long j = nanoTime / 1000;
        if (j < this.pEc) {
            j += this.pEc - j;
        }
        if (j == this.pEc) {
            j += 100;
        }
        this.pEc = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.pDQ = cVar;
    }
}
