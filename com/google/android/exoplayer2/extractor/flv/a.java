package com.google.android.exoplayer2.extractor.flv;

import android.util.Pair;
import com.baidu.ala.player.StreamConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.l;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
final class a extends TagPayloadReader {
    private static final int[] lZO = {5512, RequestResponseCode.REQUEST_LOGIN_PB_AT, 22050, StreamConfig.Audio.AUDIO_FREQUENCY};
    private boolean lZP;
    private boolean lZQ;
    private int lZR;

    public a(m mVar) {
        super(mVar);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean a(l lVar) throws TagPayloadReader.UnsupportedFormatException {
        if (!this.lZP) {
            int readUnsignedByte = lVar.readUnsignedByte();
            this.lZR = (readUnsignedByte >> 4) & 15;
            if (this.lZR == 2) {
                this.mah.h(Format.a(null, "audio/mpeg", null, -1, -1, 1, lZO[(readUnsignedByte >> 2) & 3], null, null, 0, null));
                this.lZQ = true;
            } else if (this.lZR == 7 || this.lZR == 8) {
                this.mah.h(Format.a((String) null, this.lZR == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", (String) null, -1, -1, 1, 8000, (readUnsignedByte & 1) == 1 ? 2 : 3, (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
                this.lZQ = true;
            } else if (this.lZR != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.lZR);
            }
            this.lZP = true;
            return true;
        }
        lVar.skipBytes(1);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected void a(l lVar, long j) throws ParserException {
        if (this.lZR == 2) {
            int dwV = lVar.dwV();
            this.mah.a(lVar, dwV);
            this.mah.a(j, 1, dwV, 0, null);
            return;
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        if (readUnsignedByte == 0 && !this.lZQ) {
            byte[] bArr = new byte[lVar.dwV()];
            lVar.D(bArr, 0, bArr.length);
            Pair<Integer, Integer> av = com.google.android.exoplayer2.util.c.av(bArr);
            this.mah.h(Format.a(null, "audio/mp4a-latm", null, -1, -1, ((Integer) av.second).intValue(), ((Integer) av.first).intValue(), Collections.singletonList(bArr), null, 0, null));
            this.lZQ = true;
        } else if (this.lZR != 10 || readUnsignedByte == 1) {
            int dwV2 = lVar.dwV();
            this.mah.a(lVar, dwV2);
            this.mah.a(j, 1, dwV2, 0, null);
        }
    }
}
