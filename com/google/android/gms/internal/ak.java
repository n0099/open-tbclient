package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class ak implements ae, an.b {
    public static final al a = new al();
    private final int b;
    private final HashMap c;
    private final HashMap d;
    private final ArrayList e;

    /* loaded from: classes.dex */
    public final class a implements ae {
        public static final am a = new am();
        final int b;
        final String c;
        final int d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, String str, int i2) {
            this.b = i;
            this.c = str;
            this.d = i2;
        }

        a(String str, int i) {
            this.b = 1;
            this.c = str;
            this.d = i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            am amVar = a;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            am amVar = a;
            am.a(this, parcel, i);
        }
    }

    public ak() {
        this.b = 1;
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(int i, ArrayList arrayList) {
        this.b = i;
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = null;
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            a(aVar.c, aVar.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.b;
    }

    public ak a(String str, int i) {
        this.c.put(str, Integer.valueOf(i));
        this.d.put(Integer.valueOf(i), str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.internal.an.b
    public String a(Integer num) {
        return (String) this.d.get(num);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList b() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.c.keySet()) {
            arrayList.add(new a(str, ((Integer) this.c.get(str)).intValue()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.an.b
    public int c() {
        return 7;
    }

    @Override // com.google.android.gms.internal.an.b
    public int d() {
        return 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        al alVar = a;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        al alVar = a;
        al.a(this, parcel, i);
    }
}
