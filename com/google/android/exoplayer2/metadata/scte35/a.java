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
    private s mjr;
    private final l moE = new l();
    private final k mqx = new k();

    @Override // com.google.android.exoplayer2.metadata.a
    public Metadata a(c cVar) throws MetadataDecoderException {
        SpliceCommand a;
        if (this.mjr == null || cVar.subsampleOffsetUs != this.mjr.dzR()) {
            this.mjr = new s(cVar.mdD);
            this.mjr.gJ(cVar.mdD - cVar.subsampleOffsetUs);
        }
        ByteBuffer byteBuffer = cVar.data;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.moE.I(array, limit);
        this.mqx.I(array, limit);
        this.mqx.JU(39);
        long readBits = this.mqx.readBits(32) | (this.mqx.readBits(1) << 32);
        this.mqx.JU(20);
        int readBits2 = this.mqx.readBits(12);
        int readBits3 = this.mqx.readBits(8);
        this.moE.skipBytes(14);
        switch (readBits3) {
            case 0:
                a = new SpliceNullCommand();
                break;
            case 4:
                a = SpliceScheduleCommand.Q(this.moE);
                break;
            case 5:
                a = SpliceInsertCommand.a(this.moE, readBits, this.mjr);
                break;
            case 6:
                a = TimeSignalCommand.b(this.moE, readBits, this.mjr);
                break;
            case 255:
                a = PrivateCommand.a(this.moE, readBits2, readBits);
                break;
            default:
                a = null;
                break;
        }
        return a == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(a);
    }
}
