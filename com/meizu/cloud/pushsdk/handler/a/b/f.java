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
    public String f74735a;

    /* renamed from: b  reason: collision with root package name */
    public String f74736b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f74737c;

    /* renamed from: d  reason: collision with root package name */
    public String f74738d;

    /* renamed from: e  reason: collision with root package name */
    public String f74739e;

    public f() {
        this.f74737c = false;
    }

    public f(Parcel parcel) {
        this.f74737c = false;
        this.f74735a = parcel.readString();
        this.f74736b = parcel.readString();
        this.f74737c = parcel.readByte() != 0;
        this.f74738d = parcel.readString();
        this.f74739e = parcel.readString();
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
        return this.f74735a;
    }

    public void a(String str) {
        this.f74735a = str;
    }

    public void a(boolean z) {
        this.f74737c = z;
    }

    public String b() {
        return this.f74736b;
    }

    public void b(String str) {
        this.f74736b = str;
    }

    public void c(String str) {
        this.f74738d = str;
    }

    public boolean c() {
        return this.f74737c;
    }

    public String d() {
        return this.f74738d;
    }

    public void d(String str) {
        this.f74739e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f74739e;
    }

    public String toString() {
        return "Statics{taskId='" + this.f74735a + ExtendedMessageFormat.QUOTE + ", time='" + this.f74736b + ExtendedMessageFormat.QUOTE + ", pushExtra=" + this.f74737c + ", deviceId='" + this.f74738d + ExtendedMessageFormat.QUOTE + ", seqId='" + this.f74739e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f74735a);
        parcel.writeString(this.f74736b);
        parcel.writeByte(this.f74737c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f74738d);
        parcel.writeString(this.f74739e);
    }
}
