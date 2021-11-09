package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
    public int f67599a;

    /* renamed from: b  reason: collision with root package name */
    public int f67600b;

    /* renamed from: c  reason: collision with root package name */
    public int f67601c;

    public a() {
    }

    public a(Parcel parcel) {
        this.f67599a = parcel.readInt();
        this.f67600b = parcel.readInt();
        this.f67601c = parcel.readInt();
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
        b.l.a.a.a.b("ctl", str);
        return aVar;
    }

    public int a() {
        return this.f67599a;
    }

    public void a(int i2) {
        this.f67599a = i2;
    }

    public void b(int i2) {
        this.f67600b = i2;
    }

    public void c(int i2) {
        this.f67601c = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Control{pushType=" + this.f67599a + ", cached=" + this.f67600b + ", cacheNum=" + this.f67601c + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f67599a);
        parcel.writeInt(this.f67600b);
        parcel.writeInt(this.f67601c);
    }
}
