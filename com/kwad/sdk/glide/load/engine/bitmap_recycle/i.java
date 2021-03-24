package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.IntegerArrayAdapter;
/* loaded from: classes6.dex */
public final class i implements a<int[]> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.a
    public int a(int[] iArr) {
        return iArr.length;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.a
    public String a() {
        return IntegerArrayAdapter.TAG;
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
