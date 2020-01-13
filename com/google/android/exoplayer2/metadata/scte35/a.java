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
    private s miE;
    private final l mnQ = new l();
    private final k mpK = new k();

    @Override // com.google.android.exoplayer2.metadata.a
    public Metadata a(c cVar) throws MetadataDecoderException {
        SpliceCommand a;
        if (this.miE == null || cVar.subsampleOffsetUs != this.miE.dyD()) {
            this.miE = new s(cVar.mcQ);
            this.miE.gL(cVar.mcQ - cVar.subsampleOffsetUs);
        }
        ByteBuffer byteBuffer = cVar.data;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.mnQ.G(array, limit);
        this.mpK.G(array, limit);
        this.mpK.JP(39);
        long readBits = this.mpK.readBits(32) | (this.mpK.readBits(1) << 32);
        this.mpK.JP(20);
        int readBits2 = this.mpK.readBits(12);
        int readBits3 = this.mpK.readBits(8);
        this.mnQ.skipBytes(14);
        switch (readBits3) {
            case 0:
                a = new SpliceNullCommand();
                break;
            case 4:
                a = SpliceScheduleCommand.Q(this.mnQ);
                break;
            case 5:
                a = SpliceInsertCommand.a(this.mnQ, readBits, this.miE);
                break;
            case 6:
                a = TimeSignalCommand.b(this.mnQ, readBits, this.miE);
                break;
            case 255:
                a = PrivateCommand.a(this.mnQ, readBits2, readBits);
                break;
            default:
                a = null;
                break;
        }
        return a == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(a);
    }
}
