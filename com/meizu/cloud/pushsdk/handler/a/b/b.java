package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
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
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public a f57331b;

    /* renamed from: c  reason: collision with root package name */
    public f f57332c;

    public b() {
    }

    public b(Parcel parcel) {
        this.a = parcel.readString();
        this.f57331b = (a) parcel.readParcelable(a.class.getClassLoader());
        this.f57332c = (f) parcel.readParcelable(f.class.getClassLoader());
    }

    public b(String str, String str2, String str3) {
        this.a = str;
        if (TextUtils.isEmpty(str)) {
            this.f57331b = new a();
            this.f57332c = new f();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f57331b = a.a(jSONObject.getJSONObject("ctl"));
            f a = f.a(jSONObject.getJSONObject("statics"));
            this.f57332c = a;
            a.c(str2);
            this.f57332c.d(str3);
        } catch (JSONException e2) {
            this.f57331b = new a();
            this.f57332c = new f();
            c.k.a.a.a.b("ControlMessage", "parse control message error " + e2.getMessage());
        }
    }

    public static b a(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.a(a.a(jSONObject.getJSONObject("ctl")));
            bVar.a(f.a(jSONObject.getJSONObject("statics")));
        } catch (Exception e2) {
            c.k.a.a.a.b("ControlMessage", "parse control message error " + e2.getMessage());
            bVar.a(new f());
            bVar.a(new a());
        }
        return bVar;
    }

    public a a() {
        return this.f57331b;
    }

    public void a(a aVar) {
        this.f57331b = aVar;
    }

    public void a(f fVar) {
        this.f57332c = fVar;
    }

    public f b() {
        return this.f57332c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ControlMessage{controlMessage='" + this.a + ExtendedMessageFormat.QUOTE + ", control=" + this.f57331b + ", statics=" + this.f57332c + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeParcelable(this.f57331b, i2);
        parcel.writeParcelable(this.f57332c, i2);
    }
}
