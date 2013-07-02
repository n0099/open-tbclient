package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
/* loaded from: classes.dex */
public final class bg extends j implements Player {
    public bg(k kVar, int i) {
        super(kVar, i);
    }

    @Override // com.google.android.gms.games.Player
    public String a() {
        return d("external_player_id");
    }

    @Override // com.google.android.gms.games.Player
    public String b() {
        return d("profile_name");
    }

    @Override // com.google.android.gms.games.Player
    public Uri c() {
        return f("profile_icon_image_uri");
    }

    @Override // com.google.android.gms.games.Player
    public Uri d() {
        return f("profile_hi_res_image_uri");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.Player
    public long e() {
        return a("last_updated");
    }

    @Override // com.google.android.gms.internal.j
    public boolean equals(Object obj) {
        return PlayerEntity.a(this, obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: f */
    public Player g() {
        return new PlayerEntity(this);
    }

    @Override // com.google.android.gms.internal.j
    public int hashCode() {
        return PlayerEntity.a(this);
    }

    public String toString() {
        return PlayerEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((PlayerEntity) g()).writeToParcel(parcel, i);
    }
}
