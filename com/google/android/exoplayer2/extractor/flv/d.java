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
    private boolean meG;
    private final l meX;
    private final l meY;
    private int meZ;

    public d(m mVar) {
        super(mVar);
        this.meX = new l(j.mHm);
        this.meY = new l(4);
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
        long dzz = (lVar.dzz() * 1000) + j;
        if (readUnsignedByte == 0 && !this.meG) {
            l lVar2 = new l(new byte[lVar.dzu()]);
            lVar.G(lVar2.data, 0, lVar.dzu());
            com.google.android.exoplayer2.video.a ag = com.google.android.exoplayer2.video.a.ag(lVar2);
            this.meZ = ag.meZ;
            this.meW.h(Format.a((String) null, "video/avc", (String) null, -1, -1, ag.width, ag.height, -1.0f, ag.initializationData, -1, ag.mHC, (DrmInitData) null));
            this.meG = true;
        } else if (readUnsignedByte == 1 && this.meG) {
            byte[] bArr = this.meY.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i = 4 - this.meZ;
            int i2 = 0;
            while (lVar.dzu() > 0) {
                lVar.G(this.meY.data, i, this.meZ);
                this.meY.setPosition(0);
                int dzF = this.meY.dzF();
                this.meX.setPosition(0);
                this.meW.a(this.meX, 4);
                this.meW.a(lVar, dzF);
                i2 = i2 + 4 + dzF;
            }
            this.meW.a(dzz, this.frameType == 1 ? 1 : 0, i2, 0, null);
        }
    }
}
