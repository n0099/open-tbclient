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
        public ParcelableSparseIntArray[] newArray(int i) {
            return new ParcelableSparseIntArray[i];
        }
    }

    public /* synthetic */ ParcelableSparseIntArray(Parcel parcel, a aVar) {
        this(parcel);
    }

    public final void a(SparseArray<Integer> sparseArray) {
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            put(sparseArray.keyAt(i), sparseArray.valueAt(i).intValue());
        }
    }

    public final SparseArray<Object> b() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        int size = size();
        for (int i = 0; i < size; i++) {
            sparseArray.append(keyAt(i), Integer.valueOf(valueAt(i)));
        }
        return sparseArray;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSparseArray(b());
    }

    public ParcelableSparseIntArray() {
    }

    public ParcelableSparseIntArray(Parcel parcel) {
        a(parcel.readSparseArray(ClassLoader.getSystemClassLoader()));
    }
}
