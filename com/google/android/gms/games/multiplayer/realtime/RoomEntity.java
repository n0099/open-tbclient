package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class RoomEntity implements Room {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.google.android.gms.games.multiplayer.realtime.RoomEntity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RoomEntity createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            int readInt2 = parcel.readInt();
            Bundle readBundle = parcel.readBundle();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new RoomEntity(readString, readString2, readLong, readInt, readString3, readInt2, readBundle, arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RoomEntity[] newArray(int i) {
            return new RoomEntity[i];
        }
    };
    private final String a;
    private final String b;
    private final long c;
    private final int d;
    private final String e;
    private final int f;
    private final Bundle g;
    private final ArrayList h;

    public RoomEntity(Room room) {
        this.a = room.a();
        this.b = room.b();
        this.c = room.c();
        this.d = room.d();
        this.e = room.e();
        this.f = room.h();
        this.g = room.i();
        ArrayList f = room.f();
        int size = f.size();
        this.h = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.h.add(((Participant) f.get(i)).g());
        }
    }

    private RoomEntity(String str, String str2, long j, int i, String str3, int i2, Bundle bundle, ArrayList arrayList) {
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = i;
        this.e = str3;
        this.f = i2;
        this.g = bundle;
        this.h = arrayList;
    }

    public static int a(Room room) {
        return w.a(room.a(), room.b(), Long.valueOf(room.c()), Integer.valueOf(room.d()), room.e(), Integer.valueOf(room.h()), room.i(), room.f());
    }

    public static boolean a(Room room, Object obj) {
        if (obj instanceof Room) {
            if (room != obj) {
                Room room2 = (Room) obj;
                return w.a(room2.a(), room.a()) && w.a(room2.b(), room.b()) && w.a(Long.valueOf(room2.c()), Long.valueOf(room.c())) && w.a(Integer.valueOf(room2.d()), Integer.valueOf(room.d())) && w.a(room2.e(), room.e()) && w.a(Integer.valueOf(room2.h()), Integer.valueOf(room.h())) && w.a(room2.i(), room.i()) && w.a(room2.f(), room.f());
            }
            return true;
        }
        return false;
    }

    public static String b(Room room) {
        return w.a(room).a("RoomId", room.a()).a("CreatorId", room.b()).a("CreationTimestamp", Long.valueOf(room.c())).a("RoomStatus", Integer.valueOf(room.d())).a("Description", room.e()).a("Variant", Integer.valueOf(room.h())).a("AutoMatchCriteria", room.i()).a("Participants", room.f()).toString();
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public String a() {
        return this.a;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public String b() {
        return this.b;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public long c() {
        return this.c;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public int d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.multiplayer.Participatable
    public ArrayList f() {
        return this.h;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public int h() {
        return this.f;
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public Bundle i() {
        return this.g;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: j */
    public Room g() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeLong(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeBundle(this.g);
        int size = this.h.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            ((Participant) this.h.get(i2)).writeToParcel(parcel, i);
        }
    }
}
