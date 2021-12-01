package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.sdk.api.core.RemoteViewBuilder;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
    public String f60519b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60520c;

    /* renamed from: d  reason: collision with root package name */
    public String f60521d;

    /* renamed from: e  reason: collision with root package name */
    public String f60522e;

    public f() {
        this.f60520c = false;
    }

    public f(Parcel parcel) {
        this.f60520c = false;
        this.a = parcel.readString();
        this.f60519b = parcel.readString();
        this.f60520c = parcel.readByte() != 0;
        this.f60521d = parcel.readString();
        this.f60522e = parcel.readString();
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
        this.f60520c = z;
    }

    public String b() {
        return this.f60519b;
    }

    public void b(String str) {
        this.f60519b = str;
    }

    public void c(String str) {
        this.f60521d = str;
    }

    public boolean c() {
        return this.f60520c;
    }

    public String d() {
        return this.f60521d;
    }

    public void d(String str) {
        this.f60522e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f60522e;
    }

    public String toString() {
        return "Statics{taskId='" + this.a + ExtendedMessageFormat.QUOTE + ", time='" + this.f60519b + ExtendedMessageFormat.QUOTE + ", pushExtra=" + this.f60520c + ", deviceId='" + this.f60521d + ExtendedMessageFormat.QUOTE + ", seqId='" + this.f60522e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.f60519b);
        parcel.writeByte(this.f60520c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f60521d);
        parcel.writeString(this.f60522e);
    }
}
