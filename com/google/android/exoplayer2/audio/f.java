package com.google.android.exoplayer2.audio;

import com.baidu.ala.player.StreamConfig;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.sina.weibo.sdk.constant.WBConstants;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public final class f {
    private static final int[] mbJ = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] mbK = {-1, 8000, 16000, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_32K, -1, -1, RequestResponseCode.REQUEST_LOGIN_PB_AT, 22050, StreamConfig.Audio.AUDIO_FREQUENCY, -1, -1, 12000, 24000, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, -1, -1};
    private static final int[] mbL = {64, 112, 128, DownloadConstants.STATUS_RUNNING, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, WBConstants.SDK_NEW_PAY_VERSION, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static Format a(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        com.google.android.exoplayer2.util.k kVar = new com.google.android.exoplayer2.util.k(bArr);
        kVar.JP(60);
        int i = mbJ[kVar.readBits(6)];
        int i2 = mbK[kVar.readBits(4)];
        int readBits = kVar.readBits(5);
        int i3 = readBits >= mbL.length ? -1 : (mbL[readBits] * 1000) / 2;
        kVar.JP(10);
        return Format.a(str, "audio/vnd.dts", null, i3, -1, i + (kVar.readBits(2) > 0 ? 1 : 0), i2, null, drmInitData, 0, str2);
    }

    public static int am(byte[] bArr) {
        return ((((bArr[4] & 1) << 6) | ((bArr[5] & 252) >> 2)) + 1) * 32;
    }

    public static int j(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        return ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) * 32;
    }

    public static int an(byte[] bArr) {
        return (((bArr[5] & 2) << 12) | ((bArr[6] & 255) << 4) | ((bArr[7] & 240) >> 4)) + 1;
    }
}
