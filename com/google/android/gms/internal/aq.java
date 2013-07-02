package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.an;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class aq implements ae {
    public static final ar a = new ar();
    private final int b;
    private final HashMap c;
    private final ArrayList d = null;
    private final String e;

    /* loaded from: classes.dex */
    public class a implements ae {
        public static final as a = new as();
        final int b;
        final String c;
        final ArrayList d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, String str, ArrayList arrayList) {
            this.b = i;
            this.c = str;
            this.d = arrayList;
        }

        a(String str, HashMap hashMap) {
            this.b = 1;
            this.c = str;
            this.d = a(hashMap);
        }

        private static ArrayList a(HashMap hashMap) {
            if (hashMap == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : hashMap.keySet()) {
                arrayList.add(new b(str, (an.a) hashMap.get(str)));
            }
            return arrayList;
        }

        HashMap a() {
            HashMap hashMap = new HashMap();
            int size = this.d.size();
            for (int i = 0; i < size; i++) {
                b bVar = (b) this.d.get(i);
                hashMap.put(bVar.c, bVar.d);
            }
            return hashMap;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            as asVar = a;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            as asVar = a;
            as.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public class b implements ae {
        public static final ap a = new ap();
        final int b;
        final String c;
        final an.a d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i, String str, an.a aVar) {
            this.b = i;
            this.c = str;
            this.d = aVar;
        }

        b(String str, an.a aVar) {
            this.b = 1;
            this.c = str;
            this.d = aVar;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            ap apVar = a;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            ap apVar = a;
            ap.a(this, parcel, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(int i, ArrayList arrayList, String str) {
        this.b = i;
        this.c = a(arrayList);
        this.e = (String) x.a(str);
        a();
    }

    private static HashMap a(ArrayList arrayList) {
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) arrayList.get(i);
            hashMap.put(aVar.c, aVar.a());
        }
        return hashMap;
    }

    public HashMap a(String str) {
        return (HashMap) this.c.get(str);
    }

    public void a() {
        for (String str : this.c.keySet()) {
            HashMap hashMap = (HashMap) this.c.get(str);
            for (String str2 : hashMap.keySet()) {
                ((an.a) hashMap.get(str2)).a(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList c() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.c.keySet()) {
            arrayList.add(new a(str, (HashMap) this.c.get(str)));
        }
        return arrayList;
    }

    public String d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        ar arVar = a;
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.c.keySet()) {
            sb.append(str).append(":\n");
            HashMap hashMap = (HashMap) this.c.get(str);
            for (String str2 : hashMap.keySet()) {
                sb.append("  ").append(str2).append(": ");
                sb.append(hashMap.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ar arVar = a;
        ar.a(this, parcel, i);
    }
}
