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
/* loaded from: classes6.dex */
final class a extends TagPayloadReader {
    private static final int[] mer = {5512, RequestResponseCode.REQUEST_LOGIN_PB_AT, 22050, StreamConfig.Audio.AUDIO_FREQUENCY};
    private boolean mes;
    private boolean met;
    private int meu;

    public a(m mVar) {
        super(mVar);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean a(l lVar) throws TagPayloadReader.UnsupportedFormatException {
        if (!this.mes) {
            int readUnsignedByte = lVar.readUnsignedByte();
            this.meu = (readUnsignedByte >> 4) & 15;
            if (this.meu == 2) {
                this.meJ.h(Format.a(null, "audio/mpeg", null, -1, -1, 1, mer[(readUnsignedByte >> 2) & 3], null, null, 0, null));
                this.met = true;
            } else if (this.meu == 7 || this.meu == 8) {
                this.meJ.h(Format.a((String) null, this.meu == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", (String) null, -1, -1, 1, 8000, (readUnsignedByte & 1) == 1 ? 2 : 3, (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
                this.met = true;
            } else if (this.meu != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.meu);
            }
            this.mes = true;
            return true;
        }
        lVar.skipBytes(1);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected void a(l lVar, long j) throws ParserException {
        if (this.meu == 2) {
            int dzr = lVar.dzr();
            this.meJ.a(lVar, dzr);
            this.meJ.a(j, 1, dzr, 0, null);
            return;
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        if (readUnsignedByte == 0 && !this.met) {
            byte[] bArr = new byte[lVar.dzr()];
            lVar.G(bArr, 0, bArr.length);
            Pair<Integer, Integer> az = com.google.android.exoplayer2.util.c.az(bArr);
            this.meJ.h(Format.a(null, "audio/mp4a-latm", null, -1, -1, ((Integer) az.second).intValue(), ((Integer) az.first).intValue(), Collections.singletonList(bArr), null, 0, null));
            this.met = true;
        } else if (this.meu != 10 || readUnsignedByte == 1) {
            int dzr2 = lVar.dzr();
            this.meJ.a(lVar, dzr2);
            this.meJ.a(j, 1, dzr2, 0, null);
        }
    }
}
