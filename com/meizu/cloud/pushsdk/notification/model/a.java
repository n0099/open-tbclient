package com.meizu.cloud.pushsdk.notification.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.meizu.cloud.pushsdk.notification.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f42199b;

    public a() {
        this.a = 0;
    }

    public a(Parcel parcel) {
        this.a = 0;
        this.a = parcel.readInt();
        this.f42199b = parcel.readString();
    }

    public static a a(MessageV3 messageV3) {
        a c2;
        try {
            c2 = !TextUtils.isEmpty(messageV3.getNotificationMessage()) ? a(new JSONObject(messageV3.getNotificationMessage()).getJSONObject("data").getJSONObject("extra").getJSONObject("no")) : null;
        } catch (Exception e2) {
            c.h.a.a.a.b("NotifyOption", "parse flyme NotifyOption setting error " + e2.getMessage() + " so get from notificationMessage");
            c2 = c(messageV3.getNotificationMessage());
        }
        c.h.a.a.a.d("NotifyOption", "current notify option is " + c2);
        return c2;
    }

    public static a a(JSONObject jSONObject) {
        String str;
        a aVar = new a();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("ni")) {
                    aVar.a(jSONObject.getInt("ni"));
                }
                if (!jSONObject.isNull("nk")) {
                    aVar.a(jSONObject.getString("nk"));
                }
            } catch (JSONException e2) {
                str = "parse json obj error " + e2.getMessage();
            }
            return aVar;
        }
        str = "no such tag NotifyOption";
        c.h.a.a.a.b("NotifyOption", str);
        return aVar;
    }

    public static int b(MessageV3 messageV3) {
        a a = a(messageV3);
        if (a != null) {
            return a.a();
        }
        return 0;
    }

    public static a b(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                c.h.a.a.a.b("NotifyOption", "parse json string error " + e2.getMessage());
            }
            return a(jSONObject);
        }
        jSONObject = null;
        return a(jSONObject);
    }

    public static a c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return b(new JSONObject(str).getString("no"));
        } catch (JSONException e2) {
            c.h.a.a.a.b("NotifyOption", "parse notificationMessage error " + e2.getMessage());
            return null;
        }
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(String str) {
        this.f42199b = str;
    }

    public String b() {
        return this.f42199b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotifyOption{notifyId=" + this.a + ", notifyKey='" + this.f42199b + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.f42199b);
    }
}
