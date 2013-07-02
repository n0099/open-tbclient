package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.n;
import com.google.android.gms.internal.w;
/* loaded from: classes.dex */
public final class PlayerEntity implements Player {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.google.android.gms.games.PlayerEntity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PlayerEntity createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            return new PlayerEntity(readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readLong());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PlayerEntity[] newArray(int i) {
            return new PlayerEntity[i];
        }
    };
    private final String a;
    private final String b;
    private final Uri c;
    private final Uri d;
    private final long e;

    public PlayerEntity(Player player) {
        this.a = player.a();
        this.b = player.b();
        this.c = player.c();
        this.d = player.d();
        this.e = player.e();
        n.a(this.a);
        n.a(this.b);
        n.a(this.e > 0);
    }

    private PlayerEntity(String str, String str2, Uri uri, Uri uri2, long j) {
        this.a = str;
        this.b = str2;
        this.c = uri;
        this.d = uri2;
        this.e = j;
    }

    public static int a(Player player) {
        return w.a(player.a(), player.b(), player.c(), player.d(), Long.valueOf(player.e()));
    }

    public static boolean a(Player player, Object obj) {
        if (obj instanceof Player) {
            if (player != obj) {
                Player player2 = (Player) obj;
                return w.a(player2.a(), player.a()) && w.a(player2.b(), player.b()) && w.a(player2.c(), player.c()) && w.a(player2.d(), player.d()) && w.a(Long.valueOf(player2.e()), Long.valueOf(player.e()));
            }
            return true;
        }
        return false;
    }

    public static String b(Player player) {
        return w.a(player).a("PlayerId", player.a()).a("DisplayName", player.b()).a("IconImageUri", player.c()).a("HiResImageUri", player.d()).a("RetrievedTimestamp", Long.valueOf(player.e())).toString();
    }

    @Override // com.google.android.gms.games.Player
    public String a() {
        return this.a;
    }

    @Override // com.google.android.gms.games.Player
    public String b() {
        return this.b;
    }

    @Override // com.google.android.gms.games.Player
    public Uri c() {
        return this.c;
    }

    @Override // com.google.android.gms.games.Player
    public Uri d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.Player
    public long e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: f */
    public Player g() {
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
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c == null ? null : this.c.toString());
        parcel.writeString(this.d != null ? this.d.toString() : null);
        parcel.writeLong(this.e);
    }
}
