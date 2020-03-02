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
    private final l meM;
    private final l meN;
    private int meO;
    private boolean mev;

    public d(m mVar) {
        super(mVar);
        this.meM = new l(j.mHb);
        this.meN = new l(4);
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
        long dzy = (lVar.dzy() * 1000) + j;
        if (readUnsignedByte == 0 && !this.mev) {
            l lVar2 = new l(new byte[lVar.dzt()]);
            lVar.G(lVar2.data, 0, lVar.dzt());
            com.google.android.exoplayer2.video.a ag = com.google.android.exoplayer2.video.a.ag(lVar2);
            this.meO = ag.meO;
            this.meL.h(Format.a((String) null, "video/avc", (String) null, -1, -1, ag.width, ag.height, -1.0f, ag.initializationData, -1, ag.mHr, (DrmInitData) null));
            this.mev = true;
        } else if (readUnsignedByte == 1 && this.mev) {
            byte[] bArr = this.meN.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i = 4 - this.meO;
            int i2 = 0;
            while (lVar.dzt() > 0) {
                lVar.G(this.meN.data, i, this.meO);
                this.meN.setPosition(0);
                int dzE = this.meN.dzE();
                this.meM.setPosition(0);
                this.meL.a(this.meM, 4);
                this.meL.a(lVar, dzE);
                i2 = i2 + 4 + dzE;
            }
            this.meL.a(dzy, this.frameType == 1 ? 1 : 0, i2, 0, null);
        }
    }
}
