package com.yy.videoplayer.decoder;

import com.yy.videoplayer.YMFEventManager;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.utils.YMFLog;
import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes6.dex */
public class VideoDecoderCenterExt {
    private static final int GPUMaxRenderFrameRate = 40;
    private static final String TAG = "VideoDecoderCenterExt";
    private static long mLength;
    private static long mTime;
    private static ConcurrentMap<Long, HardDecodeWay> streamIdDecoderMap = new ConcurrentHashMap();
    private static ConcurrentMap<Long, YLightweightVideoViewExt> streamIdViewMap = new ConcurrentHashMap();
    private static String videoStreamFile = null;
    private static SimpleDateFormat dateFormat = null;
    private static boolean mYUVDecodeMode = true;
    private static int mHardDecDirectRenderConfig = 0;
    private static HardDecoderStaffVersion currentHardDecoderStaffVersion = HardDecoderStaffVersion.GPURENDER;

    /* loaded from: classes6.dex */
    public enum HardDecoderStaffVersion {
        SIMPLIFIED,
        GPURENDER,
        YUVBUFFER
    }

    /* loaded from: classes6.dex */
    public static class VideoStreamType {
        public static final int H264 = 0;
        public static final int H265 = 1;
        public static final int NOT_SET = -1;
        public static final int VP8 = 2;
    }

    public static HardDecodeWay getDecoderStaff(long j) {
        return streamIdDecoderMap.get(Long.valueOf(j));
    }

    public static void Link(long j, YLightweightVideoViewExt yLightweightVideoViewExt) {
        streamIdViewMap.put(Long.valueOf(j), yLightweightVideoViewExt);
    }

    public static void Unlink(long j) {
        streamIdViewMap.remove(Long.valueOf(j));
    }

    public static boolean setOnlyDecoded(long j, boolean z) {
        HardDecodeWay hardDecodeWay = streamIdDecoderMap.get(Long.valueOf(j));
        if (hardDecodeWay == null || !(hardDecodeWay instanceof HardDecodeWayBuffer)) {
            return false;
        }
        ((HardDecodeWayBuffer) hardDecodeWay).setOnlyDecoded(z);
        return true;
    }

    public static void VideoStreamStart(long j, long j2, int i, int i2, int i3, boolean z, int i4, int i5) {
        HardDecodeWay hardDecodeWay;
        boolean z2 = i3 >= 40;
        if ((z || mYUVDecodeMode) && !z2) {
            HardDecodeWay BorrowOrCreateDecoderByType = HardDecoderPool.BorrowOrCreateDecoderByType(HardDecoderStaffVersion.YUVBUFFER);
            if (mYUVDecodeMode) {
                ((HardDecodeWayBuffer) BorrowOrCreateDecoderByType).setYUVDecodeMode(true);
                YMFEventManager.instance().notifyStreamStart(j2);
            }
            if (z) {
                ((HardDecodeWayBuffer) BorrowOrCreateDecoderByType).setOnlyDecoded(true);
                hardDecodeWay = BorrowOrCreateDecoderByType;
            } else {
                hardDecodeWay = BorrowOrCreateDecoderByType;
            }
        } else if (z2) {
            hardDecodeWay = HardDecoderPool.BorrowOrCreateDecoderByType(HardDecoderStaffVersion.SIMPLIFIED);
        } else {
            hardDecodeWay = HardDecoderPool.BorrowOrCreateDecoderByType(HardDecoderStaffVersion.GPURENDER);
        }
        if (hardDecodeWay == null) {
            YMFLog.warn(null, "[Decoder ]", "VideoStreamStart BorrowOrCreateDecoderByType error!");
            hardDecodeWay = GetNewHardDecodeWay();
        }
        hardDecodeWay.SetVideoIds(j, j2);
        streamIdDecoderMap.put(Long.valueOf(j2), hardDecodeWay);
        if (hardDecodeWay != null) {
            String str = "video/avc";
            if (1 == i) {
                str = "video/hevc";
            } else if (2 == i) {
                str = "video/x-vnd.on2.vp8";
            }
            hardDecodeWay.onCreateRenderAhead(i4, i5, str);
        } else {
            YMFLog.error((Object) null, VideoConstant.MEDIACODE_DECODER, "CreateRenderAhead HardDecodeWay with streamId = " + j2 + " not found");
        }
        YMFLog.info(null, "[Decoder ]", "VideoStreamStart HardDecodeWay count:" + streamIdDecoderMap.size() + ", add streamId:" + j2 + ", fps:" + i3 + " used:" + hardDecodeWay);
        YLightweightVideoViewExt yLightweightVideoViewExt = streamIdViewMap.get(Long.valueOf(j2));
        if (yLightweightVideoViewExt != null) {
            yLightweightVideoViewExt.HoldDecoderStaff();
        }
    }

