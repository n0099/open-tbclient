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
    public MessageV3 f37666a;

    /* renamed from: b  reason: collision with root package name */
    public String f37667b;

    /* renamed from: c  reason: collision with root package name */
    public int f37668c;

    /* renamed from: d  reason: collision with root package name */
    public int f37669d;

    public c(Parcel parcel) {
        this.f37666a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f37667b = parcel.readString();
        this.f37668c = parcel.readInt();
        this.f37669d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.f37666a = messageV3;
    }

    public MessageV3 a() {
        return this.f37666a;
    }

    public void a(int i2) {
        this.f37668c = i2;
    }

    public void a(String str) {
        this.f37667b = str;
    }

    public int b() {
        return this.f37668c;
    }

    public void b(int i2) {
        this.f37669d = i2;
    }

    public int c() {
        return this.f37669d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.f37666a + ", notificationPkg='" + this.f37667b + "', notificationId='" + this.f37668c + "', state='" + this.f37669d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f37666a, i2);
        parcel.writeString(this.f37667b);
        parcel.writeInt(this.f37668c);
        parcel.writeInt(this.f37669d);
    }
}
