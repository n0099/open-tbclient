package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.MKSearch;
import com.baidu.mapapi.MapView;
import com.baidu.mapapi.cloud.GeoSearchManager;
import com.baidu.zeus.bouncycastle.DERTags;
import com.google.android.gms.internal.ac;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class ee implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ed edVar, Parcel parcel, int i) {
        int a = ad.a(parcel);
        Set d = edVar.d();
        if (d.contains(1)) {
            ad.a(parcel, 1, edVar.e());
        }
        if (d.contains(2)) {
            ad.a(parcel, 2, (Parcelable) edVar.f(), i, true);
        }
        if (d.contains(3)) {
            ad.a(parcel, 3, edVar.h(), true);
        }
        if (d.contains(4)) {
            ad.a(parcel, 4, (Parcelable) edVar.i(), i, true);
        }
        if (d.contains(5)) {
            ad.a(parcel, 5, edVar.j(), true);
        }
        if (d.contains(6)) {
            ad.a(parcel, 6, edVar.k(), true);
        }
        if (d.contains(7)) {
            ad.a(parcel, 7, edVar.l(), true);
        }
        if (d.contains(8)) {
            ad.b(parcel, 8, edVar.m(), true);
        }
        if (d.contains(9)) {
            ad.a(parcel, 9, edVar.n());
        }
        if (d.contains(10)) {
            ad.b(parcel, 10, edVar.o(), true);
        }
        if (d.contains(11)) {
            ad.a(parcel, 11, (Parcelable) edVar.p(), i, true);
        }
        if (d.contains(12)) {
            ad.b(parcel, 12, edVar.q(), true);
        }
        if (d.contains(13)) {
            ad.a(parcel, 13, edVar.r(), true);
        }
        if (d.contains(14)) {
            ad.a(parcel, 14, edVar.s(), true);
        }
        if (d.contains(15)) {
            ad.a(parcel, 15, (Parcelable) edVar.t(), i, true);
        }
        if (d.contains(17)) {
            ad.a(parcel, 17, edVar.v(), true);
        }
        if (d.contains(16)) {
            ad.a(parcel, 16, edVar.u(), true);
        }
        if (d.contains(19)) {
            ad.b(parcel, 19, edVar.x(), true);
        }
        if (d.contains(18)) {
            ad.a(parcel, 18, edVar.w(), true);
        }
        if (d.contains(21)) {
            ad.a(parcel, 21, edVar.z(), true);
        }
        if (d.contains(20)) {
            ad.a(parcel, 20, edVar.y(), true);
        }
        if (d.contains(23)) {
            ad.a(parcel, 23, edVar.B(), true);
        }
        if (d.contains(22)) {
            ad.a(parcel, 22, edVar.A(), true);
        }
        if (d.contains(25)) {
            ad.a(parcel, 25, edVar.D(), true);
        }
        if (d.contains(24)) {
            ad.a(parcel, 24, edVar.C(), true);
        }
        if (d.contains(27)) {
            ad.a(parcel, 27, edVar.F(), true);
        }
        if (d.contains(26)) {
            ad.a(parcel, 26, edVar.E(), true);
        }
        if (d.contains(29)) {
            ad.a(parcel, 29, (Parcelable) edVar.H(), i, true);
        }
        if (d.contains(28)) {
            ad.a(parcel, 28, edVar.G(), true);
        }
        if (d.contains(31)) {
            ad.a(parcel, 31, edVar.J(), true);
        }
        if (d.contains(30)) {
            ad.a(parcel, 30, edVar.I(), true);
        }
        if (d.contains(34)) {
            ad.a(parcel, 34, (Parcelable) edVar.M(), i, true);
        }
        if (d.contains(32)) {
            ad.a(parcel, 32, edVar.K(), true);
        }
        if (d.contains(33)) {
            ad.a(parcel, 33, edVar.L(), true);
        }
        if (d.contains(38)) {
            ad.a(parcel, 38, edVar.P());
        }
        if (d.contains(39)) {
            ad.a(parcel, 39, edVar.Q(), true);
        }
        if (d.contains(36)) {
            ad.a(parcel, 36, edVar.N());
        }
        if (d.contains(37)) {
            ad.a(parcel, 37, (Parcelable) edVar.O(), i, true);
        }
        if (d.contains(42)) {
            ad.a(parcel, 42, edVar.T(), true);
        }
        if (d.contains(43)) {
            ad.a(parcel, 43, edVar.U(), true);
        }
        if (d.contains(40)) {
            ad.a(parcel, 40, (Parcelable) edVar.R(), i, true);
        }
        if (d.contains(41)) {
            ad.b(parcel, 41, edVar.S(), true);
        }
        if (d.contains(46)) {
            ad.a(parcel, 46, (Parcelable) edVar.X(), i, true);
        }
        if (d.contains(47)) {
            ad.a(parcel, 47, edVar.Y(), true);
        }
        if (d.contains(44)) {
            ad.a(parcel, 44, edVar.V(), true);
        }
        if (d.contains(45)) {
            ad.a(parcel, 45, edVar.W(), true);
        }
        if (d.contains(51)) {
            ad.a(parcel, 51, edVar.ac(), true);
        }
        if (d.contains(50)) {
            ad.a(parcel, 50, (Parcelable) edVar.ab(), i, true);
        }
        if (d.contains(49)) {
            ad.a(parcel, 49, edVar.aa(), true);
        }
        if (d.contains(48)) {
            ad.a(parcel, 48, edVar.Z(), true);
        }
        if (d.contains(55)) {
            ad.a(parcel, 55, edVar.ag(), true);
        }
        if (d.contains(54)) {
            ad.a(parcel, 54, edVar.af(), true);
        }
        if (d.contains(53)) {
            ad.a(parcel, 53, edVar.ae(), true);
        }
        if (d.contains(52)) {
            ad.a(parcel, 52, edVar.ad(), true);
        }
        if (d.contains(56)) {
            ad.a(parcel, 56, edVar.ah(), true);
        }
        ad.a(parcel, a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ed createFromParcel(Parcel parcel) {
        int b = ac.b(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        ed edVar = null;
        ArrayList arrayList = null;
        ed edVar2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        ArrayList arrayList2 = null;
        int i2 = 0;
        ArrayList arrayList3 = null;
        ed edVar3 = null;
        ArrayList arrayList4 = null;
        String str4 = null;
        String str5 = null;
        ed edVar4 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        ArrayList arrayList5 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        ed edVar5 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        ed edVar6 = null;
        double d = 0.0d;
        ed edVar7 = null;
        double d2 = 0.0d;
        String str22 = null;
        ed edVar8 = null;
        ArrayList arrayList6 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        ed edVar9 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        ed edVar10 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        while (parcel.dataPosition() < b) {
            int a = ac.a(parcel);
            switch (ac.a(a)) {
                case 1:
                    i = ac.f(parcel, a);
                    hashSet.add(1);
                    break;
                case 2:
                    hashSet.add(2);
                    edVar = (ed) ac.a(parcel, a, ed.a);
                    break;
                case 3:
                    arrayList = ac.x(parcel, a);
                    hashSet.add(3);
                    break;
                case 4:
                    hashSet.add(4);
                    edVar2 = (ed) ac.a(parcel, a, ed.a);
                    break;
                case 5:
                    str = ac.l(parcel, a);
                    hashSet.add(5);
                    break;
                case 6:
                    str2 = ac.l(parcel, a);
                    hashSet.add(6);
                    break;
                case 7:
                    str3 = ac.l(parcel, a);
                    hashSet.add(7);
                    break;
                case 8:
                    arrayList2 = ac.c(parcel, a, ed.a);
                    hashSet.add(8);
                    break;
                case 9:
                    i2 = ac.f(parcel, a);
                    hashSet.add(9);
                    break;
                case 10:
                    arrayList3 = ac.c(parcel, a, ed.a);
                    hashSet.add(10);
                    break;
                case 11:
                    hashSet.add(11);
                    edVar3 = (ed) ac.a(parcel, a, ed.a);
                    break;
                case 12:
                    arrayList4 = ac.c(parcel, a, ed.a);
                    hashSet.add(12);
                    break;
                case 13:
                    str4 = ac.l(parcel, a);
                    hashSet.add(13);
                    break;
                case 14:
                    str5 = ac.l(parcel, a);
                    hashSet.add(14);
                    break;
                case 15:
                    hashSet.add(15);
                    edVar4 = (ed) ac.a(parcel, a, ed.a);
                    break;
                case 16:
                    str6 = ac.l(parcel, a);
                    hashSet.add(16);
                    break;
                case 17:
                    str7 = ac.l(parcel, a);
                    hashSet.add(17);
                    break;
                case 18:
                    str8 = ac.l(parcel, a);
                    hashSet.add(18);
                    break;
                case 19:
                    arrayList5 = ac.c(parcel, a, ed.a);
                    hashSet.add(19);
                    break;
                case 20:
                    str9 = ac.l(parcel, a);
                    hashSet.add(20);
                    break;
                case 21:
                    str10 = ac.l(parcel, a);
                    hashSet.add(21);
                    break;
                case DERTags.IA5_STRING /* 22 */:
                    str11 = ac.l(parcel, a);
                    hashSet.add(22);
                    break;
                case DERTags.UTC_TIME /* 23 */:
                    str12 = ac.l(parcel, a);
                    hashSet.add(23);
                    break;
                case DERTags.GENERALIZED_TIME /* 24 */:
                    str13 = ac.l(parcel, a);
                    hashSet.add(24);
                    break;
                case DERTags.GRAPHIC_STRING /* 25 */:
                    str14 = ac.l(parcel, a);
                    hashSet.add(25);
                    break;
                case DERTags.VISIBLE_STRING /* 26 */:
                    str15 = ac.l(parcel, a);
                    hashSet.add(26);
                    break;
                case DERTags.GENERAL_STRING /* 27 */:
                    str16 = ac.l(parcel, a);
                    hashSet.add(27);
                    break;
                case DERTags.UNIVERSAL_STRING /* 28 */:
                    str17 = ac.l(parcel, a);
                    hashSet.add(28);
                    break;
                case 29:
                    hashSet.add(29);
                    edVar5 = (ed) ac.a(parcel, a, ed.a);
                    break;
                case DERTags.BMP_STRING /* 30 */:
                    str18 = ac.l(parcel, a);
                    hashSet.add(30);
                    break;
                case 31:
                    str19 = ac.l(parcel, a);
                    hashSet.add(31);
                    break;
                case 32:
                    str20 = ac.l(parcel, a);
                    hashSet.add(32);
                    break;
                case 33:
                    str21 = ac.l(parcel, a);
                    hashSet.add(33);
                    break;
                case 34:
                    hashSet.add(34);
                    edVar6 = (ed) ac.a(parcel, a, ed.a);
                    break;
                case 35:
                default:
                    ac.b(parcel, a);
                    break;
                case 36:
                    d = ac.j(parcel, a);
                    hashSet.add(36);
                    break;
                case 37:
                    hashSet.add(37);
                    edVar7 = (ed) ac.a(parcel, a, ed.a);
                    break;
                case 38:
                    d2 = ac.j(parcel, a);
                    hashSet.add(38);
                    break;
                case 39:
                    str22 = ac.l(parcel, a);
                    hashSet.add(39);
                    break;
                case 40:
                    hashSet.add(40);
                    edVar8 = (ed) ac.a(parcel, a, ed.a);
                    break;
                case 41:
                    arrayList6 = ac.c(parcel, a, ed.a);
                    hashSet.add(41);
                    break;
                case 42:
                    str23 = ac.l(parcel, a);
                    hashSet.add(42);
                    break;
                case 43:
                    str24 = ac.l(parcel, a);
                    hashSet.add(43);
                    break;
                case 44:
                    str25 = ac.l(parcel, a);
                    hashSet.add(44);
                    break;
                case MKSearch.TYPE_AREA_MULTI_POI_LIST /* 45 */:
                    str26 = ac.l(parcel, a);
                    hashSet.add(45);
                    break;
                case 46:
                    hashSet.add(46);
                    edVar9 = (ed) ac.a(parcel, a, ed.a);
                    break;
                case 47:
                    str27 = ac.l(parcel, a);
                    hashSet.add(47);
                    break;
                case MapView.LayoutParams.TOP /* 48 */:
                    str28 = ac.l(parcel, a);
                    hashSet.add(48);
                    break;
                case 49:
                    str29 = ac.l(parcel, a);
                    hashSet.add(49);
                    break;
                case GeoSearchManager.GEO_SEARCH /* 50 */:
                    hashSet.add(50);
                    edVar10 = (ed) ac.a(parcel, a, ed.a);
                    break;
                case 51:
                    str30 = ac.l(parcel, a);
                    hashSet.add(51);
                    break;
                case MKSearch.POI_DETAIL_SEARCH /* 52 */:
                    str31 = ac.l(parcel, a);
                    hashSet.add(52);
                    break;
                case 53:
                    str32 = ac.l(parcel, a);
                    hashSet.add(53);
                    break;
                case 54:
                    str33 = ac.l(parcel, a);
                    hashSet.add(54);
                    break;
                case 55:
                    str34 = ac.l(parcel, a);
                    hashSet.add(55);
                    break;
                case 56:
                    str35 = ac.l(parcel, a);
                    hashSet.add(56);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        return new ed(hashSet, i, edVar, arrayList, edVar2, str, str2, str3, arrayList2, i2, arrayList3, edVar3, arrayList4, str4, str5, edVar4, str6, str7, str8, arrayList5, str9, str10, str11, str12, str13, str14, str15, str16, str17, edVar5, str18, str19, str20, str21, edVar6, d, edVar7, d2, str22, edVar8, arrayList6, str23, str24, str25, str26, edVar9, str27, str28, str29, edVar10, str30, str31, str32, str33, str34, str35);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ed[] newArray(int i) {
        return new ed[i];
    }
}