    public static HardDecodeWay getHardDecodeWay(long j) {
        return streamIdDecoderMap.get(Long.valueOf(j));
    }

    private static HardDecodeWay newHardDecoderWaySimple() {
        YMFLog.info(null, "[Decoder ]", "resetHardDecoderWay to Simplify");
        HardDecodeWaySimplified hardDecodeWaySimplified = new HardDecodeWaySimplified();
        hardDecodeWaySimplified.Start();
        return hardDecodeWaySimplified;
    }

    private static void updateHardDecodeWay(long j, int i, int i2, int i3) {
        mHardDecDirectRenderConfig = YYVideoLibMgr.instance().getHardDirectRender();
        if (mHardDecDirectRenderConfig > 0) {
            HardDecodeWay hardDecodeWay = streamIdDecoderMap.get(Long.valueOf(j));
            if ((i >= 720 && i2 >= 1280) || (i >= 1280 && i2 >= 720)) {
                if (!(hardDecodeWay instanceof HardDecodeWaySimplified)) {
                    hardDecodeWay = HardDecoderPool.BorrowOrCreateDecoderByType(HardDecoderStaffVersion.SIMPLIFIED);
                    YMFLog.info(TAG, "[Decoder ]", "reset HardDecoderWay to Simplify");
                }
            } else if (mYUVDecodeMode && !(hardDecodeWay instanceof HardDecodeWayBuffer)) {
                hardDecodeWay = HardDecoderPool.BorrowOrCreateDecoderByType(HardDecoderStaffVersion.YUVBUFFER);
                YMFLog.info(TAG, "[Decoder ]", "reset HardDecoderWay to Simplify");
            }
            streamIdDecoderMap.put(Long.valueOf(j), hardDecodeWay);
            hardDecodeWay.SetVideoIds(0L, j);
            YLightweightVideoViewExt yLightweightVideoViewExt = streamIdViewMap.get(Long.valueOf(j));
            if (yLightweightVideoViewExt != null) {
                yLightweightVideoViewExt.HoldDecoderStaff();
            }
        }
    }

    public static void DeliverVideoConfig(long j, int i, byte[] bArr, int i2, int i3, int i4) {
        YMFLog.info(null, "[Decoder ]", "DeliverVideoConfig streamId:" + j + " streamType:" + i + " width:" + i2 + " height:" + i3 + " framerate:" + i4);
        updateHardDecodeWay(j, i2, i3, i4);
        HardDecodeWay hardDecodeWay = streamIdDecoderMap.get(Long.valueOf(j));
        if (bArr != null) {
            mLength += bArr.length;
        }
        if (hardDecodeWay != null) {
            String str = "video/avc";
            if (1 == i) {
                str = "video/hevc";
            } else if (2 == i) {
                str = "video/x-vnd.on2.vp8";
            }
            hardDecodeWay.OnVideoConfig(bArr, i2, i3, str);
            return;
        }
        YMFLog.error((Object) null, "[Decoder ]", "DeliverVideoConfig HardDecodeWay with streamId:" + j + " not found");
    }

