package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.meizu.cloud.pushsdk.handler.a.b.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b[] newArray(int i2) {
            return new b[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f75210a;

    /* renamed from: b  reason: collision with root package name */
    public a f75211b;

    /* renamed from: c  reason: collision with root package name */
    public f f75212c;

    public b() {
    }

    public b(Parcel parcel) {
        this.f75210a = parcel.readString();
        this.f75211b = (a) parcel.readParcelable(a.class.getClassLoader());
        this.f75212c = (f) parcel.readParcelable(f.class.getClassLoader());
    }

    public b(String str, String str2, String str3) {
        this.f75210a = str;
        if (TextUtils.isEmpty(str)) {
            this.f75211b = new a();
            this.f75212c = new f();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f75211b = a.a(jSONObject.getJSONObject("ctl"));
            f a2 = f.a(jSONObject.getJSONObject("statics"));
            this.f75212c = a2;
            a2.c(str2);
            this.f75212c.d(str3);
        } catch (JSONException e2) {
            this.f75211b = new a();
            this.f75212c = new f();
            c.l.a.a.a.b("ControlMessage", "parse control message error " + e2.getMessage());
        }
    }

    public static b a(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.a(a.a(jSONObject.getJSONObject("ctl")));
            bVar.a(f.a(jSONObject.getJSONObject("statics")));
        } catch (Exception e2) {
            c.l.a.a.a.b("ControlMessage", "parse control message error " + e2.getMessage());
            bVar.a(new f());
            bVar.a(new a());
        }
        return bVar;
    }

    public a a() {
        return this.f75211b;
    }

    public void a(a aVar) {
        this.f75211b = aVar;
    }

    public void a(f fVar) {
        this.f75212c = fVar;
    }

    public f b() {
        return this.f75212c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ControlMessage{controlMessage='" + this.f75210a + ExtendedMessageFormat.QUOTE + ", control=" + this.f75211b + ", statics=" + this.f75212c + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f75210a);
        parcel.writeParcelable(this.f75211b, i2);
        parcel.writeParcelable(this.f75212c, i2);
    }
}
