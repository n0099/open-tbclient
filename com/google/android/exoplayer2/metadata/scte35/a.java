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
    private s mjp;
    private final l moC = new l();
    private final k mqv = new k();

    @Override // com.google.android.exoplayer2.metadata.a
    public Metadata a(c cVar) throws MetadataDecoderException {
        SpliceCommand a;
        if (this.mjp == null || cVar.subsampleOffsetUs != this.mjp.dzP()) {
            this.mjp = new s(cVar.mdB);
            this.mjp.gJ(cVar.mdB - cVar.subsampleOffsetUs);
        }
        ByteBuffer byteBuffer = cVar.data;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.moC.I(array, limit);
        this.mqv.I(array, limit);
        this.mqv.JU(39);
        long readBits = this.mqv.readBits(32) | (this.mqv.readBits(1) << 32);
        this.mqv.JU(20);
        int readBits2 = this.mqv.readBits(12);
        int readBits3 = this.mqv.readBits(8);
        this.moC.skipBytes(14);
        switch (readBits3) {
            case 0:
                a = new SpliceNullCommand();
                break;
            case 4:
                a = SpliceScheduleCommand.Q(this.moC);
                break;
            case 5:
                a = SpliceInsertCommand.a(this.moC, readBits, this.mjp);
                break;
            case 6:
                a = TimeSignalCommand.b(this.moC, readBits, this.mjp);
                break;
            case 255:
                a = PrivateCommand.a(this.moC, readBits2, readBits);
                break;
            default:
                a = null;
                break;
        }
        return a == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(a);
    }
}
