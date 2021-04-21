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
        public b[] newArray(int i) {
            return new b[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f38187a;

    /* renamed from: b  reason: collision with root package name */
    public a f38188b;

    /* renamed from: c  reason: collision with root package name */
    public f f38189c;

    public b() {
    }

    public b(Parcel parcel) {
        this.f38187a = parcel.readString();
        this.f38188b = (a) parcel.readParcelable(a.class.getClassLoader());
        this.f38189c = (f) parcel.readParcelable(f.class.getClassLoader());
    }

    public b(String str, String str2, String str3) {
        this.f38187a = str;
        if (TextUtils.isEmpty(str)) {
            this.f38188b = new a();
            this.f38189c = new f();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f38188b = a.a(jSONObject.getJSONObject("ctl"));
            f a2 = f.a(jSONObject.getJSONObject("statics"));
            this.f38189c = a2;
            a2.c(str2);
            this.f38189c.d(str3);
        } catch (JSONException e2) {
            this.f38188b = new a();
            this.f38189c = new f();
            d.k.a.a.a.b("ControlMessage", "parse control message error " + e2.getMessage());
        }
    }

    public static b a(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.a(a.a(jSONObject.getJSONObject("ctl")));
            bVar.a(f.a(jSONObject.getJSONObject("statics")));
        } catch (Exception e2) {
            d.k.a.a.a.b("ControlMessage", "parse control message error " + e2.getMessage());
            bVar.a(new f());
            bVar.a(new a());
        }
        return bVar;
    }

    public a a() {
        return this.f38188b;
    }

    public void a(a aVar) {
        this.f38188b = aVar;
    }

    public void a(f fVar) {
        this.f38189c = fVar;
    }

    public f b() {
        return this.f38189c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ControlMessage{controlMessage='" + this.f38187a + "', control=" + this.f38188b + ", statics=" + this.f38189c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f38187a);
        parcel.writeParcelable(this.f38188b, i);
        parcel.writeParcelable(this.f38189c, i);
    }
}
