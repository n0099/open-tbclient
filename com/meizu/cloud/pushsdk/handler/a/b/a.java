package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
    public int f38184a;

    /* renamed from: b  reason: collision with root package name */
    public int f38185b;

    /* renamed from: c  reason: collision with root package name */
    public int f38186c;

    public a() {
    }

    public a(Parcel parcel) {
        this.f38184a = parcel.readInt();
        this.f38185b = parcel.readInt();
        this.f38186c = parcel.readInt();
    }

    public static a a(JSONObject jSONObject) {
        String str;
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
            } catch (JSONException e2) {
                str = " parse control message error " + e2.getMessage();
            }
            return aVar;
        }
        str = "no control message can parse ";
        d.k.a.a.a.b("ctl", str);
        return aVar;
    }

    public int a() {
        return this.f38184a;
    }

    public void a(int i) {
        this.f38184a = i;
    }

    public void b(int i) {
        this.f38185b = i;
    }

    public void c(int i) {
        this.f38186c = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Control{pushType=" + this.f38184a + ", cached=" + this.f38185b + ", cacheNum=" + this.f38186c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f38184a);
        parcel.writeInt(this.f38185b);
        parcel.writeInt(this.f38186c);
    }
}
