package com.google.android.gms.games.leaderboard;

import com.google.android.gms.internal.bq;
import com.google.android.gms.internal.k;
import com.google.android.gms.internal.w;
import com.google.android.gms.internal.x;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class SubmitScoreResult {
    private static final String[] a = {"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest"};
    private String b;
    private String c;
    private int d;
    private HashMap e = new HashMap();

    /* loaded from: classes.dex */
    public final class Result {
        public final long a;
        public final String b;
        public final boolean c;

        public Result(long j, String str, boolean z) {
            this.a = j;
            this.b = str;
            this.c = z;
        }

        public String toString() {
            return w.a(this).a("RawScore", Long.valueOf(this.a)).a("FormattedScore", this.b).a("NewBest", Boolean.valueOf(this.c)).toString();
        }
    }

    public SubmitScoreResult(k kVar) {
        this.d = kVar.b();
        int d = kVar.d();
        x.b(d == 3);
        for (int i = 0; i < d; i++) {
            int a2 = kVar.a(i);
            if (i == 0) {
                this.b = kVar.c("leaderboardId", i, a2);
                this.c = kVar.c("playerId", i, a2);
            }
            if (kVar.d("hasResult", i, a2)) {
                a(new Result(kVar.a("rawScore", i, a2), kVar.c("formattedScore", i, a2), kVar.d("newBest", i, a2)), kVar.b("timeSpan", i, a2));
            }
        }
    }

    private void a(Result result, int i) {
        this.e.put(Integer.valueOf(i), result);
    }

    public int a() {
        return this.d;
    }

    public String toString() {
        w.a a2 = w.a(this).a("PlayerId", this.c).a("StatusCode", Integer.valueOf(this.d));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return a2.toString();
            }
            Result result = (Result) this.e.get(Integer.valueOf(i2));
            a2.a("TimesSpan", bq.a(i2));
            a2.a("Result", result == null ? "null" : result.toString());
            i = i2 + 1;
        }
    }
}
