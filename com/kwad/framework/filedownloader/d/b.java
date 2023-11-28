package com.kwad.framework.filedownloader.d;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.sdk.utils.ap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.kwad.framework.filedownloader.d.b.1
        public static b b(Parcel parcel) {
            return new b(parcel);
        }

        public static b[] bx(int i) {
            return new b[i];
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b createFromParcel(Parcel parcel) {
            return b(parcel);
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b[] newArray(int i) {
            return bx(i);
        }
    };
    public HashMap<String, List<String>> aho;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public b() {
    }

    public final String toString() {
        return this.aho.toString();
    }

    public final HashMap<String, List<String>> wa() {
        return this.aho;
    }

    public b(Parcel parcel) {
        this.aho = parcel.readHashMap(String.class.getClassLoader());
    }

    public final void bf(String str) {
        HashMap<String, List<String>> hashMap = this.aho;
        if (hashMap == null) {
            return;
        }
        hashMap.remove(str);
    }

    public final void s(String str, String str2) {
        ap.fZ(str);
        ap.fZ(str2);
        if (this.aho == null) {
            this.aho = new HashMap<>();
        }
        List<String> list = this.aho.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.aho.put(str, list);
        }
        if (!list.contains(str2)) {
            list.add(str2);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.aho);
    }
}
