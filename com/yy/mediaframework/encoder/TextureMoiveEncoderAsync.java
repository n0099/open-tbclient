package com.yy.mediaframework.encoder;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.yy.mediaframework.GlManager;
import com.yy.mediaframework.filters.VideoLiveFilterContext;
import com.yy.mediaframework.utils.YMFLog;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class TextureMoiveEncoderAsync extends AbstractTextureMoiveEncoder implements Runnable {
    private static final int MSG_FRAME_AVAILABLE = 2;
    private static final int MSG_STOP_RECORDING = 1;
    private static final boolean VERBOSE = false;
    private Thread mEncodeThread;
    private volatile EncoderHandler mHandler;
    private boolean mReady;
    private Object mReadyFence;
    private boolean mRunning;

    public TextureMoiveEncoderAsync(VideoLiveFilterContext videoLiveFilterContext, GlManager glManager, HardEncodeListner hardEncodeListner) {
        super(videoLiveFilterContext, glManager, hardEncodeListner);
        this.mReadyFence = new Object();
        this.mEncodeThread = null;
        synchronized (this.mReadyFence) {
            if (this.mRunning) {
                YMFLog.warn(this, "[Encoder ]", "Encoder thread already running");
                return;
            }
            this.mRunning = true;
            this.mEncodeThread = new Thread(this, "YY_yyvideolib_TextureMovieEncoder_Thread");
            this.mEncodeThread.start();
            while (!this.mReady) {
                try {
                    this.mReadyFence.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    @Override // com.yy.mediaframework.encoder.AbstractTextureMoiveEncoder
    public void onEncodedFrameFinished(long j) {
        synchronized (this.mReadyFence) {
            if (this.mReady) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2, Long.valueOf(j)));
            }
        }
    }

    @Override // com.yy.mediaframework.encoder.AbstractTextureMoiveEncoder
    public void stopEncoder() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
    }

    @Override // com.yy.mediaframework.encoder.AbstractTextureMoiveEncoder
    public void releaseEncoder() {
        if (this.mInputWindowSurface != null) {
            this.mInputWindowSurface.release();
            this.mInputWindowSurface = null;
        }
        if (this.mFullScreen != null) {
            this.mFullScreen.release(true);
            this.mFullScreen = null;
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        if (this.mEncodeThread != null) {
            try {
                this.mEncodeThread.join();
            } catch (InterruptedException e) {
                YMFLog.error(this, "[Encoder ]", "releaseEncoder exception:" + e.toString());
            }
            this.mEncodeThread = null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        YMFLog.info(this, "[Encoder ]", "run before prepare");
        Looper.prepare();
        synchronized (this.mReadyFence) {
            this.mHandler = new EncoderHandler(this);
            this.mReady = true;
            this.mReadyFence.notify();
            YMFLog.info(this, "[Encoder ]", "run notify ready");
        }
        Looper.loop();
        YMFLog.info(this, "[Encoder ]", "Encoder thread exiting");
        synchronized (this.mReadyFence) {
            this.mRunning = false;
            this.mReady = false;
            this.mHandler = null;
        }
    }

    /* loaded from: classes4.dex */
    private static class EncoderHandler extends Handler {
        private WeakReference<TextureMoiveEncoderAsync> mWeakEncoder;

        public EncoderHandler(TextureMoiveEncoderAsync textureMoiveEncoderAsync) {
            this.mWeakEncoder = new WeakReference<>(textureMoiveEncoderAsync);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            TextureMoiveEncoderAsync textureMoiveEncoderAsync = this.mWeakEncoder.get();
            if (textureMoiveEncoderAsync == null) {
                YMFLog.warn(this, "[Encoder ]", "handleMessage: encoder is null");
                return;
            }
            switch (i) {
                case 1:
                    textureMoiveEncoderAsync.handleStopRecording();
                    if (Looper.myLooper() != null) {
                        Looper.myLooper().quit();
                        return;
                    }
                    return;
                case 2:
                    textureMoiveEncoderAsync.handleFrameAvailable(message.arg1);
                    return;
                default:
                    throw new RuntimeException("Unhandled msg what=" + i);
            }
        }
    }

    public void handleFrameAvailable(int i) {
        this.mVideoEncoderImpl.drainEncoder(i, false);
    }

    public void handleStopRecording() {
        YMFLog.info(this, "[Encoder ]", "handleStopRecording");
        if (this.mVideoEncoderImpl != null) {
            this.mVideoEncoderImpl.drainEncoder(0L, true);
            this.mVideoEncoderImpl.deInit();
            this.mVideoEncoderImpl = null;
        }
    }
}
