package com.yy.mediaframework.filters;

import com.baidu.android.imsdk.internal.IMConnection;
import com.yy.mediaframework.IEncoderListener;
import com.yy.mediaframework.IMediaFilter;
import com.yy.mediaframework.YYVideoSDK;
import com.yy.mediaframework.api.YMFVideoEncodeFrame;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.model.ByteVector;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.stat.YMFLiveStatisticManager;
import com.yy.mediaframework.utils.YMFLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class TransmitUploadFilter implements IMediaFilter {
    private ByteVector mBytesVector;
    private long mDeltaPtsDts;
    private VideoLiveFilterContext mFilterContext;
    private IEncoderListener mLiveSession;
    private int svcSid;
    private int svcTid;
    byte[] externNaluData = new byte[2];
    private YMFVideoEncodeFrame mVideoEncodeFrame = new YMFVideoEncodeFrame();
    private HashMap<Integer, TransmitUploadInfo> mTransmitUploadInfoMap = new HashMap<>();

    /* loaded from: classes4.dex */
    private class TransmitUploadInfo {
        public int bitRate;
        public int count;
        public int fps;
        private boolean isSvdData;
        public int keyFrames;
        public long lastEncodeRecordTime;
        public long lastFrameTime;
        private List<Long> mDeltaPtsList;
        public long mLastPrintTime;
        public long mLastPts;
        private long mMaxDeltaEncodeTime;
        private long mMaxDeltaPts;

        private TransmitUploadInfo() {
            this.lastEncodeRecordTime = 0L;
            this.lastFrameTime = 0L;
            this.count = 0;
            this.mLastPts = 0L;
            this.mLastPrintTime = 0L;
            this.mMaxDeltaEncodeTime = 0L;
            this.mDeltaPtsList = new ArrayList();
            this.mMaxDeltaPts = 0L;
            this.isSvdData = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printfDeltaPts(long j) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mLastPts == 0) {
                this.mLastPrintTime = currentTimeMillis;
                this.mLastPts = j;
                return;
            }
            this.mDeltaPtsList.add(Long.valueOf(j - this.mLastPts));
            this.mMaxDeltaPts = this.mMaxDeltaPts < j - this.mLastPts ? j - this.mLastPts : this.mMaxDeltaPts;
            this.mLastPts = j;
            if (currentTimeMillis - this.mLastPrintTime >= IMConnection.RETRY_DELAY_TIMES) {
                String str = " " + j + " ";
                for (int i = 0; i < this.mDeltaPtsList.size(); i++) {
                    str = str + this.mDeltaPtsList.get(i) + ",";
                }
                YMFLog.info(this, "[Encoder ]", "TransmitUploadFilter printfDeltaPts [" + str + "]MAX:" + this.mMaxDeltaPts + " in " + this.mDeltaPtsList.size());
                this.mDeltaPtsList.clear();
                this.mLastPrintTime = currentTimeMillis;
                this.mMaxDeltaPts = 0L;
            }
        }

        public void calcDeltaMaxPtsDts(int i, long j, long j2) {
            YMFLiveStatisticManager.getInstance().setVideoPtsDtsMaxDiff(i, (int) Math.abs(j - j2));
        }

        public void calcEncodeInfo(YYMediaSample yYMediaSample) {
            int i = yYMediaSample.mStreamId;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.lastEncodeRecordTime == 0 || this.lastFrameTime == 0) {
                this.lastEncodeRecordTime = currentTimeMillis;
                this.lastFrameTime = currentTimeMillis;
                return;
            }
            long abs = Math.abs(currentTimeMillis - this.lastFrameTime);
            this.lastFrameTime = currentTimeMillis;
            YMFLiveStatisticManager.getInstance().setVideoEncodeTimeDiff(yYMediaSample.mStreamId, (int) abs);
            if (abs < this.mMaxDeltaEncodeTime) {
                abs = this.mMaxDeltaEncodeTime;
            }
            this.mMaxDeltaEncodeTime = abs;
            if (currentTimeMillis - this.lastEncodeRecordTime >= 1000) {
                if (this.count == 10) {
                    YMFLog.info(this, "[Encoder ]", "mStreamId：" + yYMediaSample.mStreamId + ",publishVideoFrameBuffer bitRate:" + (this.bitRate * 8) + "bps, fps:" + this.fps + ", 6s keyFrames:" + this.keyFrames + ",isSvc " + this.isSvdData);
                    this.count = 0;
                }
                this.count++;
                YMFLiveStatisticManager.getInstance().setVideoRealBitrate(yYMediaSample.mStreamId, (this.bitRate * 8) / 1000);
                YMFLiveStatisticManager.getInstance().setVideoRealEncodeFps(yYMediaSample.mStreamId, this.fps);
                this.fps = 0;
                this.keyFrames = 0;
                this.bitRate = 0;
                this.lastEncodeRecordTime = System.currentTimeMillis();
            }
            this.fps++;
            this.bitRate += yYMediaSample.mBufferSize;
        }
    }

    public TransmitUploadFilter(VideoLiveFilterContext videoLiveFilterContext, IEncoderListener iEncoderListener) {
        this.mLiveSession = null;
        this.mFilterContext = null;
        this.mBytesVector = null;
        this.mDeltaPtsDts = 0L;
        this.mFilterContext = videoLiveFilterContext;
        this.mLiveSession = iEncoderListener;
        this.mBytesVector = new ByteVector(4096);
        this.mDeltaPtsDts = YYVideoSDK.getInstance().getDeltaYYPtsMillions();
        YMFLog.info(this, "[Encoder ]", "TransmitUploadFilter mDeltaPtsDts:" + this.mDeltaPtsDts);
    }

    @Override // com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        if (!this.mTransmitUploadInfoMap.containsKey(Integer.valueOf(yYMediaSample.mStreamId))) {
            this.mTransmitUploadInfoMap.put(Integer.valueOf(yYMediaSample.mStreamId), new TransmitUploadInfo());
        }
        this.mBytesVector.reserve(yYMediaSample.mBufferSize);
        byte[] bytes = this.mBytesVector.getBytes();
        if (yYMediaSample.mEncoderType == VideoEncoderType.HARD_ENCODER_H264) {
            if (yYMediaSample.mFrameType == 6 || yYMediaSample.mFrameType == 5) {
                if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_SCREEN_RECORD) {
                    yYMediaSample.mDataByteBuffer.rewind();
                    yYMediaSample.mDataByteBuffer.get(bytes, 0, yYMediaSample.mBufferSize);
                } else {
                    yYMediaSample.mDataByteBuffer.rewind();
                    yYMediaSample.mDataByteBuffer.get(bytes, 0, yYMediaSample.mBufferSize);
                }
            } else {
                int i = yYMediaSample.mBufferSize - 4;
                bytes[0] = (byte) ((i >>> 24) & 255);
                bytes[1] = (byte) ((i >>> 16) & 255);
                bytes[2] = (byte) ((i >>> 8) & 255);
                bytes[3] = (byte) (i & 255);
                yYMediaSample.mDataByteBuffer.position(yYMediaSample.mBufferOffset + 4);
                yYMediaSample.mDataByteBuffer.limit(yYMediaSample.mBufferOffset + yYMediaSample.mBufferSize);
                yYMediaSample.mDataByteBuffer.get(bytes, 4, yYMediaSample.mBufferSize - 4);
            }
        } else if (yYMediaSample.mEncoderType != VideoEncoderType.HARD_ENCODER_H265 || yYMediaSample.mFrameType != 255) {
            if (yYMediaSample.mEncoderType == VideoEncoderType.SOFT_ENCODER_X264) {
                yYMediaSample.mDataByteBuffer.rewind();
                yYMediaSample.mDataByteBuffer.get(bytes, 0, yYMediaSample.mBufferSize);
            } else if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_SCREEN_RECORD) {
                yYMediaSample.mDataByteBuffer.rewind();
                yYMediaSample.mDataByteBuffer.get(bytes, 0, yYMediaSample.mBufferSize);
            } else {
                yYMediaSample.mDataByteBuffer.rewind();
                yYMediaSample.mDataByteBuffer.get(bytes, 0, yYMediaSample.mBufferSize);
            }
        }
        this.svcTid = 255;
        this.svcSid = 255;
        this.mTransmitUploadInfoMap.get(Integer.valueOf(yYMediaSample.mStreamId)).isSvdData = false;
        if (yYMediaSample.mEncoderType == VideoEncoderType.SOFT_ENCODER_X264 && yYMediaSample.mBufferSize >= 6) {
            yYMediaSample.mDataByteBuffer.rewind();
            yYMediaSample.mDataByteBuffer.position(4);
            yYMediaSample.mDataByteBuffer.get(this.externNaluData, 0, 2);
            if ((this.externNaluData[0] & 31) == 14) {
                this.svcSid = (this.externNaluData[1] >>> 3) & 7;
                this.svcTid = this.externNaluData[1] & 7;
                if (this.svcSid != 255 || this.svcTid != 255) {
                    this.mTransmitUploadInfoMap.get(Integer.valueOf(yYMediaSample.mStreamId)).isSvdData = true;
                }
            }
        }
        if (!yYMediaSample.isUsePbo) {
            this.mVideoEncodeFrame.pts = yYMediaSample.mYYPtsMillions + this.mDeltaPtsDts;
            this.mVideoEncodeFrame.dts = yYMediaSample.mDtsMillions + this.mDeltaPtsDts;
        } else {
            this.mVideoEncodeFrame.pts = (yYMediaSample.mYYPtsMillions + this.mDeltaPtsDts) - yYMediaSample.mFrameDeltaDts;
            this.mVideoEncodeFrame.dts = (yYMediaSample.mDtsMillions + this.mDeltaPtsDts) - yYMediaSample.mFrameDeltaDts;
        }
        this.mVideoEncodeFrame.svcSid = this.svcSid;
        this.mVideoEncodeFrame.svcTid = this.svcTid;
        this.mVideoEncodeFrame.data = bytes;
        this.mVideoEncodeFrame.len = yYMediaSample.mBufferSize;
        this.mVideoEncodeFrame.width = yYMediaSample.mWidth;
        this.mVideoEncodeFrame.height = yYMediaSample.mHeight;
        this.mVideoEncodeFrame.streamId = yYMediaSample.mStreamId;
        this.mVideoEncodeFrame.frameType = yYMediaSample.mFrameType;
        this.mVideoEncodeFrame.encodeType = yYMediaSample.mEncoderType;
        this.mLiveSession.onEncodeFrameData(this.mVideoEncodeFrame);
        this.mBytesVector.clear();
        if (yYMediaSample.mFrameType != 6 && yYMediaSample.mFrameType != 5) {
            this.mTransmitUploadInfoMap.get(Integer.valueOf(yYMediaSample.mStreamId)).printfDeltaPts(yYMediaSample.mYYPtsMillions);
            this.mTransmitUploadInfoMap.get(Integer.valueOf(yYMediaSample.mStreamId)).calcDeltaMaxPtsDts(yYMediaSample.mStreamId, yYMediaSample.mYYPtsMillions, yYMediaSample.mDtsMillions);
        }
        this.mTransmitUploadInfoMap.get(Integer.valueOf(yYMediaSample.mStreamId)).calcEncodeInfo(yYMediaSample);
        return false;
    }
}
