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
    public String f35770a;

    /* renamed from: b  reason: collision with root package name */
    public String f35771b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35772c;

    /* renamed from: d  reason: collision with root package name */
    public String f35773d;

    /* renamed from: e  reason: collision with root package name */
    public String f35774e;

    public f() {
        this.f35772c = false;
    }

    public f(Parcel parcel) {
        this.f35772c = false;
        this.f35770a = parcel.readString();
        this.f35771b = parcel.readString();
        this.f35772c = parcel.readByte() != 0;
        this.f35773d = parcel.readString();
        this.f35774e = parcel.readString();
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
        return this.f35770a;
    }

    public void a(String str) {
        this.f35770a = str;
    }

    public void a(boolean z) {
        this.f35772c = z;
    }

    public String b() {
        return this.f35771b;
    }

    public void b(String str) {
        this.f35771b = str;
    }

    public void c(String str) {
        this.f35773d = str;
    }

    public boolean c() {
        return this.f35772c;
    }

    public String d() {
        return this.f35773d;
    }

    public void d(String str) {
        this.f35774e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f35774e;
    }

    public String toString() {
        return "Statics{taskId='" + this.f35770a + "', time='" + this.f35771b + "', pushExtra=" + this.f35772c + ", deviceId='" + this.f35773d + "', seqId='" + this.f35774e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f35770a);
        parcel.writeString(this.f35771b);
        parcel.writeByte(this.f35772c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f35773d);
        parcel.writeString(this.f35774e);
    }
}
