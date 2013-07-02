package com.google.android.gms.games;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.bf;
import com.google.android.gms.internal.k;
/* loaded from: classes.dex */
public final class GameBuffer extends DataBuffer {
    public GameBuffer(k kVar) {
        super(kVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: a */
    public Game b(int i) {
        return new bf(this.a, i);
    }
}
