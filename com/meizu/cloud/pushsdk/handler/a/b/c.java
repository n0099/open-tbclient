package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.meizu.cloud.pushsdk.handler.MessageV3;
/* loaded from: classes6.dex */
public class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.meizu.cloud.pushsdk.handler.a.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public c[] newArray(int i2) {
            return new c[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public MessageV3 f35749a;

    /* renamed from: b  reason: collision with root package name */
    public String f35750b;

    /* renamed from: c  reason: collision with root package name */
    public int f35751c;

    /* renamed from: d  reason: collision with root package name */
    public int f35752d;

    public c(Parcel parcel) {
        this.f35749a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f35750b = parcel.readString();
        this.f35751c = parcel.readInt();
        this.f35752d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.f35749a = messageV3;
    }

    public MessageV3 a() {
        return this.f35749a;
    }

    public void a(int i2) {
        this.f35751c = i2;
    }

    public void a(String str) {
        this.f35750b = str;
    }

    public int b() {
        return this.f35751c;
    }

    public void b(int i2) {
        this.f35752d = i2;
    }

    public int c() {
        return this.f35752d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.f35749a + ", notificationPkg='" + this.f35750b + "', notificationId='" + this.f35751c + "', state='" + this.f35752d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f35749a, i2);
        parcel.writeString(this.f35750b);
        parcel.writeInt(this.f35751c);
        parcel.writeInt(this.f35752d);
    }
}
