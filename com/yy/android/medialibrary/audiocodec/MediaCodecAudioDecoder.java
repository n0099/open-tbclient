package com.yy.android.medialibrary.audiocodec;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import com.baidu.android.util.devices.RomUtils;
import com.kwai.video.player.misc.IMediaFormat;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.ByteBuffer;
import org.apache.http.HttpHost;
/* loaded from: classes6.dex */
public class MediaCodecAudioDecoder {
    private int mAudioTrackCount;
    private final Context mContext;
    private int mCurrentAudioTrack;
    private ByteBuffer mDecodedRAWBuffer;
    private long mFileLength;
    private ByteBuffer[] mInputBuffers;
    private final long mNativeAudioDecoder;
    private ByteBuffer[] mOutputBuffers;
    private static int MAX_DECODER_RETRY_COUNT = 300;
    private static int HTTP_REQUEST_TIMEOUT = 3000;
    private MediaCodec mMediaCodec = null;
    private MediaExtractor mExtractor = null;
    private MediaFormat mTrackFormat = null;
    private boolean mDecodedDataReady = false;
    private boolean eoInputStream = false;
    private boolean eoOutputStream = false;
    private int mSampleRate = 44100;
    private int mChannels = 2;
    private int mRetryCount = 0;
    private MediaCodec mAACDecoder = null;
    private ByteBuffer mAACOutputBuffer = ByteBuffer.allocateDirect(4096);
    private String mTag = "[MediaCodecAudioDecoderJava]";
    private boolean mHasVideoTrack = false;

    private static native void nativeCacheDirectBufferAddress(ByteBuffer byteBuffer, long j);

    private static native void nativeDataIsReady(long j, int i);

    private static native void nativeLogDebugInfo(String str);

    MediaCodecAudioDecoder(Context context, long j) {
        doLog("new MediaCodecAudioDecoder, context: " + context + " ,nativeAudioDecoder: " + j);
        this.mContext = context;
        this.mNativeAudioDecoder = j;
    }

    public boolean createStreaming(String str) {
        try {
            doLog("Try to decode audio file : " + str);
            this.mRetryCount = 0;
            boolean startsWith = str.startsWith("/assets/");
            boolean startsWith2 = str.toLowerCase().startsWith(HttpHost.DEFAULT_SCHEME_NAME);
            this.mExtractor = new MediaExtractor();
            if (startsWith) {
                if (this.mContext == null) {
                    return false;
                }
                AssetFileDescriptor openFd = this.mContext.getAssets().openFd(str.substring("/assets/".length()));
                this.mExtractor.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            } else if (startsWith2) {
                try {
                    if (Build.MODEL.equalsIgnoreCase("NX569H") || Build.MODEL.equalsIgnoreCase("OPPO R7")) {
                        return false;
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setConnectTimeout(HTTP_REQUEST_TIMEOUT);
                    httpURLConnection.setReadTimeout(HTTP_REQUEST_TIMEOUT);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    doLog("connect http stream resultCode: " + responseCode);
                    if (responseCode != 200) {
                        return false;
                    }
                    this.mExtractor.setDataSource(str);
                } catch (SocketTimeoutException e) {
                    doLogErr("Connect timeout on URL : " + str + " ,exception: " + e.toString());
                    return false;
                } catch (IOException e2) {
                    doLogErr("Connect IOException on URL : " + str + " ,exception: " + e2.toString());
                    return false;
                }
            } else {
                this.mExtractor.setDataSource(str);
            }
            doLog("connect  stream successfully");
            int trackCount = this.mExtractor.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                this.mExtractor.unselectTrack(i);
            }
            int i2 = 0;
            while (true) {
                if (i2 >= trackCount) {
                    break;
                }
                this.mTrackFormat = this.mExtractor.getTrackFormat(i2);
                String string = this.mTrackFormat.getString(IMediaFormat.KEY_MIME);
                if (string.contains("video/")) {
                    this.mHasVideoTrack = true;
                }
                if (!string.contains("audio/")) {
                    i2++;
                } else {
                    this.mExtractor.selectTrack(i2);
                    this.mMediaCodec = MediaCodec.createDecoderByType(string);
                    this.mMediaCodec.configure(this.mTrackFormat, (Surface) null, (MediaCrypto) null, 0);
                    this.mCurrentAudioTrack = i2;
                    break;
                }
            }
            if (this.mHasVideoTrack) {
                this.mAudioTrackCount = trackCount - 1;
            } else {
                this.mAudioTrackCount = trackCount;
            }
            doLog("mHasVideoTrack: " + this.mHasVideoTrack + " ,mAudioTrackCount: " + this.mAudioTrackCount);
            if (this.mMediaCodec != null) {
                this.mMediaCodec.start();
            }
            this.mChannels = this.mTrackFormat.getInteger("channel-count");
            this.mSampleRate = this.mTrackFormat.getInteger("sample-rate");
            this.mFileLength = this.mTrackFormat.getLong("durationUs");
            return true;
        } catch (Exception e3) {
            doLogErr("Error when createStreaming audio file decoder, exception: " + e3.toString());
            return false;
        }
    }

