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
    private s mjC;
    private final l moP = new l();
    private final k mqI = new k();

    @Override // com.google.android.exoplayer2.metadata.a
    public Metadata a(c cVar) throws MetadataDecoderException {
        SpliceCommand a;
        if (this.mjC == null || cVar.subsampleOffsetUs != this.mjC.dzS()) {
            this.mjC = new s(cVar.mdO);
            this.mjC.gJ(cVar.mdO - cVar.subsampleOffsetUs);
        }
        ByteBuffer byteBuffer = cVar.data;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.moP.I(array, limit);
        this.mqI.I(array, limit);
        this.mqI.JU(39);
        long readBits = this.mqI.readBits(32) | (this.mqI.readBits(1) << 32);
        this.mqI.JU(20);
        int readBits2 = this.mqI.readBits(12);
        int readBits3 = this.mqI.readBits(8);
        this.moP.skipBytes(14);
        switch (readBits3) {
            case 0:
                a = new SpliceNullCommand();
                break;
            case 4:
                a = SpliceScheduleCommand.Q(this.moP);
                break;
            case 5:
                a = SpliceInsertCommand.a(this.moP, readBits, this.mjC);
                break;
            case 6:
                a = TimeSignalCommand.b(this.moP, readBits, this.mjC);
                break;
            case 255:
                a = PrivateCommand.a(this.moP, readBits2, readBits);
                break;
            default:
                a = null;
                break;
        }
        return a == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(a);
    }
}
