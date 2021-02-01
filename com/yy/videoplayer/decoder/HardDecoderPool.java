package com.yy.videoplayer.decoder;

import com.yy.videoplayer.decoder.VideoDecoderCenterExt;
import com.yy.videoplayer.utils.YMFLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes4.dex */
public class HardDecoderPool {
    private static final String TAG = "HardDecoderPool";
    static int mInitialCapacity;
    static ConcurrentLinkedQueue<HardDecodeWay> mUnused = new ConcurrentLinkedQueue<>();

    public static HardDecodeWay BorrowDecoder() {
        return mUnused.poll();
    }

    public static HardDecodeWay BorrowOrCreateDecoderByType(VideoDecoderCenterExt.HardDecoderStaffVersion hardDecoderStaffVersion) {
        int size = mUnused.size();
        do {
            HardDecodeWay BorrowDecoder = BorrowDecoder();
            size--;
            if (BorrowDecoder == null) {
                break;
            } else if (BorrowDecoder.getHardDecodeType() == hardDecoderStaffVersion) {
                return BorrowDecoder;
            } else {
                ReturnDecoder(BorrowDecoder);
            }
        } while (size > 0);
        VideoDecoderCenterExt.ChooseHardDecoderStaff(hardDecoderStaffVersion);
        return VideoDecoderCenterExt.GetNewHardDecodeWay();
    }

    public static void ReturnDecoder(HardDecodeWay hardDecodeWay) {
        mUnused.offer(hardDecodeWay);
        YMFLog.info(null, "[Decoder ]", "ReturnDecoder, mUnused size:" + mUnused.size());
    }

    public static void Initialize(int i) {
        mInitialCapacity = i;
        for (int i2 = 0; i2 < i; i2++) {
            mUnused.offer(VideoDecoderCenterExt.GetNewHardDecodeWay());
        }
    }

    public static void Release() {
        Iterator<HardDecodeWay> it = mUnused.iterator();
        while (it.hasNext()) {
            it.next().Quit();
        }
        mUnused.clear();
    }
}
