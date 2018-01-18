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
    private static final int[] hVm = {1, 0, 5, 7, 6};
    private h gZj;
    private c hVA;
    private int hVD;
    private int hVE;
    private b hVF;
    private final Object hVG;
    private boolean hVH;
    private final Object hVI;
    private boolean hVJ;
    private boolean hVK;
    private boolean hVL;
    private long hVM;
    private com.faceunity.a.c hVi;
    private com.faceunity.gles.e hVs;
    private com.faceunity.gles.a hVt;
    private com.faceunity.gles.c hVu;
    private int hVv;
    private com.faceunity.a.e hVw;
    private com.faceunity.a.a hVx;
    private volatile HandlerC0178d hVy;
    private int hVz;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long hVB = 0;
    private long hVC = 0;

    /* loaded from: classes2.dex */
    public interface c {
        void bCR();

        void bCS();
    }

    public boolean yG(int i) {
        return this.hVz == i;
    }

    public d() {
        this.hVz = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gZj = kVar.aVs();
        }
        this.hVF = null;
        this.hVG = new Object();
        this.hVH = false;
        this.hVI = new Object();
        this.hVJ = false;
        this.hVK = false;
        this.hVL = false;
        this.hVM = 0L;
        this.hVz = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final int gsr;
        final long hVB;
        final EGLContext hVO;
        final File hmD;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.hmD = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.gsr = i3;
            if (eGLContext != null) {
                this.hVO = eGLContext;
            } else {
                this.hVO = EGL14.eglGetCurrentContext();
            }
            this.hVB = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.gsr + " to '" + this.hmD.toString() + "' ctxt=" + this.hVO;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.hVD = iArr[0];
        GLES20.glBindTexture(3553, this.hVD);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.hVE = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.hVz = 5;
        this.hVB = bVar.hVB;
        this.hVC = System.nanoTime();
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
            this.hVy.sendMessage(this.hVy.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.hVE}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.hVD}, 0);
        this.hVE = 0;
        this.hVD = 0;
        if (this.hVi == null || !this.hVi.isStarted()) {
            this.hVL = true;
            if (this.hVw != null) {
                this.hVw.requestStop();
            }
        }
        this.hVz = 4;
        this.hVy.sendMessage(this.hVy.obtainMessage(1));
        this.hVy.sendMessage(this.hVy.obtainMessage(5));
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
                    this.hVy.sendMessage(this.hVy.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.hVD != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.hVE);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.hVD, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.hVy.sendMessage(this.hVy.obtainMessage(3, this.hVD, 0, null));
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
                d.this.hVy = new HandlerC0178d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.hVy = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class HandlerC0178d extends Handler {
        private WeakReference<d> mWeakEncoder;

        public HandlerC0178d(d dVar) {
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
                        if (dVar.hVK) {
                            dVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.hVK) {
                            dVar.yH(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.hVK) {
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
        this.hVF = bVar;
        this.hVv = 0;
        a(bVar.hVO, bVar.mWidth, bVar.mHeight, bVar.gsr, bVar.hmD);
        this.hVL = false;
        if (this.hVA != null) {
            this.hVA.bCR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.hVD != 0) {
            try {
                this.hVw.oa(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.hVF.mWidth, this.hVF.mHeight);
            synchronized (d.class) {
                this.hVu.drawFrame(this.mTextureId, fArr);
            }
            if (this.hVs != null) {
                this.hVs.setPresentationTime(bLV() * 1000);
                this.hVs.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.hVw.oa(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.hVL = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.hVJ) {
            synchronized (this.hVI) {
                try {
                    this.hVI.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.hVJ = false;
        if (this.hVA != null) {
            this.hVA.bCS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yH(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.hVs != null) {
            this.hVs.releaseEglSurface();
        }
        this.hVu.release(false);
        if (this.hVt != null) {
            this.hVt.release();
        }
        this.hVt = new com.faceunity.gles.a(eGLContext, 1);
        if (this.hVs != null) {
            this.hVs.a(this.hVt);
            this.hVs.makeCurrent();
        }
        this.hVu = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.hVi = new com.faceunity.a.c(file.toString());
            this.hVw = new com.faceunity.a.e(i, i2, i3, this.hVi);
            this.hVx = new com.faceunity.a.a(this.hVi);
            this.hVK = true;
            synchronized (this.hVG) {
                this.hVH = true;
                this.hVG.notify();
            }
        } catch (IOException e2) {
            if (this.gZj != null) {
                this.gZj.R(12, com.baidu.tieba.i.a.i(e2));
            }
        } catch (IllegalStateException e3) {
            this.hVK = false;
            if (this.gZj != null) {
                this.gZj.R(13, com.baidu.tieba.i.a.i(e3));
                return;
            }
            return;
        }
        this.hVt = new com.faceunity.gles.a(eGLContext, 1);
        this.hVs = new com.faceunity.gles.e(this.hVt, this.hVw.getInputSurface(), true);
        this.hVs.makeCurrent();
        this.hVu = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.hVw.release();
            if (this.hVs != null) {
                this.hVs.release();
                this.hVs = null;
            }
            if (this.hVu != null) {
                this.hVu.release(false);
                this.hVu = null;
            }
            if (this.hVt != null) {
                this.hVt.release();
                this.hVt = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.gZj != null) {
                this.gZj.R(14, com.baidu.tieba.i.a.i(e2));
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
            synchronized (d.this.hVG) {
                while (!d.this.hVH) {
                    try {
                        d.this.hVG.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.hVH = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.bLU() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.hVz = 1;
                    while (!d.this.hVL) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.hVx.a(allocateDirect, read, d.this.bLV());
                                d.this.hVx.bLS();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.hVx.a(null, 0, d.this.bLV());
                    bVar.release();
                    d.this.hVx.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.hVI) {
                d.this.hVJ = true;
                d.this.hVI.notify();
            }
        }
    }

    protected long bLV() {
        long nanoTime = System.nanoTime();
        if (this.hVB != 0) {
            if (this.hVC == 0) {
                this.hVC = nanoTime;
            }
            nanoTime = (nanoTime - this.hVC) + this.hVB;
        }
        long j = nanoTime / 1000;
        if (j < this.hVM) {
            j += this.hVM - j;
        }
        if (j == this.hVM) {
            j += 100;
        }
        this.hVM = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.hVA = cVar;
    }
}
