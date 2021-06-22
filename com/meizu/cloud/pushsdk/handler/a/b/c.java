package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.meizu.cloud.pushsdk.handler.MessageV3;
/* loaded from: classes7.dex */
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
    public MessageV3 f38700a;

    /* renamed from: b  reason: collision with root package name */
    public String f38701b;

    /* renamed from: c  reason: collision with root package name */
    public int f38702c;

    /* renamed from: d  reason: collision with root package name */
    public int f38703d;

    public c(Parcel parcel) {
        this.f38700a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f38701b = parcel.readString();
        this.f38702c = parcel.readInt();
        this.f38703d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.f38700a = messageV3;
    }

    public MessageV3 a() {
        return this.f38700a;
    }

    public void a(int i2) {
        this.f38702c = i2;
    }

    public void a(String str) {
        this.f38701b = str;
    }

    public int b() {
        return this.f38702c;
    }

    public void b(int i2) {
        this.f38703d = i2;
    }

    public int c() {
        return this.f38703d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.f38700a + ", notificationPkg='" + this.f38701b + "', notificationId='" + this.f38702c + "', state='" + this.f38703d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f38700a, i2);
        parcel.writeString(this.f38701b);
        parcel.writeInt(this.f38702c);
        parcel.writeInt(this.f38703d);
    }
}
