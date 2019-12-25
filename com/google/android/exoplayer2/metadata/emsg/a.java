package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.c;
import com.google.android.exoplayer2.util.l;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class a implements com.google.android.exoplayer2.metadata.a {
    @Override // com.google.android.exoplayer2.metadata.a
    public Metadata a(c cVar) {
        ByteBuffer byteBuffer = cVar.data;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        l lVar = new l(array, limit);
        String dxj = lVar.dxj();
        String dxj2 = lVar.dxj();
        long readUnsignedInt = lVar.readUnsignedInt();
        lVar.skipBytes(4);
        return new Metadata(new EventMessage(dxj, dxj2, (lVar.readUnsignedInt() * 1000) / readUnsignedInt, lVar.readUnsignedInt(), Arrays.copyOfRange(array, lVar.getPosition(), limit)));
    }
}
