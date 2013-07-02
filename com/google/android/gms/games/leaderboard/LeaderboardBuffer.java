package com.google.android.gms.games.leaderboard;

import com.google.android.gms.internal.br;
import com.google.android.gms.internal.k;
import com.google.android.gms.internal.m;
/* loaded from: classes.dex */
public final class LeaderboardBuffer extends m {
    public LeaderboardBuffer(k kVar) {
        super(kVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.m
    /* renamed from: a */
    public Leaderboard b(int i, int i2) {
        return new br(this.a, i, i2);
    }

    @Override // com.google.android.gms.internal.m
    protected String c() {
        return "external_leaderboard_id";
    }
}
