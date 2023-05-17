package com.google.android.exoplayer2.audio;

import android.support.v4.media.session.MediaSessionCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.pass.face.platform.utils.FileUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.ogg.OpusReader;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public final class Ac3Util {
    public static final int AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT = 1536;
    public static final int AUDIO_SAMPLES_PER_AUDIO_BLOCK = 256;
    public static final int[] BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD = {1, 2, 3, 6};
    public static final int[] SAMPLE_RATE_BY_FSCOD = {OpusReader.SAMPLE_RATE, 44100, 32000};
    public static final int[] SAMPLE_RATE_BY_FSCOD2 = {24000, 22050, 16000};
    public static final int[] CHANNEL_COUNT_BY_ACMOD = {2, 1, 2, 3, 3, 4, 4, 5};
    public static final int[] BITRATE_BY_HALF_FRMSIZECOD = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 384, FileUtils.S_IRWXU, 512, 576, 640};
    public static final int[] SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1 = {69, 87, 104, 121, Cea708Decoder.COMMAND_TGW, MatroskaExtractor.ID_TRACK_ENTRY, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int getAc3SyncframeAudioSampleCount() {
        return 1536;
    }

    /* loaded from: classes9.dex */
    public static final class Ac3SyncFrameInfo {
        public static final int STREAM_TYPE_TYPE0 = 0;
        public static final int STREAM_TYPE_TYPE1 = 1;
        public static final int STREAM_TYPE_TYPE2 = 2;
        public static final int STREAM_TYPE_UNDEFINED = -1;
        public final int channelCount;
        public final int frameSize;
        public final String mimeType;
        public final int sampleCount;
        public final int sampleRate;
        public final int streamType;

        public Ac3SyncFrameInfo(String str, int i, int i2, int i3, int i4, int i5) {
            this.mimeType = str;
            this.streamType = i;
            this.channelCount = i2;
            this.sampleRate = i3;
            this.frameSize = i4;
            this.sampleCount = i5;
        }
    }

    public static int getAc3SyncframeSize(int i, int i2) {
        int i3 = i2 / 2;
        if (i >= 0) {
            int[] iArr = SAMPLE_RATE_BY_FSCOD;
            if (i < iArr.length && i2 >= 0) {
                int[] iArr2 = SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1;
                if (i3 < iArr2.length) {
                    int i4 = iArr[i];
                    if (i4 == 44100) {
                        return (iArr2[i3] + (i2 % 2)) * 2;
                    }
                    int i5 = BITRATE_BY_HALF_FRMSIZECOD[i3];
                    if (i4 == 32000) {
                        return i5 * 6;
                    }
                    return i5 * 4;
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }

    public static Format parseAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        int i = SAMPLE_RATE_BY_FSCOD[(parsableByteArray.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i2 = CHANNEL_COUNT_BY_ACMOD[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return Format.createAudioSampleFormat(str, MimeTypes.AUDIO_AC3, null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }

    public static Ac3SyncFrameInfo parseAc3SyncframeInfo(ParsableBitArray parsableBitArray) {
        boolean z;
        int i;
        int i2;
        int i3;
        String str;
        int i4;
        int i5;
        int i6;
        int position = parsableBitArray.getPosition();
        parsableBitArray.skipBits(40);
        if (parsableBitArray.readBits(5) == 16) {
            z = true;
        } else {
            z = false;
        }
        parsableBitArray.setPosition(position);
        int i7 = 6;
        if (z) {
            parsableBitArray.skipBits(16);
            int readBits = parsableBitArray.readBits(2);
            parsableBitArray.skipBits(3);
            int readBits2 = (parsableBitArray.readBits(11) + 1) * 2;
            int readBits3 = parsableBitArray.readBits(2);
            if (readBits3 == 3) {
                i6 = SAMPLE_RATE_BY_FSCOD2[parsableBitArray.readBits(2)];
            } else {
                i7 = BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[parsableBitArray.readBits(2)];
                i6 = SAMPLE_RATE_BY_FSCOD[readBits3];
            }
            i3 = parsableBitArray.readBits(3);
            i4 = readBits;
            i2 = readBits2;
            i = i6;
            i5 = i7 * 256;
            str = MimeTypes.AUDIO_E_AC3;
        } else {
            parsableBitArray.skipBits(32);
            int readBits4 = parsableBitArray.readBits(2);
            int ac3SyncframeSize = getAc3SyncframeSize(readBits4, parsableBitArray.readBits(6));
            parsableBitArray.skipBits(8);
            int readBits5 = parsableBitArray.readBits(3);
            if ((readBits5 & 1) != 0 && readBits5 != 1) {
                parsableBitArray.skipBits(2);
            }
            if ((readBits5 & 4) != 0) {
                parsableBitArray.skipBits(2);
            }
            if (readBits5 == 2) {
                parsableBitArray.skipBits(2);
            }
            i = SAMPLE_RATE_BY_FSCOD[readBits4];
            i2 = ac3SyncframeSize;
            i3 = readBits5;
            str = MimeTypes.AUDIO_AC3;
            i4 = -1;
            i5 = 1536;
        }
        return new Ac3SyncFrameInfo(str, i4, CHANNEL_COUNT_BY_ACMOD[i3] + (parsableBitArray.readBit() ? 1 : 0), i, i2, i5);
    }

    public static int parseAc3SyncframeSize(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        return getAc3SyncframeSize((bArr[4] & ExifInterface.MARKER_SOF0) >> 6, bArr[4] & 63);
    }

    public static int parseEAc3SyncframeAudioSampleCount(ByteBuffer byteBuffer) {
        int i = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & ExifInterface.MARKER_SOF0) >> 6) != 3) {
            i = BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * 256;
    }

    public static Format parseEAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        parsableByteArray.skipBytes(2);
        int i = SAMPLE_RATE_BY_FSCOD[(parsableByteArray.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i2 = CHANNEL_COUNT_BY_ACMOD[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        if (((parsableByteArray.readUnsignedByte() & 30) >> 1) > 0 && (2 & parsableByteArray.readUnsignedByte()) != 0) {
            i2 += 2;
        }
        return Format.createAudioSampleFormat(str, MimeTypes.AUDIO_E_AC3, null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }
}
