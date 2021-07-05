package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.mipush.sdk.MiPushMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
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
        public h[] newArray(int i2) {
            return new h[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public b f40494a;

    /* renamed from: b  reason: collision with root package name */
    public String f40495b;

    /* renamed from: c  reason: collision with root package name */
    public int f40496c;

    public h(Parcel parcel) {
        this.f40494a = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f40495b = parcel.readString();
        this.f40496c = parcel.readInt();
    }

    public h(String str, String str2, String str3, String str4, String str5) {
        this.f40495b = str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(MiPushMessage.KEY_NOTIFY_ID)) {
                this.f40496c = jSONObject.getInt(MiPushMessage.KEY_NOTIFY_ID);
            }
        } catch (JSONException e2) {
            d.h.a.a.a.b("WithDrawMessage", "parse WithDrawMessage error " + e2.getMessage());
        }
        this.f40494a = new b(str3, str4, str5);
    }

    public b a() {
        return this.f40494a;
    }

    public int b() {
        return this.f40496c;
    }

    public String c() {
        return this.f40495b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WithDrawMessage{controlMessage=" + this.f40494a + ", revokePackageName='" + this.f40495b + "', notifyId=" + this.f40496c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f40494a, i2);
        parcel.writeString(this.f40495b);
        parcel.writeInt(this.f40496c);
    }
}
