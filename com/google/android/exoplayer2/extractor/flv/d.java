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
    private boolean mdN;
    private final l mee;
    private final l mef;
    private int meg;

    public d(m mVar) {
        super(mVar);
        this.mee = new l(j.mGt);
        this.mef = new l(4);
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
        long dym = (lVar.dym() * 1000) + j;
        if (readUnsignedByte == 0 && !this.mdN) {
            l lVar2 = new l(new byte[lVar.dyh()]);
            lVar.C(lVar2.data, 0, lVar.dyh());
            com.google.android.exoplayer2.video.a ag = com.google.android.exoplayer2.video.a.ag(lVar2);
            this.meg = ag.meg;
            this.med.h(Format.a((String) null, "video/avc", (String) null, -1, -1, ag.width, ag.height, -1.0f, ag.initializationData, -1, ag.mGK, (DrmInitData) null));
            this.mdN = true;
        } else if (readUnsignedByte == 1 && this.mdN) {
            byte[] bArr = this.mef.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i = 4 - this.meg;
            int i2 = 0;
            while (lVar.dyh() > 0) {
                lVar.C(this.mef.data, i, this.meg);
                this.mef.setPosition(0);
                int dys = this.mef.dys();
                this.mee.setPosition(0);
                this.med.a(this.mee, 4);
                this.med.a(lVar, dys);
                i2 = i2 + 4 + dys;
            }
            this.med.a(dym, this.frameType == 1 ? 1 : 0, i2, 0, null);
        }
    }
}
