package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class at extends an implements ae {
    public static final au a = new au();
    private final int b;
    private final Parcel c;
    private final int d = 2;
    private final aq e;
    private final String f;
    private int g;
    private int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(int i, Parcel parcel, aq aqVar) {
        this.b = i;
        this.c = (Parcel) x.a(parcel);
        this.e = aqVar;
        if (this.e == null) {
            this.f = null;
        } else {
            this.f = this.e.d();
        }
        this.g = 2;
    }

    public static HashMap a(Bundle bundle) {
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    private static HashMap a(HashMap hashMap) {
        HashMap hashMap2 = new HashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            hashMap2.put(Integer.valueOf(((an.a) entry.getValue()).g()), entry);
        }
        return hashMap2;
    }

    private void a(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"").append(ay.a(obj.toString())).append("\"");
                return;
            case 8:
                sb.append("\"").append(aw.a((byte[]) obj)).append("\"");
                return;
            case 9:
                sb.append("\"").append(aw.b((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                az.a(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void a(StringBuilder sb, an.a aVar, Parcel parcel, int i) {
        switch (aVar.d()) {
            case 0:
                a(sb, aVar, a(aVar, Integer.valueOf(ac.f(parcel, i))));
                return;
            case 1:
                a(sb, aVar, a(aVar, ac.h(parcel, i)));
                return;
            case 2:
                a(sb, aVar, a(aVar, Long.valueOf(ac.g(parcel, i))));
                return;
            case 3:
                a(sb, aVar, a(aVar, Float.valueOf(ac.i(parcel, i))));
                return;
            case 4:
                a(sb, aVar, a(aVar, Double.valueOf(ac.j(parcel, i))));
                return;
            case 5:
                a(sb, aVar, a(aVar, ac.k(parcel, i)));
                return;
            case 6:
                a(sb, aVar, a(aVar, Boolean.valueOf(ac.c(parcel, i))));
                return;
            case 7:
                a(sb, aVar, a(aVar, ac.l(parcel, i)));
                return;
            case 8:
            case 9:
                a(sb, aVar, a(aVar, ac.o(parcel, i)));
                return;
            case 10:
                a(sb, aVar, a(aVar, a(ac.n(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + aVar.d());
        }
    }

    private void a(StringBuilder sb, an.a aVar, Object obj) {
        if (aVar.c()) {
            a(sb, aVar, (ArrayList) obj);
        } else {
            a(sb, aVar.b(), obj);
        }
    }

    private void a(StringBuilder sb, an.a aVar, ArrayList arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            a(sb, aVar.b(), arrayList.get(i));
        }
        sb.append("]");
    }

    private void a(StringBuilder sb, String str, an.a aVar, Parcel parcel, int i) {
        sb.append("\"").append(str).append("\":");
        if (aVar.j()) {
            a(sb, aVar, parcel, i);
        } else {
            b(sb, aVar, parcel, i);
        }
    }

    private void a(StringBuilder sb, HashMap hashMap, Parcel parcel) {
        HashMap a2 = a(hashMap);
        sb.append('{');
        int b = ac.b(parcel);
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a3 = ac.a(parcel);
            Map.Entry entry = (Map.Entry) a2.get(Integer.valueOf(ac.a(a3)));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                a(sb, (String) entry.getKey(), (an.a) entry.getValue(), parcel, a3);
                z = true;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ac.a("Overread allowed size end=" + b, parcel);
        }
        sb.append('}');
    }

    private void b(StringBuilder sb, an.a aVar, Parcel parcel, int i) {
        if (aVar.e()) {
            sb.append("[");
            switch (aVar.d()) {
                case 0:
                    av.a(sb, ac.q(parcel, i));
                    break;
                case 1:
                    av.a(sb, ac.s(parcel, i));
                    break;
                case 2:
                    av.a(sb, ac.r(parcel, i));
                    break;
                case 3:
                    av.a(sb, ac.t(parcel, i));
                    break;
                case 4:
                    av.a(sb, ac.u(parcel, i));
                    break;
                case 5:
                    av.a(sb, ac.v(parcel, i));
                    break;
                case 6:
                    av.a(sb, ac.p(parcel, i));
                    break;
                case 7:
                    av.a(sb, ac.w(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] z = ac.z(parcel, i);
                    int length = z.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        z[i2].setDataPosition(0);
                        a(sb, aVar.l(), z[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            sb.append("]");
            return;
        }
        switch (aVar.d()) {
            case 0:
                sb.append(ac.f(parcel, i));
                return;
            case 1:
                sb.append(ac.h(parcel, i));
                return;
            case 2:
                sb.append(ac.g(parcel, i));
                return;
            case 3:
                sb.append(ac.i(parcel, i));
                return;
            case 4:
                sb.append(ac.j(parcel, i));
                return;
            case 5:
                sb.append(ac.k(parcel, i));
                return;
            case 6:
                sb.append(ac.c(parcel, i));
                return;
            case 7:
                sb.append("\"").append(ay.a(ac.l(parcel, i))).append("\"");
                return;
            case 8:
                sb.append("\"").append(aw.a(ac.o(parcel, i))).append("\"");
                return;
            case 9:
                sb.append("\"").append(aw.b(ac.o(parcel, i)));
                sb.append("\"");
                return;
            case 10:
                Bundle n = ac.n(parcel, i);
                Set<String> keySet = n.keySet();
                keySet.size();
                sb.append("{");
                boolean z2 = true;
                for (String str : keySet) {
                    if (!z2) {
                        sb.append(",");
                    }
                    sb.append("\"").append(str).append("\"");
                    sb.append(":");
                    sb.append("\"").append(ay.a(n.getString(str))).append("\"");
                    z2 = false;
                }
                sb.append("}");
                return;
            case 11:
                Parcel y = ac.y(parcel, i);
                y.setDataPosition(0);
                a(sb, aVar.l(), y);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    public ae a(Parcelable.Creator creator) {
        Parcel e = e();
        e.setDataPosition(0);
        return (ae) creator.createFromParcel(e);
    }

    @Override // com.google.android.gms.internal.an
    protected Object a(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.internal.an
    public HashMap a() {
        if (this.e == null) {
            return null;
        }
        return this.e.a(this.f);
    }

    @Override // com.google.android.gms.internal.an
    protected boolean b(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int d() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        au auVar = a;
        return 0;
    }

    public Parcel e() {
        switch (this.g) {
            case 0:
                this.h = ad.a(this.c);
                ad.a(this.c, this.h);
                this.g = 2;
                break;
            case 1:
                ad.a(this.c, this.h);
                this.g = 2;
                break;
        }
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq f() {
        switch (this.d) {
            case 0:
                return null;
            case 1:
                return this.e;
            case 2:
                return this.e;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.d);
        }
    }

    @Override // com.google.android.gms.internal.an
    public String toString() {
        x.a(this.e, "Cannot convert to JSON on client side.");
        Parcel e = e();
        e.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        a(sb, this.e.a(this.f), e);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        au auVar = a;
        au.a(this, parcel, i);
    }
}
