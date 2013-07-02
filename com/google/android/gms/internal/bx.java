package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
/* loaded from: classes.dex */
public final class bx extends j implements Participant {
    private final bg c;

    public bx(k kVar, int i) {
        super(kVar, i);
        this.c = new bg(kVar, i);
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public int a() {
        return b("player_status");
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String b() {
        return d("client_address");
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public boolean c() {
        return b("connected") > 0;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String d() {
        return g("external_player_id") ? d("default_display_name") : this.c.b();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public Uri e() {
        return g("external_player_id") ? f("default_display_image_uri") : this.c.c();
    }

    @Override // com.google.android.gms.internal.j
    public boolean equals(Object obj) {
        return ParticipantEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public Uri f() {
        if (g("external_player_id")) {
            return null;
        }
        return this.c.d();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String h() {
        return d("external_participant_id");
    }

    @Override // com.google.android.gms.internal.j
    public int hashCode() {
        return ParticipantEntity.a(this);
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public Player i() {
        if (g("external_player_id")) {
            return null;
        }
        return this.c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: j */
    public Participant g() {
        return new ParticipantEntity(this);
    }

    public String toString() {
        return ParticipantEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((ParticipantEntity) g()).writeToParcel(parcel, i);
    }
}
