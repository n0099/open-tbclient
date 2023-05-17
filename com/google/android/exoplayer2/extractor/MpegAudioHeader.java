package com.google.android.exoplayer2.extractor;

import android.support.v4.media.session.MediaSessionCompat;
import com.baidu.pass.face.platform.utils.FileUtils;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.google.android.exoplayer2.extractor.ogg.OpusReader;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.exoplayer2.util.MimeTypes;
import com.googlecode.mp4parser.authoring.tracks.MP3TrackImpl;
/* loaded from: classes9.dex */
public final class MpegAudioHeader {
    public static final int MAX_FRAME_SIZE_BYTES = 4096;
    public int bitrate;
    public int channels;
    public int frameSize;
    public String mimeType;
    public int sampleRate;
    public int samplesPerFrame;
    public int version;
    public static final String[] MIME_TYPE_BY_LAYER = {MimeTypes.AUDIO_MPEG_L1, MimeTypes.AUDIO_MPEG_L2, MimeTypes.AUDIO_MPEG};
    public static final int[] SAMPLING_RATE_V1 = {44100, OpusReader.SAMPLE_RATE, 32000};
    public static final int[] BITRATE_V1_L1 = {32, 64, 96, 128, 160, 192, 224, 256, 288, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 352, 384, 416, FileUtils.S_IRWXU};
    public static final int[] BITRATE_V2_L1 = {32, 48, 56, 64, 80, 96, 112, 128, Cea708Decoder.COMMAND_SPA, 160, MatroskaExtractor.ID_PIXEL_WIDTH, 192, 224, 256};
    public static final int[] BITRATE_V1_L2 = {32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 384};
    public static final int[] BITRATE_V1_L3 = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP};
    public static final int[] BITRATE_V2 = {8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, Cea708Decoder.COMMAND_SPA, 160};

    public static int getFrameSize(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if ((i & (-2097152)) != -2097152 || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return -1;
        }
        int i8 = SAMPLING_RATE_V1[i5];
        if (i2 == 2) {
            i8 /= 2;
        } else if (i2 == 0) {
            i8 /= 4;
        }
        int i9 = (i >>> 9) & 1;
        if (i3 == 3) {
            if (i2 == 3) {
                i7 = BITRATE_V1_L1[i4 - 1];
            } else {
                i7 = BITRATE_V2_L1[i4 - 1];
            }
            return (((i7 * 12000) / i8) + i9) * 4;
        }
        if (i2 == 3) {
            if (i3 == 2) {
                i6 = BITRATE_V1_L2[i4 - 1];
            } else {
                i6 = BITRATE_V1_L3[i4 - 1];
            }
        } else {
            i6 = BITRATE_V2[i4 - 1];
        }
        int i10 = 144000;
        if (i2 == 3) {
            return ((i6 * 144000) / i8) + i9;
        }
        if (i3 == 1) {
            i10 = DefaultOggSeeker.MATCH_RANGE;
        }
        return ((i10 * i6) / i8) + i9;
    }

    public static boolean populateHeader(int i, MpegAudioHeader mpegAudioHeader) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if ((i & (-2097152)) != -2097152 || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return false;
        }
        int i10 = SAMPLING_RATE_V1[i5];
        if (i2 == 2) {
            i10 /= 2;
        } else if (i2 == 0) {
            i10 /= 4;
        }
        int i11 = i10;
        int i12 = (i >>> 9) & 1;
        int i13 = MP3TrackImpl.SAMPLES_PER_FRAME;
        if (i3 == 3) {
            if (i2 == 3) {
                i6 = BITRATE_V1_L1[i4 - 1];
            } else {
                i6 = BITRATE_V2_L1[i4 - 1];
            }
            i7 = (((i6 * 12000) / i11) + i12) * 4;
            i8 = 384;
        } else {
            int i14 = 144000;
            if (i2 == 3) {
                if (i3 == 2) {
                    i6 = BITRATE_V1_L2[i4 - 1];
                } else {
                    i6 = BITRATE_V1_L3[i4 - 1];
                }
                i7 = ((144000 * i6) / i11) + i12;
                i8 = MP3TrackImpl.SAMPLES_PER_FRAME;
            } else {
                i6 = BITRATE_V2[i4 - 1];
                if (i3 == 1) {
                    i13 = 576;
                }
                if (i3 == 1) {
                    i14 = DefaultOggSeeker.MATCH_RANGE;
                }
                i7 = ((i14 * i6) / i11) + i12;
                i8 = i13;
            }
        }
        String str = MIME_TYPE_BY_LAYER[3 - i3];
        if (((i >> 6) & 3) == 3) {
            i9 = 1;
        } else {
            i9 = 2;
        }
        mpegAudioHeader.setValues(i2, str, i7, i11, i9, i6 * 1000, i8);
        return true;
    }

    private void setValues(int i, String str, int i2, int i3, int i4, int i5, int i6) {
        this.version = i;
        this.mimeType = str;
        this.frameSize = i2;
        this.sampleRate = i3;
        this.channels = i4;
        this.bitrate = i5;
        this.samplesPerFrame = i6;
    }
}
