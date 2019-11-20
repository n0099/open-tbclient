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
    private static final int[] kmB = {1, 0, 5, 7, 6};
    private int axi;
    private h jiP;
    private com.faceunity.gles.e kmH;
    private com.faceunity.gles.a kmI;
    private com.faceunity.gles.c kmJ;
    private int kmK;
    private com.faceunity.a.e kmL;
    private com.faceunity.a.a kmM;
    private volatile HandlerC0568d kmN;
    private c kmP;
    private int kmS;
    private int kmT;
    private b kmU;
    private final Object kmV;
    private boolean kmW;
    private final Object kmX;
    private boolean kmY;
    private boolean kmZ;
    private com.faceunity.a.c kmz;
    private boolean kna;
    private long knb;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object kmO = new Object();
    private long kmQ = 0;
    private long kmR = 0;

    /* loaded from: classes5.dex */
    public interface c {
        void cvj();

        void cvk();
    }

    public boolean CV(int i) {
        return this.axi == i;
    }

    public d() {
        this.axi = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.jiP = lVar.bMW();
        }
        this.kmU = null;
        this.kmV = new Object();
        this.kmW = false;
        this.kmX = new Object();
        this.kmY = false;
        this.kmZ = false;
        this.kna = false;
        this.knb = 0L;
        this.axi = 2;
    }

    /* loaded from: classes5.dex */
    public static class b {
        final int iwQ;
        final File jwz;
        final long kmQ;
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.jwz = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.iwQ = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.kmQ = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.iwQ + " to '" + this.jwz.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.kmS = iArr[0];
        GLES20.glBindTexture(3553, this.kmS);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.kmT = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.axi = 5;
        this.kmQ = bVar.kmQ;
        this.kmR = System.nanoTime();
        synchronized (this.kmO) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.kmO.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.kmN.sendMessage(this.kmN.obtainMessage(0, bVar));
        }
    }

    public void yz() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.kmT}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.kmS}, 0);
        this.kmT = 0;
        this.kmS = 0;
        if (this.kmz == null || !this.kmz.isStarted()) {
            this.kna = true;
            if (this.kmL != null) {
                this.kmL.requestStop();
            }
        }
        this.axi = 4;
        this.kmN.sendMessage(this.kmN.obtainMessage(1));
        this.kmN.sendMessage(this.kmN.obtainMessage(5));
    }

    public void d(SurfaceTexture surfaceTexture) {
        synchronized (this.kmO) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.kmN.sendMessage(this.kmN.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.kmS != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.kmT);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.kmS, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.kmO) {
                if (this.mReady) {
                    this.kmN.sendMessage(this.kmN.obtainMessage(3, this.kmS, 0, null));
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
            synchronized (d.this.kmO) {
                d.this.kmN = new HandlerC0568d(d.this);
                d.this.mReady = true;
                d.this.kmO.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.kmO) {
                d.this.mReady = d.this.mRunning = false;
                d.this.kmN = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class HandlerC0568d extends Handler {
        private WeakReference<d> knd;

        public HandlerC0568d(d dVar) {
            this.knd = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.knd.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.yC();
                        return;
                    case 2:
                        if (dVar.kmZ) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.kmZ) {
                            dVar.CW(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.kmZ) {
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
        this.kmU = bVar;
        this.kmK = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.iwQ, bVar.jwz);
        this.kna = false;
        if (this.kmP != null) {
            this.kmP.cvj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.kmS != 0) {
            try {
                this.kmL.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.kmU.mWidth, this.kmU.mHeight);
            synchronized (d.class) {
                this.kmJ.drawFrame(this.mTextureId, fArr);
            }
            if (this.kmH != null) {
                this.kmH.setPresentationTime(cJO() * 1000);
                this.kmH.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yC() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.kmL.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.kna = true;
        yJ();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.kmY) {
            synchronized (this.kmX) {
                try {
                    this.kmX.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.kmY = false;
        if (this.kmP != null) {
            this.kmP.cvk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CW(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.kmH != null) {
            this.kmH.releaseEglSurface();
        }
        this.kmJ.release(false);
        if (this.kmI != null) {
            this.kmI.release();
        }
        this.kmI = new com.faceunity.gles.a(eGLContext, 1);
        if (this.kmH != null) {
            this.kmH.a(this.kmI);
            this.kmH.makeCurrent();
        }
        this.kmJ = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.kmz = new com.faceunity.a.c(file.toString());
            this.kmL = new com.faceunity.a.e(i, i2, i3, this.kmz);
            this.kmM = new com.faceunity.a.a(this.kmz);
            this.kmZ = true;
            synchronized (this.kmV) {
                this.kmW = true;
                this.kmV.notify();
            }
        } catch (IOException e2) {
            if (this.jiP != null) {
                this.jiP.au(12, com.baidu.tieba.j.a.o(e2));
            }
        } catch (IllegalStateException e3) {
            this.kmZ = false;
            if (this.jiP != null) {
                this.jiP.au(13, com.baidu.tieba.j.a.o(e3));
                return;
            }
            return;
        }
        this.kmI = new com.faceunity.gles.a(eGLContext, 1);
        this.kmH = new com.faceunity.gles.e(this.kmI, this.kmL.getInputSurface(), true);
        this.kmH.makeCurrent();
        this.kmJ = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void yJ() {
        try {
            this.kmL.release();
            if (this.kmH != null) {
                this.kmH.release();
                this.kmH = null;
            }
            if (this.kmJ != null) {
                this.kmJ.release(false);
                this.kmJ = null;
            }
            if (this.kmI != null) {
                this.kmI.release();
                this.kmI = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.jiP != null) {
                this.jiP.au(14, com.baidu.tieba.j.a.o(e2));
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
            synchronized (d.this.kmV) {
                while (!d.this.kmW) {
                    try {
                        d.this.kmV.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.kmW = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.cJN() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.yy();
                    d.this.axi = 1;
                    while (!d.this.kna) {
                        try {
                            allocateDirect.clear();
                            int b = bVar.b(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (b > 0) {
                                allocateDirect.position(b);
                                allocateDirect.flip();
                                d.this.kmM.f(allocateDirect, b, d.this.cJO());
                                d.this.kmM.cJL();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.kmM.f(null, 0, d.this.cJO());
                    bVar.release();
                    d.this.kmM.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.kmX) {
                d.this.kmY = true;
                d.this.kmX.notify();
            }
        }
    }

    protected long cJO() {
        long nanoTime = System.nanoTime();
        if (this.kmQ != 0) {
            if (this.kmR == 0) {
                this.kmR = nanoTime;
            }
            nanoTime = (nanoTime - this.kmR) + this.kmQ;
        }
        long j = nanoTime / 1000;
        if (j < this.knb) {
            j += this.knb - j;
        }
        if (j == this.knb) {
            j += 100;
        }
        this.knb = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.kmP = cVar;
    }
}
