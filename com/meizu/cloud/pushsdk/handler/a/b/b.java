package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
    public String f35746a;

    /* renamed from: b  reason: collision with root package name */
    public a f35747b;

    /* renamed from: c  reason: collision with root package name */
    public f f35748c;

    public b() {
    }

    public b(Parcel parcel) {
        this.f35746a = parcel.readString();
        this.f35747b = (a) parcel.readParcelable(a.class.getClassLoader());
        this.f35748c = (f) parcel.readParcelable(f.class.getClassLoader());
    }

    public b(String str, String str2, String str3) {
        this.f35746a = str;
        if (TextUtils.isEmpty(str)) {
            this.f35747b = new a();
            this.f35748c = new f();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f35747b = a.a(jSONObject.getJSONObject("ctl"));
            f a2 = f.a(jSONObject.getJSONObject("statics"));
            this.f35748c = a2;
            a2.c(str2);
            this.f35748c.d(str3);
        } catch (JSONException e2) {
            this.f35747b = new a();
            this.f35748c = new f();
            d.j.a.a.a.b("ControlMessage", "parse control message error " + e2.getMessage());
        }
    }

    public static b a(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.a(a.a(jSONObject.getJSONObject("ctl")));
            bVar.a(f.a(jSONObject.getJSONObject("statics")));
        } catch (Exception e2) {
            d.j.a.a.a.b("ControlMessage", "parse control message error " + e2.getMessage());
            bVar.a(new f());
            bVar.a(new a());
        }
        return bVar;
    }

    public a a() {
        return this.f35747b;
    }

    public void a(a aVar) {
        this.f35747b = aVar;
    }

    public void a(f fVar) {
        this.f35748c = fVar;
    }

    public f b() {
        return this.f35748c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ControlMessage{controlMessage='" + this.f35746a + "', control=" + this.f35747b + ", statics=" + this.f35748c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f35746a);
        parcel.writeParcelable(this.f35747b, i2);
        parcel.writeParcelable(this.f35748c, i2);
    }
}
