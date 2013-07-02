package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.w;
/* loaded from: classes.dex */
public final class GameEntity implements Game {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.google.android.gms.games.GameEntity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GameEntity createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Uri parse = readString7 == null ? null : Uri.parse(readString7);
            String readString8 = parcel.readString();
            Uri parse2 = readString8 == null ? null : Uri.parse(readString8);
            String readString9 = parcel.readString();
            return new GameEntity(readString, readString2, readString3, readString4, readString5, readString6, parse, parse2, readString9 == null ? null : Uri.parse(readString9), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GameEntity[] newArray(int i) {
            return new GameEntity[i];
        }
    };
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final Uri g;
    private final Uri h;
    private final Uri i;
    private final boolean j;
    private final boolean k;
    private final String l;
    private final int m;
    private final int n;
    private final int o;

    public GameEntity(Game game) {
        this.a = game.a();
        this.c = game.c();
        this.d = game.d();
        this.e = game.e();
        this.f = game.f();
        this.b = game.b();
        this.g = game.h();
        this.h = game.i();
        this.i = game.j();
        this.j = game.k();
        this.k = game.l();
        this.l = game.m();
        this.m = game.n();
        this.n = game.o();
        this.o = game.p();
    }

    private GameEntity(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Uri uri2, Uri uri3, boolean z, boolean z2, String str7, int i, int i2, int i3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = uri;
        this.h = uri2;
        this.i = uri3;
        this.j = z;
        this.k = z2;
        this.l = str7;
        this.m = i;
        this.n = i2;
        this.o = i3;
    }

    public static int a(Game game) {
        return w.a(game.a(), game.b(), game.c(), game.d(), game.e(), game.f(), game.h(), game.i(), game.j(), Boolean.valueOf(game.k()), Boolean.valueOf(game.l()), game.m(), Integer.valueOf(game.n()), Integer.valueOf(game.o()), Integer.valueOf(game.p()));
    }

    public static boolean a(Game game, Object obj) {
        if (obj instanceof Game) {
            if (game != obj) {
                Game game2 = (Game) obj;
                return w.a(game2.a(), game.a()) && w.a(game2.b(), game.b()) && w.a(game2.c(), game.c()) && w.a(game2.d(), game.d()) && w.a(game2.e(), game.e()) && w.a(game2.f(), game.f()) && w.a(game2.h(), game.h()) && w.a(game2.i(), game.i()) && w.a(game2.j(), game.j()) && w.a(Boolean.valueOf(game2.k()), Boolean.valueOf(game.k())) && w.a(Boolean.valueOf(game2.l()), Boolean.valueOf(game.l())) && w.a(game2.m(), game.m()) && w.a(Integer.valueOf(game2.n()), Integer.valueOf(game.n())) && w.a(Integer.valueOf(game2.o()), Integer.valueOf(game.o())) && w.a(Integer.valueOf(game2.p()), Integer.valueOf(game.p()));
            }
            return true;
        }
        return false;
    }

    public static String b(Game game) {
        return w.a(game).a("ApplicationId", game.a()).a("DisplayName", game.b()).a("PrimaryCategory", game.c()).a("SecondaryCategory", game.d()).a("Description", game.e()).a("DeveloperName", game.f()).a("IconImageUri", game.h()).a("HiResImageUri", game.i()).a("FeaturedImageUri", game.j()).a("PlayEnabledGame", Boolean.valueOf(game.k())).a("InstanceInstalled", Boolean.valueOf(game.l())).a("InstancePackageName", game.m()).a("GameplayAclStatus", Integer.valueOf(game.n())).a("AchievementTotalCount", Integer.valueOf(game.o())).a("LeaderboardCount", Integer.valueOf(game.p())).toString();
    }

    @Override // com.google.android.gms.games.Game
    public String a() {
        return this.a;
    }

    @Override // com.google.android.gms.games.Game
    public String b() {
        return this.b;
    }

    @Override // com.google.android.gms.games.Game
    public String c() {
        return this.c;
    }

    @Override // com.google.android.gms.games.Game
    public String d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.Game
    public String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.Game
    public String f() {
        return this.f;
    }

    @Override // com.google.android.gms.games.Game
    public Uri h() {
        return this.g;
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.Game
    public Uri i() {
        return this.h;
    }

    @Override // com.google.android.gms.games.Game
    public Uri j() {
        return this.i;
    }

    @Override // com.google.android.gms.games.Game
    public boolean k() {
        return this.j;
    }

    @Override // com.google.android.gms.games.Game
    public boolean l() {
        return this.k;
    }

    @Override // com.google.android.gms.games.Game
    public String m() {
        return this.l;
    }

    @Override // com.google.android.gms.games.Game
    public int n() {
        return this.m;
    }

    @Override // com.google.android.gms.games.Game
    public int o() {
        return this.n;
    }

    @Override // com.google.android.gms.games.Game
    public int p() {
        return this.o;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: q */
    public Game g() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g == null ? null : this.g.toString());
        parcel.writeString(this.h == null ? null : this.h.toString());
        parcel.writeString(this.i != null ? this.i.toString() : null);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeString(this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
    }
}
