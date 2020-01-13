package com.huewu.pla.lib;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseIntArray;
/* loaded from: classes2.dex */
public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = new Parcelable.Creator<ParcelableSparseIntArray>() { // from class: com.huewu.pla.lib.ParcelableSparseIntArray.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: aR */
        public ParcelableSparseIntArray createFromParcel(Parcel parcel) {
            return new ParcelableSparseIntArray(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: MC */
        public ParcelableSparseIntArray[] newArray(int i) {
            return new ParcelableSparseIntArray[i];
        }
    };

    public ParcelableSparseIntArray() {
    }

    private ParcelableSparseIntArray(Parcel parcel) {
        g(parcel.readSparseArray(ClassLoader.getSystemClassLoader()));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSparseArray(dAC());
    }

    private SparseArray<Object> dAC() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        int size = size();
        for (int i = 0; i < size; i++) {
            sparseArray.append(keyAt(i), Integer.valueOf(valueAt(i)));
        }
        return sparseArray;
    }

    private void g(SparseArray<Integer> sparseArray) {
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            put(sparseArray.keyAt(i), sparseArray.valueAt(i).intValue());
        }
    }
}
