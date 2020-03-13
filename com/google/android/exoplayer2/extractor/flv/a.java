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
    private static final int[] meE = {5512, RequestResponseCode.REQUEST_LOGIN_PB_AT, 22050, StreamConfig.Audio.AUDIO_FREQUENCY};
    private boolean meF;
    private boolean meG;
    private int meH;

    public a(m mVar) {
        super(mVar);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean a(l lVar) throws TagPayloadReader.UnsupportedFormatException {
        if (!this.meF) {
            int readUnsignedByte = lVar.readUnsignedByte();
            this.meH = (readUnsignedByte >> 4) & 15;
            if (this.meH == 2) {
                this.meW.h(Format.a(null, "audio/mpeg", null, -1, -1, 1, meE[(readUnsignedByte >> 2) & 3], null, null, 0, null));
                this.meG = true;
            } else if (this.meH == 7 || this.meH == 8) {
                this.meW.h(Format.a((String) null, this.meH == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", (String) null, -1, -1, 1, 8000, (readUnsignedByte & 1) == 1 ? 2 : 3, (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
                this.meG = true;
            } else if (this.meH != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.meH);
            }
            this.meF = true;
            return true;
        }
        lVar.skipBytes(1);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected void a(l lVar, long j) throws ParserException {
        if (this.meH == 2) {
            int dzu = lVar.dzu();
            this.meW.a(lVar, dzu);
            this.meW.a(j, 1, dzu, 0, null);
            return;
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        if (readUnsignedByte == 0 && !this.meG) {
            byte[] bArr = new byte[lVar.dzu()];
            lVar.G(bArr, 0, bArr.length);
            Pair<Integer, Integer> az = com.google.android.exoplayer2.util.c.az(bArr);
            this.meW.h(Format.a(null, "audio/mp4a-latm", null, -1, -1, ((Integer) az.second).intValue(), ((Integer) az.first).intValue(), Collections.singletonList(bArr), null, 0, null));
            this.meG = true;
        } else if (this.meH != 10 || readUnsignedByte == 1) {
            int dzu2 = lVar.dzu();
            this.meW.a(lVar, dzu2);
            this.meW.a(j, 1, dzu2, 0, null);
        }
    }
}
