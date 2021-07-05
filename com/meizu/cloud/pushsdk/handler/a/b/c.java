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
    public MessageV3 f40463a;

    /* renamed from: b  reason: collision with root package name */
    public String f40464b;

    /* renamed from: c  reason: collision with root package name */
    public int f40465c;

    /* renamed from: d  reason: collision with root package name */
    public int f40466d;

    public c(Parcel parcel) {
        this.f40463a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f40464b = parcel.readString();
        this.f40465c = parcel.readInt();
        this.f40466d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.f40463a = messageV3;
    }

    public MessageV3 a() {
        return this.f40463a;
    }

    public void a(int i2) {
        this.f40465c = i2;
    }

    public void a(String str) {
        this.f40464b = str;
    }

    public int b() {
        return this.f40465c;
    }

    public void b(int i2) {
        this.f40466d = i2;
    }

    public int c() {
        return this.f40466d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.f40463a + ", notificationPkg='" + this.f40464b + "', notificationId='" + this.f40465c + "', state='" + this.f40466d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f40463a, i2);
        parcel.writeString(this.f40464b);
        parcel.writeInt(this.f40465c);
        parcel.writeInt(this.f40466d);
    }
}
