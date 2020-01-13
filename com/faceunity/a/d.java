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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tieba.j.h;
import com.baidu.tieba.j.l;
import com.faceunity.gles.Texture2dProgram;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes8.dex */
public class d {
    private static final int[] AUDIO_SOURCES = {1, 0, 5, 7, 6};
    private h kgF;
    private com.faceunity.a.c lWL;
    private com.faceunity.gles.e lWS;
    private com.faceunity.gles.a lWT;
    private com.faceunity.gles.c lWU;
    private com.faceunity.a.e lWV;
    private com.faceunity.a.a lWW;
    private volatile HandlerC0661d lWX;
    private c lWY;
    private int lWZ;
    private b lXa;
    private int mFrameNum;
    private int mHeight;
    private boolean mReady;
    private int mRecordingStatus;
    private boolean mRequestStop;
    private boolean mRunning;
    private int mTextureId;
    private int mWidth;
    private final Object prepareEncoderFence;
    private boolean prepareEncoderReady;
    private long prevOutputPTSUs;
    private final Object stopEncoderFence;
    private boolean stopEncoderSuccess;
    private int texture;
    private boolean videoEncoderReadyFlag;
    private Object mReadyFence = new Object();
    private long firstTimeStampBase = 0;
    private long firstNanoTime = 0;

    /* loaded from: classes8.dex */
    public interface c {
        void onStartSuccess();

        void onStopSuccess();
    }

    public boolean checkRecordingStatus(int i) {
        return this.mRecordingStatus == i;
    }

