package com.google.android.gms.internal;

import android.os.Parcel;
import com.baidu.mapapi.MKSearch;
import com.baidu.mapapi.MapView;
import com.baidu.mapapi.cloud.GeoSearchManager;
import com.baidu.zeus.Headers;
import com.baidu.zeus.bouncycastle.DERTags;
import com.google.android.gms.internal.an;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public final class ed extends an implements ae, ItemScope {
    public static final ee a = new ee();
    private static final HashMap b = new HashMap();
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private ed F;
    private String G;
    private String H;
    private String I;
    private String J;
    private ed K;
    private double L;
    private ed M;
    private double N;
    private String O;
    private ed P;
    private List Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private ed V;
    private String W;
    private String X;
    private String Y;
    private ed Z;
    private String aa;
    private String ab;
    private String ac;
    private String ad;
    private String ae;
    private String af;
    private final Set c;
    private final int d;
    private ed e;
    private List f;
    private ed g;
    private String h;
    private String i;
    private String j;
    private List k;
    private int l;
    private List m;
    private ed n;
    private List o;
    private String p;
    private String q;
    private ed r;
    private String s;
    private String t;
    private String u;
    private List v;
    private String w;
    private String x;
    private String y;
    private String z;

    static {
        b.put("about", an.a.a("about", 2, ed.class));
        b.put("additionalName", an.a.e("additionalName", 3));
        b.put("address", an.a.a("address", 4, ed.class));
        b.put("addressCountry", an.a.d("addressCountry", 5));
        b.put("addressLocality", an.a.d("addressLocality", 6));
        b.put("addressRegion", an.a.d("addressRegion", 7));
        b.put("associated_media", an.a.b("associated_media", 8, ed.class));
        b.put("attendeeCount", an.a.a("attendeeCount", 9));
        b.put("attendees", an.a.b("attendees", 10, ed.class));
        b.put("audio", an.a.a("audio", 11, ed.class));
        b.put("author", an.a.b("author", 12, ed.class));
        b.put("bestRating", an.a.d("bestRating", 13));
        b.put("birthDate", an.a.d("birthDate", 14));
        b.put("byArtist", an.a.a("byArtist", 15, ed.class));
        b.put("caption", an.a.d("caption", 16));
        b.put("contentSize", an.a.d("contentSize", 17));
        b.put("contentUrl", an.a.d("contentUrl", 18));
        b.put("contributor", an.a.b("contributor", 19, ed.class));
        b.put("dateCreated", an.a.d("dateCreated", 20));
        b.put("dateModified", an.a.d("dateModified", 21));
        b.put("datePublished", an.a.d("datePublished", 22));
        b.put("description", an.a.d("description", 23));
        b.put("duration", an.a.d("duration", 24));
        b.put("embedUrl", an.a.d("embedUrl", 25));
        b.put("endDate", an.a.d("endDate", 26));
        b.put("familyName", an.a.d("familyName", 27));
        b.put("gender", an.a.d("gender", 28));
        b.put("geo", an.a.a("geo", 29, ed.class));
        b.put("givenName", an.a.d("givenName", 30));
        b.put("height", an.a.d("height", 31));
        b.put("id", an.a.d("id", 32));
        b.put("image", an.a.d("image", 33));
        b.put("inAlbum", an.a.a("inAlbum", 34, ed.class));
        b.put("latitude", an.a.b("latitude", 36));
        b.put(Headers.LOCATION, an.a.a(Headers.LOCATION, 37, ed.class));
        b.put("longitude", an.a.b("longitude", 38));
        b.put("name", an.a.d("name", 39));
        b.put("partOfTVSeries", an.a.a("partOfTVSeries", 40, ed.class));
        b.put("performers", an.a.b("performers", 41, ed.class));
        b.put("playerType", an.a.d("playerType", 42));
        b.put("postOfficeBoxNumber", an.a.d("postOfficeBoxNumber", 43));
        b.put("postalCode", an.a.d("postalCode", 44));
        b.put("ratingValue", an.a.d("ratingValue", 45));
        b.put("reviewRating", an.a.a("reviewRating", 46, ed.class));
        b.put("startDate", an.a.d("startDate", 47));
        b.put("streetAddress", an.a.d("streetAddress", 48));
        b.put("text", an.a.d("text", 49));
        b.put("thumbnail", an.a.a("thumbnail", 50, ed.class));
        b.put("thumbnailUrl", an.a.d("thumbnailUrl", 51));
        b.put("tickerSymbol", an.a.d("tickerSymbol", 52));
        b.put("type", an.a.d("type", 53));
        b.put("url", an.a.d("url", 54));
        b.put("width", an.a.d("width", 55));
        b.put("worstRating", an.a.d("worstRating", 56));
    }

    public ed() {
        this.d = 1;
        this.c = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed(Set set, int i, ed edVar, List list, ed edVar2, String str, String str2, String str3, List list2, int i2, List list3, ed edVar3, List list4, String str4, String str5, ed edVar4, String str6, String str7, String str8, List list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, ed edVar5, String str18, String str19, String str20, String str21, ed edVar6, double d, ed edVar7, double d2, String str22, ed edVar8, List list6, String str23, String str24, String str25, String str26, ed edVar9, String str27, String str28, String str29, ed edVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.c = set;
        this.d = i;
        this.e = edVar;
        this.f = list;
        this.g = edVar2;
        this.h = str;
        this.i = str2;
        this.j = str3;
        this.k = list2;
        this.l = i2;
        this.m = list3;
        this.n = edVar3;
        this.o = list4;
        this.p = str4;
        this.q = str5;
        this.r = edVar4;
        this.s = str6;
        this.t = str7;
        this.u = str8;
        this.v = list5;
        this.w = str9;
        this.x = str10;
        this.y = str11;
        this.z = str12;
        this.A = str13;
        this.B = str14;
        this.C = str15;
        this.D = str16;
        this.E = str17;
        this.F = edVar5;
        this.G = str18;
        this.H = str19;
        this.I = str20;
        this.J = str21;
        this.K = edVar6;
        this.L = d;
        this.M = edVar7;
        this.N = d2;
        this.O = str22;
        this.P = edVar8;
        this.Q = list6;
        this.R = str23;
        this.S = str24;
        this.T = str25;
        this.U = str26;
        this.V = edVar9;
        this.W = str27;
        this.X = str28;
        this.Y = str29;
        this.Z = edVar10;
        this.aa = str30;
        this.ab = str31;
        this.ac = str32;
        this.ad = str33;
        this.ae = str34;
        this.af = str35;
    }

    public String A() {
        return this.y;
    }

    public String B() {
        return this.z;
    }

    public String C() {
        return this.A;
    }

    public String D() {
        return this.B;
    }

    public String E() {
        return this.C;
    }

    public String F() {
        return this.D;
    }

    public String G() {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed H() {
        return this.F;
    }

    public String I() {
        return this.G;
    }

    public String J() {
        return this.H;
    }

    public String K() {
        return this.I;
    }

    public String L() {
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed M() {
        return this.K;
    }

    public double N() {
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed O() {
        return this.M;
    }

    public double P() {
        return this.N;
    }

    public String Q() {
        return this.O;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed R() {
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List S() {
        return this.Q;
    }

    public String T() {
        return this.R;
    }

    public String U() {
        return this.S;
    }

    public String V() {
        return this.T;
    }

    public String W() {
        return this.U;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed X() {
        return this.V;
    }

    public String Y() {
        return this.W;
    }

    public String Z() {
        return this.X;
    }

    @Override // com.google.android.gms.internal.an
    protected Object a(String str) {
        return null;
    }

    @Override // com.google.android.gms.internal.an
    public HashMap a() {
        return b;
    }

    @Override // com.google.android.gms.internal.an
    protected boolean a(an.a aVar) {
        return this.c.contains(Integer.valueOf(aVar.g()));
    }

    public String aa() {
        return this.Y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed ab() {
        return this.Z;
    }

    public String ac() {
        return this.aa;
    }

    public String ad() {
        return this.ab;
    }

    public String ae() {
        return this.ac;
    }

    public String af() {
        return this.ad;
    }

    public String ag() {
        return this.ae;
    }

    public String ah() {
        return this.af;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: ai */
    public ed g() {
        return this;
    }

    @Override // com.google.android.gms.internal.an
    protected Object b(an.a aVar) {
        switch (aVar.g()) {
            case 2:
                return this.e;
            case 3:
                return this.f;
            case 4:
                return this.g;
            case 5:
                return this.h;
            case 6:
                return this.i;
            case 7:
                return this.j;
            case 8:
                return this.k;
            case 9:
                return Integer.valueOf(this.l);
            case 10:
                return this.m;
            case 11:
                return this.n;
            case 12:
                return this.o;
            case 13:
                return this.p;
            case 14:
                return this.q;
            case 15:
                return this.r;
            case 16:
                return this.s;
            case 17:
                return this.t;
            case 18:
                return this.u;
            case 19:
                return this.v;
            case 20:
                return this.w;
            case 21:
                return this.x;
            case DERTags.IA5_STRING /* 22 */:
                return this.y;
            case DERTags.UTC_TIME /* 23 */:
                return this.z;
            case DERTags.GENERALIZED_TIME /* 24 */:
                return this.A;
            case DERTags.GRAPHIC_STRING /* 25 */:
                return this.B;
            case DERTags.VISIBLE_STRING /* 26 */:
                return this.C;
            case DERTags.GENERAL_STRING /* 27 */:
                return this.D;
            case DERTags.UNIVERSAL_STRING /* 28 */:
                return this.E;
            case 29:
                return this.F;
            case DERTags.BMP_STRING /* 30 */:
                return this.G;
            case 31:
                return this.H;
            case 32:
                return this.I;
            case 33:
                return this.J;
            case 34:
                return this.K;
            case 35:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.g());
            case 36:
                return Double.valueOf(this.L);
            case 37:
                return this.M;
            case 38:
                return Double.valueOf(this.N);
            case 39:
                return this.O;
            case 40:
                return this.P;
            case 41:
                return this.Q;
            case 42:
                return this.R;
            case 43:
                return this.S;
            case 44:
                return this.T;
            case MKSearch.TYPE_AREA_MULTI_POI_LIST /* 45 */:
                return this.U;
            case 46:
                return this.V;
            case 47:
                return this.W;
            case MapView.LayoutParams.TOP /* 48 */:
                return this.X;
            case 49:
                return this.Y;
            case GeoSearchManager.GEO_SEARCH /* 50 */:
                return this.Z;
            case 51:
                return this.aa;
            case MKSearch.POI_DETAIL_SEARCH /* 52 */:
                return this.ab;
            case 53:
                return this.ac;
            case 54:
                return this.ad;
            case 55:
                return this.ae;
            case 56:
                return this.af;
        }
    }

    @Override // com.google.android.gms.internal.an
    protected boolean b(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set d() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        ee eeVar = a;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ed) {
            if (this == obj) {
                return true;
            }
            ed edVar = (ed) obj;
            for (an.a aVar : b.values()) {
                if (a(aVar)) {
                    if (edVar.a(aVar) && b(aVar).equals(edVar.b(aVar))) {
                    }
                    return false;
                } else if (edVar.a(aVar)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed f() {
        return this.e;
    }

    public List h() {
        return this.f;
    }

    public int hashCode() {
        int i = 0;
        Iterator it = b.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            an.a aVar = (an.a) it.next();
            if (a(aVar)) {
                i = b(aVar).hashCode() + i2 + aVar.g();
            } else {
                i = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed i() {
        return this.g;
    }

    public String j() {
        return this.h;
    }

    public String k() {
        return this.i;
    }

    public String l() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List m() {
        return this.k;
    }

    public int n() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List o() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed p() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List q() {
        return this.o;
    }

    public String r() {
        return this.p;
    }

    public String s() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed t() {
        return this.r;
    }

    public String u() {
        return this.s;
    }

    public String v() {
        return this.t;
    }

    public String w() {
        return this.u;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ee eeVar = a;
        ee.a(this, parcel, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List x() {
        return this.v;
    }

    public String y() {
        return this.w;
    }

    public String z() {
        return this.x;
    }
}
