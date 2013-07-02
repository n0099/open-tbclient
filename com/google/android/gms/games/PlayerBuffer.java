package com.google.android.gms.games;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.bg;
import com.google.android.gms.internal.k;
/* loaded from: classes.dex */
public final class PlayerBuffer extends DataBuffer {
    public PlayerBuffer(k kVar) {
        super(kVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: a */
    public Player b(int i) {
        return new bg(this.a, i);
    }
}
