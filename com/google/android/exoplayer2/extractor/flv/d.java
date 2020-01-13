package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.j;
import com.google.android.exoplayer2.util.l;
/* loaded from: classes5.dex */
final class d extends TagPayloadReader {
    private int frameType;
    private boolean mdI;
    private final l mdZ;
    private final l mea;
    private int meb;

    public d(m mVar) {
        super(mVar);
        this.mdZ = new l(j.mGo);
        this.mea = new l(4);
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
        long dyk = (lVar.dyk() * 1000) + j;
        if (readUnsignedByte == 0 && !this.mdI) {
            l lVar2 = new l(new byte[lVar.dyf()]);
            lVar.C(lVar2.data, 0, lVar.dyf());
            com.google.android.exoplayer2.video.a ag = com.google.android.exoplayer2.video.a.ag(lVar2);
            this.meb = ag.meb;
            this.mdY.h(Format.a((String) null, "video/avc", (String) null, -1, -1, ag.width, ag.height, -1.0f, ag.initializationData, -1, ag.mGF, (DrmInitData) null));
            this.mdI = true;
        } else if (readUnsignedByte == 1 && this.mdI) {
            byte[] bArr = this.mea.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i = 4 - this.meb;
            int i2 = 0;
            while (lVar.dyf() > 0) {
                lVar.C(this.mea.data, i, this.meb);
                this.mea.setPosition(0);
                int dyq = this.mea.dyq();
                this.mdZ.setPosition(0);
                this.mdY.a(this.mdZ, 4);
                this.mdY.a(lVar, dyq);
                i2 = i2 + 4 + dyq;
            }
            this.mdY.a(dyk, this.frameType == 1 ? 1 : 0, i2, 0, null);
        }
    }
}
