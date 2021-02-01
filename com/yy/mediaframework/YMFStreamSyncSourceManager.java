package com.yy.mediaframework;

import com.baidu.mobstat.Config;
import com.yy.mediaframework.api.YMFVideoEncodeFrame;
import com.yy.mediaframework.utils.YMFLog;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
public class YMFStreamSyncSourceManager {
    public static final int SSRC_DISCARD = 1;
    public static final String TAG = "YMFStreamSyncSourceManager";
    private static YMFStreamSyncSourceManager mInstance;
    private byte[] mHighStreamExtraData;
    private byte[] mLowStreamExtraData;
    private AtomicBoolean mChangeSyncSourceFlag = new AtomicBoolean(false);
    private AtomicLong mHighStreamChangeSyncSourcePts = new AtomicLong(0);
    private AtomicLong mLowStreamChangeSyncSourcePts = new AtomicLong(0);
    public AtomicInteger mHighStreamFirstSsrc = new AtomicInteger(0);
    public AtomicInteger mLowStreamFirstSsrc = new AtomicInteger(0);
    private int mPrintHighStreamSsrc = -1;
    private int mPrintLowStreamSsrc = -1;

    public static YMFStreamSyncSourceManager getInstance() {
        if (mInstance == null) {
            mInstance = new YMFStreamSyncSourceManager();
        }
        return mInstance;
    }

    private static int randomInt(int i, int i2) {
        return (new Random().nextInt(i2) % ((i2 - i) + 1)) + i;
    }

    public YMFStreamSyncSourceManager() {
        this.mHighStreamFirstSsrc.set(randomInt(10, 100));
        this.mLowStreamFirstSsrc.set(randomInt(10, 100));
    }

    public void changeVideoConfig() {
        synchronized (this) {
            this.mChangeSyncSourceFlag.set(true);
            this.mHighStreamChangeSyncSourcePts.set(-1L);
            this.mLowStreamChangeSyncSourcePts.set(-1L);
        }
    }

    public void changeVideoSource() {
        synchronized (this) {
            this.mChangeSyncSourceFlag.set(true);
            this.mHighStreamChangeSyncSourcePts.set(-1L);
            this.mLowStreamChangeSyncSourcePts.set(-1L);
        }
    }

    public void changeEncoderConfig() {
        synchronized (this) {
            this.mChangeSyncSourceFlag.set(true);
            this.mHighStreamChangeSyncSourcePts.set(-1L);
            this.mLowStreamChangeSyncSourcePts.set(-1L);
        }
    }

    public void reStartCapture() {
        synchronized (this) {
            this.mChangeSyncSourceFlag.set(true);
            this.mHighStreamChangeSyncSourcePts.set(-1L);
            this.mLowStreamChangeSyncSourcePts.set(-1L);
        }
    }

    public boolean getAndResetSyncSourceFlag(long j) {
        boolean z;
        synchronized (this) {
            z = this.mChangeSyncSourceFlag.get();
            this.mChangeSyncSourceFlag.set(false);
            if (z) {
                this.mHighStreamChangeSyncSourcePts.set(j);
                this.mLowStreamChangeSyncSourcePts.set(j);
                this.mHighStreamFirstSsrc.getAndIncrement();
                this.mLowStreamFirstSsrc.getAndIncrement();
            }
        }
        return z;
    }

    public void getExtraData(YMFVideoEncodeFrame yMFVideoEncodeFrame) {
        if (yMFVideoEncodeFrame.streamId == 0) {
            getHighStreamExtraData(yMFVideoEncodeFrame);
        } else {
            getLowStreamExtraData(yMFVideoEncodeFrame);
        }
    }

    private void getHighStreamExtraData(YMFVideoEncodeFrame yMFVideoEncodeFrame) {
        String str;
        int i;
        if (this.mHighStreamExtraData == null) {
            this.mHighStreamExtraData = new byte[20];
        }
        if (yMFVideoEncodeFrame.pts >= this.mHighStreamChangeSyncSourcePts.get() || this.mHighStreamChangeSyncSourcePts.get() <= 0) {
            str = "ssrc=" + this.mHighStreamFirstSsrc.get();
            i = this.mHighStreamFirstSsrc.get();
        } else {
            str = "ssrc=1";
            i = 1;
        }
        String str2 = str + ":";
        System.arraycopy(str2.getBytes(), 0, this.mHighStreamExtraData, 0, str2.length());
        yMFVideoEncodeFrame.extraData = this.mHighStreamExtraData;
        yMFVideoEncodeFrame.extraDataLen = str2.length();
        if (this.mPrintHighStreamSsrc != i && yMFVideoEncodeFrame.pts > 0 && yMFVideoEncodeFrame.frameType < 5) {
            YMFLog.error(this, Constant.MEDIACODE_SSRC, "high " + yMFVideoEncodeFrame.streamId + "  " + yMFVideoEncodeFrame.pts + " ssrc:" + str2);
            this.mPrintHighStreamSsrc = i;
        }
    }

    private void getLowStreamExtraData(YMFVideoEncodeFrame yMFVideoEncodeFrame) {
        String str;
        int i;
        if (this.mLowStreamExtraData == null) {
            this.mLowStreamExtraData = new byte[20];
        }
        if (yMFVideoEncodeFrame.pts >= this.mLowStreamChangeSyncSourcePts.get() || this.mLowStreamChangeSyncSourcePts.get() <= 0) {
            str = "ssrc=" + this.mLowStreamFirstSsrc.get();
            i = this.mLowStreamFirstSsrc.get();
        } else {
            str = "ssrc=1";
            i = 1;
        }
        String str2 = str + ":";
        System.arraycopy(str2.getBytes(), 0, this.mLowStreamExtraData, 0, str2.length());
        yMFVideoEncodeFrame.extraData = this.mLowStreamExtraData;
        yMFVideoEncodeFrame.extraDataLen = str2.length();
        if (this.mPrintLowStreamSsrc != i && yMFVideoEncodeFrame.pts > 0 && yMFVideoEncodeFrame.frameType < 5) {
            YMFLog.error(this, Constant.MEDIACODE_SSRC, Config.EXCEPTION_MEMORY_LOW + yMFVideoEncodeFrame.streamId + "  " + yMFVideoEncodeFrame.pts + " ssrc:" + str2);
            this.mPrintLowStreamSsrc = i;
        }
    }

    public void deInit() {
        this.mLowStreamChangeSyncSourcePts.set(-1L);
        this.mHighStreamChangeSyncSourcePts.set(-1L);
        this.mChangeSyncSourceFlag.set(false);
    }
}
