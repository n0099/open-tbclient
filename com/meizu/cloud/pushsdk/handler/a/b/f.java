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

    /* renamed from: a  reason: collision with root package name */
    public String f68539a;

    /* renamed from: b  reason: collision with root package name */
    public String f68540b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f68541c;

    /* renamed from: d  reason: collision with root package name */
    public String f68542d;

    /* renamed from: e  reason: collision with root package name */
    public String f68543e;

    public f() {
        this.f68541c = false;
    }

    public f(Parcel parcel) {
        this.f68541c = false;
        this.f68539a = parcel.readString();
        this.f68540b = parcel.readString();
        this.f68541c = parcel.readByte() != 0;
        this.f68542d = parcel.readString();
        this.f68543e = parcel.readString();
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
        b.j.a.a.a.b("statics", str);
        return fVar;
    }

    public String a() {
        return this.f68539a;
    }

    public void a(String str) {
        this.f68539a = str;
    }

    public void a(boolean z) {
        this.f68541c = z;
    }

    public String b() {
        return this.f68540b;
    }

    public void b(String str) {
        this.f68540b = str;
    }

    public void c(String str) {
        this.f68542d = str;
    }

    public boolean c() {
        return this.f68541c;
    }

    public String d() {
        return this.f68542d;
    }

    public void d(String str) {
        this.f68543e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f68543e;
    }

    public String toString() {
        return "Statics{taskId='" + this.f68539a + ExtendedMessageFormat.QUOTE + ", time='" + this.f68540b + ExtendedMessageFormat.QUOTE + ", pushExtra=" + this.f68541c + ", deviceId='" + this.f68542d + ExtendedMessageFormat.QUOTE + ", seqId='" + this.f68543e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f68539a);
        parcel.writeString(this.f68540b);
        parcel.writeByte(this.f68541c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f68542d);
        parcel.writeString(this.f68543e);
    }
}
