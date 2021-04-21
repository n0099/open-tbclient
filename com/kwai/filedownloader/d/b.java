package com.kwai.filedownloader.d;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.kwai.filedownloader.d.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b[] newArray(int i) {
            return new b[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, List<String>> f37290a;

    public b() {
    }

    public b(Parcel parcel) {
        this.f37290a = parcel.readHashMap(String.class.getClassLoader());
    }

    public HashMap<String, List<String>> a() {
        return this.f37290a;
    }

    public void a(String str) {
        HashMap<String, List<String>> hashMap = this.f37290a;
        if (hashMap == null) {
            return;
        }
        hashMap.remove(str);
    }

    public void a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        if (str2 == null) {
            throw new NullPointerException("value == null");
        }
        if (this.f37290a == null) {
            this.f37290a = new HashMap<>();
        }
        List<String> list = this.f37290a.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f37290a.put(str, list);
        }
        if (list.contains(str2)) {
            return;
        }
        list.add(str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f37290a.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.f37290a);
    }
}
