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
        public h[] newArray(int i) {
            return new h[i];
        }
    };
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public String f42182b;

    /* renamed from: c  reason: collision with root package name */
    public int f42183c;

    public h(Parcel parcel) {
        this.a = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f42182b = parcel.readString();
        this.f42183c = parcel.readInt();
    }

    public h(String str, String str2, String str3, String str4, String str5) {
        this.f42182b = str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(MiPushMessage.KEY_NOTIFY_ID)) {
                this.f42183c = jSONObject.getInt(MiPushMessage.KEY_NOTIFY_ID);
            }
        } catch (JSONException e2) {
            c.h.a.a.a.b("WithDrawMessage", "parse WithDrawMessage error " + e2.getMessage());
        }
        this.a = new b(str3, str4, str5);
    }

    public b a() {
        return this.a;
    }

    public int b() {
        return this.f42183c;
    }

    public String c() {
        return this.f42182b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WithDrawMessage{controlMessage=" + this.a + ", revokePackageName='" + this.f42182b + "', notifyId=" + this.f42183c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeString(this.f42182b);
        parcel.writeInt(this.f42183c);
    }
}
