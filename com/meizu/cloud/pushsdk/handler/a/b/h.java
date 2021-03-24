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
        public h[] newArray(int i) {
            return new h[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public b f37836a;

    /* renamed from: b  reason: collision with root package name */
    public String f37837b;

    /* renamed from: c  reason: collision with root package name */
    public int f37838c;

    public h(Parcel parcel) {
        this.f37836a = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f37837b = parcel.readString();
        this.f37838c = parcel.readInt();
    }

    public h(String str, String str2, String str3, String str4, String str5) {
        this.f37837b = str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(MiPushMessage.KEY_NOTIFY_ID)) {
                this.f37838c = jSONObject.getInt(MiPushMessage.KEY_NOTIFY_ID);
            }
        } catch (JSONException e2) {
            d.j.a.a.a.b("WithDrawMessage", "parse WithDrawMessage error " + e2.getMessage());
        }
        this.f37836a = new b(str3, str4, str5);
    }

    public b a() {
        return this.f37836a;
    }

    public int b() {
        return this.f37838c;
    }

    public String c() {
        return this.f37837b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WithDrawMessage{controlMessage=" + this.f37836a + ", revokePackageName='" + this.f37837b + "', notifyId=" + this.f37838c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f37836a, i);
        parcel.writeString(this.f37837b);
        parcel.writeInt(this.f37838c);
    }
}
