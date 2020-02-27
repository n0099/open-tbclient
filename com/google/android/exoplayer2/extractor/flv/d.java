package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.j;
import com.google.android.exoplayer2.util.l;
/* loaded from: classes6.dex */
final class d extends TagPayloadReader {
    private int frameType;
    private final l meK;
    private final l meL;
    private int meM;
    private boolean met;

    public d(m mVar) {
        super(mVar);
        this.meK = new l(j.mGZ);
        this.meL = new l(4);
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
        long dzw = (lVar.dzw() * 1000) + j;
        if (readUnsignedByte == 0 && !this.met) {
            l lVar2 = new l(new byte[lVar.dzr()]);
            lVar.G(lVar2.data, 0, lVar.dzr());
            com.google.android.exoplayer2.video.a ag = com.google.android.exoplayer2.video.a.ag(lVar2);
            this.meM = ag.meM;
            this.meJ.h(Format.a((String) null, "video/avc", (String) null, -1, -1, ag.width, ag.height, -1.0f, ag.initializationData, -1, ag.mHp, (DrmInitData) null));
            this.met = true;
        } else if (readUnsignedByte == 1 && this.met) {
            byte[] bArr = this.meL.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i = 4 - this.meM;
            int i2 = 0;
            while (lVar.dzr() > 0) {
                lVar.G(this.meL.data, i, this.meM);
                this.meL.setPosition(0);
                int dzC = this.meL.dzC();
                this.meK.setPosition(0);
                this.meJ.a(this.meK, 4);
                this.meJ.a(lVar, dzC);
                i2 = i2 + 4 + dzC;
            }
            this.meJ.a(dzw, this.frameType == 1 ? 1 : 0, i2, 0, null);
        }
    }
}
