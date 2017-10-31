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
    private static final int[] hhU = {1, 0, 5, 7, 6};
    private com.faceunity.gles.e hhA;
    private com.faceunity.gles.a hhB;
    private com.faceunity.gles.c hhC;
    private int hhD;
    private com.faceunity.a.d hhE;
    private com.faceunity.a.a hhF;
    private volatile d hhG;
    private int hhH;
    private InterfaceC0148c hhI;
    private int hhL;
    private int hhM;
    private com.faceunity.a.b hht;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long hhJ = 0;
    private long hhK = 0;
    private b hhN = null;
    private final Object hhO = new Object();
    private boolean hhP = false;
    private final Object hhQ = new Object();
    private boolean hhR = false;
    private boolean hhS = false;
    private boolean hhT = false;
    private long hhV = 0;

    /* renamed from: com.faceunity.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0148c {
        void bIC();

        void bID();
    }

    public boolean wp(int i) {
        return this.hhH == i;
    }

    public c() {
        this.hhH = 4;
        this.hhH = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final File gGS;
        final long hhJ;
        final int hhX;
        final EGLContext hhY;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.gGS = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.hhX = i3;
            if (eGLContext != null) {
                this.hhY = eGLContext;
            } else {
                this.hhY = EGL14.eglGetCurrentContext();
            }
            this.hhJ = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.hhX + " to '" + this.gGS.toString() + "' ctxt=" + this.hhY;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.hhL = iArr[0];
        GLES20.glBindTexture(3553, this.hhL);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.hhM = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.hhH = 5;
        this.hhJ = bVar.hhJ;
        this.hhK = System.nanoTime();
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
            this.hhG.sendMessage(this.hhG.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.hhM}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.hhL}, 0);
        this.hhM = 0;
        this.hhL = 0;
        this.hhH = 4;
        this.hhG.sendMessage(this.hhG.obtainMessage(1));
        this.hhG.sendMessage(this.hhG.obtainMessage(5));
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
                    this.hhG.sendMessage(this.hhG.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.hhL != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.hhM);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.hhL, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.hhG.sendMessage(this.hhG.obtainMessage(3, this.hhL, 0, null));
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
                c.this.hhG = new d(c.this);
                c.this.mReady = true;
                c.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (c.this.mReadyFence) {
                c.this.mReady = c.this.mRunning = false;
                c.this.hhG = null;
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
                        if (cVar.hhS) {
                            cVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (cVar.hhS) {
                            cVar.wq(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (cVar.hhS) {
                            cVar.handleUpdateSharedContext((EGLContext) message.obj);
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
        this.hhN = bVar;
        this.hhD = 0;
        a(bVar.hhY, bVar.mWidth, bVar.mHeight, bVar.hhX, bVar.gGS);
        this.hhT = false;
        if (this.hhI != null) {
            this.hhI.bIC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.hhL != 0) {
            try {
                this.hhE.nP(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.hhN.mWidth, this.hhN.mHeight);
            synchronized (c.class) {
                this.hhC.drawFrame(this.mTextureId, fArr);
            }
            if (this.hhA != null) {
                this.hhA.setPresentationTime(bIA() * 1000);
                this.hhA.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.hhE.nP(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.hhT = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.hhR) {
            synchronized (this.hhQ) {
                try {
                    this.hhQ.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.hhR = false;
        if (this.hhI != null) {
            this.hhI.bID();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wq(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.hhA != null) {
            this.hhA.releaseEglSurface();
        }
        this.hhC.release(false);
        if (this.hhB != null) {
            this.hhB.release();
        }
        this.hhB = new com.faceunity.gles.a(eGLContext, 1);
        if (this.hhA != null) {
            this.hhA.a(this.hhB);
            this.hhA.makeCurrent();
        }
        this.hhC = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.hht = new com.faceunity.a.b(file.toString());
            this.hhE = new com.faceunity.a.d(i, i2, i3, this.hht);
            this.hhF = new com.faceunity.a.a(this.hht);
            this.hhS = true;
            synchronized (this.hhO) {
                this.hhP = true;
                this.hhO.notify();
            }
        } catch (IOException e2) {
        } catch (IllegalStateException e3) {
            this.hhS = false;
            return;
        }
        this.hhB = new com.faceunity.gles.a(eGLContext, 1);
        this.hhA = new com.faceunity.gles.e(this.hhB, this.hhE.getInputSurface(), true);
        this.hhA.makeCurrent();
        this.hhC = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.hhE.release();
            if (this.hhA != null) {
                this.hhA.release();
                this.hhA = null;
            }
            if (this.hhC != null) {
                this.hhC.release(false);
                this.hhC = null;
            }
            if (this.hhB != null) {
                this.hhB.release();
                this.hhB = null;
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
            synchronized (c.this.hhO) {
                while (!c.this.hhP) {
                    try {
                        c.this.hhO.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            c.this.hhP = false;
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(48000, 16, 2);
                int i = 49152;
                if (49152 < minBufferSize) {
                    i = ((minBufferSize / 2048) + 1) * 2048 * 2;
                }
                int[] iArr = c.hhU;
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
                    c.this.hhH = 1;
                    while (!c.this.hhT) {
                        allocateDirect.clear();
                        int read = audioRecord.read(allocateDirect, 2048);
                        if (read > 0) {
                            allocateDirect.position(read);
                            allocateDirect.flip();
                            c.this.hhF.a(allocateDirect, read, c.this.bIA());
                            c.this.hhF.bIz();
                        }
                    }
                    c.this.hhF.a(null, 0, c.this.bIA());
                    audioRecord.stop();
                    audioRecord.release();
                    c.this.hhF.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (c.this.hhQ) {
                c.this.hhR = true;
                c.this.hhQ.notify();
            }
        }
    }

    protected long bIA() {
        long nanoTime = System.nanoTime();
        if (this.hhJ != 0) {
            if (this.hhK == 0) {
                this.hhK = nanoTime;
            }
            nanoTime = (nanoTime - this.hhK) + this.hhJ;
        }
        long j = nanoTime / 1000;
        if (j < this.hhV) {
            j += this.hhV - j;
        }
        if (j == this.hhV) {
            j += 100;
        }
        this.hhV = j;
        return j;
    }
}
