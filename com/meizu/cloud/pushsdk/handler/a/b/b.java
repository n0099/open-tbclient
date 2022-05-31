package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.repackage.ni9;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
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
    public String a;
    public a b;
    public f c;

    public b() {
    }

    public b(Parcel parcel) {
        this.a = parcel.readString();
        this.b = (a) parcel.readParcelable(a.class.getClassLoader());
        this.c = (f) parcel.readParcelable(f.class.getClassLoader());
    }

    public b(String str, String str2, String str3) {
        this.a = str;
        if (TextUtils.isEmpty(str)) {
            this.b = new a();
            this.c = new f();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b = a.a(jSONObject.getJSONObject("ctl"));
            f a = f.a(jSONObject.getJSONObject("statics"));
            this.c = a;
            a.c(str2);
            this.c.d(str3);
        } catch (JSONException e) {
            this.b = new a();
            this.c = new f();
            ni9.b("ControlMessage", "parse control message error " + e.getMessage());
        }
    }

    public static b a(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.a(a.a(jSONObject.getJSONObject("ctl")));
            bVar.a(f.a(jSONObject.getJSONObject("statics")));
        } catch (Exception e) {
            ni9.b("ControlMessage", "parse control message error " + e.getMessage());
            bVar.a(new f());
            bVar.a(new a());
        }
        return bVar;
    }

    public a a() {
        return this.b;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(f fVar) {
        this.c = fVar;
    }

    public f b() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ControlMessage{controlMessage='" + this.a + "', control=" + this.b + ", statics=" + this.c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
    }
}
