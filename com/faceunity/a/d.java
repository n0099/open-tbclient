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
    private static final int[] iwq = {1, 0, 5, 7, 6};
    private h hqM;
    private com.faceunity.a.e iwA;
    private com.faceunity.a.a iwB;
    private volatile HandlerC0366d iwC;
    private int iwE;
    private c iwF;
    private int iwI;
    private b iwJ;
    private final Object iwK;
    private boolean iwL;
    private final Object iwM;
    private boolean iwN;
    private boolean iwO;
    private boolean iwP;
    private long iwQ;
    private com.faceunity.a.c iwn;
    private com.faceunity.gles.e iww;
    private com.faceunity.gles.a iwx;
    private com.faceunity.gles.c iwy;
    private int iwz;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private int texture;
    private Object iwD = new Object();
    private long iwG = 0;
    private long iwH = 0;

    /* loaded from: classes5.dex */
    public interface c {
        void bLT();

        void bLU();
    }

    public boolean zg(int i) {
        return this.iwE == i;
    }

    public d() {
        this.iwE = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.hqM = lVar.bdZ();
        }
        this.iwJ = null;
        this.iwK = new Object();
        this.iwL = false;
        this.iwM = new Object();
        this.iwN = false;
        this.iwO = false;
        this.iwP = false;
        this.iwQ = 0L;
        this.iwE = 2;
    }

    /* loaded from: classes5.dex */
    public static class b {
        final int gHi;
        final File hEx;
        final long iwG;
        final EGLContext iwS;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.hEx = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.gHi = i3;
            if (eGLContext != null) {
                this.iwS = eGLContext;
            } else {
                this.iwS = EGL14.eglGetCurrentContext();
            }
            this.iwG = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.gHi + " to '" + this.hEx.toString() + "' ctxt=" + this.iwS;
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
        this.iwI = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.iwE = 5;
        this.iwG = bVar.iwG;
        this.iwH = System.nanoTime();
        synchronized (this.iwD) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.iwD.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.iwC.sendMessage(this.iwC.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.iwI}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.texture}, 0);
        this.iwI = 0;
        this.texture = 0;
        if (this.iwn == null || !this.iwn.isStarted()) {
            this.iwP = true;
            if (this.iwA != null) {
                this.iwA.requestStop();
            }
        }
        this.iwE = 4;
        this.iwC.sendMessage(this.iwC.obtainMessage(1));
        this.iwC.sendMessage(this.iwC.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.iwD) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.iwC.sendMessage(this.iwC.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.texture != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.iwI);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.iwD) {
                if (this.mReady) {
                    this.iwC.sendMessage(this.iwC.obtainMessage(3, this.texture, 0, null));
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
            synchronized (d.this.iwD) {
                d.this.iwC = new HandlerC0366d(d.this);
                d.this.mReady = true;
                d.this.iwD.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.iwD) {
                d.this.mReady = d.this.mRunning = false;
                d.this.iwC = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class HandlerC0366d extends Handler {
        private WeakReference<d> iwT;

        public HandlerC0366d(d dVar) {
            this.iwT = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.iwT.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.cbx();
                        return;
                    case 2:
                        if (dVar.iwO) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.iwO) {
                            dVar.zh(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.iwO) {
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
        this.iwJ = bVar;
        this.iwz = 0;
        a(bVar.iwS, bVar.mWidth, bVar.mHeight, bVar.gHi, bVar.hEx);
        this.iwP = false;
        if (this.iwF != null) {
            this.iwF.bLT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.texture != 0) {
            try {
                this.iwA.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.iwJ.mWidth, this.iwJ.mHeight);
            synchronized (d.class) {
                this.iwy.drawFrame(this.mTextureId, fArr);
            }
            if (this.iww != null) {
                this.iww.setPresentationTime(cbz() * 1000);
                this.iww.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbx() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.iwA.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.iwP = true;
        cby();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.iwN) {
            synchronized (this.iwM) {
                try {
                    this.iwM.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.iwN = false;
        if (this.iwF != null) {
            this.iwF.bLU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.iww != null) {
            this.iww.releaseEglSurface();
        }
        this.iwy.release(false);
        if (this.iwx != null) {
            this.iwx.release();
        }
        this.iwx = new com.faceunity.gles.a(eGLContext, 1);
        if (this.iww != null) {
            this.iww.a(this.iwx);
            this.iww.makeCurrent();
        }
        this.iwy = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.iwn = new com.faceunity.a.c(file.toString());
            this.iwA = new com.faceunity.a.e(i, i2, i3, this.iwn);
            this.iwB = new com.faceunity.a.a(this.iwn);
            this.iwO = true;
            synchronized (this.iwK) {
                this.iwL = true;
                this.iwK.notify();
            }
        } catch (IOException e2) {
            if (this.hqM != null) {
                this.hqM.aa(12, com.baidu.tieba.j.a.o(e2));
            }
        } catch (IllegalStateException e3) {
            this.iwO = false;
            if (this.hqM != null) {
                this.hqM.aa(13, com.baidu.tieba.j.a.o(e3));
                return;
            }
            return;
        }
        this.iwx = new com.faceunity.gles.a(eGLContext, 1);
        this.iww = new com.faceunity.gles.e(this.iwx, this.iwA.getInputSurface(), true);
        this.iww.makeCurrent();
        this.iwy = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void cby() {
        try {
            this.iwA.release();
            if (this.iww != null) {
                this.iww.release();
                this.iww = null;
            }
            if (this.iwy != null) {
                this.iwy.release(false);
                this.iwy = null;
            }
            if (this.iwx != null) {
                this.iwx.release();
                this.iwx = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.hqM != null) {
                this.hqM.aa(14, com.baidu.tieba.j.a.o(e2));
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
            synchronized (d.this.iwK) {
                while (!d.this.iwL) {
                    try {
                        d.this.iwK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.iwL = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.cbw() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.iwE = 1;
                    while (!d.this.iwP) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.iwB.c(allocateDirect, read, d.this.cbz());
                                d.this.iwB.cbv();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.iwB.c(null, 0, d.this.cbz());
                    bVar.release();
                    d.this.iwB.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.iwM) {
                d.this.iwN = true;
                d.this.iwM.notify();
            }
        }
    }

    protected long cbz() {
        long nanoTime = System.nanoTime();
        if (this.iwG != 0) {
            if (this.iwH == 0) {
                this.iwH = nanoTime;
            }
            nanoTime = (nanoTime - this.iwH) + this.iwG;
        }
        long j = nanoTime / 1000;
        if (j < this.iwQ) {
            j += this.iwQ - j;
        }
        if (j == this.iwQ) {
            j += 100;
        }
        this.iwQ = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.iwF = cVar;
    }
}
