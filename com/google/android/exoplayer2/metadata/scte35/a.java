package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoderException;
import com.google.android.exoplayer2.metadata.c;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.s;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public final class a implements com.google.android.exoplayer2.metadata.a {
    private s mli;
    private final l mqv = new l();
    private final k msp = new k();

    @Override // com.google.android.exoplayer2.metadata.a
    public Metadata a(c cVar) throws MetadataDecoderException {
        SpliceCommand a;
        if (this.mli == null || cVar.subsampleOffsetUs != this.mli.dAp()) {
            this.mli = new s(cVar.mfu);
            this.mli.gK(cVar.mfu - cVar.subsampleOffsetUs);
        }
        ByteBuffer byteBuffer = cVar.data;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.mqv.I(array, limit);
        this.msp.I(array, limit);
        this.msp.Ka(39);
        long readBits = this.msp.readBits(32) | (this.msp.readBits(1) << 32);
        this.msp.Ka(20);
        int readBits2 = this.msp.readBits(12);
        int readBits3 = this.msp.readBits(8);
        this.mqv.skipBytes(14);
        switch (readBits3) {
            case 0:
                a = new SpliceNullCommand();
                break;
            case 4:
                a = SpliceScheduleCommand.Q(this.mqv);
                break;
            case 5:
                a = SpliceInsertCommand.a(this.mqv, readBits, this.mli);
                break;
            case 6:
                a = TimeSignalCommand.b(this.mqv, readBits, this.mli);
                break;
            case 255:
                a = PrivateCommand.a(this.mqv, readBits2, readBits);
                break;
            default:
                a = null;
                break;
        }
        return a == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(a);
    }
}
