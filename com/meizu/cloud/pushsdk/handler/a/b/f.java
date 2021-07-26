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
    public String f37687a;

    /* renamed from: b  reason: collision with root package name */
    public String f37688b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37689c;

    /* renamed from: d  reason: collision with root package name */
    public String f37690d;

    /* renamed from: e  reason: collision with root package name */
    public String f37691e;

    public f() {
        this.f37689c = false;
    }

    public f(Parcel parcel) {
        this.f37689c = false;
        this.f37687a = parcel.readString();
        this.f37688b = parcel.readString();
        this.f37689c = parcel.readByte() != 0;
        this.f37690d = parcel.readString();
        this.f37691e = parcel.readString();
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
        return this.f37687a;
    }

    public void a(String str) {
        this.f37687a = str;
    }

    public void a(boolean z) {
        this.f37689c = z;
    }

    public String b() {
        return this.f37688b;
    }

    public void b(String str) {
        this.f37688b = str;
    }

    public void c(String str) {
        this.f37690d = str;
    }

    public boolean c() {
        return this.f37689c;
    }

    public String d() {
        return this.f37690d;
    }

    public void d(String str) {
        this.f37691e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f37691e;
    }

    public String toString() {
        return "Statics{taskId='" + this.f37687a + "', time='" + this.f37688b + "', pushExtra=" + this.f37689c + ", deviceId='" + this.f37690d + "', seqId='" + this.f37691e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f37687a);
        parcel.writeString(this.f37688b);
        parcel.writeByte(this.f37689c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f37690d);
        parcel.writeString(this.f37691e);
    }
}
