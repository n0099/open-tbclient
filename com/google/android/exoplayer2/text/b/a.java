package com.google.android.exoplayer2.text.b;

import com.google.android.exoplayer2.util.l;
import java.util.List;
/* loaded from: classes4.dex */
public final class a extends com.google.android.exoplayer2.text.c {
    private final b mvG;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        l lVar = new l(list.get(0));
        this.mvG = new b(lVar.readUnsignedShort(), lVar.readUnsignedShort());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.c
    /* renamed from: c */
    public c b(byte[] bArr, int i, boolean z) {
        if (z) {
            this.mvG.reset();
        }
        return new c(this.mvG.A(bArr, i));
    }
}
