package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.sdk.api.core.RemoteViewBuilder;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
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
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f57349b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f57350c;

    /* renamed from: d  reason: collision with root package name */
    public String f57351d;

    /* renamed from: e  reason: collision with root package name */
    public String f57352e;

    public f() {
        this.f57350c = false;
    }

    public f(Parcel parcel) {
        this.f57350c = false;
        this.a = parcel.readString();
        this.f57349b = parcel.readString();
        this.f57350c = parcel.readByte() != 0;
        this.f57351d = parcel.readString();
        this.f57352e = parcel.readString();
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
        c.k.a.a.a.b("statics", str);
        return fVar;
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.f57350c = z;
    }

    public String b() {
        return this.f57349b;
    }

    public void b(String str) {
        this.f57349b = str;
    }

    public void c(String str) {
        this.f57351d = str;
    }

    public boolean c() {
        return this.f57350c;
    }

    public String d() {
        return this.f57351d;
    }

    public void d(String str) {
        this.f57352e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f57352e;
    }

    public String toString() {
        return "Statics{taskId='" + this.a + ExtendedMessageFormat.QUOTE + ", time='" + this.f57349b + ExtendedMessageFormat.QUOTE + ", pushExtra=" + this.f57350c + ", deviceId='" + this.f57351d + ExtendedMessageFormat.QUOTE + ", seqId='" + this.f57352e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.f57349b);
        parcel.writeByte(this.f57350c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f57351d);
        parcel.writeString(this.f57352e);
    }
}
