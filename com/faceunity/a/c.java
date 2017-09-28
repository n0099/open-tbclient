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
    private static final int[] gYb = {1, 0, 5, 7, 6};
    private com.faceunity.a.b gXB;
    private com.faceunity.gles.e gXI;
    private com.faceunity.gles.a gXJ;
    private com.faceunity.gles.c gXK;
    private int gXL;
    private com.faceunity.a.d gXM;
    private com.faceunity.a.a gXN;
    private volatile d gXO;
    private int gXP;
    private InterfaceC0146c gXQ;
    private int gXT;
    private int gXU;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long gXR = 0;
    private long gXS = 0;
    private b gXV = null;
    private final Object gXW = new Object();
    private boolean gXX = false;
    private final Object gXY = new Object();
    private boolean gXZ = false;
    private boolean gYa = false;
    private long gYc = 0;

    /* renamed from: com.faceunity.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0146c {
        void bFl();

        void bFm();
    }

    public boolean vT(int i) {
        return this.gXP == i;
    }

    public c() {
        this.gXP = 4;
        this.gXP = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final long gXR;
        final int gYe;
        final EGLContext gYf;
        final File gxB;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.gxB = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.gYe = i3;
            if (eGLContext != null) {
                this.gYf = eGLContext;
            } else {
                this.gYf = EGL14.eglGetCurrentContext();
            }
            this.gXR = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.gYe + " to '" + this.gxB.toString() + "' ctxt=" + this.gYf;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.gXT = iArr[0];
        GLES20.glBindTexture(3553, this.gXT);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.gXU = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.gXP = 5;
        this.gXR = bVar.gXR;
        this.gXS = System.nanoTime();
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
            this.gXO.sendMessage(this.gXO.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.gXU}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.gXT}, 0);
        this.gXU = 0;
        this.gXT = 0;
        this.gXP = 4;
        this.gXO.sendMessage(this.gXO.obtainMessage(1));
        this.gXO.sendMessage(this.gXO.obtainMessage(5));
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
                    this.gXO.sendMessage(this.gXO.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.gXT != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.gXU);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.gXT, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.gXO.sendMessage(this.gXO.obtainMessage(3, this.gXT, 0, null));
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
                c.this.gXO = new d(c.this);
                c.this.mReady = true;
                c.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (c.this.mReadyFence) {
                c.this.mReady = c.this.mRunning = false;
                c.this.gXO = null;
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
        this.gXV = bVar;
        this.gXL = 0;
        a(bVar.gYf, bVar.mWidth, bVar.mHeight, bVar.gYe, bVar.gxB);
        this.gYa = false;
        if (this.gXQ != null) {
            this.gXQ.bFl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.gXT != 0) {
            try {
                this.gXM.nO(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.gXV.mWidth, this.gXV.mHeight);
            synchronized (c.class) {
                this.gXK.drawFrame(this.mTextureId, fArr);
            }
            this.gXI.setPresentationTime(bFj() * 1000);
            this.gXI.swapBuffers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.gXM.nO(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.gYa = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.gXZ) {
            synchronized (this.gXY) {
                try {
                    this.gXY.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.gXZ = false;
        if (this.gXQ != null) {
            this.gXQ.bFm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vU(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        this.gXI.releaseEglSurface();
        this.gXK.release(false);
        this.gXJ.release();
        this.gXJ = new com.faceunity.gles.a(eGLContext, 1);
        this.gXI.a(this.gXJ);
        this.gXI.makeCurrent();
        this.gXK = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.gXB = new com.faceunity.a.b(file.toString());
            this.gXM = new com.faceunity.a.d(i, i2, i3, this.gXB);
            this.gXN = new com.faceunity.a.a(this.gXB);
            synchronized (this.gXW) {
                this.gXX = true;
                this.gXW.notify();
            }
            this.gXJ = new com.faceunity.gles.a(eGLContext, 1);
            this.gXI = new com.faceunity.gles.e(this.gXJ, this.gXM.getInputSurface(), true);
            this.gXI.makeCurrent();
            this.gXK = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void releaseEncoder() {
        try {
            this.gXM.release();
            if (this.gXI != null) {
                this.gXI.release();
                this.gXI = null;
            }
            if (this.gXK != null) {
                this.gXK.release(false);
                this.gXK = null;
            }
            if (this.gXJ != null) {
                this.gXJ.release();
                this.gXJ = null;
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
            synchronized (c.this.gXW) {
                while (!c.this.gXX) {
                    try {
                        c.this.gXW.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            c.this.gXX = false;
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(48000, 16, 2);
                int i = 49152;
                if (49152 < minBufferSize) {
                    i = ((minBufferSize / 2048) + 1) * 2048 * 2;
                }
                int[] iArr = c.gYb;
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
                    c.this.gXP = 1;
                    while (!c.this.gYa) {
                        allocateDirect.clear();
                        int read = audioRecord.read(allocateDirect, 2048);
                        if (read > 0) {
                            allocateDirect.position(read);
                            allocateDirect.flip();
                            c.this.gXN.a(allocateDirect, read, c.this.bFj());
                            c.this.gXN.bFi();
                        }
                    }
                    c.this.gXN.a(null, 0, c.this.bFj());
                    audioRecord.stop();
                    audioRecord.release();
                    c.this.gXN.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (c.this.gXY) {
                c.this.gXZ = true;
                c.this.gXY.notify();
            }
        }
    }

    protected long bFj() {
        long nanoTime = System.nanoTime();
        if (this.gXR != 0) {
            if (this.gXS == 0) {
                this.gXS = nanoTime;
            }
            nanoTime = (nanoTime - this.gXS) + this.gXR;
        }
        long j = nanoTime / 1000;
        if (j < this.gYc) {
            j += this.gYc - j;
        }
        if (j == this.gYc) {
            j += 100;
        }
        this.gYc = j;
        return j;
    }
}
