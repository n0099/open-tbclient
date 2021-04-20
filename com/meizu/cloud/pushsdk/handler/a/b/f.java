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
        public f[] newArray(int i) {
            return new f[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f38116a;

    /* renamed from: b  reason: collision with root package name */
    public String f38117b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38118c;

    /* renamed from: d  reason: collision with root package name */
    public String f38119d;

    /* renamed from: e  reason: collision with root package name */
    public String f38120e;

    public f() {
        this.f38118c = false;
    }

    public f(Parcel parcel) {
        this.f38118c = false;
        this.f38116a = parcel.readString();
        this.f38117b = parcel.readString();
        this.f38118c = parcel.readByte() != 0;
        this.f38119d = parcel.readString();
        this.f38120e = parcel.readString();
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
        return this.f38116a;
    }

    public void a(String str) {
        this.f38116a = str;
    }

    public void a(boolean z) {
        this.f38118c = z;
    }

    public String b() {
        return this.f38117b;
    }

    public void b(String str) {
        this.f38117b = str;
    }

    public void c(String str) {
        this.f38119d = str;
    }

    public boolean c() {
        return this.f38118c;
    }

    public String d() {
        return this.f38119d;
    }

    public void d(String str) {
        this.f38120e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f38120e;
    }

    public String toString() {
        return "Statics{taskId='" + this.f38116a + "', time='" + this.f38117b + "', pushExtra=" + this.f38118c + ", deviceId='" + this.f38119d + "', seqId='" + this.f38120e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f38116a);
        parcel.writeString(this.f38117b);
        parcel.writeByte(this.f38118c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f38119d);
        parcel.writeString(this.f38120e);
    }
}
