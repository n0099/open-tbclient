package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class bw extends j implements Invitation {
    private final Game c;
    private final bx d;
    private final ArrayList e;

    public bw(k kVar, int i, int i2) {
        super(kVar, i);
        this.c = new bf(kVar, i);
        this.e = new ArrayList(i2);
        String d = d("external_inviter_id");
        bx bxVar = null;
        for (int i3 = 0; i3 < i2; i3++) {
            bx bxVar2 = new bx(this.a, this.b + i3);
            if (bxVar2.h().equals(d)) {
                bxVar = bxVar2;
            }
            this.e.add(bxVar2);
        }
        this.d = (bx) x.a(bxVar, "Must have a valid inviter!");
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public Game a() {
        return this.c;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public String b() {
        return d("external_invitation_id");
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public Participant c() {
        return this.d;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public long d() {
        return a("creation_timestamp");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public int e() {
        return b("type");
    }

    @Override // com.google.android.gms.internal.j
    public boolean equals(Object obj) {
        return InvitationEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.multiplayer.Participatable
    public ArrayList f() {
        return this.e;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: h */
    public Invitation g() {
        return new InvitationEntity(this);
    }

    @Override // com.google.android.gms.internal.j
    public int hashCode() {
        return InvitationEntity.a(this);
    }

    public String toString() {
        return InvitationEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((InvitationEntity) g()).writeToParcel(parcel, i);
    }
}
