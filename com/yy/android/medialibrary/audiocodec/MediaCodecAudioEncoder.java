package com.yy.android.medialibrary.audiocodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.webkit.net.BdNetTask;
import com.kwai.video.player.KsMediaMeta;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class MediaCodecAudioEncoder {
    private ByteBuffer[] mAACInputBuffers;
    private ByteBuffer[] mAACOutputBuffers;
    private ByteBuffer[] mInputBuffers;
    private ByteBuffer[] mOutputBuffers;
    private MediaCodec mMediaCodec = null;
    private MediaFormat mTrackFormat = null;
    private String mCodecString = null;
    private File outputFile = null;
    private BufferedOutputStream outputStream = null;
    private MediaCodec mAACEncoder = null;
    private MediaFormat mAACFormat = null;
    private ByteBuffer mAACEncodedBuffer = ByteBuffer.allocateDirect(1024);
    private String mTag = "MediaCodec Audio Encoder";

    public boolean createStreaming(String str, int i, int i2, int i3) {
        int i4 = 16000;
        try {
            doLog("Recording aac with fs = " + i + ", ch = " + i2 + ", quality = " + i3);
            String substring = str.substring(str.length() - 3);
            if (substring.equalsIgnoreCase("3gp") || substring.equalsIgnoreCase("amr")) {
                if (i == 8000) {
                    this.mMediaCodec = MediaCodec.createEncoderByType("audio/3gpp");
                    this.mTrackFormat = MediaFormat.createAudioFormat("audio/3gpp", i, i2);
                    this.mTrackFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, 12200);
                    this.mCodecString = "audio/3gpp";
                } else if (i == 16000) {
                    this.mMediaCodec = MediaCodec.createEncoderByType("audio/amr-wb");
                    this.mTrackFormat = MediaFormat.createAudioFormat("audio/amr-wb", i, i2);
                    this.mTrackFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, 23850);
                    this.mCodecString = "audio/amr-wb";
                }
            } else if (!substring.equalsIgnoreCase("aac")) {
                return false;
            } else {
                switch (i3) {
                    case 0:
                        break;
                    case 1:
                        i4 = BdNetTask.TIMEOUT_READ;
                        break;
                    default:
                        i4 = IMConstants.ERROR_BASE;
                        break;
                }
                this.mMediaCodec = MediaCodec.createEncoderByType("audio/mp4a-latm");
                this.mTrackFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i, i2);
                int[] iArr = {2, 5, 39};
                this.mTrackFormat.setInteger("aac-profile", 2);
                this.mTrackFormat.setInteger("sample-rate", i);
                this.mTrackFormat.setInteger("channel-count", i2);
                this.mTrackFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, i4);
                this.mCodecString = "audio/mp4a-latm";
            }
            this.mMediaCodec.configure(this.mTrackFormat, (Surface) null, (MediaCrypto) null, 1);
            if (this.mMediaCodec != null) {
                this.mMediaCodec.start();
            }
            this.outputFile = new File(str);
            touch(this.outputFile);
            try {
                this.outputStream = new BufferedOutputStream(new FileOutputStream(this.outputFile));
                doLog("outputStream initialized");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.mCodecString == "audio/3gpp") {
                this.outputStream.write(new byte[]{35, 33, 65, 77, 82, 10});
            } else if (this.mCodecString == "audio/amr-wb") {
                this.outputStream.write(new byte[]{35, 33, 65, 77, 82, 45, 87, 66, 10});
            }
            return true;
        } catch (Exception e2) {
            doLogErr("Error when creating aac file encoder");
            e2.printStackTrace();
            return false;
        }
    }

    public void setChannelCount(int i) {
        try {
            this.mTrackFormat.setInteger("channel-count", i);
        } catch (Exception e) {
            doLogErr("Error when setting aac file encoder channel count");
            e.printStackTrace();
        }
    }

    public void setSampleRate(int i) {
        try {
            this.mTrackFormat.setInteger("sample-rate", i);
        } catch (Exception e) {
            doLogErr("Error when setting aac file encoder sample rate");
            e.printStackTrace();
        }
    }

    public void releaseStreaming() {
        try {
            if (this.mMediaCodec != null) {
                this.mMediaCodec.stop();
                this.mMediaCodec.release();
                this.mMediaCodec = null;
            }
            if (this.outputStream != null) {
                this.outputStream.flush();
                this.outputStream.close();
                this.outputStream = null;
            }
        } catch (Exception e) {
            doLogErr("Error when releasing aac file encoder");
            e.printStackTrace();
        }
    }

    public void encodeFrame(byte[] bArr) {
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        try {
            int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(2000L);
            if (dequeueInputBuffer != -1) {
                if (Build.VERSION.SDK_INT >= 21) {
                    byteBuffer2 = this.mMediaCodec.getInputBuffer(dequeueInputBuffer);
                } else {
                    this.mInputBuffers = this.mMediaCodec.getInputBuffers();
                    byteBuffer2 = this.mInputBuffers[dequeueInputBuffer];
                }
                byteBuffer2.clear();
                byteBuffer2.put(bArr);
                this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, 0L, 0);
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
            while (dequeueOutputBuffer >= 0) {
                int i = bufferInfo.size;
                if (Build.VERSION.SDK_INT >= 21) {
                    byteBuffer = this.mMediaCodec.getOutputBuffer(dequeueOutputBuffer);
                } else {
                    this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                    byteBuffer = this.mOutputBuffers[dequeueOutputBuffer];
                }
                byteBuffer.position(bufferInfo.offset);
                byteBuffer.limit(bufferInfo.offset + i);
                if (this.mCodecString == "audio/mp4a-latm") {
                    int i2 = i + 7;
                    byte[] bArr2 = new byte[i2];
                    addADTStoPacket(bArr2, i2);
                    byteBuffer.get(bArr2, 7, i);
                    byteBuffer.position(bufferInfo.offset);
                    this.outputStream.write(bArr2, 0, bArr2.length);
                } else if (this.mCodecString == "audio/3gpp" || this.mCodecString == "audio/amr-wb") {
                    byte[] bArr3 = new byte[i];
                    byteBuffer.get(bArr3, 0, i);
                    byteBuffer.position(bufferInfo.offset);
                    this.outputStream.write(bArr3, 0, bArr3.length);
                }
                this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
            }
        } catch (Exception e) {
            doLogErr("Error when encoding aac file");
            e.printStackTrace();
        }
    }

    private void addADTStoPacket(byte[] bArr, int i) {
        bArr[0] = -1;
        bArr[1] = -7;
        bArr[2] = (byte) 84;
        bArr[3] = (byte) ((i >> 11) + 64);
        bArr[4] = (byte) ((i & 2047) >> 3);
        bArr[5] = (byte) (((i & 7) << 5) + 31);
        bArr[6] = -4;
    }

    private void touch(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean createAACStreaming(int i, int i2, int i3) {
        try {
            doLog("Encoding aac with fs = " + i + ", bitrate = " + i3);
            this.mAACEncoder = MediaCodec.createEncoderByType("audio/mp4a-latm");
            this.mAACFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i, i2);
            int[] iArr = {2, 5, 39};
            this.mAACFormat.setInteger("aac-profile", 2);
            this.mAACFormat.setInteger("sample-rate", i);
            this.mAACFormat.setInteger("channel-count", i2);
            this.mAACFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, i3);
            this.mAACEncoder.configure(this.mAACFormat, (Surface) null, (MediaCrypto) null, 1);
            if (this.mAACEncoder != null) {
                this.mAACEncoder.start();
                return true;
            }
            return true;
        } catch (Exception e) {
            doLogErr("Error when creating aac encode stream");
            e.printStackTrace();
            return false;
        }
    }

    public boolean setAACEncodeBitrate(int i) {
        doLog("Set hw aac bitrate = " + i);
        try {
            if (this.mAACEncoder != null) {
                this.mAACEncoder.stop();
                this.mAACFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, i);
                this.mAACEncoder.configure(this.mAACFormat, (Surface) null, (MediaCrypto) null, 1);
                this.mAACEncoder.start();
                return true;
            }
            return true;
        } catch (Exception e) {
            doLogErr("Error when setting aac encode bitrate");
            e.printStackTrace();
            return false;
        }
    }

    public void releaseAACStreaming() {
        try {
            if (this.mAACEncoder != null) {
                this.mAACEncoder.stop();
                this.mAACEncoder.release();
                this.mAACEncoder = null;
            }
        } catch (Exception e) {
            doLogErr("Error when releasing aac encode stream");
            e.printStackTrace();
        }
    }

    public int encodeAACFrame(byte[] bArr) {
        int i;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        try {
            int dequeueInputBuffer = this.mAACEncoder.dequeueInputBuffer(2000L);
            if (dequeueInputBuffer != -1) {
                if (Build.VERSION.SDK_INT >= 21) {
                    byteBuffer2 = this.mAACEncoder.getInputBuffer(dequeueInputBuffer);
                } else {
                    this.mAACInputBuffers = this.mAACEncoder.getInputBuffers();
                    byteBuffer2 = this.mAACInputBuffers[dequeueInputBuffer];
                }
                byteBuffer2.clear();
                byteBuffer2.put(bArr);
                this.mAACEncoder.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, 0L, 0);
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mAACEncoder.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer >= 0) {
                int i2 = bufferInfo.size;
                if (Build.VERSION.SDK_INT >= 21) {
                    byteBuffer = this.mAACEncoder.getOutputBuffer(dequeueOutputBuffer);
                } else {
                    this.mAACOutputBuffers = this.mAACEncoder.getOutputBuffers();
                    byteBuffer = this.mAACOutputBuffers[dequeueOutputBuffer];
                }
                i = (bufferInfo.flags & 2) == 2 ? 0 : bufferInfo.size;
                try {
                    byteBuffer.position(bufferInfo.offset);
                    byteBuffer.limit(bufferInfo.offset + i2);
                    this.mAACEncodedBuffer.position(0);
                    this.mAACEncodedBuffer.put(byteBuffer);
                    this.mAACEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    return i;
                } catch (Exception e) {
                    e = e;
                    doLogErr("Error when encoding aac stream");
                    e.printStackTrace();
                    return i;
                }
            }
            return 0;
        } catch (Exception e2) {
            e = e2;
            i = 0;
        }
    }

    private void doLog(String str) {
        Log.i(this.mTag, str);
    }

    private void doLogErr(String str) {
        Log.e(this.mTag, "[Error]" + str);
    }
}
