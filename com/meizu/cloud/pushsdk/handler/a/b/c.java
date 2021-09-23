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
    public MessageV3 f75213a;

    /* renamed from: b  reason: collision with root package name */
    public String f75214b;

    /* renamed from: c  reason: collision with root package name */
    public int f75215c;

    /* renamed from: d  reason: collision with root package name */
    public int f75216d;

    public c(Parcel parcel) {
        this.f75213a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f75214b = parcel.readString();
        this.f75215c = parcel.readInt();
        this.f75216d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.f75213a = messageV3;
    }

    public MessageV3 a() {
        return this.f75213a;
    }

    public void a(int i2) {
        this.f75215c = i2;
    }

    public void a(String str) {
        this.f75214b = str;
    }

    public int b() {
        return this.f75215c;
    }

    public void b(int i2) {
        this.f75216d = i2;
    }

    public int c() {
        return this.f75216d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.f75213a + ", notificationPkg='" + this.f75214b + ExtendedMessageFormat.QUOTE + ", notificationId='" + this.f75215c + ExtendedMessageFormat.QUOTE + ", state='" + this.f75216d + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f75213a, i2);
        parcel.writeString(this.f75214b);
        parcel.writeInt(this.f75215c);
        parcel.writeInt(this.f75216d);
    }
}
