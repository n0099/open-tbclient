package com.yy.mediaframework.filters;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaFormat;
import com.baidu.ar.auth.FeatureCodes;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.model.ByteVector;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.model.YYMediaSampleAlloc;
import com.yy.mediaframework.stat.YMFLiveUsrBehaviorStat;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class H265HardwareEncoderFilter extends H264HardwareEncoderFilter {
    public static final int SLICE_I = 2;
    public static final int SLICE_IDR = 1;
    public static final int SLICE_UNKNOW = 255;
    private final int SyncFrameDurationMs;
    private ByteVector mBytesVector;
    private boolean mFirstFrameEncode;
    public YYMediaSample mSpsSample;
    private int m_DepSliceSegEn;
    private long m_lastSyncFrameTime;
    private int m_numExtraSliceHeader;
    private int m_outReadNum;
    private int m_outputFlagPresentFlag;

    public H265HardwareEncoderFilter(VideoLiveFilterContext videoLiveFilterContext) {
        super(videoLiveFilterContext);
        this.m_outReadNum = 0;
        this.m_outputFlagPresentFlag = 0;
        this.m_DepSliceSegEn = 0;
        this.m_numExtraSliceHeader = 0;
        this.mFirstFrameEncode = false;
        this.m_lastSyncFrameTime = 0L;
        this.SyncFrameDurationMs = FeatureCodes.TRACK_3D;
        this.mBytesVector = new ByteVector(16384);
        this.mSpsSample = new YYMediaSample();
    }

    @Override // com.yy.mediaframework.filters.H264HardwareEncoderFilter, com.yy.mediaframework.encoder.HardEncodeListner
    @TargetApi(16)
    public void onEncodedHeaderAvailableSample(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, long j, long j2, MediaFormat mediaFormat) {
        byte[] bArr = new byte[bufferInfo.size];
        if (!this.mFirstEncoderDataOut.get()) {
            onFirstEncodedDataOut();
        }
        byteBuffer.get(bArr);
        parsePPS(bArr, bufferInfo.size);
        YYMediaSample alloc = YYMediaSampleAlloc.instance().alloc();
        alloc.mYYPtsMillions = 0L;
        alloc.mDtsMillions = 0L;
        alloc.mMediaFormat = mediaFormat;
        alloc.mFrameFlag = bufferInfo.flags;
        alloc.mWidth = mediaFormat.getInteger("width");
        alloc.mHeight = mediaFormat.getInteger("height");
        alloc.mDataByteBuffer = ByteBuffer.wrap(bArr);
        alloc.mBufferOffset = 0;
        alloc.mBufferSize = bufferInfo.size;
        alloc.mEncoderType = VideoEncoderType.HARD_ENCODER_H265;
        alloc.mFrameType = 9;
        this.mSpsSample.assigne(alloc);
        deliverToDownStream(alloc);
        this.m_lastSyncFrameTime = System.currentTimeMillis();
        handleEncodedFrameStats(alloc.mBufferSize, getInputFrameByteSize(), alloc.mFrameType);
        alloc.decRef();
    }

    @Override // com.yy.mediaframework.filters.H264HardwareEncoderFilter, com.yy.mediaframework.encoder.HardEncodeListner
    @TargetApi(16)
    public void onEncodedDataAvailableSample(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, long j, long j2, MediaFormat mediaFormat) {
        YMFLog.debug(this, "[Encoder ]", "OnEncodeDataAvailableSample get in");
        YYMediaSample alloc = YYMediaSampleAlloc.instance().alloc();
        alloc.mDtsMillions = j;
        alloc.mYYPtsMillions = j2;
        alloc.mMediaFormat = mediaFormat;
        alloc.mFrameFlag = bufferInfo.flags;
        alloc.mWidth = mediaFormat.getInteger("width");
        alloc.mHeight = mediaFormat.getInteger("height");
        alloc.mDataByteBuffer = byteBuffer;
        alloc.mBufferOffset = bufferInfo.offset;
        alloc.mBufferSize = bufferInfo.size;
        alloc.mEncoderType = VideoEncoderType.HARD_ENCODER_H265;
        if (!this.mFirstFrameEncode) {
            YMFLiveUsrBehaviorStat.getInstance().notifyFirstFrameEncode(alloc.mYYPtsMillions);
            this.mFirstFrameEncode = true;
        }
        int i = 0;
        while (byteBuffer.get(((bufferInfo.offset + bufferInfo.size) - 1) - i) == 0) {
            i++;
        }
        if (i < alloc.mBufferSize) {
            alloc.mBufferSize -= i;
        }
        byteBuffer.position(bufferInfo.offset);
        this.mBytesVector.put(byteBuffer, bufferInfo.size);
        byteBuffer.position(bufferInfo.offset);
        int parseSliceType = parseSliceType(this.mBytesVector.getBytes(), this.mBytesVector.size());
        if (parseSliceType == 1 || parseSliceType == 2) {
            alloc.mFrameType = 4;
            if (parseSliceType == 1) {
                this.m_lastSyncFrameTime = System.currentTimeMillis();
            }
        } else {
            alloc.mFrameType = 1;
        }
        if (System.currentTimeMillis() - this.m_lastSyncFrameTime > 3100) {
            requestSyncFrame();
            this.m_lastSyncFrameTime = System.currentTimeMillis();
        }
        this.mBytesVector.clear();
        if (alloc.mFrameType == 4 && this.mSpsSample != null) {
            deliverToDownStream(this.mSpsSample);
        }
        deliverToDownStream(alloc);
        handleEncodedFrameStats(alloc.mBufferSize, getInputFrameByteSize(), alloc.mFrameType);
        alloc.decRef();
    }

    @Override // com.yy.mediaframework.filters.H264HardwareEncoderFilter, com.yy.mediaframework.filters.IEncodeFilter
    public VideoEncoderType getEncoderFilterType() {
        return VideoEncoderType.HARD_ENCODER_H265;
    }

    @Override // com.yy.mediaframework.filters.H264HardwareEncoderFilter, com.yy.mediaframework.encoder.HardEncodeListner
    public void onEncoderFomratChanged(MediaFormat mediaFormat) {
        super.onEncoderFomratChanged(mediaFormat);
    }

    @Override // com.yy.mediaframework.filters.H264HardwareEncoderFilter, com.yy.mediaframework.encoder.HardEncodeListner
    public void onPreviewTextureAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // com.yy.mediaframework.filters.H264HardwareEncoderFilter, com.yy.mediaframework.encoder.HardEncodeListner
    public void onError(long j, String str, String str2) {
        _OnError(j, str, str2);
    }

    private static int test_bit(byte[] bArr, int i) {
        return (bArr[i >> 3] >> (7 - (i % 8))) & 1;
    }

    private static int read_bits(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 > 0) {
                i3 = (i3 << 1) + test_bit(bArr, i);
                i2 = i4;
                i++;
            } else {
                return i3;
            }
        }
    }

    private int read_ue(byte[] bArr, int i) {
        int i2 = -1;
        int i3 = 0;
        while (i3 == 0) {
            i3 = test_bit(bArr, i + i2 + 1);
            i2++;
        }
        int read_bits = ((1 << i2) - 1) + read_bits(bArr, i + i2 + 1, i2);
        this.m_outReadNum = (i2 * 2) + 1;
        return read_bits;
    }

    public void parsePPS(byte[] bArr, int i) {
        int i2;
        if (bArr != null && i > 0) {
            int i3 = 0;
            while (true) {
                if (i3 + 5 > i) {
                    i2 = i3;
                    break;
                }
                if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 0 && bArr[i3 + 3] == 1) {
                    i2 = i3 + 4;
                } else {
                    i2 = (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 3] == 1) ? i3 + 3 : i3;
                }
                if (i3 == i2) {
                    i3 = i2 + 1;
                } else if (((bArr[i2] & 126) >> 1) == 34) {
                    break;
                } else {
                    i3 = i2;
                }
            }
            if (i2 + 5 < i) {
                int i4 = (i2 + 2) * 8;
                int read_ue = read_ue(bArr, i4);
                int i5 = i4 + this.m_outReadNum;
                int read_ue2 = read_ue(bArr, i5);
                int i6 = i5 + this.m_outReadNum;
                int i7 = i6 + 1;
                this.m_DepSliceSegEn = read_bits(bArr, i6, 1);
                int i8 = i7 + 1;
                this.m_outputFlagPresentFlag = read_bits(bArr, i7, 1);
                this.m_numExtraSliceHeader = read_bits(bArr, i8, 3);
                int i9 = i8 + 3;
                YMFLog.info(this, "[Encoder ]", "H265SurfaceEncoder parsePPS Type, picId:" + read_ue + ", seqId:" + read_ue2 + ", m_DepSliceSegEn:" + this.m_DepSliceSegEn + ", m_outputFlagPresentFlag:" + this.m_outputFlagPresentFlag + ", m_numExtraSliceHeader:" + this.m_numExtraSliceHeader);
            }
        }
    }

    public int parseSliceType(byte[] bArr, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 32;
        int i7 = 0;
        int naltype = naltype(bArr, i);
        if (naltype < 0) {
            YMFLog.info(this, "[Encoder ]", "H265SurfaceEncoder parseSliceType, unknown, ntype:" + naltype);
            return 255;
        } else if (naltype >= 16 && naltype <= 23) {
            YMFLog.info(this, "[Encoder ]", "H265SurfaceEncoder parseSliceType, IDR, ntype:" + naltype);
            return 1;
        } else if (naltype >= 32 && naltype <= 34) {
            YMFLog.info(this, "[Encoder ]", "H265SurfaceEncoder parseSliceType, PPS/VPS/SPS, ntype:" + naltype);
            return 255;
        } else {
            if (bArr[0] != 0 || bArr[1] != 0 || bArr[2] != 0 || bArr[3] != 1) {
                if (bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 1) {
                    i6 = 24;
                } else {
                    YMFLog.info(this, "[Encoder ]", "H265SurfaceEncoder parseSliceType, unknown slice type");
                    return 255;
                }
            }
            int i8 = i6 + 16;
            int i9 = i8 + 1;
            int read_bits = read_bits(bArr, i8, 1);
            read_ue(bArr, i9);
            int i10 = this.m_outReadNum + i9;
            if (read_bits == 0) {
                if (this.m_DepSliceSegEn != 0) {
                    i5 = i10 + 1;
                    i2 = read_bits(bArr, i10, 1);
                } else {
                    i2 = 0;
                    i5 = i10;
                }
                read_ue(bArr, i5);
                i3 = i5 + this.m_outReadNum;
            } else {
                i2 = 0;
                i3 = i10;
            }
            if (i2 == 0) {
                while (true) {
                    i4 = i3;
                    if (i7 >= this.m_numExtraSliceHeader) {
                        break;
                    }
                    i3 = i4 + 1;
                    read_bits(bArr, i4, 1);
                    i7++;
                }
                int read_ue = read_ue(bArr, i4);
                int i11 = i4 + this.m_outReadNum;
                return read_ue == 2 ? 2 : 255;
            }
            return 255;
        }
    }

    public static int naltype(byte[] bArr, int i) {
        if (bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 1) {
            return (bArr[4] & 126) >> 1;
        }
        if (bArr[0] != 0 || bArr[1] != 0 || bArr[2] != 1) {
            return -1;
        }
        return (bArr[3] & 126) >> 1;
    }
}
