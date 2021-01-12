package com.kwad.sdk.glide.load.engine.bitmap_recycle;
/* loaded from: classes4.dex */
public final class i implements a<int[]> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.a
    public int a(int[] iArr) {
        return iArr.length;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.a
    public String a() {
        return "IntegerArrayPool";
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.a
    public int b() {
        return 4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.a
    /* renamed from: b */
    public int[] a(int i) {
        return new int[i];
    }
}
