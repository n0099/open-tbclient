package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes8.dex */
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
    public String f57333b;

    /* renamed from: c  reason: collision with root package name */
    public int f57334c;

    /* renamed from: d  reason: collision with root package name */
    public int f57335d;

    public c(Parcel parcel) {
        this.a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f57333b = parcel.readString();
        this.f57334c = parcel.readInt();
        this.f57335d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.a = messageV3;
    }

    public MessageV3 a() {
        return this.a;
    }

    public void a(int i2) {
        this.f57334c = i2;
    }

    public void a(String str) {
        this.f57333b = str;
    }

    public int b() {
        return this.f57334c;
    }

    public void b(int i2) {
        this.f57335d = i2;
    }

    public int c() {
        return this.f57335d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.a + ", notificationPkg='" + this.f57333b + ExtendedMessageFormat.QUOTE + ", notificationId='" + this.f57334c + ExtendedMessageFormat.QUOTE + ", state='" + this.f57335d + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.a, i2);
        parcel.writeString(this.f57333b);
        parcel.writeInt(this.f57334c);
        parcel.writeInt(this.f57335d);
    }
}
