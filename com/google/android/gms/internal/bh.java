package com.google.android.gms.internal;

import com.google.android.gms.games.achievement.Achievement;
import com.google.android.gms.internal.w;
/* loaded from: classes.dex */
public final class bh extends j implements Achievement {
    public bh(k kVar, int i) {
        super(kVar, i);
    }

    public String a() {
        return d("external_achievement_id");
    }

    public int b() {
        return b("type");
    }

    public String c() {
        return d("name");
    }

    public int d() {
        n.a(b() == 1);
        return b("total_steps");
    }

    public int e() {
        return b("state");
    }

    public int f() {
        n.a(b() == 1);
        return b("current_steps");
    }

    public String toString() {
        w.a a = w.a(this).a("id", a()).a("name", c()).a("state", Integer.valueOf(e())).a("type", Integer.valueOf(b()));
        if (b() == 1) {
            a.a("steps", f() + "/" + d());
        }
        return a.toString();
    }
}
