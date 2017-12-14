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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i.h;
import com.baidu.tieba.i.k;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes2.dex */
public class c {
    private static final int[] hxj = {1, 0, 5, 7, 6};
    private h gCP;
    private com.faceunity.a.b hwK;
    private com.faceunity.gles.e hwP;
    private com.faceunity.gles.a hwQ;
    private com.faceunity.gles.c hwR;
    private int hwS;
    private com.faceunity.a.d hwT;
    private com.faceunity.a.a hwU;
    private volatile d hwV;
    private int hwW;
    private InterfaceC0167c hwX;
    private int hxa;
    private int hxb;
    private b hxc;
    private final Object hxd;
    private boolean hxe;
    private final Object hxf;
    private boolean hxg;
    private boolean hxh;
    private boolean hxi;
    private long hxk;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long hwY = 0;
    private long hwZ = 0;

    /* renamed from: com.faceunity.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0167c {
        void bDU();

        void bDV();
    }

    public boolean xe(int i) {
        return this.hwW == i;
    }

    public c() {
        this.hwW = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gCP = kVar.aOk();
        }
        this.hxc = null;
        this.hxd = new Object();
        this.hxe = false;
        this.hxf = new Object();
        this.hxg = false;
        this.hxh = false;
        this.hxi = false;
        this.hxk = 0L;
        this.hwW = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final int fQc;
        final File gPT;
        final long hwY;
        final EGLContext hxm;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.gPT = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.fQc = i3;
            if (eGLContext != null) {
                this.hxm = eGLContext;
            } else {
                this.hxm = EGL14.eglGetCurrentContext();
            }
            this.hwY = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.fQc + " to '" + this.gPT.toString() + "' ctxt=" + this.hxm;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.hxa = iArr[0];
        GLES20.glBindTexture(3553, this.hxa);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.hxb = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.hwW = 5;
        this.hwY = bVar.hwY;
        this.hwZ = System.nanoTime();
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
            this.hwV.sendMessage(this.hwV.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.hxb}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.hxa}, 0);
        this.hxb = 0;
        this.hxa = 0;
        this.hwW = 4;
        this.hwV.sendMessage(this.hwV.obtainMessage(1));
        this.hwV.sendMessage(this.hwV.obtainMessage(5));
    }

    public void d(SurfaceTexture surfaceTexture) {
        synchronized (this.mReadyFence) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.hwV.sendMessage(this.hwV.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.hxa != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.hxb);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.hxa, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.hwV.sendMessage(this.hwV.obtainMessage(3, this.hxa, 0, null));
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
                c.this.hwV = new d(c.this);
                c.this.mReady = true;
                c.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (c.this.mReadyFence) {
                c.this.mReady = c.this.mRunning = false;
                c.this.hwV = null;
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
                        if (cVar.hxh) {
                            cVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (cVar.hxh) {
                            cVar.xf(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (cVar.hxh) {
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
        this.hxc = bVar;
        this.hwS = 0;
        a(bVar.hxm, bVar.mWidth, bVar.mHeight, bVar.fQc, bVar.gPT);
        this.hxi = false;
        if (this.hwX != null) {
            this.hwX.bDU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.hxa != 0) {
            try {
                this.hwT.oC(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.hxc.mWidth, this.hxc.mHeight);
            synchronized (c.class) {
                this.hwR.drawFrame(this.mTextureId, fArr);
            }
            if (this.hwP != null) {
                this.hwP.setPresentationTime(bMv() * 1000);
                this.hwP.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.hwT.oC(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.hxi = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.hxg) {
            synchronized (this.hxf) {
                try {
                    this.hxf.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.hxg = false;
        if (this.hwX != null) {
            this.hwX.bDV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xf(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.hwP != null) {
            this.hwP.releaseEglSurface();
        }
        this.hwR.release(false);
        if (this.hwQ != null) {
            this.hwQ.release();
        }
        this.hwQ = new com.faceunity.gles.a(eGLContext, 1);
        if (this.hwP != null) {
            this.hwP.a(this.hwQ);
            this.hwP.makeCurrent();
        }
        this.hwR = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.hwK = new com.faceunity.a.b(file.toString());
            this.hwT = new com.faceunity.a.d(i, i2, i3, this.hwK);
            this.hwU = new com.faceunity.a.a(this.hwK);
            this.hxh = true;
            synchronized (this.hxd) {
                this.hxe = true;
                this.hxd.notify();
            }
        } catch (IOException e2) {
            if (this.gCP != null) {
                this.gCP.Q(12, com.baidu.tieba.i.a.g(e2));
            }
        } catch (IllegalStateException e3) {
            this.hxh = false;
            if (this.gCP != null) {
                this.gCP.Q(13, com.baidu.tieba.i.a.g(e3));
                return;
            }
            return;
        }
        this.hwQ = new com.faceunity.gles.a(eGLContext, 1);
        this.hwP = new com.faceunity.gles.e(this.hwQ, this.hwT.getInputSurface(), true);
        this.hwP.makeCurrent();
        this.hwR = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.hwT.release();
            if (this.hwP != null) {
                this.hwP.release();
                this.hwP = null;
            }
            if (this.hwR != null) {
                this.hwR.release(false);
                this.hwR = null;
            }
            if (this.hwQ != null) {
                this.hwQ.release();
                this.hwQ = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.gCP != null) {
                this.gCP.Q(14, com.baidu.tieba.i.a.g(e2));
            }
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
            synchronized (c.this.hxd) {
                while (!c.this.hxe) {
                    try {
                        c.this.hxd.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            c.this.hxe = false;
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(48000, 16, 2);
                int i = 49152;
                if (49152 < minBufferSize) {
                    i = ((minBufferSize / 2048) + 1) * 2048 * 2;
                }
                int[] iArr = c.hxj;
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
                        if (c.this.gCP != null) {
                            c.this.gCP.Q(15, com.baidu.tieba.i.a.g(e2));
                        }
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
                    c.this.hwW = 1;
                    while (!c.this.hxi) {
                        allocateDirect.clear();
                        int read = audioRecord.read(allocateDirect, 2048);
                        if (read > 0) {
                            allocateDirect.position(read);
                            allocateDirect.flip();
                            c.this.hwU.a(allocateDirect, read, c.this.bMv());
                            c.this.hwU.bMu();
                        }
                    }
                    c.this.hwU.a(null, 0, c.this.bMv());
                    audioRecord.stop();
                    audioRecord.release();
                    c.this.hwU.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
                if (c.this.gCP != null) {
                    c.this.gCP.Q(16, com.baidu.tieba.i.a.g(e3));
                }
            }
            synchronized (c.this.hxf) {
                c.this.hxg = true;
                c.this.hxf.notify();
            }
        }
    }

    protected long bMv() {
        long nanoTime = System.nanoTime();
        if (this.hwY != 0) {
            if (this.hwZ == 0) {
                this.hwZ = nanoTime;
            }
            nanoTime = (nanoTime - this.hwZ) + this.hwY;
        }
        long j = nanoTime / 1000;
        if (j < this.hxk) {
            j += this.hxk - j;
        }
        if (j == this.hxk) {
            j += 100;
        }
        this.hxk = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(InterfaceC0167c interfaceC0167c) {
        this.hwX = interfaceC0167c;
    }
}
