package com.yy.videoplayer;

import com.baidu.mobstat.Config;
import com.yy.videoplayer.decoder.HardDecodeWay;
import com.yy.videoplayer.decoder.HardDecodeWayBuffer;
import com.yy.videoplayer.decoder.HardDecodeWaySimplified;
import com.yy.videoplayer.decoder.YYVideoLibMgr;
import com.yy.videoplayer.render.YMFImageBuffer;
import com.yy.videoplayer.stat.YMFPlayerStatisticManager;
import com.yy.videoplayer.utils.ByteVector;
import com.yy.videoplayer.utils.TimeUtil;
import com.yy.videoplayer.utils.YMFLog;
import com.yy.videoplayer.view.YMFPlayerController;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes4.dex */
public class YMFStreamManager {
    private static final String TAG = "YMFStreamManager";
    private static IYMFDecoderListener mDecoderListener;
    private static final byte[] SYNC_FLAG = new byte[1];
    private static YMFStreamManager mInstance = null;
    private static ConcurrentLinkedQueue<IYMFDecoderListener> mDecoderListeners = new ConcurrentLinkedQueue<>();
    private static ConcurrentHashMap<Long, HardDecodeWay> mStreamHardDecoderMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Long, YMFImageBuffer> mStreamImageMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Long, ByteVector> mStreamImagePushOutMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Long, ArrayList<VideoRenderNotify>> mStreamVideoRenderNotifysMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Long, VideoSsrcStruct> mStreamInputSsrcMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Long, Integer> mStreamLastSsrcMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Long, Boolean> mStreamFirstIgnoreMap = new ConcurrentHashMap<>();
    private static boolean mIgnoreStatistic = false;
    private static boolean mFirstPushOut = false;
    private static boolean mLastPushOut = false;
    private static ConcurrentHashMap<Long, Boolean> mStreamVideoPlayRenderMap = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class VideoSsrcStruct {
        public long pts;
        public int ssrc;

        public VideoSsrcStruct(int i, long j) {
            this.ssrc = i;
            this.pts = j;
        }
    }

