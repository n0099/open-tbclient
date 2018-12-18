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
    private static final int[] irY = {1, 0, 5, 7, 6};
    private h hms;
    private com.faceunity.a.c irV;
    private com.faceunity.gles.e ise;
    private com.faceunity.gles.a isf;
    private com.faceunity.gles.c isg;
    private int ish;
    private com.faceunity.a.e isi;
    private com.faceunity.a.a isj;
    private volatile HandlerC0367d isk;
    private int ism;
    private c isn;
    private int isq;
    private b isr;
    private final Object iss;
    private boolean ist;
    private final Object isu;
    private boolean isv;
    private boolean isw;
    private boolean isx;
    private long isy;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private int texture;
    private Object isl = new Object();
    private long iso = 0;
    private long isp = 0;

    /* loaded from: classes5.dex */
    public interface c {
        void bKu();

        void bKv();
    }

    public boolean yR(int i) {
        return this.ism == i;
    }

    public d() {
        this.ism = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.hms = lVar.bcL();
        }
        this.isr = null;
        this.iss = new Object();
        this.ist = false;
        this.isu = new Object();
        this.isv = false;
        this.isw = false;
        this.isx = false;
        this.isy = 0L;
        this.ism = 2;
    }

    /* loaded from: classes5.dex */
    public static class b {
        final int gDm;
        final File hAe;
        final EGLContext isA;
        final long iso;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.hAe = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.gDm = i3;
            if (eGLContext != null) {
                this.isA = eGLContext;
            } else {
                this.isA = EGL14.eglGetCurrentContext();
            }
            this.iso = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.gDm + " to '" + this.hAe.toString() + "' ctxt=" + this.isA;
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
        this.isq = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.ism = 5;
        this.iso = bVar.iso;
        this.isp = System.nanoTime();
        synchronized (this.isl) {
            if (this.mRunning) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            new e("TextureMovieVideoEncoder").start();
            new a().start();
            while (!this.mReady) {
                try {
                    this.isl.wait();
                } catch (InterruptedException e2) {
                }
            }
            this.isk.sendMessage(this.isk.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.isq}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.texture}, 0);
        this.isq = 0;
        this.texture = 0;
        if (this.irV == null || !this.irV.isStarted()) {
            this.isx = true;
            if (this.isi != null) {
                this.isi.requestStop();
            }
        }
        this.ism = 4;
        this.isk.sendMessage(this.isk.obtainMessage(1));
        this.isk.sendMessage(this.isk.obtainMessage(5));
    }

    public void e(SurfaceTexture surfaceTexture) {
        synchronized (this.isl) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.isk.sendMessage(this.isk.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.texture != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.isq);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.isl) {
                if (this.mReady) {
                    this.isk.sendMessage(this.isk.obtainMessage(3, this.texture, 0, null));
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
            synchronized (d.this.isl) {
                d.this.isk = new HandlerC0367d(d.this);
                d.this.mReady = true;
                d.this.isl.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.isl) {
                d.this.mReady = d.this.mRunning = false;
                d.this.isk = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class HandlerC0367d extends Handler {
        private WeakReference<d> isB;

        public HandlerC0367d(d dVar) {
            this.isB = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.isB.get();
            if (dVar != null) {
                switch (i) {
                    case 0:
                        dVar.b((b) obj);
                        return;
                    case 1:
                        dVar.bZY();
                        return;
                    case 2:
                        if (dVar.isw) {
                            dVar.c((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.isw) {
                            dVar.yS(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.isw) {
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
        this.isr = bVar;
        this.ish = 0;
        a(bVar.isA, bVar.mWidth, bVar.mHeight, bVar.gDm, bVar.hAe);
        this.isx = false;
        if (this.isn != null) {
            this.isn.bKu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr, long j) {
        if (this.texture != 0) {
            try {
                this.isi.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.isr.mWidth, this.isr.mHeight);
            synchronized (d.class) {
                this.isg.drawFrame(this.mTextureId, fArr);
            }
            if (this.ise != null) {
                this.ise.setPresentationTime(caa() * 1000);
                this.ise.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZY() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.isi.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.isx = true;
        bZZ();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.isv) {
            synchronized (this.isu) {
                try {
                    this.isu.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.isv = false;
        if (this.isn != null) {
            this.isn.bKv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yS(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.ise != null) {
            this.ise.releaseEglSurface();
        }
        this.isg.release(false);
        if (this.isf != null) {
            this.isf.release();
        }
        this.isf = new com.faceunity.gles.a(eGLContext, 1);
        if (this.ise != null) {
            this.ise.a(this.isf);
            this.ise.makeCurrent();
        }
        this.isg = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.irV = new com.faceunity.a.c(file.toString());
            this.isi = new com.faceunity.a.e(i, i2, i3, this.irV);
            this.isj = new com.faceunity.a.a(this.irV);
            this.isw = true;
            synchronized (this.iss) {
                this.ist = true;
                this.iss.notify();
            }
        } catch (IOException e2) {
            if (this.hms != null) {
                this.hms.X(12, com.baidu.tieba.j.a.o(e2));
            }
        } catch (IllegalStateException e3) {
            this.isw = false;
            if (this.hms != null) {
                this.hms.X(13, com.baidu.tieba.j.a.o(e3));
                return;
            }
            return;
        }
        this.isf = new com.faceunity.gles.a(eGLContext, 1);
        this.ise = new com.faceunity.gles.e(this.isf, this.isi.getInputSurface(), true);
        this.ise.makeCurrent();
        this.isg = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void bZZ() {
        try {
            this.isi.release();
            if (this.ise != null) {
                this.ise.release();
                this.ise = null;
            }
            if (this.isg != null) {
                this.isg.release(false);
                this.isg = null;
            }
            if (this.isf != null) {
                this.isf.release();
                this.isf = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.hms != null) {
                this.hms.X(14, com.baidu.tieba.j.a.o(e2));
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
            synchronized (d.this.iss) {
                while (!d.this.ist) {
                    try {
                        d.this.iss.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.ist = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.bZX() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.startRecording();
                    d.this.ism = 1;
                    while (!d.this.isx) {
                        try {
                            allocateDirect.clear();
                            int read = bVar.read(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (read > 0) {
                                allocateDirect.position(read);
                                allocateDirect.flip();
                                d.this.isj.c(allocateDirect, read, d.this.caa());
                                d.this.isj.bZW();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.isj.c(null, 0, d.this.caa());
                    bVar.release();
                    d.this.isj.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.isu) {
                d.this.isv = true;
                d.this.isu.notify();
            }
        }
    }

    protected long caa() {
        long nanoTime = System.nanoTime();
        if (this.iso != 0) {
            if (this.isp == 0) {
                this.isp = nanoTime;
            }
            nanoTime = (nanoTime - this.isp) + this.iso;
        }
        long j = nanoTime / 1000;
        if (j < this.isy) {
            j += this.isy - j;
        }
        if (j == this.isy) {
            j += 100;
        }
        this.isy = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.isn = cVar;
    }
}