    public d() {
        this.mRecordingStatus = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.kgF = lVar.cfr();
        }
        this.lXa = null;
        this.prepareEncoderFence = new Object();
        this.prepareEncoderReady = false;
        this.stopEncoderFence = new Object();
        this.stopEncoderSuccess = false;
        this.videoEncoderReadyFlag = false;
        this.mRequestStop = false;
        this.prevOutputPTSUs = 0L;
        this.mRecordingStatus = 2;
    }

    /* loaded from: classes8.dex */
    public static class b {
        final long firstTimeStampBase;
        final int mBitRate;
        final EGLContext mEglContext;
        final int mHeight;
        final File mOutputFile;
        final int mWidth;

        public b(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.mOutputFile = file;
            this.mWidth = i;
            this.mHeight = i2;
            this.mBitRate = i3;
            if (eGLContext != null) {
                this.mEglContext = eGLContext;
            } else {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            this.firstTimeStampBase = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.mWidth + Config.EVENT_HEAT_X + this.mHeight + " @" + this.mBitRate + " to '" + this.mOutputFile.toString() + "' ctxt=" + this.mEglContext;
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
        this.lWZ = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.mRecordingStatus = 5;
        this.firstTimeStampBase = bVar.firstTimeStampBase;
        this.firstNanoTime = System.nanoTime();
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
            this.lWX.sendMessage(this.lWX.obtainMessage(0, bVar));
        }
    }

    public void stopRecording() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.lWZ}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.texture}, 0);
        this.lWZ = 0;
        this.texture = 0;
        if (this.lWL == null || !this.lWL.isStarted()) {
            this.mRequestStop = true;
            if (this.lWV != null) {
                this.lWV.requestStop();
            }
        }
        this.mRecordingStatus = 4;
        this.lWX.sendMessage(this.lWX.obtainMessage(1));
        this.lWX.sendMessage(this.lWX.obtainMessage(5));
    }

    public void frameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.mReadyFence) {
            if (this.mReady) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.lWX.sendMessage(this.lWX.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public void a(com.faceunity.gles.c cVar, int i, float[] fArr) {
        if (this.texture != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.lWZ);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texture, 0);
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            if (cVar != null) {
                cVar.drawFrame(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.mReadyFence) {
                if (this.mReady) {
                    this.lWX.sendMessage(this.lWX.obtainMessage(3, this.texture, 0, null));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    private class e extends Thread {
        public e(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (d.this.mReadyFence) {
                d.this.lWX = new HandlerC0661d(d.this);
                d.this.mReady = true;
                d.this.mReadyFence.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.mReadyFence) {
                d.this.mReady = d.this.mRunning = false;
                d.this.lWX = null;
            }
        }
    }

    /* renamed from: com.faceunity.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class HandlerC0661d extends Handler {
        private WeakReference<d> mWeakEncoder;

        public HandlerC0661d(d dVar) {
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
                        if (dVar.videoEncoderReadyFlag) {
                            dVar.handleFrameAvailable((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                            return;
                        }
                        return;
                    case 3:
                        if (dVar.videoEncoderReadyFlag) {
                            dVar.handleSetTexture(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (dVar.videoEncoderReadyFlag) {
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
        this.lXa = bVar;
        this.mFrameNum = 0;
        a(bVar.mEglContext, bVar.mWidth, bVar.mHeight, bVar.mBitRate, bVar.mOutputFile);
        this.mRequestStop = false;
        if (this.lWY != null) {
            this.lWY.onStartSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFrameAvailable(float[] fArr, long j) {
        if (this.texture != 0) {
            try {
                this.lWV.drainEncoder(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GLES20.glViewport(0, 0, this.lXa.mWidth, this.lXa.mHeight);
            synchronized (d.class) {
                this.lWU.drawFrame(this.mTextureId, fArr);
            }
            if (this.lWS != null) {
                this.lWS.setPresentationTime(getPTSUs() * 1000);
                this.lWS.swapBuffers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.lWV.drainEncoder(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mRequestStop = true;
        releaseEncoder();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.stopEncoderSuccess) {
            synchronized (this.stopEncoderFence) {
                try {
                    this.stopEncoderFence.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.stopEncoderSuccess = false;
        if (this.lWY != null) {
            this.lWY.onStopSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSetTexture(int i) {
        this.mTextureId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        if (this.lWS != null) {
            this.lWS.releaseEglSurface();
        }
        this.lWU.release(false);
        if (this.lWT != null) {
            this.lWT.release();
        }
        this.lWT = new com.faceunity.gles.a(eGLContext, 1);
        if (this.lWS != null) {
            this.lWS.a(this.lWT);
            this.lWS.makeCurrent();
        }
        this.lWU = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void a(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            this.lWL = new com.faceunity.a.c(file.toString());
            this.lWV = new com.faceunity.a.e(i, i2, i3, this.lWL);
            this.lWW = new com.faceunity.a.a(this.lWL);
            this.videoEncoderReadyFlag = true;
            synchronized (this.prepareEncoderFence) {
                this.prepareEncoderReady = true;
                this.prepareEncoderFence.notify();
            }
        } catch (IOException e2) {
            if (this.kgF != null) {
                this.kgF.aP(12, com.baidu.tieba.j.a.r(e2));
            }
        } catch (IllegalStateException e3) {
            this.videoEncoderReadyFlag = false;
            if (this.kgF != null) {
                this.kgF.aP(13, com.baidu.tieba.j.a.r(e3));
                return;
            }
            return;
        }
        this.lWT = new com.faceunity.gles.a(eGLContext, 1);
        this.lWS = new com.faceunity.gles.e(this.lWT, this.lWV.getInputSurface(), true);
        this.lWS.makeCurrent();
        this.lWU = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    private void releaseEncoder() {
        try {
            this.lWV.release();
            if (this.lWS != null) {
                this.lWS.release();
                this.lWS = null;
            }
            if (this.lWU != null) {
                this.lWU.release(false);
                this.lWU = null;
            }
            if (this.lWT != null) {
                this.lWT.release();
                this.lWT = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.kgF != null) {
                this.kgF.aP(14, com.baidu.tieba.j.a.r(e2));
            }
        }
    }

    /* loaded from: classes8.dex */
    private class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            synchronized (d.this.prepareEncoderFence) {
                while (!d.this.prepareEncoderReady) {
                    try {
                        d.this.prepareEncoderFence.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            d.this.prepareEncoderReady = false;
            try {
                com.faceunity.a.b bVar = new com.faceunity.a.b();
                if (bVar.drp() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(com.faceunity.a.b.SAMPLES_PER_FRAME);
                    bVar.AL();
                    d.this.mRecordingStatus = 1;
                    while (!d.this.mRequestStop) {
                        try {
                            allocateDirect.clear();
                            int c = bVar.c(allocateDirect, com.faceunity.a.b.SAMPLES_PER_FRAME);
                            if (c > 0) {
                                allocateDirect.position(c);
                                allocateDirect.flip();
                                d.this.lWW.f(allocateDirect, c, d.this.getPTSUs());
                                d.this.lWW.dro();
                            }
                        } finally {
                            bVar.stop();
                        }
                    }
                    d.this.lWW.f(null, 0, d.this.getPTSUs());
                    bVar.release();
                    d.this.lWW.release();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e2) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e2);
            }
            synchronized (d.this.stopEncoderFence) {
                d.this.stopEncoderSuccess = true;
                d.this.stopEncoderFence.notify();
            }
        }
    }

    protected long getPTSUs() {
        long nanoTime = System.nanoTime();
        if (this.firstTimeStampBase != 0) {
            if (this.firstNanoTime == 0) {
                this.firstNanoTime = nanoTime;
            }
            nanoTime = (nanoTime - this.firstNanoTime) + this.firstTimeStampBase;
        }
        long j = nanoTime / 1000;
        if (j < this.prevOutputPTSUs) {
            j += this.prevOutputPTSUs - j;
        }
        if (j == this.prevOutputPTSUs) {
            j += 100;
        }
        this.prevOutputPTSUs = j;
        return j;
    }

    public void setOnEncoderStatusUpdateListener(c cVar) {
        this.lWY = cVar;
    }
}
