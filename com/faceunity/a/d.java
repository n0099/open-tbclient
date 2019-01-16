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
    private static final int[] iwp = {1, 0, 5, 7, 6};
    private h hqL;
    private com.faceunity.a.a iwA;
    private volatile HandlerC0366d iwB;
    private int iwD;
    private c iwE;
    private int iwH;
    private b iwI;
    private final Object iwJ;
    private boolean iwK;
    private final Object iwL;
    private boolean iwM;
    private boolean iwN;
    private boolean iwO;
    private long iwP;
    private com.faceunity.a.c iwm;
    private com.faceunity.gles.e iwv;
    private com.faceunity.gles.a iww;
    private com.faceunity.gles.c iwx;
    private int iwy;
    private com.faceunity.a.e iwz;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private int texture;
    private Object iwC = new Object();
    private long iwF = 0;
    private long iwG = 0;

    /* loaded from: classes5.dex */
    public interface c {
        void bLT();

        void bLU();
    }

    public boolean zg(int i) {
        return this.iwD == i;
    }

    public d() {
        this.iwD = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.hqL = lVar.bdZ();
        }
        this.iwI = null;
        this.iwJ = new Object();
        this.iwK = false;
        this.iwL = new Object();
        this.iwM = false;
        this.iwN = false;
        this.iwO = false;
        this.iwP = 0L;
        this.iwD = 2;
    }

    /* loaded from: classes5.dex */
    public static class b {
        final int gHh;
        final File hEw;
        final long iwF;
        final EGLContext iwR;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.hEw = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.gHh = i3;
            if (eGLContext != null) {
                this.iwR = eGLContext;
            } else {
                this.iwR = EGL14.eglGetCurrentContext();
            }
            this.iwF = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.gHh + " to '" + this.hEw.toString() + "' ctxt=" + this.iwR;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.texture = iArr[0];
        GLES20.glBindTexture(3553, this.texture);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.iwH = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.iwD = 5;
        this.iwF = bVar.iwF;
        this.iwG = System.nanoTime();
        synchronized (this.iwC) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.iwC.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.iwB.sendMessage(this.iwB.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.iwH}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.texture}, 0);
        this.iwH = 0;
        this.texture = 0;
        if (this.iwm == null || !this.iwm.isStarted()) {
            this.iwO = true;
            if (this.iwz != null) {
                this.iwz.requestStop();
            }
        }
        this.iwD = 4;
        this.iwB.sendMessage(this.iwB.obtainMessage(1));
        this.iwB.sendMessage(this.iwB.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.iwC) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.iwB.sendMessage(this.iwB.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.texture != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.iwH);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.iwC) {
                if (this.mReady) {
                    this.iwB.sendMessage(this.iwB.obtainMessage(3, this.texture, 0, null));
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
            synchronized (d.this.iwC) {
                d.this.iwB = new HandlerC0366d(d.this);
                d.this.mReady = true;
                d.this.iwC.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.iwC) {
                d.this.mReady = d.this.mRunning = false;
                d.this.iwB = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class HandlerC0366d extends Handler {
        private WeakReference<d> iwS;

        public HandlerC0366d(d dVar) {
            this.iwS = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.iwS.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.cbx();
                        return;
                    case 2:
                        if (dVar.iwN) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.iwN) {
                            dVar.zh(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.iwN) {
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
        this.iwI = bVar;
        this.iwy = 0;
        a(bVar.iwR, bVar.mWidth, bVar.mHeight, bVar.gHh, bVar.hEw);
        this.iwO = false;
        if (this.iwE != null) {
            this.iwE.bLT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.texture != 0) {
            try {
                this.iwz.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.iwI.mWidth, this.iwI.mHeight);
            synchronized (d.class) {
                this.iwx.drawFrame(this.mTextureId, fArr);
            }
            if (this.iwv != null) {
                this.iwv.setPresentationTime(cbz() * 1000);
                this.iwv.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbx() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.iwz.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.iwO = true;
        cby();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.iwM) {
            synchronized (this.iwL) {
                try {
                    this.iwL.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.iwM = false;
        if (this.iwE != null) {
            this.iwE.bLU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.iwv != null) {
            this.iwv.releaseEglSurface();
        }
        this.iwx.release(false);
        if (this.iww != null) {
            this.iww.release();
        }
        this.iww = new com.faceunity.gles.a(eGLContext, 1);
        if (this.iwv != null) {
            this.iwv.a(this.iww);
            this.iwv.makeCurrent();
        }
        this.iwx = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.iwm = new com.faceunity.a.c(file.toString());
            this.iwz = new com.faceunity.a.e(i, i2, i3, this.iwm);
            this.iwA = new com.faceunity.a.a(this.iwm);
            this.iwN = true;
            synchronized (this.iwJ) {
                this.iwK = true;
                this.iwJ.notify();
            }
        } catch (IOException e2) {
            if (this.hqL != null) {
                this.hqL.aa(12, com.baidu.tieba.j.a.o(e2));
            }
        } catch (IllegalStateException e3) {
            this.iwN = false;
            if (this.hqL != null) {
                this.hqL.aa(13, com.baidu.tieba.j.a.o(e3));
                return;
            }
            return;
        }
        this.iww = new com.faceunity.gles.a(eGLContext, 1);
        this.iwv = new com.faceunity.gles.e(this.iww, this.iwz.getInputSurface(), true);
        this.iwv.makeCurrent();
        this.iwx = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void cby() {
        try {
            this.iwz.release();
            if (this.iwv != null) {
                this.iwv.release();
                this.iwv = null;
            }
            if (this.iwx != null) {
                this.iwx.release(false);
                this.iwx = null;
            }
            if (this.iww != null) {
                this.iww.release();
                this.iww = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.hqL != null) {
                this.hqL.aa(14, com.baidu.tieba.j.a.o(e2));
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
            synchronized (d.this.iwJ) {
                while (!d.this.iwK) {
                    try {
                        d.this.iwJ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.iwK = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.cbw() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.iwD = 1;
                    while (!d.this.iwO) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.iwA.c(allocateDirect, read, d.this.cbz());
                                d.this.iwA.cbv();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.iwA.c(null, 0, d.this.cbz());
                    bVar.release();
                    d.this.iwA.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.iwL) {
                d.this.iwM = true;
                d.this.iwL.notify();
            }
        }
    }

    protected long cbz() {
        long nanoTime = System.nanoTime();
        if (this.iwF != 0) {
            if (this.iwG == 0) {
                this.iwG = nanoTime;
            }
            nanoTime = (nanoTime - this.iwG) + this.iwF;
        }
        long j = nanoTime / 1000;
        if (j < this.iwP) {
            j += this.iwP - j;
        }
        if (j == this.iwP) {
            j += 100;
        }
        this.iwP = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.iwE = cVar;
    }
}
