package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h implements Parcelable {
    public static final Parcelable.Creator<h> CREATOR = new Parcelable.Creator<h>() { // from class: com.meizu.cloud.pushsdk.handler.a.b.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public h createFromParcel(Parcel parcel) {
            return new h(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public h[] newArray(int i) {
            return new h[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private b f11624a;

    /* renamed from: b  reason: collision with root package name */
    private String f11625b;
    private int c;

    protected h(Parcel parcel) {
        this.f11624a = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f11625b = parcel.readString();
        this.c = parcel.readInt();
    }

    public h(String str, String str2, String str3, String str4, String str5) {
        this.f11625b = str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("notifyId")) {
                this.c = jSONObject.getInt("notifyId");
            }
        } catch (JSONException e) {
            com.meizu.cloud.a.a.e("WithDrawMessage", "parse WithDrawMessage error " + e.getMessage());
        }
        this.f11624a = new b(str3, str4, str5);
    }

    public b a() {
        return this.f11624a;
    }

    public int b() {
        return this.c;
    }

    public String c() {
        return this.f11625b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WithDrawMessage{controlMessage=" + this.f11624a + ", revokePackageName='" + this.f11625b + "', notifyId=" + this.c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f11624a, i);
        parcel.writeString(this.f11625b);
        parcel.writeInt(this.c);
    }
}
