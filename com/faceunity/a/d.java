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
    private static final int[] ijc = {1, 0, 5, 7, 6};
    private h hea;
    private com.faceunity.a.c iiY;
    private boolean ijA;
    private long ijB;
    private com.faceunity.gles.e iji;
    private com.faceunity.gles.a ijj;
    private com.faceunity.gles.c ijk;
    private int ijl;
    private com.faceunity.a.e ijm;
    private com.faceunity.a.a ijn;
    private volatile HandlerC0325d ijo;
    private int ijp;
    private c ijq;
    private int ijt;
    private b iju;
    private final Object ijv;
    private boolean ijw;
    private final Object ijx;
    private boolean ijy;
    private boolean ijz;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private int texture;
    private Object mReadyFence = new Object();
    private long ijr = 0;
    private long ijs = 0;

    /* loaded from: classes5.dex */
    public interface c {
        void bIR();

        void bIS();
    }

    public boolean yb(int i) {
        return this.ijp == i;
    }

    public d() {
        this.ijp = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.hea = lVar.bbw();
        }
        this.iju = null;
        this.ijv = new Object();
        this.ijw = false;
        this.ijx = new Object();
        this.ijy = false;
        this.ijz = false;
        this.ijA = false;
        this.ijB = 0L;
        this.ijp = 2;
    }

    /* loaded from: classes5.dex */
    public static class b {
        final int guU;
        final File hri;
        final EGLContext ijD;
        final long ijr;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.hri = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.guU = i3;
            if (eGLContext != null) {
                this.ijD = eGLContext;
            } else {
                this.ijD = EGL14.eglGetCurrentContext();
            }
            this.ijr = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.guU + " to '" + this.hri.toString() + "' ctxt=" + this.ijD;
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
        this.ijt = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.ijp = 5;
        this.ijr = bVar.ijr;
        this.ijs = System.nanoTime();
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
            this.ijo.sendMessage(this.ijo.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.ijt}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.texture}, 0);
        this.ijt = 0;
        this.texture = 0;
        if (this.iiY == null || !this.iiY.isStarted()) {
            this.ijA = true;
            if (this.ijm != null) {
                this.ijm.requestStop();
            }
        }
        this.ijp = 4;
        this.ijo.sendMessage(this.ijo.obtainMessage(1));
        this.ijo.sendMessage(this.ijo.obtainMessage(5));
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
                    this.ijo.sendMessage(this.ijo.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.texture != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.ijt);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.ijo.sendMessage(this.ijo.obtainMessage(3, this.texture, 0, null));
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
                d.this.ijo = new HandlerC0325d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.ijo = null;
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
                        if (dVar.ijz) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.ijz) {
                            dVar.yc(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.ijz) {
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
        this.iju = bVar;
        this.ijl = 0;
        a(bVar.ijD, bVar.mWidth, bVar.mHeight, bVar.guU, bVar.hri);
        this.ijA = false;
        if (this.ijq != null) {
            this.ijq.bIR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.texture != 0) {
            try {
                this.ijm.oL(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.iju.mWidth, this.iju.mHeight);
            synchronized (d.class) {
                this.ijk.drawFrame(this.mTextureId, fArr);
            }
            if (this.iji != null) {
                this.iji.setPresentationTime(bYy() * 1000);
                this.iji.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.ijm.oL(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.ijA = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.ijy) {
            synchronized (this.ijx) {
                try {
                    this.ijx.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.ijy = false;
        if (this.ijq != null) {
            this.ijq.bIS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yc(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.iji != null) {
            this.iji.releaseEglSurface();
        }
        this.ijk.release(false);
        if (this.ijj != null) {
            this.ijj.release();
        }
        this.ijj = new com.faceunity.gles.a(eGLContext, 1);
        if (this.iji != null) {
            this.iji.a(this.ijj);
            this.iji.makeCurrent();
        }
        this.ijk = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.iiY = new com.faceunity.a.c(file.toString());
            this.ijm = new com.faceunity.a.e(i, i2, i3, this.iiY);
            this.ijn = new com.faceunity.a.a(this.iiY);
            this.ijz = true;
            synchronized (this.ijv) {
                this.ijw = true;
                this.ijv.notify();
            }
        } catch (IOException e2) {
            if (this.hea != null) {
                this.hea.ab(12, com.baidu.tieba.j.a.o(e2));
            }
        } catch (IllegalStateException e3) {
            this.ijz = false;
            if (this.hea != null) {
                this.hea.ab(13, com.baidu.tieba.j.a.o(e3));
                return;
            }
            return;
        }
        this.ijj = new com.faceunity.gles.a(eGLContext, 1);
        this.iji = new com.faceunity.gles.e(this.ijj, this.ijm.getInputSurface(), true);
        this.iji.makeCurrent();
        this.ijk = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.ijm.release();
            if (this.iji != null) {
                this.iji.release();
                this.iji = null;
            }
            if (this.ijk != null) {
                this.ijk.release(false);
                this.ijk = null;
            }
            if (this.ijj != null) {
                this.ijj.release();
                this.ijj = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.hea != null) {
                this.hea.ab(14, com.baidu.tieba.j.a.o(e2));
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
            synchronized (d.this.ijv) {
                while (!d.this.ijw) {
                    try {
                        d.this.ijv.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.ijw = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.bYx() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.ijp = 1;
                    while (!d.this.ijA) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.ijn.c(allocateDirect, read, d.this.bYy());
                                d.this.ijn.bYw();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.ijn.c(null, 0, d.this.bYy());
                    bVar.release();
                    d.this.ijn.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.ijx) {
                d.this.ijy = true;
                d.this.ijx.notify();
            }
        }
    }

    protected long bYy() {
        long nanoTime = System.nanoTime();
        if (this.ijr != 0) {
            if (this.ijs == 0) {
                this.ijs = nanoTime;
            }
            nanoTime = (nanoTime - this.ijs) + this.ijr;
        }
        long j = nanoTime / 1000;
        if (j < this.ijB) {
            j += this.ijB - j;
        }
        if (j == this.ijB) {
            j += 100;
        }
        this.ijB = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.ijq = cVar;
    }
}
