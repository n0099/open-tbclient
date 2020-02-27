package com.google.android.exoplayer2.text;

import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public abstract class c extends com.google.android.exoplayer2.a.g<h, i, SubtitleDecoderException> implements f {
    private final String name;

    protected abstract e b(byte[] bArr, int i, boolean z) throws SubtitleDecoderException;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(String str) {
        super(new h[2], new i[2]);
        this.name = str;
        Jq(1024);
    }

    @Override // com.google.android.exoplayer2.text.f
    public void gv(long j) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a.g
    /* renamed from: dxG */
    public final h duJ() {
        return new h();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a.g
    /* renamed from: dxH */
    public final i duK() {
        return new d(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a.g
    public final void a(i iVar) {
        super.a((c) iVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a.g
    public final SubtitleDecoderException a(h hVar, i iVar, boolean z) {
        try {
            ByteBuffer byteBuffer = hVar.data;
            iVar.a(hVar.mdB, b(byteBuffer.array(), byteBuffer.limit(), z), hVar.subsampleOffsetUs);
            iVar.aL(Integer.MIN_VALUE);
            return null;
        } catch (SubtitleDecoderException e) {
            return e;
        }
    }
}
