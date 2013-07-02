package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ad;
/* loaded from: classes.dex */
public class TileCreator implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Tile tile, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, tile.a());
        ad.a(parcel, 2, tile.b);
        ad.a(parcel, 3, tile.c);
        ad.a(parcel, 4, tile.d, false);
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Tile createFromParcel(Parcel parcel) {
        int i = 0;
        int b = ac.b(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i3 = ac.f(parcel, a);
                    break;
                case 2:
                    i2 = ac.f(parcel, a);
                    break;
                case 3:
                    i = ac.f(parcel, a);
                    break;
                case 4:
                    bArr = ac.o(parcel, a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new Tile(i3, i2, i, bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Tile[] newArray(int i) {
        return new Tile[i];
    }
}
