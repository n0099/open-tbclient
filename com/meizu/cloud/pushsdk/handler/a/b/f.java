package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
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
    public String f40484a;

    /* renamed from: b  reason: collision with root package name */
    public String f40485b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40486c;

    /* renamed from: d  reason: collision with root package name */
    public String f40487d;

    /* renamed from: e  reason: collision with root package name */
    public String f40488e;

    public f() {
        this.f40486c = false;
    }

    public f(Parcel parcel) {
        this.f40486c = false;
        this.f40484a = parcel.readString();
        this.f40485b = parcel.readString();
        this.f40486c = parcel.readByte() != 0;
        this.f40487d = parcel.readString();
        this.f40488e = parcel.readString();
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
        d.h.a.a.a.b("statics", str);
        return fVar;
    }

    public String a() {
        return this.f40484a;
    }

    public void a(String str) {
        this.f40484a = str;
    }

    public void a(boolean z) {
        this.f40486c = z;
    }

    public String b() {
        return this.f40485b;
    }

    public void b(String str) {
        this.f40485b = str;
    }

    public void c(String str) {
        this.f40487d = str;
    }

    public boolean c() {
        return this.f40486c;
    }

    public String d() {
        return this.f40487d;
    }

    public void d(String str) {
        this.f40488e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f40488e;
    }

    public String toString() {
        return "Statics{taskId='" + this.f40484a + "', time='" + this.f40485b + "', pushExtra=" + this.f40486c + ", deviceId='" + this.f40487d + "', seqId='" + this.f40488e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f40484a);
        parcel.writeString(this.f40485b);
        parcel.writeByte(this.f40486c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f40487d);
        parcel.writeString(this.f40488e);
    }
}
