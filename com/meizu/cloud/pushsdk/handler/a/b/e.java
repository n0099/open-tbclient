package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>() { // from class: com.meizu.cloud.pushsdk.handler.a.b.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public e[] newArray(int i) {
            return new e[i];
        }
    };
    private String a;
    private String b;
    private boolean c;
    private String d;
    private String e;

    public e() {
        this.c = false;
    }

    protected e(Parcel parcel) {
        this.c = false;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readByte() != 0;
        this.d = parcel.readString();
        this.e = parcel.readString();
    }

    public static e a(JSONObject jSONObject) {
        e eVar = new e();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("taskId")) {
                    eVar.a(jSONObject.getString("taskId"));
                }
                if (!jSONObject.isNull("time")) {
                    eVar.b(jSONObject.getString("time"));
                }
                if (!jSONObject.isNull("pushExtra")) {
                    eVar.a(jSONObject.getInt("pushExtra") != 0);
                }
            } catch (JSONException e) {
                com.meizu.cloud.a.a.e("statics", " parse statics message error " + e.getMessage());
            }
        } else {
            com.meizu.cloud.a.a.e("statics", "no control statics can parse ");
        }
        return eVar;
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.d = str;
    }

    public boolean c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.e;
    }

    public String toString() {
        return "Statics{taskId='" + this.a + "', time='" + this.b + "', pushExtra=" + this.c + ", deviceId='" + this.d + "', seqId='" + this.e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeByte((byte) (this.c ? 1 : 0));
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }
}