    public int getChannelCount() {
        return this.mChannels;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public long getFileLength() {
        return this.mFileLength;
    }

    public long getCurrentFilePosition() {
        return this.mExtractor.getSampleTime();
    }

    public void setCurrentFilePosition(long j) {
        this.mExtractor.seekTo(j, 2);
    }

    public boolean selectAudioTrack(int i) {
        if (i >= this.mAudioTrackCount || i < 0) {
            doLog("selectAudioTrack parameter fail..");
            return false;
        }
        if (this.mHasVideoTrack) {
            i++;
        }
        if (this.mCurrentAudioTrack == i) {
            doLog("selectAudioTrack fail, already select");
            return true;
        }
        long sampleTime = this.mExtractor.getSampleTime();
        this.mExtractor.unselectTrack(this.mCurrentAudioTrack);
        this.mExtractor.selectTrack(i);
        this.mExtractor.seekTo(sampleTime, 2);
        this.mCurrentAudioTrack = i;
        return true;
    }

    public int getAudioTrackCount() {
        return this.mAudioTrackCount;
    }

    public boolean getDecodeDataReadyFlag() {
        return this.mDecodedDataReady;
    }

    public void releaseStreaming() {
        try {
            if (this.mMediaCodec != null) {
                this.mMediaCodec.stop();
                this.mMediaCodec.release();
                this.mMediaCodec = null;
            }
            if (this.mExtractor != null) {
                this.mExtractor.release();
                this.mExtractor = null;
            }
        } catch (Exception e) {
            doLogErr("Error when releasing audio file stream, exception: " + e.toString());
            e.printStackTrace();
        }
        this.eoOutputStream = false;
        this.eoInputStream = false;
    }

    public void rewindStreaming() {
        try {
            this.mExtractor.seekTo(0L, 1);
            this.mMediaCodec.flush();
        } catch (Exception e) {
            doLogErr("Error when rewinding audio file stream, exception: " + e.toString());
        }
        this.eoInputStream = false;
        this.eoOutputStream = false;
        this.mDecodedDataReady = false;
    }

    public boolean decodeFrame() {
        int dequeueInputBuffer;
        ByteBuffer byteBuffer;
        int i = 0;
        try {
            if (!this.eoInputStream && (dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(0L)) >= 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    byteBuffer = this.mMediaCodec.getInputBuffer(dequeueInputBuffer);
                } else {
                    this.mInputBuffers = this.mMediaCodec.getInputBuffers();
                    byteBuffer = this.mInputBuffers[dequeueInputBuffer];
                }
                int readSampleData = this.mExtractor.readSampleData(byteBuffer, 0);
                if (readSampleData <= 0) {
                    this.eoInputStream = true;
                } else {
                    i = readSampleData;
                }
                long sampleTime = this.mExtractor.getSampleTime();
                int sampleFlags = this.mExtractor.getSampleFlags();
                if (this.eoInputStream) {
                    sampleFlags |= 4;
                }
                this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, i, sampleTime, sampleFlags);
                this.mExtractor.advance();
            }
            if (!this.eoOutputStream) {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
                this.mDecodedDataReady = false;
                switch (dequeueOutputBuffer) {
                    case -3:
                    case -2:
                        break;
                    case -1:
                        this.mRetryCount++;
                        if (this.mRetryCount >= MAX_DECODER_RETRY_COUNT && (Build.BRAND.toLowerCase().contains(RomUtils.MANUFACTURER_MEIZU) || Build.MANUFACTURER.toLowerCase().contains(RomUtils.MANUFACTURER_MEIZU) || Build.BRAND.toLowerCase().contains(RomUtils.MANUFACTURER_VIVO) || Build.MANUFACTURER.toLowerCase().contains(RomUtils.MANUFACTURER_VIVO))) {
                            doLogErr("EAGAIN count=" + this.mRetryCount + " presentationTimeUs=" + bufferInfo.presentationTimeUs + " totalUs=" + this.mFileLength + " Force EOS");
                            this.eoOutputStream = true;
                            break;
                        }
                        break;
                    default:
                        this.mRetryCount = 0;
                        if (dequeueOutputBuffer >= 0) {
                            if ((bufferInfo.flags & 4) == 4) {
                                this.eoOutputStream = true;
                            }
                            if (Build.VERSION.SDK_INT >= 21) {
                                cloneByteBuffer(this.mMediaCodec.getOutputBuffer(dequeueOutputBuffer));
                            } else {
                                this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                                cloneByteBufferByLength(this.mOutputBuffers[dequeueOutputBuffer], bufferInfo.size);
                            }
                            this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                            this.mDecodedDataReady = true;
                            break;
                        }
                        break;
                }
            }
        } catch (Exception e) {
            doLogErr("Error when decoding audio file stream, exception: " + e.toString());
        }
        return this.eoOutputStream;
    }

    private boolean checkInfoChange() {
        if (Build.VERSION.SDK_INT < 19) {
            return false;
        }
        try {
            MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
            int integer = outputFormat.getInteger("sample-rate");
            int integer2 = outputFormat.getInteger("channel-count");
            boolean z = (this.mSampleRate == integer && this.mChannels == integer2) ? false : true;
            this.mSampleRate = integer;
            this.mChannels = integer2;
            return z;
        } catch (Exception e) {
            doLogErr("Error when checking file's new format, exception: " + e.toString());
            return false;
        }
    }

    private void cloneByteBuffer(ByteBuffer byteBuffer) {
        try {
            if (this.mDecodedRAWBuffer == null || this.mDecodedRAWBuffer.limit() != byteBuffer.limit()) {
                if (this.mDecodedRAWBuffer != null) {
                    this.mDecodedRAWBuffer.clear();
                    this.mDecodedRAWBuffer = null;
                }
                this.mDecodedRAWBuffer = ByteBuffer.allocateDirect(byteBuffer.limit());
                nativeCacheDirectBufferAddress(this.mDecodedRAWBuffer, this.mNativeAudioDecoder);
            }
            this.mDecodedRAWBuffer.position(0);
            this.mDecodedRAWBuffer.put(byteBuffer);
            nativeDataIsReady(this.mNativeAudioDecoder, byteBuffer.limit());
        } catch (Exception e) {
            doLogErr("Error when cloneByteBuffer, exception: " + e.toString());
        }
    }

    private void cloneByteBufferByLength(ByteBuffer byteBuffer, int i) {
        try {
            if (this.mDecodedRAWBuffer == null || this.mDecodedRAWBuffer.capacity() < i) {
                if (this.mDecodedRAWBuffer != null) {
                    this.mDecodedRAWBuffer.clear();
                    this.mDecodedRAWBuffer = null;
                }
                this.mDecodedRAWBuffer = ByteBuffer.allocateDirect(i);
                nativeCacheDirectBufferAddress(this.mDecodedRAWBuffer, this.mNativeAudioDecoder);
            }
            this.mDecodedRAWBuffer.position(0);
            byteBuffer.limit(i);
            this.mDecodedRAWBuffer.put(byteBuffer);
            nativeDataIsReady(this.mNativeAudioDecoder, i);
        } catch (Exception e) {
            doLogErr("Error when cloneByteBufferByLength, exception: " + e.toString());
        }
    }

    public boolean checkAACSupported() {
        MediaCodecInfo[] codecInfos;
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
                    if (!mediaCodecInfo.isEncoder() && mediaCodecInfo.getName().toLowerCase().contains("nvidia")) {
                        return false;
                    }
                }
            } else {
                int codecCount = MediaCodecList.getCodecCount();
                for (int i = 0; i < codecCount; i++) {
                    MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
                    if (!codecInfoAt.isEncoder() && codecInfoAt.getName().toLowerCase().contains("nvidia")) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            doLogErr("Error when checking aac codec availability, exception: " + e.toString());
            return false;
        }
    }

    public boolean createAACStreaming(int i) {
        try {
            this.mAACDecoder = MediaCodec.createDecoderByType("audio/mp4a-latm");
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i, 1);
            createAudioFormat.setInteger("sample-rate", i);
            createAudioFormat.setInteger("channel-count", 1);
            createAudioFormat.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[]{18, -120}));
            this.mAACDecoder.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 0);
            if (this.mAACDecoder != null) {
                this.mAACDecoder.start();
                return true;
            }
            return true;
        } catch (Exception e) {
            doLogErr("Error when creating aac decode stream, exception: " + e.toString());
            return false;
        }
    }

    public void releaseAACStreaming() {
        try {
            if (this.mAACDecoder != null) {
                this.mAACDecoder.stop();
                this.mAACDecoder.release();
                this.mAACDecoder = null;
            }
        } catch (Exception e) {
            doLogErr("Error when releasing aac decode stream, exception: " + e.toString());
        }
    }

    public int decodeAACFrame(byte[] bArr) {
        int i;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        try {
            int dequeueInputBuffer = this.mAACDecoder.dequeueInputBuffer(200L);
            if (dequeueInputBuffer >= 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    byteBuffer2 = this.mAACDecoder.getInputBuffer(dequeueInputBuffer);
                } else {
                    byteBuffer2 = this.mAACDecoder.getInputBuffers()[dequeueInputBuffer];
                }
                byteBuffer2.clear();
                byteBuffer2.put(bArr);
                this.mAACDecoder.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, 0L, 0);
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mAACDecoder.dequeueOutputBuffer(bufferInfo, 0L);
            switch (dequeueOutputBuffer) {
                case -3:
                    return 0;
                case -2:
                    return 0;
                case -1:
                    return 0;
                default:
                    if (dequeueOutputBuffer >= 0) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            byteBuffer = this.mAACDecoder.getOutputBuffer(dequeueOutputBuffer);
                        } else {
                            byteBuffer = this.mAACDecoder.getOutputBuffers()[dequeueOutputBuffer];
                        }
                        i = bufferInfo.size;
                        try {
                            this.mAACOutputBuffer.position(0);
                            byteBuffer.limit(i);
                            this.mAACOutputBuffer.put(byteBuffer);
                            this.mAACDecoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                            return i;
                        } catch (Exception e) {
                            e = e;
                            doLogErr("Error when decoding aac stream, exception: " + e.toString());
                            return i;
                        }
                    }
                    return 0;
            }
        } catch (Exception e2) {
            e = e2;
            i = 0;
        }
    }

    private void doLog(String str) {
        Log.i(this.mTag, str);
        nativeLogDebugInfo(this.mTag + str);
    }

    private void doLogErr(String str) {
        nativeLogDebugInfo(this.mTag + "[Error]" + str);
    }
}
