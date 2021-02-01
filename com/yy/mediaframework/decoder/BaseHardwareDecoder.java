package com.yy.mediaframework.decoder;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import androidx.annotation.NonNull;
import com.kwai.video.player.misc.IMediaFormat;
import com.yy.mediaframework.model.DecodeVideoConfig;
import com.yy.mediaframework.model.DecodeVideoSample;
import com.yy.mediaframework.model.YYPeripheralsVideoSampleAllocator;
import com.yy.mediaframework.utils.YMFLog;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes4.dex */
public class BaseHardwareDecoder extends BaseDecoder {
    private static final byte[] SYNC_FLAG = new byte[1];
    protected boolean isInited;
    protected MediaCodec.BufferInfo mBufferInfo;
    protected MediaCodec mDecoder;
    protected MediaFormat mDecoderFormat;
    private byte[] mHeader;
    protected ByteBuffer[] mInputBuffers;
    private int mNoFrameCnt;
    private OnDecoderSizeChangeListener mOnDecoderSizeChangeListener;
    private OnDecoderYUVListener mOnDecoderYUVListener;
    protected ByteBuffer[] mOutputBuffers;
    private Boolean mSupportFlexible;

    /* loaded from: classes4.dex */
    public interface OnDecoderSizeChangeListener {
        void onDecoderSizeChanged(int i, int i2);
    }

    /* loaded from: classes4.dex */
    public interface OnDecoderYUVListener {
        void OnDecoderError();

        void OnDecoderYUVListener(int i, int i2, ByteBuffer byteBuffer, Image image, int i3, long j, int i4);

        boolean onVerifyPts(long j);
    }

