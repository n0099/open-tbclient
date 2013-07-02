package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.bs;
import com.google.android.gms.internal.bu;
import com.google.android.gms.internal.k;
/* loaded from: classes.dex */
public final class LeaderboardScoreBuffer extends DataBuffer {
    private final bs b;

    public LeaderboardScoreBuffer(k kVar) {
        super(kVar);
        this.b = new bs(kVar.c());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: a */
    public LeaderboardScore b(int i) {
        return new bu(this.a, i);
    }
}
