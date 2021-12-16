package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.mipush.sdk.MiPushMessage;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public String f61108b;

    /* renamed from: c  reason: collision with root package name */
    public int f61109c;

    public h(Parcel parcel) {
        this.a = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f61108b = parcel.readString();
        this.f61109c = parcel.readInt();
    }

    public h(String str, String str2, String str3, String str4, String str5) {
        this.f61108b = str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(MiPushMessage.KEY_NOTIFY_ID)) {
                this.f61109c = jSONObject.getInt(MiPushMessage.KEY_NOTIFY_ID);
            }
        } catch (JSONException e2) {
            c.k.a.a.a.b("WithDrawMessage", "parse WithDrawMessage error " + e2.getMessage());
        }
        this.a = new b(str3, str4, str5);
    }

    public b a() {
        return this.a;
    }

    public int b() {
        return this.f61109c;
    }

    public String c() {
        return this.f61108b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WithDrawMessage{controlMessage=" + this.a + ", revokePackageName='" + this.f61108b + ExtendedMessageFormat.QUOTE + ", notifyId=" + this.f61109c + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.a, i2);
        parcel.writeString(this.f61108b);
        parcel.writeInt(this.f61109c);
    }
}
