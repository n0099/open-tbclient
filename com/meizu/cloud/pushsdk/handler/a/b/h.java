package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.mipush.sdk.MiPushMessage;
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
        public h[] newArray(int i2) {
            return new h[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public b f35025a;

    /* renamed from: b  reason: collision with root package name */
    public String f35026b;

    /* renamed from: c  reason: collision with root package name */
    public int f35027c;

    public h(Parcel parcel) {
        this.f35025a = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f35026b = parcel.readString();
        this.f35027c = parcel.readInt();
    }

    public h(String str, String str2, String str3, String str4, String str5) {
        this.f35026b = str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(MiPushMessage.KEY_NOTIFY_ID)) {
                this.f35027c = jSONObject.getInt(MiPushMessage.KEY_NOTIFY_ID);
            }
        } catch (JSONException e2) {
            d.j.a.a.a.b("WithDrawMessage", "parse WithDrawMessage error " + e2.getMessage());
        }
        this.f35025a = new b(str3, str4, str5);
    }

    public b a() {
        return this.f35025a;
    }

    public int b() {
        return this.f35027c;
    }

    public String c() {
        return this.f35026b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WithDrawMessage{controlMessage=" + this.f35025a + ", revokePackageName='" + this.f35026b + "', notifyId=" + this.f35027c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f35025a, i2);
        parcel.writeString(this.f35026b);
        parcel.writeInt(this.f35027c);
    }
}
