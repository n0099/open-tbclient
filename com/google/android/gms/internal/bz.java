package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class bz extends j implements Room {
    private final int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(k kVar, int i, int i2) {
        super(kVar, i);
        this.c = i2;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public String a() {
        return d("external_match_id");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public String b() {
        return d("creator_external");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public long c() {
        return a("creation_timestamp");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public int d() {
        return b("status");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public String e() {
        return d("description");
    }

    @Override // com.google.android.gms.internal.j
    public boolean equals(Object obj) {
        return RoomEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.multiplayer.Participatable
    public ArrayList f() {
        ArrayList arrayList = new ArrayList(this.c);
        for (int i = 0; i < this.c; i++) {
            arrayList.add(new bx(this.a, this.b + i));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public int h() {
        return b("variant");
    }

    @Override // com.google.android.gms.internal.j
    public int hashCode() {
        return RoomEntity.a(this);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public Bundle i() {
        if (c("has_automatch_criteria")) {
            return RoomConfig.a(b("automatch_min_players"), b("automatch_max_players"), a("automatch_bit_mask"));
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: j */
    public Room g() {
        return new RoomEntity(this);
    }

    public String toString() {
        return RoomEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((RoomEntity) g()).writeToParcel(parcel, i);
    }
}
