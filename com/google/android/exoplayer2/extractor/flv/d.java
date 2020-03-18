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
    private final l mgD;
    private final l mgE;
    private int mgF;
    private boolean mgm;

    public d(m mVar) {
        super(mVar);
        this.mgD = new l(j.mIW);
        this.mgE = new l(4);
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
        long dzW = (lVar.dzW() * 1000) + j;
        if (readUnsignedByte == 0 && !this.mgm) {
            l lVar2 = new l(new byte[lVar.dzR()]);
            lVar.G(lVar2.data, 0, lVar.dzR());
            com.google.android.exoplayer2.video.a ag = com.google.android.exoplayer2.video.a.ag(lVar2);
            this.mgF = ag.mgF;
            this.mgC.h(Format.a((String) null, "video/avc", (String) null, -1, -1, ag.width, ag.height, -1.0f, ag.initializationData, -1, ag.mJm, (DrmInitData) null));
            this.mgm = true;
        } else if (readUnsignedByte == 1 && this.mgm) {
            byte[] bArr = this.mgE.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i = 4 - this.mgF;
            int i2 = 0;
            while (lVar.dzR() > 0) {
                lVar.G(this.mgE.data, i, this.mgF);
                this.mgE.setPosition(0);
                int dAc = this.mgE.dAc();
                this.mgD.setPosition(0);
                this.mgC.a(this.mgD, 4);
                this.mgC.a(lVar, dAc);
                i2 = i2 + 4 + dAc;
            }
            this.mgC.a(dzW, this.frameType == 1 ? 1 : 0, i2, 0, null);
        }
    }
}
