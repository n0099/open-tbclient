package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.an;
/* loaded from: classes.dex */
public class ai implements ae {
    public static final aj a = new aj();
    private final int b;
    private final ak c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(int i, ak akVar) {
        this.b = i;
        this.c = akVar;
    }

    private ai(ak akVar) {
        this.b = 1;
        this.c = akVar;
    }

    public static ai a(an.b bVar) {
        if (bVar instanceof ak) {
            return new ai((ak) bVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak b() {
        return this.c;
    }

    public an.b c() {
        if (this.c != null) {
            return this.c;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        aj ajVar = a;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        aj ajVar = a;
        aj.a(this, parcel, i);
    }
}
