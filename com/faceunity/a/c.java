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
    private static final int[] hus = {1, 0, 5, 7, 6};
    private h gAg;
    private com.faceunity.a.b htT;
    private com.faceunity.gles.e htY;
    private com.faceunity.gles.a htZ;
    private com.faceunity.gles.c hua;
    private int hub;
    private com.faceunity.a.d huc;
    private com.faceunity.a.a hud;
    private volatile d hue;
    private int huf;
    private InterfaceC0150c hug;
    private int huj;
    private int huk;
    private b hul;
    private final Object hum;
    private boolean hun;
    private final Object huo;
    private boolean hup;
    private boolean huq;
    private boolean hur;
    private long hut;
    private int mHeight;
    private boolean mReady;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private Object mReadyFence = new Object();
    private long huh = 0;
    private long hui = 0;

    /* renamed from: com.faceunity.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0150c {
        void bLL();

        void bLM();
    }

    public boolean wR(int i) {
        return this.huf == i;
    }

    public c() {
        this.huf = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gAg = kVar.aOb();
        }
        this.hul = null;
        this.hum = new Object();
        this.hun = false;
        this.huo = new Object();
        this.hup = false;
        this.huq = false;
        this.hur = false;
        this.hut = 0L;
        this.huf = 2;
    }

    /* loaded from: classes2.dex */
    public static class b {
        final int fPj;
        final File gNl;
        final long huh;
        final EGLContext huv;
        final int mHeight;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.gNl = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.fPj = i3;
            if (eGLContext != null) {
                this.huv = eGLContext;
            } else {
                this.huv = EGL14.eglGetCurrentContext();
            }
            this.huh = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + "x" + this.mHeight + " @" + this.fPj + " to '" + this.gNl.toString() + "' ctxt=" + this.huv;
        }
    }

    public void a(b bVar) {
        this.mWidth = bVar.mWidth;
        this.mHeight = bVar.mHeight;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.huj = iArr[0];
        GLES20.glBindTexture(3553, this.huj);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.huk = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.huf = 5;
        this.huh = bVar.huh;
        this.hui = System.nanoTime();
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
            this.hue.sendMessage(this.hue.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.huk}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.huj}, 0);
        this.huk = 0;
        this.huj = 0;
        this.huf = 4;
        this.hue.sendMessage(this.hue.obtainMessage(1));
        this.hue.sendMessage(this.hue.obtainMessage(5));
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
                    this.hue.sendMessage(this.hue.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.huj != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.huk);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.huj, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.hue.sendMessage(this.hue.obtainMessage(3, this.huj, 0, null));
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
                c.this.hue = new d(c.this);
                c.this.mReady = true;
                c.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (c.this.mReadyFence) {
                c.this.mReady = c.this.mRunning = false;
                c.this.hue = null;
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
                        if (cVar.huq) {
                            cVar.a((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (cVar.huq) {
                            cVar.wS(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (cVar.huq) {
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
        this.hul = bVar;
        this.hub = 0;
        a(bVar.huv, bVar.mWidth, bVar.mHeight, bVar.fPj, bVar.gNl);
        this.hur = false;
        if (this.hug != null) {
            this.hug.bLL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr, long j) {
        if (this.huj != 0) {
            try {
                this.huc.oB(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.hul.mWidth, this.hul.mHeight);
            synchronized (c.class) {
                this.hua.drawFrame(this.mTextureId, fArr);
            }
            if (this.htY != null) {
                this.htY.setPresentationTime(bLJ() * 1000);
                this.htY.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.huc.oB(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.hur = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.hup) {
            synchronized (this.huo) {
                try {
                    this.huo.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.hup = false;
        if (this.hug != null) {
            this.hug.bLM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wS(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.htY != null) {
            this.htY.releaseEglSurface();
        }
        this.hua.release(false);
        if (this.htZ != null) {
            this.htZ.release();
        }
        this.htZ = new com.faceunity.gles.a(eGLContext, 1);
        if (this.htY != null) {
            this.htY.a(this.htZ);
            this.htY.makeCurrent();
        }
        this.hua = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.htT = new com.faceunity.a.b(file.toString());
            this.huc = new com.faceunity.a.d(i, i2, i3, this.htT);
            this.hud = new com.faceunity.a.a(this.htT);
            this.huq = true;
            synchronized (this.hum) {
                this.hun = true;
                this.hum.notify();
            }
        } catch (IOException e2) {
            if (this.gAg != null) {
                this.gAg.Q(12, com.baidu.tieba.i.a.g(e2));
            }
        } catch (IllegalStateException e3) {
            this.huq = false;
            if (this.gAg != null) {
                this.gAg.Q(13, com.baidu.tieba.i.a.g(e3));
                return;
            }
            return;
        }
        this.htZ = new com.faceunity.gles.a(eGLContext, 1);
        this.htY = new com.faceunity.gles.e(this.htZ, this.huc.getInputSurface(), true);
        this.htY.makeCurrent();
        this.hua = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.huc.release();
            if (this.htY != null) {
                this.htY.release();
                this.htY = null;
            }
            if (this.hua != null) {
                this.hua.release(false);
                this.hua = null;
            }
            if (this.htZ != null) {
                this.htZ.release();
                this.htZ = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.gAg != null) {
                this.gAg.Q(14, com.baidu.tieba.i.a.g(e2));
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
            synchronized (c.this.hum) {
                while (!c.this.hun) {
                    try {
                        c.this.hum.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            c.this.hun = false;
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(48000, 16, 2);
                int i = 49152;
                if (49152 < minBufferSize) {
                    i = ((minBufferSize / 2048) + 1) * 2048 * 2;
                }
                int[] iArr = c.hus;
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
                        if (c.this.gAg != null) {
                            c.this.gAg.Q(15, com.baidu.tieba.i.a.g(e2));
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
                    c.this.huf = 1;
                    while (!c.this.hur) {
                        allocateDirect.clear();
                        int read = audioRecord.read(allocateDirect, 2048);
                        if (read > 0) {
                            allocateDirect.position(read);
                            allocateDirect.flip();
                            c.this.hud.a(allocateDirect, read, c.this.bLJ());
                            c.this.hud.bLI();
                        }
                    }
                    c.this.hud.a(null, 0, c.this.bLJ());
                    audioRecord.stop();
                    audioRecord.release();
                    c.this.hud.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
                if (c.this.gAg != null) {
                    c.this.gAg.Q(16, com.baidu.tieba.i.a.g(e3));
                }
            }
            synchronized (c.this.huo) {
                c.this.hup = true;
                c.this.huo.notify();
            }
        }
    }

    protected long bLJ() {
        long nanoTime = System.nanoTime();
        if (this.huh != 0) {
            if (this.hui == 0) {
                this.hui = nanoTime;
            }
            nanoTime = (nanoTime - this.hui) + this.huh;
        }
        long j = nanoTime / 1000;
        if (j < this.hut) {
            j += this.hut - j;
        }
        if (j == this.hut) {
            j += 100;
        }
        this.hut = j;
        return j;
    }
}
