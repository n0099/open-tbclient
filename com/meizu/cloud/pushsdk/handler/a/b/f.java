package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new Parcelable.Creator<f>() { // from class: com.meizu.cloud.pushsdk.handler.a.b.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public f[] newArray(int i2) {
            return new f[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f35015a;

    /* renamed from: b  reason: collision with root package name */
    public String f35016b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35017c;

    /* renamed from: d  reason: collision with root package name */
    public String f35018d;

    /* renamed from: e  reason: collision with root package name */
    public String f35019e;

    public f() {
        this.f35017c = false;
    }

    public f(Parcel parcel) {
        this.f35017c = false;
        this.f35015a = parcel.readString();
        this.f35016b = parcel.readString();
        this.f35017c = parcel.readByte() != 0;
        this.f35018d = parcel.readString();
        this.f35019e = parcel.readString();
    }

    public static f a(JSONObject jSONObject) {
        String str;
        f fVar = new f();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("taskId")) {
                    fVar.a(jSONObject.getString("taskId"));
                }
                if (!jSONObject.isNull("time")) {
                    fVar.b(jSONObject.getString("time"));
                }
                if (!jSONObject.isNull("pushExtra")) {
                    fVar.a(jSONObject.getInt("pushExtra") != 0);
                }
            } catch (JSONException e2) {
                str = " parse statics message error " + e2.getMessage();
            }
            return fVar;
        }
        str = "no control statics can parse ";
        d.j.a.a.a.b("statics", str);
        return fVar;
    }

    public String a() {
        return this.f35015a;
    }

    public void a(String str) {
        this.f35015a = str;
    }

    public void a(boolean z) {
        this.f35017c = z;
    }

    public String b() {
        return this.f35016b;
    }

    public void b(String str) {
        this.f35016b = str;
    }

    public void c(String str) {
        this.f35018d = str;
    }

    public boolean c() {
        return this.f35017c;
    }

    public String d() {
        return this.f35018d;
    }

    public void d(String str) {
        this.f35019e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f35019e;
    }

    public String toString() {
        return "Statics{taskId='" + this.f35015a + "', time='" + this.f35016b + "', pushExtra=" + this.f35017c + ", deviceId='" + this.f35018d + "', seqId='" + this.f35019e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f35015a);
        parcel.writeString(this.f35016b);
        parcel.writeByte(this.f35017c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f35018d);
        parcel.writeString(this.f35019e);
    }
}
