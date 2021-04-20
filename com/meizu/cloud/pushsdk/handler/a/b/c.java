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
    public MessageV3 f38095a;

    /* renamed from: b  reason: collision with root package name */
    public String f38096b;

    /* renamed from: c  reason: collision with root package name */
    public int f38097c;

    /* renamed from: d  reason: collision with root package name */
    public int f38098d;

    public c(Parcel parcel) {
        this.f38095a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f38096b = parcel.readString();
        this.f38097c = parcel.readInt();
        this.f38098d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.f38095a = messageV3;
    }

    public MessageV3 a() {
        return this.f38095a;
    }

    public void a(int i) {
        this.f38097c = i;
    }

    public void a(String str) {
        this.f38096b = str;
    }

    public int b() {
        return this.f38097c;
    }

    public void b(int i) {
        this.f38098d = i;
    }

    public int c() {
        return this.f38098d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.f38095a + ", notificationPkg='" + this.f38096b + "', notificationId='" + this.f38097c + "', state='" + this.f38098d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f38095a, i);
        parcel.writeString(this.f38096b);
        parcel.writeInt(this.f38097c);
        parcel.writeInt(this.f38098d);
    }
}
