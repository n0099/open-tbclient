package com.google.android.exoplayer2.audio;

import com.baidu.ala.player.StreamConfig;
import com.baidu.down.manage.DownloadConstants;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.l;
import java.nio.ByteBuffer;
import org.apache.http.HttpStatus;
/* loaded from: classes4.dex */
public final class a {
    private static final int[] lVT = {1, 2, 3, 6};
    private static final int[] lVU = {StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, StreamConfig.Audio.AUDIO_FREQUENCY, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_32K};
    private static final int[] lVV = {24000, 22050, 16000};
    private static final int[] lVW = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] lVX = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, DownloadConstants.STATUS_RUNNING, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] lVY = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, HttpStatus.SC_EXPECTATION_FAILED, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* renamed from: com.google.android.exoplayer2.audio.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0656a {
        public final int channelCount;
        public final int frameSize;
        public final String mimeType;
        public final int sampleCount;
        public final int sampleRate;
        public final int streamType;

        private C0656a(String str, int i, int i2, int i3, int i4, int i5) {
            this.mimeType = str;
            this.streamType = i;
            this.channelCount = i2;
            this.sampleRate = i3;
            this.frameSize = i4;
            this.sampleCount = i5;
        }
    }

    public static Format a(l lVar, String str, String str2, DrmInitData drmInitData) {
        int i = lVU[(lVar.readUnsignedByte() & DownloadConstants.STATUS_RUNNING) >> 6];
        int readUnsignedByte = lVar.readUnsignedByte();
        int i2 = lVW[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return Format.a(str, "audio/ac3", null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }

    public static Format b(l lVar, String str, String str2, DrmInitData drmInitData) {
        lVar.skipBytes(2);
        int i = lVU[(lVar.readUnsignedByte() & DownloadConstants.STATUS_RUNNING) >> 6];
        int readUnsignedByte = lVar.readUnsignedByte();
        int i2 = lVW[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        return Format.a(str, "audio/eac3", null, -1, -1, (((lVar.readUnsignedByte() & 30) >> 1) <= 0 || (lVar.readUnsignedByte() & 2) == 0) ? i2 : i2 + 2, i, null, drmInitData, 0, str2);
    }

    public static C0656a a(com.google.android.exoplayer2.util.k kVar) {
        int dH;
        int readBits;
        int i;
        int i2;
        String str;
        int i3;
        int i4;
        int position = kVar.getPosition();
        kVar.JG(40);
        boolean z = kVar.readBits(5) == 16;
        kVar.setPosition(position);
        int i5 = -1;
        if (z) {
            kVar.JG(16);
            i5 = kVar.readBits(2);
            kVar.JG(3);
            dH = (kVar.readBits(11) + 1) * 2;
            int readBits2 = kVar.readBits(2);
            if (readBits2 == 3) {
                i4 = lVV[kVar.readBits(2)];
                i3 = 6;
            } else {
                i3 = lVT[kVar.readBits(2)];
                i4 = lVU[readBits2];
            }
            i2 = i3 * 256;
            readBits = kVar.readBits(3);
            int i6 = i4;
            str = "audio/eac3";
            i = i6;
        } else {
            kVar.JG(32);
            int readBits3 = kVar.readBits(2);
            dH = dH(readBits3, kVar.readBits(6));
            kVar.JG(8);
            readBits = kVar.readBits(3);
            if ((readBits & 1) != 0 && readBits != 1) {
                kVar.JG(2);
            }
            if ((readBits & 4) != 0) {
                kVar.JG(2);
            }
            if (readBits == 2) {
                kVar.JG(2);
            }
            i = lVU[readBits3];
            i2 = 1536;
            str = "audio/ac3";
        }
        return new C0656a(str, i5, (kVar.dsM() ? 1 : 0) + lVW[readBits], i, dH, i2);
    }

    public static int am(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        return dH((bArr[4] & 192) >> 6, bArr[4] & 63);
    }

    public static int drj() {
        return 1536;
    }

    public static int h(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) == 3 ? 6 : lVT[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4]) * 256;
    }

    private static int dH(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0 || i >= lVU.length || i2 < 0 || i3 >= lVY.length) {
            return -1;
        }
        int i4 = lVU[i];
        if (i4 == 44100) {
            return (lVY[i3] + (i2 % 2)) * 2;
        }
        int i5 = lVX[i3];
        if (i4 == 32000) {
            return i5 * 6;
        }
        return i5 * 4;
    }
}
