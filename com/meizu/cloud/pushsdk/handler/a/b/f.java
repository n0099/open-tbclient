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
    public String f75234a;

    /* renamed from: b  reason: collision with root package name */
    public String f75235b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f75236c;

    /* renamed from: d  reason: collision with root package name */
    public String f75237d;

    /* renamed from: e  reason: collision with root package name */
    public String f75238e;

    public f() {
        this.f75236c = false;
    }

    public f(Parcel parcel) {
        this.f75236c = false;
        this.f75234a = parcel.readString();
        this.f75235b = parcel.readString();
        this.f75236c = parcel.readByte() != 0;
        this.f75237d = parcel.readString();
        this.f75238e = parcel.readString();
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
        return this.f75234a;
    }

    public void a(String str) {
        this.f75234a = str;
    }

    public void a(boolean z) {
        this.f75236c = z;
    }

    public String b() {
        return this.f75235b;
    }

    public void b(String str) {
        this.f75235b = str;
    }

    public void c(String str) {
        this.f75237d = str;
    }

    public boolean c() {
        return this.f75236c;
    }

    public String d() {
        return this.f75237d;
    }

    public void d(String str) {
        this.f75238e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f75238e;
    }

    public String toString() {
        return "Statics{taskId='" + this.f75234a + ExtendedMessageFormat.QUOTE + ", time='" + this.f75235b + ExtendedMessageFormat.QUOTE + ", pushExtra=" + this.f75236c + ", deviceId='" + this.f75237d + ExtendedMessageFormat.QUOTE + ", seqId='" + this.f75238e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f75234a);
        parcel.writeString(this.f75235b);
        parcel.writeByte(this.f75236c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f75237d);
        parcel.writeString(this.f75238e);
    }
}
