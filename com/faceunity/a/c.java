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
    private static final int[] hjf = {1, 0, 5, 7, 6};
    private com.faceunity.a.b hiE;
    private com.faceunity.gles.e hiL;
    private com.faceunity.gles.a hiM;
    private com.faceunity.gles.c hiN;
    private int hiO;
    private com.faceunity.a.d hiP;
    private com.faceunity.a.a hiQ;
    private volatile d hiR;
    private int hiS;
    private InterfaceC0151c hiT;
    private int hiW;
    private int hiX;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long hiU = 0;
    private long hiV = 0;
    private b hiY = null;
    private final Object hiZ = new Object();
    private boolean hja = false;
    private final Object hjb = new Object();
    private boolean hjc = false;
    private boolean hjd = false;
    private boolean hje = false;
    private long hjg = 0;

    /* renamed from: com.faceunity.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0151c {
        void bIP();

        void bIQ();
    }

    public boolean wt(int i) {
        return this.hiS == i;
    }

    public c() {
        this.hiS = 4;
        this.hiS = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final File gIa;
        final long hiU;
        final int hji;
        final EGLContext hjj;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.gIa = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.hji = i3;
            if (eGLContext != null) {
                this.hjj = eGLContext;
            } else {
                this.hjj = EGL14.eglGetCurrentContext();
            }
            this.hiU = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.hji + " to '" + this.gIa.toString() + "' ctxt=" + this.hjj;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.hiW = iArr[0];
        GLES20.glBindTexture(3553, this.hiW);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.hiX = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.hiS = 5;
        this.hiU = bVar.hiU;
        this.hiV = System.nanoTime();
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
            this.hiR.sendMessage(this.hiR.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.hiX}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.hiW}, 0);
        this.hiX = 0;
        this.hiW = 0;
        this.hiS = 4;
        this.hiR.sendMessage(this.hiR.obtainMessage(1));
        this.hiR.sendMessage(this.hiR.obtainMessage(5));
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
                    this.hiR.sendMessage(this.hiR.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.hiW != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.hiX);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.hiW, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.hiR.sendMessage(this.hiR.obtainMessage(3, this.hiW, 0, null));
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
                c.this.hiR = new d(c.this);
                c.this.mReady = true;
                c.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (c.this.mReadyFence) {
                c.this.mReady = c.this.mRunning = false;
                c.this.hiR = null;
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
                        if (cVar.hjd) {
                            cVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (cVar.hjd) {
                            cVar.wu(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (cVar.hjd) {
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
        this.hiY = bVar;
        this.hiO = 0;
        a(bVar.hjj, bVar.mWidth, bVar.mHeight, bVar.hji, bVar.gIa);
        this.hje = false;
        if (this.hiT != null) {
            this.hiT.bIP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.hiW != 0) {
            try {
                this.hiP.nX(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.hiY.mWidth, this.hiY.mHeight);
            synchronized (c.class) {
                this.hiN.drawFrame(this.mTextureId, fArr);
            }
            if (this.hiL != null) {
                this.hiL.setPresentationTime(bIN() * 1000);
                this.hiL.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.hiP.nX(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.hje = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.hjc) {
            synchronized (this.hjb) {
                try {
                    this.hjb.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.hjc = false;
        if (this.hiT != null) {
            this.hiT.bIQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wu(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.hiL != null) {
            this.hiL.releaseEglSurface();
        }
        this.hiN.release(false);
        if (this.hiM != null) {
            this.hiM.release();
        }
        this.hiM = new com.faceunity.gles.a(eGLContext, 1);
        if (this.hiL != null) {
            this.hiL.a(this.hiM);
            this.hiL.makeCurrent();
        }
        this.hiN = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.hiE = new com.faceunity.a.b(file.toString());
            this.hiP = new com.faceunity.a.d(i, i2, i3, this.hiE);
            this.hiQ = new com.faceunity.a.a(this.hiE);
            this.hjd = true;
            synchronized (this.hiZ) {
                this.hja = true;
                this.hiZ.notify();
            }
        } catch (IOException e2) {
        } catch (IllegalStateException e3) {
            this.hjd = false;
            return;
        }
        this.hiM = new com.faceunity.gles.a(eGLContext, 1);
        this.hiL = new com.faceunity.gles.e(this.hiM, this.hiP.getInputSurface(), true);
        this.hiL.makeCurrent();
        this.hiN = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.hiP.release();
            if (this.hiL != null) {
                this.hiL.release();
                this.hiL = null;
            }
            if (this.hiN != null) {
                this.hiN.release(false);
                this.hiN = null;
            }
            if (this.hiM != null) {
                this.hiM.release();
                this.hiM = null;
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
            synchronized (c.this.hiZ) {
                while (!c.this.hja) {
                    try {
                        c.this.hiZ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            c.this.hja = false;
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(48000, 16, 2);
                int i = 49152;
                if (49152 < minBufferSize) {
                    i = ((minBufferSize / 2048) + 1) * 2048 * 2;
                }
                int[] iArr = c.hjf;
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
                    c.this.hiS = 1;
                    while (!c.this.hje) {
                        allocateDirect.clear();
                        int read = audioRecord.read(allocateDirect, 2048);
                        if (read > 0) {
                            allocateDirect.position(read);
                            allocateDirect.flip();
                            c.this.hiQ.a(allocateDirect, read, c.this.bIN());
                            c.this.hiQ.bIM();
                        }
                    }
                    c.this.hiQ.a(null, 0, c.this.bIN());
                    audioRecord.stop();
                    audioRecord.release();
                    c.this.hiQ.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (c.this.hjb) {
                c.this.hjc = true;
                c.this.hjb.notify();
            }
        }
    }

    protected long bIN() {
        long nanoTime = System.nanoTime();
        if (this.hiU != 0) {
            if (this.hiV == 0) {
                this.hiV = nanoTime;
            }
            nanoTime = (nanoTime - this.hiV) + this.hiU;
        }
        long j = nanoTime / 1000;
        if (j < this.hjg) {
            j += this.hjg - j;
        }
        if (j == this.hjg) {
            j += 100;
        }
        this.hjg = j;
        return j;
    }
}
