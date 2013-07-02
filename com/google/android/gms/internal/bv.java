package com.google.android.gms.internal;

import com.google.android.gms.games.leaderboard.LeaderboardVariant;
/* loaded from: classes.dex */
public final class bv extends j implements LeaderboardVariant {
    public int a() {
        return b("timespan");
    }

    public int b() {
        return b("collection");
    }

    public boolean c() {
        return !g("player_raw_score");
    }

    public long d() {
        if (g("player_raw_score")) {
            return -1L;
        }
        return a("player_raw_score");
    }

    public String e() {
        return d("player_display_score");
    }

    public long f() {
        if (g("player_rank")) {
            return -1L;
        }
        return a("player_rank");
    }

    public String g() {
        return d("player_display_rank");
    }

    public long h() {
        if (g("total_scores")) {
            return -1L;
        }
        return a("total_scores");
    }

    public String i() {
        return d("top_page_token_next");
    }

    public String j() {
        return d("window_page_token_prev");
    }

    public String k() {
        return d("window_page_token_next");
    }

    public String toString() {
        return w.a(this).a("TimeSpan", bq.a(a())).a("Collection", bp.a(b())).a("RawPlayerScore", c() ? Long.valueOf(d()) : "none").a("DisplayPlayerScore", c() ? e() : "none").a("PlayerRank", c() ? Long.valueOf(f()) : "none").a("DisplayPlayerRank", c() ? g() : "none").a("NumScores", Long.valueOf(h())).a("TopPageNextToken", i()).a("WindowPageNextToken", k()).a("WindowPagePrevToken", j()).toString();
    }
}
