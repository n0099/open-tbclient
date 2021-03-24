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
        public c[] newArray(int i) {
            return new c[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public MessageV3 f37805a;

    /* renamed from: b  reason: collision with root package name */
    public String f37806b;

    /* renamed from: c  reason: collision with root package name */
    public int f37807c;

    /* renamed from: d  reason: collision with root package name */
    public int f37808d;

    public c(Parcel parcel) {
        this.f37805a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f37806b = parcel.readString();
        this.f37807c = parcel.readInt();
        this.f37808d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.f37805a = messageV3;
    }

    public MessageV3 a() {
        return this.f37805a;
    }

    public void a(int i) {
        this.f37807c = i;
    }

    public void a(String str) {
        this.f37806b = str;
    }

    public int b() {
        return this.f37807c;
    }

    public void b(int i) {
        this.f37808d = i;
    }

    public int c() {
        return this.f37808d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.f37805a + ", notificationPkg='" + this.f37806b + "', notificationId='" + this.f37807c + "', state='" + this.f37808d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f37805a, i);
        parcel.writeString(this.f37806b);
        parcel.writeInt(this.f37807c);
        parcel.writeInt(this.f37808d);
    }
}
