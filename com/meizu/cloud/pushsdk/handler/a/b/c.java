package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes10.dex */
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
    public MessageV3 f74894a;

    /* renamed from: b  reason: collision with root package name */
    public String f74895b;

    /* renamed from: c  reason: collision with root package name */
    public int f74896c;

    /* renamed from: d  reason: collision with root package name */
    public int f74897d;

    public c(Parcel parcel) {
        this.f74894a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f74895b = parcel.readString();
        this.f74896c = parcel.readInt();
        this.f74897d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.f74894a = messageV3;
    }

    public MessageV3 a() {
        return this.f74894a;
    }

    public void a(int i2) {
        this.f74896c = i2;
    }

    public void a(String str) {
        this.f74895b = str;
    }

    public int b() {
        return this.f74896c;
    }

    public void b(int i2) {
        this.f74897d = i2;
    }

    public int c() {
        return this.f74897d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.f74894a + ", notificationPkg='" + this.f74895b + ExtendedMessageFormat.QUOTE + ", notificationId='" + this.f74896c + ExtendedMessageFormat.QUOTE + ", state='" + this.f74897d + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f74894a, i2);
        parcel.writeString(this.f74895b);
        parcel.writeInt(this.f74896c);
        parcel.writeInt(this.f74897d);
    }
}
