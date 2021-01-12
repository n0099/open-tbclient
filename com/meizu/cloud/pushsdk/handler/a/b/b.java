package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
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

    /* renamed from: a  reason: collision with root package name */
    private String f11309a;

    /* renamed from: b  reason: collision with root package name */
    private a f11310b;
    private f c;

    public b() {
    }

    protected b(Parcel parcel) {
        this.f11309a = parcel.readString();
        this.f11310b = (a) parcel.readParcelable(a.class.getClassLoader());
        this.c = (f) parcel.readParcelable(f.class.getClassLoader());
    }

    public b(String str, String str2, String str3) {
        this.f11309a = str;
        if (TextUtils.isEmpty(str)) {
            this.f11310b = new a();
            this.c = new f();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.f11310b = a.a(jSONObject.getJSONObject("ctl"));
                this.c = f.a(jSONObject.getJSONObject("statics"));
                this.c.c(str2);
                this.c.d(str3);
            }
        } catch (JSONException e) {
            this.f11310b = new a();
            this.c = new f();
            com.meizu.cloud.a.a.e("ControlMessage", "parse control message error " + e.getMessage());
        }
    }

    public static b a(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                bVar.a(a.a(jSONObject.getJSONObject("ctl")));
                bVar.a(f.a(jSONObject.getJSONObject("statics")));
            }
        } catch (Exception e) {
            com.meizu.cloud.a.a.e("ControlMessage", "parse control message error " + e.getMessage());
            bVar.a(new f());
            bVar.a(new a());
        }
        return bVar;
    }

    public a a() {
        return this.f11310b;
    }

    public void a(a aVar) {
        this.f11310b = aVar;
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
        return "ControlMessage{controlMessage='" + this.f11309a + "', control=" + this.f11310b + ", statics=" + this.c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11309a);
        parcel.writeParcelable(this.f11310b, i);
        parcel.writeParcelable(this.c, i);
    }
}
