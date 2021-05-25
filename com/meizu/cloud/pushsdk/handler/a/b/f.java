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
    public String f34944a;

    /* renamed from: b  reason: collision with root package name */
    public String f34945b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34946c;

    /* renamed from: d  reason: collision with root package name */
    public String f34947d;

    /* renamed from: e  reason: collision with root package name */
    public String f34948e;

    public f() {
        this.f34946c = false;
    }

    public f(Parcel parcel) {
        this.f34946c = false;
        this.f34944a = parcel.readString();
        this.f34945b = parcel.readString();
        this.f34946c = parcel.readByte() != 0;
        this.f34947d = parcel.readString();
        this.f34948e = parcel.readString();
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
        return this.f34944a;
    }

    public void a(String str) {
        this.f34944a = str;
    }

    public void a(boolean z) {
        this.f34946c = z;
    }

    public String b() {
        return this.f34945b;
    }

    public void b(String str) {
        this.f34945b = str;
    }

    public void c(String str) {
        this.f34947d = str;
    }

    public boolean c() {
        return this.f34946c;
    }

    public String d() {
        return this.f34947d;
    }

    public void d(String str) {
        this.f34948e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f34948e;
    }

    public String toString() {
        return "Statics{taskId='" + this.f34944a + "', time='" + this.f34945b + "', pushExtra=" + this.f34946c + ", deviceId='" + this.f34947d + "', seqId='" + this.f34948e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f34944a);
        parcel.writeString(this.f34945b);
        parcel.writeByte(this.f34946c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f34947d);
        parcel.writeString(this.f34948e);
    }
}
