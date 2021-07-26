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
    public String f37663a;

    /* renamed from: b  reason: collision with root package name */
    public a f37664b;

    /* renamed from: c  reason: collision with root package name */
    public f f37665c;

    public b() {
    }

    public b(Parcel parcel) {
        this.f37663a = parcel.readString();
        this.f37664b = (a) parcel.readParcelable(a.class.getClassLoader());
        this.f37665c = (f) parcel.readParcelable(f.class.getClassLoader());
    }

    public b(String str, String str2, String str3) {
        this.f37663a = str;
        if (TextUtils.isEmpty(str)) {
            this.f37664b = new a();
            this.f37665c = new f();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f37664b = a.a(jSONObject.getJSONObject("ctl"));
            f a2 = f.a(jSONObject.getJSONObject("statics"));
            this.f37665c = a2;
            a2.c(str2);
            this.f37665c.d(str3);
        } catch (JSONException e2) {
            this.f37664b = new a();
            this.f37665c = new f();
            d.h.a.a.a.b("ControlMessage", "parse control message error " + e2.getMessage());
        }
    }

    public static b a(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.a(a.a(jSONObject.getJSONObject("ctl")));
            bVar.a(f.a(jSONObject.getJSONObject("statics")));
        } catch (Exception e2) {
            d.h.a.a.a.b("ControlMessage", "parse control message error " + e2.getMessage());
            bVar.a(new f());
            bVar.a(new a());
        }
        return bVar;
    }

    public a a() {
        return this.f37664b;
    }

    public void a(a aVar) {
        this.f37664b = aVar;
    }

    public void a(f fVar) {
        this.f37665c = fVar;
    }

    public f b() {
        return this.f37665c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ControlMessage{controlMessage='" + this.f37663a + "', control=" + this.f37664b + ", statics=" + this.f37665c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f37663a);
        parcel.writeParcelable(this.f37664b, i2);
        parcel.writeParcelable(this.f37665c, i2);
    }
}
