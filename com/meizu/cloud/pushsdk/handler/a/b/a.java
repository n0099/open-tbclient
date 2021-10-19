package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
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
    public int f75242a;

    /* renamed from: b  reason: collision with root package name */
    public int f75243b;

    /* renamed from: c  reason: collision with root package name */
    public int f75244c;

    public a() {
    }

    public a(Parcel parcel) {
        this.f75242a = parcel.readInt();
        this.f75243b = parcel.readInt();
        this.f75244c = parcel.readInt();
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
        c.l.a.a.a.b("ctl", str);
        return aVar;
    }

    public int a() {
        return this.f75242a;
    }

    public void a(int i2) {
        this.f75242a = i2;
    }

    public void b(int i2) {
        this.f75243b = i2;
    }

    public void c(int i2) {
        this.f75244c = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Control{pushType=" + this.f75242a + ", cached=" + this.f75243b + ", cacheNum=" + this.f75244c + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f75242a);
        parcel.writeInt(this.f75243b);
        parcel.writeInt(this.f75244c);
    }
}
