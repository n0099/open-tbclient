package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoderException;
import com.google.android.exoplayer2.metadata.c;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.s;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public final class a implements com.google.android.exoplayer2.metadata.a {
    private s meN;
    private final l mkc = new l();
    private final k mlV = new k();

    @Override // com.google.android.exoplayer2.metadata.a
    public Metadata a(c cVar) throws MetadataDecoderException {
        SpliceCommand a;
        if (this.meN == null || cVar.subsampleOffsetUs != this.meN.dxt()) {
            this.meN = new s(cVar.lYY);
            this.meN.gG(cVar.lYY - cVar.subsampleOffsetUs);
        }
        ByteBuffer byteBuffer = cVar.data;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.mkc.G(array, limit);
        this.mlV.G(array, limit);
        this.mlV.JG(39);
        long readBits = this.mlV.readBits(32) | (this.mlV.readBits(1) << 32);
        this.mlV.JG(20);
        int readBits2 = this.mlV.readBits(12);
        int readBits3 = this.mlV.readBits(8);
        this.mkc.skipBytes(14);
        switch (readBits3) {
            case 0:
                a = new SpliceNullCommand();
                break;
            case 4:
                a = SpliceScheduleCommand.Q(this.mkc);
                break;
            case 5:
                a = SpliceInsertCommand.a(this.mkc, readBits, this.meN);
                break;
            case 6:
                a = TimeSignalCommand.b(this.mkc, readBits, this.meN);
                break;
            case 255:
                a = PrivateCommand.a(this.mkc, readBits2, readBits);
                break;
            default:
                a = null;
                break;
        }
        return a == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(a);
    }
}
