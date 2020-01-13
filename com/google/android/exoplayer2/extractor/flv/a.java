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
/* loaded from: classes5.dex */
final class a extends TagPayloadReader {
    private static final int[] mdG = {5512, RequestResponseCode.REQUEST_LOGIN_PB_AT, 22050, StreamConfig.Audio.AUDIO_FREQUENCY};
    private boolean mdH;
    private boolean mdI;
    private int mdJ;

    public a(m mVar) {
        super(mVar);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean a(l lVar) throws TagPayloadReader.UnsupportedFormatException {
        if (!this.mdH) {
            int readUnsignedByte = lVar.readUnsignedByte();
            this.mdJ = (readUnsignedByte >> 4) & 15;
            if (this.mdJ == 2) {
                this.mdY.h(Format.a(null, "audio/mpeg", null, -1, -1, 1, mdG[(readUnsignedByte >> 2) & 3], null, null, 0, null));
                this.mdI = true;
            } else if (this.mdJ == 7 || this.mdJ == 8) {
                this.mdY.h(Format.a((String) null, this.mdJ == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", (String) null, -1, -1, 1, 8000, (readUnsignedByte & 1) == 1 ? 2 : 3, (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
                this.mdI = true;
            } else if (this.mdJ != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.mdJ);
            }
            this.mdH = true;
            return true;
        }
        lVar.skipBytes(1);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected void a(l lVar, long j) throws ParserException {
        if (this.mdJ == 2) {
            int dyf = lVar.dyf();
            this.mdY.a(lVar, dyf);
            this.mdY.a(j, 1, dyf, 0, null);
            return;
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        if (readUnsignedByte == 0 && !this.mdI) {
            byte[] bArr = new byte[lVar.dyf()];
            lVar.C(bArr, 0, bArr.length);
            Pair<Integer, Integer> au = com.google.android.exoplayer2.util.c.au(bArr);
            this.mdY.h(Format.a(null, "audio/mp4a-latm", null, -1, -1, ((Integer) au.second).intValue(), ((Integer) au.first).intValue(), Collections.singletonList(bArr), null, 0, null));
            this.mdI = true;
        } else if (this.mdJ != 10 || readUnsignedByte == 1) {
            int dyf2 = lVar.dyf();
            this.mdY.a(lVar, dyf2);
            this.mdY.a(j, 1, dyf2, 0, null);
        }
    }
}
