package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.meizu.cloud.pushsdk.handler.MessageV3;
/* loaded from: classes5.dex */
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
    private MessageV3 f11311a;

    /* renamed from: b  reason: collision with root package name */
    private String f11312b;
    private int c;
    private int d;

    protected c(Parcel parcel) {
        this.f11311a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.f11312b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.f11311a = messageV3;
    }

    public MessageV3 a() {
        return this.f11311a;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(String str) {
        this.f11312b = str;
    }

    public int b() {
        return this.c;
    }

    public void b(int i) {
        this.d = i;
    }

    public int c() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.f11311a + ", notificationPkg='" + this.f11312b + "', notificationId='" + this.c + "', state='" + this.d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f11311a, i);
        parcel.writeString(this.f11312b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }
}
