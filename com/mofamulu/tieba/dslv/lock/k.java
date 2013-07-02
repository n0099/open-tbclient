package com.mofamulu.tieba.dslv.lock;

import android.os.Parcel;
import android.os.Parcelable;
import com.mofamulu.tieba.dslv.lock.LockPatternView;
/* loaded from: classes.dex */
class k implements Parcelable.Creator {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public LockPatternView.SavedState createFromParcel(Parcel parcel) {
        return new LockPatternView.SavedState(parcel, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public LockPatternView.SavedState[] newArray(int i) {
        return new LockPatternView.SavedState[i];
    }
}
