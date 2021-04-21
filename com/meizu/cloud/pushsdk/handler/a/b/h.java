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
    public b f38221a;

    /* renamed from: b  reason: collision with root package name */
    public String f38222b;

    /* renamed from: c  reason: collision with root package name */
    public int f38223c;

    public h(Parcel parcel) {
        this.f38221a = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f38222b = parcel.readString();
        this.f38223c = parcel.readInt();
    }

    public h(String str, String str2, String str3, String str4, String str5) {
        this.f38222b = str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(MiPushMessage.KEY_NOTIFY_ID)) {
                this.f38223c = jSONObject.getInt(MiPushMessage.KEY_NOTIFY_ID);
            }
        } catch (JSONException e2) {
            d.k.a.a.a.b("WithDrawMessage", "parse WithDrawMessage error " + e2.getMessage());
        }
        this.f38221a = new b(str3, str4, str5);
    }

    public b a() {
        return this.f38221a;
    }

    public int b() {
        return this.f38223c;
    }

    public String c() {
        return this.f38222b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WithDrawMessage{controlMessage=" + this.f38221a + ", revokePackageName='" + this.f38222b + "', notifyId=" + this.f38223c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f38221a, i);
        parcel.writeString(this.f38222b);
        parcel.writeInt(this.f38223c);
    }
}
