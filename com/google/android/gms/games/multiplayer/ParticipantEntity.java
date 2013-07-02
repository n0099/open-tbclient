package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.w;
/* loaded from: classes.dex */
public final class ParticipantEntity implements Parcelable, Participant {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.google.android.gms.games.multiplayer.ParticipantEntity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ParticipantEntity createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Uri parse = readString3 == null ? null : Uri.parse(readString3);
            String readString4 = parcel.readString();
            return new ParticipantEntity(readString, readString2, parse, readString4 == null ? null : Uri.parse(readString4), parcel.readInt(), parcel.readString(), parcel.readInt() > 0, parcel.readInt() > 0 ? (PlayerEntity) PlayerEntity.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ParticipantEntity[] newArray(int i) {
            return new ParticipantEntity[i];
        }
    };
    private final PlayerEntity a;
    private final String b;
    private final String c;
    private final Uri d;
    private final Uri e;
    private final int f;
    private final String g;
    private final boolean h;

    public ParticipantEntity(Participant participant) {
        Player i = participant.i();
        this.a = i == null ? null : new PlayerEntity(i);
        this.b = participant.h();
        this.c = participant.d();
        this.d = participant.e();
        this.e = participant.f();
        this.f = participant.a();
        this.g = participant.b();
        this.h = participant.c();
    }

    private ParticipantEntity(String str, String str2, Uri uri, Uri uri2, int i, String str3, boolean z, PlayerEntity playerEntity) {
        this.b = str;
        this.c = str2;
        this.d = uri;
        this.e = uri2;
        this.f = i;
        this.g = str3;
        this.h = z;
        this.a = playerEntity;
    }

    public static int a(Participant participant) {
        return w.a(participant.i(), Integer.valueOf(participant.a()), participant.b(), Boolean.valueOf(participant.c()), participant.d(), participant.e(), participant.f());
    }

    public static boolean a(Participant participant, Object obj) {
        if (obj instanceof Participant) {
            if (participant != obj) {
                Participant participant2 = (Participant) obj;
                return w.a(participant2.i(), participant.i()) && w.a(Integer.valueOf(participant2.a()), Integer.valueOf(participant.a())) && w.a(participant2.b(), participant.b()) && w.a(Boolean.valueOf(participant2.c()), Boolean.valueOf(participant.c())) && w.a(participant2.d(), participant.d()) && w.a(participant2.e(), participant.e()) && w.a(participant2.f(), participant.f());
            }
            return true;
        }
        return false;
    }

    public static String b(Participant participant) {
        return w.a(participant).a("Player", participant.i()).a("Status", Integer.valueOf(participant.a())).a("ClientAddress", participant.b()).a("ConnectedToRoom", Boolean.valueOf(participant.c())).a("DisplayName", participant.d()).a("IconImage", participant.e()).a("HiResImage", participant.f()).toString();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public int a() {
        return this.f;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String b() {
        return this.g;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public boolean c() {
        return this.h;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String d() {
        return this.a == null ? this.c : this.a.b();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public Uri e() {
        return this.a == null ? this.d : this.a.c();
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public Uri f() {
        return this.a == null ? this.e : this.a.d();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String h() {
        return this.b;
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public Player i() {
        return this.a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: j */
    public Participant g() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d == null ? null : this.d.toString());
        parcel.writeString(this.e != null ? this.e.toString() : null);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.a != null ? 1 : 0);
        if (this.a != null) {
            this.a.writeToParcel(parcel, i);
        }
    }
}
