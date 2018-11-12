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
    private static final int[] ikM = {1, 0, 5, 7, 6};
    private h hfy;
    private com.faceunity.a.c ikJ;
    private com.faceunity.gles.e ikS;
    private com.faceunity.gles.a ikT;
    private com.faceunity.gles.c ikU;
    private int ikV;
    private com.faceunity.a.e ikW;
    private com.faceunity.a.a ikX;
    private volatile HandlerC0353d ikY;
    private int ila;
    private c ilb;
    private int ile;
    private b ilf;
    private final Object ilg;
    private boolean ilh;
    private final Object ili;
    private boolean ilj;
    private boolean ilk;
    private boolean ill;
    private long ilm;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private int texture;
    private Object ikZ = new Object();
    private long ilc = 0;
    private long ild = 0;

    /* loaded from: classes5.dex */
    public interface c {
        void bIq();

        void bIr();
    }

    public boolean yu(int i) {
        return this.ila == i;
    }

    public d() {
        this.ila = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.hfy = lVar.baV();
        }
        this.ilf = null;
        this.ilg = new Object();
        this.ilh = false;
        this.ili = new Object();
        this.ilj = false;
        this.ilk = false;
        this.ill = false;
        this.ilm = 0L;
        this.ila = 2;
    }

    /* loaded from: classes5.dex */
    public static class b {
        final int gww;
        final File hsS;
        final long ilc;
        final EGLContext ilo;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.hsS = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.gww = i3;
            if (eGLContext != null) {
                this.ilo = eGLContext;
            } else {
                this.ilo = EGL14.eglGetCurrentContext();
            }
            this.ilc = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.gww + " to '" + this.hsS.toString() + "' ctxt=" + this.ilo;
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
        this.ile = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.ila = 5;
        this.ilc = bVar.ilc;
        this.ild = System.nanoTime();
        synchronized (this.ikZ) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.ikZ.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.ikY.sendMessage(this.ikY.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.ile}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.texture}, 0);
        this.ile = 0;
        this.texture = 0;
        if (this.ikJ == null || !this.ikJ.isStarted()) {
            this.ill = true;
            if (this.ikW != null) {
                this.ikW.requestStop();
            }
        }
        this.ila = 4;
        this.ikY.sendMessage(this.ikY.obtainMessage(1));
        this.ikY.sendMessage(this.ikY.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.ikZ) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.ikY.sendMessage(this.ikY.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.texture != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.ile);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.ikZ) {
                if (this.mReady) {
                    this.ikY.sendMessage(this.ikY.obtainMessage(3, this.texture, 0, null));
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
            synchronized (d.this.ikZ) {
                d.this.ikY = new HandlerC0353d(d.this);
                d.this.mReady = true;
                d.this.ikZ.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.ikZ) {
                d.this.mReady = d.this.mRunning = false;
                d.this.ikY = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class HandlerC0353d extends Handler {
        private WeakReference<d> ilp;

        public HandlerC0353d(d dVar) {
            this.ilp = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.ilp.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.bXT();
                        return;
                    case 2:
                        if (dVar.ilk) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.ilk) {
                            dVar.yv(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.ilk) {
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
        this.ilf = bVar;
        this.ikV = 0;
        a(bVar.ilo, bVar.mWidth, bVar.mHeight, bVar.gww, bVar.hsS);
        this.ill = false;
        if (this.ilb != null) {
            this.ilb.bIq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.texture != 0) {
            try {
                this.ikW.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.ilf.mWidth, this.ilf.mHeight);
            synchronized (d.class) {
                this.ikU.drawFrame(this.mTextureId, fArr);
            }
            if (this.ikS != null) {
                this.ikS.setPresentationTime(bXV() * 1000);
                this.ikS.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXT() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.ikW.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.ill = true;
        bXU();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.ilj) {
            synchronized (this.ili) {
                try {
                    this.ili.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.ilj = false;
        if (this.ilb != null) {
            this.ilb.bIr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yv(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.ikS != null) {
            this.ikS.releaseEglSurface();
        }
        this.ikU.release(false);
        if (this.ikT != null) {
            this.ikT.release();
        }
        this.ikT = new com.faceunity.gles.a(eGLContext, 1);
        if (this.ikS != null) {
            this.ikS.a(this.ikT);
            this.ikS.makeCurrent();
        }
        this.ikU = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.ikJ = new com.faceunity.a.c(file.toString());
            this.ikW = new com.faceunity.a.e(i, i2, i3, this.ikJ);
            this.ikX = new com.faceunity.a.a(this.ikJ);
            this.ilk = true;
            synchronized (this.ilg) {
                this.ilh = true;
                this.ilg.notify();
            }
        } catch (IOException e2) {
            if (this.hfy != null) {
                this.hfy.X(12, com.baidu.tieba.j.a.o(e2));
            }
        } catch (IllegalStateException e3) {
            this.ilk = false;
            if (this.hfy != null) {
                this.hfy.X(13, com.baidu.tieba.j.a.o(e3));
                return;
            }
            return;
        }
        this.ikT = new com.faceunity.gles.a(eGLContext, 1);
        this.ikS = new com.faceunity.gles.e(this.ikT, this.ikW.getInputSurface(), true);
        this.ikS.makeCurrent();
        this.ikU = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void bXU() {
        try {
            this.ikW.release();
            if (this.ikS != null) {
                this.ikS.release();
                this.ikS = null;
            }
            if (this.ikU != null) {
                this.ikU.release(false);
                this.ikU = null;
            }
            if (this.ikT != null) {
                this.ikT.release();
                this.ikT = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.hfy != null) {
                this.hfy.X(14, com.baidu.tieba.j.a.o(e2));
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
            synchronized (d.this.ilg) {
                while (!d.this.ilh) {
                    try {
                        d.this.ilg.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.ilh = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.bXS() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.ila = 1;
                    while (!d.this.ill) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.ikX.c(allocateDirect, read, d.this.bXV());
                                d.this.ikX.bXR();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.ikX.c(null, 0, d.this.bXV());
                    bVar.release();
                    d.this.ikX.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.ili) {
                d.this.ilj = true;
                d.this.ili.notify();
            }
        }
    }

    protected long bXV() {
        long nanoTime = System.nanoTime();
        if (this.ilc != 0) {
            if (this.ild == 0) {
                this.ild = nanoTime;
            }
            nanoTime = (nanoTime - this.ild) + this.ilc;
        }
        long j = nanoTime / 1000;
        if (j < this.ilm) {
            j += this.ilm - j;
        }
        if (j == this.ilm) {
            j += 100;
        }
        this.ilm = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.ilb = cVar;
    }
}
