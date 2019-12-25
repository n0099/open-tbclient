package com.google.android.exoplayer2.text;

import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public abstract class c extends com.google.android.exoplayer2.a.g<h, i, SubtitleDecoderException> implements f {
    private final String name;

    protected abstract e b(byte[] bArr, int i, boolean z) throws SubtitleDecoderException;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(String str) {
        super(new h[2], new i[2]);
        this.name = str;
        Jc(1024);
    }

    @Override // com.google.android.exoplayer2.text.f
    public void gs(long j) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a.g
    /* renamed from: dvj */
    public final h dsk() {
        return new h();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.a.g
    /* renamed from: dvk */
    public final i dsl() {
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
            iVar.a(hVar.lYY, b(byteBuffer.array(), byteBuffer.limit(), z), hVar.subsampleOffsetUs);
            iVar.aI(Integer.MIN_VALUE);
            return null;
        } catch (SubtitleDecoderException e) {
            return e;
        }
    }
}
