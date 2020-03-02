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
    private static final int[] met = {5512, RequestResponseCode.REQUEST_LOGIN_PB_AT, 22050, StreamConfig.Audio.AUDIO_FREQUENCY};
    private boolean meu;
    private boolean mev;
    private int mew;

    public a(m mVar) {
        super(mVar);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean a(l lVar) throws TagPayloadReader.UnsupportedFormatException {
        if (!this.meu) {
            int readUnsignedByte = lVar.readUnsignedByte();
            this.mew = (readUnsignedByte >> 4) & 15;
            if (this.mew == 2) {
                this.meL.h(Format.a(null, "audio/mpeg", null, -1, -1, 1, met[(readUnsignedByte >> 2) & 3], null, null, 0, null));
                this.mev = true;
            } else if (this.mew == 7 || this.mew == 8) {
                this.meL.h(Format.a((String) null, this.mew == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", (String) null, -1, -1, 1, 8000, (readUnsignedByte & 1) == 1 ? 2 : 3, (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
                this.mev = true;
            } else if (this.mew != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.mew);
            }
            this.meu = true;
            return true;
        }
        lVar.skipBytes(1);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected void a(l lVar, long j) throws ParserException {
        if (this.mew == 2) {
            int dzt = lVar.dzt();
            this.meL.a(lVar, dzt);
            this.meL.a(j, 1, dzt, 0, null);
            return;
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        if (readUnsignedByte == 0 && !this.mev) {
            byte[] bArr = new byte[lVar.dzt()];
            lVar.G(bArr, 0, bArr.length);
            Pair<Integer, Integer> az = com.google.android.exoplayer2.util.c.az(bArr);
            this.meL.h(Format.a(null, "audio/mp4a-latm", null, -1, -1, ((Integer) az.second).intValue(), ((Integer) az.first).intValue(), Collections.singletonList(bArr), null, 0, null));
            this.mev = true;
        } else if (this.mew != 10 || readUnsignedByte == 1) {
            int dzt2 = lVar.dzt();
            this.meL.a(lVar, dzt2);
            this.meL.a(j, 1, dzt2, 0, null);
        }
    }
}
