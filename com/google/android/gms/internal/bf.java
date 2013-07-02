package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
/* loaded from: classes.dex */
public final class bf extends j implements Game {
    public bf(k kVar, int i) {
        super(kVar, i);
    }

    @Override // com.google.android.gms.games.Game
    public String a() {
        return d("external_game_id");
    }

    @Override // com.google.android.gms.games.Game
    public String b() {
        return d("display_name");
    }

    @Override // com.google.android.gms.games.Game
    public String c() {
        return d("primary_category");
    }

    @Override // com.google.android.gms.games.Game
    public String d() {
        return d("secondary_category");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.Game
    public String e() {
        return d("game_description");
    }

    @Override // com.google.android.gms.internal.j
    public boolean equals(Object obj) {
        return GameEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.Game
    public String f() {
        return d("developer_name");
    }

    @Override // com.google.android.gms.games.Game
    public Uri h() {
        return f("game_icon_image_uri");
    }

    @Override // com.google.android.gms.internal.j
    public int hashCode() {
        return GameEntity.a(this);
    }

    @Override // com.google.android.gms.games.Game
    public Uri i() {
        return f("game_hi_res_image_uri");
    }

    @Override // com.google.android.gms.games.Game
    public Uri j() {
        return f("featured_image_uri");
    }

    @Override // com.google.android.gms.games.Game
    public boolean k() {
        return c("play_enabled_game");
    }

    @Override // com.google.android.gms.games.Game
    public boolean l() {
        return b("installed") > 0;
    }

    @Override // com.google.android.gms.games.Game
    public String m() {
        return d("package_name");
    }

    @Override // com.google.android.gms.games.Game
    public int n() {
        return b("gameplay_acl_status");
    }

    @Override // com.google.android.gms.games.Game
    public int o() {
        return b("achievement_total_count");
    }

    @Override // com.google.android.gms.games.Game
    public int p() {
        return b("leaderboard_count");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: q */
    public Game g() {
        return new GameEntity(this);
    }

    public String toString() {
        return GameEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((GameEntity) g()).writeToParcel(parcel, i);
    }
}
