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
    private static final int[] ijd = {1, 0, 5, 7, 6};
    private h heb;
    private com.faceunity.a.c iiZ;
    private boolean ijA;
    private boolean ijB;
    private long ijC;
    private com.faceunity.gles.e ijj;
    private com.faceunity.gles.a ijk;
    private com.faceunity.gles.c ijl;
    private int ijm;
    private com.faceunity.a.e ijn;
    private com.faceunity.a.a ijo;
    private volatile HandlerC0325d ijp;
    private int ijq;
    private c ijr;
    private int iju;
    private b ijv;
    private final Object ijw;
    private boolean ijx;
    private final Object ijy;
    private boolean ijz;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private int texture;
    private Object mReadyFence = new Object();
    private long ijs = 0;
    private long ijt = 0;

    /* loaded from: classes5.dex */
    public interface c {
        void bIR();

        void bIS();
    }

    public boolean yb(int i) {
        return this.ijq == i;
    }

    public d() {
        this.ijq = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.heb = lVar.bbw();
        }
        this.ijv = null;
        this.ijw = new Object();
        this.ijx = false;
        this.ijy = new Object();
        this.ijz = false;
        this.ijA = false;
        this.ijB = false;
        this.ijC = 0L;
        this.ijq = 2;
    }

    /* loaded from: classes5.dex */
    public static class b {
        final int guV;
        final File hrj;
        final EGLContext ijE;
        final long ijs;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.hrj = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.guV = i3;
            if (eGLContext != null) {
                this.ijE = eGLContext;
            } else {
                this.ijE = EGL14.eglGetCurrentContext();
            }
            this.ijs = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.guV + " to '" + this.hrj.toString() + "' ctxt=" + this.ijE;
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
        this.iju = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.ijq = 5;
        this.ijs = bVar.ijs;
        this.ijt = System.nanoTime();
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
            this.ijp.sendMessage(this.ijp.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.iju}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.texture}, 0);
        this.iju = 0;
        this.texture = 0;
        if (this.iiZ == null || !this.iiZ.isStarted()) {
            this.ijB = true;
            if (this.ijn != null) {
                this.ijn.requestStop();
            }
        }
        this.ijq = 4;
        this.ijp.sendMessage(this.ijp.obtainMessage(1));
        this.ijp.sendMessage(this.ijp.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.mReadyFence) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.ijp.sendMessage(this.ijp.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.texture != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.iju);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.ijp.sendMessage(this.ijp.obtainMessage(3, this.texture, 0, null));
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
            synchronized (d.this.mReadyFence) {
                d.this.ijp = new HandlerC0325d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.ijp = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class HandlerC0325d extends Handler {
        private WeakReference<d> mWeakEncoder;

        public HandlerC0325d(d dVar) {
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
                        if (dVar.ijA) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.ijA) {
                            dVar.yc(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.ijA) {
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
        this.ijv = bVar;
        this.ijm = 0;
        a(bVar.ijE, bVar.mWidth, bVar.mHeight, bVar.guV, bVar.hrj);
        this.ijB = false;
        if (this.ijr != null) {
            this.ijr.bIR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.texture != 0) {
            try {
                this.ijn.oL(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.ijv.mWidth, this.ijv.mHeight);
            synchronized (d.class) {
                this.ijl.drawFrame(this.mTextureId, fArr);
            }
            if (this.ijj != null) {
                this.ijj.setPresentationTime(bYy() * 1000);
                this.ijj.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.ijn.oL(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.ijB = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.ijz) {
            synchronized (this.ijy) {
                try {
                    this.ijy.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.ijz = false;
        if (this.ijr != null) {
            this.ijr.bIS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yc(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.ijj != null) {
            this.ijj.releaseEglSurface();
        }
        this.ijl.release(false);
        if (this.ijk != null) {
            this.ijk.release();
        }
        this.ijk = new com.faceunity.gles.a(eGLContext, 1);
        if (this.ijj != null) {
            this.ijj.a(this.ijk);
            this.ijj.makeCurrent();
        }
        this.ijl = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.iiZ = new com.faceunity.a.c(file.toString());
            this.ijn = new com.faceunity.a.e(i, i2, i3, this.iiZ);
            this.ijo = new com.faceunity.a.a(this.iiZ);
            this.ijA = true;
            synchronized (this.ijw) {
                this.ijx = true;
                this.ijw.notify();
            }
        } catch (IOException e2) {
            if (this.heb != null) {
                this.heb.ab(12, com.baidu.tieba.j.a.o(e2));
            }
        } catch (IllegalStateException e3) {
            this.ijA = false;
            if (this.heb != null) {
                this.heb.ab(13, com.baidu.tieba.j.a.o(e3));
                return;
            }
            return;
        }
        this.ijk = new com.faceunity.gles.a(eGLContext, 1);
        this.ijj = new com.faceunity.gles.e(this.ijk, this.ijn.getInputSurface(), true);
        this.ijj.makeCurrent();
        this.ijl = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.ijn.release();
            if (this.ijj != null) {
                this.ijj.release();
                this.ijj = null;
            }
            if (this.ijl != null) {
                this.ijl.release(false);
                this.ijl = null;
            }
            if (this.ijk != null) {
                this.ijk.release();
                this.ijk = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.heb != null) {
                this.heb.ab(14, com.baidu.tieba.j.a.o(e2));
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
            synchronized (d.this.ijw) {
                while (!d.this.ijx) {
                    try {
                        d.this.ijw.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.ijx = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.bYx() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.ijq = 1;
                    while (!d.this.ijB) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.ijo.c(allocateDirect, read, d.this.bYy());
                                d.this.ijo.bYw();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.ijo.c(null, 0, d.this.bYy());
                    bVar.release();
                    d.this.ijo.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.ijy) {
                d.this.ijz = true;
                d.this.ijy.notify();
            }
        }
    }

    protected long bYy() {
        long nanoTime = System.nanoTime();
        if (this.ijs != 0) {
            if (this.ijt == 0) {
                this.ijt = nanoTime;
            }
            nanoTime = (nanoTime - this.ijt) + this.ijs;
        }
        long j = nanoTime / 1000;
        if (j < this.ijC) {
            j += this.ijC - j;
        }
        if (j == this.ijC) {
            j += 100;
        }
        this.ijC = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.ijr = cVar;
    }
}
