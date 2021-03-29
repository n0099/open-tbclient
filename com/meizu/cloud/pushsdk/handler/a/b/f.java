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
    public String f37827a;

    /* renamed from: b  reason: collision with root package name */
    public String f37828b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37829c;

    /* renamed from: d  reason: collision with root package name */
    public String f37830d;

    /* renamed from: e  reason: collision with root package name */
    public String f37831e;

    public f() {
        this.f37829c = false;
    }

    public f(Parcel parcel) {
        this.f37829c = false;
        this.f37827a = parcel.readString();
        this.f37828b = parcel.readString();
        this.f37829c = parcel.readByte() != 0;
        this.f37830d = parcel.readString();
        this.f37831e = parcel.readString();
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
        return this.f37827a;
    }

    public void a(String str) {
        this.f37827a = str;
    }

    public void a(boolean z) {
        this.f37829c = z;
    }

    public String b() {
        return this.f37828b;
    }

    public void b(String str) {
        this.f37828b = str;
    }

    public void c(String str) {
        this.f37830d = str;
    }

    public boolean c() {
        return this.f37829c;
    }

    public String d() {
        return this.f37830d;
    }

    public void d(String str) {
        this.f37831e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f37831e;
    }

    public String toString() {
        return "Statics{taskId='" + this.f37827a + "', time='" + this.f37828b + "', pushExtra=" + this.f37829c + ", deviceId='" + this.f37830d + "', seqId='" + this.f37831e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f37827a);
        parcel.writeString(this.f37828b);
        parcel.writeByte(this.f37829c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f37830d);
        parcel.writeString(this.f37831e);
    }
}
