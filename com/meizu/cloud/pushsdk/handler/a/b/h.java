package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.mipush.sdk.MiPushMessage;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
    public b f67637a;

    /* renamed from: b  reason: collision with root package name */
    public String f67638b;

    /* renamed from: c  reason: collision with root package name */
    public int f67639c;

    public h(Parcel parcel) {
        this.f67637a = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f67638b = parcel.readString();
        this.f67639c = parcel.readInt();
    }

    public h(String str, String str2, String str3, String str4, String str5) {
        this.f67638b = str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(MiPushMessage.KEY_NOTIFY_ID)) {
                this.f67639c = jSONObject.getInt(MiPushMessage.KEY_NOTIFY_ID);
            }
        } catch (JSONException e2) {
            b.l.a.a.a.b("WithDrawMessage", "parse WithDrawMessage error " + e2.getMessage());
        }
        this.f67637a = new b(str3, str4, str5);
    }

    public b a() {
        return this.f67637a;
    }

    public int b() {
        return this.f67639c;
    }

    public String c() {
        return this.f67638b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WithDrawMessage{controlMessage=" + this.f67637a + ", revokePackageName='" + this.f67638b + ExtendedMessageFormat.QUOTE + ", notifyId=" + this.f67639c + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f67637a, i2);
        parcel.writeString(this.f67638b);
        parcel.writeInt(this.f67639c);
    }
}
