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
    public MessageV3 f38190a;

    /* renamed from: b  reason: collision with root package name */
    public String f38191b;

    /* renamed from: c  reason: collision with root package name */
    public int f38192c;

    /* renamed from: d  reason: collision with root package name */
    public int f38193d;

    public c(Parcel parcel) {
        this.f38190a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f38191b = parcel.readString();
        this.f38192c = parcel.readInt();
        this.f38193d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.f38190a = messageV3;
    }

    public MessageV3 a() {
        return this.f38190a;
    }

    public void a(int i) {
        this.f38192c = i;
    }

    public void a(String str) {
        this.f38191b = str;
    }

    public int b() {
        return this.f38192c;
    }

    public void b(int i) {
        this.f38193d = i;
    }

    public int c() {
        return this.f38193d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.f38190a + ", notificationPkg='" + this.f38191b + "', notificationId='" + this.f38192c + "', state='" + this.f38193d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f38190a, i);
        parcel.writeString(this.f38191b);
        parcel.writeInt(this.f38192c);
        parcel.writeInt(this.f38193d);
    }
}
