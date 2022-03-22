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
        public f[] newArray(int i) {
            return new f[i];
        }
    };
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f42174b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42175c;

    /* renamed from: d  reason: collision with root package name */
    public String f42176d;

    /* renamed from: e  reason: collision with root package name */
    public String f42177e;

    public f() {
        this.f42175c = false;
    }

    public f(Parcel parcel) {
        this.f42175c = false;
        this.a = parcel.readString();
        this.f42174b = parcel.readString();
        this.f42175c = parcel.readByte() != 0;
        this.f42176d = parcel.readString();
        this.f42177e = parcel.readString();
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
        c.h.a.a.a.b("statics", str);
        return fVar;
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.f42175c = z;
    }

    public String b() {
        return this.f42174b;
    }

    public void b(String str) {
        this.f42174b = str;
    }

    public void c(String str) {
        this.f42176d = str;
    }

    public boolean c() {
        return this.f42175c;
    }

    public String d() {
        return this.f42176d;
    }

    public void d(String str) {
        this.f42177e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f42177e;
    }

    public String toString() {
        return "Statics{taskId='" + this.a + "', time='" + this.f42174b + "', pushExtra=" + this.f42175c + ", deviceId='" + this.f42176d + "', seqId='" + this.f42177e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.f42174b);
        parcel.writeByte(this.f42175c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f42176d);
        parcel.writeString(this.f42177e);
    }
}
