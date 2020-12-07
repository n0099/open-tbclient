package com.meizu.cloud.pushsdk.notification.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes16.dex */
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

    /* renamed from: a  reason: collision with root package name */
    private int f4200a;
    private String b;

    public a() {
        this.f4200a = 0;
    }

    protected a(Parcel parcel) {
        this.f4200a = 0;
        this.f4200a = parcel.readInt();
        this.b = parcel.readString();
    }

    public static a a(MessageV3 messageV3) {
        a aVar = null;
        try {
            if (!TextUtils.isEmpty(messageV3.getNotificationMessage())) {
                aVar = a(new JSONObject(messageV3.getNotificationMessage()).getJSONObject("data").getJSONObject("extra").getJSONObject("no"));
            }
        } catch (Exception e) {
            com.meizu.cloud.a.a.e("NotifyOption", "parse flyme NotifyOption setting error " + e.getMessage() + " so get from notificationMessage");
            aVar = c(messageV3.getNotificationMessage());
        }
        com.meizu.cloud.a.a.i("NotifyOption", "current notify option is " + aVar);
        return aVar;
    }

    public static a a(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("ni")) {
                    aVar.a(jSONObject.getInt("ni"));
                }
                if (!jSONObject.isNull("nk")) {
                    aVar.a(jSONObject.getString("nk"));
                }
            } catch (JSONException e) {
                com.meizu.cloud.a.a.e("NotifyOption", "parse json obj error " + e.getMessage());
            }
        } else {
            com.meizu.cloud.a.a.e("NotifyOption", "no such tag NotifyOption");
        }
        return aVar;
    }

    public static int b(MessageV3 messageV3) {
        a a2 = a(messageV3);
        if (a2 != null) {
            return a2.a();
        }
        return 0;
    }

    public static a b(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                com.meizu.cloud.a.a.e("NotifyOption", "parse json string error " + e.getMessage());
            }
            return a(jSONObject);
        }
        jSONObject = null;
        return a(jSONObject);
    }

    private static a c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return b(new JSONObject(str).getString("no"));
        } catch (JSONException e) {
            com.meizu.cloud.a.a.e("NotifyOption", "parse notificationMessage error " + e.getMessage());
            return null;
        }
    }

    public int a() {
        return this.f4200a;
    }

    public void a(int i) {
        this.f4200a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotifyOption{notifyId=" + this.f4200a + ", notifyKey='" + this.b + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4200a);
        parcel.writeString(this.b);
    }
}
