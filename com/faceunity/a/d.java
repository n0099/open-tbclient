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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i.h;
import com.baidu.tieba.i.k;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes2.dex */
public class d {
    private static final int[] hVG = {1, 0, 5, 7, 6};
    private h gZD;
    private com.faceunity.a.c hVC;
    private com.faceunity.gles.e hVM;
    private com.faceunity.gles.a hVN;
    private com.faceunity.gles.c hVO;
    private int hVP;
    private com.faceunity.a.e hVQ;
    private com.faceunity.a.a hVR;
    private volatile HandlerC0179d hVS;
    private int hVT;
    private c hVU;
    private int hVX;
    private int hVY;
    private b hVZ;
    private final Object hWa;
    private boolean hWb;
    private final Object hWc;
    private boolean hWd;
    private boolean hWe;
    private boolean hWf;
    private long hWg;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long hVV = 0;
    private long hVW = 0;

    /* loaded from: classes2.dex */
    public interface c {
        void bCT();

        void bCU();
    }

    public boolean yG(int i) {
        return this.hVT == i;
    }

    public d() {
        this.hVT = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gZD = kVar.aVx();
        }
        this.hVZ = null;
        this.hWa = new Object();
        this.hWb = false;
        this.hWc = new Object();
        this.hWd = false;
        this.hWe = false;
        this.hWf = false;
        this.hWg = 0L;
        this.hVT = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final int gsM;
        final long hVV;
        final EGLContext hWi;
        final File hmX;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.hmX = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.gsM = i3;
            if (eGLContext != null) {
                this.hWi = eGLContext;
            } else {
                this.hWi = EGL14.eglGetCurrentContext();
            }
            this.hVV = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.gsM + " to '" + this.hmX.toString() + "' ctxt=" + this.hWi;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.hVX = iArr[0];
        GLES20.glBindTexture(3553, this.hVX);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.hVY = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.hVT = 5;
        this.hVV = bVar.hVV;
        this.hVW = System.nanoTime();
        synchronized (this.mReadyFence) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.mReadyFence.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.hVS.sendMessage(this.hVS.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.hVY}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.hVX}, 0);
        this.hVY = 0;
        this.hVX = 0;
        if (this.hVC == null || !this.hVC.isStarted()) {
            this.hWf = true;
            if (this.hVQ != null) {
                this.hVQ.requestStop();
            }
        }
        this.hVT = 4;
        this.hVS.sendMessage(this.hVS.obtainMessage(1));
        this.hVS.sendMessage(this.hVS.obtainMessage(5));
    }

    public void c(SurfaceTexture surfaceTexture) {
        synchronized (this.mReadyFence) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.hVS.sendMessage(this.hVS.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.hVX != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.hVY);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.hVX, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.hVS.sendMessage(this.hVS.obtainMessage(3, this.hVX, 0, null));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private class e extends Thread {
        public e(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (d.this.mReadyFence) {
                d.this.hVS = new HandlerC0179d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.hVS = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class HandlerC0179d extends Handler {
        private WeakReference<d> mWeakEncoder;

        public HandlerC0179d(d dVar) {
            this.mWeakEncoder = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.mWeakEncoder.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.handleStopRecording();
                        return;
                    case 2:
                        if (dVar.hWe) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.hWe) {
                            dVar.yH(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.hWe) {
                            dVar.handleUpdateSharedContext((EGLContext) message.obj);
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
        this.hVZ = bVar;
        this.hVP = 0;
        a(bVar.hWi, bVar.mWidth, bVar.mHeight, bVar.gsM, bVar.hmX);
        this.hWf = false;
        if (this.hVU != null) {
            this.hVU.bCT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.hVX != 0) {
            try {
                this.hVQ.od(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.hVZ.mWidth, this.hVZ.mHeight);
            synchronized (d.class) {
                this.hVO.drawFrame(this.mTextureId, fArr);
            }
            if (this.hVM != null) {
                this.hVM.setPresentationTime(bLX() * 1000);
                this.hVM.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.hVQ.od(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.hWf = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.hWd) {
            synchronized (this.hWc) {
                try {
                    this.hWc.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.hWd = false;
        if (this.hVU != null) {
            this.hVU.bCU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yH(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.hVM != null) {
            this.hVM.releaseEglSurface();
        }
        this.hVO.release(false);
        if (this.hVN != null) {
            this.hVN.release();
        }
        this.hVN = new com.faceunity.gles.a(eGLContext, 1);
        if (this.hVM != null) {
            this.hVM.a(this.hVN);
            this.hVM.makeCurrent();
        }
        this.hVO = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.hVC = new com.faceunity.a.c(file.toString());
            this.hVQ = new com.faceunity.a.e(i, i2, i3, this.hVC);
            this.hVR = new com.faceunity.a.a(this.hVC);
            this.hWe = true;
            synchronized (this.hWa) {
                this.hWb = true;
                this.hWa.notify();
            }
        } catch (IOException e2) {
            if (this.gZD != null) {
                this.gZD.T(12, com.baidu.tieba.i.a.i(e2));
            }
        } catch (IllegalStateException e3) {
            this.hWe = false;
            if (this.gZD != null) {
                this.gZD.T(13, com.baidu.tieba.i.a.i(e3));
                return;
            }
            return;
        }
        this.hVN = new com.faceunity.gles.a(eGLContext, 1);
        this.hVM = new com.faceunity.gles.e(this.hVN, this.hVQ.getInputSurface(), true);
        this.hVM.makeCurrent();
        this.hVO = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.hVQ.release();
            if (this.hVM != null) {
                this.hVM.release();
                this.hVM = null;
            }
            if (this.hVO != null) {
                this.hVO.release(false);
                this.hVO = null;
            }
            if (this.hVN != null) {
                this.hVN.release();
                this.hVN = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.gZD != null) {
                this.gZD.T(14, com.baidu.tieba.i.a.i(e2));
            }
        }
    }

    /* loaded from: classes2.dex */
    private class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            synchronized (d.this.hWa) {
                while (!d.this.hWb) {
                    try {
                        d.this.hWa.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.hWb = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.bLW() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.hVT = 1;
                    while (!d.this.hWf) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.hVR.a(allocateDirect, read, d.this.bLX());
                                d.this.hVR.bLU();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.hVR.a(null, 0, d.this.bLX());
                    bVar.release();
                    d.this.hVR.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.hWc) {
                d.this.hWd = true;
                d.this.hWc.notify();
            }
        }
    }

    protected long bLX() {
        long nanoTime = System.nanoTime();
        if (this.hVV != 0) {
            if (this.hVW == 0) {
                this.hVW = nanoTime;
            }
            nanoTime = (nanoTime - this.hVW) + this.hVV;
        }
        long j = nanoTime / 1000;
        if (j < this.hWg) {
            j += this.hWg - j;
        }
        if (j == this.hWg) {
            j += 100;
        }
        this.hWg = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.hVU = cVar;
    }
}
