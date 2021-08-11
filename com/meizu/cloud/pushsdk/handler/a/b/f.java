package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.sdk.api.core.RemoteViewBuilder;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
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
    public String f74535a;

    /* renamed from: b  reason: collision with root package name */
    public String f74536b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f74537c;

    /* renamed from: d  reason: collision with root package name */
    public String f74538d;

    /* renamed from: e  reason: collision with root package name */
    public String f74539e;

    public f() {
        this.f74537c = false;
    }

    public f(Parcel parcel) {
        this.f74537c = false;
        this.f74535a = parcel.readString();
        this.f74536b = parcel.readString();
        this.f74537c = parcel.readByte() != 0;
        this.f74538d = parcel.readString();
        this.f74539e = parcel.readString();
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
        c.l.a.a.a.b("statics", str);
        return fVar;
    }

    public String a() {
        return this.f74535a;
    }

    public void a(String str) {
        this.f74535a = str;
    }

    public void a(boolean z) {
        this.f74537c = z;
    }

    public String b() {
        return this.f74536b;
    }

    public void b(String str) {
        this.f74536b = str;
    }

    public void c(String str) {
        this.f74538d = str;
    }

    public boolean c() {
        return this.f74537c;
    }

    public String d() {
        return this.f74538d;
    }

    public void d(String str) {
        this.f74539e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f74539e;
    }

    public String toString() {
        return "Statics{taskId='" + this.f74535a + ExtendedMessageFormat.QUOTE + ", time='" + this.f74536b + ExtendedMessageFormat.QUOTE + ", pushExtra=" + this.f74537c + ", deviceId='" + this.f74538d + ExtendedMessageFormat.QUOTE + ", seqId='" + this.f74539e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f74535a);
        parcel.writeString(this.f74536b);
        parcel.writeByte(this.f74537c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f74538d);
        parcel.writeString(this.f74539e);
    }
}
