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
    private static final int[] gYa = {1, 0, 5, 7, 6};
    private com.faceunity.a.b gXA;
    private com.faceunity.gles.e gXH;
    private com.faceunity.gles.a gXI;
    private com.faceunity.gles.c gXJ;
    private int gXK;
    private com.faceunity.a.d gXL;
    private com.faceunity.a.a gXM;
    private volatile d gXN;
    private int gXO;
    private InterfaceC0146c gXP;
    private int gXS;
    private int gXT;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long gXQ = 0;
    private long gXR = 0;
    private b gXU = null;
    private final Object gXV = new Object();
    private boolean gXW = false;
    private final Object gXX = new Object();
    private boolean gXY = false;
    private boolean gXZ = false;
    private long gYb = 0;

    /* renamed from: com.faceunity.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0146c {
        void bFk();

        void bFl();
    }

    public boolean vT(int i) {
        return this.gXO == i;
    }

    public c() {
        this.gXO = 4;
        this.gXO = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final long gXQ;
        final int gYd;
        final EGLContext gYe;
        final File gxA;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.gxA = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.gYd = i3;
            if (eGLContext != null) {
                this.gYe = eGLContext;
            } else {
                this.gYe = EGL14.eglGetCurrentContext();
            }
            this.gXQ = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.gYd + " to '" + this.gxA.toString() + "' ctxt=" + this.gYe;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.gXS = iArr[0];
        GLES20.glBindTexture(3553, this.gXS);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.gXT = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.gXO = 5;
        this.gXQ = bVar.gXQ;
        this.gXR = System.nanoTime();
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
            this.gXN.sendMessage(this.gXN.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.gXT}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.gXS}, 0);
        this.gXT = 0;
        this.gXS = 0;
        this.gXO = 4;
        this.gXN.sendMessage(this.gXN.obtainMessage(1));
        this.gXN.sendMessage(this.gXN.obtainMessage(5));
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
                    this.gXN.sendMessage(this.gXN.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.gXS != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.gXT);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.gXS, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.gXN.sendMessage(this.gXN.obtainMessage(3, this.gXS, 0, null));
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
                c.this.gXN = new d(c.this);
                c.this.mReady = true;
                c.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (c.this.mReadyFence) {
                c.this.mReady = c.this.mRunning = false;
                c.this.gXN = null;
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
                        cVar.vU(message.arg1);
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
        this.gXU = bVar;
        this.gXK = 0;
        a(bVar.gYe, bVar.mWidth, bVar.mHeight, bVar.gYd, bVar.gxA);
        this.gXZ = false;
        if (this.gXP != null) {
            this.gXP.bFk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.gXS != 0) {
            try {
                this.gXL.nO(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.gXU.mWidth, this.gXU.mHeight);
            synchronized (c.class) {
                this.gXJ.drawFrame(this.mTextureId, fArr);
            }
            this.gXH.setPresentationTime(bFi() * 1000);
            this.gXH.swapBuffers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.gXL.nO(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.gXZ = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.gXY) {
            synchronized (this.gXX) {
                try {
                    this.gXX.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.gXY = false;
        if (this.gXP != null) {
            this.gXP.bFl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vU(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        this.gXH.releaseEglSurface();
        this.gXJ.release(false);
        this.gXI.release();
        this.gXI = new com.faceunity.gles.a(eGLContext, 1);
        this.gXH.a(this.gXI);
        this.gXH.makeCurrent();
        this.gXJ = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.gXA = new com.faceunity.a.b(file.toString());
            this.gXL = new com.faceunity.a.d(i, i2, i3, this.gXA);
            this.gXM = new com.faceunity.a.a(this.gXA);
            synchronized (this.gXV) {
                this.gXW = true;
                this.gXV.notify();
            }
            this.gXI = new com.faceunity.gles.a(eGLContext, 1);
            this.gXH = new com.faceunity.gles.e(this.gXI, this.gXL.getInputSurface(), true);
            this.gXH.makeCurrent();
            this.gXJ = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void releaseEncoder() {
        try {
            this.gXL.release();
            if (this.gXH != null) {
                this.gXH.release();
                this.gXH = null;
            }
            if (this.gXJ != null) {
                this.gXJ.release(false);
                this.gXJ = null;
            }
            if (this.gXI != null) {
                this.gXI.release();
                this.gXI = null;
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
            synchronized (c.this.gXV) {
                while (!c.this.gXW) {
                    try {
                        c.this.gXV.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            c.this.gXW = false;
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(48000, 16, 2);
                int i = 49152;
                if (49152 < minBufferSize) {
                    i = ((minBufferSize / 2048) + 1) * 2048 * 2;
                }
                int[] iArr = c.gYa;
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
                    c.this.gXO = 1;
                    while (!c.this.gXZ) {
                        allocateDirect.clear();
                        int read = audioRecord.read(allocateDirect, 2048);
                        if (read > 0) {
                            allocateDirect.position(read);
                            allocateDirect.flip();
                            c.this.gXM.a(allocateDirect, read, c.this.bFi());
                            c.this.gXM.bFh();
                        }
                    }
                    c.this.gXM.a(null, 0, c.this.bFi());
                    audioRecord.stop();
                    audioRecord.release();
                    c.this.gXM.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (c.this.gXX) {
                c.this.gXY = true;
                c.this.gXX.notify();
            }
        }
    }

    protected long bFi() {
        long nanoTime = System.nanoTime();
        if (this.gXQ != 0) {
            if (this.gXR == 0) {
                this.gXR = nanoTime;
            }
            nanoTime = (nanoTime - this.gXR) + this.gXQ;
        }
        long j = nanoTime / 1000;
        if (j < this.gYb) {
            j += this.gYb - j;
        }
        if (j == this.gYb) {
            j += 100;
        }
        this.gYb = j;
        return j;
    }
}
