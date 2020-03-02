package com.google.android.exoplayer2.extractor.d;

import com.baidu.ala.player.StreamConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.d.h;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
final class g extends h {
    private static final int mlE = v.QE("Opus");
    private static final byte[] mlF = {79, 112, 117, 115, 72, Constants.SHORT_PING_CMD_TYPE, 97, 100};
    private boolean mlG;

    public static boolean A(l lVar) {
        if (lVar.dzt() < mlF.length) {
            return false;
        }
        byte[] bArr = new byte[mlF.length];
        lVar.G(bArr, 0, mlF.length);
        return Arrays.equals(bArr, mlF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.d.h
    public void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.mlG = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected long B(l lVar) {
        return fV(ax(lVar.data));
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected boolean a(l lVar, long j, h.a aVar) throws IOException, InterruptedException {
        if (!this.mlG) {
            byte[] copyOf = Arrays.copyOf(lVar.data, lVar.dzu());
            int i = copyOf[9] & 255;
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(copyOf);
            q(arrayList, ((copyOf[11] & 255) << 8) | (copyOf[10] & 255));
            q(arrayList, 3840);
            aVar.lZy = Format.a(null, "audio/opus", null, -1, -1, i, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, arrayList, null, 0, null);
            this.mlG = true;
            return true;
        }
        boolean z = lVar.readInt() == mlE;
        lVar.setPosition(0);
        return z;
    }

    private void q(List<byte[]> list, int i) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((i * 1000000000) / 48000).array());
    }

    private long ax(byte[] bArr) {
        int i;
        int i2;
        int i3 = bArr[0] & 255;
        switch (i3 & 3) {
            case 0:
                i = 1;
                break;
            case 1:
            case 2:
                i = 2;
                break;
            default:
                i = bArr[1] & 63;
                break;
        }
        int i4 = i3 >> 3;
        int i5 = i4 & 3;
        if (i4 >= 16) {
            i2 = TbConfig.NOTIFY_YUN_PUSH << i5;
        } else if (i4 >= 12) {
            i2 = 10000 << (i5 & 1);
        } else if (i5 == 3) {
            i2 = 60000;
        } else {
            i2 = 10000 << i5;
        }
        return i2 * i;
    }
}
