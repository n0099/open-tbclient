package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
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
    public String f61084b;

    /* renamed from: c  reason: collision with root package name */
    public int f61085c;

    /* renamed from: d  reason: collision with root package name */
    public int f61086d;

    public c(Parcel parcel) {
        this.a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f61084b = parcel.readString();
        this.f61085c = parcel.readInt();
        this.f61086d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.a = messageV3;
    }

    public MessageV3 a() {
        return this.a;
    }

    public void a(int i2) {
        this.f61085c = i2;
    }

    public void a(String str) {
        this.f61084b = str;
    }

    public int b() {
        return this.f61085c;
    }

    public void b(int i2) {
        this.f61086d = i2;
    }

    public int c() {
        return this.f61086d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.a + ", notificationPkg='" + this.f61084b + ExtendedMessageFormat.QUOTE + ", notificationId='" + this.f61085c + ExtendedMessageFormat.QUOTE + ", state='" + this.f61086d + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.a, i2);
        parcel.writeString(this.f61084b);
        parcel.writeInt(this.f61085c);
        parcel.writeInt(this.f61086d);
    }
}
