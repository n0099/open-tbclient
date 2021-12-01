package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes2.dex */
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
    public MessageV3 a;

    /* renamed from: b  reason: collision with root package name */
    public String f60503b;

    /* renamed from: c  reason: collision with root package name */
    public int f60504c;

    /* renamed from: d  reason: collision with root package name */
    public int f60505d;

    public c(Parcel parcel) {
        this.a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f60503b = parcel.readString();
        this.f60504c = parcel.readInt();
        this.f60505d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.a = messageV3;
    }

    public MessageV3 a() {
        return this.a;
    }

    public void a(int i2) {
        this.f60504c = i2;
    }

    public void a(String str) {
        this.f60503b = str;
    }

    public int b() {
        return this.f60504c;
    }

    public void b(int i2) {
        this.f60505d = i2;
    }

    public int c() {
        return this.f60505d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.a + ", notificationPkg='" + this.f60503b + ExtendedMessageFormat.QUOTE + ", notificationId='" + this.f60504c + ExtendedMessageFormat.QUOTE + ", state='" + this.f60505d + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.a, i2);
        parcel.writeString(this.f60503b);
        parcel.writeInt(this.f60504c);
        parcel.writeInt(this.f60505d);
    }
}
