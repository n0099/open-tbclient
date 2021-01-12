package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.meizu.cloud.pushsdk.handler.a.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a[] newArray(int i) {
            return new a[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f11307a;

    /* renamed from: b  reason: collision with root package name */
    private int f11308b;
    private int c;

    public a() {
    }

    protected a(Parcel parcel) {
        this.f11307a = parcel.readInt();
        this.f11308b = parcel.readInt();
        this.c = parcel.readInt();
    }

    public static a a(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("pushType")) {
                    aVar.a(jSONObject.getInt("pushType"));
                }
                if (!jSONObject.isNull("cached")) {
                    aVar.b(jSONObject.getInt("cached"));
                }
                if (!jSONObject.isNull("cacheNum")) {
                    aVar.c(jSONObject.getInt("cacheNum"));
                }
            } catch (JSONException e) {
                com.meizu.cloud.a.a.e("ctl", " parse control message error " + e.getMessage());
            }
        } else {
            com.meizu.cloud.a.a.e("ctl", "no control message can parse ");
        }
        return aVar;
    }

    public int a() {
        return this.f11307a;
    }

    public void a(int i) {
        this.f11307a = i;
    }

    public void b(int i) {
        this.f11308b = i;
    }

    public void c(int i) {
        this.c = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Control{pushType=" + this.f11307a + ", cached=" + this.f11308b + ", cacheNum=" + this.c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11307a);
        parcel.writeInt(this.f11308b);
        parcel.writeInt(this.c);
    }
}
