package com.kwai.filedownloader.d;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
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
    private HashMap<String, List<String>> f10889a;

    public b() {
    }

    protected b(Parcel parcel) {
        this.f10889a = parcel.readHashMap(String.class.getClassLoader());
    }

    public HashMap<String, List<String>> a() {
        return this.f10889a;
    }

    public void a(String str) {
        if (this.f10889a == null) {
            return;
        }
        this.f10889a.remove(str);
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
        if (this.f10889a == null) {
            this.f10889a = new HashMap<>();
        }
        List<String> list = this.f10889a.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f10889a.put(str, list);
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
        return this.f10889a.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.f10889a);
    }
}