    private static void notifyBiteRateInfo(long j, byte[] bArr) {
        long currentTimeMillis;
        if (bArr != null) {
            mLength += bArr.length;
        }
        if (mTime == 0) {
            mTime = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - mTime > 10000) {
            StateMonitor.instance();
            StateMonitor.NotifyBiteRateInfo(j, (int) ((mLength / currentTimeMillis) * 1000 * 8));
            mLength = 0L;
            mTime = System.currentTimeMillis();
        }
    }

    public static long DeliverVideoData(long j, long j2, byte[] bArr, long j3, int i, int[] iArr, int i2) {
        notifyBiteRateInfo(j2, bArr);
        HardDecodeWay hardDecodeWay = streamIdDecoderMap.get(Long.valueOf(j2));
        if (hardDecodeWay != null) {
            return hardDecodeWay.OnVideoDataArrived(bArr, j3, new VideoConstant.ExtraData(iArr, i2));
        }
        YMFLog.error((Object) null, "[Decoder ]", "HardDecodeWay with streamId:" + j2 + " not found");
        return 0L;
    }

    public static void VideoStreamEnd(long j) {
        YMFLog.info(null, "[Decoder ]", "VideoStreamEnd HardDecodeWay count:" + streamIdDecoderMap.size() + ", remove streamId:" + j);
        HardDecodeWay hardDecodeWay = streamIdDecoderMap.get(Long.valueOf(j));
        if (hardDecodeWay != null) {
            hardDecodeWay.OnStreamEnd();
            hardDecodeWay.Quit();
            streamIdDecoderMap.remove(Long.valueOf(j));
            HardDecoderPool.ReturnDecoder(GetNewHardDecodeWay());
        } else {
            YMFLog.error((Object) null, "[Decoder ]", "VideoStreamEnd fatal error! HardDecodeWay not found, streamId:" + j);
        }
        if (mYUVDecodeMode) {
            YMFEventManager.instance().notifyStreamEnd(j);
        }
    }

    public static boolean IsHardDecoderAvailable(int i) {
        if (1 == i) {
            return H265DecRender.IsAvailable();
        }
        if (i == 0) {
            return H264DecRender.IsAvailable();
        }
        if (2 == i) {
            return VP8DecRender.IsAvailable();
        }
        return false;
    }

    public static boolean IsDecoderNeedReconfig(long j) {
        HardDecodeWay hardDecodeWay = streamIdDecoderMap.get(Long.valueOf(j));
        if (hardDecodeWay != null) {
            return hardDecodeWay.IsDecoderNeedReconfig();
        }
        return false;
    }

    public static void ChooseHardDecoderStaff(HardDecoderStaffVersion hardDecoderStaffVersion) {
        YMFLog.info(null, "[Decoder ]", "ChooseHardDecoderStaff hardDecoderStaffVersion:" + hardDecoderStaffVersion);
        currentHardDecoderStaffVersion = hardDecoderStaffVersion;
    }

    public static HardDecoderStaffVersion GetCurrentHardDecoderStaffVersion() {
        return currentHardDecoderStaffVersion;
    }

    public static HardDecodeWay GetNewHardDecodeWay() {
        HardDecodeWay hardDecodeWayGpu;
        YMFLog.info(null, "[Decoder ]", "GetNewHardDecodeWay version:" + currentHardDecoderStaffVersion);
        if (currentHardDecoderStaffVersion == HardDecoderStaffVersion.SIMPLIFIED) {
            hardDecodeWayGpu = new HardDecodeWaySimplified();
        } else if (currentHardDecoderStaffVersion == HardDecoderStaffVersion.YUVBUFFER) {
            hardDecodeWayGpu = new HardDecodeWayBuffer();
        } else {
            hardDecodeWayGpu = new HardDecodeWayGpu();
        }
        hardDecodeWayGpu.Start();
        return hardDecodeWayGpu;
    }
}
