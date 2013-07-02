package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.k;
/* loaded from: classes.dex */
public final class MomentBuffer extends DataBuffer {
    public MomentBuffer(k kVar) {
        super(kVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: a */
    public Moment b(int i) {
        return new eh(this.a, i);
    }
}
