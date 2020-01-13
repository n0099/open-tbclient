package com.google.android.exoplayer2.extractor;

import com.baidu.ala.player.StreamConfig;
import com.baidu.down.manage.DownloadConstants;
import org.apache.http.HttpStatus;
/* loaded from: classes5.dex */
public final class j {
    public int bitrate;
    public int channels;
    public int frameSize;
    public String mimeType;
    public int sampleRate;
    public int samplesPerFrame;
    public int version;
    private static final String[] mdx = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] mdy = {StreamConfig.Audio.AUDIO_FREQUENCY, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_32K};
    private static final int[] mdz = {32, 64, 96, 128, 160, DownloadConstants.STATUS_RUNNING, 224, 256, 288, 320, 352, 384, HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE, 448};
    private static final int[] mdA = {32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, DownloadConstants.STATUS_RUNNING, 224, 256};
    private static final int[] mdB = {32, 48, 56, 64, 80, 96, 112, 128, 160, DownloadConstants.STATUS_RUNNING, 224, 256, 320, 384};
    private static final int[] mdC = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, DownloadConstants.STATUS_RUNNING, 224, 256, 320};
    private static final int[] mdD = {8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};

    public static int Jx(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if ((i & (-2097152)) != -2097152 || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return -1;
        }
        int i8 = mdy[i5];
        if (i2 == 2) {
            i6 = i8 / 2;
        } else {
            i6 = i2 == 0 ? i8 / 4 : i8;
        }
        int i9 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? mdz[i4 - 1] : mdA[i4 - 1]) * 12000) / i6) + i9) * 4;
        }
        if (i2 == 3) {
            i7 = i3 == 2 ? mdB[i4 - 1] : mdC[i4 - 1];
        } else {
            i7 = mdD[i4 - 1];
        }
        if (i2 == 3) {
            return ((144000 * i7) / i6) + i9;
        }
        return (((i3 == 1 ? 72000 : 144000) * i7) / i6) + i9;
    }

    public static boolean a(int i, j jVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if ((i & (-2097152)) == -2097152 && (i2 = (i >>> 19) & 3) != 1 && (i3 = (i >>> 17) & 3) != 0) {
            int i7 = (i >>> 12) & 15;
            if (i7 == 0 || i7 == 15) {
                return false;
            }
            int i8 = (i >>> 10) & 3;
            if (i8 == 3) {
                return false;
            }
            int i9 = mdy[i8];
            if (i2 == 2) {
                i9 /= 2;
            } else if (i2 == 0) {
                i9 /= 4;
            }
            int i10 = (i >>> 9) & 1;
            if (i3 == 3) {
                i6 = i2 == 3 ? mdz[i7 - 1] : mdA[i7 - 1];
                i5 = (((i6 * 12000) / i9) + i10) * 4;
                i4 = 384;
            } else if (i2 == 3) {
                i6 = i3 == 2 ? mdB[i7 - 1] : mdC[i7 - 1];
                i4 = 1152;
                i5 = i10 + ((144000 * i6) / i9);
            } else {
                int i11 = mdD[i7 - 1];
                i4 = i3 == 1 ? 576 : 1152;
                i5 = i10 + (((i3 == 1 ? 72000 : 144000) * i11) / i9);
                i6 = i11;
            }
            jVar.a(i2, mdx[3 - i3], i5, i9, ((i >> 6) & 3) == 3 ? 1 : 2, i6 * 1000, i4);
            return true;
        }
        return false;
    }

    private void a(int i, String str, int i2, int i3, int i4, int i5, int i6) {
        this.version = i;
        this.mimeType = str;
        this.frameSize = i2;
        this.sampleRate = i3;
        this.channels = i4;
        this.bitrate = i5;
        this.samplesPerFrame = i6;
    }
}
