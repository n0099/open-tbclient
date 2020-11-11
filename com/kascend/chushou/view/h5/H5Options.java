package com.kascend.chushou.view.h5;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
/* loaded from: classes6.dex */
public class H5Options implements Parcelable {
    public static final Parcelable.Creator<H5Options> CREATOR = new Parcelable.Creator<H5Options>() { // from class: com.kascend.chushou.view.h5.H5Options.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: as */
        public H5Options createFromParcel(Parcel parcel) {
            return new H5Options(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: QN */
        public H5Options[] newArray(int i) {
            return new H5Options[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f4233a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    @ColorInt
    public int h;

    public H5Options() {
        this.f4233a = "";
        this.b = false;
        this.c = false;
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = -1;
    }

    protected H5Options(Parcel parcel) {
        this.f4233a = "";
        this.b = false;
        this.c = false;
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = -1;
        this.f4233a = parcel.readString();
        this.b = parcel.readByte() != 0;
        this.c = parcel.readByte() != 0;
        this.d = parcel.readByte() != 0;
        this.e = parcel.readByte() != 0;
        this.f = parcel.readByte() != 0;
        this.g = parcel.readByte() != 0;
        this.h = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4233a);
        parcel.writeByte((byte) (this.b ? 1 : 0));
        parcel.writeByte((byte) (this.c ? 1 : 0));
        parcel.writeByte((byte) (this.d ? 1 : 0));
        parcel.writeByte((byte) (this.e ? 1 : 0));
        parcel.writeByte((byte) (this.f ? 1 : 0));
        parcel.writeByte((byte) (this.g ? 1 : 0));
        parcel.writeInt(this.h);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
