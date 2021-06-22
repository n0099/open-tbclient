package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
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
        public a[] newArray(int i2) {
            return new a[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f38694a;

    /* renamed from: b  reason: collision with root package name */
    public int f38695b;

    /* renamed from: c  reason: collision with root package name */
    public int f38696c;

    public a() {
    }

    public a(Parcel parcel) {
        this.f38694a = parcel.readInt();
        this.f38695b = parcel.readInt();
        this.f38696c = parcel.readInt();
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
        d.j.a.a.a.b("ctl", str);
        return aVar;
    }

    public int a() {
        return this.f38694a;
    }

    public void a(int i2) {
        this.f38694a = i2;
    }

    public void b(int i2) {
        this.f38695b = i2;
    }

    public void c(int i2) {
        this.f38696c = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Control{pushType=" + this.f38694a + ", cached=" + this.f38695b + ", cacheNum=" + this.f38696c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f38694a);
        parcel.writeInt(this.f38695b);
        parcel.writeInt(this.f38696c);
    }
}
