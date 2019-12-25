package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.j;
import com.google.android.exoplayer2.util.l;
/* loaded from: classes4.dex */
final class d extends TagPayloadReader {
    private int frameType;
    private boolean lZQ;
    private final l mai;
    private final l maj;
    private int mak;

    public d(m mVar) {
        super(mVar);
        this.mai = new l(j.mCx);
        this.maj = new l(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean a(l lVar) throws TagPayloadReader.UnsupportedFormatException {
        int readUnsignedByte = lVar.readUnsignedByte();
        int i = (readUnsignedByte >> 4) & 15;
        int i2 = readUnsignedByte & 15;
        if (i2 != 7) {
            throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i2);
        }
        this.frameType = i;
        return i != 5;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected void a(l lVar, long j) throws ParserException {
        int readUnsignedByte = lVar.readUnsignedByte();
        long dxa = (lVar.dxa() * 1000) + j;
        if (readUnsignedByte == 0 && !this.lZQ) {
            l lVar2 = new l(new byte[lVar.dwV()]);
            lVar.D(lVar2.data, 0, lVar.dwV());
            com.google.android.exoplayer2.video.a ag = com.google.android.exoplayer2.video.a.ag(lVar2);
            this.mak = ag.mak;
            this.mah.h(Format.a((String) null, "video/avc", (String) null, -1, -1, ag.width, ag.height, -1.0f, ag.initializationData, -1, ag.mCO, (DrmInitData) null));
            this.lZQ = true;
        } else if (readUnsignedByte == 1 && this.lZQ) {
            byte[] bArr = this.maj.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i = 4 - this.mak;
            int i2 = 0;
            while (lVar.dwV() > 0) {
                lVar.D(this.maj.data, i, this.mak);
                this.maj.setPosition(0);
                int dxg = this.maj.dxg();
                this.mai.setPosition(0);
                this.mah.a(this.mai, 4);
                this.mah.a(lVar, dxg);
                i2 = i2 + 4 + dxg;
            }
            this.mah.a(dxa, this.frameType == 1 ? 1 : 0, i2, 0, null);
        }
    }
}
