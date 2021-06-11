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
    public String f38623a;

    /* renamed from: b  reason: collision with root package name */
    public String f38624b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38625c;

    /* renamed from: d  reason: collision with root package name */
    public String f38626d;

    /* renamed from: e  reason: collision with root package name */
    public String f38627e;

    public f() {
        this.f38625c = false;
    }

    public f(Parcel parcel) {
        this.f38625c = false;
        this.f38623a = parcel.readString();
        this.f38624b = parcel.readString();
        this.f38625c = parcel.readByte() != 0;
        this.f38626d = parcel.readString();
        this.f38627e = parcel.readString();
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
        return this.f38623a;
    }

    public void a(String str) {
        this.f38623a = str;
    }

    public void a(boolean z) {
        this.f38625c = z;
    }

    public String b() {
        return this.f38624b;
    }

    public void b(String str) {
        this.f38624b = str;
    }

    public void c(String str) {
        this.f38626d = str;
    }

    public boolean c() {
        return this.f38625c;
    }

    public String d() {
        return this.f38626d;
    }

    public void d(String str) {
        this.f38627e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f38627e;
    }

    public String toString() {
        return "Statics{taskId='" + this.f38623a + "', time='" + this.f38624b + "', pushExtra=" + this.f38625c + ", deviceId='" + this.f38626d + "', seqId='" + this.f38627e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f38623a);
        parcel.writeString(this.f38624b);
        parcel.writeByte(this.f38625c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f38626d);
        parcel.writeString(this.f38627e);
    }
}
