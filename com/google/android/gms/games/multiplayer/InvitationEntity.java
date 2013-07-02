package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.w;
import com.google.android.gms.internal.x;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class InvitationEntity implements Invitation {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.google.android.gms.games.multiplayer.InvitationEntity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public InvitationEntity createFromParcel(Parcel parcel) {
            GameEntity gameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            Participant participant = (Participant) ParticipantEntity.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i < readInt2; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new InvitationEntity(gameEntity, readString, readLong, readInt, participant, arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public InvitationEntity[] newArray(int i) {
            return new InvitationEntity[i];
        }
    };
    private final GameEntity a;
    private final String b;
    private final long c;
    private final int d;
    private final Participant e;
    private final ArrayList f;

    private InvitationEntity(GameEntity gameEntity, String str, long j, int i, Participant participant, ArrayList arrayList) {
        this.a = gameEntity;
        this.b = str;
        this.c = j;
        this.d = i;
        this.e = participant;
        this.f = arrayList;
    }

    public InvitationEntity(Invitation invitation) {
        this.a = new GameEntity(invitation.a());
        this.b = invitation.b();
        this.c = invitation.d();
        this.d = invitation.e();
        String h = invitation.c().h();
        Participant participant = null;
        ArrayList f = invitation.f();
        int size = f.size();
        this.f = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Participant participant2 = (Participant) f.get(i);
            if (participant2.h().equals(h)) {
                participant = participant2;
            }
            this.f.add(participant2.g());
        }
        x.a(participant, "Must have a valid inviter!");
        this.e = (Participant) participant.g();
    }

    public static int a(Invitation invitation) {
        return w.a(invitation.a(), invitation.b(), Long.valueOf(invitation.d()), Integer.valueOf(invitation.e()), invitation.c(), invitation.f());
    }

    public static boolean a(Invitation invitation, Object obj) {
        if (obj instanceof Invitation) {
            if (invitation != obj) {
                Invitation invitation2 = (Invitation) obj;
                return w.a(invitation2.a(), invitation.a()) && w.a(invitation2.b(), invitation.b()) && w.a(Long.valueOf(invitation2.d()), Long.valueOf(invitation.d())) && w.a(Integer.valueOf(invitation2.e()), Integer.valueOf(invitation.e())) && w.a(invitation2.c(), invitation.c()) && w.a(invitation2.f(), invitation.f());
            }
            return true;
        }
        return false;
    }

    public static String b(Invitation invitation) {
        return w.a(invitation).a("Game", invitation.a()).a("InvitationId", invitation.b()).a("CreationTimestamp", Long.valueOf(invitation.d())).a("InvitationType", Integer.valueOf(invitation.e())).a("Inviter", invitation.c()).a("Participants", invitation.f()).toString();
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public Game a() {
        return this.a;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public String b() {
        return this.b;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public Participant c() {
        return this.e;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public long d() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.multiplayer.Participatable
    public ArrayList f() {
        return this.f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: h */
    public Invitation g() {
        return this;
    }

    public int hashCode() {
        return a(this);
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        this.a.writeToParcel(parcel, i);
        parcel.writeString(this.b);
        parcel.writeLong(this.c);
        parcel.writeInt(this.d);
        this.e.writeToParcel(parcel, i);
        int size = this.f.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            ((Participant) this.f.get(i2)).writeToParcel(parcel, i);
        }
    }
}
