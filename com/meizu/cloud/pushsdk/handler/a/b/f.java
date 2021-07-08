package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.sdk.api.core.RemoteViewBuilder;
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
    public String f37498a;

    /* renamed from: b  reason: collision with root package name */
    public String f37499b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37500c;

    /* renamed from: d  reason: collision with root package name */
    public String f37501d;

    /* renamed from: e  reason: collision with root package name */
    public String f37502e;

    public f() {
        this.f37500c = false;
    }

    public f(Parcel parcel) {
        this.f37500c = false;
        this.f37498a = parcel.readString();
        this.f37499b = parcel.readString();
        this.f37500c = parcel.readByte() != 0;
        this.f37501d = parcel.readString();
        this.f37502e = parcel.readString();
    }

    public static f a(JSONObject jSONObject) {
        String str;
        f fVar = new f();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(RemoteViewBuilder.ProgressRemoteViewImpl.KEY_TASKID)) {
                    fVar.a(jSONObject.getString(RemoteViewBuilder.ProgressRemoteViewImpl.KEY_TASKID));
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
        return this.f37498a;
    }

    public void a(String str) {
        this.f37498a = str;
    }

    public void a(boolean z) {
        this.f37500c = z;
    }

    public String b() {
        return this.f37499b;
    }

    public void b(String str) {
        this.f37499b = str;
    }

    public void c(String str) {
        this.f37501d = str;
    }

    public boolean c() {
        return this.f37500c;
    }

    public String d() {
        return this.f37501d;
    }

    public void d(String str) {
        this.f37502e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f37502e;
    }

    public String toString() {
        return "Statics{taskId='" + this.f37498a + "', time='" + this.f37499b + "', pushExtra=" + this.f37500c + ", deviceId='" + this.f37501d + "', seqId='" + this.f37502e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f37498a);
        parcel.writeString(this.f37499b);
        parcel.writeByte(this.f37500c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f37501d);
        parcel.writeString(this.f37502e);
    }
}
