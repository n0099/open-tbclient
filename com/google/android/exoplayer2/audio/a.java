package com.google.android.exoplayer2.audio;

import com.baidu.ala.player.StreamConfig;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.l;
import java.nio.ByteBuffer;
import org.apache.http.HttpStatus;
/* loaded from: classes6.dex */
public final class a {
    private static final int[] mcp = {1, 2, 3, 6};
    private static final int[] mcq = {StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, StreamConfig.Audio.AUDIO_FREQUENCY, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_32K};
    private static final int[] mcr = {24000, 22050, 16000};
    private static final int[] mcs = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] mct = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] mcu = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, HttpStatus.SC_EXPECTATION_FAILED, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* renamed from: com.google.android.exoplayer2.audio.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0671a {
        public final int channelCount;
        public final int frameSize;
        public final String mimeType;
        public final int sampleCount;
        public final int sampleRate;
        public final int streamType;

        private C0671a(String str, int i, int i2, int i3, int i4, int i5) {
            this.mimeType = str;
            this.streamType = i;
            this.channelCount = i2;
            this.sampleRate = i3;
            this.frameSize = i4;
            this.sampleCount = i5;
        }
    }

    public static Format a(l lVar, String str, String str2, DrmInitData drmInitData) {
        int i = mcq[(lVar.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = lVar.readUnsignedByte();
        int i2 = mcs[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return Format.a(str, "audio/ac3", null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }

    public static Format b(l lVar, String str, String str2, DrmInitData drmInitData) {
        lVar.skipBytes(2);
        int i = mcq[(lVar.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = lVar.readUnsignedByte();
        int i2 = mcs[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        return Format.a(str, "audio/eac3", null, -1, -1, (((lVar.readUnsignedByte() & 30) >> 1) <= 0 || (lVar.readUnsignedByte() & 2) == 0) ? i2 : i2 + 2, i, null, drmInitData, 0, str2);
    }

    public static C0671a a(com.google.android.exoplayer2.util.k kVar) {
        int dJ;
        int readBits;
        int i;
        int i2;
        String str;
        int i3;
        int i4;
        int position = kVar.getPosition();
        kVar.Ka(40);
        boolean z = kVar.readBits(5) == 16;
        kVar.setPosition(position);
        int i5 = -1;
        if (z) {
            kVar.Ka(16);
            i5 = kVar.readBits(2);
            kVar.Ka(3);
            dJ = (kVar.readBits(11) + 1) * 2;
            int readBits2 = kVar.readBits(2);
            if (readBits2 == 3) {
                i4 = mcr[kVar.readBits(2)];
                i3 = 6;
            } else {
                i3 = mcp[kVar.readBits(2)];
                i4 = mcq[readBits2];
            }
            i2 = i3 * 256;
            readBits = kVar.readBits(3);
            int i6 = i4;
            str = "audio/eac3";
            i = i6;
        } else {
            kVar.Ka(32);
            int readBits3 = kVar.readBits(2);
            dJ = dJ(readBits3, kVar.readBits(6));
            kVar.Ka(8);
            readBits = kVar.readBits(3);
            if ((readBits & 1) != 0 && readBits != 1) {
                kVar.Ka(2);
            }
            if ((readBits & 4) != 0) {
                kVar.Ka(2);
            }
            if (readBits == 2) {
                kVar.Ka(2);
            }
            i = mcq[readBits3];
            i2 = 1536;
            str = "audio/ac3";
        }
        return new C0671a(str, i5, (kVar.dvL() ? 1 : 0) + mcs[readBits], i, dJ, i2);
    }

    public static int aq(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        return dJ((bArr[4] & 192) >> 6, bArr[4] & 63);
    }

    public static int dui() {
        return 1536;
    }

    public static int h(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) == 3 ? 6 : mcp[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4]) * 256;
    }

    private static int dJ(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0 || i >= mcq.length || i2 < 0 || i3 >= mcu.length) {
            return -1;
        }
        int i4 = mcq[i];
        if (i4 == 44100) {
            return (mcu[i3] + (i2 % 2)) * 2;
        }
        int i5 = mct[i3];
        if (i4 == 32000) {
            return i5 * 6;
        }
        return i5 * 4;
    }
}
