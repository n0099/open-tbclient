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
    public MessageV3 f38602a;

    /* renamed from: b  reason: collision with root package name */
    public String f38603b;

    /* renamed from: c  reason: collision with root package name */
    public int f38604c;

    /* renamed from: d  reason: collision with root package name */
    public int f38605d;

    public c(Parcel parcel) {
        this.f38602a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f38603b = parcel.readString();
        this.f38604c = parcel.readInt();
        this.f38605d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.f38602a = messageV3;
    }

    public MessageV3 a() {
        return this.f38602a;
    }

    public void a(int i2) {
        this.f38604c = i2;
    }

    public void a(String str) {
        this.f38603b = str;
    }

    public int b() {
        return this.f38604c;
    }

    public void b(int i2) {
        this.f38605d = i2;
    }

    public int c() {
        return this.f38605d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.f38602a + ", notificationPkg='" + this.f38603b + "', notificationId='" + this.f38604c + "', state='" + this.f38605d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f38602a, i2);
        parcel.writeString(this.f38603b);
        parcel.writeInt(this.f38604c);
        parcel.writeInt(this.f38605d);
    }
}
