package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ad;
/* loaded from: classes.dex */
public class VisibleRegionCreator implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int a = ad.a(parcel);
        ad.a(parcel, 1, visibleRegion.a());
        ad.a(parcel, 2, (Parcelable) visibleRegion.b, i, false);
        ad.a(parcel, 3, (Parcelable) visibleRegion.c, i, false);
        ad.a(parcel, 4, (Parcelable) visibleRegion.d, i, false);
        ad.a(parcel, 5, (Parcelable) visibleRegion.e, i, false);
        ad.a(parcel, 6, (Parcelable) visibleRegion.f, i, false);
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int b = ac.b(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i = ac.f(parcel, a);
                    break;
                case 2:
                    latLng4 = (LatLng) ac.a(parcel, a, LatLng.a);
                    break;
                case 3:
                    latLng3 = (LatLng) ac.a(parcel, a, LatLng.a);
                    break;
                case 4:
                    latLng2 = (LatLng) ac.a(parcel, a, LatLng.a);
                    break;
                case 5:
                    latLng = (LatLng) ac.a(parcel, a, LatLng.a);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) ac.a(parcel, a, LatLngBounds.a);
                    break;
                default:
                    ac.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public VisibleRegion[] newArray(int i) {
        return new VisibleRegion[i];
    }
}
