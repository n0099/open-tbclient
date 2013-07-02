package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
/* loaded from: classes.dex */
public final class bt implements LeaderboardScore {
    private final long a;
    private final String b;
    private final String c;
    private final long d;
    private final long e;
    private final String f;
    private final Uri g;
    private final Uri h;
    private final PlayerEntity i;

    public bt(LeaderboardScore leaderboardScore) {
        this.a = leaderboardScore.a();
        this.b = (String) x.a(leaderboardScore.b());
        this.c = (String) x.a(leaderboardScore.c());
        this.d = leaderboardScore.d();
        this.e = leaderboardScore.e();
        this.f = leaderboardScore.f();
        this.g = leaderboardScore.h();
        this.h = leaderboardScore.i();
        Player j = leaderboardScore.j();
        this.i = j == null ? null : (PlayerEntity) j.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(LeaderboardScore leaderboardScore) {
        return w.a(Long.valueOf(leaderboardScore.a()), leaderboardScore.b(), Long.valueOf(leaderboardScore.d()), leaderboardScore.c(), Long.valueOf(leaderboardScore.e()), leaderboardScore.f(), leaderboardScore.h(), leaderboardScore.i(), leaderboardScore.j());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(LeaderboardScore leaderboardScore, Object obj) {
        if (obj instanceof LeaderboardScore) {
            if (leaderboardScore != obj) {
                LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
                return w.a(Long.valueOf(leaderboardScore2.a()), Long.valueOf(leaderboardScore.a())) && w.a(leaderboardScore2.b(), leaderboardScore.b()) && w.a(Long.valueOf(leaderboardScore2.d()), Long.valueOf(leaderboardScore.d())) && w.a(leaderboardScore2.c(), leaderboardScore.c()) && w.a(Long.valueOf(leaderboardScore2.e()), Long.valueOf(leaderboardScore.e())) && w.a(leaderboardScore2.f(), leaderboardScore.f()) && w.a(leaderboardScore2.h(), leaderboardScore.h()) && w.a(leaderboardScore2.i(), leaderboardScore.i()) && w.a(leaderboardScore2.j(), leaderboardScore.j());
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(LeaderboardScore leaderboardScore) {
        return w.a(leaderboardScore).a("Rank", Long.valueOf(leaderboardScore.a())).a("DisplayRank", leaderboardScore.b()).a("Score", Long.valueOf(leaderboardScore.d())).a("DisplayScore", leaderboardScore.c()).a("Timestamp", Long.valueOf(leaderboardScore.e())).a("DisplayName", leaderboardScore.f()).a("IconImageUri", leaderboardScore.h()).a("HiResImageUri", leaderboardScore.i()).a("Player", leaderboardScore.j() == null ? null : leaderboardScore.j()).toString();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public long a() {
        return this.a;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String b() {
        return this.b;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String c() {
        return this.c;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public long d() {
        return this.d;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public long e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String f() {
        return this.i == null ? this.f : this.i.b();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public Uri h() {
        return this.i == null ? this.g : this.i.c();
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public Uri i() {
        return this.i == null ? this.h : this.i.d();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public Player j() {
        return this.i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: k */
    public LeaderboardScore g() {
        return this;
    }

    public String toString() {
        return b(this);
    }
}
