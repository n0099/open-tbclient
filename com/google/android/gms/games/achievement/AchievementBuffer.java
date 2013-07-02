package com.google.android.gms.games.achievement;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.bh;
import com.google.android.gms.internal.k;
/* loaded from: classes.dex */
public final class AchievementBuffer extends DataBuffer {
    public AchievementBuffer(k kVar) {
        super(kVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: a */
    public Achievement b(int i) {
        return new bh(this.a, i);
    }
}
