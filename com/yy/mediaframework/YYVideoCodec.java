package com.yy.mediaframework;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import com.yy.mediaframework.stat.VideoDataStatistic;
import com.yy.mediaframework.utils.YMFLog;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class YYVideoCodec {
    public static final int IFRAME_INTERVAL = 3;
    public static final String MIME_H264 = "video/avc";
    public static final String MIME_H265 = "video/hevc";
    public static final String TAG = "YYVideoCodec";
    private static String mEncoderName;
    private static String mEncoderH264Name = "";
    private static String mEncoderH265Name = "";
    private static Object mLock = new Object();
    private static AtomicReference<Integer> mSupportH264 = new AtomicReference<>(-1);
    private static AtomicReference<Integer> mSupportH265 = new AtomicReference<>(-1);
    private static AtomicReference<String> mCurrentEncodeName = new AtomicReference<>("noEncoder");

    /* loaded from: classes6.dex */
    public static class EncodeSupport {
        public static final int DEFAULT = -1;
        public static final int SUPPORTED = 1;
        public static final int UNSUPPORTED = 0;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [86=4] */
    @android.annotation.TargetApi(18)
    private static boolean testVideoEncoderCrash(java.lang.String r10) {
        /*
            r1 = 1
            r3 = 0
            r0 = 0
            r2 = 720(0x2d0, float:1.009E-42)
            r4 = 1280(0x500, float:1.794E-42)
            android.media.MediaFormat r2 = android.media.MediaFormat.createVideoFormat(r10, r2, r4)     // Catch: java.lang.Throwable -> L183
            java.lang.String r4 = "color-format"
            r5 = 2130708361(0x7f000789, float:1.701803E38)
            r2.setInteger(r4, r5)     // Catch: java.lang.Throwable -> L183
            java.lang.String r4 = "bitrate"
            r5 = 2000000(0x1e8480, float:2.802597E-39)
            r2.setInteger(r4, r5)     // Catch: java.lang.Throwable -> L183
            java.lang.String r4 = "frame-rate"
            r5 = 30
            r2.setInteger(r4, r5)     // Catch: java.lang.Throwable -> L183
            java.lang.String r4 = "i-frame-interval"
            r5 = 3
            r2.setInteger(r4, r5)     // Catch: java.lang.Throwable -> L183
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L183
            r5 = 21
            if (r4 < r5) goto L39
            java.lang.String r4 = "bitrate-mode"
            r5 = 2
            r2.setInteger(r4, r5)     // Catch: java.lang.Throwable -> L183
        L39:
            r4 = 0
            java.lang.String r5 = "[Encoder ]"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L183
            r6.<init>()     // Catch: java.lang.Throwable -> L183
            java.lang.String r7 = "testVideoEncoder mime:"
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L183
            java.lang.StringBuilder r6 = r6.append(r10)     // Catch: java.lang.Throwable -> L183
            java.lang.String r7 = ", MediaCodec format:"
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L183
            java.lang.StringBuilder r6 = r6.append(r2)     // Catch: java.lang.Throwable -> L183
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L183
            com.yy.mediaframework.utils.YMFLog.info(r4, r5, r6)     // Catch: java.lang.Throwable -> L183
            android.media.MediaCodec r4 = android.media.MediaCodec.createEncoderByType(r10)     // Catch: java.lang.Throwable -> L183
            java.lang.String r5 = r4.getName()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r6 = "video/avc"
            boolean r6 = r10.equals(r6)     // Catch: java.lang.Throwable -> Lbf
            if (r6 == 0) goto Lb3
            com.yy.mediaframework.YYVideoCodec.mEncoderH264Name = r5     // Catch: java.lang.Throwable -> Lbf
        L72:
            r6 = 0
            java.lang.String r7 = "[Encoder ]"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbf
            r8.<init>()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r9 = "testVideoEncoder mime:"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch: java.lang.Throwable -> Lbf
            java.lang.StringBuilder r8 = r8.append(r10)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r9 = ", MediaCodec encoder:"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch: java.lang.Throwable -> Lbf
            java.lang.StringBuilder r5 = r8.append(r5)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lbf
            com.yy.mediaframework.utils.YMFLog.info(r6, r7, r5)     // Catch: java.lang.Throwable -> Lbf
            r5 = 0
            r6 = 0
            r7 = 1
            r4.configure(r2, r5, r6, r7)     // Catch: java.lang.Throwable -> Lbf
            android.view.Surface r2 = r4.createInputSurface()     // Catch: java.lang.Throwable -> Lbf
            r4.start()     // Catch: java.lang.Throwable -> L188
            if (r4 == 0) goto Lb2
            if (r2 == 0) goto Lac
            r2.release()     // Catch: java.lang.Throwable -> Lf6
        Lac:
            r4.stop()     // Catch: java.lang.Throwable -> Lf6
            r4.release()     // Catch: java.lang.Throwable -> Lf6
        Lb2:
            return r0
        Lb3:
            java.lang.String r6 = "video/hevc"
            boolean r6 = r10.equals(r6)     // Catch: java.lang.Throwable -> Lbf
            if (r6 == 0) goto L72
            com.yy.mediaframework.YYVideoCodec.mEncoderH265Name = r5     // Catch: java.lang.Throwable -> Lbf
            goto L72
        Lbf:
            r0 = move-exception
            r2 = r3
        Lc1:
            r5 = 0
            java.lang.String r6 = "[Encoder ]"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L181
            r7.<init>()     // Catch: java.lang.Throwable -> L181
            java.lang.String r8 = "testVideoEncoderCrash, mime:"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch: java.lang.Throwable -> L181
            java.lang.StringBuilder r7 = r7.append(r10)     // Catch: java.lang.Throwable -> L181
            java.lang.String r8 = ", reason:"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch: java.lang.Throwable -> L181
            java.lang.StringBuilder r0 = r7.append(r0)     // Catch: java.lang.Throwable -> L181
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L181
            com.yy.mediaframework.utils.YMFLog.error(r5, r6, r0)     // Catch: java.lang.Throwable -> L181
            if (r4 == 0) goto L18b
            if (r2 == 0) goto Lee
            r2.release()     // Catch: java.lang.Throwable -> L11d
        Lee:
            r4.stop()     // Catch: java.lang.Throwable -> L11d
            r4.release()     // Catch: java.lang.Throwable -> L11d
            r0 = r1
            goto Lb2
        Lf6:
            r1 = move-exception
            java.lang.String r2 = "[Encoder ]"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "release test encoder error! mime:"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r10)
            java.lang.String r5 = ", reason:"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r1 = r4.append(r1)
            java.lang.String r1 = r1.toString()
            com.yy.mediaframework.utils.YMFLog.error(r3, r2, r1)
            goto Lb2
        L11d:
            r0 = move-exception
            java.lang.String r2 = "[Encoder ]"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "release test encoder error! mime:"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r10)
            java.lang.String r5 = ", reason:"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.String r0 = r0.toString()
            com.yy.mediaframework.utils.YMFLog.error(r3, r2, r0)
            r0 = r1
            goto Lb2
        L146:
            r0 = move-exception
            r2 = r3
            r4 = r3
        L149:
            if (r4 == 0) goto L156
            if (r2 == 0) goto L150
            r2.release()     // Catch: java.lang.Throwable -> L157
        L150:
            r4.stop()     // Catch: java.lang.Throwable -> L157
            r4.release()     // Catch: java.lang.Throwable -> L157
        L156:
            throw r0
        L157:
            r1 = move-exception
            java.lang.String r2 = "[Encoder ]"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "release test encoder error! mime:"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r10)
            java.lang.String r5 = ", reason:"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r1 = r4.append(r1)
            java.lang.String r1 = r1.toString()
            com.yy.mediaframework.utils.YMFLog.error(r3, r2, r1)
            goto L156
        L17e:
            r0 = move-exception
            r2 = r3
            goto L149
        L181:
            r0 = move-exception
            goto L149
        L183:
            r0 = move-exception
            r2 = r3
            r4 = r3
            goto Lc1
        L188:
            r0 = move-exception
            goto Lc1
        L18b:
            r0 = r1
            goto Lb2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yy.mediaframework.YYVideoCodec.testVideoEncoderCrash(java.lang.String):boolean");
    }

    public static void testSupportH264Encode() {
        synchronized (mLock) {
            boolean isH264EncoderSupport = isH264EncoderSupport();
            boolean testVideoEncoderCrash = testVideoEncoderCrash("video/avc");
            if (isH264EncoderSupport && !testVideoEncoderCrash) {
                mSupportH264.set(1);
                YMFLog.info(TAG, "[Encoder ]", "testVideoEncoderSupport h264 isSupportH264:" + isH264EncoderSupport + " isSupportH264 " + testVideoEncoderCrash + " mSupportH264 " + mSupportH264.get());
            } else {
                mSupportH264.set(0);
                YMFLog.info(TAG, "[Encoder ]", "testVideoEncoderSupport h264 isSupportH264:" + isH264EncoderSupport + " h264Crashed " + testVideoEncoderCrash + " mSupportH264 " + mSupportH264.get());
            }
        }
    }

    public static void testSupportH265Encode() {
        synchronized (mLock) {
            boolean z = Build.VERSION.SDK_INT >= 18;
            boolean isH265EncoderSupport = isH265EncoderSupport();
            boolean testVideoEncoderCrash = testVideoEncoderCrash("video/hevc");
            if (isH265EncoderSupport && !testVideoEncoderCrash && z) {
                mSupportH265.set(1);
                YMFLog.info(TAG, "[Encoder ]", "testVideoEncoderSupport h265 isSupportH265:" + isH265EncoderSupport + " h265Crashed " + testVideoEncoderCrash + " mSupportH265 " + mSupportH265.get());
            } else {
                mSupportH265.set(0);
                YMFLog.info(TAG, "[Encoder ]", "testVideoEncoderSupport h265 isSupportH265:" + isH265EncoderSupport + " h265Crashed " + testVideoEncoderCrash + " mSupportH265 " + mSupportH265.get());
            }
        }
    }

    public static int getSupportH264() {
        return mSupportH264.get().intValue();
    }

    public static int getSupportH265() {
        if (mSupportH265.get().intValue() == -1) {
            testSupportH265Encode();
        }
        return mSupportH265.get().intValue();
    }

    public static int getSupportH265Property() {
        return mSupportH265.get().intValue();
    }

    public static String getH264EncodeName() {
        return mEncoderH264Name;
    }

    public static String getH265EncodeName() {
        return mEncoderH265Name;
    }

    public static void setCurrentEncodeName(String str) {
        mCurrentEncodeName.set(str);
    }

    public static String getCurrentEncodeName() {
        return mCurrentEncodeName.get();
    }

    public static void resetCurrentEncodeName() {
        mCurrentEncodeName.set("noEncoder");
    }

    public static boolean isH265EncoderSupport() {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            String name = codecInfoAt.getName();
            boolean isEncoder = codecInfoAt.isEncoder();
            if (name != null && isEncoder && name.contains(VideoDataStatistic.AnchorHiidoAssistantStatisticKey.H265SupportInfo) && !isSWCodec(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isH264EncoderSupport() {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            String name = codecInfoAt.getName();
            boolean isEncoder = codecInfoAt.isEncoder();
            if (name != null && isEncoder && name.contains("avc") && !isSWCodec(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSWCodec(String str) {
        return str.startsWith("OMX.google.") || !str.startsWith("OMX.");
    }
}
