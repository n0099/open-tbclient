package com.huewu.pla.lib;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseIntArray;
/* loaded from: classes7.dex */
public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = new Parcelable.Creator<ParcelableSparseIntArray>() { // from class: com.huewu.pla.lib.ParcelableSparseIntArray.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: aq */
        public ParcelableSparseIntArray createFromParcel(Parcel parcel) {
            return new ParcelableSparseIntArray(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ra */
        public ParcelableSparseIntArray[] newArray(int i) {
            return new ParcelableSparseIntArray[i];
        }
    };

    public ParcelableSparseIntArray() {
    }

    private ParcelableSparseIntArray(Parcel parcel) {
        h(parcel.readSparseArray(ClassLoader.getSystemClassLoader()));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSparseArray(etP());
    }

    private SparseArray<Object> etP() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        int size = size();
        for (int i = 0; i < size; i++) {
            sparseArray.append(keyAt(i), Integer.valueOf(valueAt(i)));
        }
        return sparseArray;
    }

    private void h(SparseArray<Integer> sparseArray) {
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            put(sparseArray.keyAt(i), sparseArray.valueAt(i).intValue());
        }
    }
}
