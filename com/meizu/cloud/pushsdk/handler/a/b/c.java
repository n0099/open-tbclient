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
    public MessageV3 f34994a;

    /* renamed from: b  reason: collision with root package name */
    public String f34995b;

    /* renamed from: c  reason: collision with root package name */
    public int f34996c;

    /* renamed from: d  reason: collision with root package name */
    public int f34997d;

    public c(Parcel parcel) {
        this.f34994a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f34995b = parcel.readString();
        this.f34996c = parcel.readInt();
        this.f34997d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.f34994a = messageV3;
    }

    public MessageV3 a() {
        return this.f34994a;
    }

    public void a(int i2) {
        this.f34996c = i2;
    }

    public void a(String str) {
        this.f34995b = str;
    }

    public int b() {
        return this.f34996c;
    }

    public void b(int i2) {
        this.f34997d = i2;
    }

    public int c() {
        return this.f34997d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.f34994a + ", notificationPkg='" + this.f34995b + "', notificationId='" + this.f34996c + "', state='" + this.f34997d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f34994a, i2);
        parcel.writeString(this.f34995b);
        parcel.writeInt(this.f34996c);
        parcel.writeInt(this.f34997d);
    }
}
