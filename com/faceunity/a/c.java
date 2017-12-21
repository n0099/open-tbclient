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
    private static final int[] hxo = {1, 0, 5, 7, 6};
    private h gCU;
    private com.faceunity.a.b hwP;
    private com.faceunity.gles.e hwU;
    private com.faceunity.gles.a hwV;
    private com.faceunity.gles.c hwW;
    private int hwX;
    private com.faceunity.a.d hwY;
    private com.faceunity.a.a hwZ;
    private volatile d hxa;
    private int hxb;
    private InterfaceC0166c hxc;
    private int hxf;
    private int hxg;
    private b hxh;
    private final Object hxi;
    private boolean hxj;
    private final Object hxk;
    private boolean hxl;
    private boolean hxm;
    private boolean hxn;
    private long hxp;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long hxd = 0;
    private long hxe = 0;

    /* renamed from: com.faceunity.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0166c {
        void bDU();

        void bDV();
    }

    public boolean xe(int i) {
        return this.hxb == i;
    }

    public c() {
        this.hxb = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gCU = kVar.aOk();
        }
        this.hxh = null;
        this.hxi = new Object();
        this.hxj = false;
        this.hxk = new Object();
        this.hxl = false;
        this.hxm = false;
        this.hxn = false;
        this.hxp = 0L;
        this.hxb = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final int fQh;
        final File gPY;
        final long hxd;
        final EGLContext hxr;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.gPY = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.fQh = i3;
            if (eGLContext != null) {
                this.hxr = eGLContext;
            } else {
                this.hxr = EGL14.eglGetCurrentContext();
            }
            this.hxd = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.fQh + " to '" + this.gPY.toString() + "' ctxt=" + this.hxr;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.hxf = iArr[0];
        GLES20.glBindTexture(3553, this.hxf);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.hxg = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.hxb = 5;
        this.hxd = bVar.hxd;
        this.hxe = System.nanoTime();
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
            this.hxa.sendMessage(this.hxa.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.hxg}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.hxf}, 0);
        this.hxg = 0;
        this.hxf = 0;
        this.hxb = 4;
        this.hxa.sendMessage(this.hxa.obtainMessage(1));
        this.hxa.sendMessage(this.hxa.obtainMessage(5));
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
                    this.hxa.sendMessage(this.hxa.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.hxf != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.hxg);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.hxf, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.hxa.sendMessage(this.hxa.obtainMessage(3, this.hxf, 0, null));
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
                c.this.hxa = new d(c.this);
                c.this.mReady = true;
                c.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (c.this.mReadyFence) {
                c.this.mReady = c.this.mRunning = false;
                c.this.hxa = null;
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
                        if (cVar.hxm) {
                            cVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (cVar.hxm) {
                            cVar.xf(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (cVar.hxm) {
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
        this.hxh = bVar;
        this.hwX = 0;
        a(bVar.hxr, bVar.mWidth, bVar.mHeight, bVar.fQh, bVar.gPY);
        this.hxn = false;
        if (this.hxc != null) {
            this.hxc.bDU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.hxf != 0) {
            try {
                this.hwY.oC(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.hxh.mWidth, this.hxh.mHeight);
            synchronized (c.class) {
                this.hwW.drawFrame(this.mTextureId, fArr);
            }
            if (this.hwU != null) {
                this.hwU.setPresentationTime(bMv() * 1000);
                this.hwU.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.hwY.oC(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.hxn = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.hxl) {
            synchronized (this.hxk) {
                try {
                    this.hxk.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.hxl = false;
        if (this.hxc != null) {
            this.hxc.bDV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xf(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.hwU != null) {
            this.hwU.releaseEglSurface();
        }
        this.hwW.release(false);
        if (this.hwV != null) {
            this.hwV.release();
        }
        this.hwV = new com.faceunity.gles.a(eGLContext, 1);
        if (this.hwU != null) {
            this.hwU.a(this.hwV);
            this.hwU.makeCurrent();
        }
        this.hwW = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.hwP = new com.faceunity.a.b(file.toString());
            this.hwY = new com.faceunity.a.d(i, i2, i3, this.hwP);
            this.hwZ = new com.faceunity.a.a(this.hwP);
            this.hxm = true;
            synchronized (this.hxi) {
                this.hxj = true;
                this.hxi.notify();
            }
        } catch (IOException e2) {
            if (this.gCU != null) {
                this.gCU.Q(12, com.baidu.tieba.i.a.g(e2));
            }
        } catch (IllegalStateException e3) {
            this.hxm = false;
            if (this.gCU != null) {
                this.gCU.Q(13, com.baidu.tieba.i.a.g(e3));
                return;
            }
            return;
        }
        this.hwV = new com.faceunity.gles.a(eGLContext, 1);
        this.hwU = new com.faceunity.gles.e(this.hwV, this.hwY.getInputSurface(), true);
        this.hwU.makeCurrent();
        this.hwW = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.hwY.release();
            if (this.hwU != null) {
                this.hwU.release();
                this.hwU = null;
            }
            if (this.hwW != null) {
                this.hwW.release(false);
                this.hwW = null;
            }
            if (this.hwV != null) {
                this.hwV.release();
                this.hwV = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.gCU != null) {
                this.gCU.Q(14, com.baidu.tieba.i.a.g(e2));
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
            synchronized (c.this.hxi) {
                while (!c.this.hxj) {
                    try {
                        c.this.hxi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            c.this.hxj = false;
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(48000, 16, 2);
                int i = 49152;
                if (49152 < minBufferSize) {
                    i = ((minBufferSize / 2048) + 1) * 2048 * 2;
                }
                int[] iArr = c.hxo;
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
                        if (c.this.gCU != null) {
                            c.this.gCU.Q(15, com.baidu.tieba.i.a.g(e2));
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
                    c.this.hxb = 1;
                    while (!c.this.hxn) {
                        allocateDirect.clear();
                        int read = audioRecord.read(allocateDirect, 2048);
                        if (read > 0) {
                            allocateDirect.position(read);
                            allocateDirect.flip();
                            c.this.hwZ.a(allocateDirect, read, c.this.bMv());
                            c.this.hwZ.bMu();
                        }
                    }
                    c.this.hwZ.a(null, 0, c.this.bMv());
                    audioRecord.stop();
                    audioRecord.release();
                    c.this.hwZ.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
                if (c.this.gCU != null) {
                    c.this.gCU.Q(16, com.baidu.tieba.i.a.g(e3));
                }
            }
            synchronized (c.this.hxk) {
                c.this.hxl = true;
                c.this.hxk.notify();
            }
        }
    }

    protected long bMv() {
        long nanoTime = System.nanoTime();
        if (this.hxd != 0) {
            if (this.hxe == 0) {
                this.hxe = nanoTime;
            }
            nanoTime = (nanoTime - this.hxe) + this.hxd;
        }
        long j = nanoTime / 1000;
        if (j < this.hxp) {
            j += this.hxp - j;
        }
        if (j == this.hxp) {
            j += 100;
        }
        this.hxp = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(InterfaceC0166c interfaceC0166c) {
        this.hxc = interfaceC0166c;
    }
}
