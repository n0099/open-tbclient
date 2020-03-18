package com.google.android.exoplayer2.text.b;

import com.google.android.exoplayer2.util.l;
import java.util.List;
/* loaded from: classes6.dex */
public final class a extends com.google.android.exoplayer2.text.c {
    private final b mBZ;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        l lVar = new l(list.get(0));
        this.mBZ = new b(lVar.readUnsignedShort(), lVar.readUnsignedShort());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.c
    /* renamed from: c */
    public c b(byte[] bArr, int i, boolean z) {
        if (z) {
            this.mBZ.reset();
        }
        return new c(this.mBZ.C(bArr, i));
    }
}