    public static YMFStreamManager instance() {
        if (mInstance == null) {
            synchronized (SYNC_FLAG) {
                if (mInstance == null) {
                    mInstance = new YMFStreamManager();
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkRenderOrNotify(long j, YMFImageBuffer yMFImageBuffer) {
        VideoSsrcStruct videoSsrcStruct;
        synchronized (mStreamInputSsrcMap) {
            videoSsrcStruct = mStreamInputSsrcMap.get(Long.valueOf(j)) == null ? new VideoSsrcStruct(-1, -1L) : mStreamInputSsrcMap.get(Long.valueOf(j));
            if (yMFImageBuffer.mSsrc == 0) {
                yMFImageBuffer.mNeedRendered = true;
                yMFImageBuffer.mNotifyRenderInfo = true;
                yMFImageBuffer.mIgnore = false;
            } else if (yMFImageBuffer.mSsrc == 1) {
                yMFImageBuffer.mNeedRendered = false;
                yMFImageBuffer.mNotifyRenderInfo = false;
                yMFImageBuffer.mIgnore = false;
                mStreamFirstIgnoreMap.put(Long.valueOf(j), true);
            } else if (videoSsrcStruct.ssrc == -1) {
                yMFImageBuffer.mNeedRendered = true;
                yMFImageBuffer.mNotifyRenderInfo = true;
                yMFImageBuffer.mIgnore = false;
            } else if (mStreamLastSsrcMap.get(Long.valueOf(yMFImageBuffer.mStreamId)) != null && mStreamLastSsrcMap.get(Long.valueOf(yMFImageBuffer.mStreamId)).intValue() != yMFImageBuffer.mSsrc) {
                yMFImageBuffer.mNeedRendered = true;
                yMFImageBuffer.mNotifyRenderInfo = true;
                yMFImageBuffer.mIgnore = true;
            } else if (videoSsrcStruct.ssrc != yMFImageBuffer.mSsrc) {
                yMFImageBuffer.mNeedRendered = false;
                yMFImageBuffer.mNotifyRenderInfo = false;
                yMFImageBuffer.mIgnore = false;
                mStreamFirstIgnoreMap.put(Long.valueOf(j), true);
            } else if (mStreamFirstIgnoreMap.get(Long.valueOf(j)) != null) {
                mStreamFirstIgnoreMap.remove(Long.valueOf(j));
                yMFImageBuffer.mNeedRendered = true;
                yMFImageBuffer.mNotifyRenderInfo = true;
                yMFImageBuffer.mIgnore = true;
            } else {
                yMFImageBuffer.mNeedRendered = true;
                yMFImageBuffer.mNotifyRenderInfo = true;
                yMFImageBuffer.mIgnore = false;
            }
            if (yMFImageBuffer.mNeedRendered) {
                mStreamLastSsrcMap.put(Long.valueOf(yMFImageBuffer.mStreamId), Integer.valueOf(yMFImageBuffer.mSsrc));
            }
            if (yMFImageBuffer.mIgnore) {
                yMFImageBuffer.mMultiIgnoreState = true;
            } else {
                yMFImageBuffer.mMultiIgnoreState = false;
            }
        }
        if (!yMFImageBuffer.mNeedRendered || !yMFImageBuffer.mNotifyRenderInfo || yMFImageBuffer.mIgnore) {
            YMFLog.info(null, TAG, " ssrc in " + videoSsrcStruct.ssrc + "!=" + yMFImageBuffer.mSsrc + ",pts " + yMFImageBuffer.mPts + " " + yMFImageBuffer.mNeedRendered + "," + yMFImageBuffer.mNotifyRenderInfo + "," + yMFImageBuffer.mIgnore);
        }
    }

    private YMFStreamManager() {
        mDecoderListener = new IYMFDecoderListener() { // from class: com.yy.videoplayer.YMFStreamManager.1
            @Override // com.yy.videoplayer.IYMFDecoderListener
            public void onDecodedFrameAvailable(long j, YMFImageBuffer yMFImageBuffer) {
                YMFStreamManager.checkRenderOrNotify(j, yMFImageBuffer);
                synchronized (YMFStreamManager.mDecoderListeners) {
                    Iterator it = YMFStreamManager.mDecoderListeners.iterator();
                    while (it.hasNext()) {
                        ((IYMFDecoderListener) it.next()).onDecodedFrameAvailable(j, yMFImageBuffer);
                    }
                }
            }

            @Override // com.yy.videoplayer.IYMFDecoderListener
            public void onDecodeStreamStart(long j, YMFImageBuffer yMFImageBuffer) {
            }

            @Override // com.yy.videoplayer.IYMFDecoderListener
            public void onDecodeStreamEnd(long j, YMFImageBuffer yMFImageBuffer) {
            }
        };
    }

    public void addStream(long j, HardDecodeWay hardDecodeWay) {
        mStreamHardDecoderMap.put(Long.valueOf(j), hardDecodeWay);
        if (hardDecodeWay instanceof HardDecodeWayBuffer) {
            ((HardDecodeWayBuffer) hardDecodeWay).setDecoderListener(mDecoderListener);
        }
        if (hardDecodeWay instanceof HardDecodeWaySimplified) {
            ((HardDecodeWaySimplified) hardDecodeWay).setDecoderListener(mDecoderListener);
        }
    }

    public void removeStream(long j) {
        Iterator<Map.Entry<Long, HardDecodeWay>> it = mStreamHardDecoderMap.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().longValue() == j) {
                mStreamHardDecoderMap.remove(Long.valueOf(j));
            }
        }
    }

    public void registerListener(IYMFDecoderListener iYMFDecoderListener) {
        synchronized (mDecoderListeners) {
            if (!mDecoderListeners.contains(iYMFDecoderListener)) {
                mDecoderListeners.add(iYMFDecoderListener);
            }
        }
        YMFLog.info(TAG, "[Decoder ]", "registerListener," + mDecoderListeners.size());
    }

    public void unregisterListener(IYMFDecoderListener iYMFDecoderListener) {
        synchronized (mDecoderListeners) {
            if (mDecoderListeners.contains(iYMFDecoderListener)) {
                mDecoderListeners.remove(iYMFDecoderListener);
            }
        }
        YMFLog.info(TAG, "[Decoder ]", "unRegisterListener," + mDecoderListeners.size());
    }

    public static ByteBuffer mallocBytebuffer(long j, int i, int i2) {
        if (mStreamImageMap.containsKey(Long.valueOf(j))) {
            YMFImageBuffer yMFImageBuffer = mStreamImageMap.get(Long.valueOf(j));
            if (yMFImageBuffer.mWidth == i && yMFImageBuffer.mHeight == i2) {
                return yMFImageBuffer.mData;
            }
            yMFImageBuffer.mData = null;
            mStreamImageMap.remove(Long.valueOf(j));
        }
        YMFLog.info(TAG, "[Decoder ]", "mallocBytebuffer," + j + "," + i + Config.EVENT_HEAT_X + i2);
        YMFImageBuffer yMFImageBuffer2 = new YMFImageBuffer(i, i2, 2, true);
        if (yMFImageBuffer2.mData != null) {
            mStreamImageMap.put(Long.valueOf(j), yMFImageBuffer2);
        } else {
            YMFLog.error((Object) null, "[Decoder ]", "mallocBytebuffer error~. buffer.mData == null.");
        }
        return yMFImageBuffer2.mData;
    }

    public static void notifyDecodedFrameSsrc(long j, int i, long j2) {
        synchronized (mStreamInputSsrcMap) {
            VideoSsrcStruct videoSsrcStruct = mStreamInputSsrcMap.get(Long.valueOf(j));
            if (videoSsrcStruct == null) {
                videoSsrcStruct = new VideoSsrcStruct(-1, -1L);
            } else {
                videoSsrcStruct.pts = j2;
                videoSsrcStruct.ssrc = i;
            }
            mStreamInputSsrcMap.put(Long.valueOf(j), videoSsrcStruct);
        }
    }

    public static boolean checkIfStreamRenderedBySdk(long j) {
        synchronized (mDecoderListeners) {
            Iterator<IYMFDecoderListener> it = mDecoderListeners.iterator();
            while (it.hasNext()) {
                if (((YMFPlayerController) it.next()).findRenderImageByStreamId(j) != null) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void onSoftDecodedFrameArrived(long j, int i, int[] iArr, int i2, int i3, long j2, boolean z, int i4) {
        YMFImageBuffer yMFImageBuffer = mStreamImageMap.get(Long.valueOf(j));
        if (yMFImageBuffer != null && i >= 0) {
            if (yMFImageBuffer.mWidth != i2 || yMFImageBuffer.mHeight != i3) {
                YMFLog.error((Object) null, "[Decoder ]", "Image buffer size un-match !, image:" + yMFImageBuffer.mWidth + Config.EVENT_HEAT_X + yMFImageBuffer.mHeight + " decoder:" + i2 + Config.EVENT_HEAT_X + i3);
                return;
            }
            yMFImageBuffer.mDts = TimeUtil.getTickCountLong();
            yMFImageBuffer.mPts = j2;
            yMFImageBuffer.mStreamId = j;
            int i5 = 0;
            int i6 = i2 - 1;
            int i7 = 0;
            int i8 = i3 - 1;
            boolean z2 = false;
            if (iArr != null && iArr.length >= 4 && iArr[0] >= 0 && iArr[1] >= 0 && iArr[2] > 0 && iArr[3] > 0) {
                i5 = iArr[0];
                i6 = (iArr[2] + i5) - 1;
                i7 = iArr[1];
                i8 = (iArr[3] + i7) - 1;
                z2 = true;
            }
            yMFImageBuffer.mCropLeft = i5;
            yMFImageBuffer.mCropRight = i6;
            yMFImageBuffer.mCropTop = i7;
            yMFImageBuffer.mCropBottom = i8;
            if (yMFImageBuffer.mClipWindow != z2) {
                yMFImageBuffer.mChangeRenderMode = true;
            } else {
                yMFImageBuffer.mChangeRenderMode = false;
            }
            yMFImageBuffer.mClipWindow = z2;
            yMFImageBuffer.mNeedRendered = true;
            yMFImageBuffer.mSsrc = i4;
            checkRenderOrNotify(j, yMFImageBuffer);
            synchronized (mStreamImagePushOutMap) {
                if (z) {
                    int i9 = ((yMFImageBuffer.mWidth * yMFImageBuffer.mHeight) * 3) / 2;
                    ByteVector byteVector = mStreamImagePushOutMap.get(Long.valueOf(j));
                    if (byteVector == null) {
                        byteVector = new ByteVector(i9);
                        mStreamImagePushOutMap.put(Long.valueOf(j), byteVector);
                    }
                    boolean z3 = false;
                    try {
                        yMFImageBuffer.tryLockData();
                        byteVector.reserve(i9);
                        yMFImageBuffer.mData.rewind();
                        if (yMFImageBuffer.mData.limit() >= i9) {
                            yMFImageBuffer.mData.get(byteVector.getBytes(), 0, i9);
                        } else {
                            z3 = true;
                            YMFLog.error((Object) null, TAG, "byte limit: " + yMFImageBuffer.mData.limit() + ", videoSize: " + i9 + ", w: " + yMFImageBuffer.mWidth + ",h:" + yMFImageBuffer.mHeight);
                        }
                        yMFImageBuffer.tryUnlockData();
                    } catch (Exception e) {
                        e.printStackTrace();
                        yMFImageBuffer.tryUnlockData();
                        z3 = true;
                    }
                    if (mFirstPushOut) {
                        mIgnoreStatistic = true;
                    }
                    if (!z3) {
                        onSoftDecodedFramePushOut(j, byteVector.getBytes());
                    }
                }
                if (yMFImageBuffer != null) {
                    YMFEventManager.instance().notifyDecoderEvent(j, yMFImageBuffer.mPts);
                }
                synchronized (mDecoderListeners) {
                    Iterator<IYMFDecoderListener> it = mDecoderListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onDecodedFrameAvailable(j, yMFImageBuffer);
                    }
                }
                mFirstPushOut = !z;
            }
        }
    }

    public HardDecodeWayBuffer getDecoderWithStreamId(long j) {
        HardDecodeWay hardDecodeWay;
        synchronized (mStreamHardDecoderMap) {
            Iterator<Map.Entry<Long, HardDecodeWay>> it = mStreamHardDecoderMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    hardDecodeWay = null;
                    break;
                } else if (it.next().getKey().longValue() == j) {
                    hardDecodeWay = mStreamHardDecoderMap.get(Long.valueOf(j));
                    break;
                }
            }
            if (hardDecodeWay instanceof HardDecodeWayBuffer) {
                return (HardDecodeWayBuffer) hardDecodeWay;
            }
            return null;
        }
    }

    private static void onSoftDecodedFramePushOut(long j, byte[] bArr) {
        YMFImageBuffer yMFImageBuffer = mStreamImageMap.get(Long.valueOf(j));
        if (yMFImageBuffer != null && yMFImageBuffer.mWidth != 0 && yMFImageBuffer.mHeight != 0 && bArr != null) {
            int i = ((yMFImageBuffer.mWidth * yMFImageBuffer.mHeight) * 3) / 2;
            ArrayList<VideoRenderNotify> arrayList = mStreamVideoRenderNotifysMap.get(Long.valueOf(j));
            ArrayList<VideoRenderNotify> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
            long currentTimeMillis = System.currentTimeMillis();
            YYVideoLibMgr.instance().onDecodedFrameData(j, yMFImageBuffer.mWidth, yMFImageBuffer.mHeight, bArr, i, yMFImageBuffer.mPts);
            if (!checkIfStreamRenderedBySdk(j) && mStreamVideoPlayRenderMap.get(Long.valueOf(j)) != null && !mStreamVideoPlayRenderMap.get(Long.valueOf(j)).booleanValue()) {
                long tickCountLong = TimeUtil.getTickCountLong();
                arrayList2.add(new VideoRenderNotify(0L, j, yMFImageBuffer.mPts, tickCountLong, tickCountLong, mIgnoreStatistic));
                if (mIgnoreStatistic) {
                    YMFLog.info(TAG, "[Decoder ]", "IgnoreStat mStreamId:" + j + " pts:" + yMFImageBuffer.mPts);
                    mIgnoreStatistic = false;
                }
                YYVideoLibMgr.instance().onVideoRenderNotify(arrayList2);
                arrayList2.clear();
                YMFPlayerStatisticManager.getInstance().setRenderFrameCount(yMFImageBuffer.mStreamId, 1);
                YMFPlayerStatisticManager.getInstance().setRenderTimeStamp(yMFImageBuffer.mStreamId, System.currentTimeMillis(), yMFImageBuffer.mPts);
                YMFPlayerStatisticManager.getInstance().setRenderLatency(yMFImageBuffer.mStreamId, (int) (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public static void onStreamStart(long j) {
        if (mStreamImageMap.containsKey(Long.valueOf(j))) {
            mStreamImageMap.get(Long.valueOf(j)).mStreamStart = true;
            synchronized (mDecoderListeners) {
                Iterator<IYMFDecoderListener> it = mDecoderListeners.iterator();
                while (it.hasNext()) {
                    it.next().onDecodeStreamStart(j, mStreamImageMap.get(Long.valueOf(j)));
                }
            }
            YMFLog.info(TAG, "[Decoder ]", "onStreamStart," + j);
        }
        mStreamVideoPlayRenderMap.put(Long.valueOf(j), false);
        YMFEventManager.instance().notifyStreamStart(j);
    }

    public static void onStreamEnd(long j) {
        try {
            if (mStreamImageMap.containsKey(Long.valueOf(j))) {
                mStreamImageMap.get(Long.valueOf(j)).mStreamStart = false;
                synchronized (mDecoderListeners) {
                    Iterator<IYMFDecoderListener> it = mDecoderListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onDecodeStreamEnd(j, mStreamImageMap.get(Long.valueOf(j)));
                    }
                }
                YMFLog.info(TAG, "[Decoder ]", "onStreamEnd," + j);
                mStreamImageMap.remove(Long.valueOf(j));
            }
            synchronized (mStreamInputSsrcMap) {
                mStreamInputSsrcMap.remove(Long.valueOf(j));
                mStreamLastSsrcMap.remove(Long.valueOf(j));
            }
            mStreamVideoPlayRenderMap.remove(Long.valueOf(j));
            synchronized (mStreamImagePushOutMap) {
                ByteVector byteVector = mStreamImagePushOutMap.get(Long.valueOf(j));
                if (byteVector != null) {
                    mStreamImagePushOutMap.remove(Long.valueOf(j));
                    byteVector.release();
                }
                mStreamVideoRenderNotifysMap.remove(Long.valueOf(j));
            }
            YMFEventManager.instance().notifyStreamEnd(j);
            YMFPlayerStatisticManager.getInstance().clean(j);
        } catch (Exception e) {
            YMFLog.error((Object) null, TAG, " onStreamEnd :" + e.toString());
        }
    }
}
