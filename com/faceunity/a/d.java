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
import com.baidu.tieba.j.h;
import com.baidu.tieba.j.k;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes2.dex */
public class d {
    private static final int[] hLq = {1, 0, 5, 7, 6};
    private h gOa;
    private com.faceunity.a.e hLA;
    private com.faceunity.a.a hLB;
    private volatile HandlerC0266d hLC;
    private int hLD;
    private c hLE;
    private int hLH;
    private int hLI;
    private b hLJ;
    private final Object hLK;
    private boolean hLL;
    private final Object hLM;
    private boolean hLN;
    private boolean hLO;
    private boolean hLP;
    private long hLQ;
    private com.faceunity.a.c hLm;
    private com.faceunity.gles.e hLw;
    private com.faceunity.gles.a hLx;
    private com.faceunity.gles.c hLy;
    private int hLz;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long hLF = 0;
    private long hLG = 0;

    /* loaded from: classes2.dex */
    public interface c {
        void bEd();

        void bEe();
    }

    public boolean wF(int i) {
        return this.hLD == i;
    }

    public d() {
        this.hLD = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gOa = kVar.aXF();
        }
        this.hLJ = null;
        this.hLK = new Object();
        this.hLL = false;
        this.hLM = new Object();
        this.hLN = false;
        this.hLO = false;
        this.hLP = false;
        this.hLQ = 0L;
        this.hLD = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final int gfz;
        final long hLF;
        final EGLContext hLS;
        final File haM;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.haM = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.gfz = i3;
            if (eGLContext != null) {
                this.hLS = eGLContext;
            } else {
                this.hLS = EGL14.eglGetCurrentContext();
            }
            this.hLF = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.gfz + " to '" + this.haM.toString() + "' ctxt=" + this.hLS;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.hLH = iArr[0];
        GLES20.glBindTexture(3553, this.hLH);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.hLI = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.hLD = 5;
        this.hLF = bVar.hLF;
        this.hLG = System.nanoTime();
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
            this.hLC.sendMessage(this.hLC.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.hLI}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.hLH}, 0);
        this.hLI = 0;
        this.hLH = 0;
        if (this.hLm == null || !this.hLm.isStarted()) {
            this.hLP = true;
            if (this.hLA != null) {
                this.hLA.requestStop();
            }
        }
        this.hLD = 4;
        this.hLC.sendMessage(this.hLC.obtainMessage(1));
        this.hLC.sendMessage(this.hLC.obtainMessage(5));
    }

    public void d(SurfaceTexture surfaceTexture) {
        synchronized (this.mReadyFence) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.hLC.sendMessage(this.hLC.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.hLH != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.hLI);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.hLH, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.hLC.sendMessage(this.hLC.obtainMessage(3, this.hLH, 0, null));
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
                d.this.hLC = new HandlerC0266d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.hLC = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class HandlerC0266d extends Handler {
        private WeakReference<d> mWeakEncoder;

        public HandlerC0266d(d dVar) {
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
                        if (dVar.hLO) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.hLO) {
                            dVar.wG(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.hLO) {
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
        this.hLJ = bVar;
        this.hLz = 0;
        a(bVar.hLS, bVar.mWidth, bVar.mHeight, bVar.gfz, bVar.haM);
        this.hLP = false;
        if (this.hLE != null) {
            this.hLE.bEd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.hLH != 0) {
            try {
                this.hLA.oi(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.hLJ.mWidth, this.hLJ.mHeight);
            synchronized (d.class) {
                this.hLy.drawFrame(this.mTextureId, fArr);
            }
            if (this.hLw != null) {
                this.hLw.setPresentationTime(bNO() * 1000);
                this.hLw.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.hLA.oi(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.hLP = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.hLN) {
            synchronized (this.hLM) {
                try {
                    this.hLM.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.hLN = false;
        if (this.hLE != null) {
            this.hLE.bEe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wG(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.hLw != null) {
            this.hLw.releaseEglSurface();
        }
        this.hLy.release(false);
        if (this.hLx != null) {
            this.hLx.release();
        }
        this.hLx = new com.faceunity.gles.a(eGLContext, 1);
        if (this.hLw != null) {
            this.hLw.a(this.hLx);
            this.hLw.makeCurrent();
        }
        this.hLy = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.hLm = new com.faceunity.a.c(file.toString());
            this.hLA = new com.faceunity.a.e(i, i2, i3, this.hLm);
            this.hLB = new com.faceunity.a.a(this.hLm);
            this.hLO = true;
            synchronized (this.hLK) {
                this.hLL = true;
                this.hLK.notify();
            }
        } catch (IOException e2) {
            if (this.gOa != null) {
                this.gOa.Z(12, com.baidu.tieba.j.a.m(e2));
            }
        } catch (IllegalStateException e3) {
            this.hLO = false;
            if (this.gOa != null) {
                this.gOa.Z(13, com.baidu.tieba.j.a.m(e3));
                return;
            }
            return;
        }
        this.hLx = new com.faceunity.gles.a(eGLContext, 1);
        this.hLw = new com.faceunity.gles.e(this.hLx, this.hLA.getInputSurface(), true);
        this.hLw.makeCurrent();
        this.hLy = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.hLA.release();
            if (this.hLw != null) {
                this.hLw.release();
                this.hLw = null;
            }
            if (this.hLy != null) {
                this.hLy.release(false);
                this.hLy = null;
            }
            if (this.hLx != null) {
                this.hLx.release();
                this.hLx = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.gOa != null) {
                this.gOa.Z(14, com.baidu.tieba.j.a.m(e2));
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
            synchronized (d.this.hLK) {
                while (!d.this.hLL) {
                    try {
                        d.this.hLK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.hLL = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.bNN() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.hLD = 1;
                    while (!d.this.hLP) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.hLB.c(allocateDirect, read, d.this.bNO());
                                d.this.hLB.bNM();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.hLB.c(null, 0, d.this.bNO());
                    bVar.release();
                    d.this.hLB.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.hLM) {
                d.this.hLN = true;
                d.this.hLM.notify();
            }
        }
    }

    protected long bNO() {
        long nanoTime = System.nanoTime();
        if (this.hLF != 0) {
            if (this.hLG == 0) {
                this.hLG = nanoTime;
            }
            nanoTime = (nanoTime - this.hLG) + this.hLF;
        }
        long j = nanoTime / 1000;
        if (j < this.hLQ) {
            j += this.hLQ - j;
        }
        if (j == this.hLQ) {
            j += 100;
        }
        this.hLQ = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.hLE = cVar;
    }
}
