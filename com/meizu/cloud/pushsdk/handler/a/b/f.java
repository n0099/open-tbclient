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
    public String f67627a;

    /* renamed from: b  reason: collision with root package name */
    public String f67628b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f67629c;

    /* renamed from: d  reason: collision with root package name */
    public String f67630d;

    /* renamed from: e  reason: collision with root package name */
    public String f67631e;

    public f() {
        this.f67629c = false;
    }

    public f(Parcel parcel) {
        this.f67629c = false;
        this.f67627a = parcel.readString();
        this.f67628b = parcel.readString();
        this.f67629c = parcel.readByte() != 0;
        this.f67630d = parcel.readString();
        this.f67631e = parcel.readString();
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
        b.l.a.a.a.b("statics", str);
        return fVar;
    }

    public String a() {
        return this.f67627a;
    }

    public void a(String str) {
        this.f67627a = str;
    }

    public void a(boolean z) {
        this.f67629c = z;
    }

    public String b() {
        return this.f67628b;
    }

    public void b(String str) {
        this.f67628b = str;
    }

    public void c(String str) {
        this.f67630d = str;
    }

    public boolean c() {
        return this.f67629c;
    }

    public String d() {
        return this.f67630d;
    }

    public void d(String str) {
        this.f67631e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f67631e;
    }

    public String toString() {
        return "Statics{taskId='" + this.f67627a + ExtendedMessageFormat.QUOTE + ", time='" + this.f67628b + ExtendedMessageFormat.QUOTE + ", pushExtra=" + this.f67629c + ", deviceId='" + this.f67630d + ExtendedMessageFormat.QUOTE + ", seqId='" + this.f67631e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f67627a);
        parcel.writeString(this.f67628b);
        parcel.writeByte(this.f67629c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f67630d);
        parcel.writeString(this.f67631e);
    }
}
