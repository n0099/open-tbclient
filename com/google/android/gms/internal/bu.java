package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
/* loaded from: classes.dex */
public final class bu extends j implements LeaderboardScore {
    private final bg c;

    public bu(k kVar, int i) {
        super(kVar, i);
        this.c = new bg(kVar, i);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public long a() {
        return a("rank");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String b() {
        return d("display_rank");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String c() {
        return d("display_score");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public long d() {
        return a("raw_score");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public long e() {
        return a("achieved_timestamp");
    }

    @Override // com.google.android.gms.internal.j
    public boolean equals(Object obj) {
        return bt.a(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String f() {
        return g("external_player_id") ? d("default_display_name") : this.c.b();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public Uri h() {
        return g("external_player_id") ? f("default_display_image_uri") : this.c.c();
    }

    @Override // com.google.android.gms.internal.j
    public int hashCode() {
        return bt.a(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public Uri i() {
        if (g("external_player_id")) {
            return null;
        }
        return this.c.d();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public Player j() {
        if (g("external_player_id")) {
            return null;
        }
        return this.c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: k */
    public LeaderboardScore g() {
        return new bt(this);
    }

    public String toString() {
        return bt.b(this);
    }
}
