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
    private static final int[] kmJ = {1, 0, 5, 7, 6};
    private int aec;
    private h jhv;
    private com.faceunity.a.c kmH;
    private com.faceunity.gles.e kmP;
    private com.faceunity.gles.a kmQ;
    private com.faceunity.gles.c kmR;
    private int kmS;
    private com.faceunity.a.e kmT;
    private com.faceunity.a.a kmU;
    private volatile HandlerC0462d kmV;
    private c kmX;
    private int kna;
    private int knb;
    private b knc;
    private final Object knd;
    private boolean kne;
    private final Object knf;
    private boolean kng;
    private boolean knh;
    private boolean kni;
    private long knj;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object kmW = new Object();
    private long kmY = 0;
    private long kmZ = 0;

    /* loaded from: classes5.dex */
    public interface c {
        void cwH();

        void cwI();
    }

    public boolean Ew(int i) {
        return this.aec == i;
    }

    public d() {
        this.aec = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.jhv = lVar.bPk();
        }
        this.knc = null;
        this.knd = new Object();
        this.kne = false;
        this.knf = new Object();
        this.kng = false;
        this.knh = false;
        this.kni = false;
        this.knj = 0L;
        this.aec = 2;
    }

    /* loaded from: classes5.dex */
    public static class b {
        final int ixd;
        final File jvc;
        final long kmY;
        final EGLContext mEglContext;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.jvc = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.ixd = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.kmY = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.ixd + " to '" + this.jvc.toString() + "' ctxt=" + this.mEglContext;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.kna = iArr[0];
        GLES20.glBindTexture(3553, this.kna);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.knb = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.aec = 5;
        this.kmY = bVar.kmY;
        this.kmZ = System.nanoTime();
        synchronized (this.kmW) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.kmW.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.kmV.sendMessage(this.kmV.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.knb}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.kna}, 0);
        this.knb = 0;
        this.kna = 0;
        if (this.kmH == null || !this.kmH.isStarted()) {
            this.kni = true;
            if (this.kmT != null) {
                this.kmT.requestStop();
            }
        }
        this.aec = 4;
        this.kmV.sendMessage(this.kmV.obtainMessage(1));
        this.kmV.sendMessage(this.kmV.obtainMessage(5));
    }

    public void d(SurfaceTexture surfaceTexture) {
        synchronized (this.kmW) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.kmV.sendMessage(this.kmV.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.kna != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.knb);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.kna, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.kmW) {
                if (this.mReady) {
                    this.kmV.sendMessage(this.kmV.obtainMessage(3, this.kna, 0, null));
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
            synchronized (d.this.kmW) {
                d.this.kmV = new HandlerC0462d(d.this);
                d.this.mReady = true;
                d.this.kmW.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.kmW) {
                d.this.mReady = d.this.mRunning = false;
                d.this.kmV = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class HandlerC0462d extends Handler {
        private WeakReference<d> knl;

        public HandlerC0462d(d dVar) {
            this.knl = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.knl.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.tH();
                        return;
                    case 2:
                        if (dVar.knh) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.knh) {
                            dVar.Ex(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.knh) {
                            dVar.d((EGLContext) message.obj);
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
        this.knc = bVar;
        this.kmS = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.ixd, bVar.jvc);
        this.kni = false;
        if (this.kmX != null) {
            this.kmX.cwH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.kna != 0) {
            try {
                this.kmT.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.knc.mWidth, this.knc.mHeight);
            synchronized (d.class) {
                this.kmR.drawFrame(this.mTextureId, fArr);
            }
            if (this.kmP != null) {
                this.kmP.setPresentationTime(cMf() * 1000);
                this.kmP.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tH() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.kmT.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.kni = true;
        tO();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.kng) {
            synchronized (this.knf) {
                try {
                    this.knf.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.kng = false;
        if (this.kmX != null) {
            this.kmX.cwI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ex(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.kmP != null) {
            this.kmP.releaseEglSurface();
        }
        this.kmR.release(false);
        if (this.kmQ != null) {
            this.kmQ.release();
        }
        this.kmQ = new com.faceunity.gles.a(eGLContext, 1);
        if (this.kmP != null) {
            this.kmP.a(this.kmQ);
            this.kmP.makeCurrent();
        }
        this.kmR = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.kmH = new com.faceunity.a.c(file.toString());
            this.kmT = new com.faceunity.a.e(i, i2, i3, this.kmH);
            this.kmU = new com.faceunity.a.a(this.kmH);
            this.knh = true;
            synchronized (this.knd) {
                this.kne = true;
                this.knd.notify();
            }
        } catch (IOException e2) {
            if (this.jhv != null) {
                this.jhv.av(12, com.baidu.tieba.j.a.p(e2));
            }
        } catch (IllegalStateException e3) {
            this.knh = false;
            if (this.jhv != null) {
                this.jhv.av(13, com.baidu.tieba.j.a.p(e3));
                return;
            }
            return;
        }
        this.kmQ = new com.faceunity.gles.a(eGLContext, 1);
        this.kmP = new com.faceunity.gles.e(this.kmQ, this.kmT.getInputSurface(), true);
        this.kmP.makeCurrent();
        this.kmR = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void tO() {
        try {
            this.kmT.release();
            if (this.kmP != null) {
                this.kmP.release();
                this.kmP = null;
            }
            if (this.kmR != null) {
                this.kmR.release(false);
                this.kmR = null;
            }
            if (this.kmQ != null) {
                this.kmQ.release();
                this.kmQ = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.jhv != null) {
                this.jhv.av(14, com.baidu.tieba.j.a.p(e2));
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
            synchronized (d.this.knd) {
                while (!d.this.kne) {
                    try {
                        d.this.knd.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.kne = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.cMe() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.tE();
                    d.this.aec = 1;
                    while (!d.this.kni) {
                        try {
                            allocateDirect.clear();
                            int b = bVar.b(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (b > 0) {
                                allocateDirect.position(b);
                                allocateDirect.flip();
                                d.this.kmU.f(allocateDirect, b, d.this.cMf());
                                d.this.kmU.cMc();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.kmU.f(null, 0, d.this.cMf());
                    bVar.release();
                    d.this.kmU.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.knf) {
                d.this.kng = true;
                d.this.knf.notify();
            }
        }
    }

    protected long cMf() {
        long nanoTime = System.nanoTime();
        if (this.kmY != 0) {
            if (this.kmZ == 0) {
                this.kmZ = nanoTime;
            }
            nanoTime = (nanoTime - this.kmZ) + this.kmY;
        }
        long j = nanoTime / 1000;
        if (j < this.knj) {
            j += this.knj - j;
        }
        if (j == this.knj) {
            j += 100;
        }
        this.knj = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.kmX = cVar;
    }
}