    public BaseHardwareDecoder(@NonNull int i, @NonNull int i2, @NonNull String str, @NonNull String str2) {
        super(i, i2, str, str2);
        this.isInited = false;
        this.mNoFrameCnt = 0;
        this.mSupportFlexible = false;
        this.mHeader = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4, 122=4, 123=4, 124=4] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ef A[Catch: all -> 0x0201, TryCatch #0 {, blocks: (B:4:0x0013, B:6:0x002c, B:9:0x003d, B:11:0x004d, B:13:0x0053, B:30:0x012d, B:31:0x0142, B:38:0x016f, B:40:0x0173, B:57:0x01ef, B:59:0x01f3, B:60:0x0200, B:64:0x0204, B:45:0x01a5, B:47:0x01a9, B:51:0x01d7, B:53:0x01db, B:8:0x0036, B:14:0x0073, B:16:0x0077, B:34:0x0146, B:19:0x00a3, B:21:0x00a7, B:23:0x00ad, B:25:0x00bf, B:27:0x00c3, B:28:0x00ca, B:29:0x00ec, B:18:0x007f), top: B:71:0x0013, inners: #1, #3, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0204 A[Catch: all -> 0x0201, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0013, B:6:0x002c, B:9:0x003d, B:11:0x004d, B:13:0x0053, B:30:0x012d, B:31:0x0142, B:38:0x016f, B:40:0x0173, B:57:0x01ef, B:59:0x01f3, B:60:0x0200, B:64:0x0204, B:45:0x01a5, B:47:0x01a9, B:51:0x01d7, B:53:0x01db, B:8:0x0036, B:14:0x0073, B:16:0x0077, B:34:0x0146, B:19:0x00a3, B:21:0x00a7, B:23:0x00ad, B:25:0x00bf, B:27:0x00c3, B:28:0x00ca, B:29:0x00ec, B:18:0x007f), top: B:71:0x0013, inners: #1, #3, #5 }] */
    @Override // com.yy.mediaframework.decoder.BaseDecoder
    @TargetApi(18)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int initDecoder(DecodeVideoConfig decodeVideoConfig) {
        int i = 2135033992;
        boolean z = true;
        YMFLog.info(this, "[Decoder ]", "init decoder.");
        synchronized (SYNC_FLAG) {
            this.mDecodeVideoConfig = decodeVideoConfig;
            this.mDecoderFormat = MediaFormat.createVideoFormat(this.mCodecType, this.mDecodeWidth, this.mDecodeHeight);
            String.valueOf(decodeVideoConfig.spspps);
            if (this.mDecodeVideoConfig.mCodecType == null || this.mDecodeVideoConfig.mCodecType.isEmpty()) {
                this.mDecodeVideoConfig.mCodecType = "video/avc";
            }
            this.mDecoderFormat.setString(IMediaFormat.KEY_MIME, decodeVideoConfig.mCodecType);
            if (this.mDecodeVideoConfig.sps != null && this.mDecodeVideoConfig.pps != null) {
                this.mDecoderFormat.setByteBuffer("csd-0", ByteBuffer.wrap(this.mDecodeVideoConfig.sps));
                this.mDecoderFormat.setByteBuffer("csd-1", ByteBuffer.wrap(this.mDecodeVideoConfig.pps));
            }
            try {
                try {
                    try {
                        try {
                            if (this.mCodecName == null || this.mCodecName.isEmpty()) {
                                YMFLog.info(this, "[Decoder ]", "mCodecName:null mCodeType:" + decodeVideoConfig.mCodecType);
                                this.mDecoder = MediaCodec.createDecoderByType(decodeVideoConfig.mCodecType);
                            } else {
                                this.mDecoder = MediaCodec.createByCodecName(this.mCodecName);
                            }
                            if (Build.VERSION.SDK_INT >= 21 && this.mDecodeVideoConfig.mRenderSurface == null) {
                                int[] iArr = this.mDecoder.getCodecInfo().getCapabilitiesForType(this.mCodecType).colorFormats;
                                int length = iArr.length;
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= length) {
                                        i = 21;
                                        break;
                                    } else if (iArr[i2] == 2135033992) {
                                        this.mSupportFlexible = true;
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                                this.mDecoderFormat.setInteger("color-format", i);
                                YMFLog.info(this, "[Decoder ]", "color-format:" + i);
                            }
                            YMFLog.info(this, "[Decoder ]", "init decoder, name:" + this.mDecoder.getName() + " type:" + this.mDecodeVideoConfig.mCodecType);
                            this.mDecoder.configure(this.mDecoderFormat, this.mDecodeVideoConfig.mRenderSurface, (MediaCrypto) null, 0);
                            this.mDecoder.start();
                            this.mInputBuffers = this.mDecoder.getInputBuffers();
                            this.mBufferInfo = new MediaCodec.BufferInfo();
                            this.mNoFrameCnt = 0;
                            this.isInited = true;
                        } catch (IllegalStateException e) {
                            YMFLog.info(this, "[Decoder ]", "init decoder IllegalStateException:" + e.toString());
                            if (this.mDecoder != null) {
                                this.mDecoder.stop();
                                this.mDecoder.release();
                                this.mDecoder = null;
                                z = false;
                            }
                            z = false;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (!z) {
                            this.mInputBuffers = this.mDecoder.getInputBuffers();
                            this.mBufferInfo = new MediaCodec.BufferInfo();
                            this.mNoFrameCnt = 0;
                            this.isInited = true;
                        } else if (this.mDecoder != null) {
                            this.mDecoder.stop();
                            this.mDecoder.release();
                            this.mDecoder = null;
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    try {
                        YMFLog.info(this, "[Decoder ]", "init decoder IOException:" + e2.toString());
                        if (this.mDecoder != null) {
                            this.mDecoder.stop();
                            this.mDecoder.release();
                            this.mDecoder = null;
                            z = false;
                        }
                        z = false;
                    } catch (Throwable th2) {
                        th = th2;
                        z = false;
                        if (!z) {
                        }
                        throw th;
                    }
                }
            } catch (IllegalArgumentException e3) {
                YMFLog.info(this, "[Decoder ]", "init decoder IllegalArgumentException:" + e3.toString());
                if (this.mDecoder != null) {
                    this.mDecoder.stop();
                    this.mDecoder.release();
                    this.mDecoder = null;
                    z = false;
                }
                z = false;
            }
        }
        return z ? 0 : -1;
    }

    @Override // com.yy.mediaframework.decoder.BaseDecoder
    public void release() {
        YMFLog.info(this, "[Decoder ]", "release decoder.");
        synchronized (SYNC_FLAG) {
            if (this.mDecoder == null) {
                YMFLog.info(this, "[Decoder ]", "decoder has already released.");
                return;
            }
            try {
                if (Build.VERSION.SDK_INT > 18 && this.mDecodeVideoConfig.mRenderSurface != null) {
                    this.mDecoder.signalEndOfInputStream();
                }
                this.mDecoder.flush();
                this.mDecoder.stop();
                this.mDecoder.release();
                this.mDecoder = null;
                this.isInited = false;
                this.mSupportFlexible = false;
            } catch (IllegalStateException e) {
                YMFLog.info(this, "[Decoder ]", "release decoder exception:" + e.getMessage());
                this.mDecoder.release();
                this.mDecoder = null;
                this.isInited = false;
                this.mSupportFlexible = false;
            }
        }
    }

    private void resetDecoder() {
        release();
        initDecoder(this.mDecodeVideoConfig);
    }

    public void resetDecoder(DecodeVideoConfig decodeVideoConfig) {
        YMFLog.info(this, "[Decoder ]", "resetDecoder, config:" + decodeVideoConfig.toString());
        release();
        initDecoder(decodeVideoConfig);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [273=6] */
    @Override // com.yy.mediaframework.decoder.BaseDecoder
    public long drainDecoder(DecodeVideoSample decodeVideoSample) {
        long j;
        int i;
        ByteBuffer inputBuffer;
        synchronized (SYNC_FLAG) {
            if (!this.isInited || decodeVideoSample == null) {
                YMFLog.info(this, "[Decoder ]", "decoder not inited or invalid sample data.");
                j = -1;
            } else if (this.mDecoder == null) {
                YMFLog.info(this, "[Decoder ]", "decoder not init yet.");
                j = -1;
            } else {
                try {
                    int dequeueInputBuffer = this.mDecoder.dequeueInputBuffer(200000L);
                    if (dequeueInputBuffer >= 0) {
                        if (Build.VERSION.SDK_INT < 21) {
                            inputBuffer = this.mInputBuffers[dequeueInputBuffer];
                            inputBuffer.clear();
                        } else {
                            inputBuffer = this.mDecoder.getInputBuffer(dequeueInputBuffer);
                        }
                        if (inputBuffer != null) {
                            inputBuffer.rewind();
                            inputBuffer.put(decodeVideoSample.data, 0, decodeVideoSample.dataLenght);
                        }
                        switch (decodeVideoSample.frameType) {
                            case 4:
                                this.mDecoder.queueInputBuffer(dequeueInputBuffer, 0, decodeVideoSample.dataLenght, decodeVideoSample.pts * 1000, 1);
                                break;
                            case 5:
                            case 6:
                                this.mDecoder.queueInputBuffer(dequeueInputBuffer, 0, decodeVideoSample.dataLenght, decodeVideoSample.pts * 1000, 2);
                                break;
                            default:
                                this.mDecoder.queueInputBuffer(dequeueInputBuffer, 0, decodeVideoSample.dataLenght, decodeVideoSample.pts * 1000, 0);
                                break;
                        }
                    }
                    i = -1;
                } catch (IllegalStateException e) {
                    YMFLog.error(this, "[Decoder ]", "drain decoder exception:" + e.toString());
                    i = -1;
                }
                while (true) {
                    try {
                        int dequeueOutputBuffer = this.mDecoder.dequeueOutputBuffer(this.mBufferInfo, 0L);
                        if (dequeueOutputBuffer >= 0) {
                            this.mDecoder.releaseOutputBuffer(dequeueOutputBuffer, true);
                            long j2 = this.mBufferInfo.presentationTimeUs / 1000;
                            try {
                                this.mDecoderFormat = this.mDecoder.getOutputFormat();
                                int integer = this.mDecoderFormat.getInteger("width");
                                int integer2 = this.mDecoderFormat.getInteger("height");
                                if (this.mOnDecoderSizeChangeListener != null) {
                                    this.mOnDecoderSizeChangeListener.onDecoderSizeChanged(integer, integer2);
                                }
                                this.mNoFrameCnt = 0;
                                j = j2;
                            } catch (IllegalStateException e2) {
                                YMFLog.error(this, "[Decoder ]", "getOutputFormat exception:" + e2.toString());
                                j = j2;
                            }
                        } else {
                            if (dequeueOutputBuffer == -3) {
                                YMFLog.info(this, "[Decoder ]", "HardDecRender PushFrame INFO_OUTPUT_BUFFERS_CHANGED");
                            } else if (dequeueOutputBuffer == -2) {
                                this.mDecoderFormat = this.mDecoder.getOutputFormat();
                                this.mDecodeWidth = this.mDecoderFormat.getInteger("width");
                                this.mDecodeHeight = this.mDecoderFormat.getInteger("height");
                                YMFLog.debug(this, "[Decoder ]", "HardDecRender PushFrame INFO_OUTPUT_FORMAT_CHANGED format:" + this.mDecoder.getOutputFormat() + " width:" + this.mDecodeWidth + " height:" + this.mDecodeHeight);
                            } else if (dequeueOutputBuffer == -1) {
                                this.mNoFrameCnt++;
                                if (this.mNoFrameCnt % 150 == 0) {
                                    resetDecoder();
                                    YMFLog.error(this, "[Decoder ]", "HardDecRender PushFrame noFrameCnt:" + this.mNoFrameCnt);
                                }
                                YMFLog.debug(this, "[Decoder ]", "HardDecRender PushFrame INFO_TRY_AGAIN_LATER, no frame count:" + this.mNoFrameCnt);
                                j = 0;
                            }
                            i = dequeueOutputBuffer;
                        }
                    } catch (IllegalStateException e3) {
                        YMFLog.error(this, "[Decoder ]", "dequeueOutputBuffer exception:" + e3.toString());
                        if (i >= 0) {
                            this.mDecoder.releaseOutputBuffer(i, true);
                            long j3 = this.mBufferInfo.presentationTimeUs / 1000;
                            try {
                                this.mDecoderFormat = this.mDecoder.getOutputFormat();
                                int integer3 = this.mDecoderFormat.getInteger("width");
                                int integer4 = this.mDecoderFormat.getInteger("height");
                                if (this.mOnDecoderSizeChangeListener != null) {
                                    this.mOnDecoderSizeChangeListener.onDecoderSizeChanged(integer3, integer4);
                                }
                                this.mNoFrameCnt = 0;
                                j = j3;
                            } catch (IllegalStateException e4) {
                                YMFLog.error(this, "[Decoder ]", "getOutputFormat exception:" + e4.toString());
                                j = j3;
                            }
                        } else if (i == -3) {
                            YMFLog.info(this, "[Decoder ]", "HardDecRender PushFrame INFO_OUTPUT_BUFFERS_CHANGED");
                            j = 0;
                        } else if (i == -2) {
                            this.mDecoderFormat = this.mDecoder.getOutputFormat();
                            this.mDecodeWidth = this.mDecoderFormat.getInteger("width");
                            this.mDecodeHeight = this.mDecoderFormat.getInteger("height");
                            YMFLog.debug(this, "[Decoder ]", "HardDecRender PushFrame INFO_OUTPUT_FORMAT_CHANGED format:" + this.mDecoder.getOutputFormat() + " width:" + this.mDecodeWidth + " height:" + this.mDecodeHeight);
                            j = 0;
                        } else if (i == -1) {
                            this.mNoFrameCnt++;
                            if (this.mNoFrameCnt % 150 == 0) {
                                resetDecoder();
                                YMFLog.error(this, "[Decoder ]", "HardDecRender PushFrame noFrameCnt:" + this.mNoFrameCnt);
                            }
                            YMFLog.debug(this, "[Decoder ]", "HardDecRender PushFrame INFO_TRY_AGAIN_LATER, no frame count:" + this.mNoFrameCnt);
                            j = 0;
                        }
                    }
                }
                j = 0;
                YYPeripheralsVideoSampleAllocator.instance().free(decodeVideoSample);
            }
        }
        return j;
    }

    public boolean isInited() {
        return this.isInited;
    }

    public void setOnDecoderSizeChangeListener(OnDecoderSizeChangeListener onDecoderSizeChangeListener) {
        this.mOnDecoderSizeChangeListener = onDecoderSizeChangeListener;
    }

    private String byte2hex(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            YMFLog.info(this, "[Decoder ]", "invalid buffer");
            return "";
        }
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            str = str + " " + hexString;
        }
        return str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [434=6] */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a2, code lost:
        r8 = r16.mBufferInfo.presentationTimeUs / 1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ac, code lost:
        r16.mDecoderFormat = r16.mDecoder.getOutputFormat();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b8, code lost:
        r3 = r16.mDecoderFormat.getInteger("width");
        r4 = r16.mDecoderFormat.getInteger("height");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d2, code lost:
        if (r16.mOnDecoderSizeChangeListener == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d4, code lost:
        r16.mOnDecoderSizeChangeListener.onDecoderSizeChanged(r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00df, code lost:
        if (r16.mOnDecoderYUVListener == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e7, code lost:
        if (r16.mBufferInfo.size <= 0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f1, code lost:
        if (r16.mOnDecoderYUVListener.onVerifyPts(r8) == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00fb, code lost:
        if (r16.mSupportFlexible.booleanValue() == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fd, code lost:
        r6 = r16.mDecoder.getOutputImage(r12);
        r2 = r6.getCropRect();
        r3 = r2.width();
        r4 = r2.height();
        r2 = r6.getFormat();
        com.yy.mediaframework.utils.YMFLog.info(r16, "[Decoder ]", "color format:" + r2);
        r16.mOnDecoderYUVListener.OnDecoderYUVListener(r3, r4, null, r6, ((r3 * r4) * android.graphics.ImageFormat.getBitsPerPixel(r2)) / 8, r8, r16.mBufferInfo.flags);
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x014b, code lost:
        r16.mDecoder.releaseOutputBuffer(r12, false);
        r16.mNoFrameCnt = 0;
        r2 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01a9, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01aa, code lost:
        com.yy.mediaframework.utils.YMFLog.error(r16, "[Decoder ]", "getOutputFormat exception:" + r2.toString());
        r2 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01d0, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 21) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01d2, code lost:
        r5 = r16.mOutputBuffers[r12];
        r5.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01db, code lost:
        r16.mOnDecoderYUVListener.OnDecoderYUVListener(r3, r4, r5, null, r16.mBufferInfo.size, r8, r16.mBufferInfo.flags);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01f1, code lost:
        r5 = r16.mDecoder.getOutputBuffer(r12);
     */
    @Override // com.yy.mediaframework.decoder.BaseDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long drainDecoder(@NonNull byte[] bArr, int i, boolean z, long j) {
        long j2;
        int i2;
        int i3;
        ByteBuffer outputBuffer;
        ByteBuffer inputBuffer;
        synchronized (SYNC_FLAG) {
            if (!this.isInited || bArr == null) {
                YMFLog.info(this, "[Decoder ]", "decoder not inited or invalid data.");
                j2 = -1;
            } else if (this.mDecoder == null) {
                YMFLog.info(this, "[Decoder ]", "decoder not init yet.");
                j2 = -1;
            } else {
                try {
                    int dequeueInputBuffer = this.mDecoder.dequeueInputBuffer(200000L);
                    if (dequeueInputBuffer >= 0) {
                        if (Build.VERSION.SDK_INT < 21) {
                            inputBuffer = this.mInputBuffers[dequeueInputBuffer];
                            inputBuffer.clear();
                        } else {
                            inputBuffer = this.mDecoder.getInputBuffer(dequeueInputBuffer);
                        }
                        if (inputBuffer != null) {
                            inputBuffer.rewind();
                            inputBuffer.put(bArr, 0, i);
                        }
                        if (z) {
                            this.mDecoder.queueInputBuffer(dequeueInputBuffer, 0, i, 1000 * j, 2);
                            this.mHeader = new byte[i];
                            System.arraycopy(bArr, 0, this.mHeader, 0, i);
                            YMFLog.info(this, "[Decoder ]", "BUFFER_FLAG_CODEC_CONFIG");
                        } else {
                            this.mDecoder.queueInputBuffer(dequeueInputBuffer, 0, i, 1000 * j, 0);
                        }
                    }
                    i2 = -1;
                    i3 = dequeueInputBuffer;
                } catch (IllegalStateException e) {
                    YMFLog.error(this, "[Decoder ]", "drain decoder exception:" + e.toString());
                    i2 = -1;
                    i3 = -1;
                }
                while (true) {
                    try {
                        i2 = this.mDecoder.dequeueOutputBuffer(this.mBufferInfo, 0L);
                        if (i2 >= 0) {
                            break;
                        } else if (i2 == -3) {
                            YMFLog.info(this, "[Decoder ]", "HardDecRender PushFrame INFO_OUTPUT_BUFFERS_CHANGED");
                        } else if (i2 == -2) {
                            this.mDecoderFormat = this.mDecoder.getOutputFormat();
                            this.mDecodeWidth = this.mDecoderFormat.getInteger("width");
                            this.mDecodeHeight = this.mDecoderFormat.getInteger("height");
                            YMFLog.debug(this, "[Decoder ]", "HardDecRender PushFrame INFO_OUTPUT_FORMAT_CHANGED format:" + this.mDecoder.getOutputFormat() + " width:" + this.mDecodeWidth + " height:" + this.mDecodeHeight);
                        } else if (i2 == -1) {
                            this.mNoFrameCnt++;
                            if (this.mNoFrameCnt % 150 == 0) {
                                if (this.mOnDecoderYUVListener != null) {
                                    this.mOnDecoderYUVListener.OnDecoderError();
                                }
                                resetDecoder();
                                YMFLog.error(this, "[Decoder ]", "HardDecRender PushFrame noFrameCnt:" + this.mNoFrameCnt);
                                j2 = 0;
                            }
                        }
                    } catch (IllegalStateException e2) {
                        YMFLog.error(this, "[Decoder ]", "dequeueOutputBuffer exception:" + e2.toString());
                        if (i2 >= 0) {
                            long j3 = this.mBufferInfo.presentationTimeUs / 1000;
                            try {
                                this.mDecoderFormat = this.mDecoder.getOutputFormat();
                                int integer = this.mDecoderFormat.getInteger("width");
                                int integer2 = this.mDecoderFormat.getInteger("height");
                                if (this.mOnDecoderSizeChangeListener != null) {
                                    this.mOnDecoderSizeChangeListener.onDecoderSizeChanged(integer, integer2);
                                }
                                if (this.mOnDecoderYUVListener != null && this.mBufferInfo.size > 0 && this.mOnDecoderYUVListener.onVerifyPts(j3)) {
                                    if (this.mSupportFlexible.booleanValue()) {
                                        Image outputImage = this.mDecoder.getOutputImage(i2);
                                        Rect cropRect = outputImage.getCropRect();
                                        int width = cropRect.width();
                                        int height = cropRect.height();
                                        int format = outputImage.getFormat();
                                        YMFLog.info(this, "[Decoder ]", "color format:" + format);
                                        this.mOnDecoderYUVListener.OnDecoderYUVListener(width, height, null, outputImage, ((width * height) * ImageFormat.getBitsPerPixel(format)) / 8, j3, this.mBufferInfo.flags);
                                        outputImage.close();
                                    } else {
                                        if (Build.VERSION.SDK_INT < 21) {
                                            outputBuffer = this.mOutputBuffers[i2];
                                            outputBuffer.clear();
                                        } else {
                                            outputBuffer = this.mDecoder.getOutputBuffer(i2);
                                        }
                                        this.mOnDecoderYUVListener.OnDecoderYUVListener(integer, integer2, outputBuffer, null, this.mBufferInfo.size, j3, this.mBufferInfo.flags);
                                    }
                                }
                                this.mDecoder.releaseOutputBuffer(i2, false);
                                this.mNoFrameCnt = 0;
                                j2 = j3;
                            } catch (IllegalStateException e3) {
                                YMFLog.error(this, "[Decoder ]", "getOutputFormat exception:" + e3.toString());
                                j2 = j3;
                            }
                        } else if (i2 == -3) {
                            YMFLog.info(this, "[Decoder ]", "HardDecRender PushFrame INFO_OUTPUT_BUFFERS_CHANGED");
                            j2 = 0;
                        } else if (i2 == -2) {
                            this.mDecoderFormat = this.mDecoder.getOutputFormat();
                            this.mDecodeWidth = this.mDecoderFormat.getInteger("width");
                            this.mDecodeHeight = this.mDecoderFormat.getInteger("height");
                            YMFLog.debug(this, "[Decoder ]", "HardDecRender PushFrame INFO_OUTPUT_FORMAT_CHANGED format:" + this.mDecoder.getOutputFormat() + " width:" + this.mDecodeWidth + " height:" + this.mDecodeHeight);
                            j2 = 0;
                        } else if (i2 == -1) {
                            this.mNoFrameCnt++;
                            if (this.mNoFrameCnt % 150 == 0) {
                                if (this.mOnDecoderYUVListener != null) {
                                    this.mOnDecoderYUVListener.OnDecoderError();
                                }
                                resetDecoder();
                                YMFLog.error(this, "[Decoder ]", "HardDecRender PushFrame noFrameCnt:" + this.mNoFrameCnt);
                                j2 = 0;
                            }
                        }
                    }
                }
                j2 = 0;
                if (i3 < 0) {
                    YMFLog.error(this, "[Decoder ]", "HardDecRender drainDecoder data err input block");
                }
            }
        }
        return j2;
    }

    public boolean decoderHeaderChange(byte[] bArr, int i) {
        if (this.mHeader != null && this.mHeader.length == i) {
            for (int i2 = 0; i2 < i; i2++) {
                if (this.mHeader[i2] != bArr[i2]) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public void setOnDecoderYUVListener(OnDecoderYUVListener onDecoderYUVListener) {
        this.mOnDecoderYUVListener = onDecoderYUVListener;
    }
}
