package com.google.android.exoplayer2.audio;

import com.baidu.pass.face.platform.utils.FileUtils;
import com.baidu.tieba.r81;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ogg.OpusReader;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.googlecode.mp4parser.authoring.tracks.MP3TrackImpl;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public final class DtsUtil {
    public static final int[] CHANNELS_BY_AMODE = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    public static final int[] SAMPLE_RATE_BY_SFREQ = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, OpusReader.SAMPLE_RATE, -1, -1};
    public static final int[] TWICE_BITRATE_KBPS_BY_RATE = {64, 112, 128, 192, 224, 256, 384, FileUtils.S_IRWXU, 512, 640, 768, 896, 1024, MP3TrackImpl.SAMPLES_PER_FRAME, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, r81.a, 3840, 4096, 6144, 7680};

    public static int getDtsFrameSize(byte[] bArr) {
        return (((bArr[7] & 240) >> 4) | ((bArr[5] & 2) << 12) | ((bArr[6] & 255) << 4)) + 1;
    }

    public static int parseDtsAudioSampleCount(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        return ((((byteBuffer.get(position + 5) & Cea608Decoder.CC_IMPLICIT_DATA_HEADER) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) * 32;
    }

    public static int parseDtsAudioSampleCount(byte[] bArr) {
        return ((((bArr[5] & Cea608Decoder.CC_IMPLICIT_DATA_HEADER) >> 2) | ((bArr[4] & 1) << 6)) + 1) * 32;
    }

    public static Format parseDtsFormat(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        int i;
        int i2;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.skipBits(60);
        int i3 = CHANNELS_BY_AMODE[parsableBitArray.readBits(6)];
        int i4 = SAMPLE_RATE_BY_SFREQ[parsableBitArray.readBits(4)];
        int readBits = parsableBitArray.readBits(5);
        int[] iArr = TWICE_BITRATE_KBPS_BY_RATE;
        if (readBits >= iArr.length) {
            i = -1;
        } else {
            i = (iArr[readBits] * 1000) / 2;
        }
        parsableBitArray.skipBits(10);
        if (parsableBitArray.readBits(2) > 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        return Format.createAudioSampleFormat(str, MimeTypes.AUDIO_DTS, null, i, -1, i3 + i2, i4, null, drmInitData, 0, str2);
    }
}
