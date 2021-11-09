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

    /* renamed from: a  reason: collision with root package name */
    public MessageV3 f67605a;

    /* renamed from: b  reason: collision with root package name */
    public String f67606b;

    /* renamed from: c  reason: collision with root package name */
    public int f67607c;

    /* renamed from: d  reason: collision with root package name */
    public int f67608d;

    public c(Parcel parcel) {
        this.f67605a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f67606b = parcel.readString();
        this.f67607c = parcel.readInt();
        this.f67608d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.f67605a = messageV3;
    }

    public MessageV3 a() {
        return this.f67605a;
    }

    public void a(int i2) {
        this.f67607c = i2;
    }

    public void a(String str) {
        this.f67606b = str;
    }

    public int b() {
        return this.f67607c;
    }

    public void b(int i2) {
        this.f67608d = i2;
    }

    public int c() {
        return this.f67608d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.f67605a + ", notificationPkg='" + this.f67606b + ExtendedMessageFormat.QUOTE + ", notificationId='" + this.f67607c + ExtendedMessageFormat.QUOTE + ", state='" + this.f67608d + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f67605a, i2);
        parcel.writeString(this.f67606b);
        parcel.writeInt(this.f67607c);
        parcel.writeInt(this.f67608d);
    }
}
