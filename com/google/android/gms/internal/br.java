package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.games.leaderboard.Leaderboard;
/* loaded from: classes.dex */
public final class br extends j implements Leaderboard {
    private final int c;

    public br(k kVar, int i, int i2) {
        super(kVar, i);
        this.c = i2;
    }

    public String a() {
        return d("external_leaderboard_id");
    }

    public String b() {
        return d("name");
    }

    public Uri c() {
        return f("board_icon_image_uri");
    }

    public int d() {
        return b("score_order");
    }

    public String toString() {
        return w.a(this).a("ID", a()).a("DisplayName", b()).a("IconImageURI", c()).a("ScoreOrder", Integer.valueOf(d())).toString();
    }
}
