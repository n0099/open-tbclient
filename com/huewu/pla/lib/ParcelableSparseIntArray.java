package com.huewu.pla.lib;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseIntArray;
/* loaded from: classes6.dex */
public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = new a();

    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<ParcelableSparseIntArray> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ParcelableSparseIntArray createFromParcel(Parcel parcel) {
            return new ParcelableSparseIntArray(parcel, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ParcelableSparseIntArray[] newArray(int i2) {
            return new ParcelableSparseIntArray[i2];
        }
    }

    public /* synthetic */ ParcelableSparseIntArray(Parcel parcel, a aVar) {
        this(parcel);
    }

    public final void a(SparseArray<Integer> sparseArray) {
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            put(sparseArray.keyAt(i2), sparseArray.valueAt(i2).intValue());
        }
    }

    public final SparseArray<Object> b() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseArray.append(keyAt(i2), Integer.valueOf(valueAt(i2)));
        }
        return sparseArray;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeSparseArray(b());
    }

    public ParcelableSparseIntArray() {
    }

    public ParcelableSparseIntArray(Parcel parcel) {
        a(parcel.readSparseArray(ClassLoader.getSystemClassLoader()));
    }
}
