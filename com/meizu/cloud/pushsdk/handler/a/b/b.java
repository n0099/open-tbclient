package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
    public a f58769b;

    /* renamed from: c  reason: collision with root package name */
    public f f58770c;

    public b() {
    }

    public b(Parcel parcel) {
        this.a = parcel.readString();
        this.f58769b = (a) parcel.readParcelable(a.class.getClassLoader());
        this.f58770c = (f) parcel.readParcelable(f.class.getClassLoader());
    }

    public b(String str, String str2, String str3) {
        this.a = str;
        if (TextUtils.isEmpty(str)) {
            this.f58769b = new a();
            this.f58770c = new f();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f58769b = a.a(jSONObject.getJSONObject("ctl"));
            f a = f.a(jSONObject.getJSONObject("statics"));
            this.f58770c = a;
            a.c(str2);
            this.f58770c.d(str3);
        } catch (JSONException e2) {
            this.f58769b = new a();
            this.f58770c = new f();
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
        return this.f58769b;
    }

    public void a(a aVar) {
        this.f58769b = aVar;
    }

    public void a(f fVar) {
        this.f58770c = fVar;
    }

    public f b() {
        return this.f58770c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ControlMessage{controlMessage='" + this.a + ExtendedMessageFormat.QUOTE + ", control=" + this.f58769b + ", statics=" + this.f58770c + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeParcelable(this.f58769b, i2);
        parcel.writeParcelable(this.f58770c, i2);
    }
}
