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
        public c[] newArray(int i) {
            return new c[i];
        }
    };
    public MessageV3 a;

    /* renamed from: b  reason: collision with root package name */
    public String f42158b;

    /* renamed from: c  reason: collision with root package name */
    public int f42159c;

    /* renamed from: d  reason: collision with root package name */
    public int f42160d;

    public c(Parcel parcel) {
        this.a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f42158b = parcel.readString();
        this.f42159c = parcel.readInt();
        this.f42160d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.a = messageV3;
    }

    public MessageV3 a() {
        return this.a;
    }

    public void a(int i) {
        this.f42159c = i;
    }

    public void a(String str) {
        this.f42158b = str;
    }

    public int b() {
        return this.f42159c;
    }

    public void b(int i) {
        this.f42160d = i;
    }

    public int c() {
        return this.f42160d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.a + ", notificationPkg='" + this.f42158b + "', notificationId='" + this.f42159c + "', state='" + this.f42160d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeString(this.f42158b);
        parcel.writeInt(this.f42159c);
        parcel.writeInt(this.f42160d);
    }
}
