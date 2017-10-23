package com.faceunity.a;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.AudioRecord;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes2.dex */
public class c {
    private static final int[] gXL = {1, 0, 5, 7, 6};
    private InterfaceC0146c gXA;
    private int gXD;
    private int gXE;
    private com.faceunity.a.b gXl;
    private com.faceunity.gles.e gXs;
    private com.faceunity.gles.a gXt;
    private com.faceunity.gles.c gXu;
    private int gXv;
    private com.faceunity.a.d gXw;
    private com.faceunity.a.a gXx;
    private volatile d gXy;
    private int gXz;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long gXB = 0;
    private long gXC = 0;
    private b gXF = null;
    private final Object gXG = new Object();
    private boolean gXH = false;
    private final Object gXI = new Object();
    private boolean gXJ = false;
    private boolean gXK = false;
    private long gXM = 0;

    /* renamed from: com.faceunity.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0146c {
        void bFe();

        void bFf();
    }

    public boolean vS(int i) {
        return this.gXz == i;
    }

    public c() {
        this.gXz = 4;
        this.gXz = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final long gXB;
        final int gXO;
        final EGLContext gXP;
        final File gxm;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.gxm = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.gXO = i3;
            if (eGLContext != null) {
                this.gXP = eGLContext;
            } else {
                this.gXP = EGL14.eglGetCurrentContext();
            }
            this.gXB = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.gXO + " to '" + this.gxm.toString() + "' ctxt=" + this.gXP;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.gXD = iArr[0];
        GLES20.glBindTexture(3553, this.gXD);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.gXE = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.gXz = 5;
        this.gXB = bVar.gXB;
        this.gXC = System.nanoTime();
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
            this.gXy.sendMessage(this.gXy.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.gXE}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.gXD}, 0);
        this.gXE = 0;
        this.gXD = 0;
        this.gXz = 4;
        this.gXy.sendMessage(this.gXy.obtainMessage(1));
        this.gXy.sendMessage(this.gXy.obtainMessage(5));
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
                    this.gXy.sendMessage(this.gXy.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.gXD != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.gXE);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.gXD, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.gXy.sendMessage(this.gXy.obtainMessage(3, this.gXD, 0, null));
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
            synchronized (c.this.mReadyFence) {
                c.this.gXy = new d(c.this);
                c.this.mReady = true;
                c.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (c.this.mReadyFence) {
                c.this.mReady = c.this.mRunning = false;
                c.this.gXy = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class d extends Handler {
        private WeakReference<c> mWeakEncoder;

        public d(c cVar) {
            this.mWeakEncoder = new WeakReference<>(cVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            c cVar = this.mWeakEncoder.get();
            if (cVar != null) {
                switch (i) {
                    case 0:
                        cVar.b((b) obj);
                        return;
                    case 1:
                        cVar.handleStopRecording();
                        return;
                    case 2:
                        cVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                        return;
                    case 3:
                        cVar.vT(message.arg1);
                        return;
                    case 4:
                        cVar.handleUpdateSharedContext((EGLContext) message.obj);
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
        this.gXF = bVar;
        this.gXv = 0;
        a(bVar.gXP, bVar.mWidth, bVar.mHeight, bVar.gXO, bVar.gxm);
        this.gXK = false;
        if (this.gXA != null) {
            this.gXA.bFe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.gXD != 0) {
            try {
                this.gXw.nN(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.gXF.mWidth, this.gXF.mHeight);
            synchronized (c.class) {
                this.gXu.drawFrame(this.mTextureId, fArr);
            }
            this.gXs.setPresentationTime(bFc() * 1000);
            this.gXs.swapBuffers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.gXw.nN(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.gXK = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.gXJ) {
            synchronized (this.gXI) {
                try {
                    this.gXI.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.gXJ = false;
        if (this.gXA != null) {
            this.gXA.bFf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vT(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        this.gXs.releaseEglSurface();
        this.gXu.release(false);
        this.gXt.release();
        this.gXt = new com.faceunity.gles.a(eGLContext, 1);
        this.gXs.a(this.gXt);
        this.gXs.makeCurrent();
        this.gXu = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.gXl = new com.faceunity.a.b(file.toString());
            this.gXw = new com.faceunity.a.d(i, i2, i3, this.gXl);
            this.gXx = new com.faceunity.a.a(this.gXl);
            synchronized (this.gXG) {
                this.gXH = true;
                this.gXG.notify();
            }
            this.gXt = new com.faceunity.gles.a(eGLContext, 1);
            this.gXs = new com.faceunity.gles.e(this.gXt, this.gXw.getInputSurface(), true);
            this.gXs.makeCurrent();
            this.gXu = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void releaseEncoder() {
        try {
            this.gXw.release();
            if (this.gXs != null) {
                this.gXs.release();
                this.gXs = null;
            }
            if (this.gXu != null) {
                this.gXu.release(false);
                this.gXu = null;
            }
            if (this.gXt != null) {
                this.gXt.release();
                this.gXt = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* loaded from: classes2.dex */
    private class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AudioRecord audioRecord;
            Process.setThreadPriority(-19);
            synchronized (c.this.gXG) {
                while (!c.this.gXH) {
                    try {
                        c.this.gXG.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            c.this.gXH = false;
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(48000, 16, 2);
                int i = 49152;
                if (49152 < minBufferSize) {
                    i = ((minBufferSize / 2048) + 1) * 2048 * 2;
                }
                int[] iArr = c.gXL;
                int length = iArr.length;
                int i2 = 0;
                AudioRecord audioRecord2 = null;
                while (true) {
                    if (i2 >= length) {
                        audioRecord = audioRecord2;
                        break;
                    }
                    try {
                        audioRecord2 = new AudioRecord(iArr[i2], 48000, 16, 2, i);
                        if (audioRecord2.getState() != 1) {
                            audioRecord2 = null;
                        }
                    } catch (Exception e2) {
                        audioRecord2 = null;
                    }
                    if (audioRecord2 != null) {
                        audioRecord = audioRecord2;
                        break;
                    }
                    i2++;
                }
                if (audioRecord != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(2048);
                    audioRecord.startRecording();
                    c.this.gXz = 1;
                    while (!c.this.gXK) {
                        allocateDirect.clear();
                        int read = audioRecord.read(allocateDirect, 2048);
                        if (read > 0) {
                            allocateDirect.position(read);
                            allocateDirect.flip();
                            c.this.gXx.a(allocateDirect, read, c.this.bFc());
                            c.this.gXx.bFb();
                        }
                    }
                    c.this.gXx.a(null, 0, c.this.bFc());
                    audioRecord.stop();
                    audioRecord.release();
                    c.this.gXx.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (c.this.gXI) {
                c.this.gXJ = true;
                c.this.gXI.notify();
            }
        }
    }

    protected long bFc() {
        long nanoTime = System.nanoTime();
        if (this.gXB != 0) {
            if (this.gXC == 0) {
                this.gXC = nanoTime;
            }
            nanoTime = (nanoTime - this.gXC) + this.gXB;
        }
        long j = nanoTime / 1000;
        if (j < this.gXM) {
            j += this.gXM - j;
        }
        if (j == this.gXM) {
            j += 100;
        }
        this.gXM = j;
        return j;
    }
}
