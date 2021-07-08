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
    public MessageV3 f37477a;

    /* renamed from: b  reason: collision with root package name */
    public String f37478b;

    /* renamed from: c  reason: collision with root package name */
    public int f37479c;

    /* renamed from: d  reason: collision with root package name */
    public int f37480d;

    public c(Parcel parcel) {
        this.f37477a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f37478b = parcel.readString();
        this.f37479c = parcel.readInt();
        this.f37480d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.f37477a = messageV3;
    }

    public MessageV3 a() {
        return this.f37477a;
    }

    public void a(int i2) {
        this.f37479c = i2;
    }

    public void a(String str) {
        this.f37478b = str;
    }

    public int b() {
        return this.f37479c;
    }

    public void b(int i2) {
        this.f37480d = i2;
    }

    public int c() {
        return this.f37480d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.f37477a + ", notificationPkg='" + this.f37478b + "', notificationId='" + this.f37479c + "', state='" + this.f37480d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f37477a, i2);
        parcel.writeString(this.f37478b);
        parcel.writeInt(this.f37479c);
        parcel.writeInt(this.f37480d);
    }
}
