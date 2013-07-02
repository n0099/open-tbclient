package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.bx;
/* loaded from: classes.dex */
public final class ParticipantBuffer extends DataBuffer {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: a */
    public Participant b(int i) {
        return new bx(this.a, i);
    }
}
