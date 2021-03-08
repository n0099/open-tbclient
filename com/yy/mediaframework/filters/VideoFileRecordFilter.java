package com.yy.mediaframework.filters;

import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.utils.YMFLog;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class VideoFileRecordFilter extends AbstractYYMediaFilter implements Runnable {
    private static final int MSG_FRAME_AVAIL = 1;
    private static final int MSG_QUIT = 2;
    public static int mFileIndex = 1;
    public static final String sVideoDir = "YYVideo";
    public Thread mTaskThread = null;
    private Object mReadyFence = new Object();
    private boolean mReady = false;
    private Handler mHandler = null;
    DataOutputStream mDataOutput = null;
    private int mCnt = 0;

    public static String getVideoFileName() {
        String str = Environment.getExternalStorageDirectory().toString() + File.separator + sVideoDir;
        File file = new File(str);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdir();
        }
        StringBuilder append = new StringBuilder().append(str).append(File.separator).append("yyvideo-").append(Thread.currentThread().getId());
        int i = mFileIndex;
        mFileIndex = i + 1;
        return append.append(i).toString();
    }

    public void init() {
        this.mTaskThread = new Thread(this, "YY_yyvideolib_H264FileStore_Thread");
        this.mTaskThread.start();
        synchronized (this.mReadyFence) {
            while (!this.mReady) {
                try {
                    YMFLog.info(this, "[Encoder ]", "ready fence waitting");
                    this.mReadyFence.wait();
                    YMFLog.info(this, "[Encoder ]", "got ready fence ");
                } catch (InterruptedException e) {
                    YMFLog.info(this, "[Encoder ]", "init exception:" + e.getMessage());
                }
            }
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        this.mHandler.post(new Runnable() { // from class: com.yy.mediaframework.filters.VideoFileRecordFilter.1
            @Override // java.lang.Runnable
            public void run() {
                Looper myLooper = Looper.myLooper();
                if (myLooper != null) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        myLooper.quitSafely();
                    } else {
                        myLooper.quit();
                    }
                }
            }
        });
        try {
            this.mTaskThread.join();
        } catch (InterruptedException e) {
            YMFLog.info(this, "[Encoder ]", "deinit exception:" + e.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [130=5] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    @Override // java.lang.Runnable
    public void run() {
        YMFLog.info(this, "[Encoder ]", "run before prepare");
        Looper.prepare();
        try {
            synchronized (this.mReadyFence) {
                this.mReady = true;
                this.mReadyFence.notify();
                YMFLog.info(this, "[Encoder ]", "run notify ready");
            }
            this.mHandler = new OutputStreamHandler(this);
            this.mDataOutput = new DataOutputStream(new FileOutputStream(getVideoFileName()));
            Looper.loop();
            YMFLog.info(this, "[Encoder ]", "encoder thread exiting");
            try {
                this.mDataOutput.flush();
                this.mDataOutput.close();
            } catch (IOException e) {
                YMFLog.error(this, "[Encoder ]", "encoder thread exception:" + e.getMessage());
            }
            synchronized (this.mReadyFence) {
                this.mReady = false;
                this.mHandler = null;
            }
        } catch (Throwable th) {
            try {
                YMFLog.error(this, "[Encoder ]", "encoder thread run exception:" + th.getMessage());
                YMFLog.info(this, "[Encoder ]", "encoder thread exiting");
                try {
                    this.mDataOutput.flush();
                    this.mDataOutput.close();
                } catch (IOException e2) {
                    YMFLog.error(this, "[Encoder ]", "encoder thread exception:" + e2.getMessage());
                }
                synchronized (this.mReadyFence) {
                    this.mReady = false;
                    this.mHandler = null;
                }
            } catch (Throwable th2) {
                YMFLog.info(this, "[Encoder ]", "encoder thread exiting");
                try {
                    this.mDataOutput.flush();
                    this.mDataOutput.close();
                } catch (IOException e3) {
                    YMFLog.error(this, "[Encoder ]", "encoder thread exception:" + e3.getMessage());
                }
                synchronized (this.mReadyFence) {
                    this.mReady = false;
                    this.mHandler = null;
                    throw th2;
                }
            }
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        if (this.mHandler != null && yYMediaSample.mBufferSize > 0 && this.mCnt <= 14400) {
            this.mCnt++;
            byte[] bArr = new byte[yYMediaSample.mBufferSize];
            yYMediaSample.mDataByteBuffer.position(yYMediaSample.mBufferOffset);
            yYMediaSample.mDataByteBuffer.get(bArr, 0, yYMediaSample.mBufferSize);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, bArr));
        }
        return false;
    }

    public boolean processMediaData(ByteBuffer byteBuffer, int i, int i2) {
        if (this.mHandler != null && byteBuffer != null && i2 > 0 && this.mCnt <= 14400) {
            this.mCnt++;
            byte[] bArr = new byte[i2];
            int position = byteBuffer.position();
            byteBuffer.position(i);
            byteBuffer.get(bArr, 0, i2);
            byteBuffer.position(position);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, bArr));
        }
        return false;
    }

    public void OutputStreamToFile(byte[] bArr) {
        try {
            this.mDataOutput.write(bArr, 0, bArr.length);
            this.mDataOutput.flush();
        } catch (IOException e) {
            YMFLog.error(this, "[Encoder ]", "OutputStreamToFile exception:" + e.getMessage());
        }
    }

    /* loaded from: classes6.dex */
    private static class OutputStreamHandler extends Handler {
        private WeakReference<VideoFileRecordFilter> mWeakRecorder;

        public OutputStreamHandler(VideoFileRecordFilter videoFileRecordFilter) {
            this.mWeakRecorder = new WeakReference<>(videoFileRecordFilter);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            VideoFileRecordFilter videoFileRecordFilter = this.mWeakRecorder.get();
            if (videoFileRecordFilter == null) {
                YMFLog.warn(this, "[Encoder ]", "OutputStreamHandler handleMessage:encoder is null");
                return;
            }
            switch (i) {
                case 1:
                    videoFileRecordFilter.OutputStreamToFile((byte[]) message.obj);
                    return;
                case 2:
                    if (Looper.myLooper() != null) {
                        Looper.myLooper().quit();
                        return;
                    }
                    return;
                default:
                    throw new RuntimeException("Unhandled msg what=" + i);
            }
        }
    }
}
