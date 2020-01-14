package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoderException;
import com.google.android.exoplayer2.metadata.c;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.s;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public final class a implements com.google.android.exoplayer2.metadata.a {
    private s miJ;
    private final l mnV = new l();
    private final k mpP = new k();

    @Override // com.google.android.exoplayer2.metadata.a
    public Metadata a(c cVar) throws MetadataDecoderException {
        SpliceCommand a;
        if (this.miJ == null || cVar.subsampleOffsetUs != this.miJ.dyF()) {
            this.miJ = new s(cVar.mcV);
            this.miJ.gL(cVar.mcV - cVar.subsampleOffsetUs);
        }
        ByteBuffer byteBuffer = cVar.data;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.mnV.G(array, limit);
        this.mpP.G(array, limit);
        this.mpP.JP(39);
        long readBits = this.mpP.readBits(32) | (this.mpP.readBits(1) << 32);
        this.mpP.JP(20);
        int readBits2 = this.mpP.readBits(12);
        int readBits3 = this.mpP.readBits(8);
        this.mnV.skipBytes(14);
        switch (readBits3) {
            case 0:
                a = new SpliceNullCommand();
                break;
            case 4:
                a = SpliceScheduleCommand.Q(this.mnV);
                break;
            case 5:
                a = SpliceInsertCommand.a(this.mnV, readBits, this.miJ);
                break;
            case 6:
                a = TimeSignalCommand.b(this.mnV, readBits, this.miJ);
                break;
            case 255:
                a = PrivateCommand.a(this.mnV, readBits2, readBits);
                break;
            default:
                a = null;
                break;
        }
        return a == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(a);
    }
}
