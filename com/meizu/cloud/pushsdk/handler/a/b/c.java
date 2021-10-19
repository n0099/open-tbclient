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
    public MessageV3 f75248a;

    /* renamed from: b  reason: collision with root package name */
    public String f75249b;

    /* renamed from: c  reason: collision with root package name */
    public int f75250c;

    /* renamed from: d  reason: collision with root package name */
    public int f75251d;

    public c(Parcel parcel) {
        this.f75248a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f75249b = parcel.readString();
        this.f75250c = parcel.readInt();
        this.f75251d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.f75248a = messageV3;
    }

    public MessageV3 a() {
        return this.f75248a;
    }

    public void a(int i2) {
        this.f75250c = i2;
    }

    public void a(String str) {
        this.f75249b = str;
    }

    public int b() {
        return this.f75250c;
    }

    public void b(int i2) {
        this.f75251d = i2;
    }

    public int c() {
        return this.f75251d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.f75248a + ", notificationPkg='" + this.f75249b + ExtendedMessageFormat.QUOTE + ", notificationId='" + this.f75250c + ExtendedMessageFormat.QUOTE + ", state='" + this.f75251d + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f75248a, i2);
        parcel.writeString(this.f75249b);
        parcel.writeInt(this.f75250c);
        parcel.writeInt(this.f75251d);
    }
}
